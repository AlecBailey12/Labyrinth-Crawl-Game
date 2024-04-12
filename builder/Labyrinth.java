package builder;

import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

import observer.Observer;

public class Labyrinth {
    private final LabyrinthModules[][] grid;
    private int playerX, playerY;

    private Labyrinth(Builder builder) {
        this.grid = builder.grid;
        this.playerX = 4;
        this.playerY = 4;
    }
    
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyMove(int x, int y) {
        playerX = x;
        playerY = y;
        for (Observer observer : observers) {
            observer.update(x, y);
        }
    }

    public interface LabyrinthModules {
        void setVisible(boolean visible);
        boolean isVisible();
    }

    public static class Chamber implements LabyrinthModules {
        private boolean visible = false;
        private boolean exit = false;

        public Chamber(boolean exit) {
            this.exit = exit;
        }

        @Override
        public void setVisible(boolean visible) {
            this.visible = visible;
        }

        @Override
        public boolean isVisible() {
            return visible;
        }
            
        public boolean isExit() {
            return exit;
        }
    }

    public static class Corridor implements LabyrinthModules {
        private boolean visible = false;

        @Override
        public void setVisible(boolean visible) {
            this.visible = visible;
        }

        @Override
        public boolean isVisible() {
            return visible;
        }
    }

    public boolean canMove(int x, int y) {
        if (x > 8 || x < 0 || y > 8 || y < 0) {
            dramaticPrint("There's no corridor by which to travel in that direction.", 60, 500);
            return false;
        } else if (grid[y][x] instanceof Corridor == false) {
            dramaticPrint("There's no corridor by which to travel in that direction.", 60, 500);
        }
        return grid[y][x] instanceof Corridor;
    }

    public Chamber getCurrentChamber() {
        if (grid[playerY][playerX] instanceof Chamber) {
            return (Chamber) grid[playerY][playerX];
        }
        return null;
    }

    public Chamber getChamberAt(int x, int y) {
        if (x > 8 || x < 0 || y > 8 || y < 0) {
            return null;
        } else if (grid[y][x] instanceof Chamber) {
            return (Chamber) grid[y][x];
        }
        return null;
    }

    public Corridor getCorridorAt(int x, int y) {
        if (x > 8 || x < 0 || y > 8 || y < 0) {
            return null;
        } else if (grid[y][x] instanceof Corridor) {
            return (Corridor) grid[y][x];
        }
        return null;
    }

    // This function was graciously provided by ChatGPT
    public static void dramaticPrint(String text, int speed, int pauseBetweenLines) {
        for (String line : text.split("\n")) {
            for (char character : line.toCharArray()) {
                System.out.print(character);
                
                try {
                    Thread.sleep(speed);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println();
            
            try {
                Thread.sleep(pauseBetweenLines);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void display() {
        System.out.println("__________________");
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                if (grid[y][x] instanceof Chamber) {
                    Chamber Chamber = (Chamber) grid[y][x];
                    if (playerX == x && playerY == y) {
                        System.out.print("o");
                    }
                    else if (Chamber.exit) {
                        if (Chamber.isVisible()) {
                            System.out.print("X");
                        }
                        else {
                            System.out.print(" ");
                        }
                    }
                    else {
                        if (Chamber.isVisible()) {
                            System.out.print("#");
                        }
                        else {
                            System.out.print(" ");
                        }
                    }
                } else if (grid[y][x] instanceof Corridor) {
                    Corridor Corridor = (Corridor) grid[y][x];
                    if (y % 2 == 1) {
                        if (Corridor.isVisible()) {
                            System.out.print("|");
                        } else {
                            System.out.print(" ");
                        }
                    } else {
                        if (Corridor.isVisible()) {
                            System.out.print("---");
                        } else {
                            System.out.print("   ");
                        }
                    }
                } else if (y % 2 == 1 && x % 2 == 0) {
                    System.out.print(" ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
        System.out.println("__________________");
    }

    public static class Builder {
        private LabyrinthModules[][] grid = new LabyrinthModules[9][9];

        public Builder() {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    grid[i][j] = null;
                }
            }
        }

        public Builder addChamber(int x, int y, boolean exit) {
            grid[Math.abs(y-8)][x] = new Chamber(exit);
            return this;
        }
        
        public Builder addChamber(int x, int y) {
            return addChamber(x, y, false);
        }

        public Builder addCorridor(int x, int y) {
            grid[Math.abs(y-8)][x] = new Corridor();
            return this;
        }

        public Labyrinth build() {
            return new Labyrinth(this);
        }
    }
}