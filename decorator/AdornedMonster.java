package decorator;

// Unused in submission
public class AdornedMonster extends MonsterDecorator {
    public AdornedMonster(Monster monster) {
        super(monster);
    }

    @Override
    public void attack() {
        super.attack();
    }
}