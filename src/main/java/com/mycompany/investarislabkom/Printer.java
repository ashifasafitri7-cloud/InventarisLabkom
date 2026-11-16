/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.investarislabkom;

/**
 *
 * @author Ashifa Safitri
 */
public class Printer extends Barang implements DapatDipinjam, DapatDinilai {

    private String jenisPrinter;

    public Printer(String nama, String merek,
                   int tahunPembelian, String jenisPrinter) {
        super(nama, merek, tahunPembelian);
        this.jenisPrinter = jenisPrinter;
    }
    @Override
    public void cekKondisi() {
        System.out.println("Kondisi printer: Baik.");
        System.out.println("Jenis printer: " + jenisPrinter);
    }
    @Override
    public void prosesPeminjaman() {
        System.out.println("Printer berhasil diproses untuk peminjaman.");
    }
    @Override
    public void beriPenilaian() {
        System.out.println("Penilaian printer: 8/10.");
    }
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Jenis Printer: " + jenisPrinter);
    }
}
