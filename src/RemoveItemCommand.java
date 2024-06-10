public class RemoveItemCommand implements Command {
    private ShoppingCart cart;
    private Item item;

    public RemoveItemCommand(ShoppingCart cart, Item item) {    //executor dari fitur remove
        this.cart = cart;
        this.item = item;
    }

    @Override
    public void execute() {     //melakukan execute  command remove
        cart.removeItem(item);
    }

    @Override
    public void undo() {    //jika melakukan undo maka akan mengembalikan barang yang sebelumnya diremove
        cart.addItem(item);
    }
}
