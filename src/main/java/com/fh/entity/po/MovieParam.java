package com.fh.entity.po;

import com.fh.common.Page;

import java.io.Serializable;

public class MovieParam extends Page implements Serializable {

    private String name;
    private Integer count;
    private Integer home;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getHome() {
        return home;
    }

    public void setHome(Integer home) {
        this.home = home;
    }
}
