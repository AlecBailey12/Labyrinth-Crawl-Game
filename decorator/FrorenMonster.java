package decorator;

public class FrorenMonster extends MonsterDecorator {
    public FrorenMonster(Monster monster) {
        super(monster);
    }

    @Override
    public void attack() {
        DecoratorUtility.dramaticPrint("A frost-tipped ", 60, 500);
        decoratedMonster.attack();
    }

    @Override
    public void spawn() {
        decoratedMonster.spawn();
        DecoratorUtility.dramaticPrint("A chilly mist eminates from its mouth.", 60, 500);
    }
}