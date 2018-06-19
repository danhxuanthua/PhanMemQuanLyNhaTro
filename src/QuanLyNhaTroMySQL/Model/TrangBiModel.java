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
public class TrangBiModel {
    private String maPhong;
    private String hienTrangPhong;
    private float giaPhong;
    private String tenThietBi;
    private String maTB;

    public TrangBiModel() {
    }

    public TrangBiModel(String maPhong, String hienTrangPhong, float giaPhong, String tenTrangBi, String maTB) {
        this.maPhong = maPhong;
        this.hienTrangPhong = hienTrangPhong;
        this.giaPhong = giaPhong;
        this.tenThietBi = tenTrangBi;
        this.maTB = maTB;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getHienTrangPhong() {
        return hienTrangPhong;
    }

    public void setHienTrangPhong(String hienTrangPhong) {
        this.hienTrangPhong = hienTrangPhong;
    }

    public float getGiaPhong() {
        return giaPhong;
    }

    public void setGiaPhong(float giaPhong) {
        this.giaPhong = giaPhong;
    }

    public String getTenThietBi() {
        return tenThietBi;
    }

    public void setTenThietBi(String tenThietBi) {
        this.tenThietBi = tenThietBi;
    }

    public String getMaTB() {
        return maTB;
    }

    public void setMaTB(String maTB) {
        this.maTB = maTB;
    }

}
