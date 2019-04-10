package com.example.congthucnauan.models;

public class MonAn {
    private String imgHinhMonAn;
    private String txtTenMonAn;
    private String txtMoTaMonAn;

    public MonAn(String imgHinhMonAn, String txtTenMonAn, String txtMoTaMonAn) {

        this.imgHinhMonAn = imgHinhMonAn;
        this.txtTenMonAn = txtTenMonAn;
        this.txtMoTaMonAn = txtMoTaMonAn;
    }
    public String getImgHinhMonAn() {
        return imgHinhMonAn;
    }

    public void setImgHinhMonAn(String imgHinhMonAn) {
        this.imgHinhMonAn = imgHinhMonAn;
    }

    public String getTxtTenMonAn() {
        return txtTenMonAn;
    }

    public void setTxtTenMonAn(String txtTenMonAn) {
        this.txtTenMonAn = txtTenMonAn;
    }

    public String getTxtMoTaMonAn() {
        return txtMoTaMonAn;
    }

    public void setTxtMoTaMonAn(String txtMoTaMonAn) {
        this.txtMoTaMonAn = txtMoTaMonAn;
    }
}
