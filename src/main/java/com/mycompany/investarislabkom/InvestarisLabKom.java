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

    public static void cariBarang(
            String nama,
            Barang[] daftarBarang,
            int jumlahBarang) {

        System.out.println(
                "Mencari barang dengan Nama (Teks): " + nama
        );

        boolean ditemukan = false;

        for (int i = 0; i < jumlahBarang; i++) {

            if (daftarBarang[i]
                    .getNama()
                    .equalsIgnoreCase(nama)) {

                daftarBarang[i].tampilkanInfo();
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Barang tidak ditemukan.");
        }
    }

    public static void cariBarang(
            int tahunPembelian,
            Barang[] daftarBarang,
            int jumlahBarang) {

        System.out.println(
                "Mencari barang dengan Tahun Pembelian: "
                + tahunPembelian
        );

        boolean ditemukan = false;

        for (int i = 0; i < jumlahBarang; i++) {

            if (daftarBarang[i]
                    .getTahunPembelian() == tahunPembelian) {

                daftarBarang[i].tampilkanInfo();
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Barang tidak ditemukan.");
        }
    }

    public static void simulasiPenggunaan(Barang item) {
        item.caraPenggunaan();
    }

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            Barang[] daftarBarang = new Barang[10];

            int jumlahBarang = 0;
            boolean isRunning = true;

            System.out.println("========================================");
            System.out.println("    SELAMAT DATANG DI INVENTARIS LABKOM!");
            System.out.println("========================================");

            while (isRunning) {

                System.out.println("\nMenu Utama:");
                System.out.println("1. Tambah Barang");
                System.out.println("2. Lihat Daftar Barang");
                System.out.println("3. Cari Barang");
                System.out.println("4. Keluar");
                System.out.print("Pilih Menu: 1-4: ");

                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {

                    case 1 -> {

                        if (jumlahBarang < daftarBarang.length) {

                            System.out.println(
                                    "\n-- Pilih Jenis Barang --"
                            );

                            System.out.println(
                                    "1. Komputer"
                            );

                            System.out.println(
                                    "2. Monitor"
                            );

                            System.out.println(
                                    "3. Printer"
                            );

                            System.out.print(
                                    "Pilihan (1/2/3): "
                            );

                            int jenis = scanner.nextInt();
                            scanner.nextLine();

                            System.out.print(
                                    "Masukkan Nama Barang: "
                            );

                            String namaBaru =
                                    scanner.nextLine();

                            System.out.print(
                                    "Masukkan Merek: "
                            );

                            String merekBaru =
                                    scanner.nextLine();

                            System.out.print(
                                    "Masukkan Tahun Pembelian: "
                            );

                            int tahunBaru =
                                    scanner.nextInt();

                            scanner.nextLine();

                            if (jenis == 1) {

                                System.out.print(
                                        "Masukkan Processor: "
                                );

                                String processor =
                                        scanner.nextLine();

                                daftarBarang[jumlahBarang] =
                                        new Komputer(
                                                namaBaru,
                                                merekBaru,
                                                tahunBaru,
                                                processor
                                        );

                            } else if (jenis == 2) {

                                System.out.print(
                                        "Masukkan Ukuran Layar (Inch): "
                                );

                                int ukuran =
                                        scanner.nextInt();

                                scanner.nextLine();

                                daftarBarang[jumlahBarang] =
                                        new Monitor(
                                                namaBaru,
                                                merekBaru,
                                                tahunBaru,
                                                ukuran
                                        );

                            } else if (jenis == 3) {

                                System.out.print(
                                        "Masukkan Jenis Printer: "
                                );

                                String jenisPrinter =
                                        scanner.nextLine();

                                daftarBarang[jumlahBarang] =
                                        new Printer(
                                                namaBaru,
                                                merekBaru,
                                                tahunBaru,
                                                jenisPrinter
                                        );

                            } else {

                                System.out.println(
                                        "Pilihan jenis barang tidak valid."
                                );

                                break;
                            }

                            jumlahBarang++;

                            System.out.println(
                                    "Sukses! Barang berhasil ditambahkan."
                            );

                            System.out.print(
                                    "Tekan Enter untuk melanjutkan..."
                            );

                            scanner.nextLine();

                        } else {

                            System.out.println(
                                    "Maaf, kapasitas inventaris sudah penuh!"
                            );
                        }
                    }

                    case 2 -> {

                        System.out.println(
                                "\n-- Daftar Barang di Labkom --"
                        );

                        if (jumlahBarang == 0) {

                            System.out.println(
                                    "Belum ada barang yang tersimpan."
                            );

                        } else {

                            for (int i = 0;
                                    i < jumlahBarang;
                                    i++) {

                                System.out.print(
                                        (i + 1) + ". "
                                );

                                daftarBarang[i]
                                        .tampilkanInfo();

                                simulasiPenggunaan(
                                        daftarBarang[i]
                                );

                                System.out.println("");
                            }

                            System.out.println(
                                    "\nTotal Barang yang Terdaftar: "
                                    + Barang.totalBarangBerhasilDibuat
                            );
                        }

                        System.out.print(
                                "Tekan Enter untuk melanjutkan..."
                        );

                        scanner.nextLine();
                    }

                    case 3 -> {

                        System.out.println(
                                "\n-- Fitur Cari Barang --"
                        );

                        System.out.println(
                                "1. Cari berdasarkan Nama Barang (String)"
                        );

                        System.out.println(
                                "2. Cari berdasarkan Tahun Pembelian (Integer)"
                        );

                        System.out.print(
                                "Pilih (1/2): "
                        );

                        int modeCari =
                                scanner.nextInt();

                        scanner.nextLine();

                        if (modeCari == 1) {

                            System.out.print(
                                    "Masukkan Nama Barang: "
                            );

                            String kataKunci =
                                    scanner.nextLine();

                            cariBarang(
                                    kataKunci,
                                    daftarBarang,
                                    jumlahBarang
                            );

                        } else if (modeCari == 2) {

                            System.out.print(
                                    "Masukkan Tahun Pembelian: "
                            );

                            int angkaKunci =
                                    scanner.nextInt();

                            scanner.nextLine();

                            cariBarang(
                                    angkaKunci,
                                    daftarBarang,
                                    jumlahBarang
                            );

                        } else {

                            System.out.println(
                                    "Pilihan tidak valid."
                            );
                        }

                        System.out.print(
                                "Tekan Enter untuk melanjutkan..."
                        );

                        scanner.nextLine();
                    }

                    case 4 -> {

                        System.out.println(
                                "Terima kasih telah menggunakan "
                                + "Sistem Inventaris Labkom!"
                        );

                        isRunning = false;
                    }

                    default -> {

                        System.out.println(
                                "Pilihan tidak valid. "
                                + "Silahkan masukkan angka 1-4."
                        );

                        scanner.nextLine();
                    }
                }
            }
        }
    }
}
