/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.investarislabkom;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Ashifa Safitri
 */
public class InvestarisLabKom {
    private static Scanner input = new Scanner(System.in);
    private ArrayList<Barang> daftarBarang;
    private HashMap<String, Petugas> dataPetugas;
    private RuangPenyimpanan ruang;
    private TransaksiPeminjaman transaksi;
    public InvestarisLabKom() {
        daftarBarang = new ArrayList<>();
        dataPetugas = new HashMap<>();
        ruang = new RuangPenyimpanan();
        transaksi = new TransaksiPeminjaman();
    }
    public void isiDataAwal() {
        daftarBarang.add(new Komputer( "Komputer Lab 1", "Lenovo", 2023, "Intel i5" ));
        daftarBarang.add(new Komputer( "Komputer Lab 2", "Asus", 2024, "Intel i7" ));
        daftarBarang.add(new Monitor( "Monitor Lab 1", "Samsung", 2023, 24 ));
        daftarBarang.add(new Printer( "Printer Lab", "Epson", 2022, "Inkjet" ));
        daftarBarang.add(new Keyboard( "Keyboard Lab 1", "Logitech", 2024, "Mechanical" ));
        dataPetugas.put("PT001", new Petugas("PT001", "Andi", "Admin"));
        dataPetugas.put("PT002", new Petugas("PT002", "Budi", "Teknisi"));
        dataPetugas.put("PT003", new Petugas("PT003", "Citra", "Petugas Lab"));
        System.out.println("Data awal berhasil ditambahkan.");
    }
    public void tambahBarang(Barang barang) {
        daftarBarang.add(barang);
    }
    public void tambahPetugas(Petugas petugas)
            throws InventarisException {
        if (dataPetugas.containsKey(petugas.getId())) {
            throw new InventarisException( "ID petugas sudah terdaftar!"
            );
        }
        dataPetugas.put(petugas.getId(), petugas);
    }
    public void tampilkanSemuaBarang() {

        System.out.println("\n===== DAFTAR BARANG INVENTARIS =====");
        if (daftarBarang.isEmpty()) {
            System.out.println("Belum ada barang.");
            return;
        }
        for (int i = 0; i < daftarBarang.size(); i++) {
            System.out.println("\nBarang ke-" + (i + 1));
            daftarBarang.get(i).tampilkanInfo();
            daftarBarang.get(i).cekKondisi();
        }
        System.out.println("\nTotal barang: " + daftarBarang.size());
    }
    public void cariBarang(String nama) {
        boolean ditemukan = false;
        for (Barang barang : daftarBarang) {
            if (barang.getNama().equalsIgnoreCase(nama)) {
                barang.tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Barang tidak ditemukan.");
        }
    }
    public void cariBarang(int tahun) {
        boolean ditemukan = false;
        for (Barang barang : daftarBarang) {
            if (barang.getTahunPembelian() == tahun) {
                barang.tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Barang tidak ditemukan.");
        }
    }
    public void prosesFiturBarang(Barang barang) {
        barang.cekKondisi();
        if (barang instanceof DapatDinilai) {
            DapatDinilai penilaian = (DapatDinilai) barang;
            penilaian.beriPenilaian();
        }
        if (barang instanceof DapatDipinjam) {
            System.out.println("Barang dapat dipinjam.");
        }
    }
    public void simulasiPenggunaan() {
        if (daftarBarang.isEmpty()) {
            System.out.println("Belum ada barang.");
            return;
        }
        for (Barang barang : daftarBarang) {
            barang.caraPenggunaan();
        }
    }
    public Petugas cariPetugas(String id) {
        return dataPetugas.get(id);
    }
    public void tampilkanSemuaPetugas() {
        System.out.println("\n===== DAFTAR PETUGAS =====");
        if (dataPetugas.isEmpty()) {
            System.out.println("Belum ada petugas.");
            return;
        }
       for (Petugas petugas : dataPetugas.values()) {
            petugas.tampilkanInfo();
            System.out.println("-------------------------");
        }
    }
    public void kelolaPetugas() {
        System.out.println("\n===== KELOLA PETUGAS =====");
        System.out.println("1. Tambah Petugas");
        System.out.println("2. Cari Petugas");
        System.out.println("3. Tampilkan Semua Petugas");
        System.out.print("Pilih menu: ");
        int pilihan = bacaAngka();
        switch (pilihan) {
            case 1:
                System.out.print("Masukkan ID Petugas: ");
                String id = input.nextLine();
                System.out.print("Masukkan Nama: ");
                String nama = input.nextLine();
                System.out.print("Masukkan Jabatan: ");
                String jabatan = input.nextLine();
                try {
                    tambahPetugas(
                        new Petugas(id, nama, jabatan)
                    );
                    System.out.println("Petugas berhasil ditambahkan.");
                    transaksi.catatLog(
                        "Penambahan petugas: " + nama
                    );
                } catch (InventarisException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                System.out.print("Masukkan ID Petugas: ");
                String cariId = input.nextLine();

                Petugas petugas = cariPetugas(cariId);

                if (petugas != null) {
                    petugas.tampilkanInfo();
                } else {
                    System.out.println("Petugas tidak ditemukan.");
                }
                break;
            case 3:
                tampilkanSemuaPetugas();
                break;
            default:
                System.out.println("Pilihan tidak tersedia.");
        }
    }
    public void tampilkanRuang() {
        ruang.tampilkanInfo();
    }
    public void prosesPeminjaman() {
        if (daftarBarang.isEmpty() || dataPetugas.isEmpty()) {
            System.out.println("Data barang atau petugas masih kosong.");
            return;
        }
        tampilkanSemuaPetugas();
        System.out.print("\nMasukkan ID Petugas: ");
        String id = input.nextLine();
        Petugas petugas = cariPetugas(id);
        if (petugas == null) {
            System.out.println("Petugas tidak ditemukan.");
            return;
        }
        tampilkanSemuaBarang();
        System.out.print("\nPilih nomor barang: ");
        int nomor = bacaAngka();
        if (nomor < 1 || nomor > daftarBarang.size()) {
            System.out.println("Nomor barang tidak valid.");
            return;
        }
        Barang barang = daftarBarang.get(nomor - 1);
        transaksi.prosesTransaksi(petugas, barang);
    }public void tambahBarangMenu() {
        System.out.println("\n===== TAMBAH BARANG =====");
        System.out.println("1. Komputer");
        System.out.println("2. Monitor");
        System.out.println("3. Printer");
        System.out.println("4. Keyboard");
        System.out.print("Pilih jenis barang: ");
        int pilihan = bacaAngka();
        System.out.print("Nama barang: ");
        String nama = input.nextLine();
        System.out.print("Merek: ");
        String merek = input.nextLine();
        System.out.print("Tahun pembelian: ");
        int tahun = bacaAngka();
        Barang barang = null;
        switch (pilihan) {
            case 1:
                System.out.print("Processor: ");
                String processor = input.nextLine();
                barang = new Komputer(
                    nama, merek, tahun, processor
                );
                break;
            case 2:
                System.out.print("Ukuran monitor (inci): ");
                int ukuran = bacaAngka();
                barang = new Monitor(
                    nama, merek, tahun, ukuran
                );
                break;
            case 3:
                System.out.print("Jenis printer: ");
                String jenisPrinter = input.nextLine();
                barang = new Printer(
                    nama, merek, tahun, jenisPrinter
                );
                break;
            case 4:
                System.out.print("Jenis keyboard: ");
                String jenisKeyboard = input.nextLine();
                barang = new Keyboard(
                    nama, merek, tahun, jenisKeyboard
                );
                break;
            default:
                System.out.println("Jenis barang tidak tersedia.");
                return;
        }
        tambahBarang(barang);
        System.out.println("Barang berhasil ditambahkan.");
        transaksi.catatLog( "Penambahan barang: " + nama
        );
    }
    public void simpanDataKeFile() {
        ObjectOutputStream output = null;
        try {
            FileOutputStream file = new FileOutputStream(  "data_inventaris.dat"
            );
            output = new ObjectOutputStream(file);
            output.writeObject(daftarBarang);
            output.writeObject(dataPetugas);
            System.out.println( "Data barang dan petugas berhasil disimpan."
            );
        } catch (IOException e) {
            System.out.println( "Gagal menyimpan data: " + e.getMessage()
            );
        } finally {
            try {
                if (output != null) {
                    output.close();
                }
            } catch (IOException e) {
                System.out.println("Gagal menutup file.");
            }
        }
    }
    @SuppressWarnings("unchecked")
    public boolean muatDataDariFile() {
        ObjectInputStream objectInput = null;
        try {
            File file = new File("data_inventaris.dat");
            if (!file.exists()) {
                System.out.println( "File data belum tersedia. Menggunakan data awal."
                );
                return false;
            }
            FileInputStream fileInput = new FileInputStream(file);
            objectInput = new ObjectInputStream(fileInput);
            daftarBarang =
                (ArrayList<Barang>) objectInput.readObject();
            dataPetugas =
                (HashMap<String, Petugas>) objectInput.readObject();
            System.out.println( "Data barang dan petugas berhasil dimuat."
            );
            System.out.println( "Jumlah barang: " + daftarBarang.size()
            );
            System.out.println( "Jumlah petugas: " + dataPetugas.size()
            );
            return true;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println( "Gagal memuat data: " + e.getMessage()
            );
            return false;
        } finally {
            try {
                if (objectInput != null) {
                    objectInput.close();
                }
            } catch (IOException e) {
                System.out.println("Gagal menutup file.");
            }
        }
    }
    public void bacaLogTransaksi() {
        File file = new File("log_transaksi.txt");
        System.out.println("\n===== RIWAYAT AKTIVITAS =====");
        Scanner pembaca = null;
        try {
            if (!file.exists()) {
                System.out.println("File log belum tersedia.");
                return;
            }
            pembaca = new Scanner(file);
            if (!pembaca.hasNextLine()) {
                System.out.println("Belum ada aktivitas.");
                return;
            }
            while (pembaca.hasNextLine()) {
                System.out.println(pembaca.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println( "Gagal membaca file: " + e.getMessage()
            );
        } finally {
            if (pembaca != null) {
                pembaca.close();
            }
        }
    }
    private static int bacaAngka() {

        while (true) {
            try {
                int angka = Integer.parseInt(input.nextLine());
                return angka;

            } catch (NumberFormatException e) {
                System.out.print("Masukkan angka yang benar: ");
            }
        }
    }
    public void menuUtama() {

        int pilihan;

        do {
            System.out.println("\n=================================");
            System.out.println("     SISTEM INVENTARIS LABKOM");
            System.out.println("=================================");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Tampilkan Semua Barang");
            System.out.println("3. Cari Barang Berdasarkan Nama");
            System.out.println("4. Cari Barang Berdasarkan Tahun");
            System.out.println("5. Kelola Petugas");
            System.out.println("6. Tampilkan Ruang Penyimpanan");
            System.out.println("7. Proses Peminjaman");
            System.out.println("8. Simpan Data ke File");
            System.out.println("9. Muat Data dari File");
            System.out.println("10. Tampilkan Log Aktivitas");
            System.out.println("11. Simulasi Penggunaan Barang");
            System.out.println("0. Keluar");
            System.out.println("=================================");
            System.out.print("Pilih menu: ");

            pilihan = bacaAngka();
            switch (pilihan) {
                case 1:
                    tambahBarangMenu();
                    break;
                case 2:
                    tampilkanSemuaBarang();
                    break;
                case 3:
                    System.out.print("Masukkan nama barang: ");
                    String nama = input.nextLine();
                    cariBarang(nama);
                    break;
                case 4:
                    System.out.print("Masukkan tahun pembelian: ");
                    int tahun = bacaAngka();
                    cariBarang(tahun);
                    break;
                case 5:
                    kelolaPetugas();
                    break;
                case 6:
                    tampilkanRuang();
                    break;
                case 7:
                    prosesPeminjaman();
                    break;
                case 8:
                    simpanDataKeFile();
                    break;
                case 9:
                    muatDataDariFile();
                    break;
                case 10:
                    bacaLogTransaksi();
                    break;
                case 11:
                    simulasiPenggunaan();
                    break;
                case 0:
                    simpanDataKeFile();
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia.");
            }
        } while (pilihan != 0);
    }
    public static void main(String[] args) {
        InvestarisLabKom sistem = new InvestarisLabKom();
        boolean dataTersedia = sistem.muatDataDariFile();
        if (!dataTersedia) {
            sistem.isiDataAwal();
        }
        sistem.menuUtama();
    }
}