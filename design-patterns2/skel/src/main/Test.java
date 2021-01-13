package main;

import commands.CommandType;

public class Test {
    public static void main(String[] args) {
        Client client = new Client();

        // Execute various tests
        //CommandType commandType = CommandType.CHANGE_COLOR;
        testDraw(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));

        testTextAndColor(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));

        testResize(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));

        testConnect(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));

        testAllCommands(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));

        testSimpleUndoRedo(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));

        testComplexUndoRedo(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));
    }

    private static void testDraw(Client client) {
        client.newDiagram();

        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");

        client.showDiagram();
    }

    private static void testTextAndColor(Client client) {
        testDraw(client);
        client.executeAction("change color", "0", "RED");
        client.executeAction("change color", "1", "BLUE");
        client.executeAction("draw rectangle");
        client.executeAction("change text", "0", "MyClass1");
        client.executeAction("change text", "5", "MyClass2");
        client.showDiagram();
    }

    private static void testConnect(Client client) {
        // TODO
        System.out.println("making connections");
        client.executeAction("connect", "1", "4");
        client.executeAction("connect", "0", "2");
        client.executeAction("connect", "4", "3");
        client.showDiagram();
    }

    private static void testResize(Client client) {
        // TODO
        System.out.println("doing resizes");
        client.executeAction("resize", "0", "50");
        client.executeAction("resize", "1", "75");
        client.showDiagram();
    }

    private static void testAllCommands(Client client) {
        // TODO
        System.out.println("testing all commands");
        client.newDiagram();
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("change color", "3", "BLACK");
        client.executeAction("resize", "0", "60");
        client.executeAction("change text", "0", "cerc dreptunghiular");
        client.executeAction("change text", "1", "dreptunghi circular");
        client.executeAction("connect", "0", "1");
        client.showDiagram();
    }

    private static void testSimpleUndoRedo(Client client) {
        client.newDiagram();

        client.executeAction("draw rectangle");
        client.executeAction("change color", "0", "ORANGE");
        client.showDiagram();

        client.executeAction("draw rectangle");
        client.showDiagram();

        client.undo();
        client.showDiagram();

        client.redo();
        client.showDiagram();
    }

    private static void testComplexUndoRedo(Client client) {
        // TODO
        client.newDiagram();
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.undo();
        client.undo();
        client.undo();
        client.showDiagram();

        client.executeAction("draw rectangle");
        client.executeAction("change text", "0", "cerc dreptunghiular");
        client.executeAction("change text", "0", "dreptunghi circular");
        client.executeAction("change text", "0", "ceva" );
        client.showDiagram();
        client.undo();
        client.showDiagram();
        client.redo();
        client.showDiagram();
        client.undo();
        client.undo();
        client.showDiagram();
        client.undo();
        client.showDiagram();
        client.undo();
        client.showDiagram(); // empty

        client.newDiagram();
        client.executeAction("draw rectangle");
        client.executeAction("resize", "0", "50");
        client.showDiagram();
        client.undo();
        client.showDiagram();
        client.redo();
        client.showDiagram();

        client.newDiagram();
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("connect", "0", "1");
        client.executeAction("connect", "0", "2");
        client.executeAction("connect", "2", "1");
        client.showDiagram();
        client.undo();
        client.showDiagram();
        client.undo();
        client.showDiagram();
        client.redo();
        client.showDiagram();
        client.undo();
        client.undo();
        client.showDiagram();
        client.executeAction("change color", "1", "BLACK");
        client.executeAction("change color", "2", "YELLOW");
        client.undo();
        client.showDiagram();
        client.redo();
        client.showDiagram();


    }
}
