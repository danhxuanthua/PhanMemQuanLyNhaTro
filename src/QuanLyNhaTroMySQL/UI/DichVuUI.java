/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyNhaTroMySQL.UI;

import QuanLyNhaTroMySQL.Model.DichVuModel;
import QuanLyNhaTroMySQL.Model.KhachHangModel;
import QuanLyNhaTroMySQL.Model.SuDungModel;
import QuanLyNhaTroMySQL.Model.ThuePhongModel;
import QuanLyNhaTroMySQL.Service.DichVuService;
import QuanLyNhaTroMySQL.Service.KhachHangService;
import QuanLyNhaTroMySQL.Service.PhieuThanhToanSevice;
import QuanLyNhaTroMySQL.Service.SuDungService;
import QuanLyNhaTroMySQL.Service.ThuePhongService;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DanhThua
 */
public class DichVuUI extends JDialog{

    private DefaultTableModel modelDichVu, modelSuDung;
    private JTable tbDichVu, tbSuDung;
    private JButton btnThemDV, btnSuaDV, btnXoaDV, btnThemSD, btnSuaSD, btnXoaSD;
    private JTextField txtMaDV, txtTenDV;
    private JComboBox  cbbMaDV, cbbMaKH, cbbThanhToanMaKH, cbbThanhToanMaDV, cbbMaPDK;
    private JTextField txtNgaySD, txtGiaDV;
    private ArrayList<DichVuModel> dichVuModels = null;
    private ArrayList<SuDungModel> suDungModels = null;
    private ArrayList<KhachHangModel> khachHangModels=null;
    private ArrayList<ThuePhongModel> thuePhongModels=null;
    private JButton btnSuDungReload, btnThanhToanDVReload, btnLuuPTT;
    private JTextField txtThanhToanDVSoLuongCu, txtThanhToanDVSoLuongMoi,
            txtThanhToanDVSoLuong, txtThanhToanDVGiaDV, txtThanhToanTongCong;
    private JButton btnThanhToanDVThanhToan, btnThanhToan;
    private JTextField txtMaPTT, txtSoThang, txtNgayTT, txtTongTien, txtTienPhaiTra;
    private float tongCong=0;
    
    public DichVuUI(String title) {
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
    }//Show Windows

