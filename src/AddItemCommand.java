public class AddItemCommand implements Command {
    private ShoppingCart cart;
    private Item item;

    public AddItemCommand(ShoppingCart cart, Item item) {
        this.cart = cart;
        this.item = item;
    }

    @Override
    public void execute() {
        cart.addItem(item);
    }

    @Override
    public void undo() {
        cart.removeItem(item);
    }
}
