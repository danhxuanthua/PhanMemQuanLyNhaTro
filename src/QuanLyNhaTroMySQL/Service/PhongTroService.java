/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyNhaTroMySQL.Service;

import QuanLyNhaTroMySQL.Model.PhongTroModel;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetImpl;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DanhThua
 */
public class PhongTroService extends KetNoiService {

    private  Connection ketNoi = getKetNoiService();

    
    public ArrayList<PhongTroModel> layToanBoPhongTro() {
        ArrayList<PhongTroModel> phongTroModels = null;
        try {
            String sQL = "select * from PhongTro";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sQL);
            ResultSetImpl resultSetImpl = (ResultSetImpl) preparedStatement.executeQuery();

            phongTroModels = new ArrayList<>();
            while (resultSetImpl.next()) {
                PhongTroModel phongTroModel = new PhongTroModel();
                phongTroModel.setMaPhong(resultSetImpl.getString(1));
                phongTroModel.setHienTrangPhon(resultSetImpl.getString(2));
                phongTroModel.setGiaPhong(resultSetImpl.getFloat(3));
                phongTroModels.add(phongTroModel);
            }
        } catch (SQLException e) {
        }
        return phongTroModels;
    }//Lay danh sach phong tro

    public ArrayList<PhongTroModel> layThongTinTungPhongTro(String maPhong) {
        ArrayList<PhongTroModel> phongTroModels = null;
        try {
            String sQL = "select * from PhongTro where MaPhong=?";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sQL);
            preparedStatement.setString(1, maPhong);
            ResultSetImpl resultSetImpl = (ResultSetImpl) preparedStatement.executeQuery();

            phongTroModels = new ArrayList<>();
            while (resultSetImpl.next()) {
                PhongTroModel phongTroModel = new PhongTroModel();
                phongTroModel.setMaPhong(resultSetImpl.getString(1));
                phongTroModel.setHienTrangPhon(resultSetImpl.getString(2));
                phongTroModel.setGiaPhong(resultSetImpl.getFloat(3));
                phongTroModels.add(phongTroModel);
            }
        } catch (SQLException e) {
        }
        return phongTroModels;
    }//Lay ma phong tro

    public int themPhong(String maPhong, String hienTrangPhong, float giaPhong) {
        try {
            String sql = "insert into PhongTro values(?,?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sql);
            preparedStatement.setString(1, maPhong);
            preparedStatement.setString(2, hienTrangPhong);
            preparedStatement.setFloat(3, giaPhong);

            int x = preparedStatement.executeUpdate();
            if (x > 0) {
                return x;
            }
        } catch (SQLException e) {
        }
        return 0;
    }//them phong

    public boolean kiemTraPhongDaTonTai(String maPhong) {
        try {
            String sQL = "select * from PhongTro where MaPhong=?";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sQL);
            preparedStatement.setString(1, maPhong);
            ResultSetImpl resultSetImpl = (ResultSetImpl) preparedStatement.executeQuery();
            if (resultSetImpl.next()) {
                return true;//neu ton tai
            }
        } catch (SQLException e) {
        }

        return false;//khong ton tai
    }//kiem tra phong da ton tai hay chua

    public int suaPhong(String maPhong, String hienTrangPhong, float giaPhong) {
        try {
            String sql = "update PhongTro set HienTrangPhong=?, GiaPhong=? where MaPhong=?";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sql);
            preparedStatement.setString(1, hienTrangPhong);
            preparedStatement.setFloat(2, giaPhong);
            preparedStatement.setString(3, maPhong);

            int x = preparedStatement.executeUpdate();
            if (x > 0) {
                return x;
            }
        } catch (SQLException e) {
        }
        return 0;
    }//sua phong

    public int xoaPhong(String maPhong) {
        try {
            String sql = "delete from PhongTro where MaPhong=?";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sql);
            preparedStatement.setString(1, maPhong);
            int x = preparedStatement.executeUpdate();
            if (x > 0) {
                return x;
            }
        } catch (SQLException e) {
        }
        return 0;
    }//xoa phong

    public ArrayList<PhongTroModel> timKiemPhong(String timKiem) {
        ArrayList<PhongTroModel> phongTroModels = null;
        try {
            String sQL = "select * from PhongTro where MaPhong like '%" + timKiem + "%' or GiaPhong like '%" + timKiem + "%' or HienTrangPhong like '%" + timKiem + "%'";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sQL);
            ResultSetImpl resultSetImpl = (ResultSetImpl) preparedStatement.executeQuery();

            phongTroModels = new ArrayList<>();
            while (resultSetImpl.next()) {
                PhongTroModel phongTroModel = new PhongTroModel();
                phongTroModel.setMaPhong(resultSetImpl.getString(1));
                phongTroModel.setHienTrangPhon(resultSetImpl.getString(2));
                phongTroModel.setGiaPhong(resultSetImpl.getFloat(3));
                phongTroModels.add(phongTroModel);
            }
        } catch (SQLException e) {
        }
        return phongTroModels;
    }//Tim kiem phong tro

}
