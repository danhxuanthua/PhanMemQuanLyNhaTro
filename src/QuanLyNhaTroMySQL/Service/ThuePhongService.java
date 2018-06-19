/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyNhaTroMySQL.Service;

import QuanLyNhaTroMySQL.Model.ThuePhongModel;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetImpl;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author DanhThua
 */
public class ThuePhongService extends KetNoiService{
    private Connection ketNoi = getKetNoiService();
    
    public ArrayList<ThuePhongModel> layToanBoPhieuDangKyThuePhong(){
        
        ArrayList<ThuePhongModel> thuePhongModels = null;
        try {
            String sql = "select * from PhieuDangKy";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sql);
            ResultSetImpl resultSetImpl = (ResultSetImpl) preparedStatement.executeQuery();
            
            thuePhongModels = new ArrayList<>();
            while (resultSetImpl.next()) {                
                ThuePhongModel thuePhongModel = new ThuePhongModel();
                thuePhongModel.setMaPDK(resultSetImpl.getString(1));
                thuePhongModel.setMaKH(resultSetImpl.getString(2));
                thuePhongModel.setMaPhong(resultSetImpl.getString(3));
                thuePhongModel.setNgayThue(resultSetImpl.getDate(4)+"");
                thuePhongModel.setNgayTra(resultSetImpl.getDate(5)+"");
                thuePhongModel.setTraTruoc(resultSetImpl.getFloat(6));
                thuePhongModel.setTraSau(resultSetImpl.getFloat(7));
                thuePhongModel.setChuThich(resultSetImpl.getString(8));
                
                thuePhongModels.add(thuePhongModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return thuePhongModels;
    }//Lay danh sach phieu thue phong
    
    public int themPhieuDangKy(String maPDK, String maKH, String maPhong, String ngayThue, String ngayTra, float traTRuoc, float traSau, String chuThich){
        try {
            String sql = "INSERT INTO phieudangky VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sql);
            preparedStatement.setString(1, maPDK);
            preparedStatement.setString(2, maKH);
            preparedStatement.setString(3, maPhong);
            preparedStatement.setDate(4, Date.valueOf(ngayThue));
            preparedStatement.setDate(5, Date.valueOf(ngayTra));
            preparedStatement.setFloat(6, traTRuoc);
            preparedStatement.setFloat(7, traSau);
            preparedStatement.setString(8, chuThich);
           
            int x = preparedStatement.executeUpdate();
            if(x>0){
                return x;   
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }//Them phieu dang ky
    
    public ArrayList<ThuePhongModel> layPhieuDangDangKyThuePhongTheoMa(String maPDK){
        ArrayList<ThuePhongModel> thuePhongModels = null;
        try {
            String sql = "select * from PhieuDangKy where MaPDK=?";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sql);
            preparedStatement.setString(1, maPDK);
            
            ResultSetImpl resultSetImpl = (ResultSetImpl) preparedStatement.executeQuery();
            
            thuePhongModels = new ArrayList<>();
            while (resultSetImpl.next()) {                
                ThuePhongModel thuePhongModel = new ThuePhongModel();
                thuePhongModel.setMaPDK(resultSetImpl.getString(1));
                thuePhongModel.setMaKH(resultSetImpl.getString(2));
                thuePhongModel.setMaPhong(resultSetImpl.getString(3));
                thuePhongModel.setNgayThue(resultSetImpl.getDate(4)+"");
                thuePhongModel.setNgayTra(resultSetImpl.getDate(5)+"");
                thuePhongModel.setTraTruoc(resultSetImpl.getFloat(6));
                thuePhongModel.setTraSau(resultSetImpl.getFloat(7));
                thuePhongModel.setChuThich(resultSetImpl.getString(8));
                
                thuePhongModels.add(thuePhongModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return thuePhongModels;
    }//Lay phieu dang ky thue phong theo ma phieu dang ky
    
    public boolean kiemTraMaPhieuDangKyDaTonTai(String maPDK){
        try {
            String sql = "select * from PhieuDangKy where MaPDK=?";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sql);
            preparedStatement.setString(1, maPDK);
            
            ResultSetImpl resultSetImpl = (ResultSetImpl) preparedStatement.executeQuery();
            
            if(resultSetImpl.next()){
                return true;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }//kiem tra ma phieu dang ky
    
    public int suaPhieuDangKy(String maPDK, String maKH, String maPhong, String ngayThue, String ngayTra, float traTRuoc, float traSau, String chuThich){
        try {
            String sql = "UPDATE phieudangky SET MaKH=?, MaPhong=?, NgayThue=?, NgayTra=?, TraTruoc=?, TraSau=?, ChuThich=? WHERE MaPDK=?";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sql);
            
            preparedStatement.setString(1, maKH);
            preparedStatement.setString(2, maPhong);
            preparedStatement.setDate(3, Date.valueOf(ngayThue));
            preparedStatement.setDate(4, Date.valueOf(ngayTra));
            preparedStatement.setFloat(5, traTRuoc);
            preparedStatement.setFloat(6, traSau);
            preparedStatement.setString(7, chuThich);
            preparedStatement.setString(8, maPDK);
            
            int x = preparedStatement.executeUpdate();
            if (x > 0){
                return x;
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
        
    }//sua phieu dang ky
    
    public int xoaPhieuDangKy(String maPDK){
        try {
            String sql = "DELETE FROM phieudangky WHERE MaPDK=?";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sql);
            preparedStatement.setString(1, maPDK);
            
            int x = preparedStatement.executeUpdate();
            if (x > 0){
                return x;
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }//xoa phieu dang ky
   
    public ArrayList<ThuePhongModel> layPhieuDangKyTheoMaPDK(String maPDK){
        
        ArrayList<ThuePhongModel> thuePhongModels = null;
        try {
            String sql = "select * from PhieuDangKy where MaPDK=?";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sql);
            preparedStatement.setString(1, maPDK);
            ResultSetImpl resultSetImpl = (ResultSetImpl) preparedStatement.executeQuery();
            
            thuePhongModels = new ArrayList<>();
            while (resultSetImpl.next()) {                
                ThuePhongModel thuePhongModel = new ThuePhongModel();
                thuePhongModel.setMaPDK(resultSetImpl.getString(1));
                thuePhongModel.setMaKH(resultSetImpl.getString(2));
                thuePhongModel.setMaPhong(resultSetImpl.getString(3));
                thuePhongModel.setNgayThue(resultSetImpl.getDate(4)+"");
                thuePhongModel.setNgayTra(resultSetImpl.getDate(5)+"");
                thuePhongModel.setTraTruoc(resultSetImpl.getFloat(6));
                thuePhongModel.setTraSau(resultSetImpl.getFloat(7));
                thuePhongModel.setChuThich(resultSetImpl.getString(8));
                
                thuePhongModels.add(thuePhongModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return thuePhongModels;
    }//Lay phieu dang ky thue phong theo maPDK
}
