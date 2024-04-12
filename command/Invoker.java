package command;

import java.util.List;
import java.util.ArrayList;

public class Invoker {
    private List<Command> subsistence = new ArrayList<>();

    public void addActivity(Command command) {
        subsistence.add(command);
    }
    
    public void removeActivity(Command command) {
        subsistence.remove(command);
    }

    public void performActivities() {
        for (Command command : subsistence) {
            command.execute();
        }
        subsistence.clear();
    }
}
