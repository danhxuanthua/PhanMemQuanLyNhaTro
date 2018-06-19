/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyNhaTroMySQL.UI;

import QuanLyNhaTroMySQL.Model.KhachHangModel;
import QuanLyNhaTroMySQL.Service.KhachHangService;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
public class KhachHangUI extends JDialog{

    private DefaultTableModel model;
    private JTable tbKhachHang;
    private JTextField txtMaKhachHang, txtTenKhachHang, txtNamSinh, txtCMND;
    private JTextField txtDiaChi, txtNgheNghep, txtSDT, txtTimKiem;
    private JButton btnThem, btnSua, btnXoa, btnTimKiem;
    private ArrayList<KhachHangModel> khachHangModels = null;
    private String maKhachHang; // luu maKH khi click vao tbKhachHang duoc xu ly trong ham xuLyLayMaKhachHang()
    public KhachHangUI(String tiele) {
        this.setTitle(tiele);
        ImageIcon img = new ImageIcon(".\\src\\QuanLyNhaTroMySQL.Icon\\title.png");
        this.setIconImage(img.getImage());
        this.addControls();
        this.addEvent();
    }//canstructor

    public void showWindows() {
        this.setSize(1145, 518);
        this.setLocation(225, 135);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setModal(true);
        this.setVisible(true);
    }//show dialog

