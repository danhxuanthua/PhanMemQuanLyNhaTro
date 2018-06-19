/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyNhaTroMySQL.Service;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import java.util.Properties;

/**
 *
 * @author DanhThua
 */
public class KetNoiService {
    protected Connection ketNoi = null;
    
    public Connection getKetNoiService() {
        try {
            String urlKetNoi = "jdbc:mysql://localhost/database_quanlynhatro?useUnicode=true&characterEncoding=utf-8";
            Properties properties = new Properties();
            properties.put("user", "root");
            properties.put("password", "");
            Driver driver = new Driver();
            ketNoi = (Connection) driver.connect(urlKetNoi, properties);
            if(ketNoi != null){
                System.out.println("Ket noi thanh cong");
            }else{
                System.out.println("Ket noi that bai");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketNoi;
    }
    
}
