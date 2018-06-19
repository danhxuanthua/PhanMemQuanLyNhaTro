/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyNhaTroMySQL.Service;

import QuanLyNhaTroMySQL.Model.DangNhapModel;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetImpl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author DanhThua
 */
public class DangNhapService extends KetNoiService{
    private Connection ketNoi = getKetNoiService();
    private String tenTaiKhoan, matKhau;
    
    public ArrayList<DangNhapModel> layToanBoThongTinDangNhap(String tenTaiKhoan, String MatKhau){
        ArrayList<DangNhapModel> dangNhapModels = null;
        try {
            String sqlDangNhap = "select * from DangNhap where TenTaiKhoan=? and MatKhau=?";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sqlDangNhap);
            preparedStatement.setString(1, tenTaiKhoan);
            preparedStatement.setString(2, MatKhau);
            ResultSetImpl resultSetImpl = (ResultSetImpl) preparedStatement.executeQuery();
            DangNhapModel dangNhapModel = new DangNhapModel();
            while (resultSetImpl.next()) {
                dangNhapModels = new ArrayList<>();
                dangNhapModel.setTenTaiKhoan(resultSetImpl.getString(1));
                dangNhapModel.setMatKhau(resultSetImpl.getString(2));
                dangNhapModels.add(dangNhapModel);
            }
        } catch (Exception e) {
        }
        return dangNhapModels;
    }//lay toan bo thong tin dang nhap trong bang DangNhap
    
    public void ghiFile (String tenTaiKhoan, String matKhau){
        String urlFile = "..\\QuanLyNhaTroMySQL\\data.txt";
        try {
            File file = new File(urlFile);
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter  = new PrintWriter(fileWriter);
            String data = tenTaiKhoan + "," + matKhau;
            printWriter.println(data);
            printWriter.close(); fileWriter.close();
        } catch (Exception e) {
        }
    }//Luu thong tin dang nhap
    
    public void docFile(){
        String urlFile = "..\\QuanLyNhaTroMySQL\\data.txt";
        try {
            File file = new File(urlFile);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line ="";
            while ((line = bufferedReader.readLine()) != null) {                
                String []s = line.split(",");
                tenTaiKhoan = s[0];
                matKhau = s[1];
            }
            
        } catch (Exception e) {
        }
    }//Hien thi thong tin tung dang nhap

    public int suaDangNhap(String tenTaiKhoan, String matKhau){
        try {
            String sqlDangNhap = "update DangNhap set MatKhau=? where TenTaiKhoan=?";
            PreparedStatement preparedStatement = (PreparedStatement) ketNoi.prepareStatement(sqlDangNhap);
            preparedStatement.setString(1, matKhau);
            preparedStatement.setString(2, tenTaiKhoan);
            
            int x = preparedStatement.executeUpdate();
            if(x>0){
                return x;
            }
        } catch (Exception e) {
        }
        return 0;
    }//sua dang nhap
    
    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }//get tenTaiKhoan

    public String getMatKhau() {
        return matKhau;
    }//get Matkhau
    
    
}
