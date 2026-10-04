/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.investarislabkom;

/**
 *
 * @author Ashifa Safitri
 */
public class Monitor extends Barang {
    
    private int ukuranLayar;
    
    public Monitor(
            String nama,
            String merek,
            int tahunPembelian,
            int ukuranLayar) {
        
        super(nama, merek, tahunPembelian);
        this.ukuranLayar = ukuranLayar;
    }
    
    @Override
    public void tampilkanInfo() {
        System.out.printf("[Monitor]   Nama: %-15s | Merek: %-10s | Tahun: %d | Ukuran: %d Inch%n", this.nama, this.merek, this.tahunPembelian, this.ukuranLayar);
    }
    
    @Override
    public void caraPenggunaan() {
        System.out.println("-> Info Penggunaan: Monitor digunakan sebagai perangkat output untuk menampilkan tampilan komputer.");
    }
    
}
