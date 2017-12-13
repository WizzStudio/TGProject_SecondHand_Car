package com.tg.javabean;

import com.tg.domain.TG_Car;

import java.util.List;

public class TG_CarAdapter {

    private TG_Car tg_car;
    private List<String> urls;

    public TG_Car getTg_car() {
        return tg_car;
    }

    public void setTg_car(TG_Car tg_car) {
        this.tg_car = tg_car;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }
}
