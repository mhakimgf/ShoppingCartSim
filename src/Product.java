import java.text.NumberFormat;
import java.util.Locale;

public class Product extends Item {
    private String name;
    private double harga;

    public Product(String name,double harga) {
        this.name = name;
        this.harga = harga;
    }

    @Override
    public void display() {
        NumberFormat formatter = NumberFormat.getInstance(Locale.US);
        String formattedHarga = formatter.format(harga);
        System.out.println("Product: " + name + ", " + formattedHarga);
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
        String s = String.format(Locale.US, "%-13s : %,.0f", name, harga);
        return s;
    }
    
    public double getPrice() {
        return harga;
    }
    
}
