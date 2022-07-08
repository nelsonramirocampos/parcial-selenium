package com.Model;

import lombok.Getter;

@Getter
public enum User {
    USUARIO("dudley.adams", "wkvtyuow5d5");

    private String userName;
    private String userPassword;

    private User(String userName, String userPassword){
        this.userName = userName;
        this.userPassword = userPassword;
    }

}
