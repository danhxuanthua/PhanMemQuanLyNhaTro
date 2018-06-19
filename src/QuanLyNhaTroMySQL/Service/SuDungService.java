/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyNhaTroMySQL.Service;

import QuanLyNhaTroMySQL.Model.SuDungModel;
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
public class SuDungService extends KetNoiService{
    private Connection ketNoi = getKetNoiService();
    
    public ArrayList<SuDungModel> layToanBoSuDung(){
        ArrayList<SuDungModel> suDungModels = null;
        try {
            String sql = "select * from SuDung";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sql);
            ResultSetImpl resultSetImpl = (ResultSetImpl) preparedStatement.executeQuery();
            
            suDungModels = new ArrayList<>();
            while(resultSetImpl.next()){
                SuDungModel suDungModel = new SuDungModel();
                suDungModel.setMaDV(resultSetImpl.getString(1));
                suDungModel.setMaKH(resultSetImpl.getString(2));
                suDungModel.setNgaySD(resultSetImpl.getDate(3)+"");
                suDungModel.setGiaDV(resultSetImpl.getFloat(4));
                suDungModels.add(suDungModel);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return suDungModels;
    }//Lay toan bo su dung
    
    public ArrayList<SuDungModel> laySuDungTheoMaDichVuMaKH(String maDV, String maKH){
            ArrayList<SuDungModel> suDungModels = null;
        try {
            String sql = "select * from SuDung where MaDV=? and MaKH=?";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sql);
            preparedStatement.setString(1, maDV);
            preparedStatement.setString(2, maKH);
            ResultSetImpl resultSetImpl = (ResultSetImpl) preparedStatement.executeQuery();
            
            suDungModels = new ArrayList<>();
            while(resultSetImpl.next()){
                SuDungModel suDungModel = new SuDungModel();
                suDungModel.setMaDV(resultSetImpl.getString(1));
                suDungModel.setMaKH(resultSetImpl.getString(2));
                suDungModel.setNgaySD(resultSetImpl.getDate(3)+"");
                suDungModel.setGiaDV(resultSetImpl.getFloat(4));
                suDungModels.add(suDungModel);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return suDungModels;
       
    }//lay su dung dich vu theo ma DV va maKH
    
    public int themSuDung(String maDV, String maKH, String ngaySD, float giaDV){
        try {
            String sql = "insert into SuDung values(?, ?, ?, ?)";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sql);
            preparedStatement.setString(1, maDV);
            preparedStatement.setString(2, maKH);
            preparedStatement.setDate(3, Date.valueOf(ngaySD));
            preparedStatement.setFloat(4, giaDV);
            
            int x = preparedStatement.executeUpdate();
            if (x > 0){
                return x;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return 0;
    }//Them su dung
    
    public int suaSuDung(String maDV, String maKH, String ngaySD, float giaDV){
        try {
            String sql = "update SuDung set NgaySD=?, GiaDV=? where MaDV=? and MaKH=?";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sql);
            preparedStatement.setDate(1, Date.valueOf(ngaySD));
            preparedStatement.setFloat(2, giaDV);
            preparedStatement.setString(3, maDV);
            preparedStatement.setString(4, maKH);
            
            int x = preparedStatement.executeUpdate();
            if (x > 0){
                return x;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return 0;
    }//sua su dung
    
    public int xoaSuDung(String maDV, String maKH){
        try {
            String sql = "delete from SuDung where MaDV=? and MaKH=?";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sql);
            preparedStatement.setString(1, maDV);
            preparedStatement.setString(2, maKH);
            
            int x = preparedStatement.executeUpdate();
            if (x > 0){
                return x;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return 0;
    }//xoa su dung
    
    public ArrayList<SuDungModel> layMaKHSuDungDVLoaiBoTrungLap(){
        ArrayList<SuDungModel> suDungModels = null;
        try {
            String sql = "select DISTINCT MaKH  from SuDung";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sql);
            ResultSetImpl resultSetImpl = (ResultSetImpl) preparedStatement.executeQuery();
            
            suDungModels = new ArrayList<>();
            while(resultSetImpl.next()){
                SuDungModel suDungModel = new SuDungModel();
                suDungModel.setMaKH(resultSetImpl.getString("MaKH"));
                suDungModels.add(suDungModel);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return suDungModels;
    }//Lay maKH su dung dich vu loai bo su trung lap
    
    public ArrayList<SuDungModel> layDichVuKhachHangSuDung(String maKH){
        ArrayList<SuDungModel> suDungModels = null;
        try {
            String sql = "select * from SuDung where MaKH=?";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sql);
            preparedStatement.setString(1, maKH);
            ResultSetImpl resultSetImpl = (ResultSetImpl) preparedStatement.executeQuery();
            
            suDungModels = new ArrayList<>();
            while(resultSetImpl.next()){
               SuDungModel suDungModel = new SuDungModel();
                suDungModel.setMaDV(resultSetImpl.getString(1));
                suDungModel.setMaKH(resultSetImpl.getString(2));
                suDungModel.setNgaySD(resultSetImpl.getDate(3)+"");
                suDungModel.setGiaDV(resultSetImpl.getFloat(4));
                suDungModels.add(suDungModel);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return suDungModels;
    }//lay dich vu khach hang da su dung
    
    public ArrayList<SuDungModel> layGiaDichVuTheoMaKHVaMaDV(String maKH, String maDV){
        ArrayList<SuDungModel> suDungModels = null;
        try {
            String sql = "select * from SuDung where MaKH=? and MaDV=?";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sql);
            preparedStatement.setString(1, maKH);
            preparedStatement.setString(2, maDV);
            ResultSetImpl resultSetImpl = (ResultSetImpl) preparedStatement.executeQuery();
            
            suDungModels = new ArrayList<>();
            while(resultSetImpl.next()){
               SuDungModel suDungModel = new SuDungModel();
                suDungModel.setMaDV(resultSetImpl.getString(1));
                suDungModel.setMaKH(resultSetImpl.getString(2));
                suDungModel.setNgaySD(resultSetImpl.getDate(3)+"");
                suDungModel.setGiaDV(resultSetImpl.getFloat(4));
                suDungModels.add(suDungModel);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return suDungModels;
    }
   
    
}
