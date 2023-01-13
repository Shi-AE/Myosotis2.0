package com.guat.myosotis.json;

public class EntryJson {
    private boolean skip;
    private String error;
    private String url;

    public EntryJson(boolean skip, String error, String url) {
        this.skip = skip;
        this.error = error;
        this.url = url;
    }

    public EntryJson() {
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
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
        return "EntryJson{" +
                "skip=" + skip +
                ", error='" + error + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
