/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyNhaTroMySQL.UI;

import QuanLyNhaTroMySQL.Model.PhongTroModel;
import QuanLyNhaTroMySQL.Service.PhongTroService;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DanhThua
 */
public class PhongTroUI extends JDialog{

    private DefaultTableModel model;
    private JTable tbPhongTro;
    private JTextField txtMaPhong, txtGiaPhong, txtTimKiem;
    private JComboBox cbbHienTrangPhong;
    private JButton btnThem, btnSua, btnXoa, btnTim;
    private ArrayList<PhongTroModel> phongTroModels = null;
    private String maPhong;
    
    public PhongTroUI(String title) {
        this.setTitle(title);
        ImageIcon img = new ImageIcon(".\\src\\QuanLyNhaTroMySQL.Icon\\title.png");
        this.setIconImage(img.getImage());
        this.addControls();
        this.addEvent();
    }//constructor

    public void showWindows() {
        this.setSize(1145, 518);
        this.setLocation(225, 135);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setModal(true);
        this.setVisible(true);
    }//show windows

    private void addControls() {
        Container container = getContentPane();
            JPanel pnMain = new JPanel(new BorderLayout());
                JPanel pnCenter = new JPanel(new BorderLayout());
                    JPanel pnCenterLeft = new JPanel();
                    JPanel pnCenterRight = new JPanel();
                    pnCenterLeft.setPreferredSize(new Dimension(700 ,0));
                    pnCenterRight.setLayout(new BoxLayout(pnCenterRight, BoxLayout.Y_AXIS));
                JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnCenterLeft, pnCenterRight);
                    
