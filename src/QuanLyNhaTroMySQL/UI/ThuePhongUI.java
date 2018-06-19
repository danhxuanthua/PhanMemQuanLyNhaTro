/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyNhaTroMySQL.UI;

import QuanLyNhaTroMySQL.Model.KhachHangModel;
import QuanLyNhaTroMySQL.Model.PhongTroModel;
import QuanLyNhaTroMySQL.Model.ThietBiModel;
import QuanLyNhaTroMySQL.Model.ThuePhongModel;
import QuanLyNhaTroMySQL.Model.TrangBiModel;
import QuanLyNhaTroMySQL.Service.KhachHangService;
import QuanLyNhaTroMySQL.Service.PhongTroService;
import QuanLyNhaTroMySQL.Service.ThietBiService;
import QuanLyNhaTroMySQL.Service.ThuePhongService;
import QuanLyNhaTroMySQL.Service.TrangBiSevice;
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
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DanhThua
 */
public class ThuePhongUI extends JDialog{

    private JComboBox  cbbMaKhachHang, cbbMaPhong;
    private JTextField txtNgayThue, txtNgayTra, txtTraTruoc, txtTraSau, txtMaPhieuDangKy;
    private JTextArea txtChuThich;
    private JButton btnThem, btnSua, btnXoa;
    private DefaultTableModel modelDangKyThuePhong;
    private JTable tbDangKyThuePhong;
    private ArrayList<KhachHangModel> khachHangModels = null;
    private ArrayList<PhongTroModel> phongTroModels = null;
    private ArrayList<ThuePhongModel> thuePhongModels = null;
    public ThuePhongUI(String title) {
        this.setTitle(title);
        ImageIcon img = new ImageIcon(".\\src\\QuanLyNhaTroMySQL.Icon\\title.png");
        this.setIconImage(img.getImage());
        this.addControls();
        this.addEvent();
    }//Constructor
    
    public void showWindows() {
        this.setSize(1145, 618);
        this.setLocation(225, 115);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setModal(true);
        this.setVisible(true);
    }//show Windows
    
