package com.Config;

import lombok.Getter;

@Getter
public enum Parametrs {
    FOLDER_REPORTS("target/reports/"),
    FOLDER_SCREENSHOTS("screenshots/");

    private String parameter;

    private Parametrs(String path){
        parameter = path;
    }
}