    private void addControls() {
        Container container = getContentPane();
            JPanel pnMain = new JPanel(new BorderLayout());
            pnMain.setBackground(Color.decode("#0489B1"));
                
                JPanel pnTop = new JPanel(new BorderLayout());
                pnTop.setPreferredSize(new Dimension(0, 210));
                    
                    JPanel pnTopLeft = new JPanel(new BorderLayout());
                    
                    pnTopLeft.setBackground(Color.decode("#0489B1"));
                    TitledBorder titledPnTopLeft = new TitledBorder(BorderFactory.createLineBorder(Color.WHITE), "Dịch Vụ");
                    titledPnTopLeft.setTitleColor(Color.WHITE);
                    pnTopLeft.setBorder(titledPnTopLeft);
                    
                        //tb Dich Vu
                        modelDichVu = new DefaultTableModel();
                        modelDichVu.addColumn("Mã Dịch Vụ");
                        modelDichVu.addColumn("Tên Dịch Vụ");
                        tbDichVu = new JTable(modelDichVu);
                        tbDichVu.setBackground(Color.decode("#0489B1"));
                        tbDichVu.setForeground(Color.WHITE);
                        tbDichVu.setSelectionBackground(Color.WHITE);
                        tbDichVu.setSelectionForeground(Color.decode("#0489B1"));
                        tbDichVu.setShowGrid(false);
                        
                        //scrollTbDichVu
                        JScrollPane scrollTbDihVu = new JScrollPane(tbDichVu,
                                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    pnTopLeft.add(scrollTbDihVu, BorderLayout.CENTER);
                
                        //pn ChucNang
                        JPanel pnChucNangDV = new JPanel();
                        pnChucNangDV.setLayout(new BoxLayout(pnChucNangDV, BoxLayout.Y_AXIS));
                            
                            //Pn MaDV
                            JPanel pnMaDV = new JPanel();
                            pnMaDV.setBackground(Color.decode("#0489B1"));
                            
                            //Ma DV
                                JLabel lblMaDV = new JLabel("Mã Dịch Vụ");
                                lblMaDV.setForeground(Color.WHITE);
                            pnMaDV.add(lblMaDV);
                                txtMaDV = new JTextField(10);
                            pnMaDV.add(txtMaDV);
                            
                            //TenDV
                                JLabel lblChucNangTab1 = new JLabel("    ");
                            pnMaDV.add(lblChucNangTab1);
                                JLabel lblTenDV = new JLabel("Tên Dịch Vụ");
                                lblTenDV.setForeground(Color.WHITE);
                            pnMaDV.add(lblTenDV);
                                txtTenDV = new JTextField(10);
                            pnMaDV.add(txtTenDV);
                            
                        pnChucNangDV.add(pnMaDV);
                            
                            //Pn ThemDV
                            JPanel pnThemDV = new JPanel();
                            pnThemDV.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                            pnThemDV.setBackground(Color.decode("#0489B1"));
                            
                            //BtnThem
                                btnThemDV = new JButton("Thêm");
                                btnThemDV.setForeground(Color.decode("#086A87"));
                                btnThemDV.setBackground(Color.WHITE);
                            pnThemDV.add(btnThemDV);
                            
                            //btnSua
                                btnSuaDV = new JButton("Sửa");
                                btnSuaDV.setBackground(Color.WHITE);
                                btnSuaDV.setForeground(Color.decode("#086A87"));
                            pnThemDV.add(btnSuaDV);
                            
                            //btnXoa
                                btnXoaDV = new JButton("Xóa");
                                btnXoaDV.setBackground(Color.WHITE);
                                btnXoaDV.setForeground(Color.decode("#086A87"));
                            pnThemDV.add(btnXoaDV);
                                    
                        pnChucNangDV.add(pnThemDV);
                        
                    pnTopLeft.add(pnChucNangDV, BorderLayout.SOUTH);
                
                    //pnTopRight
                    JPanel pnTopRight = new JPanel(new BorderLayout());
                    
                    pnTopRight.setBackground(Color.decode("#0489B1"));
                    TitledBorder titledPnTopRight = new TitledBorder(BorderFactory.createLineBorder(Color.WHITE), "Sử Dụng Dịch Vụ");
                    titledPnTopRight.setTitleColor(Color.WHITE);
                    pnTopRight.setBorder(titledPnTopRight);
                    
                        //tb Su dung dich vu
                        modelSuDung = new DefaultTableModel();
                        modelSuDung.addColumn("Mã Dịch Vụ");
                        modelSuDung.addColumn("Mã Khách Hàng");
                        modelSuDung.addColumn("Ngày Sử Dụng");
                        modelSuDung.addColumn("Giá dịch vụ");
                                
                        tbSuDung = new JTable(modelSuDung);
                        tbSuDung.setBackground(Color.decode("#0489B1"));
                        tbSuDung.setForeground(Color.WHITE);
                        tbSuDung.setSelectionBackground(Color.WHITE);
                        tbSuDung.setSelectionForeground(Color.decode("#0489B1"));
                        tbSuDung.setShowGrid(false);

                        //scrollSuDung
                        JScrollPane scrollSuDung = new JScrollPane(tbSuDung,
                                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    pnTopRight.add(scrollSuDung, BorderLayout.CENTER);
                        
                        //pnChucNang
                        JPanel pnChucNangSD = new JPanel();
                        pnChucNangSD.setLayout(new BoxLayout(pnChucNangSD, BoxLayout.Y_AXIS));
                        
                            //pn MaSDDV
                            JPanel pnMaSDDV = new JPanel();
                            pnMaSDDV.setBackground(Color.decode("#0489B1"));
                                JLabel lblMaSDDV = new JLabel("Mã Dịch Vụ      ");
                                lblMaSDDV.setForeground(Color.WHITE);
                            pnMaSDDV.add(lblMaSDDV);
                                cbbMaDV = new JComboBox();
                                cbbMaDV.setMaximumRowCount(4);
                                cbbMaDV.addItem("Trống");
                                cbbMaDV.setPreferredSize(new Dimension(115, 25));
                                cbbMaDV.setBackground(Color.WHITE);
                                cbbMaDV.setForeground(Color.decode("#086A87"));
                            pnMaSDDV.add(cbbMaDV);
                            
                                //Ma KH
                                JLabel lblTab1 = new JLabel("    ");
                            pnMaSDDV.add(lblTab1);
                                JLabel lblMaKH= new JLabel("Mã Khách Hàng");
                                lblMaKH.setForeground(Color.WHITE);
                            pnMaSDDV.add(lblMaKH);
                                cbbMaKH = new JComboBox();
                                cbbMaKH.addItem("Trống");
                                cbbMaKH.setMaximumRowCount(4);
                                cbbMaKH.setPreferredSize(new Dimension(115, 25));
                                cbbMaKH.setBackground(Color.WHITE);
                                cbbMaKH.setForeground(Color.decode("#086A87"));
                            pnMaSDDV.add(cbbMaKH);
                            
                        pnChucNangSD.add(pnMaSDDV);
                        
                            //Ngay Su Dung
                            JPanel pnNgaySD = new JPanel();
                            pnNgaySD.setBackground(Color.decode("#0489B1"));
                                JLabel lblNgaySD = new JLabel("Ngày Sử Dụng");
                                lblNgaySD.setForeground(Color.WHITE);
                            pnNgaySD.add(lblNgaySD);
                                txtNgaySD = new JTextField(10);
                            pnNgaySD.add(txtNgaySD);
                                
                                //Gia Dich Vu
                                JLabel lblTab2 = new JLabel("    ");
                            pnNgaySD.add(lblTab2);
                                JLabel lblGiaDV = new JLabel("Giá Dịch Vụ");
                                lblGiaDV.setForeground(Color.WHITE);
                            pnNgaySD.add(lblGiaDV);
                                txtGiaDV = new JTextField(10);
                            pnNgaySD.add(txtGiaDV);
                            
                                //Can le
                                lblMaDV.setPreferredSize(lblNgaySD.getPreferredSize());
                                lblGiaDV.setPreferredSize(lblMaKH.getPreferredSize());
                        pnChucNangSD.add(pnNgaySD);
                        
                            //Them Su dung dich vu
                            JPanel pnThemSD = new JPanel();
                            pnThemSD.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                            pnThemSD.setBackground(Color.decode("#0489B1"));
                                btnThemSD = new JButton("Thêm");
                                btnThemSD.setBackground(Color.WHITE);
                                btnThemSD.setForeground(Color.decode("#086A87"));
                            pnThemSD.add(btnThemSD);
                            
                            //Sua Su dung dich vu 
                                btnSuaSD = new JButton("Sửa");
                                btnSuaSD.setBackground(Color.WHITE);
                                btnSuaSD.setForeground(Color.decode("#086A87"));
                            pnThemSD.add(btnSuaSD);
                            
                            //Xoa su dung dich vu
                                btnXoaSD = new JButton("Xóa");
                                btnXoaSD.setBackground(Color.WHITE);
                                btnXoaSD.setForeground(Color.decode("#086A87"));
                            pnThemSD.add(btnXoaSD);
                            
                            //reload
                                btnSuDungReload = new JButton("Reload");
                                btnSuDungReload.setBackground(Color.WHITE);
                                btnSuDungReload.setForeground(Color.decode("#086A87"));
                            pnThemSD.add(btnSuDungReload);
                            
                        pnChucNangSD.add(pnThemSD);
                                   
                    pnTopRight.add(pnChucNangSD, BorderLayout.SOUTH);
                    
                pnTop.add(pnTopRight, BorderLayout.CENTER);//topRight
                        
                pnTop.add(pnTopLeft, BorderLayout.WEST);//TopLeft
                
                JPanel pnBottom = new JPanel(new BorderLayout());//PnBottom
                pnBottom.setPreferredSize(new Dimension(0, 270));
                
                    JPanel pnBottomLeft = new JPanel(new BorderLayout());//pnBottomLeft
                    pnBottomLeft.setBackground(Color.decode("#0489B1"));
                    TitledBorder titledPnBottomLeft = new TitledBorder(BorderFactory.createLineBorder(Color.WHITE), "Thanh Toán Dịch Vụ");
                    titledPnBottomLeft.setTitleColor(Color.WHITE);
                    pnBottomLeft.setBorder(titledPnBottomLeft);
                    
                        //PnThanhToanDV
                        JPanel pnThanhToanDV = new JPanel();
                        pnThanhToanDV.setPreferredSize(new Dimension(467, 0));
                        pnThanhToanDV.setLayout(new BoxLayout(pnThanhToanDV, BoxLayout.Y_AXIS));
                        
                            //pnThanhToanDvMaKH
                            JPanel pnThanhToanDVMaKH = new JPanel();
                            pnThanhToanDVMaKH.setBackground(Color.decode("#0489B1"));
                                JLabel lblThanhToanDVMaKH = new JLabel("Mã Khách Hàng");
                                lblThanhToanDVMaKH.setForeground(Color.WHITE);
                            pnThanhToanDVMaKH.add(lblThanhToanDVMaKH);
                                cbbThanhToanMaKH = new JComboBox();
                                cbbThanhToanMaKH.setMaximumRowCount(5);
                                cbbThanhToanMaKH.addItem("Trống");
                                cbbThanhToanMaKH.setBackground(Color.WHITE);
                                cbbThanhToanMaKH.setForeground(Color.decode("#086A87"));
                                cbbThanhToanMaKH.setPreferredSize(new Dimension(110, 25));
                            pnThanhToanDVMaKH.add(cbbThanhToanMaKH);
                                
                            //Thanh Toan maDV
                                JLabel lblTabTT1 = new JLabel("    ");
                            pnThanhToanDVMaKH.add(lblTabTT1);
                                JLabel lblThanhToanDVMaDV = new JLabel("Mã Dịch Vụ");
                                lblThanhToanDVMaDV.setForeground(Color.WHITE);
                            pnThanhToanDVMaKH.add(lblThanhToanDVMaDV);
                                cbbThanhToanMaDV = new JComboBox();
                                cbbThanhToanMaDV.setMaximumRowCount(5);
                                cbbThanhToanMaDV.setBackground(Color.WHITE);
                                cbbThanhToanMaDV.setForeground(Color.decode("#086A87"));
                                cbbThanhToanMaDV.setPreferredSize(cbbThanhToanMaKH.getPreferredSize());
                                cbbThanhToanMaDV.addItem("Trống");
                            pnThanhToanDVMaKH.add(cbbThanhToanMaDV);    
                        pnThanhToanDV.add(pnThanhToanDVMaKH);
                        
                            //pnThanhToanDVSoLuongCu
                            JPanel pnThanhToanDVSoLuongCu = new JPanel();
                            pnThanhToanDVSoLuongCu.setBackground(Color.decode("#0489B1"));
                                JLabel lblThanhToanSoLuongCu = new JLabel("Số Lượng(Cũ)");
                                lblThanhToanSoLuongCu.setForeground(Color.WHITE);
                            pnThanhToanDVSoLuongCu.add(lblThanhToanSoLuongCu);
                                txtThanhToanDVSoLuongCu = new JTextField(10);
                            pnThanhToanDVSoLuongCu.add(txtThanhToanDVSoLuongCu);
                            
                            //ThanhToanDVSoLuongMoi
                                JLabel lblTabTT2 = new JLabel("    ");
                            pnThanhToanDVSoLuongCu.add(lblTabTT2);
                                JLabel lblThanhToanDVSoLuongMoi = new JLabel("Số Lượng(Mới)");
                                lblThanhToanDVSoLuongMoi.setForeground(Color.WHITE);
                            pnThanhToanDVSoLuongCu.add(lblThanhToanDVSoLuongMoi);
                                txtThanhToanDVSoLuongMoi = new JTextField(10);
                            pnThanhToanDVSoLuongCu.add(txtThanhToanDVSoLuongMoi);
                        pnThanhToanDV.add(pnThanhToanDVSoLuongCu); 
                        
                            //so luong
                            JPanel pnThanhToanDVSoLuong = new JPanel();
                            pnThanhToanDVSoLuong.setBackground(Color.decode("#0489B1"));
                            pnThanhToanDVSoLuong.setBackground(Color.decode("#0489B1"));
                            
                                JLabel lblThanhToanDVSoLuong = new JLabel("Số Lượng");
                                lblThanhToanDVSoLuong.setForeground(Color.WHITE);
                            pnThanhToanDVSoLuong.add(lblThanhToanDVSoLuong);
                                txtThanhToanDVSoLuong = new JTextField(10);
                                txtThanhToanDVSoLuong.setEnabled(false);
                                txtThanhToanDVSoLuong.setDisabledTextColor(Color.BLACK);
                            pnThanhToanDVSoLuong.add(txtThanhToanDVSoLuong);
                            
                            //ThanhToanGiaDv
                                JLabel lblTabTT3 = new JLabel("    ");
                            pnThanhToanDVSoLuong.add(lblTabTT3);
                                JLabel lblThanhToanGiaDV = new JLabel("Giá Dịch Vụ");
                                lblThanhToanGiaDV.setForeground(Color.WHITE);
                            pnThanhToanDVSoLuong.add(lblThanhToanGiaDV);
                                txtThanhToanDVGiaDV = new JTextField(10);
                                txtThanhToanDVGiaDV.setEnabled(false);
                                txtThanhToanDVGiaDV.setDisabledTextColor(Color.BLACK);
                            pnThanhToanDVSoLuong.add(txtThanhToanDVGiaDV);
                        
                            //Pn TongCong
                            JPanel pnThanhToanTongCong = new JPanel();
                            pnThanhToanTongCong.setBackground(Color.decode("#0489B1"));
                            
                                JLabel lblThanhToanDVTongCong = new JLabel("Tổng Cộng:    ");
                                lblThanhToanDVTongCong.setForeground(Color.WHITE);
                            pnThanhToanTongCong.add(lblThanhToanDVTongCong);
                                txtThanhToanTongCong = new JTextField(14);
                                txtThanhToanTongCong.setEnabled(false);
                                txtThanhToanTongCong.setDisabledTextColor(Color.RED);
                            pnThanhToanTongCong.add(txtThanhToanTongCong);
                        
                            //Pn ThanhToan
                            JPanel pnThanhToanButton = new JPanel();
                            pnThanhToanButton.setBackground(Color.decode("#0489B1"));
                                JLabel lblTabTT4 = new JLabel("    ");
                                
                            pnThanhToanButton.add(lblTabTT4);
                                btnThanhToanDVThanhToan = new JButton("Thanh Toán");
                                btnThanhToanDVThanhToan.setForeground(Color.decode("#086A87"));
                                btnThanhToanDVThanhToan.setBackground(Color.WHITE);
                            pnThanhToanButton.add(btnThanhToanDVThanhToan);
                            
                            //reload
                                btnThanhToanDVReload = new JButton("Reload");
                                btnThanhToanDVReload.setForeground(Color.decode("#086A87"));
                                btnThanhToanDVReload.setBackground(Color.WHITE);
                            pnThanhToanButton.add(btnThanhToanDVReload);
                            
                            //Can le
                            lblThanhToanSoLuongCu.setPreferredSize(lblThanhToanDVMaKH.getPreferredSize());
                            lblThanhToanDVMaDV.setPreferredSize(lblThanhToanDVSoLuongMoi.getPreferredSize());
                            lblThanhToanDVSoLuong.setPreferredSize(lblThanhToanSoLuongCu.getPreferredSize());
                            lblThanhToanGiaDV.setPreferredSize(lblThanhToanDVSoLuongMoi.getPreferredSize());
                            lblThanhToanDVTongCong.setPreferredSize(lblThanhToanDVSoLuong.preferredSize());
                            btnThanhToanDVReload.setPreferredSize(btnThanhToanDVThanhToan.preferredSize());
                            
                            JPanel pnGomNhom = new JPanel();
                            
                            pnGomNhom.setBackground(Color.decode("#0489B1"));
                            pnGomNhom.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                            pnGomNhom.setPreferredSize(new Dimension(0, 100));
                            pnGomNhom.add(pnThanhToanDVSoLuong);
                            pnGomNhom.add(pnThanhToanTongCong);
                            pnGomNhom.add(pnThanhToanButton);
                            
                        pnThanhToanDV.add(pnGomNhom);
                        
                            
                    pnBottomLeft.add(pnThanhToanDV, BorderLayout.CENTER);//BottomLeft
                        
                pnBottom.add(pnBottomLeft, BorderLayout.WEST);//PnBottom
                
                    
                    JPanel pnBottomRight = new JPanel(new BorderLayout());
                    pnBottomRight.setBackground(Color.decode("#0489B1"));
                    TitledBorder titledPnBottomRight = new TitledBorder(BorderFactory.createLineBorder(Color.WHITE), "Thanh Toán Hóa Đơn");
                    titledPnBottomRight.setTitleColor(Color.WHITE);
                    pnBottomRight.setBorder(titledPnBottomRight);
                        
                        //pnPhieuThanhToan
                        JPanel pnPhieuThanhToan = new JPanel();
                        pnPhieuThanhToan.setLayout(new BoxLayout(pnPhieuThanhToan, BoxLayout.Y_AXIS));
                        
                            //pnMaPTT
                            JPanel pnMaPTT = new JPanel();
                            pnMaPTT.setBackground(Color.decode("#0489B1"));
                                JLabel lblMaPTT = new JLabel("Mã Phiếu Thanh Toán");
                                lblMaPTT.setForeground(Color.WHITE);
                            pnMaPTT.add(lblMaPTT);
                                txtMaPTT = new JTextField(10);
                            pnMaPTT.add(txtMaPTT);
                            
                            //MaPDK
                                JLabel lblPTTTab1 = new JLabel("    ");
                            pnMaPTT.add(lblPTTTab1);
                                    
                                JLabel lblMaPDK = new JLabel("Mã Phiếu Đăng Ký");
                                lblMaPDK.setForeground(Color.WHITE);
                            pnMaPTT.add(lblMaPDK);
                                cbbMaPDK = new JComboBox();
                                cbbMaPDK.setMaximumRowCount(5);
                                cbbMaPDK.addItem("Trống");
                                cbbMaPDK.setBackground(Color.WHITE);
                                cbbMaPDK.setForeground(Color.decode("#086A87"));
                                cbbMaPDK.setPreferredSize(new Dimension(110, 25));
                            pnMaPTT.add(cbbMaPDK);
                        pnPhieuThanhToan.add(pnMaPTT);
                        
                            //pnSoThang
                            JPanel pnSoThang = new JPanel();
                            pnSoThang.setBackground(Color.decode("#0489B1"));
                                JLabel lblSoThang = new JLabel("Số Tháng");
                                lblSoThang.setForeground(Color.WHITE);
                            pnSoThang.add(lblSoThang);
                                txtSoThang = new JTextField(10);
                            pnSoThang.add(txtSoThang);
                            
                            //NgayTT
                            JLabel lblPTTTab2 = new JLabel("    ");
                            pnSoThang.add(lblPTTTab2);
                                JLabel lblNgayTT = new JLabel("Ngày Thanh Toán");
                                lblNgayTT.setForeground(Color.WHITE);
                            pnSoThang.add(lblNgayTT);
                                txtNgayTT = new JTextField(10);
                            pnSoThang.add(txtNgayTT);
                        pnPhieuThanhToan.add(pnSoThang);
                        
                            //pnTongTien
                            JPanel pnTongTien = new JPanel();
                            pnTongTien.setBackground(Color.decode("#0489B1"));
                                JLabel lblTongTien = new JLabel("Tiền Phòng: ");
                                lblTongTien.setForeground(Color.WHITE);
                            pnTongTien.add(lblTongTien);
                                txtTongTien = new JTextField(10);
                                txtTongTien.setEnabled(false);
                                txtTongTien.setDisabledTextColor(Color.RED);
                            pnTongTien.add(txtTongTien);
                                
                            //TienPhaiTra
                            JLabel lblPTTTab3 = new JLabel("    ");
                            pnTongTien.add(lblPTTTab3);
                                JLabel lblTienPhaiTra = new JLabel("Tiền Phải Trả: ");
                                lblTienPhaiTra.setForeground(Color.WHITE);
                            pnTongTien.add(lblTienPhaiTra);
                                txtTienPhaiTra = new JTextField(10);
                                txtTienPhaiTra.setEnabled(false);
                                txtTienPhaiTra.setDisabledTextColor(Color.RED);
                            pnTongTien.add(txtTienPhaiTra);
                        
                            JPanel pnThanhToanLine1 = new JPanel();
                            pnThanhToanLine1.setBackground(Color.decode("#0489B1"));                                    
                                JLabel lblThanhToanTab1 = new JLabel();
                            pnThanhToanLine1.add(lblThanhToanTab1);
                   
                            //Pn Thanh Toan
                            JPanel pnThanhToan = new JPanel();
                            pnThanhToan.setBackground(Color.decode("#0489B1"));
                                btnThanhToan = new JButton("Thanh Toán");
                                btnThanhToan.setBackground(Color.WHITE);
                                btnThanhToan.setForeground(Color.decode("#086A87"));
                            pnThanhToan.add(btnThanhToan);    
                                //LuuPTT
                                btnLuuPTT = new JButton("Lưu Phiếu");
                                btnLuuPTT.setBackground(Color.WHITE);
                                btnLuuPTT.setForeground(Color.decode("#086A87"));
                            pnThanhToan.add(btnLuuPTT);
                        
                            //can le
                            lblSoThang.setPreferredSize(lblMaPTT.getPreferredSize());
                            lblNgayTT.setPreferredSize(lblMaPDK.getPreferredSize());
                            lblTongTien.setPreferredSize(lblSoThang.getPreferredSize());
                            lblTienPhaiTra.setPreferredSize(lblNgayTT.getPreferredSize());
                            
                            //pn GomNhom de set border
                            JPanel pnGomNhomPTT = new JPanel();
                            pnGomNhomPTT.setLayout(new BoxLayout(pnGomNhomPTT, BoxLayout.Y_AXIS));
                            pnGomNhomPTT.setPreferredSize(new Dimension(0, 45));
                            pnGomNhomPTT.setBackground(Color.decode("#0489B1"));
                            pnGomNhomPTT.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                            pnGomNhomPTT.add(pnTongTien);
                            pnGomNhomPTT.add(pnThanhToanLine1);
                            pnGomNhomPTT.add(pnThanhToan);
                        pnPhieuThanhToan.add(pnGomNhomPTT);
                        
                    pnBottomRight.add(pnPhieuThanhToan, BorderLayout.CENTER);
                pnBottom.add(pnBottomRight, BorderLayout.CENTER);
                    
            pnMain.add(pnTop, BorderLayout.NORTH);
            pnMain.add(pnBottom, BorderLayout.SOUTH);
            
        container.add(pnMain);   
    }//add Controls

    private void addEvent() {
//--------------SU KIEN DICH VU-------------------------------------------------
        hienThiDichVu();
        
        tbDichVu.addMouseListener(new MouseListener() {
           @Override
           public void mouseClicked(MouseEvent me) {
               xuLyLayMaDichVu();
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
       
        btnThemDV.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
               xuLyThemDV();
           }
       });
       
       btnSuaDV.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
               xuLySuaDV();
           }
       });
       
