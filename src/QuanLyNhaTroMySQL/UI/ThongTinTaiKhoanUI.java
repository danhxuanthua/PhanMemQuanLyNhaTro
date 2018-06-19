/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyNhaTroMySQL.UI;

import QuanLyNhaTroMySQL.Model.DangNhapModel;
import QuanLyNhaTroMySQL.Service.DangNhapService;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author DanhThua
 */
public class ThongTinTaiKhoanUI extends JDialog{
    private JTextField txtTenDangNhap;
    private JPasswordField txtMatKhauCu, txtMatKhauMoi;
    private JButton btnCapNhat;
    private ArrayList<DangNhapModel> dangNhapModels = null;
    
    public ThongTinTaiKhoanUI(String title) {
        this.setTitle(title);
        ImageIcon img = new ImageIcon(".\\src\\QuanLyNhaTroMySQL.Icon\\title.png");
        this.setIconImage(img.getImage());
        this.addControls();
        this.addEvent();
        
    }//constructor

    public void showWindows() {
        this.setSize(500, 250);
        //this.setLocation(225, 115);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setModal(true);
        this.setResizable(false);
        this.setVisible(true);   
    }//showWindows

    private void addControls() {
        Container container = getContentPane();
        
            JPanel pnMain = new JPanel(new BorderLayout());
            pnMain.setBackground(Color.decode("#0489B1"));
            
                JPanel pnThongTinTaiKhoan = new JPanel();
                pnThongTinTaiKhoan.setBackground(Color.decode("#0489B1"));
                pnThongTinTaiKhoan.setLayout(new BoxLayout(pnThongTinTaiKhoan, BoxLayout.Y_AXIS));
                TitledBorder titledThongTinTaiKhoan = new TitledBorder(BorderFactory.createLineBorder(Color.WHITE), "Thay đổi mật khẩu");
                titledThongTinTaiKhoan.setTitleColor(Color.WHITE);
                pnThongTinTaiKhoan.setBorder(titledThongTinTaiKhoan);
                
                    //Ten dang nhap
                    JPanel pnTenDangNhap = new JPanel();
                    pnTenDangNhap.setBackground(Color.decode("#0489B1"));
                        JLabel lblTenDangNhap = new JLabel("Tên tài khoản: ");
                        lblTenDangNhap.setForeground(Color.WHITE);
                    pnTenDangNhap.add(lblTenDangNhap);
                        txtTenDangNhap = new JTextField(15);
                    pnTenDangNhap.add(txtTenDangNhap);
                pnThongTinTaiKhoan.add(pnTenDangNhap);
                    
                    //Mat Khau Cu
                    JPanel pnMatKhauCu = new JPanel();
                    pnMatKhauCu.setBackground(Color.decode("#0489B1"));
                        JLabel lblMatKhauCu = new JLabel("Mật khẩu cũ: ");
                        lblMatKhauCu.setForeground(Color.WHITE);
                    pnMatKhauCu.add(lblMatKhauCu);
                        txtMatKhauCu = new JPasswordField(15);
                    pnMatKhauCu.add(txtMatKhauCu);
                pnThongTinTaiKhoan.add(pnMatKhauCu);
                    
                    //Mat Khau moi
                    JPanel pnMatKhauMoi = new JPanel();
                    pnMatKhauMoi.setBackground(Color.decode("#0489B1"));
                        JLabel lblMatKhauMoi = new JLabel("Mật khẩu mới: ");
                        lblMatKhauMoi.setForeground(Color.WHITE);
                    pnMatKhauMoi.add(lblMatKhauMoi);
                        txtMatKhauMoi = new JPasswordField(15);
                    pnMatKhauMoi.add(txtMatKhauMoi);
                pnThongTinTaiKhoan.add(pnMatKhauMoi);      
                
                    //button
                    JPanel pnThayDoi = new JPanel();
                    pnThayDoi.setBackground(Color.decode("#0489B1"));
                        JLabel lblTab1 = new JLabel("           ");
                    pnThayDoi.add(lblTab1);
                        btnCapNhat = new JButton("Cập nhật");
                        btnCapNhat.setForeground(Color.decode("#086A87"));
                        btnCapNhat.setBackground(Color.WHITE);
                        btnCapNhat.setIcon(new ImageIcon(".\\src\\QuanLyNhaTroMySQL.Icon\\CapNhatTaiKhoan.png"));
                    pnThayDoi.add(btnCapNhat);
                pnThongTinTaiKhoan.add(pnThayDoi);
                    
                    //can le
                    lblMatKhauCu.setPreferredSize(lblMatKhauMoi.getPreferredSize());
                    lblTenDangNhap.setPreferredSize(lblMatKhauMoi.getPreferredSize());
                     
            pnMain.add(pnThongTinTaiKhoan, BorderLayout.CENTER);
                        
        container.add(pnMain);
    }//add controls

    private void addEvent() {
        btnCapNhat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                xuLyCapNhat();
            }
        });
    }
    
    private void xuLyCapNhat(){
        DangNhapService dangNhapService = new DangNhapService();
        dangNhapModels = dangNhapService.layToanBoThongTinDangNhap(txtTenDangNhap.getText().trim(), txtMatKhauCu.getText().trim());
        
        if(dangNhapModels != null){
            int x =  dangNhapService.suaDangNhap(txtTenDangNhap.getText().trim(), txtMatKhauMoi.getText().trim());
            if(x>0){
                JOptionPane.showMessageDialog(null, "Đã cập nhật mật khẩu mới!");
            }else{
                JOptionPane.showMessageDialog(null, "Cập nhật thất bại!");
                return;
            }
        }else{
            JOptionPane.showMessageDialog(null, "Tên tài khoản hoạc mật khẩu không dúng. Vui lòng kiểm tra lại!");
            return;
        }
        
    }
}
