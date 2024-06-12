import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = ShoppingCart.getInstance();
        CommandManager commandManager = new CommandManager();
        Scanner scanner = new Scanner(System.in);

        String[] foodItemsArr = new String[] { 
            "Apple", "Banana", "Orange", "Strawberry", "Grapes",
            "Watermelon", "Pineapple", "Mango", "Blueberry", "Kiwi",
            "Peach", "Plum", "Cherry", "Avocado", "Lemon",
            "Lime", "Pear", "Pomegranate", "Coconut", "Papaya" 
        };
        
    

        // Harga untuk setiap item makanan dalam foodItemsArr
        double[] foodItemsPrice = new double[] { 
            12000, 13000, 14000, 9000, 15000,
            20000, 25000, 18000, 22000, 17000,
            14000, 16000, 19000, 21000, 11000,
            12000, 13000, 24000, 26000, 23000 
        };

        String[] furnitureItemsArr = new String[] { 
            "Chair", "Table", "Sofa", "Bed", "Cabinet",
            "Desk", "Couch", "Dresser", "Bookshelf", "Wardrobe",
            "Coffee Table", "Nightstand", "Dining Table", "Stool", "Bench",
            "Armchair", "Recliner", "Drawers", "TV Stand", "Ottoman" 
        };

        // Harga untuk setiap item furnitur dalam furnitureItemsArr
        double[] furnitureItemsPrice = new double[] { 
            500000, 1500000, 3000000, 2000000, 1200000,
            1000000, 2500000, 1800000, 900000, 2200000,
            800000, 700000, 2500000, 400000, 600000,
            1000000, 1500000, 2000000, 1100000, 900000 
        };


        

        ProductCategory foodItems = new ProductCategory("Food");
        for(int i = 0; i < foodItemsArr.length; i++){
            foodItems.add(new Product(foodItemsArr[i], foodItemsPrice[i]));
        }
        
        ProductCategory Furniture = new ProductCategory("Furniture");
        for(int i = 0; i < furnitureItemsArr.length; i++){
            Furniture.add(new Product(furnitureItemsArr[i], furnitureItemsPrice[i]));
        }
        

        while (true) {
            System.out.println(ColorConsole.BLUE + "Selamat datang di Toko Online" + ColorConsole.RESET);
            System.out.println("1. Tambahkan Barang ke Keranjang");
            System.out.println("2. Keluarkan Barang dari Keranjang");
            System.out.println("3. Lihat isi Keranjang");
            System.out.println("4. Undo Command Terakhir");
            System.out.println("5. Redo Command Terakhir");
            System.out.println("6. Exit");
            System.out.println();
            System.out.print("Pilih Aksi: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            switch (choice) {
                case 1:
                System.out.println();
                System.out.println("Pilih kategori:");
                System.out.println("1. Food");
                System.out.println("2. Furniture");
                System.out.print("Masukkan nomor kategori: ");
                int categoryChoice = scanner.nextInt();
                scanner.nextLine(); // consume newline character
            
                List<Item> selectedCategoryItems = new ArrayList<>();
                String selectedCategoryName = "";
            
                if (categoryChoice == 1) {
                    selectedCategoryItems = foodItems.getItems();
                    selectedCategoryName = "Food";
                } else if (categoryChoice == 2) {
                    selectedCategoryItems = Furniture.getItems();
                    selectedCategoryName = "Furniture";
                } else {
                    System.out.println("Kategori tidak valid.");
                    break;
                }
            
                System.out.println();
                System.out.println("Item yang tersedia dalam kategori " + selectedCategoryName + ":");
                for (int i = 0; i < selectedCategoryItems.size(); i++) {
                    System.out.println((i + 1) + ". " + selectedCategoryItems.get(i).toString());
                }
                System.out.println();
                System.out.print("Masukkan nomor item yang ingin dimasukkan: ");
                int addItemIndex = scanner.nextInt() - 1;
                if (addItemIndex >= 0 && addItemIndex < selectedCategoryItems.size()) {
                    Command addItemCommand = new AddItemCommand(cart, selectedCategoryItems.get(addItemIndex));
                    commandManager.executeCommand(addItemCommand);
                } else {
                    System.out.println("Pilihan tidak ada.");
                }
                System.out.println();
                break;

                case 2:
                    System.out.println();
                    System.out.println("Item yang ada di cart untuk dikeluarkan:");
                    List<Item> cartItems = cart.getItems();
                    for (int i = 0; i < cartItems.size(); i++) {
                        System.out.println((i + 1) + ". " + cartItems.get(i).toString());
                    }
                    System.out.println();
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
                    System.out.println();
                    System.out.println("Item di Keranjang:");
                    System.out.println("---------------------");
                    for (Item item : cart.getItems()) {
                        item.display();
                    }

                    NumberFormat formatter = NumberFormat.getInstance(Locale.US);
                    String formattedTotalPrice = formatter.format(cart.getTotalPrice());
                    System.out.println(String.format(Locale.US, ColorConsole.GREEN + "Total Harga: " + formattedTotalPrice + ColorConsole.RESET));

                    System.out.println("---------------------");
                    System.out.println();
                    break;
                case 4:
                    commandManager.undoLastCommand();
                    System.out.println("Undo berhasil dilakukan");
                    System.out.println();
                    break;
                case 5:
                    commandManager.redoLastCommand();
                    System.out.println("Redo berhasil dilakukan");
                    System.out.println();
                    break;
                case 6:
                    System.out.println();
                    System.out.println("Keluar dari aplikasi...");
                    scanner.close();
                    return;
                default:
                    System.out.println("opsi tidak valid, coba lagi ");
                
            }
        }
    }
}
