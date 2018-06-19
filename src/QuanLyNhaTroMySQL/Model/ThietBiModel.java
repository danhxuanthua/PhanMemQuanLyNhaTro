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
public class ThietBiModel {
    private String maThietBi;
    private String tenThietBi;

    public ThietBiModel() {
    }//default constructor

    public ThietBiModel(String maThietBi, String tenThietBi) {
        this.maThietBi = maThietBi;
        this.tenThietBi = tenThietBi;
    }

    public String getMaThietBi() {
        return maThietBi;
    }

    public void setMaThietBi(String maThietBi) {
        this.maThietBi = maThietBi;
    }

    public String getTenThietBi() {
        return tenThietBi;
    }

    public void setTenThietBi(String tenThietBi) {
        this.tenThietBi = tenThietBi;
    }
 
}