       btnXoaDV.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
               xuLyXoaDV();
           }
       });
//------------------XU KIEN SU DUNG DICH VU-------------------------------------
        hienThiSuDung();
        hienThiCBBmaDV();
        hienThiCBBMaKH();
        
        tbSuDung.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                xuLyLayMaDichVuMaKhachHang();
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
        
        btnThemSD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                xuLyThemSD();
            }
        });
        
        btnSuaSD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                xuLySuaSD();
            }
        });
        
        btnXoaSD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                xuLyXoaSD();
            }
        });
        
        btnSuDungReload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                hienThiCBBmaDV();
                hienThiCBBMaKH();
            }
        });
//-------------------SU KIEN THANH TOAN DICH VU---------------------------------
        hienThiMaKHSuDungDV();
        
        cbbThanhToanMaKH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String maKH = (String) cbbThanhToanMaKH.getSelectedItem();
                cbbThanhToanMaDV.removeAllItems();
                hienThiDichVuKhachHangSuDung(maKH);
            }
        });
        
        cbbThanhToanMaDV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String maKH = (String) cbbThanhToanMaKH.getSelectedItem();
                String maDV = (String) cbbThanhToanMaDV.getSelectedItem();
                xuLyHienThiGiaDVTheoMaKHVaMaDV(maKH, maDV);
            }
        });
        
        btnThanhToanDVThanhToan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                xuLyThanhToanDichVu();
            }
        });
        
        btnThanhToanDVReload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                xuLyThanhToanDVReload();
            }
        });
        
