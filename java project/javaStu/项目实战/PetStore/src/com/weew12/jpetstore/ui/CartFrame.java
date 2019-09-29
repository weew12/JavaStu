package com.weew12.jpetstore.ui;

/**
 * @Classname CartFrame
 * @Description
 * @Date 2019-09-29
 * @Created by 枫weew12
 */
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import com.weew12.jpetstore.dao.OrderDao;
import com.weew12.jpetstore.dao.OrderDetailDao;
import com.weew12.jpetstore.dao.ProductDao;
import com.weew12.jpetstore.dao.mysql.OrderDaoImp;
import com.weew12.jpetstore.dao.mysql.OrderDetailDaoImp;
import com.weew12.jpetstore.dao.mysql.ProductDaoImp;
import com.weew12.jpetstore.domain.Order;
import com.weew12.jpetstore.domain.OrderDetail;
import com.weew12.jpetstore.domain.Product;

//商品购物车窗口
public class CartFrame extends MyFrame {

    private JTable table;

    // 购物车数据
    private Object[][] data = null;

    // 创建商品Dao对象
    private ProductDao dao = new ProductDaoImp();

    // 购物车，键是选择的商品Id，值是商品的数量
    private Map<String, Integer> cart;
    // 引用到上级Frame（ProductListFrame）
    private ProductListFrame productListFrame;

    public CartFrame(Map<String, Integer> cart, ProductListFrame productListFrame) {

        super("商品购物车", 1000, 700);
        this.cart = cart;
        this.productListFrame = productListFrame;

        JPanel topPanel = new JPanel();
        FlowLayout fl_topPanel = (FlowLayout) topPanel.getLayout();
        fl_topPanel.setVgap(10);
        fl_topPanel.setHgap(20);
        getContentPane().add(topPanel, BorderLayout.NORTH);

        JButton btnReturn = new JButton("返回商品列表");
        btnReturn.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        topPanel.add(btnReturn);

        JButton btuSubmit = new JButton("提交订单");
        topPanel.add(btuSubmit);
        btuSubmit.setFont(new Font("微软雅黑", Font.PLAIN, 15));

        JScrollPane scrollPane = new JScrollPane();
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        scrollPane.setViewportView(getTable());

        // 注册【提交订单】按钮的ActionEvent事件监听器
        btuSubmit.addActionListener(e -> {
            // 生成订单
            generateOrders();

            JLabel label = new JLabel("订单已经生成，等待付款。");
            label.setFont(new Font("微软雅黑", Font.PLAIN, 15));
            if (JOptionPane.showConfirmDialog(this, label, "信息", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                // TODO 付款
                System.exit(0);
            } else {
                System.exit(0);
            }
        });

        // 注册【返回商品列表】按钮的ActionEvent事件监听器
        btnReturn.addActionListener(e -> {
            // 更新购物车
            for (int i = 0; i < data.length; i++) {
                // 商品编号
                String productid = (String) data[i][0];
                // 数量
                Integer quantity = (Integer) data[i][3];
                cart.put(productid, quantity);
            }
            this.productListFrame.setVisible(true);
            setVisible(false);
        });
    }

    // 初始化左侧面板中的表格控件
    private JTable getTable() {

        // 准备表中数据
        data = new Object[cart.size()][5];
        Set<String> keys = this.cart.keySet();
        int indx = 0;
        for (String productid : keys) {
            Product p = dao.findById(productid);
            data[indx][0] = p.getProductid();// 商品编号
            data[indx][1] = p.getCname();// 商品名
            data[indx][2] = new Double(p.getUnitcost());// 商品单价
            data[indx][3] = new Integer(cart.get(productid));// 数量
            // 计算商品应付金额
            double amount = (double) data[indx][2] * (int) data[indx][3];
            data[indx][4] = new Double(amount);
            indx++;
        }

        // 创建表数据模型
        TableModel model = new CartTableModel(data);

        if (table == null) {
            // 创建表
            table = new JTable(model);
            // 设置表中内容字体
            table.setFont(new Font("微软雅黑", Font.PLAIN, 16));
            // 设置表列标题字体
            table.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 16));
            // 设置表行高
            table.setRowHeight(51);
            table.setRowSelectionAllowed(false);

        } else {
            table.setModel(model);
        }
        return table;
    }

    // 生成订单
    private void generateOrders() {

        OrderDao orderDao = new OrderDaoImp();
        OrderDetailDao orderDetailDao = new OrderDetailDaoImp();

        Order order = new Order();
        order.setUserid(MainApp.accout.getUserid());
        // 0待付款
        order.setStatus(0);
        // 订单Id是当前时间
        Date now = new Date();
        long orderId = now.getTime();
        order.setOrderid(orderId);
        order.setOrderdate(now);
        order.setAmount(getOrderTotalAmount());

        // 下订单时间是数据库自动生成不用设置
        // 创建订单
        orderDao.create(order);

        for (int i = 0; i < data.length; i++) {

            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderid(orderId);
            orderDetail.setProductid((String) data[i][0]);
            orderDetail.setQuantity((int) data[i][3]);
            orderDetail.setUnitcost((double) data[i][2]);
            // 创建订单详细
            orderDetailDao.create(orderDetail);
        }
    }

    // 计算订单应付总金额
    private double getOrderTotalAmount() {

        double totalAmount = 0.0;
        for (int i = 0; i < data.length; i++) {
            // 计算商品应付金额
            totalAmount += (Double) data[i][4];
        }
        return totalAmount;
    }
}

