package com.example.ctngus;


public abstract class QuanCo {
    private ToaDo mToado;
    private int mColorCo;
    //quan co di chuyen

    public abstract void Move(ToaDo toaDo);

    //contructor
    public QuanCo(ToaDo mToado, int mColorCo) {
        this.mToado = mToado;
        this.mColorCo = mColorCo;
    }

    public ToaDo getmToado() {
        return mToado;
    }
    public void setmToado(ToaDo mToado)
    {
        this.mToado=mToado;
    }

    public int getmColorCo() {
        return mColorCo;
    }

    public void setmColorCo(int mColorCo) {
        this.mColorCo = mColorCo;
    }
}
