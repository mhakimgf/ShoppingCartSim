//concreate command class

public class AddItemCommand implements Command {
    private ShoppingCart cart;
    private Item item;

    public AddItemCommand(ShoppingCart cart, Item item) {
        this.cart = cart;
        this.item = item;
    }

    @Override
    public void execute() {//melakukan execute command add
        cart.addItem(item);
    }

    @Override
    public void undo() {//melakukan undo dengan remove item
        cart.removeItem(item);
    }

    @Override 
    public void redo(){
        cart.addItem(item);
    }
}