//-------------------SU KIEN PHIEU THANH TOAN-----------------------------------
        hienThiMaPDK();
        
        btnThanhToan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                xuLyThanhToanHoaDon();
            }
        });
        
        btnLuuPTT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                xuLyLuuHoaHoaDon();
            }
        });
    }//add Event
    
//-------------CAC HAM XU LY DICH VU--------------------------------------------
    private void hienThiDichVu() {
        DichVuService dichVuService = new DichVuService();
        dichVuModels = dichVuService.layToanBoDichVu();
        
        modelDichVu.setRowCount(0);
        if (dichVuModels != null){
            for (DichVuModel dichVuModel : dichVuModels) {
                Vector vtRow = new Vector();
                vtRow.add(dichVuModel.getMaDV());
                vtRow.add(dichVuModel.getTenDV());
                modelDichVu.addRow(vtRow);
            }
        }else{
            return;
        }
    }//hien thi dich vu
    
    private void xuLyLayMaDichVu() {
        int result = tbDichVu.getSelectedRow();
        String maDV = (String) tbDichVu.getValueAt(result, 0);
        hienThiDichVuTheoMa(maDV);
    }//Lay ma DV

    private void hienThiDichVuTheoMa(String maDV) {
        DichVuService dichVuService = new DichVuService();
        dichVuModels = dichVuService.layDichVuTheoMa(maDV);
        
        if (dichVuModels != null){
            for (DichVuModel dichVuModel : dichVuModels) {
                txtMaDV.setText(dichVuModel.getMaDV());
                txtTenDV.setText(dichVuModel.getTenDV());
            }
        }else{
            return;
        }
    }//Hien thi dich vu theo ma
    
    private void xuLyThemDV(){
        if (checkMaDV(txtMaDV.getText())==false){
            JOptionPane.showMessageDialog(null, "Mã dịch vụ phải thuộc dạng [DV+Số].\n Vui lòn kiểm tra lại!");
            txtMaDV.requestFocus();
            return;
        }//Kiem tra maDV        
        
        if(checkTenDV(txtTenDV.getText())==false){
            JOptionPane.showMessageDialog(null, "Tên dịch vụ không được bỏ trống!");
            txtTenDV.requestFocus();
            return;
        }//Kiem tra tenDV
        
        DichVuService dichVuService = new DichVuService();
        if (dichVuService.kiemTraDichVuDaTonTai(txtMaDV.getText())==false){
            int x = dichVuService.themDV(txtMaDV.getText(), txtTenDV.getText());
            if(x>0){
                hienThiDichVu();
                JOptionPane.showMessageDialog(null, "Đã thêm!");
            }else{
                JOptionPane.showMessageDialog(null, "Thêm thất bại!");
                txtMaDV.requestFocus();
                return;
            }
        }else{
            JOptionPane.showMessageDialog(null, "Dịch vụ đã tồn tại. Vui lòng kiểm tra lại!");
            txtMaDV.requestFocus();
            return;
        }
        
    }//xu Ly themDV
    
    private void xuLySuaDV(){
        if (checkMaDV(txtMaDV.getText())==false){
            JOptionPane.showMessageDialog(null, "Mã dịch vụ phải thuộc dạng [DV+Số].\n Vui lòn kiểm tra lại!");
            txtMaDV.requestFocus();
            return;
        }//Kiem tra maDV        
        
        if(checkTenDV(txtTenDV.getText())==false){
            JOptionPane.showMessageDialog(null, "Tên dịch vụ không được bỏ trống!");
            txtTenDV.requestFocus();
            return;
        }//Kiem tra tenDV
        
        DichVuService dichVuService = new DichVuService();
        if (dichVuService.kiemTraDichVuDaTonTai(txtMaDV.getText())==true){
            int x = dichVuService.suaDV(txtMaDV.getText(), txtTenDV.getText());
            if(x>0){
                hienThiDichVu();
                JOptionPane.showMessageDialog(null, "Đã Sửa!");
            }else{
                JOptionPane.showMessageDialog(null, "Sửa thất bại!");
                txtMaDV.requestFocus();
                return;
            }
        }else{
            JOptionPane.showMessageDialog(null, "Dịch vụ chưa tồn tại. Vui lòng kiểm tra lại!");
            txtMaDV.requestFocus();
            return;
        }
        
    }//Xu ly suaDV
    
    private void xuLyXoaDV() {
        if (checkMaDV(txtMaDV.getText())==false){
            JOptionPane.showMessageDialog(null, "Mã dịch vụ phải thuộc dạng [DV+Số].\n Vui lòn kiểm tra lại!");
            txtMaDV.requestFocus();
            return;
        }//Kiem tra maDV  
        
        int result = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa?", "Xác Nhận", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            DichVuService dichVuService = new DichVuService();
            
            if (dichVuService.kiemTraDichVuDaTonTai(txtMaDV.getText()) == true) {
                int x = dichVuService.xoaDV(txtMaDV.getText());
                if (x > 0) {
                    hienThiDichVu();
                    JOptionPane.showMessageDialog(null, "Đã Xóa!");
                } else {
                    JOptionPane.showMessageDialog(null, "Xóa thất bại!");
                    txtMaDV.requestFocus();
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Dịch vụ chưa tồn tại. Vui lòng kiểm tra lại!");
                txtMaDV.requestFocus();
                return;
            }
        }

    }//xu ly xoaDV
    
