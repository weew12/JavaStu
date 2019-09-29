package com.weew12.jpetstore.domain;

/**
 * @Classname Product
 * @Description
 *              商品
 * @Date 2019-09-29
 * @Created by 枫weew12
 */
public class Product {

    private String productid; // 商品Id
    private String category; // 商品类别
    private String cname; // 商品中文名
    private String ename; // 商品英文名
    private String image; // 商品图片
    private String descn; // 商品描述
    private double listprice; // 商品市场价
    private double unitcost; // 商品单价

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescn() {
        return descn;
    }

    public void setDescn(String descn) {
        this.descn = descn;
    }

    public double getListprice() {
        return listprice;
    }

    public void setListprice(double listprice) {
        this.listprice = listprice;
    }

    public double getUnitcost() {
        return unitcost;
    }

    public void setUnitcost(double unitcost) {
        this.unitcost = unitcost;
    }
}
