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
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author DanhThua
 */
public class ThongTinUI extends JDialog{

    public ThongTinUI(String tieuDe) {
        this.setTitle(tieuDe);
        ImageIcon img = new ImageIcon(".\\src\\QuanLyNhaTroMySQL.Icon\\title.png");
        this.setIconImage(img.getImage());
        this.addControls();
        this.addEvent();
    }

    public void showWindows() {
        this.setSize(700,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setModal(true);
        this.setResizable(false);
        this.setVisible(true); 
    }

    private void addControls() {
        Container container = getContentPane();
        
            JPanel pnMain = new JPanel(new BorderLayout());
            pnMain.setBackground(Color.decode("#0489B1"));
                JPanel pnTop = new JPanel();
                pnTop.setBackground(Color.decode("#0489B1"));
                 
                    JLabel lblTieuDe = new JLabel("PHẦN MỀM QUẢN LÝ NHÀ TRỌ");
                    lblTieuDe.setFont(new Font("arial", Font.BOLD, 30));
                    lblTieuDe.setForeground(Color.WHITE);
                    
                pnTop.add(lblTieuDe);
                
            pnMain.add(pnTop, BorderLayout.NORTH);
                
                JPanel pnCenter = new JPanel();
                pnCenter.setBackground(Color.decode("#0489B1"));
                
                    JTextArea txtNoiDung = new JTextArea();
                    txtNoiDung.setBackground(Color.decode("#0489B1"));
                    txtNoiDung.setWrapStyleWord(true);
                    txtNoiDung.setLineWrap(true);
                    txtNoiDung.setPreferredSize(new Dimension(500, 300));
                    txtNoiDung.setEnabled(false);
                    txtNoiDung.setForeground(Color.WHITE);
                    txtNoiDung.setText("Version 1.0\nProject kết thúc học phần java, đề tài quản lý nhà trọ."
                            + "\nXin chân thành cám ơn Thầy Nguyễn Minh Đức đã tận tình hướng dẫn và giúp đỡ trong"
                            + " thời gian thực hiện.\nRất mong nhận được sự đóng góp ý kiến của Thầy và các Bạn để chương trình được hoàn thiện hơn.\n"
                            + "\t\t\t\t\tTháng 9 năm 2017\n\t\t\t\t\tDanh Xuân Thừa");
                    JScrollPane scrollNoiDung = new JScrollPane(txtNoiDung,
                            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                    txtNoiDung.setFont(new Font("arial", Font.LAYOUT_LEFT_TO_RIGHT, 18));
                pnCenter.add(scrollNoiDung);
            pnMain.add(pnCenter, BorderLayout.CENTER);
        container.add(pnMain);
    }

    private void addEvent() {
       
    }
    
}
