package commands;

import diagram.DiagramCanvas;

public class ChangeText implements DrawCommand {
    private DiagramCanvas diagramCanvas;
    private String text;
    private int position;
    private String exText;

    public ChangeText(DiagramCanvas diagramCanvas, int position, String text) {
        this.diagramCanvas = diagramCanvas;
        this.text = text;
        this.position = position;
    }

    @Override
    public void execute() {
        changeText(this.position, this.text);
    }

    private void changeText(int position, String text) {
        exText = diagramCanvas.getComponent(position).getText();
        diagramCanvas.getComponent(position).setText(text);
    }

    @Override
    public void undo() {
        changeText(position, exText);
    }

    @Override
    public String toString() {
        return "ChangeText{" +
                "diagramCanvas=" + diagramCanvas +
                ", text='" + text + '\'' +
                ", position=" + position +
                '}';
    }
}
