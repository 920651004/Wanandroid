package com.duan.wanandroid.ui.tree;

import java.util.List;

/**
 * Created by Admin on 2020/3/26
 */
public class DataBean {
    public String Name;
    public List<DetialBean> detialBeans;

    public List<DetialBean> getDetialBeans() {
        return detialBeans;
    }

    public void setDetialBeans(List<DetialBean> detialBeans) {
        this.detialBeans = detialBeans;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


    public static  class DetialBean{
        public String Shlf;
        public String BitchNo;
        public List<ChildData> childData;

        public List<ChildData> getChildData() {
            return childData;
        }

        public void setChildData(List<ChildData> childData) {
            this.childData = childData;
        }

        public String getShlf() {
            return Shlf;
        }

        public void setShlf(String shlf) {
            Shlf = shlf;
        }

        public String getBitchNo() {
            return BitchNo;
        }

        public void setBitchNo(String bitchNo) {
            BitchNo = bitchNo;
        }
    }
    public static class ChildData{
        public String Product;
        public String ProductColor;

        public String getProduct() {
            return Product;
        }

        public void setProduct(String product) {
            Product = product;
        }

        public String getProductColor() {
            return ProductColor;
        }

        public void setProductColor(String productColor) {
            ProductColor = productColor;
        }
    }
}
