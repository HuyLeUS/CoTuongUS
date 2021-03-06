package com.example.ctngus.QuanCoTuong;


import com.example.ctngus.TroChoi.BanCo;
import com.example.ctngus.TroChoi.ToaDo;

import java.util.List;

public abstract class QuanCo {
    private Phe phe;
    //quan co di chuyen

    abstract public List<ToaDo> duDoanNuocDi(BanCo banCo, ToaDo toaDo);

    public Phe getPhe() {
        return phe;
    }

    //contructor
    public QuanCo(Phe phe) {
        this.phe = phe;
    }

}
