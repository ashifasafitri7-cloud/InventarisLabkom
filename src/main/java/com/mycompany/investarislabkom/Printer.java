/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.investarislabkom;

/**
 *
 * @author Ashifa Safitri
 */
public class Printer extends Barang {
    
    private String jenisPrinter;

    public Printer(
            String nama,
            String merek,
            int tahunPembelian,
            String jenisPrinter) {

        super(nama, merek, tahunPembelian);
        this.jenisPrinter = jenisPrinter;
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf(
                "[Printer]   Nama: %-15s | Merek: %-10s | Tahun: %d | Jenis: %s%n", this.nama, this.merek, this.tahunPembelian, this.jenisPrinter);
    }

    @Override
    public void caraPenggunaan() {
        System.out.println("-> Info Penggunaan: Printer digunakan untuk mencetak dokumen dan hasil praktikum.");
    }
}
