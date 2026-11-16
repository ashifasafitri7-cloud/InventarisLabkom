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

    public Keyboard(String nama, String merek,
                    int tahunPembelian, String jenisKeyboard) {
        super(nama, merek, tahunPembelian);
        this.jenisKeyboard = jenisKeyboard;
    }
    @Override
    public void cekKondisi() {
        System.out.println("Kondisi keyboard: Baik.");
        System.out.println("Jenis keyboard: " + jenisKeyboard);
    }
    @Override
    public void prosesPeminjaman() {
        System.out.println("Keyboard berhasil diproses untuk peminjaman.");
    }
    @Override
    public void beriPenilaian() {
        System.out.println("Penilaian keyboard: 9/10.");
    }
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Jenis Keyboard: " + jenisKeyboard);
    }
}