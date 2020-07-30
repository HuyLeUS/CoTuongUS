package com.example.ctngus.QuanCoTuong;


import com.example.ctngus.ToaDo;

public abstract class QuanCo {
    private Phe phe;
    //quan co di chuyen


    public Phe getPhe() {
        return phe;
    }

    //contructor
    public QuanCo(Phe phe) {
        this.phe = phe;
    }

}
