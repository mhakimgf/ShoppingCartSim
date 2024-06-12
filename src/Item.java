//composite pattern

public abstract class Item {
    public void add(Item item) {
        System.out.println("Action belum di implementasi");
        }
        
        public void remove(Item item) {
            System.out.println("Action belum di implementasi");
        }
            
        public Item getChild(int i) {
            System.out.println("Action belum di implementasi");
            return null;
        }

    public abstract void display();
}




