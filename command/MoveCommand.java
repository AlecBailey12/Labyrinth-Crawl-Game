package command;

public class MoveCommand implements Command {
    private Player player;
    private String direction;

    public MoveCommand(Player player, String direction) {
        this.player = player;
        this.direction = direction;
    }

    @Override
    public void execute() {
        int dX = 0;
        int dY = 0;
        switch (direction.toUpperCase()) {
            case "W": dY = -1; break;
            case "A": dX = -1; break;
            case "S": dY = 1; break;
            case "D": dX = 1; break;
        }
        if (player.getLabyrinth().canMove(player.getPlayerX() + dX, player.getPlayerY() + dY)) {
            player.setPlayerX(player.getPlayerX() + dX * 2);
            player.setPlayerY(player.getPlayerY() + dY * 2);
            player.getLabyrinth().notifyMove(player.getPlayerX(), player.getPlayerY());
        }
    }
}
