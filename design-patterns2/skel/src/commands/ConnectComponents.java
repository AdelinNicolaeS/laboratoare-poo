package commands;

import diagram.DiagramCanvas;

public class ConnectComponents implements DrawCommand {
    private DiagramCanvas diagramCanvas;
    private int position1, position2;

    public ConnectComponents(DiagramCanvas diagramCanvas, int position1, int position2) {
        this.diagramCanvas = diagramCanvas;
        this.position1 = position1;
        this.position2 = position2;
    }

    @Override
    public void execute() {
        connectComponents(this.position1, this.position2);
    }

    private void connectComponents(int position1, int position2) {
        diagramCanvas.getComponent(position1).connectTo(diagramCanvas.getComponent(position2).getText());
        diagramCanvas.getComponent(position2).connectTo(diagramCanvas.getComponent(position1).getText());
    }

    @Override
    public void undo() {
        diagramCanvas.getComponent(position1).getConnectedComponents().remove(diagramCanvas.getComponent(position1).getConnectedComponents().size() - 1);
        diagramCanvas.getComponent(position2).getConnectedComponents().remove(diagramCanvas.getComponent(position2).getConnectedComponents().size() - 1);
    }

    @Override
    public String toString() {
        return "ConnectComponents{" +
                "diagramCanvas=" + diagramCanvas +
                ", position1=" + position1 +
                ", position2=" + position2 +
                '}';
    }
}
