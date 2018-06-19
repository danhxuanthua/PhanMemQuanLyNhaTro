/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyNhaTroMySQL.UI;

import QuanLyNhaTroMySQL.Model.PhongTroModel;
import QuanLyNhaTroMySQL.Model.ThietBiModel;
import QuanLyNhaTroMySQL.Model.TrangBiModel;
import QuanLyNhaTroMySQL.Service.PhongTroService;
import QuanLyNhaTroMySQL.Service.ThietBiService;
import QuanLyNhaTroMySQL.Service.TrangBiSevice;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DanhThua
 */
public class ThietBiUI extends JDialog{
    private DefaultTableModel modelThietBi, modelTrangBi;
    private JTable tbThietBi, tbTrangBi;
    private JButton btnThemThietBi, btnSuaThietBi, btnXoaThietBi, btnThemTrangBi, btnSuaTrangBi, btnXoaTrangBi, btnCapNhatTrangBi;
    private JTextField txtMaThietBi, txtTenThietB;
    private JComboBox cbbMaTB, cbbMaPhong;
    private ArrayList<ThietBiModel> thietBiModels = null;
    private String maThietBi;
    private ArrayList<PhongTroModel> phongTroModels = null;
    private ArrayList<TrangBiModel> trangBiModels = null;
    
    public ThietBiUI(String title) {
        this.setTitle(title);
        ImageIcon img = new ImageIcon(".\\src\\QuanLyNhaTroMySQL.Icon\\title.png");
        this.setIconImage(img.getImage());
        this.addControls();
        this.addEvent();
       
        hienThiToanBoMaPhong();//Thuoc Trang bi
        
        hienThiToanBoMaThietBi();//Thuoc Trang bi
        
        hienThiToanBoPhongDuocTrangBi();//Thuoc Trang bi
        
        hienThiDanhSachThietBi();//Thuoc Thiet bi
    }

    public void showWindows() {
        this.setSize(1145, 518);
        this.setLocation(225, 135);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setModal(true);
        
        this.setVisible(true);
    }//showWindows

