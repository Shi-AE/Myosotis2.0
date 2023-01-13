package com.guat.myosotis.json;

import java.util.List;

public class RegisterSearchJson {
    private boolean skip;
    private String url;
    private List<String> options;

    public RegisterSearchJson(boolean skip, String url, List<String> options) {
        this.skip = skip;
        this.url = url;
        this.options = options;
    }

    public RegisterSearchJson() {
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "RegisterSearchJson{" +
                "skip=" + skip +
                ", url='" + url + '\'' +
                ", options=" + options +
                '}';
    }
}
