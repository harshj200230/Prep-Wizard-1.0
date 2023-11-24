package com.example.minor_project;

public class pdfClass {
    private String name, url;
    private boolean isBookmarked;

    public pdfClass() {
    }

    public pdfClass(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public boolean isBookmarked() {
        return isBookmarked;
    }

    public void setBookmarked(boolean bookmarked) {
        isBookmarked = bookmarked;
    }
}
