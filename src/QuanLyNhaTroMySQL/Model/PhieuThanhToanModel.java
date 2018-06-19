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
public class PhieuThanhToanModel {
    private String maPTT;
    private String maPDK;
    private int soThang;
    private String ngayTT;
    private float tongTien;
    private float tienPhaiTra;
    private String nam;
    private String Thang;
    private String tongDoanhThuTheoNam;
    private String tongDoanhThuTheoNamVaThang;

    public PhieuThanhToanModel() {
    }

    public PhieuThanhToanModel(String maPTT, String maPDK, int soThang, String ngayTT, float tongTien, float tienPhaiTra, String nam, String Thang, String tongDoanhThuTheoNam, String tongDoanhThuTheoNamVaThang) {
        this.maPTT = maPTT;
        this.maPDK = maPDK;
        this.soThang = soThang;
        this.ngayTT = ngayTT;
        this.tongTien = tongTien;
        this.tienPhaiTra = tienPhaiTra;
        this.nam = nam;
        this.Thang = Thang;
        this.tongDoanhThuTheoNam = tongDoanhThuTheoNam;
        this.tongDoanhThuTheoNamVaThang = tongDoanhThuTheoNamVaThang;
    }

    public String getMaPTT() {
        return maPTT;
    }

    public void setMaPTT(String maPTT) {
        this.maPTT = maPTT;
    }

    public String getMaPDK() {
        return maPDK;
    }

    public void setMaPDK(String maPDK) {
        this.maPDK = maPDK;
    }

    public int getSoThang() {
        return soThang;
    }

    public void setSoThang(int soThang) {
        this.soThang = soThang;
    }

    public String getNgayTT() {
        return ngayTT;
    }

    public void setNgayTT(String ngayTT) {
        this.ngayTT = ngayTT;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public float getTienPhaiTra() {
        return tienPhaiTra;
    }

    public void setTienPhaiTra(float tienPhaiTra) {
        this.tienPhaiTra = tienPhaiTra;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public String getThang() {
        return Thang;
    }

    public void setThang(String Thang) {
        this.Thang = Thang;
    }

    public String getTongDoanhThuTheoNam() {
        return tongDoanhThuTheoNam;
    }

    public void setTongDoanhThuTheoNam(String tongDoanhThuTheoNam) {
        this.tongDoanhThuTheoNam = tongDoanhThuTheoNam;
    }

    public String getTongDoanhThuTheoNamVaThang() {
        return tongDoanhThuTheoNamVaThang;
    }

    public void setTongDoanhThuTheoNamVaThang(String tongDoanhThuTheoNamVaThang) {
        this.tongDoanhThuTheoNamVaThang = tongDoanhThuTheoNamVaThang;
    }

}
