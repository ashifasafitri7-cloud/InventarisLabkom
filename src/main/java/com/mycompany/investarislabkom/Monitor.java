/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.investarislabkom;

/**
 *
 * @author Ashifa Safitri
 */
public class Monitor extends Barang implements DapatDipinjam, DapatDinilai {

    private int ukuran;

    public Monitor(String nama, String merek,
                   int tahunPembelian, int ukuran) {
        super(nama, merek, tahunPembelian);
        this.ukuran = ukuran;
    }
    @Override
    public void cekKondisi() {
        System.out.println("Kondisi monitor: Baik.");
        System.out.println("Ukuran: " + ukuran + " inci");
    }
    @Override
    public void prosesPeminjaman() {
        System.out.println("Monitor berhasil diproses untuk peminjaman.");
    }
    @Override
    public void beriPenilaian() {
        System.out.println("Penilaian monitor: 8/10.");
    }
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Ukuran: " + ukuran + " inci");
    }
}
