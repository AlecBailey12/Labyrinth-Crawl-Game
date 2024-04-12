package command;

import builder.Labyrinth;

public class Player {
    private int x, y;
    private Labyrinth labyrinth;

    public Player(Labyrinth labyrinth, int startX, int startY) {
        this.labyrinth = labyrinth;
        this.x = startX;
        this.y = startY;
    }

    // Maybe combine these
    public void setPlayerX(int x) {
        this.x = x;
    }

    public void setPlayerY(int y) {
        this.y = y;
    }
    
    public int getPlayerX() {
        return x;
    }

    public int getPlayerY() {
        return y;
    }

    public Labyrinth getLabyrinth() {
        return labyrinth;
    }
}
