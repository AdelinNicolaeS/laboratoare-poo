package commands;

import diagram.DiagramCanvas;
import diagram.DiagramComponent;

public class DrawRectangle implements DrawCommand {
    private DiagramCanvas diagramCanvas;
    @Override
    public void execute() {
        DiagramComponent diagramComponent = new DiagramComponent();
        diagramCanvas.addComponent(diagramComponent);
    }

    public DrawRectangle(DiagramCanvas diagramCanvas) {
        this.diagramCanvas = diagramCanvas;
    }

    @Override
    public void undo() {
        diagramCanvas.getComponents().remove(diagramCanvas.getComponents().size() - 1);
    }

    @Override
    public String toString() {
        return "DrawRectangle{" +
                "diagramCanvas=" + diagramCanvas +
                '}';
    }
}
