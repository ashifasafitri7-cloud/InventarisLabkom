/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.investarislabkom;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

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
            catatLog("Peminjaman barang: " + barang.getNama()
                    + " oleh " + petugas.getNama());
            System.out.println("Status     : Transaksi berhasil diproses.");
        } else {
            System.out.println("Barang tidak dapat dipinjam.");
        }
    }
    public void catatLog(String aktivitas) {
        FileWriter writer = null;
        try {
            writer = new FileWriter("log_transaksi.txt", true);

            writer.write(
                LocalDateTime.now() + " - " + aktivitas
                + System.lineSeparator()
            );
            System.out.println("Aktivitas berhasil dicatat ke log.");

        } catch (IOException e) {
            System.out.println("Gagal mencatat log: " + e.getMessage());

        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("Gagal menutup file log.");
            }
        }
    }
}