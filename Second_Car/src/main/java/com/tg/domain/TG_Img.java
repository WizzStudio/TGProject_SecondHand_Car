package com.tg.domain;

import java.util.ArrayList;
import java.util.List;

public class TG_Img {
    private int iId;    //图片的id
    private TG_Car tg_car;
    private String url;

    public int getiId() {
        return iId;
    }

    public void setiId(int iId) {
        this.iId = iId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public TG_Car getTg_car() {
        return tg_car;
    }

    public void setTg_car(TG_Car tg_car) {
        this.tg_car = tg_car;
    }
}
