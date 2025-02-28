public class Item {
    private String nama;
    private int jumlah;
    private int harga;
    private int diskon; // Diskon per item dalam persen

    public Item(String nama, int jumlah, int harga, int diskon) {
        this.nama = nama;
        this.jumlah = jumlah;
        this.harga = harga;
        this.diskon = diskon;
    }

    // Getter
    public String nama() {
        return nama;
    }

    public int jumlah() {
        return jumlah;
    }

    public int harga() {
        return harga;
    }

    public int diskon() {
        return diskon;
    }

    public void tampilkanInfo() {
        System.out.println("Nama: " + nama + ", Jumlah: " + jumlah + ", Harga: " + harga + ", Diskon: " + diskon + "%");
    }

    // Setter untuk keperluan pengurangan jumlah (opsional)
    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
}
