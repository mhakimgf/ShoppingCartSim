public class Product extends Item {
    private String name;

    public Product(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println("Product: " + name);
    }
}