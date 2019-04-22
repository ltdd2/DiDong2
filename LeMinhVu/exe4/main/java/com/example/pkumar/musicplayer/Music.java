package com.example.pkumar.musicplayer;

public class Music {
    private String name;
    private String singer;


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    private int image;
    private int song;

    public Music(String name, String singer, int song,int image) {
        this.name = name;
        this.singer = singer;
        this.song = song;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public int getSong() {
        return song;
    }

    public void setSong(int song) {
        this.song = song;
    }
}
