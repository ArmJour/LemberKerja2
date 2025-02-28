import java.util.ArrayList;
import java.util.List;

public class DaftarBelanja {
    private String hari;
    private boolean statusMember;
    private List<Item> daftarItem;

    public DaftarBelanja(String hari, boolean statusMember) {
        this.hari = hari;
        this.statusMember = statusMember;
        this.daftarItem = new ArrayList<>();
    }

    // Getter
    public String hari() {
        return hari;
    }

    public boolean statusMember() {
        return statusMember;
    }

    public List<Item> daftarItem() {
        return daftarItem;
    }

    public void tambahItem(Item item) {
        daftarItem.add(item);
    }

    public void kurangiItem(String namaItem) {
        for (Item item : daftarItem) {
            if (item.nama().equalsIgnoreCase(namaItem)) {
                if (item.jumlah() > 1) {
                    item.setJumlah(item.jumlah() - 1); // Mengurangi jumlah
                } else {
                    daftarItem.remove(item); // Menghapus item jika jumlahnya 1
                }
                return;
            }
        }
        System.out.println("Item tidak ditemukan.");
    }

    public void hapusItem(String namaItem) {
        for (Item item : daftarItem) {
            if (item.nama().equalsIgnoreCase(namaItem)) {
                daftarItem.remove(item);
                return;
            }
        }
        System.out.println("Item tidak ditemukan.");
    }

    public int hargaTotal() {
        int total = 0;
        for (Item item : daftarItem) {
            int hargaSetelahDiskon = item.harga() - (item.harga() * item.diskon() / 100);
            total += hargaSetelahDiskon * item.jumlah();
        }
        return total;
    }

    public int diskonTotal() {
        int diskonMember = statusMember ? 5 : 0; // 5% jika member
        int diskonHari = hari.equalsIgnoreCase("Jumat") ? 5 : 0; // 5% jika Jumat
        return diskonMember + diskonHari; // Total diskon tambahan
    }

    public int hargaAkhir() {
        int totalHarga = hargaTotal();
        int diskonTambahan = diskonTotal();
        int hargaAkhir = totalHarga - (totalHarga * diskonTambahan / 100);
        return hargaAkhir;
    }

    public void tampilkanDaftar() {
        if (daftarItem.isEmpty()) {
            System.out.println("Daftar belanja kosong.\n");
        } else {
            System.out.println("===========================================================");
            System.out.printf("%35s\n","Daftar Belanja");
            System.out.println("===========================================================");
            for (Item item : daftarItem) {
                item.tampilkanInfo();
            }
            System.out.println("Total Harga (setelah diskon per item): " + hargaTotal());
            System.out.println("Diskon Tambahan (Member + Hari): " + diskonTotal() + "%");
            System.out.println("===========================================================");
            System.out.println("Harga Akhir: " + hargaAkhir());
            System.out.println("===========================================================\n");
        }
    }
}