package com.example.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhougaojun
 */

@Getter
@AllArgsConstructor
public enum GTClientType {
    /**
     * web:电脑上的浏览器；h5:手机上的浏览器，包括移动应用内完全内置的web_view；native：通过原生SDK植入APP应用的方式
     */
    WEB("web"),
    H5("h5"),
    NATIVE("native");
    private String value;
}