//----------------CHECK DICH VU-------------------------------------------------
    private boolean checkMaDV(String maDV){
        String pattern = "DV\\d+";
        return maDV.matches(pattern);
    }//Kiem tra maDV phải dung theo mau
    
    private boolean checkTenDV(String tenDV){
       return tenDV.length() > 0;
    }//kiem tra tenDV khong duoc bo trong

//---------------CAC HAM XU LY SU DUNG DICH VU----------------------------------
    private void hienThiSuDung(){
        SuDungService suDungService = new SuDungService();
        suDungModels = suDungService.layToanBoSuDung();
        
        modelSuDung.setRowCount(0);
        for (SuDungModel suDungModel : suDungModels) {
            Vector vtRow = new Vector();
            vtRow.add(suDungModel.getMaDV());
            vtRow.add(suDungModel.getMaKH());
            vtRow.add(suDungModel.getNgaySD());
            vtRow.add(suDungModel.getGiaDV());
            modelSuDung.addRow(vtRow);
        }
    }//hien thi su dung DV
    
    private void hienThiCBBmaDV(){
        DichVuService dichVuService = new DichVuService();
        dichVuModels = dichVuService.layToanBoDichVu();
        
        cbbMaDV.removeAllItems();
        if (dichVuModels != null){
            for (DichVuModel dichVuModel : dichVuModels) {
                cbbMaDV.addItem(dichVuModel.getMaDV());
            }
        }else{
            return;
        }
    }//hien thi cbbMaDV
    
    private void hienThiCBBMaKH(){
        KhachHangService khachHangService = new KhachHangService();
        khachHangModels = khachHangService.layToanBoKhachHang();
        cbbMaKH.removeAllItems();
        for (KhachHangModel khachHangModel : khachHangModels) {
            cbbMaKH.addItem(khachHangModel.getMaKhachHang());
        }
    }//hien thi cbbMaKH
    
    private void xuLyLayMaDichVuMaKhachHang() {
        int result = tbSuDung.getSelectedRow();
        String maDV = (String) tbSuDung.getValueAt(result, 0);
        String maKH = (String) tbSuDung.getValueAt(result, 1);
        hienThiSuDungTheoMaDichVuMaKhachHang(maDV, maKH);
    }//xu lylay maDV va maKH

    private void hienThiSuDungTheoMaDichVuMaKhachHang(String maDV, String maKH) {
        SuDungService suDungService = new SuDungService();
        suDungModels = suDungService.laySuDungTheoMaDichVuMaKH(maDV, maKH);
        
        for (SuDungModel suDungModel : suDungModels) {
            cbbMaDV.setSelectedItem(suDungModel.getMaDV());
            cbbMaKH.setSelectedItem(suDungModel.getMaKH());
            txtNgaySD.setText(suDungModel.getNgaySD());
            txtGiaDV.setText(suDungModel.getGiaDV()+"");
        }
    }//hien thi suDung theo maDV va maKH
    
    private void xuLyThemSD(){
        if (checkNgay(txtNgaySD.getText())==false){
            JOptionPane.showMessageDialog(null, "Ngày sử dụng phải thuộc dạng [YYYY-MM-DD].\n Vui lòng kiểm tra lại!");
            txtNgaySD.requestFocus();
            return;
        }//kiem tra ngay su dung
        
        if (checkGia(txtGiaDV.getText())==false){
            JOptionPane.showMessageDialog(null, "Ngày sử dụng phải là ký tự số.\n Vui lòng kiểm tra lại!");
            txtGiaDV.requestFocus();
            return;
        }//kiem tra gia dich vu
        
        
        SuDungService suDungService = new SuDungService();
        int x = suDungService.themSuDung(cbbMaDV.getSelectedItem().toString(),
                cbbMaKH.getSelectedItem().toString(),
                txtNgaySD.getText(), Float.valueOf(txtGiaDV.getText()));
        
        if (x>0){
            hienThiSuDung();
            JOptionPane.showMessageDialog(null, "Đã thêm!");
        }else{
            JOptionPane.showMessageDialog(null, "Thêm thất bại!");
            cbbMaDV.requestFocus();
            return;
        }
    }//xu ly themSD
    
    private void xuLySuaSD(){
        if (checkNgay(txtNgaySD.getText())==false){
            JOptionPane.showMessageDialog(null, "Ngày sử dụng phải thuộc dạng [YYYY-MM-DD].\n Vui lòng kiểm tra lại!");
            txtNgaySD.requestFocus();
            return;
        }//kiem tra ngay su dung
        
        if (checkGia(txtGiaDV.getText())==false){
            JOptionPane.showMessageDialog(null, "Ngày sử dụng phải là ký tự số.\n Vui lòng kiểm tra lại!");
            txtGiaDV.requestFocus();
            return;
        }//kiem tra gia dich vu
        
        SuDungService suDungService = new SuDungService();
        int x = suDungService.suaSuDung(cbbMaDV.getSelectedItem().toString(),
                cbbMaKH.getSelectedItem().toString(),
                txtNgaySD.getText(), Float.valueOf(txtGiaDV.getText()));
        
        if (x>0){
            hienThiSuDung();
            JOptionPane.showMessageDialog(null, "Đã sửa!");
        }else{
            JOptionPane.showMessageDialog(null, "sửa thất bại!");
            cbbMaDV.requestFocus();
            return;
        }
    }//xu ly xoaSD
    
    private void xuLyXoaSD() {
        int result = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa?", "Xác Nhận", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            SuDungService suDungService = new SuDungService();
            int x = suDungService.xoaSuDung(cbbMaDV.getSelectedItem().toString(),
                    cbbMaKH.getSelectedItem().toString());

            if (x > 0) {
                hienThiSuDung();
                JOptionPane.showMessageDialog(null, "Đã xóa!");
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thất bại!");
                cbbMaDV.requestFocus();
                return;
            }
        }
    }//xu ly xoaSD
    
