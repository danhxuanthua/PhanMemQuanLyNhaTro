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
public class SuDungModel {
    private String maDV;
    private String maKH;
    private String ngaySD;
    private float giaDV;

    public SuDungModel() {
    }

    public SuDungModel(String maDV, String maKH, String ngaySD, float giaDV) {
        this.maDV = maDV;
        this.maKH = maKH;
        this.ngaySD = ngaySD;
        this.giaDV = giaDV;
    }

    public String getMaDV() {
        return maDV;
    }

    public void setMaDV(String maDV) {
        this.maDV = maDV;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getNgaySD() {
        return ngaySD;
    }

    public void setNgaySD(String ngaySD) {
        this.ngaySD = ngaySD;
    }

    public float getGiaDV() {
        return giaDV;
    }

    public void setGiaDV(float giaDV) {
        this.giaDV = giaDV;
    }
}
