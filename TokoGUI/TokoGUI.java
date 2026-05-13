package TokoGUI;

import java.awt.*;
import java.awt.event.*;

public class TokoGUI extends TransaksiToko implements Pembayaran {

    // DEKLARASI VARIABEL (PENTING AGAR TIDAK MERAH)
    Frame frame;
    TextField txtNama, txtBarang, txtJumlah, txtHarga;
    TextArea txtHasil;
    Button btnProses, btnKeluar;

    TokoGUI() {
        super("");

        frame = new Frame("Kasir Premium v1.0");

        // Palet Warna Elegant
        Color primaryColor = new Color(44, 62, 80);   // Navy Dark
        Color accentColor = new Color(52, 152, 219);  // Blue Light
        Color textColor = Color.WHITE;

        // Label
        Label lblNama = new Label("Nama Pelanggan"); lblNama.setForeground(textColor);
        Label lblBarang = new Label("Nama Barang"); lblBarang.setForeground(textColor);
        Label lblJumlah = new Label("Jumlah Barang"); lblJumlah.setForeground(textColor);
        Label lblHarga = new Label("Harga Satuan"); lblHarga.setForeground(textColor);

        // Input
        txtNama = new TextField();
        txtBarang = new TextField();
        txtJumlah = new TextField();
        txtHarga = new TextField();

        // Output (Gaya Monospaced agar rapi)
        txtHasil = new TextArea();
        txtHasil.setBackground(new Color(236, 240, 241));
        txtHasil.setFont(new Font("Monospaced", Font.PLAIN, 12));

        // Tombol
        btnProses = new Button("PROSES TRANSAKSI");
        btnProses.setBackground(accentColor);
        btnProses.setForeground(Color.WHITE);

        btnKeluar = new Button("KELUAR");
        btnKeluar.setBackground(new Color(231, 76, 60));
        btnKeluar.setForeground(Color.WHITE);

        // Atur Posisi (Bounds)
        lblNama.setBounds(50, 60, 120, 25);
        txtNama.setBounds(180, 60, 180, 25);
        lblBarang.setBounds(50, 100, 120, 25);
        txtBarang.setBounds(180, 100, 180, 25);
        lblJumlah.setBounds(50, 140, 120, 25);
        txtJumlah.setBounds(180, 140, 180, 25);
        lblHarga.setBounds(50, 180, 120, 25);
        txtHarga.setBounds(180, 180, 180, 25);

        btnProses.setBounds(50, 230, 150, 40);
        btnKeluar.setBounds(210, 230, 150, 40);
        txtHasil.setBounds(50, 290, 330, 160);

        // Tambah ke Frame
        frame.add(lblNama); frame.add(txtNama);
        frame.add(lblBarang); frame.add(txtBarang);
        frame.add(lblJumlah); frame.add(txtJumlah);
        frame.add(lblHarga); frame.add(txtHarga);
        frame.add(btnProses); frame.add(btnKeluar);
        frame.add(txtHasil);

        // Event Tombol
        btnProses.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mulaiTransaksi();
            }
        });

        btnKeluar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });

        frame.setSize(430, 500);
        frame.setLayout(null);
        frame.setBackground(primaryColor);
        frame.setVisible(true);
    }

    @Override
    int hitungTotal(int jumlah, int hargaSatuan) {
        return jumlah * hargaSatuan;
    }

    @Override
    public void prosesBayar() {
        txtHasil.append("\n-----------------------");
        txtHasil.append("\nMetode : Tunai / QRIS");
        txtHasil.append("\nStatus : LUNAS");
    }

    void mulaiTransaksi() {
        try {
            namaPelanggan = txtNama.getText();
            String barang = txtBarang.getText();
            int qty = Integer.parseInt(txtJumlah.getText());
            int harga = Integer.parseInt(txtHarga.getText());

            long idTrans = System.currentTimeMillis() / 100000;

            DetailBarang detail = new DetailBarang(barang, qty, harga);
            int total = hitungTotal(qty, harga);

            txtHasil.setText("ID TRANS: #" + idTrans + "\n");
            txtHasil.append(detail.tampilStruk());
            txtHasil.append("\nTotal Belanja  : Rp" + total);
            
            prosesBayar();
        } catch (Exception ex) {
            txtHasil.setText("⚠️ Error: Input harus angka!");
        }
    }

    public static void main(String[] args) {
        new TokoGUI();
    }
}