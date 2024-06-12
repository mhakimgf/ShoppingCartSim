import java.util.*;

public class ProductCategory extends Item {
    private List<Item> items = new ArrayList<>();
    private String name;

    public ProductCategory(String name) {
        this.name = name;
    }

    @Override
    public void add(Item item) {
        items.add(item);
    }

    @Override
    public void remove(Item item) {
        items.remove(item);
    }

    @Override
    public Item getChild(int i) {
        return items.get(i);
    }
    public List<Item> getItems(){
        return items;
    }

    @Override
    public void display() {
        System.out.println("Category: " + name);
        for (Item item : items) {
            item.display();
        }
    }
}