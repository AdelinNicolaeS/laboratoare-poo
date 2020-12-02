package com.poo.labvisitor.task1.document;

public class UrlSegment extends TextSegment {
    private String url;
    private String description;
    UrlSegment(String content) {
        super(content);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void accept(DocumentVisitor documentVisitor) {
        documentVisitor.visit(this);
    }

    public UrlSegment(String content, String url) {
        super(content);
        this.url = url;
    }

}
