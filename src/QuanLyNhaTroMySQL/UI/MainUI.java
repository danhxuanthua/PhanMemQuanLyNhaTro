/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyNhaTroMySQL.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.TitledBorder;

/**
 *
 * @author DanhThua
 */
public class MainUI extends JFrame{
    private JMenuBar menuBar;
    private JMenu menuCaiDat, menuHelp;
    private JMenuItem menuCaiDatNguoiDung, menuHelpAbout;
    private JButton btnKhachHang, btnPhongTro, btnThietBi;
    private JButton btnThuePhongVaTraPhong, btnDichVu, btnThongKe;
    public MainUI(String title) {
        super(title);
        ImageIcon img = new ImageIcon(".\\src\\QuanLyNhaTroMySQL.Icon\\title.png");
        this.setIconImage(img.getImage());
        this.showWindows();
        this.addControls();
        this.addEvent();
      
    }//constructor

   
    
    public void addControls() {
        Container container = getContentPane();
            //set menubar
            menuBar = new JMenuBar();
            this.setJMenuBar(menuBar);
            
            //add Menu
            menuCaiDat = new JMenu("Cài Đặt");
            menuCaiDat.setForeground(Color.decode("#086A87"));
            menuBar.add(menuCaiDat);
            menuHelp = new JMenu("Help");
            menuHelp.setForeground(Color.decode("#086A87"));
            menuBar.add(menuHelp);
            
            //add menu Item
            menuCaiDatNguoiDung = new JMenuItem("Người dùng");
            menuCaiDatNguoiDung.setIcon(new ImageIcon(".\\src\\QuanLyNhaTroMySQL.Icon\\CaiDatTaiKhoanNguoiDung.png"));
            menuCaiDatNguoiDung.setForeground(Color.decode("#086A87"));
            menuCaiDat.add(menuCaiDatNguoiDung);
         
            menuHelpAbout = new JMenuItem("About");
            menuHelpAbout.setForeground(Color.decode("#086A87"));
            menuHelpAbout.setIcon(new ImageIcon(".\\src\\QuanLyNhaTroMySQL.Icon\\ThongTin.png"));
            menuHelp.add(menuHelpAbout);
            
            
            //pnMain
            JPanel pnMain = new JPanel(new BorderLayout());
                
                //North
                JPanel pnNorth = new JPanel(new FlowLayout());
                pnNorth.setBackground(Color.decode("#0489B1"));
                
                    JLabel lblQuanLyNhaTro = new JLabel("Quản Lý Nhà Trọ");
                    lblQuanLyNhaTro.setFont(new Font("Ariaal", Font.BOLD, 50));
                    lblQuanLyNhaTro.setForeground(Color.WHITE);
                    
                pnNorth.add(lblQuanLyNhaTro);
                
            pnMain.add(pnNorth, BorderLayout.NORTH);
                
                   //Center
                JPanel pnCenterLeft = new JPanel();//centerRightLeft
                
                    //set border pnCenterLeft
                    TitledBorder titledBorderCenterLeft = new TitledBorder(BorderFactory.createLineBorder(Color.WHITE), "Chức Năng");
                    titledBorderCenterLeft.setTitleColor(Color.white);
                    pnCenterLeft.setBorder(titledBorderCenterLeft);
                    pnCenterLeft.setBackground(Color.decode("#0489B1"));
                
                 
                JPanel pnCenterRight = new JPanel();
                JLabel lblBackground = new JLabel(new ImageIcon(".\\src\\QuanLyNhaTroMySQL.Icon\\bg.png"));
                lblBackground.setPreferredSize(new Dimension(500, 500));
                pnCenterRight.add(lblBackground);
                pnCenterRight.setBackground(Color.decode("#0489B1"));
                
                //SplitPane
                JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnCenterLeft, pnCenterRight);
                    
                    //Chuc nang
                    JPanel pnChucNang = new JPanel();
                    pnChucNang.setLayout(new BoxLayout(pnChucNang, BoxLayout.Y_AXIS));
                    pnChucNang.setForeground(Color.decode("#04B486"));
                    
                        //Thong tin khach hang
                        JPanel pnKhachHang = new JPanel();
                            btnKhachHang = new JButton("Khách Hàng");
                            btnKhachHang.setFont(new Font("arial", Font.BOLD, 15));
                            btnKhachHang.setForeground(Color.decode("#086A87"));
                            btnKhachHang.setIcon(new ImageIcon(".\\src\\QuanLyNhaTroMySQL.Icon\\thongTinKhachHang.png"));
                            btnKhachHang.setBackground(Color.WHITE);
                        pnKhachHang.add(btnKhachHang);
                    pnChucNang.add(pnKhachHang);
                
                        //Thong tin phong tro
                        JPanel pnPhongTro = new JPanel();
                            btnPhongTro = new JButton("Phòng Trọ");
                            btnPhongTro.setIcon(new ImageIcon(".\\src\\QuanLyNhaTroMySQL.Icon\\nhaTro.png"));
                            btnPhongTro.setFont(new Font("arial", Font.BOLD, 15));
                            btnPhongTro.setForeground(Color.decode("#086A87"));
                            btnPhongTro.setBackground(Color.WHITE);
                            pnPhongTro.add(btnPhongTro);
                    pnChucNang.add(pnPhongTro);
                        
