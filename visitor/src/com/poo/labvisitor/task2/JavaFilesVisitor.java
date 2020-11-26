package com.poo.labvisitor.task2;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

import static java.nio.file.FileVisitResult.CONTINUE;

/**
 * Counter for java files of a given directory using java.nio API
 */
public class JavaFilesVisitor extends SimpleFileVisitor<Path> {

    private ArrayList<Path> javaFiles;

    public final ArrayList<Path> getJavaFiles() {
        return javaFiles;
    }

    // TODO - override the visitFile(Path file, BasicFileAttributes attr) method of the SimpleFileVisitor
    // add to javaFiles all the Java related files: the ones with .java and .class extensions


    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attr) throws IOException {
        if (attr.isSymbolicLink()) {
            System.out.format("Symbolic link: %s ", file);
        } else if (attr.isRegularFile()) {
            System.out.format("Regular file: %s ", file);
        } else {
            System.out.format("Other: %s ", file);
        }
        System.out.println("(" + attr.size() + "bytes)");
        return CONTINUE;
    }

    public static void main(String[] args) throws IOException {

        Path startingDir = Paths.get(".");
        JavaFilesVisitor filesVisitor = new JavaFilesVisitor();

        // TODO
        // use Files.walkFileTree
        // obtain the list of files and print some info about them (e.g. size and path)
        Files.walkFileTree(startingDir, filesVisitor);
    }
}
