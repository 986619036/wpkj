package com.wpkj.domain;

import java.io.Serializable;

public class UserKey implements Serializable {
    private String host;

    private String user;

    private static final long serialVersionUID = 1L;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}