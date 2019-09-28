package com.lantier.trackdemo.bean;

public class ItemBean {
    String name;
    int upload;
    int count;

    public ItemBean() {
    }

    public ItemBean(String name, int upload, int count) {
        this.name = name;
        this.upload = upload;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUpload() {
        return upload;
    }

    public void setUpload(int upload) {
        this.upload = upload;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
