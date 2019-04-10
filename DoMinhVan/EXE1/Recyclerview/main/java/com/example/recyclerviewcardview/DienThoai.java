package com.example.recyclerviewcardview;

public class DienThoai {
    private int imgHinh;
    private String txtTen;
    private String txtGia;

    public DienThoai(int imgHinh, String txtTen, String txtGia) {
        this.imgHinh = imgHinh;
        this.txtTen = txtTen;
        this.txtGia = txtGia;
    }

    public int getImgHinh() {
        return imgHinh;
    }

    public void setImgHinh(int imgHinh) {
        this.imgHinh = imgHinh;
    }

    public String getTxtTen() {
        return txtTen;
    }

    public void setTxtTen(String txtTen) {
        this.txtTen = txtTen;
    }

    public String getTxtGia() {
        return txtGia;
    }

    public void setTxtGia(String txtGia) {
        this.txtGia = txtGia;
    }
}
