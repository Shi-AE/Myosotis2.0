package com.guat.myosotis.json;

import java.util.HashSet;

public class RegisterFormJson {
    private boolean skip;
    private HashSet<String> error;
    private String url;

    public RegisterFormJson(boolean skip, HashSet<String> error, String url) {
        this.skip = skip;
        this.error = error;
        this.url = url;
    }

    public RegisterFormJson() {
        error = new HashSet<>();
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public HashSet<String> getError() {
        return error;
    }

    public void addError(String error) {
        this.error.add(error);
    }

    public void setError(HashSet<String> error) {
        this.error = error;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "RegisterFormJson{" +
                "skip=" + skip +
                ", error=" + error +
                ", url='" + url + '\'' +
                '}';
    }
}
