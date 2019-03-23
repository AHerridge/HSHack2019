package com.fidohealth.fido;

import java.util.ArrayList;
import java.util.List;

public class User {
    public final String name;
    public final String email;
    public final String passwordHash;
    public final String condition;
    public final List<DataSample> data;

    public User(String name, String email, String passwordHash, String condition) {
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
        this.condition = condition;
        this.data = new ArrayList<>();
    }
}
