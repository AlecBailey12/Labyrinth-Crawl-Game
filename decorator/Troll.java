package decorator;

public class Troll extends MonsterCore {
    @Override
    public void attack() {
        DecoratorUtility.dramaticPrint("spear impales you.\n" +
        "The troll quietly returns to its patrol.", 60, 500);
    }

    @Override
    public void spawn() {
        DecoratorUtility.dramaticPrint("A towering troll appears!", 60, 500);
    }
}