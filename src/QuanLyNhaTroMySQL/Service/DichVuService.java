/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyNhaTroMySQL.Service;

import QuanLyNhaTroMySQL.Model.DichVuModel;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetImpl;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DanhThua
 */
public class DichVuService extends KetNoiService{
    private Connection ketNoi = getKetNoiService();
    
    
    public ArrayList<DichVuModel> layToanBoDichVu(){
        ArrayList<DichVuModel> dichVuModels = null;
        try {
            String sql = "select * from DichVu";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sql);
            ResultSetImpl resultSetImpl = (ResultSetImpl) preparedStatement.executeQuery();
            
            dichVuModels = new ArrayList<>();
            while (resultSetImpl.next()) {                
                DichVuModel dichVuModel = new DichVuModel();
                dichVuModel.setMaDV(resultSetImpl.getString(1));
                dichVuModel.setTenDV(resultSetImpl.getString(2));
                dichVuModels.add(dichVuModel);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dichVuModels;
    } //lay toan bo dich vu
    
   public ArrayList<DichVuModel> layDichVuTheoMa(String maDV){
        ArrayList<DichVuModel> dichVuModels = null;
        try {
            String sql = "select * from DichVu where MaDV=?";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sql);
            preparedStatement.setString(1, maDV);
            
            ResultSetImpl resultSetImpl = (ResultSetImpl) preparedStatement.executeQuery();
            
            dichVuModels = new ArrayList<>();
            while (resultSetImpl.next()) {                
                DichVuModel dichVuModel = new DichVuModel();
                dichVuModel.setMaDV(resultSetImpl.getString(1));
                dichVuModel.setTenDV(resultSetImpl.getString(2));
                dichVuModels.add(dichVuModel);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dichVuModels;
    } //lay dich vu theo ma
   
   public boolean kiemTraDichVuDaTonTai(String maDV){
     try {
            String sql = "select * from DichVu where MaDV=?";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sql);
            preparedStatement.setString(1, maDV);
            
            ResultSetImpl resultSetImpl = (ResultSetImpl) preparedStatement.executeQuery();
            
            if (resultSetImpl.next()){
                return true;//neu ton tai
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

       return false;//chua ton tai
   }//kiem tra dich vu da ton tai hay chua
    
   public int themDV(String maDV,String tenDV){
        try {
            String sql = "insert into DichVu values(?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sql);
            preparedStatement.setString(1, maDV);
            preparedStatement.setString(2, tenDV);
            
            int x = preparedStatement.executeUpdate();
            
            if (x>0){
                return x;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

       return 0;
   }//them dich vu
   
   public int suaDV(String maDV, String tenDV){
        try {
            String sql = "update DichVu set TenDV=? where MaDV=?";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sql);
            preparedStatement.setString(1, tenDV);
            preparedStatement.setString(2, maDV);
            
            int x = preparedStatement.executeUpdate();
            if (x>0){
                return x;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
       return 0;
   }//Sua Divh Vu
   
   public int xoaDV(String maDV){
        try {
            String sql = "delete from DichVu where MaDV=?";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sql);
            preparedStatement.setString(1, maDV);
            
            int x = preparedStatement.executeUpdate();
            if (x>0){
                return x;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
       return 0;  
   }
}
