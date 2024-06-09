public class RemoveItemCommand implements Command {
    private ShoppingCart cart;
    private Item item;

    public RemoveItemCommand(ShoppingCart cart, Item item) {
        this.cart = cart;
        this.item = item;
    }

    @Override
    public void execute() {
        cart.removeItem(item);
    }
}