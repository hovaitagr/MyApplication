package net.hovait.barared.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by hovait4 on 12/11/2015.
 */
public class ProductList {
    private int totalProducts;

    @SerializedName("products")
    List<Product> products;

    public int getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(int totalProducts) {
        this.totalProducts = totalProducts;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
