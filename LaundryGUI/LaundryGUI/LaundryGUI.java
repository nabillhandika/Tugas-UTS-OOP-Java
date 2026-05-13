package LaundryGUI;

import java.awt.*;
import java.awt.event.*;

public class LaundryGUI extends TransaksiLaundry implements Pembayaran {

    Frame frame;

    TextField txtNama;
    TextField txtJenis;
    TextField txtBerat;
    TextField txtHarga;

    TextArea txtHasil;

    Button btnProses;
    Button btnKeluar;

    LaundryGUI() {

        super("");

        frame = new Frame("Aplikasi Laundry");

        Label lblNama = new Label("Nama Pelanggan");
        Label lblJenis = new Label("Jenis Laundry");
        Label lblBerat = new Label("Berat (kg)");
        Label lblHarga = new Label("Harga per kg");

        txtNama = new TextField();
        txtJenis = new TextField();
        txtBerat = new TextField();
        txtHarga = new TextField();

        txtHasil = new TextArea();

        btnProses = new Button("Proses");
        btnKeluar = new Button("Keluar");

        lblNama.setBounds(50,60,120,25);
        txtNama.setBounds(180,60,180,25);

        lblJenis.setBounds(50,100,120,25);
        txtJenis.setBounds(180,100,180,25);

        lblBerat.setBounds(50,140,120,25);
        txtBerat.setBounds(180,140,180,25);

        lblHarga.setBounds(50,180,120,25);
        txtHarga.setBounds(180,180,180,25);

        btnProses.setBounds(80,230,120,35);
        btnKeluar.setBounds(220,230,120,35);

        txtHasil.setBounds(50,290,310,150);

        frame.add(lblNama);
        frame.add(txtNama);

        frame.add(lblJenis);
        frame.add(txtJenis);

        frame.add(lblBerat);
        frame.add(txtBerat);

        frame.add(lblHarga);
        frame.add(txtHarga);

        frame.add(btnProses);
        frame.add(btnKeluar);

        frame.add(txtHasil);

        // EVENT BUTTON PROSES
        btnProses.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                prosesLaundry();
            }
        });

        // EVENT BUTTON KELUAR
        btnKeluar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                frame.dispose();
            }
        });

        // EVENT CLOSE WINDOW
        frame.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {

                frame.dispose();
            }
        });

        frame.setSize(430,500);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    // IMPLEMENT ABSTRACT METHOD
    int hitungTotal(int berat, int hargaPerKg) {

        return berat * hargaPerKg;
    }

    // IMPLEMENT INTERFACE
    public void prosesBayar() {

        txtHasil.append("\nMetode Bayar : QRIS");
        txtHasil.append("\nStatus       : Berhasil");
    }

    // METHOD PROSES
    void prosesLaundry() {

        namaPelanggan = txtNama.getText();

        String jenis = txtJenis.getText();

        int berat = Integer.parseInt(txtBerat.getText());

        int harga = Integer.parseInt(txtHarga.getText());

        // OBJECT INNER CLASS
        DetailLaundry detail =
                new DetailLaundry(jenis, berat, harga);

        int total = hitungTotal(berat, harga);

        txtHasil.setText(detail.tampilDetail());

        txtHasil.append("\nTotal Bayar  : Rp" + total);

        prosesBayar();
    }

    public static void main(String[] args) {

        new LaundryGUI();
    }
}