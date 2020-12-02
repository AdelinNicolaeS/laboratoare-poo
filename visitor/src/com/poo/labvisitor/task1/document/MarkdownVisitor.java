package com.poo.labvisitor.task1.document;

public class MarkdownVisitor implements DocumentVisitor {
    StringBuilder document = new StringBuilder();
    @Override
    public void visit(BoldTextSegment boldTextSegment) {
        document.append("**");
        document.append(boldTextSegment.getContent());
        document.append("**");
    }

    @Override
    public void visit(ItalicTextSegment italicTextSegment) {
        document.append("*");
        document.append(italicTextSegment.getContent());
        document.append("*");
    }

    @Override
    public void visit(PlainTextSegment plainTextSegment) {
        document.append(plainTextSegment.getContent());
    }

    @Override
    public void visit(UrlSegment urlSegment) {
        document.append("[");
        document.append(urlSegment.getContent());
        document.append("](");
        document.append(urlSegment.getUrl());
        document.append(")");
    }

    @Override
    public StringBuilder getDocument() {
        return document;
    }

}