                pnCenter.add(splitPane, BorderLayout.CENTER);
                    pnCenterLeft.setLayout(new BorderLayout());
                        model = new DefaultTableModel();
                        model.addColumn("Mã Phòng");
                        model.addColumn("Hiện trạng phòng");
                        model.addColumn("Giá phòng");
                        tbPhongTro = new JTable(model);
                        tbPhongTro.setBackground(Color.decode("#0489B1"));
                        tbPhongTro.setForeground(Color.WHITE);
                        tbPhongTro.setSelectionBackground(Color.WHITE);
                        tbPhongTro.setSelectionForeground(Color.decode("#086A87"));
                        tbPhongTro.setShowGrid(false);
                        JScrollPane scrollPaneTBPhongTro = new JScrollPane(tbPhongTro, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    pnCenterLeft.add(scrollPaneTBPhongTro, BorderLayout.CENTER);
                    
                        //Tim kiem
                        JPanel pnTimKiem = new JPanel();
                        pnTimKiem.setPreferredSize(new Dimension(0,140));
                        TitledBorder titledBorderTimKiem = new TitledBorder(BorderFactory.createLineBorder(Color.WHITE), "Tìm Kiếm");
                        titledBorderTimKiem.setTitleColor(Color.WHITE);
                        pnTimKiem.setBorder(titledBorderTimKiem);
                        pnTimKiem.setBackground(Color.decode("#0489B1"));
                        pnTimKiem.setLayout(new BoxLayout(pnTimKiem, BoxLayout.Y_AXIS));
                            JPanel pnline = new JPanel();
                            pnline.setBackground(Color.decode("#0489B1"));
                            JLabel lblLine = new JLabel();
                            pnline.add(lblLine);
                        pnTimKiem.add(pnline);
                        
                            //pn text field tim kiem
                            JPanel pnTim = new JPanel();
                            pnline.setBackground(Color.decode("#0489B1"));
                            JLabel lblTimKiem = new JLabel("Nhập nội dung");
                            lblTimKiem.setForeground(Color.WHITE);
                            pnTim.add(lblTimKiem);
                            txtTimKiem = new JTextField(15);
                            pnTim.add(txtTimKiem);
                            pnTim.setBackground(Color.decode("#0489B1"));
                        pnTimKiem.add(pnTim);
                        
                            //pn btn Bat dau tim
                            JPanel pnBatDauTim = new JPanel();
                            JLabel lblTabTimKiem1 = new JLabel("                ");
                            pnBatDauTim.add(lblTabTimKiem1);
                            pnBatDauTim.setBackground(Color.decode("#0489B1"));
                            btnTim = new JButton("Search");
                            btnTim.setIcon(new ImageIcon(".\\src\\QuanLyNhaTroMySQL.Icon\\timPhong.png"));
                            btnTim.setForeground(Color.decode("#086A87"));
                            btnTim.setBackground(Color.WHITE);
                            pnBatDauTim.add(btnTim);
                            
                            //can le
                            btnTim.setPreferredSize(lblTimKiem.getPreferredSize());
                            btnTim.setPreferredSize(new Dimension(120, 40));
                            
                        pnTimKiem.add(pnBatDauTim);
                    pnCenterRight.add(pnTimKiem);
                        
                    //chi tiet phong
                        JPanel pnChiTiet = new JPanel();
                        pnChiTiet.setLayout(new BoxLayout(pnChiTiet, BoxLayout.Y_AXIS));
                        TitledBorder titledBorderChiTiet = new TitledBorder(BorderFactory.createLineBorder(Color.WHITE), "Chi Tiết");
                        titledBorderChiTiet.setTitleColor(Color.WHITE);
                        pnChiTiet.setBorder(titledBorderChiTiet);
                        pnChiTiet.setBackground(Color.decode("#0489B1"));
                            
                            //Ma phong
                            JPanel pnMaPhong = new JPanel();
                                JLabel lblMaPhong = new JLabel("Mã Phòng");
                                lblMaPhong.setForeground(Color.WHITE);
                            pnMaPhong.add(lblMaPhong);
                                txtMaPhong = new JTextField(15);
                            pnMaPhong.add(txtMaPhong);
                            pnMaPhong.setBackground(Color.decode("#0489B1"));
                        pnChiTiet.add(pnMaPhong);
                        
                            //Hien trang phong
                            JPanel pnHienTrangPhong = new JPanel();
                                JLabel lblHienTrangPhong = new JLabel("Hiện trạng phòng");
                                lblHienTrangPhong.setForeground(Color.WHITE);
                            pnHienTrangPhong.add(lblHienTrangPhong);
                                cbbHienTrangPhong = new JComboBox();
                                cbbHienTrangPhong.setBackground(Color.white);
                                cbbHienTrangPhong.setForeground(Color.decode("#086A87"));
                                cbbHienTrangPhong.addItem("Đang Sử dụng");
                                cbbHienTrangPhong.addItem("Trống");
                                        
                            pnHienTrangPhong.add(cbbHienTrangPhong);
                            pnHienTrangPhong.setBackground(Color.decode("#0489B1"));
                            lblTimKiem.setPreferredSize(lblHienTrangPhong.getPreferredSize());
                        pnChiTiet.add(pnHienTrangPhong);
                        
                            //gia phong
                            JPanel pnGiaPhong = new JPanel();
                            pnGiaPhong.setBackground(Color.decode("#0489B1"));
                                JLabel lblGiaPhong = new JLabel("Giá phòng");
                                lblGiaPhong.setForeground(Color.WHITE);
                            pnGiaPhong.add(lblGiaPhong);
                                txtGiaPhong = new JTextField(15);
                            pnGiaPhong.add(txtGiaPhong);
                        pnChiTiet.add(pnGiaPhong);
                        
                            //Can le
                            lblMaPhong.setPreferredSize(lblHienTrangPhong.getPreferredSize());
                            lblGiaPhong.setPreferredSize(lblHienTrangPhong.getPreferredSize());
                            cbbHienTrangPhong.setPreferredSize(new Dimension(168,23 ));
                    pnCenterRight.add(pnChiTiet);
                    
                        //Chuc nang
                        JPanel pnChucNang = new JPanel();
                        TitledBorder titledBorderChucNang = new TitledBorder(BorderFactory.createLineBorder(Color.WHITE), "Chức Năng");
                        titledBorderChucNang.setTitleColor(Color.WHITE);
                        pnChucNang.setBorder(titledBorderChucNang);
                        pnChucNang.setBackground(Color.decode("#0489B1"));
                        pnChucNang.setLayout(new BoxLayout(pnChucNang, BoxLayout.Y_AXIS));
                            
                            //Them
                            JPanel pnThem = new JPanel();
                                btnThem = new JButton("Thêm     ");
                                btnThem.setIcon(new ImageIcon(".\\src\\QuanLyNhaTroMySQL.Icon\\themPhong.png"));
                                btnThem.setPreferredSize(new Dimension(120, 40));
                                btnThem.setForeground(Color.decode("#086A87"));
                                btnThem.setBackground(Color.WHITE);
                            pnThem.add(btnThem);
                            pnThem.setBackground(Color.decode("#0489B1"));
                        pnChucNang.add(pnThem);
                        
                            //Sua
                            JPanel pnSua = new JPanel();
                                btnSua = new JButton("Cập nhật");
                                btnSua.setIcon(new ImageIcon(".\\src\\QuanLyNhaTroMySQL.Icon\\suaPhong.png"));
                                btnSua.setPreferredSize(new Dimension(120, 40));
                                btnSua.setForeground(Color.decode("#086A87"));
                                btnSua.setBackground(Color.WHITE);
                            pnSua.add(btnSua);
                            pnSua.setBackground(Color.decode("#0489B1"));
                        pnChucNang.add(pnSua);
                        
                            //Xoa
                            JPanel pnXoa = new JPanel();
                                btnXoa = new JButton("Xóa         ");
                                btnXoa.setIcon(new ImageIcon(".\\src\\QuanLyNhaTroMySQL.Icon\\xoaPhong.png"));
                                btnXoa.setPreferredSize(new Dimension(120, 40));
                                btnXoa.setForeground(Color.decode("#086A87"));
                                btnXoa.setBackground(Color.WHITE);
                            pnXoa.add(btnXoa);
                            pnXoa.setBackground(Color.decode("#0489B1"));
                        pnChucNang.add(pnXoa);
                    pnCenterRight.add(pnChucNang);
                        
            pnMain.add(pnCenter, BorderLayout.CENTER);
        container.add(pnMain);
    }//add Controls

