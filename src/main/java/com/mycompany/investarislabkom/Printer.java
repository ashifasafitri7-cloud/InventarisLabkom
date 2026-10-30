/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.investarislabkom;

/**
 *
 * @author Ashifa Safitri
 */
public class Printer extends Barang implements DapatDinilai {

    private String jenisPrinter;

    public Printer(String nama, String merek, int tahunPembelian, String jenisPrinter) {
        super(nama, merek, tahunPembelian);
        this.jenisPrinter = jenisPrinter;
    }

    @Override
    public void cekKondisi() {
        System.out.println("Kondisi printer: periksa tinta dan pastikan printer dapat mencetak.");
    }

    @Override
    public void beriPenilaian() {
        System.out.println("Penilaian printer: periksa kualitas hasil cetak dan kondisi tinta.");
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Nama Barang      : " + getNama());
        System.out.println("Merek            : " + merek);
        System.out.println("Tahun Pembelian  : " + getTahunPembelian());
        System.out.println("Jenis Printer    : " + jenisPrinter);
    }

    @Override
    public void caraPenggunaan() {
        System.out.println("Printer digunakan untuk mencetak dokumen ke kertas.");
    }
}
