package LaundryGUI;

public abstract class TransaksiLaundry {

    String namaPelanggan;

    TransaksiLaundry(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    // ABSTRACT METHOD
    abstract int hitungTotal(int berat, int hargaPerKg);

    // INNER CLASS
    class DetailLaundry {

        String jenisLaundry;
        int berat;
        int hargaPerKg;

        DetailLaundry(String jenisLaundry, int berat, int hargaPerKg) {

            this.jenisLaundry = jenisLaundry;
            this.berat = berat;
            this.hargaPerKg = hargaPerKg;
        }

        String tampilDetail() {

            return "Nama Pelanggan : " + namaPelanggan +
                   "\nJenis Laundry  : " + jenisLaundry +
                   "\nBerat          : " + berat + " kg" +
                   "\nHarga / kg     : Rp" + hargaPerKg;
        }
    }
}