    private void addEvent() {
        xuLyHienThiPhongTro();
        tbPhongTro.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                xuLyLayMaPhong();
            }//click vao tbPhong

            @Override
            public void mousePressed(MouseEvent me) {
                
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                
            }

            @Override
            public void mouseEntered(MouseEvent me) {
               
            }

            @Override
            public void mouseExited(MouseEvent me) {
                
            }
        });
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                xuLyThemPhong();
            }
        });
        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                xuLySuaPhong();
            }
        });
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                xuLyXoaPhong();
            }
        });
        btnTim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                xuLyTimKiem();
            }
        });
    }//add Event
    
//----------------------CAC HAM XU LY-------------------------------------------    
    private void xuLyLayMaPhong(){
        int result = tbPhongTro.getSelectedRow();
        maPhong = (String) tbPhongTro.getValueAt(result, 0);
        cbbHienTrangPhong.setSelectedIndex(0);
        
        duaThongTinPhongTroVaoTextField(maPhong);
    }//lay ma phong
    
    private void xuLyHienThiPhongTro() {
        PhongTroService phongTroService = new PhongTroService();
        phongTroModels = phongTroService.layToanBoPhongTro();
        
        model.setRowCount(0);
        for (PhongTroModel phongTroModel : phongTroModels) {
            Vector vtRow = new Vector();
            vtRow.add(phongTroModel.getMaPhong());
            vtRow.add(phongTroModel.getHienTrangPhon());
            vtRow.add(phongTroModel.getGiaPhong());
            model.addRow(vtRow);
        }
    }//xu ly hien thi phong tro

    private void xuLyThemPhong() {
        if(checkMaPhong(txtMaPhong.getText())==false){
            JOptionPane.showMessageDialog(null, "Mã phòng phải định dạng theo [P+SoPhong]");
            txtMaPhong.requestFocus();
            return;
        }//kiem tra text field ma phong
        
        if (checkGia(txtGiaPhong.getText())==false){
             JOptionPane.showMessageDialog(null, "Giá phòng phải là ký tự số.\n Vui lòn kiểm tra lại !");
            txtGiaPhong.requestFocus();
            return;
        }//kiem gia txt field gia phong
        
        PhongTroService phongTroService = new PhongTroService();
        if (phongTroService.kiemTraPhongDaTonTai(txtMaPhong.getText())==false) {
            int result = phongTroService.themPhong(txtMaPhong.getText(), cbbHienTrangPhong.getSelectedItem().toString(),
                    Float.valueOf(txtGiaPhong.getText()));
            
            model.setRowCount(0);
            if (result > 0) {
                xuLyHienThiPhongTro();
                JOptionPane.showMessageDialog(null, "Đã thêm !");
            } else {
                JOptionPane.showMessageDialog(null, "Thêm thất bại");
                return;
            }
        }else{
            JOptionPane.showMessageDialog(null, "Phòng đã tồn tại. Vui lòng kiểm tra lại");
            txtMaPhong.requestFocus();
            return;
        }
                      
    }//Xu ly them phong

    private void duaThongTinPhongTroVaoTextField(String maPhong) {
        PhongTroService phongTroService = new PhongTroService();
        phongTroModels = phongTroService.layThongTinTungPhongTro(maPhong);
        
        for (PhongTroModel phongTroModel : phongTroModels) {
            txtMaPhong.setText(phongTroModel.getMaPhong());
            cbbHienTrangPhong.setSelectedItem(phongTroModel.getHienTrangPhon());
            txtGiaPhong.setText(phongTroModel.getGiaPhong()+"");
        }
    }
    
    private void xuLySuaPhong() {
        if (checkMaPhong(txtMaPhong.getText()) == false) {
            JOptionPane.showMessageDialog(null, "Mã phòng phải định dạng theo [P+SoPhong]");
            txtMaPhong.requestFocus();
            return;
        }//kiem tra text field ma phong
        
        if (checkGia(txtGiaPhong.getText()) == false) {
            JOptionPane.showMessageDialog(null, "Giá phòng phải là ký tự số.\n Vui lòng kiểm tra lại !");
            txtGiaPhong.requestFocus();
            return;
        }//kiem gia txt field gia phong

        PhongTroService phongTroService = new PhongTroService();
        if (phongTroService.kiemTraPhongDaTonTai(txtMaPhong.getText())) {

            int result = phongTroService.suaPhong(txtMaPhong.getText(),
                    cbbHienTrangPhong.getSelectedItem().toString(),
                    Float.valueOf(txtGiaPhong.getText()));
            
            if (result > 0) {
                xuLyHienThiPhongTro();
                JOptionPane.showMessageDialog(null, "Đã cập nhật");
            } else {
                JOptionPane.showMessageDialog(null, "Cập nhật thất bại !");
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Phòng trọ không tồn tại. Vui lòng kiểm tra lại !");
            txtMaPhong.requestFocus();
            return;
        }
    }//xu ly sua phong
    
    private void xuLyXoaPhong() {
        int result = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa phòng [" + txtMaPhong.getText() + "]",
                "Xác Nhận", JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION) {
            PhongTroService phongTroService = new PhongTroService();
            int x = phongTroService.xoaPhong(maPhong);
            if(x>0){
                xuLyHienThiPhongTro();
                JOptionPane.showMessageDialog(null, "Đã xóa!");
            }else{
                JOptionPane.showMessageDialog(null, "Phòng đang được sử dụng. Vui lòng kiểm tra lại");
            }
            
        } 

    }//xoa phong

    private void xuLyTimKiem() {
         PhongTroService phongTroService = new PhongTroService();
        phongTroModels = phongTroService.timKiemPhong(txtTimKiem.getText());
        
        model.setRowCount(0);
        for (PhongTroModel phongTroModel : phongTroModels) {
            Vector vtRow = new Vector();
            vtRow.add(phongTroModel.getMaPhong());
            vtRow.add(phongTroModel.getHienTrangPhon());
            vtRow.add(phongTroModel.getGiaPhong());
            model.addRow(vtRow);
        }
    }//tim kiem phong
    //----------------------KIEM TRA HOP LE-------------------------------------
    public boolean checkMaPhong(String maPhong){
        String pattern ="P\\d+";
        return maPhong.matches(pattern);
    }//check ma phong
    
    public boolean checkGia(String giaPhong){
        String pattern ="\\d+([.]\\d)?";
        return giaPhong.matches(pattern);
    }//check gia phong
    
}
