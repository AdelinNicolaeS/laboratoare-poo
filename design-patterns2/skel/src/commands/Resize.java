package commands;

import diagram.DiagramCanvas;

public class Resize implements DrawCommand{
    DiagramCanvas diagramCanvas;
    int position;
    int percent;

    public Resize(DiagramCanvas diagramCanvas, int position, int percent) {
        this.diagramCanvas = diagramCanvas;
        this.position = position;
        this.percent = percent;
    }

    @Override
    public void execute() {
        changeSizes(this.position, this.percent);
    }

    @Override
    public void undo() {
        diagramCanvas.getComponent(position).setHeight(100 * diagramCanvas.getComponent(position).getHeight() / percent);
        diagramCanvas.getComponent(position).setWeight(100 * diagramCanvas.getComponent(position).getWeight() / percent);
    }

    private void changeSizes(int position, int percent) {
        diagramCanvas.getComponent(position).setHeight(percent * diagramCanvas.getComponent(position).getHeight() / 100);
        diagramCanvas.getComponent(position).setWeight(percent * diagramCanvas.getComponent(position).getWeight() / 100);
    }

    @Override
    public String toString() {
        return "Resize{" +
                "diagramCanvas=" + diagramCanvas +
                ", position=" + position +
                ", percent=" + percent +
                '}';
    }
}
