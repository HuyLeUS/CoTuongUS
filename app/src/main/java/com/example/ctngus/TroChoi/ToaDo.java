package com.example.ctngus.TroChoi;

import com.example.ctngus.QuanCoTuong.QuanCo;

public class ToaDo {
    private Integer X;
    private Integer Y;
    private QuanCo quanCo = null;
    private boolean laDiemGoiY = false;

    public ToaDo(Integer x, Integer y, QuanCo quanCo) {
        X = x;
        Y = y;
        this.quanCo = quanCo;
    }

    public void setLaDiemGoiY(boolean laDiemGoiY) {
        this.laDiemGoiY = laDiemGoiY;
    }

    public boolean isLaDiemGoiY() {
        return laDiemGoiY;
    }

    public QuanCo getQuanCo() {
        return quanCo;
    }

    public void setQuanCo(QuanCo quanCo) {
        this.quanCo = quanCo;
    }

    public Integer getX() {
        return X;
    }

    public Integer getY() {
        return Y;
    }

    public void setX(Integer x) {
        this.X = x;
    }

    public void setY(Integer y) {
        this.Y = y;
    }
}
