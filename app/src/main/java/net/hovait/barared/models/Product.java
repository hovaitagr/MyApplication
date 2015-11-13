package net.hovait.barared.models;

/**
 * Created by hovait4 on 12/11/2015.
 */
public class Product {

    private String _id;
    private String prodSKU;
    private float prodPrice;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getProdSKU() {
        return prodSKU;
    }

    public void setProdSKU(String prodSKU) {
        this.prodSKU = prodSKU;
    }

    public float getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(float prodPrice) {
        this.prodPrice = prodPrice;
    }

}
