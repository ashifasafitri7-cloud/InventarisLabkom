/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.investarislabkom;

import java.util.Scanner;

/**
 *
 * @author Ashifa Safitri
 */
public class InvestarisLabKom {

    static Scanner input = new Scanner(System.in);
    static Barang[] daftarBarang = new Barang[10];
    static int jumlahBarang = 0;

    public static void main(String[] args) {

        int pilihan;

        do {
            System.out.println("\n===== SISTEM INVENTARIS LABKOM =====");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Tampilkan Semua Barang");
            System.out.println("3. Cari Barang Berdasarkan Nama");
            System.out.println("4. Cari Barang Berdasarkan Tahun");
            System.out.println("5. Keluar");
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
                    cariBarang(namaCari, daftarBarang, jumlahBarang);
                    break;

                case 4:
                    System.out.print("Masukkan tahun pembelian: ");
                    int tahunCari = input.nextInt();
                    input.nextLine();
                    cariBarang(tahunCari, daftarBarang, jumlahBarang);
                    break;

                case 5:
                    System.out.println("Program inventaris selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilihan != 5);

        input.close();
    }

    public static void tambahBarang() {

        if (jumlahBarang >= daftarBarang.length) {
            System.out.println("Kapasitas inventaris sudah penuh!");
            return;
        }

        System.out.println("\n===== TAMBAH BARANG =====");
        System.out.println("1. Komputer");
        System.out.println("2. Monitor");
        System.out.println("3. Printer");
        System.out.println("4. Keyboard");
        System.out.print("Pilih jenis barang: ");
        int jenis = input.nextInt();
        input.nextLine();

        System.out.print("Nama barang: ");
        String nama = input.nextLine();

        System.out.print("Merek: ");
        String merek = input.nextLine();

        System.out.print("Tahun pembelian: ");
        int tahun = input.nextInt();
        input.nextLine();

        switch (jenis) {
            case 1:
                System.out.print("Processor: ");
                String processor = input.nextLine();

                daftarBarang[jumlahBarang] =
                        new Komputer(nama, merek, tahun, processor);
                break;

            case 2:
                System.out.print("Ukuran layar (inch): ");
                int ukuranLayar = input.nextInt();
                input.nextLine();

                daftarBarang[jumlahBarang] =
                        new Monitor(nama, merek, tahun, ukuranLayar);
                break;

            case 3:
                System.out.print("Jenis printer: ");
                String jenisPrinter = input.nextLine();

                daftarBarang[jumlahBarang] =
                        new Printer(nama, merek, tahun, jenisPrinter);
                break;

            case 4:
                System.out.print("Jenis keyboard: ");
                String jenisKeyboard = input.nextLine();

                daftarBarang[jumlahBarang] =
                        new Keyboard(nama, merek, tahun, jenisKeyboard);
                break;

            default:
                System.out.println("Jenis barang tidak valid!");
                return;
        }

        jumlahBarang++;
        System.out.println("Barang berhasil ditambahkan!");
    }

    public static void tampilkanSemuaBarang() {

        if (jumlahBarang == 0) {
            System.out.println("Belum ada barang yang ditambahkan.");
            return;
        }

        System.out.println("\n===== DAFTAR INVENTARIS =====");

        for (int i = 0; i < jumlahBarang; i++) {
            System.out.println("\nBarang ke-" + (i + 1));
            daftarBarang[i].tampilkanInfo();
            simulasiPenggunaan(daftarBarang[i]);
            prosesFiturBarang(daftarBarang[i]);
        }

        System.out.println("\nTotal barang berhasil dibuat: "
                + Barang.totalBarangBerhasilDibuat);
    }

    public static void cariBarang(String nama, Barang[] daftarBarang,
                                  int jumlahBarang) {

        boolean ditemukan = false;

        for (int i = 0; i < jumlahBarang; i++) {
            if (daftarBarang[i].getNama().equalsIgnoreCase(nama)) {
                daftarBarang[i].tampilkanInfo();
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Barang dengan nama tersebut tidak ditemukan.");
        }
    }

    public static void cariBarang(int tahun, Barang[] daftarBarang,
                                  int jumlahBarang) {

        boolean ditemukan = false;

        for (int i = 0; i < jumlahBarang; i++) {
            if (daftarBarang[i].getTahunPembelian() == tahun) {
                daftarBarang[i].tampilkanInfo();
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Barang dari tahun tersebut tidak ditemukan.");
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
}
