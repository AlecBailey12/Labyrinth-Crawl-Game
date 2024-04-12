package decorator;

// Unused in submission
public class PerfectedMonster extends MonsterDecorator {
    public PerfectedMonster(Monster monster) {
        super(monster);
    }

    @Override
    public void attack() {
        super.attack();

    }
    
    @Override
    public void spawn() {
        
    }
}