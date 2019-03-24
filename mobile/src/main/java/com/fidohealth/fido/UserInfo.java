package com.fidohealth.fido;

public class UserInfo {
    public String name;
    public String condition;
    public double weight, height;

    public UserInfo() {
    }

    public UserInfo(String name, String condition, double weight, double height) {
        this.name = name;
        this.condition = condition;
        this.weight = weight;
        this.height = height;
    }
}
