package decorator;

public class Manticore extends MonsterCore {
    @Override
    public void attack() {
        DecoratorUtility.dramaticPrint("incisor devours you!\n" +
        "The beast bounds down another corridor in search of something more satiating", 60 , 500);
    }

    @Override
    public void spawn() {
        DecoratorUtility.dramaticPrint("A fearsome manticore appears!", 60 , 500);
    }
}