/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyNhaTroMySQL.Service;

import QuanLyNhaTroMySQL.Model.ThietBiModel;
import com.mysql.jdbc.ResultSetImpl;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DanhThua
 */
public class ThietBiService extends KetNoiService{
    private com.mysql.jdbc.Connection ketNoi = getKetNoiService();
    
    public ArrayList<ThietBiModel> layToanBoThietBi(){
        ArrayList<ThietBiModel> thietBiModels = null;
        try {
            String sql = "select * from ThietBi";
            PreparedStatement preparedStatement = ketNoi.prepareStatement(sql);
            ResultSetImpl resultSetImpl = (ResultSetImpl) preparedStatement.executeQuery();
            
            thietBiModels = new ArrayList<>();
            while (resultSetImpl.next()) {                
                ThietBiModel thietBiModel = new ThietBiModel();
                thietBiModel.setMaThietBi(resultSetImpl.getString(1));
                thietBiModel.setTenThietBi(resultSetImpl.getString(2));
                thietBiModels.add(thietBiModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return thietBiModels;
    }//lay toan bo thiet bi
    
    public int themThietBi(String maTB, String tenTB){
        try {
            String sql = "insert into ThietBi values (?, ?)";
            PreparedStatement preparedStatement = ketNoi.prepareStatement(sql);
            preparedStatement.setString(1, maTB);
            preparedStatement.setString(2, tenTB);
            
            int x = preparedStatement.executeUpdate();
            if(x>0){
                return x;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }//them thiet bi
    
    public ArrayList<ThietBiModel> layThietBiTheoMaThietBi(String maTB){
        ArrayList<ThietBiModel> thietBiModels = null;
        try {
            String sql = "select * from ThietBi where MaTB=?";
            PreparedStatement preparedStatement = ketNoi.prepareStatement(sql);
            preparedStatement.setString(1, maTB);
            ResultSetImpl resultSetImpl = (ResultSetImpl) preparedStatement.executeQuery();
            
            thietBiModels = new ArrayList<>();
            while (resultSetImpl.next()) {                
                ThietBiModel thietBiModel = new ThietBiModel();
                thietBiModel.setMaThietBi(resultSetImpl.getString(1));
                thietBiModel.setTenThietBi(resultSetImpl.getString(2));
                thietBiModels.add(thietBiModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }        
        return thietBiModels;
    }//Lay thiet bi theo ma thiet bi
    
    public boolean kiemTraThietBiCoTonTai(String maTB){
        try {
            String sql = "select * from ThietBi where MaTB=?";
            PreparedStatement preparedStatement = ketNoi.prepareStatement(sql);
            preparedStatement.setString(1, maTB);
            ResultSetImpl resultSetImpl = (ResultSetImpl) preparedStatement.executeQuery();
            
            if(resultSetImpl.next()){
                return true;//Neu ton tai
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;//Khong ton tai
    }//kiem tra
    
    public int suaThietBi(String maTB, String tenTB){
        try {
            String sql = "update ThietBi set TenTB=? where MaTB=?";
            PreparedStatement preparedStatement = ketNoi.prepareStatement(sql);
            preparedStatement.setString(1, tenTB);
            preparedStatement.setString(2, maTB);
            
            int x = preparedStatement.executeUpdate();
            if(x>0){
                return x;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }//sua thiet bi
    
    public int xoaThietBi(String maTB){
        try {
            String sql = "delete from ThietBi where MaTB=?";
            PreparedStatement preparedStatement = ketNoi.prepareStatement(sql);
            preparedStatement.setString(1, maTB);
            
            int x = preparedStatement.executeUpdate();
            if(x>0){
                return x;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    
    
}
