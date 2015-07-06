package com.lance.persistence.model;

import javax.validation.constraints.NotNull;

public class User {
    @NotNull(message = "id不能为空")
    private Short id;

    private String name;

    private String password;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}