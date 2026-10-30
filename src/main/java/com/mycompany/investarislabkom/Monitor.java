/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.investarislabkom;

/**
 *
 * @author Ashifa Safitri
 */
public class Monitor extends Barang implements DapatDipinjam {

    private int ukuranLayar;

    public Monitor(String nama, String merek, int tahunPembelian, int ukuranLayar) {
        super(nama, merek, tahunPembelian);
        this.ukuranLayar = ukuranLayar;
    }

    @Override
    public void cekKondisi() {
        System.out.println("Kondisi monitor: periksa layar dan pastikan tampilan terlihat jelas.");
    }

    @Override
    public void prosesPeminjaman() {
        System.out.println("Peminjaman monitor sedang diproses oleh petugas laboratorium.");
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Nama Barang      : " + getNama());
        System.out.println("Merek            : " + merek);
        System.out.println("Tahun Pembelian  : " + getTahunPembelian());
        System.out.println("Ukuran Layar     : " + ukuranLayar + " inch");
    }

    @Override
    public void caraPenggunaan() {
        System.out.println("Monitor digunakan untuk menampilkan hasil keluaran komputer.");
    }
}
