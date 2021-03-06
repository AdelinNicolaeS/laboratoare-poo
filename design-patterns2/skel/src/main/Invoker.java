package main;

import commands.*;

import java.util.LinkedList;

/**
 * The layer between the client and the commands that need to be executed on the receivers (DiagramCanvas and DiagramComponent).
 * <br>
 * It is independent of the subtypes of commands, it just receives a command, runs it and implements a redo/undo mechanism.
 */
public class Invoker {

    /**
     * Clear up all the used resources, start fresh :D
     */
    private LinkedList<DrawCommand> undos = new LinkedList<>();
    private LinkedList<DrawCommand> redos = new LinkedList<>();

    public LinkedList<DrawCommand> getUndos() {
        return undos;
    }

    public void setUndos(LinkedList<DrawCommand> undos) {
        this.undos = undos;
    }

    public void restart() {
      // TODO
        undos.clear();
        undos = new LinkedList<>();
        redos.clear();
        redos = new LinkedList<>();
    }

    /**
     * Executes a given command
     * @param command
     */
    public void execute(DrawCommand command) {
        command.execute();
        undos.push(command);
        redos.clear();
    }

    /**
     * Undo the latest command
     */
    public void undo() {
        // TODO
        // Hint: use data structures to keep track of commands
        // Do not use the java.util.Stack, its implementation is based on vector which is inefficient and deprecated.
        // Use a class that implements the Deque interface, e.g. LinkedList https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Deque.html
        DrawCommand command = undos.pop();
        command.undo();
        redos.push(command);
    }

    /**
     * Redo command previously undone. Cannot perform a redo after an execute, only after at least one undo.
     */
    public void redo() {
        // TODO
        DrawCommand command = redos.pop();
        command.execute();
        undos.push(command);
    }
}
