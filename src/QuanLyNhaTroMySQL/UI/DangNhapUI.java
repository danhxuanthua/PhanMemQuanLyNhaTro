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
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author DanhThua
 */
public class DangNhapUI extends JFrame{

    private  JTextField txtTenTaiKhoan;
    private JPasswordField txtMatKhau;
    private  JCheckBox cbGhiNho;
    private JButton btnDangNhap, btnThoat;
    private ArrayList <DangNhapModel> dangNhapModels = null;
    public DangNhapUI(String title) {
        super(title);
        ImageIcon img = new ImageIcon(".\\src\\QuanLyNhaTroMySQL.Icon\\title.png");
        this.setIconImage(img.getImage());
        this.showWindows();
        this.addControls();
        this.addEvent();
    }//constructor

    public void showWindows() {
        this.setSize(430, 250);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }//showWindows

    private void addControls() {
        Container container = getContentPane();
            JPanel pnMain = new JPanel(new BorderLayout());
            
                //title dang nhap he thong
                JPanel pnTitle = new JPanel(new FlowLayout());
                    JLabel lblTitle = new JLabel("Đăng nhập hệ thống");
                    lblTitle.setFont(new Font("arial", Font.BOLD, 30));
                    lblTitle.setForeground(Color.decode("#0489B1"));
                pnTitle.add(lblTitle);
                pnTitle.setBorder(BorderFactory.createLineBorder(Color.decode("#088A85")));
                pnTitle.setBackground(Color.WHITE);
            pnMain.add(pnTitle, BorderLayout.NORTH);
            
                //pnCenter
                JPanel pnCenter = new JPanel(new BorderLayout());
                    
                    //pnCenterLeft
                    JPanel pnCenterLeft = new JPanel();
                    pnCenterLeft.setLayout(new BoxLayout(pnCenterLeft, BoxLayout.Y_AXIS));
                        JPanel pnLineLeft = new JPanel();
                    pnCenterLeft.add(pnLineLeft);
                        JPanel pnImage  = new JPanel();
                            JLabel lblImage = new JLabel(new ImageIcon("..\\QuanLyNhaTroMySQL\\src\\QuanLyNhaTroMySQL.Icon\\dangNhapIcon.png"));
                        pnImage.add(lblImage);
                    pnCenterLeft.add(pnImage);
                pnCenter.add(pnCenterLeft, BorderLayout.WEST);
                
                    //pnCenterRight
                    JPanel pnCenterRight = new JPanel();
                    pnCenterRight.setLayout(new BoxLayout(pnCenterRight, BoxLayout.Y_AXIS));
                        JPanel pnLineRight = new JPanel();
                    pnCenterRight.add(pnLineRight);
                    
                        //pnTenTaiKhoan
                        JPanel pnTenTaiKhoan = new JPanel(new FlowLayout());
                            JLabel lblTenTaiKhoan = new JLabel("Tên tài khoản: ");
                        pnTenTaiKhoan.add(lblTenTaiKhoan);
                            txtTenTaiKhoan = new JTextField(15);
                        pnTenTaiKhoan.add(txtTenTaiKhoan);
                    pnCenterRight.add(pnTenTaiKhoan);
                
                        //pnMatKhau
                        JPanel pnMatKhau = new JPanel(new FlowLayout());
                            JLabel lblMatKhau = new JLabel("Mật khẩu: ");
                        pnMatKhau.add(lblMatKhau);
                            txtMatKhau = new JPasswordField(15);
                        pnMatKhau.add(txtMatKhau);
                    pnCenterRight.add(pnMatKhau);
                    
                        //pn ghi nho dang nhap
                        JPanel pnGhiNhoDangNhap = new JPanel(new FlowLayout());
                            cbGhiNho = new JCheckBox("Ghi nhớ đăng nhập");
                            cbGhiNho.setFont(new Font("arial",Font.ITALIC, 12));
                        pnGhiNhoDangNhap.add(cbGhiNho);
                    pnCenterRight.add(pnGhiNhoDangNhap);
                    
                        //pnDangNhap Va Thoat
                        JPanel pnDangNhapVaThoat = new JPanel(new FlowLayout());
                            btnDangNhap = new JButton("Đăng nhập");
                        pnDangNhapVaThoat.add(btnDangNhap);
                            btnThoat = new JButton("Thoát");
                        pnDangNhapVaThoat.add(btnThoat);
                    pnCenterRight.add(pnDangNhapVaThoat);
                    
                        //Can le
                        lblMatKhau.setPreferredSize(lblTenTaiKhoan.getPreferredSize());
                        btnThoat.setPreferredSize(btnDangNhap.getPreferredSize());
                    
                pnCenter.add(pnCenterRight, BorderLayout.EAST);                
            pnMain.add(pnCenter, BorderLayout.CENTER);
        container.add(pnMain);
                    
    }//addControls

    private void addEvent() {
        hienThiThongTinTungDangNhap();
        
        btnDangNhap.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent ae) {
              xuLyDangNhap();
          }
        });//xu ly su kien btn dang nhap
        
        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                xuLyThoat();
            }
        });
        
    }//addEvent
    
    private void xuLyDangNhap() {
        DangNhapService dangNhapService = new DangNhapService();
        dangNhapModels = dangNhapService.layToanBoThongTinDangNhap(txtTenTaiKhoan.getText(), txtMatKhau.getText());
        if (dangNhapModels != null){
            if(cbGhiNho.isSelected()){
                dangNhapService.ghiFile(txtTenTaiKhoan.getText(), txtMatKhau.getText());
            }else{
                dangNhapService.ghiFile("", "");
            }
            MainUI mainUI = new MainUI("Quản lý nhà trọ");
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Tên tài khoản hoặc mật khẩu không đúng.\n Vui lòng kiểm tra lại !");
            txtTenTaiKhoan.requestFocus();
        }    
    }//xu ly luu thong tin tung dang nhap

    private void hienThiThongTinTungDangNhap() {
        cbGhiNho.setSelected(true);
        DangNhapService dangNhapService = new DangNhapService();
        dangNhapService.docFile();
        txtTenTaiKhoan.setText(dangNhapService.getTenTaiKhoan());
        txtMatKhau.setText(dangNhapService.getMatKhau());
    }// xu ly hien thi thong tin tung dang nhap
    
    
    private void xuLyThoat() {
       System.exit(0);
    }//xu ly thoat
}
