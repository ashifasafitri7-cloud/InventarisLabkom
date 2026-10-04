package com.mycompany.investarislabkom;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ashifa Safitri
 */
public class Barang {
    
    protected String nama;
    protected String merek;
    protected int tahunPembelian;

    public static int totalBarangBerhasilDibuat = 0;

    public Barang(String nama, String merek, int tahunPembelian) {
        this.nama = nama;
        this.merek = merek;
        this.tahunPembelian = tahunPembelian;

        totalBarangBerhasilDibuat++;
    }

    public String getNama() {
        return this.nama;
    }

    public int getTahunPembelian() {
        return this.tahunPembelian;
    }

    public void tampilkanInfo() {
        System.out.printf(
                "Nama: %-20s | Merek: %-15s | Tahun: %d%n",
                this.nama,
                this.merek,
                this.tahunPembelian
        );
    }

    public void caraPenggunaan() {
        System.out.println(
                "Barang digunakan untuk kebutuhan operasional laboratorium."
        );
    }
}
