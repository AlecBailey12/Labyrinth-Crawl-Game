package decorator;

public class EarthenMonster extends MonsterDecorator {
    public EarthenMonster(Monster monster) {
        super(monster);
    }

    @Override
    public void attack() {
        DecoratorUtility.dramaticPrint("An earth-hardened ", 60, 500);
        decoratedMonster.attack();
    }

    @Override
    public void spawn() {
        decoratedMonster.spawn();
        DecoratorUtility.dramaticPrint("It's covered in thick earthen armor.", 60, 500);
    }
}