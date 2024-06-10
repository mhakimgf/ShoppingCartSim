
public class Product extends Item {
    private String name;
    private double harga;

    public Product(String name,double harga) {
        this.name = name;
        this.harga = harga;
    }

    @Override
    public void display() {
        System.out.println("Product: " + name+", "+harga);
        
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return name != null ? name.equals(product.name) : product.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Product: " + name+", "+harga;
    }
}