//--------------CHECK SU DUNG---------------------------------------------------
    private boolean checkNgay(String ngaySD){
        String pattern="\\d{4}-\\d{1,2}-\\d{1,2}";
        return ngaySD.matches(pattern);
    }//kiem tra ngay su dung hop le
    
    private boolean checkGia(String giaPhong){
        String pattern ="\\d+([.]\\d)?";
        return giaPhong.matches(pattern);
    }//kiem tra gia dich vu hop le
    
 //---------------------CAC HAM XU LY THANH TOAN DICH VU------------------------
    private void hienThiMaKHSuDungDV(){
         SuDungService suDungService = new SuDungService();
        suDungModels = suDungService.layMaKHSuDungDVLoaiBoTrungLap();
        
        cbbThanhToanMaKH.removeAllItems();
        for (SuDungModel suDungModel : suDungModels) {
            cbbThanhToanMaKH.addItem(suDungModel.getMaKH());
        }
    }//hien thi ma khach hang su dung dich vu
    
    private void hienThiDichVuKhachHangSuDung(String maKH){
        SuDungService suDungService = new SuDungService();
        suDungModels = suDungService.layDichVuKhachHangSuDung(maKH);
        for (SuDungModel suDungModel : suDungModels) {
            cbbThanhToanMaDV.addItem(suDungModel.getMaDV());
        }
    }//Hien thi dich vu khach hang da su dung
    
    private void xuLyHienThiGiaDVTheoMaKHVaMaDV(String maKH, String maDV) {
        SuDungService suDungService = new SuDungService();
        suDungModels = suDungService.layGiaDichVuTheoMaKHVaMaDV(maKH, maDV);
       
        for (SuDungModel suDungModel : suDungModels) {
            txtThanhToanDVGiaDV.setText(suDungModel.getGiaDV()+"");
        }
    }//hien thi gia dich vu theo maKH va MaDV
    
    private void xuLyThanhToanDichVu() {
        if(checkGia(txtThanhToanDVSoLuongCu.getText())== false){
            JOptionPane.showMessageDialog(null, "Số lượng không hợp lệ. Vui lòng kiểm tra lại!");
            txtThanhToanDVSoLuongCu.requestFocus();
            return;
        }//Kiem tra so luong cu
        
        if(checkGia(txtThanhToanDVSoLuongMoi.getText())== false){
            JOptionPane.showMessageDialog(null, "Số lượng không hợp lệ. Vui lòng kiểm tra lại!");
            txtThanhToanDVSoLuongMoi.requestFocus();
            return;
        }//kiem tra so luong moi
        
        float soLuongCu = Float.valueOf(txtThanhToanDVSoLuongCu.getText().trim());
        float soLuongMoi = Float.valueOf(txtThanhToanDVSoLuongMoi.getText().trim());
        float soLuong = soLuongMoi - soLuongCu;
        txtThanhToanDVSoLuong.setText(soLuong+"");
            tongCong +=    soLuong * Float.valueOf(txtThanhToanDVGiaDV.getText().trim());
        txtThanhToanTongCong.setText(tongCong+" VNĐ");
       
    }//Xu ly thanh toan dv
    
    private void xuLyThanhToanDVReload() {
        txtThanhToanDVGiaDV.setText("");
        txtThanhToanDVSoLuong.setText("");
        txtThanhToanDVSoLuongMoi.setText("");
        txtThanhToanDVSoLuongCu.setText("");
        txtThanhToanTongCong.setText("0");
        tongCong=0;
        cbbThanhToanMaKH.removeAllItems();
        hienThiMaKHSuDungDV();
    }//xu ly reload
    