    private void addControls() {
        Container container = getContentPane();
            JPanel pnMain = new JPanel(new BorderLayout());
            pnMain.setBackground(Color.decode("#0489B1"));
                //pn Top
                JPanel pnTop = new JPanel();
                pnTop.setBackground(Color.decode("#0489B1"));
                pnTop.setLayout(new BorderLayout());
                JPanel pnBottom = new JPanel();
               
                //table khach hang
                    JPanel pnTopCenterTBKhachHang = new JPanel(new BorderLayout());
                        model = new DefaultTableModel();
                        model.addColumn("Mã Khách Hàng");
                        model.addColumn("Tên Khách Hàng");
                        model.addColumn("Năm Sinh");
                        model.addColumn("Số CMND");
                        model.addColumn("Địa Chỉ");
                        model.addColumn("Nghề Nghiệp");
                        model.addColumn("Số Điện Thoại");
                        tbKhachHang = new JTable(model);
                        tbKhachHang.setBackground(Color.decode("#0489B1"));
                        tbKhachHang.setForeground(Color.WHITE);
                        tbKhachHang.setSelectionBackground(Color.WHITE);
                        tbKhachHang.setSelectionForeground(Color.decode("#086A87"));
                        tbKhachHang.setShowGrid(false);
                                
                        JScrollPane ScrollPaneTBKhachHang = new JScrollPane(tbKhachHang, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                    pnTopCenterTBKhachHang.add(ScrollPaneTBKhachHang, BorderLayout.CENTER);
                pnTop.add(pnTopCenterTBKhachHang, BorderLayout.CENTER);
                pnTop.setPreferredSize(new Dimension(0, 290));
                
                //pn Bottom
                pnBottom.setLayout(new BorderLayout());
                
                    //Nhap Lieu
                    JPanel pnNhapLieu = new JPanel();
                    pnNhapLieu.setLayout(new BoxLayout(pnNhapLieu, BoxLayout.Y_AXIS));
                    TitledBorder titledBorderNhapLieu = new TitledBorder(BorderFactory.createLineBorder(Color.WHITE), "Thông Tin Khách Hàng");
                    titledBorderNhapLieu.setTitleColor(Color.white);
                    pnNhapLieu.setBorder(titledBorderNhapLieu);
                    pnNhapLieu.setBackground(Color.decode("#0489B1"));
                    
                        //ma khach hang
                        JPanel pnMaKhachHang = new JPanel();
                        pnMaKhachHang.setBackground(Color.decode("#0489B1"));
                            JLabel lblMaKhachHang = new JLabel("Mã Khách Hàng");
                            lblMaKhachHang.setForeground(Color.WHITE);
                        pnMaKhachHang.add(lblMaKhachHang);
                            txtMaKhachHang = new JTextField(15);
                        pnMaKhachHang.add(txtMaKhachHang);
                        
                        //Ten khach hang
                            JLabel lblTenKhachHang = new JLabel("Tên Khách Hàng");
                            lblTenKhachHang.setForeground(Color.WHITE);
                        pnMaKhachHang.add(lblTenKhachHang);
                            txtTenKhachHang = new JTextField(15);
                        pnMaKhachHang.add(txtTenKhachHang);
                    pnNhapLieu.add(pnMaKhachHang);
                    
                        //Nam Sinh
                        JPanel pnNamSinh = new JPanel();
                        pnNamSinh.setBackground(Color.decode("#0489B1"));
                            JLabel lblNamSinh = new JLabel("Năm Sinh");
                            lblNamSinh.setForeground(Color.WHITE);
                        pnNamSinh.add(lblNamSinh);
                            txtNamSinh = new JTextField(15);
                        pnNamSinh.add(txtNamSinh);
                        
                        //CMND
                            JLabel lblCMND = new JLabel("Số CMND");
                            lblCMND.setForeground(Color.WHITE);
                        pnNamSinh.add(lblCMND);
                            txtCMND = new JTextField(15);
                        pnNamSinh.add(txtCMND);
                    pnNhapLieu.add(pnNamSinh);
                    
                        //DiaChi
                        JPanel pnDiaChi = new JPanel();
                        pnDiaChi.setBackground(Color.decode("#0489B1"));
                            JLabel lblDiaChi = new JLabel("Địa Chỉ");
                            lblDiaChi.setForeground(Color.WHITE);
                        pnDiaChi.add(lblDiaChi);
                            txtDiaChi = new JTextField(15);
                        pnDiaChi.add(txtDiaChi);
                        
                        //Nghe nghiep
                            JLabel lblNgheNghiep = new JLabel("Nghề Nghiệp");
                            lblNgheNghiep.setForeground(Color.WHITE);
                        pnDiaChi.add(lblNgheNghiep);
                            txtNgheNghep = new JTextField(15);
                        pnDiaChi.add(txtNgheNghep);
                    pnNhapLieu.add(pnDiaChi);
                    
                        //SDT
                        JPanel pnSDT = new JPanel();
                        pnSDT.setBackground(Color.decode("#0489B1"));
                            JLabel lblSDT = new JLabel("Số Điện Thoại");
                            lblSDT.setForeground(Color.WHITE);
                        pnSDT.add(lblSDT);
                            txtSDT = new JTextField(15);
                        pnSDT.add(txtSDT);
                        
                        //Tim kiem
                            JLabel lblTimKiem = new JLabel("Tìm kiếm");
                            lblTimKiem.setForeground(Color.WHITE);
                        pnSDT.add(lblTimKiem);
                            txtTimKiem = new JTextField(15);
                        pnSDT.add(txtTimKiem);
                    pnNhapLieu.add(pnSDT);
                    
                    //can le
                    lblNamSinh.setPreferredSize(lblMaKhachHang.getPreferredSize());
                    lblCMND.setPreferredSize(lblTenKhachHang.getPreferredSize());
                    lblDiaChi.setPreferredSize(lblMaKhachHang.getPreferredSize());
                    lblNgheNghiep.setPreferredSize(lblTenKhachHang.getPreferredSize());
                    lblSDT.setPreferredSize(lblMaKhachHang.getPreferredSize());
                    lblTimKiem.setPreferredSize(lblTenKhachHang.getPreferredSize());
                
                pnBottom.add(pnNhapLieu,BorderLayout.WEST);
                
                    //Chuc Nang
                    JPanel pnChucNang = new JPanel();
                    pnChucNang.setLayout(new BoxLayout(pnChucNang, BoxLayout.Y_AXIS));
                    TitledBorder titledBorderChucNang = new TitledBorder(BorderFactory.createLineBorder(Color.WHITE), "Chức Năng");
                    titledBorderChucNang.setTitleColor(Color.WHITE);
                    pnChucNang.setBorder(titledBorderChucNang);
                    pnChucNang.setBackground(Color.decode("#0489B1"));
                    
                        //Them
                        JPanel pnThem = new JPanel(new FlowLayout(FlowLayout.LEFT));
                        pnThem.setBackground(Color.decode("#0489B1"));
                            JLabel lblTabThem = new JLabel("        ");
                        pnThem.add(lblTabThem);
                            btnThem = new JButton("Thêm");
                            btnThem.setIcon(new ImageIcon(".\\src\\QuanLyNhaTroMySQL.Icon\\themKhachHang.png"));
                            btnThem.setBackground(Color.WHITE);
                            btnThem.setForeground(Color.decode("#086A87"));
                        pnThem.add(btnThem);
                        
                        //Tim kiem
                            JLabel lblTabTimKiem = new JLabel("        ");
                        pnThem.add(lblTabTimKiem);
                            btnTimKiem = new JButton("Search");
                            btnTimKiem.setIcon(new ImageIcon(".\\src\\QuanLyNhaTroMySQL.Icon\\timKhachHang.png"));
                            btnTimKiem.setBackground(Color.WHITE);
                            btnTimKiem.setForeground(Color.decode("#086A87"));
                        pnThem.add(btnTimKiem);
                    pnChucNang.add(pnThem);
                    
                        //sua
                        JPanel pnSua = new JPanel(new FlowLayout(FlowLayout.LEFT));
                        pnSua.setBackground(Color.decode("#0489B1"));
                            JLabel lblTabSua = new JLabel("        ");
                        pnSua.add(lblTabSua);
                            btnSua = new JButton("Sửa");
                            btnSua.setIcon(new ImageIcon(".\\src\\QuanLyNhaTroMySQL.Icon\\capNhatKhachHang.png"));
                            btnSua.setBackground(Color.WHITE);
                            btnSua.setForeground(Color.decode("#086A87"));
                        pnSua.add(btnSua);
                    pnChucNang.add(pnSua);
                    
                        //Xoa
                        JPanel pnXoa = new JPanel(new FlowLayout(FlowLayout.LEFT));
                        pnXoa.setBackground(Color.decode("#0489B1"));
                            JLabel lblTabXoa = new JLabel("        ");
                        pnXoa.add(lblTabXoa);
                            btnXoa = new JButton("Xóa");
                            btnXoa.setIcon(new ImageIcon(".\\src\\QuanLyNhaTroMySQL.Icon\\xoaKhachHang.png"));
                            btnXoa.setBackground(Color.WHITE);
                            btnXoa.setForeground(Color.decode("#086A87"));
                        pnXoa.add(btnXoa);
                        
                            //Can chinh button
                            btnThem.setPreferredSize(new Dimension(120, 40));
                            btnSua.setPreferredSize(btnThem.getPreferredSize());
                            btnXoa.setPreferredSize(btnThem.getPreferredSize());
                    pnChucNang.add(pnXoa);
                pnBottom.add(pnChucNang, BorderLayout.CENTER);
                
            pnMain.add(pnTop, BorderLayout.NORTH);
            pnMain.add(pnBottom, BorderLayout.CENTER);
        container.add(pnMain); 
    }

    private void addEvent() {
       xuLyHienThiKhachHang();
       
       tbKhachHang.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                xuLyLayMaKhachHang();
                xuLyHienThiThongTinTungKhachHang();
            }

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
               xuLyKiemTraVaThemKhachHang();
           }
       });
       
       btnSua.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
               xuLyKiemTraVaSuaKhachHang();
           }
       });
       
       btnXoa.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
               xuLyXoaKhachHang();
           }
       });
       
       btnTimKiem.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
               xuLyTimKiemKhachHang();
           }
       });
    }//add Event
    
    //--------------------------CAC HAM XU LY SU KIEN---------------------------
    private void xuLyHienThiKhachHang() {
        KhachHangService khachHangService = new KhachHangService();
        khachHangModels = khachHangService.layToanBoKhachHang();
        model.setRowCount(0);
        
        for (KhachHangModel khachHangModel : khachHangModels) {
            Vector vtRow = new Vector();
            vtRow.add(khachHangModel.getMaKhachHang());
            vtRow.add(khachHangModel.getTenKhachHang());
            vtRow.add(khachHangModel.getNamSinh());
            vtRow.add(khachHangModel.getcMND());
            vtRow.add(khachHangModel.getDiaChi());
            vtRow.add(khachHangModel.getNgheNghiep());
            vtRow.add(khachHangModel.getsDT());
            model.addRow(vtRow);
        }
        
    }//Hien thi danh sach khach hang
    
    private void xuLyLayMaKhachHang() {
        int result = tbKhachHang.getSelectedRow();
        maKhachHang = (String) tbKhachHang.getValueAt(result, 0);
    }//lay ma khach hang khi click vao tbKhachHang
    
    private void xuLyHienThiThongTinTungKhachHang(){
        KhachHangService khachHangService = new KhachHangService();
        khachHangModels = khachHangService.layThongTinTungKhachHang(maKhachHang);
        
        for (KhachHangModel khachHangModel : khachHangModels) {
            txtMaKhachHang.setText(khachHangModel.getMaKhachHang());
            txtTenKhachHang.setText(khachHangModel.getTenKhachHang());
            txtNamSinh.setText(khachHangModel.getNamSinh());
            txtCMND.setText(String.valueOf(khachHangModel.getcMND()));
            txtDiaChi.setText(khachHangModel.getDiaChi());
            txtNgheNghep.setText(khachHangModel.getNgheNghiep());
            txtSDT.setText(String.valueOf(khachHangModel.getsDT()));
        }
    }//hien thi thong tin khi click vao tbKH sau do dua vao cac text filed tuong ung
    
    private void xuLyThemKhachHang() {
        KhachHangService khachHangService = new KhachHangService();
        int result = khachHangService.themKhachHang(txtMaKhachHang.getText(), txtTenKhachHang.getText(),
                txtNamSinh.getText(), Integer.valueOf(txtCMND.getText()),
                txtDiaChi.getText(), txtNgheNghep.getText(), Integer.valueOf(txtSDT.getText()));

        if (result > 0) {
            xuLyHienThiKhachHang();
        } else {
            JOptionPane.showMessageDialog(null, "Thêm thất bại");
        }
    }//xu them khach hang khong can kiem tra maKH da ton tai hay chua
    
    private void xuLyKiemTraVaThemKhachHang() {
        if(checkMaKhachHang(txtMaKhachHang.getText())==false){
            JOptionPane.showMessageDialog(null, "Mã khách hàng phải bắt đầu bằng [KH]\nVui lòng kiểm tra lại !");
            txtMaKhachHang.requestFocus();
            return;
        }//Kiem tra ma khach hang co hop le hay khong
        
        if(checkTenKhachHang(txtTenKhachHang.getText())==true){
            JOptionPane.showMessageDialog(null, "Tên khách hàng không được chứa ký tụ số\nVui lòng kiểm tra lại !");
            txtTenKhachHang.requestFocus();
            return;
        }//Kiem tra ten khach hang co hop le hay khong
        
        if(checkNamSinh(txtNamSinh.getText())==false){
            JOptionPane.showMessageDialog(null, "Năm sinh phải có dạng [YYYY-DD-MM]\n Vui lòng kiểm tra lại");
            txtNamSinh.requestFocus();
            return;
        }//Kiem tra NamSinh
        
        if(checkCMND(txtCMND.getText())==false){
            JOptionPane.showMessageDialog(null, "Số CMND phải là ký tự số. Vui lòng kiểm tra lại");
            txtSDT.requestFocus();
            return;
        }//kiem tra cmnd
        
        if(checkSDT(txtSDT.getText())==false){
            JOptionPane.showMessageDialog(null, "Số điện thoại phải là ký tự số. Vui lòng kiểm tra lại");
            txtSDT.requestFocus();
            return;
        }//check SDT
        
        KhachHangService khachHangService = new KhachHangService();
        boolean checkMaKH = khachHangService.kiemTraKhachHangDaTonTai(txtMaKhachHang.getText());
        
        if(checkMaKH == false){
            xuLyThemKhachHang();
            JOptionPane.showMessageDialog(null, "Đã thêm !");
        }else{
            JOptionPane.showMessageDialog(null, "Khách hàng đã tồn tại. Vui lòng kiểm tra lại");
            txtMaKhachHang.requestFocus();
            return;
        }
    }
    
    private void xuLySuaKhachHang(){
        KhachHangService khachHangService = new KhachHangService();
        int result = khachHangService.SuaKhachHang(txtMaKhachHang.getText(), txtTenKhachHang.getText(),
                    txtNamSinh.getText(), Integer.valueOf(txtCMND.getText()),
                    txtDiaChi.getText(), txtNgheNghep.getText(), Integer.valueOf(txtSDT.getText()));
        
        model.setRowCount(0);
        if(result > 0){
            xuLyHienThiKhachHang();
            JOptionPane.showMessageDialog(null, "Đã cập nhật !");
        }else{
            JOptionPane.showMessageDialog(null, "Cập nhật thông tin khách hàng thất bại");
        }
    }//xu ly sua thong tin khach hang
    
    private void xuLyKiemTraVaSuaKhachHang() {
        KhachHangService khachHangService = new KhachHangService();
        boolean checkMaKH = khachHangService.kiemTraKhachHangDaTonTai(txtMaKhachHang.getText());
        
        if(checkMaKH){
            xuLySuaKhachHang();
        }else{
            JOptionPane.showMessageDialog(null, "Khách hàng không tồn tại. \n Vui lòng kiểm tra lại !");
            txtMaKhachHang.requestFocus();
            return;
        }
    }//kiem tra neu  maKH ton tai thi tien hanh sua. Nguoc lai se bao loi
    
    private void xuLyXoaKhachHang() {
        KhachHangService khachHangService = new KhachHangService();
        int result = JOptionPane.showConfirmDialog(null,"Bạn thật sự muốn xóa khách hàng ["+txtTenKhachHang.getText()+"] ?","Xác Nhận", JOptionPane.YES_NO_OPTION);
        
        if(JOptionPane.YES_OPTION == result){
            int x = khachHangService.xoaKhachHang(txtMaKhachHang.getText());
            if(x>0){
                xuLyHienThiKhachHang();
                JOptionPane.showMessageDialog(null, "Đã xóa");
            }else{
                JOptionPane.showMessageDialog(null, "Xóa thất bại.\n Vui lòng kiểm tra lại!");
                return;
            }
            
        }
    }//xoa khach hang
    
    private void xuLyTimKiemKhachHang() {
        KhachHangService khachHangService = new KhachHangService();
        khachHangModels = khachHangService.timKiemKhachHang(txtTimKiem.getText());
        
        model.setRowCount(0);
        for (KhachHangModel khachHangModel : khachHangModels) {
            Vector vtRow = new Vector();
            vtRow.add(khachHangModel.getMaKhachHang());
            vtRow.add(khachHangModel.getTenKhachHang());
            vtRow.add(khachHangModel.getNamSinh());
            vtRow.add(khachHangModel.getcMND());
            vtRow.add(khachHangModel.getDiaChi());
            vtRow.add(khachHangModel.getNgheNghiep());
            vtRow.add(khachHangModel.getsDT());
            model.addRow(vtRow);
        }
    }//Tìm kiem khach hang
    
    //---------------------------CAC HAM KIEM TRA-------------------------------
    private boolean checkMaKhachHang(String maKhachHang){
        String pattern="KH\\d+";
        return maKhachHang.matches(pattern);
    }//check textField MaKH
    
    private boolean checkTenKhachHang(String tenKhachHang){
        String pattern="\\s+";
        return tenKhachHang.matches(pattern);
    }//check textField TenKH
    
    private boolean checkNamSinh(String namSinh){
        String pattern="\\d{4}-\\d{1,2}-\\d{1,2}";
        return namSinh.matches(pattern);
    }//Check NamSinh
    
    private boolean checkCMND(String cMND){
        String pattern="\\d{1,11}";
        return cMND.matches(pattern);
    }//check CMND
    
    private boolean checkSDT(String sDT){
        String pattern="\\d{1,11}";
        return sDT.matches(pattern);
    }//check sdt
}