    private void addControls() {
        Container container = getContentPane();
            JPanel pnMain = new JPanel(new BorderLayout());
                
                // pn Top
                JPanel pnTop = new JPanel(new BorderLayout());
                pnTop.setPreferredSize(new Dimension(0, 200));
                pnTop.setBackground(Color.decode("#086A87"));
                
                // pn Bottom
                JPanel pnBottom = new JPanel(new BorderLayout());
                pnBottom.setBackground(Color.decode("#086A87"));
                    //Split pane Top
                    JPanel pnTopLeft = new JPanel(new BorderLayout());
                    TitledBorder titledBorderTopLeft = new TitledBorder(BorderFactory.createLineBorder(Color.WHITE), "Thiết Bị");
                    titledBorderTopLeft.setTitleColor(Color.WHITE);
                    pnTopLeft.setBorder(titledBorderTopLeft);
                    pnTopLeft.setBackground(Color.decode("#0489B1"));
                    pnTopLeft.setPreferredSize(new Dimension(660, 500));
                    
                    
                    JPanel pnTopRight = new JPanel(new BorderLayout());
                    pnTopRight.setPreferredSize(new Dimension(470, 500));
                    TitledBorder titledBorderTopRight = new TitledBorder(BorderFactory.createLineBorder(Color.WHITE), "Trang Bị");
                    titledBorderTopRight.setTitleColor(Color.WHITE);
                    pnTopRight.setBorder(titledBorderTopRight);
                    pnTopRight.setBackground(Color.decode("#0489B1"));
                   
                pnTop.add(pnTopLeft, BorderLayout.WEST);
                pnTop.add(pnTopRight, BorderLayout.EAST);
                
                        //pnTopLeft
                        modelThietBi = new DefaultTableModel();
                        modelThietBi.addColumn("Mã Thiết Bị");
                        modelThietBi.addColumn("Tên Thiết bị");
                        tbThietBi = new JTable(modelThietBi);
                        tbThietBi.setBackground(Color.decode("#0489B1"));
                        tbThietBi.setForeground(Color.WHITE);
                        tbThietBi.setSelectionBackground(Color.WHITE);
                        tbThietBi.setSelectionForeground(Color.decode("#086A87"));
                        tbThietBi.setShowGrid(false);
                       
                        JScrollPane scrollTBThietBi = new JScrollPane(tbThietBi,
                                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    pnTopLeft.add(scrollTBThietBi, BorderLayout.CENTER);
                        
                        //Chi tiet thiet bi
                        JPanel pnChiTietThietBi = new JPanel();
                        pnChiTietThietBi.setLayout(new BoxLayout(pnChiTietThietBi, BoxLayout.Y_AXIS));
                        
                            //Ma thiet bi
                            JPanel pnMaThietBi = new JPanel();
                            pnMaThietBi.setBackground(Color.decode("#0489B1"));
                                JLabel lblMaThietBi = new JLabel("Mã thiết bị");
                                lblMaThietBi.setForeground(Color.WHITE);
                            pnMaThietBi.add(lblMaThietBi);
                                txtMaThietBi = new JTextField(10);
                            pnMaThietBi.add(txtMaThietBi);
                            
                            //Ten Thiet bi
                                JLabel lblTenThietBi = new JLabel("Tên thiết bị");
                                lblTenThietBi.setForeground(Color.WHITE);
                            pnMaThietBi.add(lblTenThietBi);
                                txtTenThietB = new JTextField(15);
                            pnMaThietBi.add(txtTenThietB);
                        pnChiTietThietBi.add(pnMaThietBi);
                        
                            //Pn them thiet bi
                            JPanel pnThemThietBi= new JPanel();
                            pnThemThietBi.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                            pnThemThietBi.setBackground(Color.decode("#0489B1"));
                            
                                btnThemThietBi = new JButton("Thêm");
                                btnThemThietBi.setForeground(Color.decode("#086A87"));
                                btnThemThietBi.setBackground(Color.WHITE);
                            pnThemThietBi.add(btnThemThietBi);
                            
                                btnSuaThietBi = new JButton("Sửa");
                                btnSuaThietBi.setForeground(Color.decode("#086A87"));
                                btnSuaThietBi.setBackground(Color.WHITE);
                            pnThemThietBi.add(btnSuaThietBi);
                            
                                btnXoaThietBi = new JButton("Xóa");
                                btnXoaThietBi.setForeground(Color.decode("#086A87"));
                                btnXoaThietBi.setBackground(Color.WHITE);
                            pnThemThietBi.add(btnXoaThietBi);
                            
                        pnChiTietThietBi.add(pnThemThietBi);
                        
                    pnTopLeft.add(pnChiTietThietBi,BorderLayout.SOUTH);
                    
                    //PnTopRight
                        JPanel pnTrangBi = new JPanel();
                       
                        pnTrangBi.setLayout(new BoxLayout(pnTrangBi, BoxLayout.Y_AXIS));
                            
                            //Ma phong
                            JPanel pnMaPhong = new JPanel();
                            pnMaPhong.setBackground(Color.decode("#0489B1"));
                                JLabel lblMaPhong = new JLabel("Mã Phòng");
                                lblMaPhong.setForeground(Color.WHITE);
                                
                            pnMaPhong.add(lblMaPhong);
                                cbbMaPhong = new JComboBox();
                                cbbMaPhong.addItem("Trống");
                                cbbMaPhong.setMaximumRowCount(7);
                                cbbMaPhong.setPreferredSize(new Dimension(100 ,28));
                                cbbMaPhong.setBackground(Color.WHITE);
                                cbbMaPhong.setForeground(Color.decode("#086A87"));
                            pnMaPhong.add(cbbMaPhong);
                            
                                JLabel lblTab = new JLabel("    ");
                                lblTab.setForeground(Color.decode("#086A87"));
                            pnMaPhong.add(lblTab);
                            
                            //Ma thiet bi
                                JLabel lblMaTrangBiThietBi = new JLabel("Mã Thiết Bị");
                                lblMaTrangBiThietBi.setForeground(Color.WHITE);
                            pnMaPhong.add(lblMaTrangBiThietBi);
                                cbbMaTB = new JComboBox();
                                cbbMaTB.addItem("Trống");
                                cbbMaTB.setMaximumRowCount(7);
                                cbbMaTB.setPreferredSize(new Dimension(100 ,28));
                                cbbMaTB.setBackground(Color.WHITE);
                                cbbMaTB.setForeground(Color.decode("#086A87"));
                            pnMaPhong.add(cbbMaTB);
                        pnTrangBi.add(pnMaPhong);
                            
                            JPanel pnChucNangLine1 = new JPanel();
                            pnChucNangLine1.setBackground(Color.decode("#0489B1"));
                                btnThemTrangBi = new JButton("Trang bị");
                                btnThemTrangBi.setForeground(Color.decode("#086A87"));
                                btnThemTrangBi.setBackground(Color.WHITE);
                                btnThemTrangBi.setIcon(new ImageIcon(".\\src\\QuanLyNhaTroMySQL.Icon\\ThemTrangBi.png"));
                            pnChucNangLine1.add(btnThemTrangBi);
                                btnSuaTrangBi = new JButton("Cập nhật");
                                btnSuaTrangBi.setForeground(Color.decode("#086A87"));
                                btnSuaTrangBi.setBackground(Color.WHITE);
                                btnSuaTrangBi.setIcon(new ImageIcon(".\\src\\QuanLyNhaTroMySQL.Icon\\CapNhatTrangBi.png"));
                                
                            pnChucNangLine1.add(btnSuaTrangBi);
                                btnXoaTrangBi = new JButton("Loại bỏ");
                                btnXoaTrangBi.setForeground(Color.decode("#086A87"));
                                btnXoaTrangBi.setBackground(Color.WHITE);
                                btnXoaTrangBi.setIcon(new ImageIcon(".\\src\\QuanLyNhaTroMySQL.Icon\\XoaTrangBi.png"));
                            pnChucNangLine1.add(btnXoaTrangBi);
                        pnTrangBi.add(pnChucNangLine1);
                        
                            JPanel pnChucNangLine2 = new JPanel();
                            pnChucNangLine2.setBackground(Color.decode("#0489B1"));
                                btnCapNhatTrangBi = new JButton("Reload");
                                btnCapNhatTrangBi.setForeground(Color.decode("#086A87"));
                                btnCapNhatTrangBi.setBackground(Color.WHITE);
                                btnCapNhatTrangBi.setIcon(new ImageIcon(".\\src\\QuanLyNhaTroMySQL.Icon\\ReloadTrangBi.png"));
                            pnChucNangLine2.add(btnCapNhatTrangBi);
                        pnTrangBi.add(pnChucNangLine2);
                    pnTopRight.add(pnTrangBi, BorderLayout.CENTER);
                    
                    //can le
                                btnXoaTrangBi.setPreferredSize(btnThemTrangBi.getPreferredSize());
                        
                //Bottom
                    JPanel pnTbTrangBi = new JPanel(new BorderLayout());
                    pnTbTrangBi.setBackground(Color.decode("#086A87"));
                    TitledBorder titledBorderTBTrangBi = new TitledBorder(BorderFactory.createLineBorder(Color.WHITE),"Phòng Đã Trang Bị" );
                    titledBorderTBTrangBi.setTitleColor(Color.WHITE);
                    pnTbTrangBi.setBorder(titledBorderTBTrangBi);
                        modelTrangBi = new DefaultTableModel();
                        modelTrangBi.addColumn("Mã Phòng");
                        modelTrangBi.addColumn("Hiện Trạng Phòng");
                        modelTrangBi.addColumn("Giá Phòng");
                        modelTrangBi.addColumn("Tên Thiết Bị");
                        modelTrangBi.addColumn("Mã Thiết Bị");
                        tbTrangBi = new JTable(modelTrangBi);
                       
                        tbTrangBi.setBackground(Color.decode("#0489B1"));
                        tbTrangBi.setForeground(Color.WHITE);
                        tbTrangBi.setSelectionBackground(Color.WHITE);
                        tbTrangBi.setSelectionForeground(Color.decode("#086A87"));
                        tbTrangBi.setShowGrid(false);
                        JScrollPane scrollTBTrangBi = new JScrollPane(tbTrangBi,
                                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    pnTbTrangBi.add(scrollTBTrangBi, BorderLayout.CENTER);
                   
                pnBottom.add(pnTbTrangBi, BorderLayout.CENTER);
                 
            pnMain.add(pnTop, BorderLayout.NORTH);
            pnMain.add(pnBottom, BorderLayout.CENTER);
        container.add(pnMain);
        
    }//add controls

    private void addEvent() {
        
        tbThietBi.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                xuLyLayMaThietBi();
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
        
        btnThemThietBi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                xuLyThemThietBi();
            }
        });
        
