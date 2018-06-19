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
public class PhongTroModel {
    private String maPhong;
    private String hienTrangPhon;
    private float giaPhong;

    public PhongTroModel() {
    }

    public PhongTroModel(String maPhong, String hienTrangPhon, float giaPhong) {
        this.maPhong = maPhong;
        this.hienTrangPhon = hienTrangPhon;
        this.giaPhong = giaPhong;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getHienTrangPhon() {
        return hienTrangPhon;
    }

    public void setHienTrangPhon(String hienTrangPhon) {
        this.hienTrangPhon = hienTrangPhon;
    }

    public float getGiaPhong() {
        return giaPhong;
    }

    public void setGiaPhong(float giaPhong) {
        this.giaPhong = giaPhong;
    }
    
    
}