                        //Thiet Bi phong tro
                        JPanel pnThietBi = new JPanel();
                            btnThietBi = new JButton("Thiết Bị");
                            btnThietBi.setIcon(new ImageIcon(".\\src\\QuanLyNhaTroMySQL.Icon\\thietBi.png"));
                            btnThietBi.setFont(new Font("arial", Font.BOLD, 15));
                            btnThietBi.setForeground(Color.decode("#086A87"));
                            btnThietBi.setBackground(Color.WHITE);
                            pnThietBi.add(btnThietBi);
                    pnChucNang.add(pnThietBi);
                        
                        //Thue phong va tra phong
                        JPanel pnThueVaTraPhong = new JPanel();
                            btnThuePhongVaTraPhong = new JButton("Thuê Phòng");
                            btnThuePhongVaTraPhong.setIcon(new ImageIcon(".\\src\\QuanLyNhaTroMySQL.Icon\\ThuePhong.png"));
                            btnThuePhongVaTraPhong.setFont(new Font("arial", Font.BOLD, 15));
                            btnThuePhongVaTraPhong.setForeground(Color.decode("#086A87"));
                            btnThuePhongVaTraPhong.setBackground(Color.WHITE);
                        pnThueVaTraPhong.add(btnThuePhongVaTraPhong);
                    pnChucNang.add(pnThueVaTraPhong);
                    
                        //Dich vu
                        JPanel pnDichVu = new JPanel();
                            btnDichVu = new JButton("Dịch Vụ");
                            btnDichVu.setIcon(new ImageIcon(".\\src\\QuanLyNhaTroMySQL.Icon\\dichVu.png"));
                            btnDichVu.setFont(new Font("arial", Font.BOLD, 15));
                            btnDichVu.setForeground(Color.decode("#086A87"));
                            btnDichVu.setBackground(Color.WHITE);
                        pnDichVu.add(btnDichVu);
                    pnChucNang.add(pnDichVu);
                    
                        //thong ke
                        JPanel pnThongKe = new JPanel();
                            btnThongKe = new JButton("Thống Kê");
                            btnThongKe.setIcon(new ImageIcon(".\\src\\QuanLyNhaTroMySQL.Icon\\thongKe.png"));
                            btnThongKe.setFont(new Font("arial", Font.BOLD, 15));
                            btnThongKe.setForeground(Color.decode("#086A87"));
                            btnThongKe.setBackground(Color.WHITE);
                        pnThongKe.add(btnThongKe);    
                    pnChucNang.add(pnThongKe);
                  
                    //Can chinh button chuc nang
                    btnDichVu.setPreferredSize(btnThuePhongVaTraPhong.getPreferredSize());
                    btnKhachHang.setPreferredSize(btnThuePhongVaTraPhong.getPreferredSize());
                    btnPhongTro.setPreferredSize(btnThuePhongVaTraPhong.getPreferredSize());
                    btnThongKe.setPreferredSize(btnThuePhongVaTraPhong.getPreferredSize());
                    btnThietBi.setPreferredSize(btnThuePhongVaTraPhong.getPreferredSize());
                pnCenterLeft.add(pnChucNang);
                
                

            pnMain.add(pnCenterLeft, BorderLayout.WEST);
            pnMain.add(pnCenterRight, BorderLayout.CENTER);
        
        container.add(pnMain);
            
    }//add controls

    private void addEvent() {
      // xuLyHienThiPhongTro();
       
       btnKhachHang.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
                KhachHangUI khachHangUI = new KhachHangUI("Quản lý thông tin khách hàng");
                khachHangUI.showWindows();
           }
       });
       
       btnPhongTro.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
              PhongTroUI phongTroUI = new PhongTroUI("Thông tin phong trọ");
              phongTroUI.showWindows();
           }
       });
       
       btnThietBi.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
               ThietBiUI thietBiUI = new ThietBiUI("Quản lý thiết bị");
               thietBiUI.showWindows();
           }
       });
       
       btnThuePhongVaTraPhong.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
               ThuePhongUI thuePhongUI = new ThuePhongUI("Quản lý đăng ký thuê phòng");
               thuePhongUI.showWindows();
           }
       });
       
       btnDichVu.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
               DichVuUI dichVuUI = new DichVuUI("Dịch Vụ");
               dichVuUI.showWindows();
           }
       });
       
       btnThongKe.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
               ThongKeUI thongKeUI = new ThongKeUI("Thống kê");
               thongKeUI.showWindows();
           }
       });
       
       menuCaiDatNguoiDung.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
              ThongTinTaiKhoanUI thongTinTaiKhoanUI = new ThongTinTaiKhoanUI("Người dùng");
              thongTinTaiKhoanUI.showWindows();
           }
       });
       
       menuHelpAbout.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
               ThongTinUI thongTinUI = new ThongTinUI("Thông tin phần mềm");
               thongTinUI.showWindows();
           }
       });
     
    }//add Event

    private void showWindows() {
      this.setSize(950, 700);
      this.setLocationRelativeTo(null);
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
      this.setVisible(true);
    }//show Windows

    
}
