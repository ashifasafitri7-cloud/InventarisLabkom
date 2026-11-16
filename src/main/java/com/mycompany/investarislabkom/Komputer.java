/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.investarislabkom;

/**
 *
 * @author Ashifa Safitri
 */
public class Komputer extends Barang implements DapatDipinjam, DapatDinilai {

    private String processor;

    public Komputer(String nama, String merek,
                    int tahunPembelian, String processor) {
        super(nama, merek, tahunPembelian);
        this.processor = processor;
    }
    @Override
    public void cekKondisi() {
        System.out.println("Kondisi komputer: Baik.");
        System.out.println("Processor: " + processor);
    }
    @Override
    public void prosesPeminjaman() {
        System.out.println("Komputer berhasil diproses untuk peminjaman.");
    }
    @Override
    public void beriPenilaian() {
        System.out.println("Penilaian komputer: 9/10.");
    }
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Processor: " + processor);
    }
}
