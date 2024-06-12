//conrete Command sampai anak anaknya

public interface Command { 
    void execute();
    void undo();
    void redo();
}
