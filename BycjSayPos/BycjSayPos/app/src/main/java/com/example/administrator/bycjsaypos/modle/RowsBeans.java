package com.example.administrator.bycjsaypos.modle;

/**
 * Created by Administrator on 2017/11/28.
 */
 public  class RowsBeans {
    private String ProductId;
    private String ProductName;
    private String CategoryId;
    private String OrigPrice;
    private String Picture;
    private String StockCount;
    private String SalePrice;
    private String BarCode;
    private String BusinessId;
    private String DataStatus;

    public RowsBeans() {
        super();
    }

    public RowsBeans(String productId, String productName, String categoryId, String origPrice, String picture, String stockCount, String salePrice, String barCode, String businessId, String dataStatus) {
        ProductId = productId;
        ProductName = productName;
        CategoryId = categoryId;
        OrigPrice = origPrice;
        Picture = picture;
        StockCount = stockCount;
        SalePrice = salePrice;
        BarCode = barCode;
        BusinessId = businessId;
        DataStatus = dataStatus;
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(String categoryId) {
        CategoryId = categoryId;
    }

    public String getOrigPrice() {
        return OrigPrice;
    }

    public void setOrigPrice(String origPrice) {
        OrigPrice = origPrice;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        Picture = picture;
    }

    public String getStockCount() {
        return StockCount;
    }

    public void setStockCount(String stockCount) {
        StockCount = stockCount;
    }

    public String getSalePrice() {
        return SalePrice;
    }

    public void setSalePrice(String salePrice) {
        SalePrice = salePrice;
    }

    public String getBarCode() {
        return BarCode;
    }

    public void setBarCode(String barCode) {
        BarCode = barCode;
    }

    public String getBusinessId(int i) {
        return BusinessId;
    }

    public void setBusinessId(String businessId) {
        BusinessId = businessId;
    }

    public String getDataStatus() {
        return DataStatus;
    }

    public void setDataStatus(String dataStatus) {
        DataStatus = dataStatus;
    }

    @Override
    public String toString() {
        return "RowsBeans{" +
                "ProductId='" + ProductId + '\'' +
                ", ProductName='" + ProductName + '\'' +
                ", CategoryId='" + CategoryId + '\'' +
                ", OrigPrice='" + OrigPrice + '\'' +
                ", Picture='" + Picture + '\'' +
                ", StockCount='" + StockCount + '\'' +
                ", SalePrice='" + SalePrice + '\'' +
                ", BarCode='" + BarCode + '\'' +
                ", BusinessId='" + BusinessId + '\'' +
                ", DataStatus='" + DataStatus + '\'' +
                '}';
    }


}
