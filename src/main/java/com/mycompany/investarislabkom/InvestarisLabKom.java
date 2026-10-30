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
    static ArrayList<Barang> daftarBarang = new ArrayList<>();
    static HashMap<String, String> dataPetugas = new HashMap<>();
    public static void main(String[] args) {
        int pilihan;
        boolean berjalan = true;
        tambahDataAwal();
        while (berjalan) {
            try {
                System.out.println("\n===== SISTEM INVENTARIS LABKOM =====");
                System.out.println("1. Tambah Barang");
                System.out.println("2. Tampilkan Semua Barang");
                System.out.println("3. Cari Barang Berdasarkan Nama");
                System.out.println("4. Cari Barang Berdasarkan Tahun");
                System.out.println("5. Kelola Petugas Labkom");
                System.out.println("6. Keluar");
                System.out.print("Pilih menu: ");
                pilihan = input.nextInt();
                input.nextLine();
                switch (pilihan) {
                    case 1:
                        tambahBarang();
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
                        berjalan = false;
                        System.out.println("Program inventaris selesai.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Kesalahan: Input harus sesuai dengan tipe data!"
                );
                input.nextLine();
            } catch (InventarisException e) {
                System.out.println("Kesalahan: " + e.getMessage());
            } finally {
                System.out.println("Proses menu selesai.");
            }
        }
        input.close();
    }
    public static void tambahDataAwal() {
        daftarBarang.add(
                new Komputer("Komputer Lab 1", "Lenovo", 2023, "Intel i5")
        );
        daftarBarang.add(
                new Komputer("Komputer Lab 2", "Asus", 2024, "Intel i7")
        );
        daftarBarang.add(
                new Monitor("Monitor Lab 1", "Samsung", 2023, 24)
        );
        daftarBarang.add(
                new Printer("Printer Lab", "Epson", 2022, "Inkjet")
        );
        daftarBarang.add(
                new Keyboard("Keyboard Lab 1", "Logitech", 2024, "Mechanical")
        );
        dataPetugas.put("PT001", "Andi");
        dataPetugas.put("PT002", "Budi");
        dataPetugas.put("PT003", "Citra");
    }
    public static void tambahBarang() throws InventarisException {
        System.out.println("\n===== TAMBAH BARANG =====");
        System.out.println("1. Komputer");
        System.out.println("2. Monitor");
        System.out.println("3. Printer");
        System.out.println("4. Keyboard");
        System.out.print("Pilih jenis barang: ");

        int jenis = input.nextInt();
        input.nextLine();
        if (jenis < 1 || jenis > 4) {
            throw new InventarisException("Jenis barang tidak valid!"
            );
        }
        System.out.print("Nama barang: ");
        String nama = input.nextLine();
        if (nama.trim().isEmpty()) {
            throw new InventarisException("Nama barang tidak boleh kosong!"
            );
        }
        System.out.print("Merek: ");
        String merek = input.nextLine();
        if (merek.trim().isEmpty()) {
            throw new InventarisException("Merek barang tidak boleh kosong!"
            );
        }
        System.out.print("Tahun pembelian: ");
        int tahun = input.nextInt();
        input.nextLine();
        if (tahun <= 0) {
            throw new InventarisException("Tahun pembelian harus lebih dari nol!"
            );
        }
        Barang barangBaru;
        switch (jenis) {
            case 1:
                System.out.print("Processor: ");
                String processor = input.nextLine();
                barangBaru = new Komputer(nama, merek, tahun, processor
                );
                break;
            case 2:
                System.out.print("Ukuran layar (inch): ");
                int ukuranLayar = input.nextInt();
                input.nextLine();
                if (ukuranLayar <= 0) {
                    throw new InventarisException( "Ukuran layar harus lebih dari nol!"
                    );
                }
                barangBaru = new Monitor(nama, merek, tahun, ukuranLayar
                );
                break;
            case 3:
                System.out.print("Jenis printer: ");
                String jenisPrinter = input.nextLine();
                barangBaru = new Printer(nama, merek, tahun, jenisPrinter
                );
                break;

            default:
                System.out.print("Jenis keyboard: ");
                String jenisKeyboard = input.nextLine();
                barangBaru = new Keyboard(nama, merek, tahun, jenisKeyboard
                );
                break;
        }
        daftarBarang.add(barangBaru);
        System.out.println("Barang berhasil ditambahkan!");
    }
    public static void tampilkanSemuaBarang() {
        if (daftarBarang.isEmpty()) {
            System.out.println("Belum ada barang yang ditambahkan.");
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
        System.out.println("\nTotal barang berhasil dibuat: " + Barang.totalBarangBerhasilDibuat
        );
        System.out.println("Jumlah barang dalam inventaris: " + daftarBarang.size()
        );
    }
    public static void cariBarang(String nama)throws InventarisException {
        if (nama.trim().isEmpty()) {
            throw new InventarisException("Nama barang yang dicari tidak boleh kosong!"
            );
        }
        boolean ditemukan = false;
        for (Barang barang : daftarBarang) {
            if (barang.getNama().equalsIgnoreCase(nama)) {
                barang.tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            throw new InventarisException("Barang dengan nama " + nama + " tidak ditemukan."
            );
        }
    }
    public static void cariBarang(int tahun) throws InventarisException {

        boolean ditemukan = false;
        for (Barang barang : daftarBarang) {
            if (barang.getTahunPembelian() == tahun) {
                barang.tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            throw new InventarisException("Barang dari tahun " + tahun + " tidak ditemukan."
            );
        }
    }
    public static void simulasiPenggunaan(Barang item) {
        item.caraPenggunaan();
    }
    public static void prosesFiturBarang(Barang item) {
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
    public static void kelolaPetugas() throws InventarisException {
        int pilihanPetugas;
        System.out.println("\n===== KELOLA PETUGAS LABKOM =====");
        System.out.println("1. Tambah Petugas");
        System.out.println("2. Cari Petugas");
        System.out.println("3. Tampilkan Semua Petugas");
        System.out.print("Pilih menu: ");

        pilihanPetugas = input.nextInt();
        input.nextLine();

        switch (pilihanPetugas) {
            case 1:
                tambahPetugas();
                break;
            case 2:
                cariPetugas();
                break;
            case 3:
                tampilkanSemuaPetugas();
                break;
            default:
                throw new InventarisException("Pilihan menu petugas tidak valid!"
                );
        }
    }
    public static void tambahPetugas() throws InventarisException {
        System.out.print("Masukkan ID petugas: ");
        String id = input.nextLine();
        if (id.trim().isEmpty()) {
            throw new InventarisException("ID petugas tidak boleh kosong!"
            );
        }
        if (dataPetugas.containsKey(id)) {
            throw new InventarisException("ID petugas sudah terdaftar!"
            );
        }
        System.out.print("Masukkan nama petugas: ");
        String nama = input.nextLine();
        if (nama.trim().isEmpty()) {
            throw new InventarisException("Nama petugas tidak boleh kosong!"
            );
        }
        dataPetugas.put(id, nama);
        System.out.println("Petugas berhasil ditambahkan!");
    }

    public static void cariPetugas() throws InventarisException {
        System.out.print("Masukkan ID petugas: ");
        String id = input.nextLine();
        if (!dataPetugas.containsKey(id)) {
            throw new InventarisException("Petugas dengan ID tersebut tidak ditemukan!"
            );
        }
        System.out.println("Nama petugas: " + dataPetugas.get(id)
        );
    }

    public static void tampilkanSemuaPetugas() {
        if (dataPetugas.isEmpty()) {
            System.out.println("Belum ada data petugas.");
            return;
        }
        
        System.out.println("\n===== DAFTAR PETUGAS =====");
        System.out.println("Jumlah petugas: " + dataPetugas.size()
        );
        for (String id : dataPetugas.keySet()) {
            System.out.println(
                    "ID Petugas: " + id + " | Nama: " + dataPetugas.get(id)
            );
        }
    }
}
