import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = ShoppingCart.getInstance();
        CommandManager commandManager = new CommandManager();
        Scanner scanner = new Scanner(System.in);

        List<Item> availableItems = new ArrayList<>();
        availableItems.add(new Product("Shirt"));
        availableItems.add(new Product("Apple"));
        availableItems.add(new Product("Chair"));
        availableItems.add(new Product("Table"));
        

        while (true) {
            System.out.println("1. Tambahkan Barang ke Keranjang");
            System.out.println("2. Keluarkan Barang dari Keranjang");
            System.out.println("3. Lihat isi Keranjang");
            System.out.println("4. Undo Command Terakhir");
            System.out.println("5. Exit");
            System.out.print("Pilih Aksi: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            switch (choice) {
                case 1:
                    System.out.println("Item yang tersedia:");
                    for (int i = 0; i < availableItems.size(); i++) {
                        System.out.println((i + 1) + ". " + availableItems.get(i).toString());
                    }
                    System.out.print("Masukkan nomor item yang ingin dimasukkan: ");
                    int addItemIndex = scanner.nextInt() - 1;
                    if (addItemIndex >= 0 && addItemIndex < availableItems.size()) {
                        Command addItemCommand = new AddItemCommand(cart, availableItems.get(addItemIndex));
                        commandManager.executeCommand(addItemCommand);
                    } else {
                        System.out.println("Pilihan tidak ada.");
                    }
                    break;

                case 2:
                    System.out.println("Item yang ada di cart untuk dikeluarkan:");
                    List<Item> cartItems = cart.getItems();
                    for (int i = 0; i < cartItems.size(); i++) {
                        System.out.println((i + 1) + ". " + cartItems.get(i).toString());
                    }
                    System.out.print("Masukkan nomor item yang ingin dikeluarkan: ");
                    int removeItemIndex = scanner.nextInt() - 1;
                    if (removeItemIndex >= 0 && removeItemIndex < cartItems.size()) {
                        Command removeItemCommand = new RemoveItemCommand(cart, cartItems.get(removeItemIndex));
                        commandManager.executeCommand(removeItemCommand);
                    } else {
                        System.out.println("Pilihan Tidak Ada.");
                    }
                    break;

                case 3:
                    System.out.println("Item di Keranjang:");
                    System.out.println("---------------------");
                    for (Item item : cart.getItems()) {
                        item.display();
                    }

                    System.out.println("---------------------");
                    break;
                case 4:

                    commandManager.undoLastCommand();
                    break;
                case 5:

                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
