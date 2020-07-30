package com.example.ctngus;

import com.example.ctngus.QuanCoTuong.QuanCo;

class OCo {
    protected ToaDo toaDo;
    protected QuanCo quanCo = null;

    public OCo(ToaDo toaDo, QuanCo quanCo) {
        this.toaDo = toaDo;
        this.quanCo = quanCo;
    }

    public ToaDo getToaDo() {
        return toaDo;
    }

    public QuanCo getQuanCo() {
        return quanCo;
    }

    public void setToaDo(ToaDo toaDo) {
        this.toaDo = toaDo;
    }

    public void setQuanCo(QuanCo quanCo) {
        this.quanCo = quanCo;
    }
}
