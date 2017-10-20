package com.sheng.security.dto;

/**
 * Created by shengxingyue on 2017/10/20.
 */
public class FileInfo {
    private String path;

    public FileInfo(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