//------------------CAC HAM XU LY PHIEU THANH TOAN------------------------------
    private void hienThiMaPDK(){
       ThuePhongService thuePhongService = new ThuePhongService();
       thuePhongModels = thuePhongService.layToanBoPhieuDangKyThuePhong();
       cbbMaPDK.removeAllItems();
       for (ThuePhongModel thuePhongModel : thuePhongModels) {
           cbbMaPDK.addItem(thuePhongModel.getMaPDK());
       }
   }//Hien thi maPDK
   
    private void xuLyThanhToanHoaDon() {
        if (checkMaPhieuTT(txtMaPTT.getText().trim()) == false) {
            JOptionPane.showMessageDialog(null, "Mã phiếu thanh toán phải có dạng [PTT + Số]\n Vui lòng kiểm tra lại!");
            txtMaPTT.requestFocus();
            return;
        }//kiem ma phieu thanh toan

        if (checkSoThang(txtSoThang.getText().trim()) == false) {
            JOptionPane.showMessageDialog(null, "Số tháng không hợp lệ. Vui lòng kiểm tra lại!");
            txtSoThang.requestFocus();
            return;
        }//kiem tra so thang

        if (checkNgay(txtNgayTT.getText()) == false) {
            JOptionPane.showMessageDialog(null, "Ngày sử dụng phải thuộc dạng [YYYY-MM-DD].\n Vui lòng kiểm tra lại!");
            txtNgayTT.requestFocus();
            return;
        }//kiem tra ngay thanh toan

        PhieuThanhToanSevice phieuThanhToanSevice = new PhieuThanhToanSevice();
        if (phieuThanhToanSevice.kiemTraPTTDaTonTai(txtMaPTT.getText().trim()) == true) {
            JOptionPane.showMessageDialog(null, "Phiếu đã được thanh toán trước đó. Vui lòng kiểm tra lại");
            txtMaPTT.requestFocus();
            return;
        }//kiem tra ma phieu da ton tai

        ThuePhongService thuePhongService = new ThuePhongService();
        thuePhongModels = thuePhongService.layPhieuDangKyTheoMaPDK(cbbMaPDK.getSelectedItem().toString());
        float traSau = 0;
        float tongTien = 0;

        for (ThuePhongModel thuePhongModel : thuePhongModels) {
            traSau = thuePhongModel.getTraSau();
        }
        if (traSau > 0) {
            tongTien = traSau;
        } else {
            tongTien = 0;
        }

        txtTongTien.setText(tongTien + " VNĐ");
        txtTienPhaiTra.setText(tongTien + tongCong + " VNĐ");
        xuLyThemPhieuThanhToan();//sau khi thanh toan xong se dua vao database
    }//Xu ly thanh toan hoa don
    
    public void xuLyThemPhieuThanhToan(){
        //Ngat chuoi
        String strTongTien = txtTongTien.getText().trim();
        String[] tongTien = strTongTien.split("\\s");
        String strTienPhaiTra = txtTienPhaiTra.getText().trim();
        String[] tienPhaiTra = strTienPhaiTra.split("\\s");

        //xu ly them vao data base
        PhieuThanhToanSevice phieuThanhToanSevice = new PhieuThanhToanSevice();
        int x = phieuThanhToanSevice.themPhieuThanhToan(txtMaPTT.getText().trim(),
                cbbMaPDK.getSelectedItem().toString(),
                Integer.valueOf(txtSoThang.getText().trim()),
                txtNgayTT.getText().trim(), Float.valueOf(tongTien[0]), Float.valueOf(tienPhaiTra[0]));

        if (x > 0) {
            JOptionPane.showMessageDialog(null, "Thanh toán thành công");
        } else {
            JOptionPane.showMessageDialog(null, "Thanh toán thất bại");
            return;
        }

    }//xu ly them thanh toan
    
    public void xuLyLuuHoaHoaDon(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File file) {
                 return file.getAbsolutePath().endsWith(".txt");
            }

            @Override
            public String getDescription() {
                 return ".txt";
            }
        });
        fileChooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File file) {
                 return file.getAbsolutePath().endsWith(".doc");
            }

            @Override
            public String getDescription() {
                 return ".doc";
            }
        });
        int flag = fileChooser.showSaveDialog(null);
        if(flag == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            try {
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), Charset.forName("UTF-8"));
                PrintWriter printWriter = new PrintWriter(outputStreamWriter);
                String lineTieuDe1 =    "----------------Phiếu Thanh Toán-----------------------";
                String lineMaPTT =      "+Mã Phiếu Thanh Toán: " + txtMaPTT.getText();
                String lineMaPDK =      "+Mã Phiếu Đăng Ký: " + cbbMaPDK.getSelectedItem().toString();
                String lineSoThang =    "+Số Tháng: " + txtSoThang.getText()+"|";
                String lineNgayTT =     "+Ngày Thanh Toán: " + txtNgayTT.getText();
                String lineTienPhong =  "+Tiền Phòng: " + txtTongTien.getText();
                String lineTienDV =     "+Tiền Dịch Vụ: "+txtThanhToanTongCong.getText();
                String lineTieuDe2 =    "--------------------------------------------------------";
                String lineTienPhaiTra ="+Tiền Phải Trả: " + txtTienPhaiTra.getText()+"          ";
                String lineTieuDe3 =    "--------------------------------------------------------";
                 
                printWriter.println(lineTieuDe1);
                printWriter.println(lineMaPTT);
                printWriter.println(lineMaPDK);
                printWriter.println(lineSoThang);
                printWriter.println(lineNgayTT);
                printWriter.println(lineTienPhong);
                printWriter.println(lineTienDV);
                printWriter.println(lineTieuDe2);
                printWriter.println(lineTienPhaiTra);
                printWriter.println(lineTieuDe3);
                
                printWriter.close();
                outputStreamWriter.close();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Đã lưu");
        }
        
    }//lua phieu thanh thanh toan

//-------------CHECK THANH TOAN-------------------------------------------------
    private boolean checkSoThang(String soThang){
        String pattern = "\\d+"; 
        return soThang.matches(pattern);
    }//kiem tra so thang phai la kieu nguyen
    
    private boolean checkMaPhieuTT(String maPTT){
        String pattern = "PTT\\d+";
        return maPTT.matches(pattern);
    }//kiem ma phieu thanh toan 

}//End Class