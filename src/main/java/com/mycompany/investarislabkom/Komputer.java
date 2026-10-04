/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.investarislabkom;

/**
 *
 * @author Ashifa Safitri
 */
public class Komputer extends Barang {
    
    private String processor;
    
    public Komputer (
            String nama,
            String merek,
            int tahunPembelian,
            String processor){
        
        super(nama, merek, tahunPembelian);
        this.processor = processor;
    }
    
    @Override
    public void tampilkanInfo() {
        System.out.printf("[Komputer] Nama: %-15s | Merek: %-10s | Tahun: %d | Processor: %s%n", this.nama, this.merek, this.tahunPembelian, this.processor);
    }
    
    @Override
    public void caraPenggunaan() {
        System.out.println("-> Info Penggunaa: Komputer digunakan untuk praktikum, pemrograman, dan kegiatan akademik.");
    }
}

