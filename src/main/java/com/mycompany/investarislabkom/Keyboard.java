/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.investarislabkom;

/**
 *
 * @author Ashifa Safitri
 */
public class Keyboard extends Barang implements DapatDinilai, DapatDipinjam {

    private String jenisKeyboard;

    public Keyboard(String nama, String merek, int tahunPembelian, String jenisKeyboard) {
        super(nama, merek, tahunPembelian);
        this.jenisKeyboard = jenisKeyboard;
    }

    @Override
    public void cekKondisi() {
        System.out.println("Kondisi keyboard: periksa tombol dan pastikan keyboard berfungsi.");
    }

    @Override
    public void beriPenilaian() {
        System.out.println("Penilaian keyboard: periksa respons tombol dan kenyamanan penggunaan.");
    }

    @Override
    public void prosesPeminjaman() {
        System.out.println("Peminjaman keyboard sedang diproses oleh petugas laboratorium.");
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Nama Barang      : " + getNama());
        System.out.println("Merek            : " + merek);
        System.out.println("Tahun Pembelian  : " + getTahunPembelian());
        System.out.println("Jenis Keyboard   : " + jenisKeyboard);
    }

    @Override
    public void caraPenggunaan() {
        System.out.println("Keyboard digunakan untuk memasukkan karakter melalui tombol.");
    }
}