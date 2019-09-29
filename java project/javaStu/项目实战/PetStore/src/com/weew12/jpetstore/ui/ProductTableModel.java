package com.weew12.jpetstore.ui;

/**
 * @Classname ProductTableModel
 * @Description
 * @Date 2019-09-29
 * @Created by 枫weew12
 */
import java.util.List;
import javax.swing.table.AbstractTableModel;
import com.weew12.jpetstore.domain.Product;

//商品列表表格模型
public class ProductTableModel extends AbstractTableModel {

    // 表格列名columnNames
    private String[] columnNames = { "商品编号", "商品类别", "商品中文名", "商品英文名" };

    // 表格中的数据内容保存在List集合中
    private List<Product> data = null;

    public ProductTableModel(List<Product> data) {
        this.data = data;
    }

    // 返回列数
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    // 返回行数
    @Override
    public int getRowCount() {
        return data.size();
    }

    // 获得某行某列的数据，而数据保存在对象数组data中
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        // 每一行就是一个Product商品对象
        Product p = data.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return p.getProductid(); // 第一列商品编号
            case 1:
                return p.getCategory(); // 第二列商品类别
            case 2:
                return p.getCname(); // 商品中文名
            default:
                return p.getEname(); // 商品英文名
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }
}
