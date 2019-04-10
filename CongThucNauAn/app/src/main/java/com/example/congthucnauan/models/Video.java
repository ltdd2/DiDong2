package com.example.congthucnauan.models;

public class Video {
    private String tenVideo;
    private String imgHinhVideo;
    private String idVideo;

    public Video(String tenVideo, String imgHinhVideo, String idVideo) {
        this.tenVideo = tenVideo;
        this.imgHinhVideo = imgHinhVideo;
        this.idVideo = idVideo;
    }

    public String getTenVideo() {
        return tenVideo;
    }

    public void setTenVideo(String tenVideo) {
        this.tenVideo = tenVideo;
    }

    public String getImgHinhVideo() {
        return imgHinhVideo;
    }

    public void setImgHinhVideo(String imgHinhVideo) {
        this.imgHinhVideo = imgHinhVideo;
    }

    public String getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(String idVideo) {
        this.idVideo = idVideo;
    }
}
