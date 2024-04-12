package builder;

import java.util.Scanner;
import java.lang.Math;

import command.*;
import builder.Labyrinth.Chamber;
import observer.VisibilityManager;
import decorator.*;
import factory.MonsterMaker;

public class LabyrinthGame {
    public static void main(String[] args) {
        Labyrinth labyrinth = new Labyrinth.Builder()
                .addChamber(0, 0)
                .addChamber(0, 2)
                .addChamber(0, 4)
                .addChamber(0, 6)
                .addChamber(0, 8, true)
                .addChamber(2, 0)
                .addChamber(2, 2)
                .addChamber(2, 4)
                .addChamber(2, 6)
                .addChamber(2, 8)
                .addChamber(4, 0)
                .addChamber(4, 2)
                .addChamber(4, 4)
                .addChamber(4, 6)
                .addChamber(4, 8)
                .addChamber(6, 0)
                .addChamber(6, 2)
                .addChamber(6, 4)
                .addChamber(6, 6)
                .addChamber(6, 8)
                .addChamber(8, 0)
                .addChamber(8, 2)
                .addChamber(8, 4)
                .addChamber(8, 6)
                .addChamber(8, 8)
                .addCorridor(0, 3)
                .addCorridor(0, 5)
                .addCorridor(0, 7)
                .addCorridor(1, 0)
                .addCorridor(1, 4)
                .addCorridor(2, 1)
                .addCorridor(2, 3)
                .addCorridor(2, 5)
                .addCorridor(2, 7)
                .addCorridor(3, 0)
                .addCorridor(3, 2)
                .addCorridor(3, 6)
                .addCorridor(4, 3)
                .addCorridor(5, 0)
                .addCorridor(5, 2)
                .addCorridor(5, 6)
                .addCorridor(5, 8)
                .addCorridor(6, 3)
                .addCorridor(6, 5)
                .addCorridor(7, 0)
                .addCorridor(7, 2)
                .addCorridor(7, 4)
                .addCorridor(7, 6)
                .addCorridor(7, 8)
                .addCorridor(8, 1)
                .addCorridor(8, 5)
                .addCorridor(8, 7)
                .build();

        Player player = new Player(labyrinth, 4, 4);
        VisibilityManager visibilityManager = new VisibilityManager(labyrinth);
        Invoker invoker = new Invoker();
        
        visibilityManager.update(player.getPlayerX(), player.getPlayerY());

        labyrinth.display();

        labyrinth.dramaticPrint("You have just picked your head up off the cold stone floor\n" +
                                "You are surrounded by darnkess, the soft flicker of a dying torch can be seen in the distance\n"
                                , 60, 1000);
        
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter W, A, S, or D to move (or Q to end the game):");
            String input = scanner.nextLine();
            if ("Q".equals(input) || "q".equals(input)) {
                labyrinth.dramaticPrint("You got lost in the dark corners of time...\n" +
                                  "Forgotten...\n" +
                                  "Even by the unending annals of history\n", 60, 1000);
                break;
            }
            Command moveCommand = new MoveCommand(player, input);
            invoker.addActivity(moveCommand);
            invoker.performActivities();
            if (Math.random() < 0.4) {
                //Monster monster = MonsterFactory.createMonster();
            }
            visibilityManager.update(player.getPlayerX(), player.getPlayerY());
            labyrinth.display();
            Chamber Chamber = labyrinth.getCurrentChamber();
            if (Chamber.isExit()) {
                Monster monster = MonsterMaker.createMonster();
                monster.spawn();
                System.out.println("Enter F to fight or R to make a run for the exit (or Q if this is more than your frail heart can take):");
                input = scanner.nextLine();
                if ("Q".equals(input) || "q".equals(input)) {
                    labyrinth.dramaticPrint("You got lost in the dark corners of time...\n" +
                                    "Forgotten...\n" +
                                    "Even by the unending annals of history\n", 60, 1000);
                break;
                } else if ("F".equals(input) || "f".equals(input)) {
                    if (Math.random() < 0.2) {
                        labyrinth.dramaticPrint("You find a nearby rock and hurl it with all your might directly at the beast's head...\n" +
                        "The stone hits the monster in the eye, sending it reeling!\n" +
                        "Against stacked odds you emerge into the light!", 60, 500);
                        break;
                    } else {
                        labyrinth.dramaticPrint("You find a nearby rock and hurl it with all your might directly at the beast's head...\n" +
                        "Alas, the stone bounces off as if it were a scrunched up piece of paper.\n" +
                        "With an effortless swing of its arm your spine is shattered. You are try to move but can't.", 60, 500);
                        monster.attack();
                        break;
                    }
                } else if ("R".equals(input) || "r".equals(input)) {
                    if (Math.random() < 0.6) {
                        labyrinth.dramaticPrint("The monster is disinterested in such a small critter as you.\n" +
                        "Against stacked odds you emerge into the light!", 60, 500);
                        break;
                    } else {
                        labyrinth.dramaticPrint("The abominatination easily scoops you up and tears off an arm before letting you fall to the ground...", 60, 500);
                        monster.attack();
                        break;
                    }
                } else {
                    labyrinth.dramaticPrint("Your indecision costs you at the worst moment...\n" +
                    "A arm twice the size of your body effortlessly shatters your skeleton rendering you paralyzed.", 60, 500);
                    monster.attack();
                    break;
                }
            }
        }
        scanner.close();
    }
}