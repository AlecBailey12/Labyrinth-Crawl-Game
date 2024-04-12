package decorator;

public class AshenMonster extends MonsterDecorator {
    public AshenMonster(Monster monster) {
        super(monster);
    }

    @Override
    public void attack() {
        DecoratorUtility.dramaticPrint("A flame-kissed ", 60, 0);
        decoratedMonster.attack();
    }

    @Override
    public void spawn() {
        decoratedMonster.spawn();
        DecoratorUtility.dramaticPrint("Its ashen skin flickers with fiery veins.", 60, 500);
    }
}