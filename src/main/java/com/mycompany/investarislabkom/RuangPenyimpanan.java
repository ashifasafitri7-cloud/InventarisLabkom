/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.investarislabkom;

import java.io.Serializable;

/**
 *
 * @author Ashifa Safitri
 */
public class RuangPenyimpanan implements Serializable {
    private static final long serialVersionUID = 1L;

    private String namaRuang;
    private String lokasi;
    private int kapasitas;
    
    public RuangPenyimpanan() {
        namaRuang = "Ruang Penyimpanan Labkom";
        lokasi = "Lantai 2";
        kapasitas = 50;
    }
    public void tampilkanInfo() {
        System.out.println("\n===== INFORMASI RUANG PENYIMPANAN =====");
        System.out.println("Nama Ruangan : " + namaRuang);
        System.out.println("Lokasi       : " + lokasi);
        System.out.println("Kapasitas    : " + kapasitas + " barang");
    }
}
