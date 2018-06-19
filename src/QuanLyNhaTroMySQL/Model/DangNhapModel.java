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
public class DangNhapModel {
    private String tenTaiKhoan;
    private String matKhau;

    public DangNhapModel() {
    }//dafault contructor

    public DangNhapModel(String tenTaiKhoan, String matKhau) {
        this.tenTaiKhoan = tenTaiKhoan;
        this.matKhau = matKhau;
    }// contructor

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }// get TenTaiKhoan

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }//set tenTaiKhoan

    public String getMatKhau() {
        return matKhau;
    }//get matKhau

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }// set matKhau
    
  
}
