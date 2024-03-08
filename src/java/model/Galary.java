/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PC
 */
public class Galary {

    private int galaryId;
    private Product product;
    private String thumbnail;

    public Galary() {
    }

    public Galary(int galaryId, Product product, String thumbnail) {
        this.galaryId = galaryId;
        this.product = product;
        this.thumbnail = thumbnail;
    }

    public int getGalaryId() {
        return galaryId;
    }

    public void setGalaryId(int galaryId) {
        this.galaryId = galaryId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "Galary{" + "galaryId=" + galaryId + ", product=" + product + ", thumbnail=" + thumbnail + '}';
    }
}
