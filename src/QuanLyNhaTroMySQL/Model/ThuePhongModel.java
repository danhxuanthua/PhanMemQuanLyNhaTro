/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyNhaTroMySQL.Model;

/**
 *
 * @author DanhThua
 */
public class ThuePhongModel{
    private String maPDK;
    private String maKH;
    private String maPhong;
    private String ngayThue;
    private String ngayTra;
    private float traTruoc;
    private float traSau;
    private String chuThich;

    public ThuePhongModel() {
    }

    public ThuePhongModel(String maPDK, String maKH, String maPhong, String ngayThue, String ngayTra, float traTruoc, float traSau, String chuThich) {
        this.maPDK = maPDK;
        this.maKH = maKH;
        this.maPhong = maPhong;
        this.ngayThue = ngayThue;
        this.ngayTra = ngayTra;
        this.traTruoc = traTruoc;
        this.traSau = traSau;
        this.chuThich = chuThich;
    }

    public String getMaPDK() {
        return maPDK;
    }

    public void setMaPDK(String maPDK) {
        this.maPDK = maPDK;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getNgayThue() {
        return ngayThue;
    }

    public void setNgayThue(String ngayThue) {
        this.ngayThue = ngayThue;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }

    public float getTraTruoc() {
        return traTruoc;
    }

    public void setTraTruoc(float traTruoc) {
        this.traTruoc = traTruoc;
    }

    public float getTraSau() {
        return traSau;
    }

    public void setTraSau(float traSau) {
        this.traSau = traSau;
    }

    public String getChuThich() {
        return chuThich;
    }

    public void setChuThich(String chuThich) {
        this.chuThich = chuThich;
    }

}
