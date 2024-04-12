package decorator;

public abstract class MonsterDecorator implements Monster {
    protected Monster decoratedMonster;

    public MonsterDecorator(Monster monster) {
        this.decoratedMonster = monster;
    }

    public void attack() {
        decoratedMonster.attack();
    }
    public void spawn() {
        decoratedMonster.spawn();
    }
}