    private void addControls() {
        Container container = getContentPane();
            JPanel pnMain = new JPanel(new BorderLayout());
                
                //Pn Top
                JPanel pnTop = new JPanel(new BorderLayout());
                    
                    //Pn TopLeft
                    JPanel pnTopLeft = new JPanel(new BorderLayout());
                    
                        //Ma phieu dang ky
                        JPanel pnPhieuDangKy = new JPanel();
                        pnPhieuDangKy.setLayout(new BoxLayout(pnPhieuDangKy, BoxLayout.Y_AXIS));
                        
                        pnPhieuDangKy.setBackground(Color.decode("#0489B1"));
                        
                        TitledBorder titledBorderPhieuDangKy = new TitledBorder(BorderFactory.createLineBorder(Color.WHITE), "Phiếu Đăng Ký Thuê Phòng");
                        titledBorderPhieuDangKy.setTitleColor(Color.WHITE);
                        pnPhieuDangKy.setBorder(titledBorderPhieuDangKy);
                            
                            //pnMaPDK
                            JPanel pnMaPhieuDangKy = new JPanel(new FlowLayout(FlowLayout.LEFT));
                            pnMaPhieuDangKy.setBackground(Color.decode("#0489B1"));
                                JLabel lblMaPhieuDangKy = new JLabel("Mã Phiếu Đăng Ký");
                                lblMaPhieuDangKy.setForeground(Color.WHITE);
                            pnMaPhieuDangKy.add(lblMaPhieuDangKy);  
                                txtMaPhieuDangKy = new JTextField(10);
                            pnMaPhieuDangKy.add(txtMaPhieuDangKy);
                            
                            //MaKH
                                JLabel lbltab1 = new JLabel("        ");
                            pnMaPhieuDangKy.add(lbltab1);
                                JLabel lblMaKhachHang = new JLabel("Mã Khách Hàng");
                                lblMaKhachHang.setForeground(Color.WHITE);
                            pnMaPhieuDangKy.add(lblMaKhachHang);
                                cbbMaKhachHang = new JComboBox();
                                cbbMaKhachHang.setPreferredSize(new Dimension(115, 25));
                                cbbMaKhachHang.addItem("Trống");
                                cbbMaKhachHang.setMaximumRowCount(7);
                                cbbMaKhachHang.setForeground(Color.decode("#086A87"));
                            pnMaPhieuDangKy.add(cbbMaKhachHang);
                            
                            //MaPhong
                                JLabel lbltab2 = new JLabel("        ");
                            pnMaPhieuDangKy.add(lbltab2);
                                JLabel lblMaPhong = new JLabel("Mã Phòng");
                                lblMaPhong.setForeground(Color.WHITE);
                            pnMaPhieuDangKy.add(lblMaPhong);
                                cbbMaPhong = new JComboBox();
                                cbbMaPhong.setPreferredSize(new Dimension(115, 25));
                                cbbMaPhong.addItem("Trống");
                                cbbMaPhong.setMaximumRowCount(7);
                                cbbMaPhong.setForeground(Color.decode("#086A87"));
                            pnMaPhieuDangKy.add(cbbMaPhong);
                                
                        pnPhieuDangKy.add(pnMaPhieuDangKy);
                        
                            //NgayThue
                            JPanel pnNgayThue = new JPanel(new FlowLayout(FlowLayout.LEFT));
                            pnNgayThue.setBackground(Color.decode("#0489B1"));
                            
                                JLabel lblNgayThue = new JLabel("Ngày Thuê");
                                lblNgayThue.setForeground(Color.WHITE);
                            pnNgayThue.add(lblNgayThue);
                                txtNgayThue = new JTextField(10);
                            pnNgayThue.add(txtNgayThue);
                            
                            //NgayTra
                            JLabel lbltab3 = new JLabel("        ");
                            pnNgayThue.add(lbltab3);
                                JLabel lblNgayTra = new JLabel("Ngày Trả");
                                lblNgayTra.setForeground(Color.WHITE);
                            pnNgayThue.add(lblNgayTra);
                                txtNgayTra = new JTextField(10);
                            pnNgayThue.add(txtNgayTra);
                            
                            //Tra truoc
                                JLabel lbltab4 = new JLabel("        ");
                            pnNgayThue.add(lbltab4);
                                JLabel lblTraTruoc = new JLabel("Trả Trước");
                                lblTraTruoc.setForeground(Color.WHITE);
                            pnNgayThue.add(lblTraTruoc);
                                txtTraTruoc = new JTextField(10);
                            pnNgayThue.add(txtTraTruoc);
                                    
                        pnPhieuDangKy.add(pnNgayThue);
                        
                            //Tra Sau
                            JPanel pnTraSau = new JPanel(new FlowLayout(FlowLayout.LEFT));
                            pnTraSau.setBackground(Color.decode("#0489B1"));
                                JLabel lblTraSau = new JLabel("Trả Sau");
                                lblTraSau.setForeground(Color.WHITE);
                            pnTraSau.add(lblTraSau);
                                txtTraSau = new JTextField(10);
                            pnTraSau.add(txtTraSau);
                            
                            //Chu thich
                                JLabel lbltab5 = new JLabel("        ");
                            pnTraSau.add(lbltab5);
                                JLabel lblChuThich = new JLabel("Chú Thích");
                                lblChuThich.setForeground(Color.WHITE);
                            pnTraSau.add(lblChuThich);
                                txtChuThich = new JTextArea(3,20);
                                txtChuThich.setLineWrap(true);
                                txtChuThich.setWrapStyleWord(true);
                                JScrollPane scroollChuThich =new JScrollPane(txtChuThich,
                                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                            pnTraSau.add(scroollChuThich);
                            
                            //Can le
                            lblNgayThue.setPreferredSize(lblMaPhieuDangKy.getPreferredSize());
                            lblTraSau.setPreferredSize(lblMaPhieuDangKy.getPreferredSize());
                            
                            lblNgayTra.setPreferredSize(lblMaKhachHang.getPreferredSize());
                            lblChuThich.setPreferredSize(lblMaKhachHang.getPreferredSize());
                            
                            lblMaPhong.setPreferredSize(lblTraTruoc.getPreferredSize());
                            
                        pnPhieuDangKy.add(pnTraSau);
                            
                    pnTopLeft.add(pnPhieuDangKy, BorderLayout.CENTER);
  
                pnTop.add(pnTopLeft, BorderLayout.WEST);
                
                    //TopRight
                    JPanel pnTopRight = new JPanel(new BorderLayout());
                        
                        JPanel pnChucNang = new JPanel();
                        pnChucNang.setLayout(new BoxLayout(pnChucNang, BoxLayout.Y_AXIS));
                            
                        TitledBorder titledBorderChucNang = new TitledBorder(BorderFactory.createLineBorder(Color.WHITE), "Chức Năng");
                        titledBorderChucNang.setTitleColor(Color.WHITE);
                        pnChucNang.setBorder(titledBorderChucNang);
                        
                        pnChucNang.setBackground(Color.decode("#0489B1"));
                        
                            //Them
                            JPanel pnThem = new JPanel();
                            pnThem.setBackground(Color.decode("#0489B1"));
                                btnThem = new JButton("Đăng ký");
                                btnThem.setIcon(new ImageIcon(".\\src\\QuanLyNhaTroMySQL.Icon\\themPDK.png"));
                                btnThem.setForeground(Color.decode("#086A87"));
                                btnThem.setBackground(Color.WHITE);
                            pnThem.add(btnThem);
                        pnChucNang.add(pnThem);
                            
                            //Sua
                            JPanel pnSua = new JPanel();
                            pnSua.setBackground(Color.decode("#0489B1"));
                                btnSua = new JButton("Cập nhật");
                                btnSua.setIcon(new ImageIcon(".\\src\\QuanLyNhaTroMySQL.Icon\\suaPDK.png"));
                                btnSua.setForeground(Color.decode("#086A87"));
                                btnSua.setBackground(Color.WHITE);
                            pnSua.add(btnSua);
                        pnChucNang.add(pnSua);
                            
                            //Xoa
                            JPanel pnXoa = new JPanel();
                            pnXoa.setBackground(Color.decode("#0489B1"));
                                btnXoa = new JButton("Xóa phiếu");
                                btnXoa.setIcon(new ImageIcon(".\\src\\QuanLyNhaTroMySQL.Icon\\xoaPDK.png"));
                                btnXoa.setForeground(Color.decode("#086A87"));
                                btnXoa.setBackground(Color.WHITE);
                            pnXoa.add(btnXoa);
                        pnChucNang.add(pnXoa);
                        
                            //can chinh button
                            btnThem.setPreferredSize(new Dimension(128, 40));
                            btnSua.setPreferredSize(btnThem.getPreferredSize());
                            btnXoa.setPreferredSize(btnThem.getPreferredSize());
                    pnTopRight.add(pnChucNang);
                pnTop.add(pnTopRight, BorderLayout.CENTER);
                
                //pnCenter
                JPanel pnCenter = new JPanel(new BorderLayout());
                TitledBorder titledPnCenter = new TitledBorder(BorderFactory.createLineBorder(Color.WHITE), "Danh sách phiếu đăng ký");
                titledPnCenter.setTitleColor(Color.WHITE);
                pnCenter.setBackground(Color.decode("#0489B1"));
                pnCenter.setBorder(titledPnCenter);
                    
                    modelDangKyThuePhong = new DefaultTableModel();
                    modelDangKyThuePhong.addColumn("Mã Phiếu Đăng Ký");
                    modelDangKyThuePhong.addColumn("Mã Khách Hàng");
                    modelDangKyThuePhong.addColumn("Mã Phòng");
                    modelDangKyThuePhong.addColumn("Ngày Thuê");
                    modelDangKyThuePhong.addColumn("Ngày Trả");
                    modelDangKyThuePhong.addColumn("Trả Trước");
                    modelDangKyThuePhong.addColumn("Trả Sau");
                    modelDangKyThuePhong.addColumn("Chú Thích");
                    
                    tbDangKyThuePhong = new JTable(modelDangKyThuePhong);
                    tbDangKyThuePhong.setBackground(Color.decode("#0489B1"));
                    tbDangKyThuePhong.setForeground(Color.WHITE);
                    tbDangKyThuePhong.setSelectionBackground(Color.WHITE);
                    tbDangKyThuePhong.setSelectionForeground(Color.decode("#086A87"));
                    tbDangKyThuePhong.setShowGrid(false);
                    JScrollPane scrollTBPhieuDangKy = new JScrollPane(tbDangKyThuePhong,
                            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                pnCenter.add(scrollTBPhieuDangKy);
                
            pnMain.add(pnTop, BorderLayout.NORTH);
            pnMain.add(pnCenter, BorderLayout.CENTER);
        container.add(pnMain);
    }
    
    private void addEvent() {
        hienThiMaKhachHang();
        hienThiMaPhong();
        hienThiDanhSachPhieuDangKyThuePhong();
        
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                xuLyThem();
                
            }
        });
        
