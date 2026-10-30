/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.investarislabkom;

/**
 *
 * @author Ashifa Safitri
 */
public class Komputer extends Barang implements DapatDinilai {

    private String processor;

    public Komputer(String nama, String merek, int tahunPembelian, String processor) {
        super(nama, merek, tahunPembelian);
        this.processor = processor;
    }

    @Override
    public void cekKondisi() {
        System.out.println("Kondisi komputer: periksa processor dan pastikan komputer dapat menyala.");
    }

    @Override
    public void beriPenilaian() {
        System.out.println("Penilaian komputer: periksa kinerja processor dan kondisi perangkat.");
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Nama Barang      : " + getNama());
        System.out.println("Merek            : " + merek);
        System.out.println("Tahun Pembelian  : " + getTahunPembelian());
        System.out.println("Processor        : " + processor);
    }

    @Override
    public void caraPenggunaan() {
        System.out.println("Komputer digunakan untuk menjalankan aplikasi dan mengolah data.");
    }
}
