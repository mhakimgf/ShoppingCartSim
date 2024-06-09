public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = ShoppingCart.getInstance();

        Item shirt = new Product("Shirt");
        Item apple = new Product("Apple");
        Item chair = new Product("Chair");

        ProductCategory clothing = new ProductCategory("Clothing");
        clothing.add(shirt);

        ProductCategory food = new ProductCategory("Food");
        food.add(apple);

        ProductCategory furniture = new ProductCategory("Furniture");
        furniture.add(chair);

        Command addShirt = new AddItemCommand(cart, clothing);
        Command addApple = new AddItemCommand(cart, food);
        Command addChair = new AddItemCommand(cart, furniture);
        Command removeShirt = new RemoveItemCommand(cart, clothing);

        addShirt.execute();
        addApple.execute();
        addChair.execute();
        removeShirt.execute();

        System.out.println("Items in the cart:");
        for (Item item : cart.getItems()) {
            item.display();
        }
    }
}
