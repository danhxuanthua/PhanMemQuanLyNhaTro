/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyNhaTroMySQL.Service;

import QuanLyNhaTroMySQL.Model.KhachHangModel;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetImpl;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DanhThua
 */
public class KhachHangService extends KetNoiService{
    private Connection ketNoi = getKetNoiService();
    
    public ArrayList<KhachHangModel> layToanBoKhachHang(){
        ArrayList<KhachHangModel> khachHangModels = null;
        try {
            String sqlKhachHang = "select * from KhachHang";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sqlKhachHang);
            ResultSetImpl resultSetImpl = (ResultSetImpl) preparedStatement.executeQuery();
            khachHangModels = new ArrayList<>();
            while (resultSetImpl.next()) {                
                KhachHangModel khachHangModel = new KhachHangModel();
                khachHangModel.setMaKhachHang(resultSetImpl.getString(1));
                khachHangModel.setTenKhachHang(resultSetImpl.getString(2));
                khachHangModel.setNamSinh(resultSetImpl.getDate(3)+"");
                khachHangModel.setcMND(resultSetImpl.getInt(4));
                khachHangModel.setDiaChi(resultSetImpl.getString(5));
                khachHangModel.setNgheNghiep(resultSetImpl.getString(6));
                khachHangModel.setsDT(resultSetImpl.getInt(7));
                khachHangModels.add(khachHangModel);
            }
            
        } catch (SQLException e) {
        }
        return khachHangModels;
    }//lay toan bo danh sach khach hang trong database
    
    public ArrayList<KhachHangModel> layThongTinTungKhachHang(String maKhachHang){
        ArrayList<KhachHangModel> khachHangModels = null;
        try {
            String sqlKhachHang = "select * from KhachHang where MaKH=?";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sqlKhachHang);
            
            preparedStatement.setString(1, maKhachHang);
            ResultSetImpl resultSetImpl = (ResultSetImpl) preparedStatement.executeQuery();
            
            khachHangModels = new ArrayList<>();
            while (resultSetImpl.next()) {                
                KhachHangModel khachHangModel = new KhachHangModel();
                khachHangModel.setMaKhachHang(resultSetImpl.getString(1));
                khachHangModel.setTenKhachHang(resultSetImpl.getString(2));
                khachHangModel.setNamSinh(resultSetImpl.getDate(3)+"");
                khachHangModel.setcMND(resultSetImpl.getInt(4));
                khachHangModel.setDiaChi(resultSetImpl.getString(5));
                khachHangModel.setNgheNghiep(resultSetImpl.getString(6));
                khachHangModel.setsDT(resultSetImpl.getInt(7));
                khachHangModels.add(khachHangModel);
            }
        } catch (SQLException e) {
        }
        return khachHangModels;
    }//lay thong tin chi tiet tung khach hang dau vao textfiel
    
    public int themKhachHang(String maKH, String tenKH, String namSinh, int cMND, String diaChi, String ngheNghiep, int sDT){
        try {
            String sql = "insert into KhachHang values(?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sql);
            
            preparedStatement.setString(1, maKH);
            preparedStatement.setString(2, tenKH);
            preparedStatement.setDate(3, Date.valueOf(namSinh));
            preparedStatement.setInt(4, cMND);
            preparedStatement.setString(5, diaChi);
            preparedStatement.setString(6, ngheNghiep);
            preparedStatement.setInt(7, sDT);
            
            int x = preparedStatement.executeUpdate();
            if (x>0){
                return x;
            }
        } catch (SQLException e) {
        }
        return 0;
    }//them khach hang
    
    public boolean kiemTraKhachHangDaTonTai(String maKH){
        try {
            String sql = "select * from KhachHang where MaKH=?";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sql);
            preparedStatement.setString(1, maKH);
            
            ResultSetImpl resultSetImpl = (ResultSetImpl) preparedStatement.executeQuery();
            if(resultSetImpl.next()){
                return true;//neu ton tai
            }
        } catch (SQLException e) {
        }
        return false;//neu khong ton tai
    }//Kiem tra KH da ton tai
    
    public int SuaKhachHang(String maKH, String tenKH, String namSinh, int cMND, String diaChi, String ngheNghiep, int sDT){
        try {
            String sql = "UPDATE khachhang SET TenKH=?, NamSinh=?, CMND=?, DiaChi=?, NgheNghiep=?, SDT=? WHERE MaKH=?";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sql);
            preparedStatement.setString(1, tenKH);
            preparedStatement.setDate(2, Date.valueOf(namSinh));
            preparedStatement.setInt(3, cMND);
            preparedStatement.setString(4, diaChi);
            preparedStatement.setString(5, ngheNghiep);
            preparedStatement.setInt(6, sDT);
            preparedStatement.setString(7, maKH);
            int x = preparedStatement.executeUpdate();
            if(x>0){
                return x;
            }
        } catch (SQLException e) {
        }
        
        return 0;
    }//sua thong tin khach hang
    
    public int xoaKhachHang(String maKH){
        try {
            String sql ="delete from KhachHang where MaKH=?";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sql);
            preparedStatement.setString(1, maKH);
            int x = preparedStatement.executeUpdate();
            if (x > 0){
                return x;
            }
        } catch (SQLException e) {
        }
        return 0;
    }//xoa khach hang
    
    public ArrayList<KhachHangModel> timKiemKhachHang(String timKiem){
        ArrayList<KhachHangModel> khachHangModels = null;
        try {
            String sql ="select * from KhachHang where MaKH like '%"+timKiem +"%' or TenKH like '%"+timKiem+"%' or DiaChi like '%"+timKiem+"%'";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sql);
            ResultSetImpl resultSetImpl = (ResultSetImpl) preparedStatement.executeQuery();
            
            khachHangModels = new ArrayList<>();
            while (resultSetImpl.next()) {                
                KhachHangModel khachHangModel = new KhachHangModel();
                khachHangModel.setMaKhachHang(resultSetImpl.getString(1));
                khachHangModel.setTenKhachHang(resultSetImpl.getString(2));
                khachHangModel.setNamSinh(resultSetImpl.getDate(3)+"");
                khachHangModel.setcMND(resultSetImpl.getInt(4));
                khachHangModel.setDiaChi(resultSetImpl.getString(5));
                khachHangModel.setNgheNghiep(resultSetImpl.getString(6));
                khachHangModel.setsDT(resultSetImpl.getInt(7));
                khachHangModels.add(khachHangModel);
            }
        } catch (SQLException e) {
        }
        return khachHangModels;
    }//xu ly tim kiem khach hang
    
}
