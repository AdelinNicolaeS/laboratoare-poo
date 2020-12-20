package commands;

import diagram.DiagramCanvas;

public class ChangeColor implements DrawCommand {
    private DiagramCanvas diagramCanvas;
    private int position;
    private String color;
    private String exColor;

    public ChangeColor(DiagramCanvas diagramCanvas, int position, String color) {
        this.diagramCanvas = diagramCanvas;
        this.position = position;
        this.color = color;
    }

    @Override
    public void execute() {
        changeColor(this.position, this.color);
    }

    private void changeColor(int position, String color) {
        exColor = diagramCanvas.getComponent(position).getColor();
        diagramCanvas.getComponent(position).setColor(color);
    }

    @Override
    public void undo() {
        changeColor(position, exColor);
    }

    @Override
    public String toString() {
        return "ChangeColor{" +
                "diagramCanvas=" + diagramCanvas +
                ", color='" + color + '\'' +
                ", position=" + position +
                '}';
    }
}
