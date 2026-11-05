/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.investarislabkom;

/**
 *
 * @author Ashifa Safitri
 */
public class TransaksiPeminjaman {

    public void prosesTransaksi(Petugas petugas, Barang barang) {

        if (petugas == null || barang == null) {
            System.out.println("Transaksi gagal!");
            return;
        }

        System.out.println("\n===== TRANSAKSI PEMINJAMAN =====");
        System.out.println("ID Petugas : " + petugas.getId());
        System.out.println("Nama       : " + petugas.getNama());
        System.out.println("Barang     : " + barang.getNama());

        if (barang instanceof DapatDipinjam) {
            DapatDipinjam peminjaman = (DapatDipinjam) barang;
            peminjaman.prosesPeminjaman();
        }

        System.out.println("Status     : Transaksi berhasil diproses.");
    }
}