package TokoGUI;

public abstract class TransaksiToko {
    String namaPelanggan;

    TransaksiToko(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    // ABSTRACT METHOD
    abstract int hitungTotal(int jumlah, int hargaSatuan);

    // INNER CLASS
    class DetailBarang {
        String namaBarang;
        int jumlah;
        int hargaSatuan;

        DetailBarang(String namaBarang, int jumlah, int hargaSatuan) {
            this.namaBarang = namaBarang;
            this.jumlah = jumlah;
            this.hargaSatuan = hargaSatuan;
        }

        String tampilStruk() {
            return "Nama Pelanggan : " + namaPelanggan +
                   "\nNama Barang    : " + namaBarang +
                   "\nJumlah Barang  : " + jumlah +
                   "\nHarga Satuan   : Rp" + hargaSatuan;
        }
    }
}