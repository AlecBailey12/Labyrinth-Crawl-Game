package observer;

import builder.Labyrinth;


public class VisibilityManager implements Observer {
    private Labyrinth labyrinth;

    public VisibilityManager(Labyrinth labyrinth) {
        this.labyrinth = labyrinth;
    }

    @Override
    public void update(int x, int y) {
        if (labyrinth.getCorridorAt(x + 1, y) != null) {
            labyrinth.getCorridorAt(x + 1, y).setVisible(true);
            if (labyrinth.getChamberAt(x + 2, y) != null) {
                labyrinth.getChamberAt(x + 2, y).setVisible(true);
            }
        }
        if (labyrinth.getCorridorAt(x, y + 1) != null) {
            labyrinth.getCorridorAt(x, y + 1).setVisible(true);
            if (labyrinth.getChamberAt(x, y + 2) != null) {
                labyrinth.getChamberAt(x, y + 2).setVisible(true);
            }
        }
        if (labyrinth.getCorridorAt(x - 1, y) != null) {
            labyrinth.getCorridorAt(x - 1, y).setVisible(true);
            if (labyrinth.getChamberAt(x - 2, y) != null) {
                labyrinth.getChamberAt(x - 2, y).setVisible(true);
            }
        }
        if (labyrinth.getCorridorAt(x, y - 1) != null) {
            labyrinth.getCorridorAt(x, y - 1).setVisible(true);
            if (labyrinth.getChamberAt(x, y - 2) != null) {
                labyrinth.getChamberAt(x, y - 2).setVisible(true);
            }
        }
    }
}