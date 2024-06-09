import java.util.Stack;

public class CommandManager {
    private Stack<Command> commandStack = new Stack<>();

    public void executeCommand(Command command) {
        command.execute();
        commandStack.push(command);
    }

    public void undoLastCommand() {
        if (!commandStack.isEmpty()) {
            Command lastCommand = commandStack.pop();
            lastCommand.undo();
        }
    }
}
