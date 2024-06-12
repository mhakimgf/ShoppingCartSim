//invoker class dipanggil oleh kelas Main.java

import java.util.Stack;

public class CommandManager {
    private Stack<Command> commandStack = new Stack<>();
    private Stack<Command> undoCommandStack= new Stack<>();

    public void executeCommand(Command command) {
        command.execute();
        commandStack.push(command);
    }

    public void undoLastCommand() {
        if (!commandStack.isEmpty()) {
            Command lastCommand = commandStack.pop();
            undoCommandStack.add(lastCommand);
            lastCommand.undo();
        }
    }

    public void redoLastCommand(){
        if(!undoCommandStack.isEmpty()){
            Command lastUndoCommand = undoCommandStack.pop();
            lastUndoCommand.redo();

            
        }
    }
}
