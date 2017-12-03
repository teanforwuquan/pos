package com.example.administrator.bycjsaypos.modle;


import java.util.List;

/**
 * Created by Administrator on 2017/11/27.
 */

public class Users {

    /**
     * Success : true
     * Message :
     * StatusNo :
     * Data : {"total":1,"rows":[{"ProductId":51,"ProductName":"2017春夏季新款韩版女装纯棉中长款娃娃领衬衫长袖打底衫纯色潮","CategoryId":53,"OrigPrice":88,"Picture":"http://jijia.boyusj.cn:8004/upload/1000000000/20/20170602/2017060215532614027635.jpg   ","StockCount":100,"SalePrice":36,"BarCode":"1478521","BusinessId":1000000000,"DataStatus":0}]}
     * RecordCount : 0
     */

    private boolean Success;
    private String Message;
    private String StatusNo;
    private DataBean Data;
    private int RecordCount;

    public boolean isSuccess() {
        return Success;
    }

    public void setSuccess(boolean Success) {
        this.Success = Success;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public String getStatusNo() {
        return StatusNo;
    }

    public void setStatusNo(String StatusNo) {
        this.StatusNo = StatusNo;
    }

    public DataBean getData() {
        return Data;
    }

    public void setData(DataBean Data) {
        this.Data = Data;
    }

    public int getRecordCount() {
        return RecordCount;
    }

    public void setRecordCount(int RecordCount) {
        this.RecordCount = RecordCount;
    }

    public static class DataBean {
        /**
         * total : 1
         * rows : [{"ProductId":51,"ProductName":"2017春夏季新款韩版女装纯棉中长款娃娃领衬衫长袖打底衫纯色潮","CategoryId":53,"OrigPrice":88,"Picture":"http://jijia.boyusj.cn:8004/upload/1000000000/20/20170602/2017060215532614027635.jpg   ","StockCount":100,"SalePrice":36,"BarCode":"1478521","BusinessId":1000000000,"DataStatus":0}]
         */

        private int total;
        private List<RowsBean> rows;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<RowsBean> getRows() {
            return rows;
        }

        public void setRows(List<RowsBean> rows) {
            this.rows = rows;
        }

        public static class RowsBean {
            /**
             * ProductId : 51
             * ProductName : 2017春夏季新款韩版女装纯棉中长款娃娃领衬衫长袖打底衫纯色潮
             * CategoryId : 53
             * OrigPrice : 88
             * Picture : http://jijia.boyusj.cn:8004/upload/1000000000/20/20170602/2017060215532614027635.jpg
             * StockCount : 100
             * SalePrice : 36
             * BarCode : 1478521
             * BusinessId : 1000000000
             * DataStatus : 0
             */

            private int ProductId;
            private String ProductName;
            private int CategoryId;
            private int OrigPrice;
            private String Picture;
            private int StockCount;
            private int SalePrice;
            private String BarCode;
            private int BusinessId;
            private int DataStatus;

            public int getProductId() {
                return ProductId;
            }

            public void setProductId(int ProductId) {
                this.ProductId = ProductId;
            }

            public String getProductName() {
                return ProductName;
            }

            public void setProductName(String ProductName) {
                this.ProductName = ProductName;
            }

            public int getCategoryId() {
                return CategoryId;
            }

            public void setCategoryId(int CategoryId) {
                this.CategoryId = CategoryId;
            }

            public int getOrigPrice() {
                return OrigPrice;
            }

            public void setOrigPrice(int OrigPrice) {
                this.OrigPrice = OrigPrice;
            }

            public String getPicture() {
                return Picture;
            }

            public void setPicture(String Picture) {
                this.Picture = Picture;
            }

            public int getStockCount() {
                return StockCount;
            }

            public void setStockCount(int StockCount) {
                this.StockCount = StockCount;
            }

            public int getSalePrice() {
                return SalePrice;
            }

            public void setSalePrice(int SalePrice) {
                this.SalePrice = SalePrice;
            }

            public String getBarCode() {
                return BarCode;
            }

            public void setBarCode(String BarCode) {
                this.BarCode = BarCode;
            }

            public int getBusinessId() {
                return BusinessId;
            }

            public void setBusinessId(int BusinessId) {
                this.BusinessId = BusinessId;
            }

            public int getDataStatus() {
                return DataStatus;
            }

            public void setDataStatus(int DataStatus) {
                this.DataStatus = DataStatus;
            }
        }
    }
}
