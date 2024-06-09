
//composite pattern

public abstract class Item {
    public void add(Item item) {
        throw new UnsupportedOperationException();
    }

    public void remove(Item item) {
        throw new UnsupportedOperationException();
    }

    public Item getChild(int i) {
        throw new UnsupportedOperationException();
    }

    public abstract void display();
}




