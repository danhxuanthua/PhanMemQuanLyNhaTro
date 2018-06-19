/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyNhaTroMySQL.UI;

import QuanLyNhaTroMySQL.Model.PhieuThanhToanModel;
import QuanLyNhaTroMySQL.Service.PhieuThanhToanSevice;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DanhThua
 */
public class ThongKeUI extends JDialog{

    private DefaultTableModel modelThang, modelPhieuTT;
    private JTable tbThang, tbPhieuTT;
    private JButton btnXoaPTT;
    private ArrayList<PhieuThanhToanModel> phieuThanhToanModels =null;
    private JLabel lblTongDoanhThuKQ, lblThang, lblTongDoanhThuThangKQ, lblNam;
    public ThongKeUI(String title) {
        this.setTitle(title);
        ImageIcon img = new ImageIcon(".\\src\\QuanLyNhaTroMySQL.Icon\\title.png");
        this.setIconImage(img.getImage());
        this.addControls();
        this.addEvent();
    }

    public void showWindows() {
        this.setSize(1145, 618);
        this.setLocation(225, 115);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setModal(true);
        this.setVisible(true);
    }//Show Windows

    private void addControls() {
        Container container = getContentPane();
            
            JPanel pnMain = new JPanel(new BorderLayout());
            
                //pn Top
                JPanel pnTop = new JPanel(new BorderLayout());
               
                    
                    //pn TopLeft
                    JPanel pnTopLeft = new JPanel(new BorderLayout());
                    pnTopLeft.setBackground(Color.decode("#0489B1"));
                    pnTopLeft.setPreferredSize(new Dimension(150, 0));
                    TitledBorder titlePnLeft = new TitledBorder(BorderFactory.createLineBorder(Color.WHITE), "Tháng");
                    titlePnLeft.setTitleColor(Color.WHITE);
                    pnTopLeft.setBorder(titlePnLeft);
                        //tb Thang
                        modelThang = new DefaultTableModel();
                        modelThang.addColumn("Tháng");
                        tbThang = new JTable(modelThang);
                        tbThang.setBackground(Color.decode("#0489B1"));
                        tbThang.setForeground(Color.WHITE);
                        tbThang.setSelectionBackground(Color.WHITE);
                        tbThang.setSelectionForeground(Color.decode("#086A87"));
                        tbThang.setShowGrid(false);
                        JScrollPane scrollTbThang = new JScrollPane(tbThang,
                                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                        
                    pnTopLeft.add(scrollTbThang, BorderLayout.CENTER);
                
                pnTop.add(pnTopLeft, BorderLayout.WEST);
                
                    //pn Top Center
                    JPanel pnTopCenter = new JPanel(new BorderLayout());
                    pnTopCenter.setBackground(Color.decode("#0489B1"));
                    TitledBorder titlePnCenter = new TitledBorder(BorderFactory.createLineBorder(Color.WHITE), "Danh Sách Hóa Đơn");
                    titlePnCenter.setTitleColor(Color.WHITE);
                    pnTopCenter.setBorder(titlePnCenter);    
                        //tb PhieuTT
                        modelPhieuTT = new DefaultTableModel();
                        modelPhieuTT.addColumn("Mã Phiếu Thanh Toán");
                        modelPhieuTT.addColumn("Mã Phiếu Đăng Ký");
                        modelPhieuTT.addColumn("Số Tháng");
                        modelPhieuTT.addColumn("Ngày Thanh Toán");
                        modelPhieuTT.addColumn("Tiền Phòng");
                        modelPhieuTT.addColumn("Tiền phải trả");
                        tbPhieuTT = new JTable(modelPhieuTT);
                        tbPhieuTT.setBackground(Color.decode("#0489B1"));
                        tbPhieuTT.setForeground(Color.WHITE);
                        tbPhieuTT.setSelectionBackground(Color.WHITE);
                        tbPhieuTT.setSelectionForeground(Color.decode("#086A87"));
                        tbPhieuTT.setShowGrid(false);
                        JScrollPane scrollTbPhieuTT = new JScrollPane(tbPhieuTT,
                                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                        
                    pnTopCenter.add(scrollTbPhieuTT, BorderLayout.CENTER);
                pnTop.add(pnTopCenter, BorderLayout.CENTER);
                    
                    //Pn Top Right
                    JPanel pnTopRight = new JPanel();
                    pnTopRight.setBackground(Color.decode("#0489B1"));
                    TitledBorder titlePnRight = new TitledBorder(BorderFactory.createLineBorder(Color.WHITE), "Chức Năng");
                    titlePnRight.setTitleColor(Color.WHITE);
                    pnTopRight.setBorder(titlePnRight);
                    pnTopRight.setLayout(new BoxLayout(pnTopRight, BoxLayout.Y_AXIS));
                        
                        //btn xoa
                        btnXoaPTT = new JButton("Xóa Hóa Đơn");
                        btnXoaPTT.setForeground(Color.decode("#086A87"));
                        btnXoaPTT.setBackground(Color.WHITE);
                        
                    pnTopRight.add(btnXoaPTT);
                pnTop.add(pnTopRight, BorderLayout.EAST);
                
                    //pn bottom
                JPanel pnBottom = new JPanel();
                pnBottom.setBackground(Color.decode("#0489B1"));
                pnBottom.setLayout(new BoxLayout(pnBottom, BoxLayout.X_AXIS));
                        
                        //Tong doanh thu
                        JPanel pnTongDoanhThu = new JPanel(new FlowLayout(FlowLayout.LEFT));
                        pnTongDoanhThu.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                        pnTongDoanhThu.setBackground(Color.decode("#0489B1"));
                        
                            JLabel lblTongDoanhThu = new JLabel("Tổng doanh thu Năm ");
                            lblTongDoanhThu.setForeground(Color.WHITE);
                            lblTongDoanhThu.setFont(new Font("arial", Font.BOLD, 20));
                        pnTongDoanhThu.add(lblTongDoanhThu);
                            lblNam = new JLabel();
                            lblNam.setFont(new Font("arial", Font.BOLD, 20));
                            lblNam.setForeground(Color.WHITE);
                        pnTongDoanhThu.add(lblNam);
                            lblTongDoanhThuKQ = new JLabel();
                            lblTongDoanhThuKQ.setForeground(Color.RED);
                            lblTongDoanhThuKQ.setFont(new Font("arial", Font.BOLD, 20));
                        pnTongDoanhThu.add(lblTongDoanhThuKQ);
                pnBottom.add(pnTongDoanhThu);
                        
                        //Tong doanh thu thang
                        JPanel pnTongDoanhThuThang = new JPanel();
                        pnTongDoanhThuThang.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                        pnTongDoanhThuThang.setBackground(Color.decode("#0489B1"));
                        
                            JLabel lblTongDoanhThuThang = new JLabel("Tổng doanh thu Tháng ");
                            lblTongDoanhThuThang.setForeground(Color.WHITE);
                            lblTongDoanhThuThang.setFont(new Font("arial", Font.BOLD, 20));
                        pnTongDoanhThuThang.add(lblTongDoanhThuThang);
                            lblThang = new JLabel();
                            lblThang.setFont(new Font("arial", Font.BOLD, 20));
                            lblThang.setForeground(Color.WHITE);
                        pnTongDoanhThuThang.add(lblThang);
                            lblTongDoanhThuThangKQ = new JLabel();
                            lblTongDoanhThuThangKQ.setFont(new Font("arial", Font.BOLD, 20));
                            lblTongDoanhThuThangKQ.setForeground(Color.RED);
                        pnTongDoanhThuThang.add(lblTongDoanhThuThangKQ);
                pnBottom.add(pnTongDoanhThuThang);
                
            pnMain.add(pnTop, BorderLayout.NORTH);
            pnMain.add(pnBottom,BorderLayout.CENTER);
        container.add(pnMain);
    }//add Controls

    private void addEvent() {
       xuLyHienThiThang();
       
       tbThang.addMouseListener(new MouseListener() {
           @Override
           public void mouseClicked(MouseEvent me) {
               int result = tbThang.getSelectedRow();
               String namVaThang = (String) tbThang.getValueAt(result, 0);
               String[] tachNamVaThang = namVaThang.split("-");
               
               xuLuHienThiPhieuTTTheoNamVaThang(tachNamVaThang[0], tachNamVaThang[1]);
               xuLuHienThiTongDoanhThuTheoNam(tachNamVaThang[0]);
               xuLuHienThiTongDoanhThuTheoNamVaThang(tachNamVaThang[0], tachNamVaThang[1]);
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
       
       btnXoaPTT.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
            int result = tbPhieuTT.getSelectedRow();
               String maPTT = (String) tbPhieuTT.getValueAt(result, 0);
               xuLyXoaPhieuTT(maPTT);
           }
       });
    }//add Event
 
//---------------CAC HAM XU LY PHIEU THANH TOAN---------------------------------
    private void xuLyHienThiThang() {
        PhieuThanhToanSevice phieuThanhToanSevice = new PhieuThanhToanSevice();
        phieuThanhToanModels = phieuThanhToanSevice.layThangNamThanhToanLoaiBoTrungLap();
        for (PhieuThanhToanModel phieuThanhToanModel : phieuThanhToanModels) {
            Vector vtRow = new Vector();
            vtRow.add(phieuThanhToanModel.getNam()+"-"+phieuThanhToanModel.getThang());
            modelThang.addRow(vtRow);
        }
    }//xu ly hien thi thang
    
    public void xuLuHienThiPhieuTTTheoNamVaThang(String nam, String thang){
        PhieuThanhToanSevice phieuThanhToanSevice = new PhieuThanhToanSevice();
        phieuThanhToanModels = phieuThanhToanSevice.layPhieuTTTheoNamVaThang(nam, thang);
        
        modelPhieuTT.setRowCount(0);
        for (PhieuThanhToanModel phieuThanhToanModel : phieuThanhToanModels) {
            Vector vtRow = new Vector();
            vtRow.add(phieuThanhToanModel.getMaPTT());
            vtRow.add(phieuThanhToanModel.getMaPDK());
            vtRow.add(phieuThanhToanModel.getSoThang());
            vtRow.add(phieuThanhToanModel.getNgayTT());
            vtRow.add(phieuThanhToanModel.getTongTien());
            vtRow.add(phieuThanhToanModel.getTienPhaiTra());
            modelPhieuTT.addRow(vtRow);
        }
    }//xu ly hien thi phieu thanh toan theo nam va theo thang
    
    public void xuLuHienThiTongDoanhThuTheoNam(String nam){
        PhieuThanhToanSevice phieuThanhToanSevice = new PhieuThanhToanSevice();
        phieuThanhToanModels = phieuThanhToanSevice.layTongDoanhThuTheoNam(nam);
        
        for (PhieuThanhToanModel phieuThanhToanModel : phieuThanhToanModels) {
            lblNam.setText(nam +": ");
            lblTongDoanhThuKQ.setText(phieuThanhToanModel.getTongDoanhThuTheoNam()+" VNĐ");
        }
    }//xu ly tinh tong doang thu theo tung nam
    
    public void xuLuHienThiTongDoanhThuTheoNamVaThang(String nam, String thang){
        PhieuThanhToanSevice phieuThanhToanSevice = new PhieuThanhToanSevice();
        phieuThanhToanModels = phieuThanhToanSevice.layTongDoanhThuTheoThang(nam, thang);
       
        for (PhieuThanhToanModel phieuThanhToanModel : phieuThanhToanModels) {
            lblThang.setText(thang + " Năm " +nam+ ": ");
            lblTongDoanhThuThangKQ.setText(phieuThanhToanModel.getTongDoanhThuTheoNamVaThang()+" VNĐ");
        }
    }//xu ly tinh tong doang thu theo tung thang cua nam
    
    public void xuLyXoaPhieuTT(String maPTT){
        int result = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa?", "Xác Nhận", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION){
            PhieuThanhToanSevice phieuThanhToanSevice = new PhieuThanhToanSevice();
            int x = phieuThanhToanSevice.xoaPhieuTT(maPTT);
            if(x>0){
                xuLyHienThiPTT(maPTT);
                JOptionPane.showMessageDialog(null, "Đã xóa!");
            }else{
                JOptionPane.showMessageDialog(null, "Xóa thất bại");
                return;
            }
        }
    }//xu ly xoa phieu thanh toan
    
    public void xuLyHienThiPTT(String maPTT){
        PhieuThanhToanSevice phieuThanhToanSevice = new PhieuThanhToanSevice();
        phieuThanhToanModels = phieuThanhToanSevice.layToanBoPhieuThanhToanTheoMa(maPTT);
        modelPhieuTT.setRowCount(0);
        for (PhieuThanhToanModel phieuThanhToanModel : phieuThanhToanModels) {
            Vector vtRow = new Vector();
            vtRow.add(phieuThanhToanModel.getMaPTT());
            vtRow.add(phieuThanhToanModel.getMaPDK());
            vtRow.add(phieuThanhToanModel.getSoThang());
            vtRow.add(phieuThanhToanModel.getNgayTT());
            vtRow.add(phieuThanhToanModel.getTongTien());
            vtRow.add(phieuThanhToanModel.getTienPhaiTra());
            modelPhieuTT.addRow(vtRow);
        }
    }
    
}
