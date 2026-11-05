/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.investarislabkom;

/**
 *
 * @author Ashifa Safitri
 */
public class Petugas {

    private String id;
    private String nama;
    private String jabatan;

    public Petugas(String id, String nama, String jabatan) {
        this.id = id;
        this.nama = nama;
        this.jabatan = jabatan;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void tampilkanInfo() {
        System.out.println("ID Petugas : " + id);
        System.out.println("Nama       : " + nama);
        System.out.println("Jabatan    : " + jabatan);
    }
}