        tbDangKyThuePhong.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                layMaPhieuDangKy();
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
        
        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                xuLySua();
            }
        });
        
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int result = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION){
                    xuLyXoa();
                }
            }
        });
    }
    
//-----------------CAC HAM XU LY------------------------------------------------
    private void hienThiMaKhachHang() {
        KhachHangService khachHangService = new KhachHangService();
        khachHangModels = khachHangService.layToanBoKhachHang();
        if(khachHangModels != null){
            cbbMaKhachHang.removeAllItems();
            for (KhachHangModel khachHangModel : khachHangModels) {
                cbbMaKhachHang.addItem(khachHangModel.getMaKhachHang());
            }
            
        }
    }//hien thi khach hang

    private void hienThiMaPhong() {
        PhongTroService phongTroService = new PhongTroService();
        phongTroModels = phongTroService.layToanBoPhongTro();
        if(phongTroModels != null){
            cbbMaPhong.removeAllItems();
            for (PhongTroModel phongTroModel: phongTroModels) {
                cbbMaPhong.addItem(phongTroModel.getMaPhong());
            }
        }
    }//hien thi ma phong

    private void hienThiDanhSachPhieuDangKyThuePhong() {
        ThuePhongService thuePhongService = new ThuePhongService();
        thuePhongModels = thuePhongService.layToanBoPhieuDangKyThuePhong();
        modelDangKyThuePhong.setRowCount(0);
        if(thuePhongModels != null){
            for (ThuePhongModel thuePhongModel : thuePhongModels) {
                Vector vtRow = new Vector();
                vtRow.add(thuePhongModel.getMaPDK());
                vtRow.add(thuePhongModel.getMaKH());
                vtRow.add(thuePhongModel.getMaPhong());
                vtRow.add(thuePhongModel.getNgayThue());
                vtRow.add(thuePhongModel.getNgayTra());
                vtRow.add(thuePhongModel.getTraTruoc());
                vtRow.add(thuePhongModel.getTraSau());
                vtRow.add(thuePhongModel.getChuThich());
                
                modelDangKyThuePhong.addRow(vtRow);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Trống");
            return;
        }
    }//Hien thi danh sach phieu dang ky
    
    private void xuLyThem(){
       
        if(checkMaPhieuDangKy(txtMaPhieuDangKy.getText())==false){
            JOptionPane.showMessageDialog(null, "Mã phiếu đăng ký phải có dạng [PDK+Số]\nVui long kiểm tra lại!");
            txtMaPhieuDangKy.requestFocus();
            return;
        }//kiem tra ma phieu dang ky
        
        if(checkNgay(txtNgayThue.getText())==false){
            JOptionPane.showMessageDialog(null, "Ngày thuê phải có dạng [YYYY-MM-DD]\n Vui lòng kiểm tra lại");
            txtNgayThue.requestFocus();
            return;
        }//kiem tra ngay thue
        
        if(checkNgay(txtNgayTra.getText())==false){
            JOptionPane.showMessageDialog(null, "Ngày trả phải có dạng [YYYY-MM-DD]\n Vui lòng kiểm tra lại");
            txtNgayTra.requestFocus();
            return;
        }//kiem tra ngay tra
        
        if(checkTraTruocVaTraSau(txtTraTruoc.getText())==false){
            JOptionPane.showMessageDialog(null, "Giá tiền phải là ký tự số. Vui lòng kiểm tra lại!");
            txtNgayTra.requestFocus();
            return;
        }//check tra truoc
        
        if(checkTraTruocVaTraSau(txtTraSau.getText())==false){
            JOptionPane.showMessageDialog(null, "Giá tiền phải là ký tự số. Vui lòng kiểm tra lại!");
            txtNgayTra.requestFocus();
            return;
        }//check tra sau
        
        ThuePhongService thuePhongService = new ThuePhongService();
        if (thuePhongService.kiemTraMaPhieuDangKyDaTonTai(txtMaPhieuDangKy.getText()) == false) {

            int result = thuePhongService.themPhieuDangKy(txtMaPhieuDangKy.getText(),
                    cbbMaKhachHang.getSelectedItem().toString(),
                    cbbMaPhong.getSelectedItem().toString(), txtNgayThue.getText(),
                    txtNgayTra.getText(), Float.valueOf(txtTraTruoc.getText()),
                    Float.valueOf(txtTraSau.getText()), txtChuThich.getText());

            if (result > 0) {
                hienThiDanhSachPhieuDangKyThuePhong();
                JOptionPane.showMessageDialog(null, "Đã thêm!");
            } else {
                JOptionPane.showMessageDialog(null, "Thêm thất bại");
                return;
            }
        }else{
            JOptionPane.showMessageDialog(null, "Mã phiếu đăng ký đã tồn tại. Vui lòng kiểm tra lại");
            txtMaPhieuDangKy.getText();
            txtMaPhieuDangKy.requestFocus();
            return;
        }
    }//Xu ly them
    
    public void layMaPhieuDangKy(){
        int result = tbDangKyThuePhong.getSelectedRow();
        String maPDK = (String) tbDangKyThuePhong.getValueAt(result, 0);
        ThuePhongService thuePhongService = new ThuePhongService();
        thuePhongModels = thuePhongService.layPhieuDangDangKyThuePhongTheoMa(maPDK);
        
        if(thuePhongModels != null){
            for (ThuePhongModel thuePhongModel : thuePhongModels) {
                txtMaPhieuDangKy.setText(thuePhongModel.getMaPDK());
                cbbMaKhachHang.setSelectedItem(thuePhongModel.getMaKH());
                cbbMaPhong.setSelectedItem(thuePhongModel.getMaPhong());
                txtNgayThue.setText(thuePhongModel.getNgayThue());
                txtNgayTra.setText(thuePhongModel.getNgayTra());
                txtTraTruoc.setText(thuePhongModel.getTraTruoc()+"");
                txtTraSau.setText(thuePhongModel.getTraSau()+"");
                txtChuThich.setText(thuePhongModel.getChuThich());
                
            }
        }else{
            JOptionPane.showMessageDialog(null, "Lỗi!");
            return;
        }
    }//Lay phieu dang ky theo ma phieu

    public void xuLySua(){
        if(checkMaPhieuDangKy(txtMaPhieuDangKy.getText())==false){
            JOptionPane.showMessageDialog(null, "Mã phiếu đăng ký phải có dạng [PDK+Số]\nVui long kiểm tra lại!");
            txtMaPhieuDangKy.requestFocus();
            return;
        }//kiem tra ma phieu dang ky
        
        if(checkNgay(txtNgayThue.getText())==false){
            JOptionPane.showMessageDialog(null, "Ngày thuê phải có dạng [YYYY-MM-DD]\n Vui lòng kiểm tra lại");
            txtNgayThue.requestFocus();
            return;
        }//kiem tra ngay thue
        
        if(checkNgay(txtNgayTra.getText())==false){
            JOptionPane.showMessageDialog(null, "Ngày trả phải có dạng [YYYY-MM-DD]\n Vui lòng kiểm tra lại");
            txtNgayTra.requestFocus();
            return;
        }//kiem tra ngay tra
        
        if(checkTraTruocVaTraSau(txtTraTruoc.getText())==false){
            JOptionPane.showMessageDialog(null, "Giá tiền phải là ký tự số. Vui lòng kiểm tra lại!");
            txtNgayTra.requestFocus();
            return;
        }//check tra truoc
        
        if(checkTraTruocVaTraSau(txtTraSau.getText())==false){
            JOptionPane.showMessageDialog(null, "Giá tiền phải là ký tự số. Vui lòng kiểm tra lại!");
            txtNgayTra.requestFocus();
            return;
        }//check tra sau
        
        
        ThuePhongService thuePhongService = new ThuePhongService();
        if (thuePhongService.kiemTraMaPhieuDangKyDaTonTai(txtMaPhieuDangKy.getText())==true){
            int x = thuePhongService.suaPhieuDangKy(txtMaPhieuDangKy.getText(),
                    cbbMaKhachHang.getSelectedItem().toString(),
                    cbbMaPhong.getSelectedItem().toString(), txtNgayThue.getText(),
                    txtNgayTra.getText(), Float.valueOf(txtTraTruoc.getText()),
                    Float.valueOf(txtTraSau.getText()), txtChuThich.getText());
            
            if(x>0){
                hienThiDanhSachPhieuDangKyThuePhong();
                JOptionPane.showMessageDialog(null, "Đã cập nhật!");
            }else{
                JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
                return;
            }
  
        }else{
            JOptionPane.showMessageDialog(null, "Phiếu đăng ký chưa tồn tại");
                return;
        }      
    }//xu ly sua
    
    public void xuLyXoa(){
        ThuePhongService thuePhongService = new ThuePhongService();
        if (thuePhongService.kiemTraMaPhieuDangKyDaTonTai(txtMaPhieuDangKy.getText())==true){
            int x = thuePhongService.xoaPhieuDangKy(txtMaPhieuDangKy.getText());
            
            if(x>0){
                hienThiDanhSachPhieuDangKyThuePhong();
                JOptionPane.showMessageDialog(null, "Đã xóa!");
            }else{
                JOptionPane.showMessageDialog(null, "Xóa thất bại");
                return;
            }
  
        }else{
            JOptionPane.showMessageDialog(null, "Phiếu đăng ký chưa tồn tại");
                return;
        }      
        
    }//xu ly xoa
    
    //----------------Kiem tra--------------------------------------------------
    public boolean checkMaPhieuDangKy(String maPDK){
        String pattern = "PDK\\d+";
        return maPDK.matches(pattern);//tra ve true neu dung
    }
    
    private boolean checkNgay(String ngay){
        String pattern="\\d{4}-\\d{1,2}-\\d{1,2}";
        return ngay.matches(pattern);
    }//Check ngay 

    public boolean checkTraTruocVaTraSau(String gia){
        String pattern ="\\d+([.]\\d)?";
        return gia.matches(pattern);
    }//check gia 
    
    
}

