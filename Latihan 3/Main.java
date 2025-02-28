import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input hari dan status member
        System.out.print("Masukkan hari belanja: ");
        String hari = scanner.nextLine();
        System.out.print("Apakah Anda member? (ya/tidak): ");
        boolean statusMember = scanner.nextLine().equalsIgnoreCase("ya");

        // Inisialisasi DaftarBelanja
        DaftarBelanja daftarBelanja = new DaftarBelanja(hari, statusMember);
        boolean lanjut = true;

        while (lanjut) {
            System.out.println("===========================================================");
            System.out.printf("%31s\n","Menu");
            System.out.println("===========================================================");
            System.out.println("1. Tambah Item");
            System.out.println("2. Kurangi Item");
            System.out.println("3. Hapus Item");
            System.out.println("4. Tampilkan Daftar Belanja");
            System.out.println("5. Keluar");
            System.out.println("===========================================================");
            System.out.print("Pilih opsi: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline

            switch (pilihan) {
                case 1 -> {
                    System.out.print("Berapa jumlah item yang ingin dimasukkan? ");
                    int x = scanner.nextInt(); 
                    scanner.nextLine();
                    for (int i = 0; i < x; i++) {
                        System.out.print("Masukkan nama item: ");
                        String nama = scanner.nextLine();
                        System.out.print("Masukkan jumlah item: ");
                        int jumlah = scanner.nextInt();
                        System.out.print("Masukkan harga item: ");
                        int harga = scanner.nextInt();
                        System.out.print("Masukkan diskon item (%): ");
                        int diskon = scanner.nextInt();
                        scanner.nextLine(); // Membersihkan newline
                        Item item = new Item(nama, jumlah, harga, diskon);
                        daftarBelanja.tambahItem(item);
                        System.out.println("Item berhasil ditambahkan.\n");
                    }
                }
                case 2 -> {
                    System.out.print("Masukkan nama item yang ingin dikurangi: ");
                    String namaKurang = scanner.nextLine();
                    daftarBelanja.kurangiItem(namaKurang);
                    System.out.println(namaKurang + " berhasil dikurangi\n");
                }
                case 3 -> {
                    System.out.print("Masukkan nama item yang ingin dihapus: ");
                    String namaHapus = scanner.nextLine();
                    daftarBelanja.hapusItem(namaHapus);
                    System.out.println(namaHapus + " berhasil dihapus\n");
                }
                case 4 -> daftarBelanja.tampilkanDaftar();
                case 5 -> {
                    lanjut = false;
                    System.out.println("Terima kasih!");
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
        scanner.close();
    }
}
