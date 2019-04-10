package com.example.congthucnauan.models;

public class QuanAn {
    private String imgHinhQuanAn;
    private String txtTenQuanAn;
    private String txtDiaChi;

    public QuanAn(String imgHinhQuanAn, String txtTenQuanAn,String txtDiaChi) {
        this.imgHinhQuanAn = imgHinhQuanAn;
        this.txtTenQuanAn = txtTenQuanAn;
        this.txtDiaChi =  txtDiaChi;
    }

    public String getTxtDiaChi() {
        return txtDiaChi;
    }

    public void setTxtDiaChi(String txtDiaChi) {
        this.txtDiaChi = txtDiaChi;
    }

    public String getImgHinhQuanAn() {
        return imgHinhQuanAn;
    }

    public void setImgHinhQuanAn(String imgHinhQuanAn) {
        this.imgHinhQuanAn = imgHinhQuanAn;
    }

    public String getTxtTenQuanAn() {
        return txtTenQuanAn;
    }

    public void setTxtTenQuanAn(String txtTenQuanAn) {
        this.txtTenQuanAn = txtTenQuanAn;
    }
}
