/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.investarislabkom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Ashifa Safitri
 */
public class InvestarisLabKom {
    static Scanner input = new Scanner(System.in);
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
    public void tambahBarang(Barang barang) {
        daftarBarang.add(barang);
    }
    public void tampilkanSemuaBarang() {
        if (daftarBarang.isEmpty()) {
            System.out.println("Belum ada barang.");
            return;
        }
        System.out.println("\n===== DAFTAR INVENTARIS =====");
        for (int i = 0; i < daftarBarang.size(); i++) {
            System.out.println("\nBarang ke-" + (i + 1));
            Barang barang = daftarBarang.get(i);
            barang.tampilkanInfo();
            simulasiPenggunaan(barang);
            prosesFiturBarang(barang);
        }
        System.out.println("\nTotal barang berhasil dibuat: "
                + Barang.totalBarangBerhasilDibuat);
        System.out.println("Jumlah barang dalam inventaris: "
                + daftarBarang.size());
    }
    public void cariBarang(String nama) throws InventarisException {
        if (nama.trim().isEmpty()) {
            throw new InventarisException("Nama barang tidak boleh kosong!");
        }
        boolean ditemukan = false;
        for (Barang barang : daftarBarang) {
            if (barang.getNama().equalsIgnoreCase(nama)) {
                barang.tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            throw new InventarisException("Barang dengan nama " + nama + " tidak ditemukan.");
        }
    }
    public void cariBarang(int tahun) throws InventarisException {
        boolean ditemukan = false;
        for (Barang barang : daftarBarang) {
            if (barang.getTahunPembelian() == tahun) {
                barang.tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            throw new InventarisException("Barang dari tahun " + tahun + " tidak ditemukan.");
        }
    }
    public void simulasiPenggunaan(Barang item) {
        item.caraPenggunaan();
    }
    public void prosesFiturBarang(Barang item) {
        item.cekKondisi();
        if (item instanceof DapatDinilai) {
            DapatDinilai penilaian = (DapatDinilai) item;
            penilaian.beriPenilaian();
        }
        if (item instanceof DapatDipinjam) {
            DapatDipinjam peminjaman = (DapatDipinjam) item;
            peminjaman.prosesPeminjaman();
        }
    }
    public void tambahPetugas(Petugas petugas)
            throws InventarisException {
        if (dataPetugas.containsKey(petugas.getId())) {
            throw new InventarisException(
                    "ID petugas sudah terdaftar!");
        }
        dataPetugas.put(petugas.getId(), petugas);
        System.out.println("Petugas berhasil ditambahkan!");
    }
    public Petugas cariPetugas(String id)
            throws InventarisException {
        Petugas petugas = dataPetugas.get(id);
        if (petugas == null) {
            throw new InventarisException("Petugas dengan ID tersebut tidak ditemukan!");
        }
        return petugas;
    }
    public void tampilkanSemuaPetugas() {
        if (dataPetugas.isEmpty()) {
            System.out.println("Belum ada data petugas.");
            return;
        }
        System.out.println("\n===== DAFTAR PETUGAS =====");
        System.out.println("Jumlah petugas: " + dataPetugas.size());
        for (String id : dataPetugas.keySet()) {
            System.out.println();
            dataPetugas.get(id).tampilkanInfo();
        }
    }
    public void kelolaPetugas() throws InventarisException {
        System.out.println("\n===== KELOLA PETUGAS LABKOM =====");
        System.out.println("1. Tambah Petugas");
        System.out.println("2. Cari Petugas");
        System.out.println("3. Tampilkan Semua Petugas");
        System.out.print("Pilih menu: ");
        int pilihan = input.nextInt();
        input.nextLine();
        switch (pilihan) {
            case 1:
                System.out.print("Masukkan ID petugas: ");
                String id = input.nextLine();
                System.out.print("Masukkan nama petugas: ");
                String nama = input.nextLine();
                System.out.print("Masukkan jabatan: ");
                String jabatan = input.nextLine();
                if (id.trim().isEmpty()
                        || nama.trim().isEmpty()
                        || jabatan.trim().isEmpty()) {
                    throw new InventarisException("Data petugas tidak boleh kosong!");
                }
                tambahPetugas(new Petugas(id, nama, jabatan));
                break;
            case 2:
                System.out.print("Masukkan ID petugas: ");
                String idCari = input.nextLine();
                Petugas hasil = cariPetugas(idCari);
                hasil.tampilkanInfo();
                break;
            case 3:
                tampilkanSemuaPetugas();
                break;
            default:
                throw new InventarisException("Pilihan menu petugas tidak valid!");
        }
    }
    public void tampilkanRuang() {
        ruang.tampilkanInfo();
    }
    public void prosesPeminjaman() throws InventarisException {
        System.out.print("Masukkan ID petugas: ");
        String id = input.nextLine();
        System.out.print("Masukkan nama barang: ");
        String namaBarang = input.nextLine();
        Petugas petugas = cariPetugas(id);
        Barang barangDitemukan = null;
        for (Barang barang : daftarBarang) {
            if (barang.getNama().equalsIgnoreCase(namaBarang)) {
                barangDitemukan = barang;
                break;
            }
        }

        if (barangDitemukan == null) {
            throw new InventarisException("Barang tidak ditemukan!");
        }

        transaksi.prosesTransaksi(petugas, barangDitemukan);
    }
    public static void main(String[] args) {
        InvestarisLabKom sistem = new InvestarisLabKom();
        Barang b1 = new Komputer("Komputer Lab 1", "Lenovo", 2023, "Intel i5");
        Barang b2 = new Komputer("Komputer Lab 2", "Asus", 2024, "Intel i7");
        Barang b3 = new Monitor("Monitor Lab 1", "Samsung", 2023, 24);
        Barang b4 = new Printer("Printer Lab", "Epson", 2022, "Inkjet");
        Barang b5 = new Keyboard("Keyboard Lab 1", "Logitech", 2024, "Mechanical");
        
        sistem.tambahBarang(b1);
        sistem.tambahBarang(b2);
        sistem.tambahBarang(b3);
        sistem.tambahBarang(b4);
        sistem.tambahBarang(b5);
        
        Petugas p1 = new Petugas("PT001", "Andi", "Admin");
        Petugas p2 = new Petugas("PT002", "Budi", "Teknisi");
        Petugas p3 = new Petugas("PT003", "Citra", "Manager");
        try {
            sistem.tambahPetugas(p1);
            sistem.tambahPetugas(p2);
            sistem.tambahPetugas(p3);
        } catch (InventarisException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\n===== DATA AWAL INVENTARIS =====");
        sistem.tampilkanSemuaBarang();
        sistem.tampilkanSemuaPetugas();
        sistem.tampilkanRuang();
        try {
            System.out.println("\n===== SIMULASI TRANSAKSI =====");
            sistem.transaksi.prosesTransaksi(p1, b1);
        } catch (Exception e) {
            System.out.println("Transaksi gagal: " + e.getMessage());
        }

        sistem.menuUtama();
    }
    public void menuUtama() {
        boolean berjalan = true;
        while (berjalan) {
            try {
                System.out.println("\n===== SISTEM INVENTARIS LABKOM =====");
                System.out.println("1. Tambah Barang");
                System.out.println("2. Tampilkan Semua Barang");
                System.out.println("3. Cari Barang Berdasarkan Nama");
                System.out.println("4. Cari Barang Berdasarkan Tahun");
                System.out.println("5. Kelola Petugas Labkom");
                System.out.println("6. Tampilkan Ruang Penyimpanan");
                System.out.println("7. Transaksi Peminjaman");
                System.out.println("8. Keluar");
                System.out.print("Pilih menu: ");
                int pilihan = input.nextInt();
                input.nextLine();
                switch (pilihan) {
                    case 1:
                        tambahBarangMenu();
                        break;
                    case 2:
                        tampilkanSemuaBarang();
                        break;
                    case 3:
                        System.out.print("Masukkan nama barang: ");
                        String namaCari = input.nextLine();
                        cariBarang(namaCari);
                        break;
                    case 4:
                        System.out.print("Masukkan tahun pembelian: ");
                        int tahunCari = input.nextInt();
                        input.nextLine();
                        cariBarang(tahunCari);
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
                        berjalan = false;
                        System.out.println("Program inventaris selesai.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            } catch (InputMismatchException e) {
                System.out.println(
                        "Kesalahan: Input harus sesuai tipe data!");
                input.nextLine();
            } catch (InventarisException e) {
                System.out.println("Kesalahan: " + e.getMessage());
            } finally {
                System.out.println("Proses menu selesai.");
            }
        }
    }

    public void tambahBarangMenu() throws InventarisException {
        System.out.println("\n===== TAMBAH BARANG =====");
        System.out.println("1. Komputer");
        System.out.println("2. Monitor");
        System.out.println("3. Printer");
        System.out.println("4. Keyboard");
        System.out.print("Pilih jenis barang: ");
        int jenis = input.nextInt();
        input.nextLine();
        if (jenis < 1 || jenis > 4) {
            throw new InventarisException("Jenis barang tidak valid!");
        }
        System.out.print("Nama barang: ");
        String nama = input.nextLine();
        System.out.print("Merek: ");
        String merek = input.nextLine();
        System.out.print("Tahun pembelian: ");
        int tahun = input.nextInt();
        input.nextLine();
        if (nama.trim().isEmpty() || merek.trim().isEmpty()
                || tahun <= 0) {
            throw new InventarisException("Data barang tidak valid!");
        }
        Barang barangBaru;
        switch (jenis) {
            case 1:
                System.out.print("Processor: ");
                String processor = input.nextLine();
                barangBaru = new Komputer(nama, merek, tahun, processor);
                break;
            case 2:
                System.out.print("Ukuran layar (inch): ");
                int ukuran = input.nextInt();
                input.nextLine();
                barangBaru = new Monitor(nama, merek, tahun, ukuran);
                break;
            case 3:
                System.out.print("Jenis printer: ");
                String jenisPrinter = input.nextLine();

                barangBaru = new Printer(nama, merek, tahun, jenisPrinter);
                break;
            default:
                System.out.print("Jenis keyboard: ");
                String jenisKeyboard = input.nextLine();

                barangBaru = new Keyboard(
                        nama, merek, tahun, jenisKeyboard);
                break;
        }
        tambahBarang(barangBaru);
        System.out.println("Barang berhasil ditambahkan!");
    }
}