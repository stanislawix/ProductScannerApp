package com.sj.skanercsv;

import java.util.Objects;

public class FullBlueprint {

    private String name;
    private String barcode;
    private String imgUri;

    public FullBlueprint(String name, String barcode, String imgUri) {
        this.name = name;
        this.barcode = barcode;
        this.imgUri = imgUri;
    }

    public FullBlueprint(String name) {
        this.name = name;
        this.barcode = "BRAK";
        this.imgUri = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getImgUri() {
        return imgUri;
    }

    public void setImgUri(String imgUri) {
        this.imgUri = imgUri;
    }

    @Override
    public String toString() {
        return String.format("{};{};{}\r\n", name, barcode, imgUri);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FullBlueprint that = (FullBlueprint) o;
        return name.equals(that.name) && Objects.equals(barcode, that.barcode) && Objects.equals(imgUri, that.imgUri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, barcode, imgUri);
    }
}
