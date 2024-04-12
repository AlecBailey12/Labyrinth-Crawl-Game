package factory;

import decorator.*;

import java.lang.Math;

public class MonsterMaker {

    public static Monster createMonster() {
        double random = Math.random();
        Monster monster = random < 0.7 ? new Troll() : new Manticore();
        random = Math.random();
        if (random < 0.3) {
            monster = new AshenMonster(monster);
        } else if (random < 0.6) {
            monster = new EarthenMonster(monster);
        } else {
            monster = new FrorenMonster(monster);
        }
        return monster;
    }
}
