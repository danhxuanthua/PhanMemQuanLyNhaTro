/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyNhaTroMySQL.Service;

import QuanLyNhaTroMySQL.Model.PhieuThanhToanModel;
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
public class PhieuThanhToanSevice extends KetNoiService{
    private Connection ketNoi = getKetNoiService();
    public ArrayList<PhieuThanhToanModel> layToanBoPhieuThanhToan(){
        ArrayList<PhieuThanhToanModel> phieuThanhToanModels = null;
        try {
            String sql = "select * from PhieuThanhToan";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sql);
            ResultSetImpl resultSetImpl = (ResultSetImpl) preparedStatement.executeQuery();
            
            phieuThanhToanModels = new ArrayList<>();
            while (resultSetImpl.next()) {                
                PhieuThanhToanModel phieuThanhToanModel = new PhieuThanhToanModel();
                phieuThanhToanModel.setMaPTT(resultSetImpl.getString(1));
                phieuThanhToanModel.setMaPDK(resultSetImpl.getString(2));
                phieuThanhToanModel.setSoThang(resultSetImpl.getInt(3));
                phieuThanhToanModel.setNgayTT(resultSetImpl.getDate(4)+"");
                phieuThanhToanModel.setTongTien(resultSetImpl.getFloat(5));
                phieuThanhToanModel.setTienPhaiTra(resultSetImpl.getFloat(6));
                phieuThanhToanModels.add(phieuThanhToanModel);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phieuThanhToanModels;
        
    }//Hien thi toan bo phieu thanh toan
    
    public int themPhieuThanhToan(String maPTT, String maPDK, int soThang, String ngayTT, float tongTien, float tienPhaiTra){
        try {
            String sql = "insert into PhieuThanhToan values(?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sql);
            preparedStatement.setString(1, maPTT);
            preparedStatement.setString(2, maPDK);
            preparedStatement.setInt(3, soThang);
            preparedStatement.setDate(4, Date.valueOf(ngayTT));
            preparedStatement.setFloat(5, tongTien);
            preparedStatement.setFloat(6, tienPhaiTra);
            
            int x = preparedStatement.executeUpdate();
            if(x>0){
                return x;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return 0;
    }//them phieuTT
    
    public boolean kiemTraPTTDaTonTai(String maPTT){
        try {
            String sql = "select * from PhieuThanhToan where MaPTT=?";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sql);
            preparedStatement.setString(1, maPTT);
                        
            ResultSetImpl resultSetImpl = (ResultSetImpl) preparedStatement.executeQuery();
            if(resultSetImpl.next()){
                return true;//da ton tai
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;//Chua ton tai
    }//kiem tra PTT 
    
    public ArrayList<PhieuThanhToanModel> layThangNamThanhToanLoaiBoTrungLap(){
        ArrayList<PhieuThanhToanModel> phieuThanhToanModels = null;
        try {
            String sql = "SELECT DISTINCT YEAR(NgayTT) as Nam, MONTH(NgayTT) as Thang FROM phieuthanhtoan";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sql);
            ResultSetImpl resultSetImpl = (ResultSetImpl) preparedStatement.executeQuery();
            
            phieuThanhToanModels = new ArrayList<>();
            while (resultSetImpl.next()) {                
                PhieuThanhToanModel phieuThanhToanModel = new PhieuThanhToanModel();
                phieuThanhToanModel.setNam(resultSetImpl.getString("Nam"));
                phieuThanhToanModel.setThang(resultSetImpl.getString("Thang"));
                phieuThanhToanModels.add(phieuThanhToanModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phieuThanhToanModels;
    }//lay thang nam thanh toan, loai bo trung lap
    
    public ArrayList<PhieuThanhToanModel> layPhieuTTTheoNamVaThang(String nam, String thang) {
        ArrayList<PhieuThanhToanModel> phieuThanhToanModels = null;
        try {
            String sql = "SELECT * FROM phieuthanhtoan WHERE NgayTT like '%" + nam + "%-%" + thang + "%'";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sql);
            ResultSetImpl resultSetImpl = (ResultSetImpl) preparedStatement.executeQuery();

            phieuThanhToanModels = new ArrayList<>();
            while (resultSetImpl.next()) {
                PhieuThanhToanModel phieuThanhToanModel = new PhieuThanhToanModel();
                phieuThanhToanModel.setMaPTT(resultSetImpl.getString(1));
                phieuThanhToanModel.setMaPDK(resultSetImpl.getString(2));
                phieuThanhToanModel.setSoThang(resultSetImpl.getInt(3));
                phieuThanhToanModel.setNgayTT(resultSetImpl.getDate(4) + "");
                phieuThanhToanModel.setTongTien(resultSetImpl.getFloat(5));
                phieuThanhToanModel.setTienPhaiTra(resultSetImpl.getFloat(6));
                phieuThanhToanModels.add(phieuThanhToanModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phieuThanhToanModels;
    }//Lay Phieu thanh toan theo nam va thang

    public ArrayList<PhieuThanhToanModel> layTongDoanhThuTheoNam(String nam) {
        ArrayList<PhieuThanhToanModel> phieuThanhToanModels = null;
        try {
            String sql = "SELECT SUM(TienPhaiTra)as TongDoangThu FROM phieuthanhtoan WHERE NgayTT like '%" + nam + "%'";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sql);
            ResultSetImpl resultSetImpl = (ResultSetImpl) preparedStatement.executeQuery();

            phieuThanhToanModels = new ArrayList<>();
            while (resultSetImpl.next()) {
                PhieuThanhToanModel phieuThanhToanModel = new PhieuThanhToanModel();
                phieuThanhToanModel.setTongDoanhThuTheoNam(resultSetImpl.getString("TongDoangThu"));
                phieuThanhToanModels.add(phieuThanhToanModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phieuThanhToanModels;
    }//Lay Tong doanh thu theo Nam
    
    public ArrayList<PhieuThanhToanModel> layTongDoanhThuTheoThang(String nam, String thang) {
        ArrayList<PhieuThanhToanModel> phieuThanhToanModels = null;
        try {
            String sql = "SELECT SUM(TienPhaiTra) as TongDoangThuThang FROM phieuthanhtoan WHERE NgayTT like '%"+nam+"%-%"+thang+"%'";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sql);
            ResultSetImpl resultSetImpl = (ResultSetImpl) preparedStatement.executeQuery();

            phieuThanhToanModels = new ArrayList<>();
            while (resultSetImpl.next()) {
                PhieuThanhToanModel phieuThanhToanModel = new PhieuThanhToanModel();
                phieuThanhToanModel.setTongDoanhThuTheoNamVaThang(resultSetImpl.getString("TongDoangThuThang"));
                phieuThanhToanModels.add(phieuThanhToanModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phieuThanhToanModels;
    }
    
    public int xoaPhieuTT(String maPTT){
        try {
            String sql = "delete from PhieuThanhToan where MaPTT=?";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sql);
            preparedStatement.setString(1, maPTT);
            
            int x = preparedStatement.executeUpdate();
            if(x>0){
                return x;
            }   
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }//xoa phieu thanh toan
    
    public ArrayList<PhieuThanhToanModel> layToanBoPhieuThanhToanTheoMa(String maPTT){
        ArrayList<PhieuThanhToanModel> phieuThanhToanModels = null;
        try {
            String sql = "select * from PhieuThanhToan where MaPTT=?";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sql);
            preparedStatement.setString(1, maPTT);
            ResultSetImpl resultSetImpl = (ResultSetImpl) preparedStatement.executeQuery();
            
            phieuThanhToanModels = new ArrayList<>();
            while (resultSetImpl.next()) {                
                PhieuThanhToanModel phieuThanhToanModel = new PhieuThanhToanModel();
                phieuThanhToanModel.setMaPTT(resultSetImpl.getString(1));
                phieuThanhToanModel.setMaPDK(resultSetImpl.getString(2));
                phieuThanhToanModel.setSoThang(resultSetImpl.getInt(3));
                phieuThanhToanModel.setNgayTT(resultSetImpl.getDate(4)+"");
                phieuThanhToanModel.setTongTien(resultSetImpl.getFloat(5));
                phieuThanhToanModel.setTienPhaiTra(resultSetImpl.getFloat(6));
                phieuThanhToanModels.add(phieuThanhToanModel);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phieuThanhToanModels;
        
    }
}