        btnSuaThietBi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                xuLySuaThietBi();
            }
        });
        
        btnXoaThietBi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                xuLyXoaThietBi();
            }
        });
        
        btnCapNhatTrangBi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                hienThiToanBoMaThietBi();
            }
        });
        
        btnThemTrangBi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                xuLyThemTrangBi();
            }
        });
        
        tbTrangBi.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                xuLyKhiClickVaoTBTrangBi();
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
        
        btnSuaTrangBi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                xuLySuaTrangBi();
            }
        });
        
        btnXoaTrangBi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                xuLyXoaTrangBi();
            }
        });
    
    }//add event
    
   //---------------CAC HAM XU LY THIET BI--------------------------------------
    private void hienThiDanhSachThietBi() {
        ThietBiService thietBiService = new ThietBiService();
        thietBiModels = thietBiService.layToanBoThietBi();
        modelThietBi.setRowCount(0);
        if(thietBiModels != null){
            for (ThietBiModel thietBiModel : thietBiModels) {
                Vector vtRow = new Vector();
                vtRow.add(thietBiModel.getMaThietBi());
                vtRow.add(thietBiModel.getTenThietBi());
                modelThietBi.addRow(vtRow);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Hiện thị thất bại");
            return;
        }
    }//hien thi danh sach
    
    private void xuLyThemThietBi() {
        ThietBiService thietBiService = new ThietBiService();
        
        if (checkMaThietBi(txtMaThietBi.getText()) == true) {
            if (thietBiService.kiemTraThietBiCoTonTai(txtMaThietBi.getText()) == false) {
                int result = thietBiService.themThietBi(txtMaThietBi.getText(), txtTenThietB.getText());

                if (result > 0) {
                    hienThiDanhSachThietBi();
                    JOptionPane.showMessageDialog(null, "Đã thêm!");
                } else {
                    JOptionPane.showMessageDialog(null, "Thêm thất bai!");
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Thiết bị đã tồn tại. Vui lòng kiểm tra lại!");
                txtMaThietBi.requestFocus();
                return;
            }
        }else{
            JOptionPane.showMessageDialog(null, "Định dạng không hợp lệ!\nMã thiết bị có dạng [TB+Số]");
                txtMaThietBi.requestFocus();
                return;
        }
    }//xu ly them

    private void xuLyLayMaThietBi() {
        int result = tbThietBi.getSelectedRow();
        maThietBi = (String) tbThietBi.getValueAt(result, 0);
        
        ThietBiService thietBiService = new ThietBiService();
        thietBiModels = thietBiService.layThietBiTheoMaThietBi(maThietBi);
        hienThiThietBiTheoMaThietBi();// dua vao txt field
    }//Lay ma thiet bi

    private void hienThiThietBiTheoMaThietBi() {
        if(thietBiModels != null){
            for (ThietBiModel thietBiModel : thietBiModels) {
               txtMaThietBi.setText(thietBiModel.getMaThietBi());
               txtTenThietB.setText(thietBiModel.getTenThietBi());
            }
        }else{
            JOptionPane.showMessageDialog(null, "Hiện thị thất bại");
            return;
        }
    }//hien thi thiet bi theo ma dau vao text field
    
    public void xuLySuaThietBi(){
        ThietBiService thietBiService = new ThietBiService();
        
        if (thietBiService.kiemTraThietBiCoTonTai(txtMaThietBi.getText()) == true) {
            int result = thietBiService.suaThietBi(txtMaThietBi.getText(), txtTenThietB.getText());
            
            if (result > 0) {
                hienThiDanhSachThietBi();
                JOptionPane.showMessageDialog(null, "Đã cập nhật!");
            } else {
                JOptionPane.showMessageDialog(null, "Cập nhật thất bại!");
                return;
            }
        }else{
            JOptionPane.showMessageDialog(null, "Thiết bị không tồn tại. Vui lòng kiểm tra lại!");
            txtMaThietBi.requestFocus();
            return;
        }
    }//sua thiet bi
    
    public void xuLyXoaThietBi() {
        ThietBiService thietBiService = new ThietBiService();

        if (thietBiService.kiemTraThietBiCoTonTai(txtMaThietBi.getText()) == true) {
            int xacNhan = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa thiết bị [" + txtTenThietB.getText() + "]",
                    "Xác Nhận", JOptionPane.YES_NO_OPTION);
            if (xacNhan == JOptionPane.YES_OPTION) {
                int result = thietBiService.xoaThietBi(txtMaThietBi.getText());

                if (result > 0) {
                    hienThiDanhSachThietBi();
                    JOptionPane.showMessageDialog(null, "Đã xóa !");
                } else {
                    JOptionPane.showMessageDialog(null, "Xóa thất bại!");
                    return;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Thiết bị không tồn tại. Vui lòng kiểm tra lại!");
            txtMaThietBi.requestFocus();
            return;
        }
    }//xoa thiet bi
    
    public boolean checkMaThietBi(String maTB){
        String pattern = "TB\\d+";
        return maTB.matches(pattern);
    }//kiem tra ma Thiet Bi
    
    
//------------------CAC HAM XU LY TRANG BI--------------------------------------
    private void hienThiToanBoMaPhong() {
        PhongTroService phongTroService = new PhongTroService();
        phongTroModels = phongTroService.layToanBoPhongTro();
        if(phongTroModels != null){
            cbbMaPhong.removeAllItems();
            for (PhongTroModel phongTroModel : phongTroModels) {
                cbbMaPhong.addItem(phongTroModel.getMaPhong());
            }
        }else{
            JOptionPane.showMessageDialog(null, "Hiện thị phòng trọ thất bại");
            return;
        }
    }//hien thi toan bo ma phong
    
    private void hienThiToanBoMaThietBi(){
        ThietBiService thietBiService = new ThietBiService();
        thietBiModels = thietBiService.layToanBoThietBi();
        cbbMaTB.removeAllItems();
        if(thietBiModels != null){
            for (ThietBiModel thietBiModel : thietBiModels) {
                cbbMaTB.addItem(thietBiModel.getMaThietBi());
            }
        }else{
            JOptionPane.showMessageDialog(null, "Hiện thị thất bại");
            return;
        }
    }//Hien thi toan bo ma thiet bi

    private void hienThiToanBoPhongDuocTrangBi() {
        TrangBiSevice trangBiSevice = new TrangBiSevice();
        trangBiModels = trangBiSevice.layToanBoPhongDuocTrangBi();
        
        modelTrangBi.setRowCount(0);
        if (trangBiModels != null) {
            for (TrangBiModel trangBiModel : trangBiModels) {
                Vector vtRow = new Vector();
                vtRow.add(trangBiModel.getMaPhong());
                vtRow.add(trangBiModel.getHienTrangPhong());
                vtRow.add(trangBiModel.getGiaPhong());
                vtRow.add(trangBiModel.getTenThietBi());
                vtRow.add(trangBiModel.getMaTB());
                modelTrangBi.addRow(vtRow);
            }
        }
        
    }//Danh sach phong duoc trang bi
    
    private void xuLyThemTrangBi() {
        TrangBiSevice trangBiSevice = new TrangBiSevice();
        int result = trangBiSevice.themTrangBi(cbbMaPhong.getSelectedItem().toString(),cbbMaTB.getSelectedItem().toString());
        
        if(result > 0){
            hienThiToanBoPhongDuocTrangBi();
            JOptionPane.showMessageDialog(null, "Đã thêm !");
        }else{
            JOptionPane.showMessageDialog(null, "Thêm thất bại!");
            return;
        }
    }//xu ly them trang bi
    
    private void xuLyKhiClickVaoTBTrangBi(){
        int result = tbTrangBi.getSelectedRow();
        String maPhong = (String) tbTrangBi.getValueAt(result, 0);
        String maTB = (String) tbTrangBi.getValueAt(result, 4);
        
        cbbMaPhong.setSelectedItem(maPhong);
        cbbMaTB.setSelectedItem(maTB);
    }//xu ly khi click vao table Trang bi
    
    private void xuLySuaTrangBi(){
        TrangBiSevice trangBiSevice = new TrangBiSevice();
        int result = trangBiSevice.suaTrangBi(cbbMaPhong.getSelectedItem().toString(), cbbMaTB.getSelectedItem().toString());
        if (result > 0){
            hienThiToanBoPhongDuocTrangBi();
            JOptionPane.showMessageDialog(null, "Đã cập nhật !");
        }else{
            JOptionPane.showMessageDialog(null, "Cập nhật thất bại. Vui lòng kiểm tra lại mã phòng !");
            cbbMaPhong.requestFocus();
            return;
        }    
    }//sua trang bi
  
    private void xuLyXoaTrangBi() {
        int kiemTra = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa?", "Xác Nhận", JOptionPane.YES_NO_OPTION);
        if (kiemTra == JOptionPane.YES_OPTION) {
            TrangBiSevice trangBiSevice = new TrangBiSevice();
            int result = trangBiSevice.xoaTrangBi(cbbMaPhong.getSelectedItem().toString(), cbbMaTB.getSelectedItem().toString());
            if (result > 0) {
                hienThiToanBoPhongDuocTrangBi();
                JOptionPane.showMessageDialog(null, "Đã Xóa!");
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thất bại \nVui lòng kiểm tra lại mã phòng và mã thiết bị !");
                cbbMaPhong.requestFocus();
                return;
            }
        }
    }
}
