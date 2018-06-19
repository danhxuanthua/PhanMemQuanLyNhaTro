/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyNhaTroMySQL.Service;

import QuanLyNhaTroMySQL.Model.TrangBiModel;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetImpl;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DanhThua
 */
public class TrangBiSevice extends KetNoiService{
    private Connection ketNoi = getKetNoiService();
    public ArrayList<TrangBiModel> layToanBoTrangBi(){
        ArrayList<TrangBiModel> trangBiModels = null;
        try {
            String sql = "select * from TrangBi";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sql);
            ResultSetImpl resultSetImpl = (ResultSetImpl) preparedStatement.executeQuery();
            
            trangBiModels = new ArrayList<>();
            while (resultSetImpl.next()) {                
                TrangBiModel trangBiModel = new TrangBiModel();
                trangBiModel.setMaPhong(resultSetImpl.getString(1));
                trangBiModel.setMaTB(resultSetImpl.getString(2));
                trangBiModels.add(trangBiModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return trangBiModels;
    }
    
    public ArrayList<TrangBiModel> layToanBoPhongDuocTrangBi(){
        ArrayList<TrangBiModel> trangBiModels = null;
        try {
            String sql = "select a.MaPhong, a.HienTrangPhong, a.GiaPhong, b.TenTB, b.MaTB from PhongTro a, ThietBi b, TrangBi c where a.MaPhong=c.MaPhong and b.MaTB=c.MaTB";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sql);
            ResultSetImpl resultSetImpl = (ResultSetImpl) preparedStatement.executeQuery();
            
            trangBiModels = new ArrayList<>();
            while (resultSetImpl.next()) {                
                TrangBiModel trangBiModel = new TrangBiModel();
                trangBiModel.setMaPhong(resultSetImpl.getString("MaPhong"));
                trangBiModel.setHienTrangPhong(resultSetImpl.getString("HienTrangPhong"));
                trangBiModel.setGiaPhong(resultSetImpl.getFloat("GiaPhong"));
                trangBiModel.setTenThietBi(resultSetImpl.getString("TenTB"));
                trangBiModel.setMaTB(resultSetImpl.getString("MaTB"));
                trangBiModels.add(trangBiModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return trangBiModels;        
    }//Lay toan bo phong duoc trang bi
    
   public int themTrangBi(String maPhong, String maTB){
       try {
           String sql = "insert into TrangBi values (?,?)";
           PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sql);
           preparedStatement.setString(1, maPhong);
           preparedStatement.setString(2, maTB);
           
           int x = preparedStatement.executeUpdate();
           if (x> 0){
               return x;
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return 0;
   }//them trang bi
   
   public int suaTrangBi(String maPhong, String maTB){
       try {
           String sql = "update TrangBi set MaTB =? where MaPhong=?";
           PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sql);
           preparedStatement.setString(1, maTB);
           preparedStatement.setString(2, maPhong);
           
           int x = preparedStatement.executeUpdate();
           if (x> 0){
               return x;
           }
           
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return 0;
   }//sua trang bi
   
   public int xoaTrangBi(String maPhong, String maTB){
       try {
           String sql = "delete from TrangBi where MaPhong =? and MaTB=?";
           PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sql);
           preparedStatement.setString(1, maPhong);
           preparedStatement.setString(2, maTB);
           
           int x = preparedStatement.executeUpdate();
           if (x> 0){
               return x;
           }
           
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return 0;
   }//xoa trang bi
}
