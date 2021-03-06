package com.poo.labvisitor.task1.document;

public interface DocumentVisitor {
    void visit(BoldTextSegment boldTextSegment);
    void visit(ItalicTextSegment italicTextSegment);
    void visit(PlainTextSegment plainTextSegment);
    void visit(UrlSegment urlSegment);
    StringBuilder getDocument();

}
