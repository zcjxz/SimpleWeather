package com.guowei.draw.simpleweather.bean;


import java.util.List;

public class YoudaoBean {

    /**
     * translation : ["The good weather"]
     * query : 好天气
     * errorCode : 0
     */

    private String query;
    private int errorCode;
    private List<String> translation;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public List<String> getTranslation() {
        return translation;
    }

    public void setTranslation(List<String> translation) {
        this.translation = translation;
    }
}
