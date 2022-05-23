/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rental;

import Rental.Koneksi;
import com.mysql.jdbc.Statement;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;


public class MenuAdmin1 extends javax.swing.JFrame {
    String s;
     
    
    public MenuAdmin1() {
        initComponents();
        this.setExtendedState(MAXIMIZED_HORIZ);
        setVisible(true);
        setResizable(false);
        datatable();
        datatable1();
        datatable2();
        datatatble3();
        ID();
        datanow();
        getTot();
       
    }
    
    public String cmb_id;
    public String id_buku;
    public String K;
    String pinjam2 = null;
    String kembali2 = null;
    int hitung ;
    
    public void datanow (){
        Date dt = new Date();
        tanggal_now.setDate(dt);
        tanggal_now1.setDate(dt); 
    }
    public void datatable (){
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("ID BUKU");
        tbl.addColumn("JUDUL BUKU");
        tbl.addColumn("TAHUN TERBIT");
        tbl.addColumn("JENIS BUKU");
        tbl.addColumn("Sinopsis");
        tbl.addColumn("Harga buku");
        tbl.addColumn("stok");
        table.setModel(tbl);
        try {
             Statement statement =(Statement)Koneksi.getkoneksi().createStatement();
            ResultSet res=statement.executeQuery("select * from detail_buku ;");
            while(res.next())
            {        
             tbl.addRow(new Object[]{
                res.getString("ID_BUKU"),
                res.getString("JUDUL_BUKU"),
                res.getString("TAHUN_TERBIT"),
                res.getString("JENIS"),
                res.getString("sinopsis"),
                res.getString("harga_satuan"),
                res.getString("stok")
            });
            table.setModel(tbl);
            }
        } catch (Exception e) {
         }}
    
        public void datatable1 (){
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("EMAIL");
        tbl.addColumn("NAMA");
        tbl.addColumn("ALAMAT");
        tbl.addColumn("PASSWORD");
        tbl.addColumn("NOHP");
        table2.setModel(tbl);
        try {
             Statement statement =(Statement)Koneksi.getkoneksi().createStatement();
            ResultSet res=statement.executeQuery("SELECT * from peminjam");
            while(res.next())
            {        
             tbl.addRow(new Object[]{
                res.getString("email"),
                res.getString("nama"),
                res.getString("alamat"),
                res.getString("password"),
                res.getString("noHP")
            });
            table2.setModel(tbl);
            }
        } catch (Exception e) {
         }}
        
       public void datatable2 (){
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("ID Transaksi");
        tbl.addColumn("TGL PINJAM");
        tbl.addColumn("KEMBALI");
        tbl.addColumn("EMAIL");
        tbl.addColumn("HARGA TOTAL");
        tbl.addColumn("qty");
        
        table3.setModel(tbl);
        try {
             Statement statement =(Statement)Koneksi.getkoneksi().createStatement();
            ResultSet res=statement.executeQuery("select * from detail_peminjaman");
            while(res.next())
            {        
             tbl.addRow(new Object[]{
                res.getString("Id_transaksi"),
                res.getString("tgl_pinjam"),
                res.getString("kembali"),
                res.getString("email"),
                res.getString("hrg_total"),
                res.getString("banyak_pinjam"),
                });
            table3.setModel(tbl);
            }
        } catch (Exception e) {
        }}
        
        public void  datatatble3 () {
            DefaultTableModel bl = new DefaultTableModel();
            bl.addColumn("ID TRANSAKSI");
            bl.addColumn("ID BUKU");
            bl.addColumn("KEMBALI");
            bl.addColumn("TOTAL");
            bl.addColumn("QTY");
             table4.setModel(bl);

        try {
           Statement stm = (Statement) Koneksi.getkoneksi().createStatement();
           ResultSet rs = stm.executeQuery("select * from log_peminjam");
             while(rs.next()){
                 bl.addRow(new Object[] {
                 rs.getString("Id_transaksi"),
                 rs.getString("id_buku"),
                 rs.getString("kembali"),
                 rs.getString("total"),
                 rs.getString("qty")
                 });
             }
        } catch (SQLException ex) {
            Logger.getLogger(MenuAdmin1.class.getName()).log(Level.SEVERE, null, ex);
        }
             
        }

        
        public void tb () {
            try {
            Statement statement =(Statement)Koneksi.getkoneksi().createStatement();
            ResultSet res =statement.executeQuery("select * from detail_buku where id_buku LIKE '%"+txt_id.getText()+"%' OR jenis= '"+cmb_jenis.getSelectedItem()+"' OR judul_buku LIKE '%"+txt_judul.getText()+"%';");
            DefaultTableModel tbl =new DefaultTableModel();
            tbl.addColumn("ID BUKU");
            tbl.addColumn("JUDUL BUKU");
            tbl.addColumn("TAHUN TERBIT");
            tbl.addColumn("JENIS BUKU");
            tbl.addColumn("Sinopsis");
            tbl.addColumn("Harga buku");
            table.setModel(tbl);
            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("ID_BUKU"),
                    res.getString("JUDUL_BUKU"),
                    res.getString("TAHUN_TERBIT"),
                    res.getString("JENIS"),
                    res.getString("sinopsis"),
                    res.getString("harga_satuan")

                });
                table.setModel(tbl);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "salah");
        }
        }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BodyPanel = new javax.swing.JPanel();
        MenuPanel = new javax.swing.JPanel();
        btn_buku = new javax.swing.JButton();
        btn_user = new javax.swing.JButton();
        btn_transaksi = new javax.swing.JButton();
        btn_logout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        detail_pinjam = new javax.swing.JButton();
        MainPanel = new javax.swing.JPanel();
        Akun = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_email2 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txt_pass = new javax.swing.JTextField();
        txt_nama = new javax.swing.JTextField();
        txt_nohp = new javax.swing.JTextField();
        btn_update = new javax.swing.JButton();
        btn_hapus2 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        btn_simpan2 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        txt_alamat = new javax.swing.JTextArea();
        clear = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        buku_dipinjam = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        table4 = new javax.swing.JTable();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        update1 = new javax.swing.JButton();
        tgl_kembali1 = new com.toedter.calendar.JDateChooser();
        hapus1 = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        txtID1 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        tanggal_now1 = new com.toedter.calendar.JDateChooser();
        Peminjaman = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table3 = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        tgl_pinjam = new com.toedter.calendar.JDateChooser();
        tgl_kembali = new com.toedter.calendar.JDateChooser();
        update = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        tanggal_now = new com.toedter.calendar.JDateChooser();
        buku = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_judul = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_sinopsis = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        cmb_jenis = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txt_harga = new javax.swing.JTextField();
        btn_simpan = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        upload_gmb = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        labelfoto = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        txtStok = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        thnterbit = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin");

        BodyPanel.setBackground(new java.awt.Color(226, 165, 92));

        MenuPanel.setBackground(new java.awt.Color(204, 182, 140));
        MenuPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        MenuPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_buku.setBackground(new java.awt.Color(243, 243, 110));
        btn_buku.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_buku.setText("DAFTAR BUKU");
        btn_buku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bukuActionPerformed(evt);
            }
        });
        MenuPanel.add(btn_buku, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 210, 40));

        btn_user.setBackground(new java.awt.Color(243, 243, 110));
        btn_user.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_user.setText("DATA AKUN");
        btn_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_userActionPerformed(evt);
            }
        });
        MenuPanel.add(btn_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 210, 40));

        btn_transaksi.setBackground(new java.awt.Color(243, 243, 110));
        btn_transaksi.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_transaksi.setText("DATA PEMINJAMAN");
        btn_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transaksiActionPerformed(evt);
            }
        });
        MenuPanel.add(btn_transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 210, 40));

        btn_logout.setBackground(new java.awt.Color(255, 51, 51));
        btn_logout.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_logout.setText("LOGOUT");
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });
        MenuPanel.add(btn_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 870, 210, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menu/logoadm.png"))); // NOI18N
        MenuPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        detail_pinjam.setBackground(new java.awt.Color(243, 243, 110));
        detail_pinjam.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        detail_pinjam.setText("BUKU DIPINJAM");
        detail_pinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detail_pinjamActionPerformed(evt);
            }
        });
        MenuPanel.add(detail_pinjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 210, 40));

        MainPanel.setBackground(new java.awt.Color(226, 165, 92));
        MainPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        MainPanel.setPreferredSize(new java.awt.Dimension(568, 464));
        MainPanel.setLayout(new java.awt.CardLayout());

        Akun.setBackground(new java.awt.Color(251, 232, 183));
        Akun.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel15.setText("DATA AKUN");
        Akun.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("EMAIL");
        Akun.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));

        txt_email2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_email2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_email2ActionPerformed(evt);
            }
        });
        txt_email2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_email2KeyReleased(evt);
            }
        });
        Akun.add(txt_email2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 203, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("NAMA ");
        Akun.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("PASSWORD  ");
        Akun.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, -1, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("ALAMAT");
        Akun.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, -1, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("NO HP  ");
        Akun.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, -1, -1));

        txt_pass.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passActionPerformed(evt);
            }
        });
        Akun.add(txt_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 203, -1));

        txt_nama.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namaActionPerformed(evt);
            }
        });
        Akun.add(txt_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 203, -1));

        txt_nohp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_nohp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nohpActionPerformed(evt);
            }
        });
        Akun.add(txt_nohp, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 230, 230, -1));

        btn_update.setBackground(new java.awt.Color(204, 153, 0));
        btn_update.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_update.setForeground(new java.awt.Color(255, 255, 255));
        btn_update.setText("UPDATE");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        Akun.add(btn_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 360, 150, 40));

        btn_hapus2.setBackground(new java.awt.Color(255, 0, 0));
        btn_hapus2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_hapus2.setForeground(new java.awt.Color(255, 255, 255));
        btn_hapus2.setText("HAPUS");
        btn_hapus2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapus2ActionPerformed(evt);
            }
        });
        Akun.add(btn_hapus2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 360, 150, 40));

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table2.setSelectionForeground(new java.awt.Color(102, 102, 102));
        table2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table2MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(table2);

        Akun.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 1050, 430));

        btn_simpan2.setBackground(new java.awt.Color(0, 153, 153));
        btn_simpan2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_simpan2.setForeground(new java.awt.Color(255, 255, 255));
        btn_simpan2.setText("SIMPAN");
        btn_simpan2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpan2ActionPerformed(evt);
            }
        });
        Akun.add(btn_simpan2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, 150, 40));

        txt_alamat.setColumns(20);
        txt_alamat.setRows(5);
        jScrollPane5.setViewportView(txt_alamat);

        Akun.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 110, -1, -1));

        clear.setBackground(new java.awt.Color(204, 153, 0));
        clear.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        clear.setForeground(new java.awt.Color(255, 255, 255));
        clear.setText("CLEAR");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        Akun.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 360, 150, 40));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu baru/Rectangle 33 (2).png"))); // NOI18N
        jLabel22.setText("jLabel22");
        Akun.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1030, 390));

        MainPanel.add(Akun, "card5");

        buku_dipinjam.setBackground(new java.awt.Color(251, 232, 183));
        buku_dipinjam.setPreferredSize(new java.awt.Dimension(584, 428));
        buku_dipinjam.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        jLabel12.setText("DAFTAR BUKU YANG DIPINJAM");
        buku_dipinjam.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("ID BUKU");
        buku_dipinjam.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("HARGA TOTAL");
        buku_dipinjam.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, -1));

        table4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table4MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(table4);

        buku_dipinjam.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 1050, 420));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("KEMBALI");
        buku_dipinjam.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, -1));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("QTY");
        buku_dipinjam.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 100, -1, -1));

        update1.setBackground(new java.awt.Color(204, 153, 0));
        update1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        update1.setForeground(new java.awt.Color(255, 255, 255));
        update1.setText("CLEAR");
        update1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update1ActionPerformed(evt);
            }
        });
        buku_dipinjam.add(update1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 370, 130, 40));
        buku_dipinjam.add(qtyy, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 100, 200, 28));
        buku_dipinjam.add(txt_idbk4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 200, 28));
        buku_dipinjam.add(tott, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, 200, 28));

        tgl_kembali1.setDateFormatString("yyyy-MM-dd");
        tgl_kembali1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tgl_kembali1PropertyChange(evt);
            }
        });
        buku_dipinjam.add(tgl_kembali1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 200, 28));

        hapus1.setBackground(new java.awt.Color(255, 0, 0));
        hapus1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        hapus1.setForeground(new java.awt.Color(255, 255, 255));
        hapus1.setText("HAPUS");
        hapus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapus1ActionPerformed(evt);
            }
        });
        buku_dipinjam.add(hapus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 370, 130, 40));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("ID TRANSAKSI");
        buku_dipinjam.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        txtID1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtID1KeyReleased(evt);
            }
        });
        buku_dipinjam.add(txtID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 200, 28));

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu baru/Rectangle 33 (2).png"))); // NOI18N
        jLabel35.setText("jLabel22");
        buku_dipinjam.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1030, 390));

        tanggal_now1.setForeground(new java.awt.Color(255, 255, 255));
        tanggal_now1.setDateFormatString("yyyy-MM-dd");
        tanggal_now1.setEnabled(false);
        tanggal_now1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tanggal_now1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tanggal_now1PropertyChange(evt);
            }
        });
        buku_dipinjam.add(tanggal_now1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 20, 160, -1));

        MainPanel.add(buku_dipinjam, "card4");

        Peminjaman.setBackground(new java.awt.Color(251, 232, 183));
        Peminjaman.setPreferredSize(new java.awt.Dimension(584, 428));
        Peminjaman.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        jLabel10.setText("DATA PEMINJAMAN");
        Peminjaman.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("EMAIL ");
        Peminjaman.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("TGL PEMINJAMAN ");
        Peminjaman.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, -1));

        table3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table3);

        Peminjaman.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 1050, 420));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("TGL KEMBALI");
        Peminjaman.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, -1, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("DENDA");
        Peminjaman.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, -1, -1));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("QTY");
        Peminjaman.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("HARGA TOTAL");
        Peminjaman.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 200, -1, -1));
        Peminjaman.add(tot, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 200, 200, 28));

        denda.setEditable(false);
        denda.setForeground(new java.awt.Color(102, 102, 102));
        denda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dendaActionPerformed(evt);
            }
        });
        Peminjaman.add(denda, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 150, 200, 28));
        Peminjaman.add(txt_email3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 200, 28));
        Peminjaman.add(qty, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 200, 28));

        tgl_pinjam.setDateFormatString("yyyy-MM-dd");
        tgl_pinjam.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tgl_pinjamPropertyChange(evt);
            }
        });
        Peminjaman.add(tgl_pinjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, 200, 28));

        tgl_kembali.setDateFormatString("yyyy-MM-dd");
        tgl_kembali.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tgl_kembaliPropertyChange(evt);
            }
        });
        Peminjaman.add(tgl_kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 100, 200, 28));

        update.setBackground(new java.awt.Color(204, 153, 0));
        update.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setText("CLEAR");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        Peminjaman.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 370, 130, 40));

        hapus.setBackground(new java.awt.Color(255, 0, 0));
        hapus.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        hapus.setForeground(new java.awt.Color(255, 255, 255));
        hapus.setText("HAPUS");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });
        Peminjaman.add(hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 370, 130, 40));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setText("CEK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        Peminjaman.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 100, -1, -1));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("ID TRANSAKSI");
        Peminjaman.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        txtID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIDKeyReleased(evt);
            }
        });
        Peminjaman.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 200, 28));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu baru/Rectangle 33 (2).png"))); // NOI18N
        jLabel23.setText("jLabel22");
        Peminjaman.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1030, 390));

        tanggal_now.setForeground(new java.awt.Color(255, 255, 255));
        tanggal_now.setDateFormatString("yyyy-MM-dd");
        tanggal_now.setEnabled(false);
        tanggal_now.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tanggal_now.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tanggal_nowPropertyChange(evt);
            }
        });
        Peminjaman.add(tanggal_now, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 20, 160, -1));

        MainPanel.add(Peminjaman, "card4");

        buku.setBackground(new java.awt.Color(251, 232, 183));
        buku.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("DAFTAR BUKU");
        buku.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ID BUKU");
        buku.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        txt_id.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });
        txt_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_idKeyReleased(evt);
            }
        });
        buku.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 290, -1));

        txt_judul.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_judul.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_judulKeyReleased(evt);
            }
        });
        buku.add(txt_judul, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 290, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("JUDUL BUKU");
        buku.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("TAHUN TERBIT");
        buku.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("SINOPSIS");
        buku.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        txt_sinopsis.setColumns(20);
        txt_sinopsis.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_sinopsis.setLineWrap(true);
        txt_sinopsis.setRows(5);
        jScrollPane2.setViewportView(txt_sinopsis);

        buku.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 290, 120));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("JENIS BUKU");
        buku.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        cmb_jenis.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cmb_jenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "artikel", "dongeng", "komik", "koran", "novel" }));
        cmb_jenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_jenisActionPerformed(evt);
            }
        });
        buku.add(cmb_jenis, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 290, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("STOK");
        buku.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, -1, -1));

        txt_harga.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_harga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hargaActionPerformed(evt);
            }
        });
        buku.add(txt_harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 440, 150, -1));

        btn_simpan.setBackground(new java.awt.Color(141, 196, 167));
        btn_simpan.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_simpan.setForeground(new java.awt.Color(255, 255, 255));
        btn_simpan.setText("SIMPAN");
        btn_simpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_simpanMouseClicked(evt);
            }
        });
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });
        buku.add(btn_simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 90, 150, 40));

        btn_hapus.setBackground(new java.awt.Color(227, 74, 56));
        btn_hapus.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_hapus.setForeground(new java.awt.Color(255, 255, 255));
        btn_hapus.setText("HAPUS");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        buku.add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 150, 150, 40));

        btn_clear.setBackground(new java.awt.Color(204, 153, 0));
        btn_clear.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_clear.setForeground(new java.awt.Color(255, 255, 255));
        btn_clear.setText("CLEAR");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });
        buku.add(btn_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 210, 150, 40));

        upload_gmb.setBackground(new java.awt.Color(204, 153, 0));
        upload_gmb.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        upload_gmb.setForeground(new java.awt.Color(255, 255, 255));
        upload_gmb.setText("UPLOAD");
        upload_gmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upload_gmbActionPerformed(evt);
            }
        });
        buku.add(upload_gmb, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 270, 150, 40));

        jButton1.setBackground(new java.awt.Color(204, 153, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("UPDATE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        buku.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 330, 150, 40));

        labelfoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelfoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelfotoMouseClicked(evt);
            }
        });
        buku.add(labelfoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, 217, 250));

        table.setAutoCreateRowSorter(true);
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        buku.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 1070, 340));

        txtStok.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        buku.add(txtStok, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 490, 80, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("HARGA SEWA");
        buku.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, -1, -1));

        thnterbit.setDateFormatString("yyyy-MM-dd");
        buku.add(thnterbit, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 290, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu baru/dsbgdetailbuku.png"))); // NOI18N
        buku.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 840, -1));

        MainPanel.add(buku, "card2");

        javax.swing.GroupLayout BodyPanelLayout = new javax.swing.GroupLayout(BodyPanel);
        BodyPanel.setLayout(BodyPanelLayout);
        BodyPanelLayout.setHorizontalGroup(
            BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BodyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1072, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BodyPanelLayout.setVerticalGroup(
            BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BodyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BodyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_bukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bukuActionPerformed
        // TODO add your handling code here:
        MainPanel.removeAll();
        MainPanel.repaint();
        MainPanel.revalidate();
        
        MainPanel.add(buku);
        MainPanel.repaint();
        MainPanel.revalidate();
    }//GEN-LAST:event_btn_bukuActionPerformed

    private void btn_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_userActionPerformed
        // TODO add your handling code here:
        MainPanel.removeAll();
        MainPanel.repaint();
        MainPanel.revalidate();
        
        MainPanel.add(Akun);
        MainPanel.repaint();
        MainPanel.revalidate();
    }//GEN-LAST:event_btn_userActionPerformed

    private void btn_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transaksiActionPerformed
        // TODO add your handling code here:
        MainPanel.removeAll();
        MainPanel.repaint();
        MainPanel.revalidate();
        
        MainPanel.add(Peminjaman);
        MainPanel.repaint();
        MainPanel.revalidate();
    }//GEN-LAST:event_btn_transaksiActionPerformed

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new Login_Admin().setVisible(true);
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void txt_email2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_email2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_email2ActionPerformed

    private void txt_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passActionPerformed

    private void txt_namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namaActionPerformed

    private void txt_nohpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nohpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nohpActionPerformed

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_idActionPerformed

    private void cmb_jenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_jenisActionPerformed
        // TODO add your handling code here:
        ID();
    }//GEN-LAST:event_cmb_jenisActionPerformed

    private void txt_hargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hargaActionPerformed

    private void btn_simpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_simpanMouseClicked

    }//GEN-LAST:event_btn_simpanMouseClicked

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        try {
            String tampilan = "yyyy-MM-dd";
            SimpleDateFormat fm = new SimpleDateFormat(tampilan);
            String tanggal = String.valueOf(fm.format(thnterbit.getDate()));
            String id = txt_id.getText();
            String jdl = txt_judul.getText();
            String jns = (String) cmb_jenis.getSelectedItem();
            String snp = txt_sinopsis.getText();
            String hrg = txt_harga.getText();
            String stok = txtStok.getText();
            String sql = "INSERT INTO detail_buku (id_buku, gambar, judul_buku, tahun_terbit, jenis, sinopsis, harga_satuan, stok) VALUES (?,?,?,?,?,?,?,?);";
            java.sql.Connection conn =(Connection)Koneksi.getkoneksi();
            java.sql.PreparedStatement ps=conn.prepareStatement(sql);
            InputStream is = new FileInputStream(new File(s));
            ps.setString(1, id);
            ps.setBlob(2,is);
            ps.setString(3, jdl);
            ps.setString(4, tanggal);
            ps.setString(5, jns);
            ps.setString(6, snp);
            ps.setString(7, hrg);
            ps.setString(8, stok);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            kosong();
        } catch (Exception t) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan");
        }
        datatable();
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        int ok=JOptionPane.showConfirmDialog(null,"Apakah Yakin Anda Menghapus Record ini???","Confirmation",JOptionPane.YES_NO_OPTION);
        String id = txt_id.getText();
        if(ok==0){
            try {
                Statement statement=(Statement)Koneksi.getkoneksi().createStatement();
                statement.executeUpdate("DELETE from detail_buku WHERE detail_buku.id_buku=('"+id+"');");
                JOptionPane.showMessageDialog(null, "Data berhasil di HAPUS");
                kosong();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data gagal di HAPUS");
            }
            datatable();
        }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        // TODO add your handling code here:
        kosong();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void upload_gmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upload_gmbActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png");
        fileChooser.addChoosableFileFilter(filter);
        int result = fileChooser.showSaveDialog(null);
        if(result == JFileChooser.APPROVE_OPTION){
            File selectedFile = fileChooser.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            labelfoto.setIcon(ResizeImage(path));
            s = path;
        }
        else if(result == JFileChooser.CANCEL_OPTION){
            System.out.println("No Data");
        }

    }//GEN-LAST:event_upload_gmbActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int ok=JOptionPane.showConfirmDialog(null,"Apakah Yakin Untuk Update Record ini???","Confirmation",JOptionPane.YES_NO_OPTION);
        String tampilan = "yyyy-MM-dd";
            SimpleDateFormat fm = new SimpleDateFormat(tampilan);
            String tanggal = String.valueOf(fm.format(thnterbit.getDate()));
        try
        {
            String sql="update detail_buku set judul_buku=?, tahun_terbit=?, sinopsis=?, harga_satuan=? , stok=?where id_buku = '"+txt_id.getText()+"';";
            java.sql.Connection conn=(Connection)Koneksi.getkoneksi();
            PreparedStatement st=conn.prepareStatement(sql);
            if(ok==0)
            {
                try
                {
                    st.setString(1, txt_judul.getText());
                    st.setString(2, tanggal);
                    st.setString(3, txt_sinopsis.getText());
                    st.setString(4, txt_harga.getText());
                    st.setString(5, txtStok.getText());

                    st.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Update Data Sukses");

                }catch (Exception e)
                {
                    JOptionPane.showMessageDialog(null, "Update Data Gagal");
                }
                datatable();
            }
        }catch (Exception e){}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void labelfotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelfotoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_labelfotoMouseClicked

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        
        int a = table.rowAtPoint(evt.getPoint());

        String user = table.getValueAt(a, 0).toString();
        txt_id.setText(user);

        String judul = table.getValueAt(a, 1).toString();
        txt_judul.setText(judul);

        String Tahun = table.getModel().getValueAt(a, 2).toString();
        try{
        SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd"); 
        Date d=f.parse(Tahun);
        thnterbit.setDate(d);
        }catch(Exception ex){
        ex.printStackTrace();
        }

        String snp = table.getValueAt(a, 4).toString();
        txt_sinopsis.setText(snp);

        String hrg = table.getValueAt(a, 5).toString();
        txt_harga.setText(hrg);
        
        String stk = table.getValueAt(a, 6).toString();
        txtStok.setText(stk);

        try{
            int row = table.getSelectedRow();
            String nama = (String) table.getValueAt(row, 0);
            java.sql.Statement statement = (java.sql.Statement)Koneksi.getkoneksi().createStatement();
            ResultSet res = statement.executeQuery("select * from detail_buku where id_buku = '"+ nama +"';");
            while (res.next()) {
                Blob gambar = (com.mysql.jdbc.Blob) res.getBlob("gambar");
                int ukuran = (int) (gambar.length());
                ImageIcon tampilkan = new ImageIcon(gambar.getBytes(1, ukuran));
                labelfoto.setIcon(tampilkan);
            }
        } catch (SQLException ex){
            Logger.getLogger(MenuAdmin1.gambar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tableMouseClicked

    private void table2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table2MouseClicked
        // TODO add your handling code here:
        int a = table2.rowAtPoint(evt.getPoint());
        String eml = table2.getValueAt(a, 0).toString();
        txt_email2.setText(eml);
        
        String nm = table2.getValueAt(a, 1).toString();
        txt_nama.setText(nm);
        
        String pass = table2.getValueAt(a, 3).toString();
        txt_pass.setText(pass);
        
        String alm = table2.getValueAt(a, 2).toString();
        txt_alamat.setText(alm);
        
        String no = table2.getValueAt(a, 4).toString();
        txt_nohp.setText(no);
        
    }//GEN-LAST:event_table2MouseClicked

    private void btn_simpan2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpan2ActionPerformed
        // TODO add your handling code here:
        try{
            String sql ="INSERT INTO peminjam (email, nama, password, alamat, noHP) VALUES ('"+txt_email2.getText()
                    +"','"+txt_nama.getText()+"','"+txt_pass.getText()+"', '"+txt_alamat.getText()+"', '"+txt_nohp.getText()+"')";
            java.sql.Connection conn =(Connection)Koneksi.getkoneksi();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
            }catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Data Tidak berhasil Disimpan");
        }
        datatable1();
    }//GEN-LAST:event_btn_simpan2ActionPerformed

    private void btn_hapus2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapus2ActionPerformed
        // TODO add your handling code here:
        int ok=JOptionPane.showConfirmDialog(null,"Apakah Yakin Anda Menghapus Data ini???","Confirmation",JOptionPane.YES_NO_OPTION);
        String id = txt_email2.getText();
        if(ok==0){
            try {
                Statement statement=(Statement)Koneksi.getkoneksi().createStatement();
                statement.executeUpdate("DELETE from peminjam WHERE email= '"+id+"';");
                JOptionPane.showMessageDialog(null, "Data berhasil di HAPUS");
                txt_email2.setText("");
                txt_nama.setText("");
                txt_pass.setText("");
                txt_alamat.setText("");
                txt_nohp.setText("");
                } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data gagal di HAPUS");
            }
            datatable1();
        }
    }//GEN-LAST:event_btn_hapus2ActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
         int ok=JOptionPane.showConfirmDialog(null,"Apakah Yakin Untuk Update Record ini???","Confirmation",JOptionPane.YES_NO_OPTION);
        try
        {
            String sql="update peminjam set nama=?, password=?, alamat=?, noHP=? where email = '"+txt_email2.getText()+"';";
            java.sql.Connection conn=(Connection)Koneksi.getkoneksi();
            PreparedStatement st=conn.prepareStatement(sql);
            if(ok==0)
            {
                try
                {
                    st.setString(1, txt_nama.getText());
                    st.setString(2, txt_pass.getText());
                    st.setString(3, txt_alamat.getText());
                    st.setString(4, txt_nohp.getText());
                    
                    st.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Update Data Sukses");

                }catch (Exception e)
                { JOptionPane.showMessageDialog(null, "Update Data Gagal");
                }
               
            }
        }catch (Exception e){}
         datatable1();
    }//GEN-LAST:event_btn_updateActionPerformed

    private void table3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table3MouseClicked
        // TODO add your handling code here:
        int row = table3.rowAtPoint(evt.getPoint());
        String ml = table3.getValueAt(row, 3).toString();
        txt_email3.setText(ml);
        
        
        
        String qlt = table3.getValueAt(row, 5).toString();
        qty.setText(qlt);
        
        
        
        String tgl_pmn = table3.getValueAt(row, 1).toString();
        try{
        SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd"); 
        Date d=f.parse(tgl_pmn);
        tgl_pinjam.setDate(d);
        }catch(Exception ex){
        ex.printStackTrace();
        }
        
        String tgl_kem = table3.getValueAt(row, 2).toString();
        try{
        SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd"); 
        Date d=f.parse(tgl_kem);
        tgl_kembali.setDate(d);
        }catch(Exception ex){
        ex.printStackTrace();
        }
        
        String ttl = table3.getValueAt(row, 4).toString();
        tot.setText(ttl);
        
        String id = table3.getValueAt(row, 0).toString();
        txtID.setText(id);
    }//GEN-LAST:event_table3MouseClicked

    private void tgl_pinjamPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tgl_pinjamPropertyChange
        // TODO add your handling code here
      
    }//GEN-LAST:event_tgl_pinjamPropertyChange

    private void tgl_kembaliPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tgl_kembaliPropertyChange
        // TODO add your handling code here:
        if (tgl_kembali.getDate() != null) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            kembali2 = format.format(tgl_kembali.getDate());
        }
        if (pinjam2 != null && kembali2 != null) {
            getTot();
        }
    }//GEN-LAST:event_tgl_kembaliPropertyChange

    private void dendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dendaActionPerformed

    private void tanggal_nowPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tanggal_nowPropertyChange
        // TODO add your handling code here:
        if (tanggal_now.getDate() != null) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            pinjam2 = format.format(tanggal_now.getDate());
        }
        if (pinjam2 != null && kembali2 != null) {
            getTot();
        }
    }//GEN-LAST:event_tanggal_nowPropertyChange

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        denda.setText(Integer.toString(hitung));
        getTot();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
        txtID.setText("");
        txt_email3.setText("");
        qty.setText("");
        Date dt = null;
        tgl_pinjam.setDate(dt);
        tgl_kembali.setDate(dt);
        denda.setText("");
        tot.setText("");
        datatable2();
    }//GEN-LAST:event_updateActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
        int ok=JOptionPane.showConfirmDialog(null,"Apakah Yakin Anda Menghapus Data ini???","Confirmation",JOptionPane.YES_NO_OPTION);
        String id = txtID.getText();
        if(ok==0){
            try {
                Statement statement=(Statement)Koneksi.getkoneksi().createStatement();
                statement.executeUpdate("DELETE from detail_peminjaman WHERE id_detail= '"+id+"';");
                JOptionPane.showMessageDialog(null, "Data berhasil di HAPUS");
                txtID.setText("");
                txt_email3.setText("");
                qty.setText("");
                Date dt = null;
                tgl_pinjam.setDate(dt);
                tgl_kembali.setDate(dt);
                denda.setText("");
                tot.setText("");
                } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data gagal di HAPUS");
            }
            datatable2();
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
                txt_email2.setText("");
                txt_nama.setText("");
                txt_pass.setText("");
                txt_alamat.setText("");
                txt_nohp.setText("");
                datatable1();
    }//GEN-LAST:event_clearActionPerformed

    private void table4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table4MouseClicked
        // TODO add your handling code here:
        int row = table4.rowAtPoint(evt.getPoint());
        String idt = table4.getValueAt(row, 0).toString();
        txtID1.setText(idt);
        
        String idb = table4.getValueAt(row, 1).toString();
        txt_idbk4.setText(idb);
        
        String kmb = table4.getValueAt(row, 2).toString();
        try{
        SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd"); 
        Date d=f.parse(kmb);
        tgl_kembali1.setDate(d);
        }catch(Exception ex){
        ex.printStackTrace();
        }
        
        String hrgt = table4.getValueAt(row, 3).toString();
        tott.setText(hrgt);
        
        String qty = table4.getValueAt(row, 4).toString();
        qtyy.setText(qty);
    }//GEN-LAST:event_table4MouseClicked

    private void tgl_kembali1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tgl_kembali1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_tgl_kembali1PropertyChange

    private void hapus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapus1ActionPerformed
        // TODO add your handling code here:
        int ok=JOptionPane.showConfirmDialog(null,"Apakah Yakin Anda Menghapus Data ini???","Confirmation",JOptionPane.YES_NO_OPTION);
        String id = txtID1.getText();
        if(ok==0){
            try {
                Statement statement=(Statement)Koneksi.getkoneksi().createStatement();
                statement.executeUpdate("DELETE from log_peminjam WHERE id_transaksi= '"+id+"';");
                JOptionPane.showMessageDialog(null, "Data berhasil di HAPUS");
                txtID1.setText("");
                txt_idbk4.setText("");
                tgl_kembali1.setDate(null);
                tott.setText("");
                qtyy.setText("");
                datatatble3();
                } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data gagal di HAPUS");
            }
            
        }
    }//GEN-LAST:event_hapus1ActionPerformed

    private void tanggal_now1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tanggal_now1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_tanggal_now1PropertyChange

    private void detail_pinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detail_pinjamActionPerformed
        // TODO add your handling code here:
        MainPanel.removeAll();
        MainPanel.repaint();
        MainPanel.revalidate();
        
        MainPanel.add(buku_dipinjam);
        MainPanel.repaint();
        MainPanel.revalidate();
    }//GEN-LAST:event_detail_pinjamActionPerformed

    private void txtID1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtID1KeyReleased
        
         DefaultTableModel bl = new DefaultTableModel();
            bl.addColumn("ID TRANSAKSI");
            bl.addColumn("ID BUKU");
            bl.addColumn("KEMBALI");
            bl.addColumn("TOTAL");
            bl.addColumn("QTY");
             table4.setModel(bl);

        try {
           Statement stm = (Statement) Koneksi.getkoneksi().createStatement();
           ResultSet rs = stm.executeQuery("SELECT * FROM log_peminjam WHERE Id_transaksi LIKE '%"+txtID1.getText()+"%';");
             while(rs.next()){
                 bl.addRow(new Object[] {
                 rs.getString("Id_transaksi"),
                 rs.getString("id_buku"),
                 rs.getString("kembali"),
                 rs.getString("total"),
                 rs.getString("qty")
                 });
             }
        } catch (SQLException ex) {
            Logger.getLogger(MenuAdmin1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtID1KeyReleased

    private void update1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update1ActionPerformed
        // TODO add your handling code here:
                txtID1.setText("");
                txt_idbk4.setText("");
                tgl_kembali1.setDate(null);
                tott.setText("");
                qtyy.setText("");
                datatatble3();
    }//GEN-LAST:event_update1ActionPerformed

    private void txt_email2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_email2KeyReleased
        // TODO add your handling code here:
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("EMAIL");
        tbl.addColumn("NAMA");
        tbl.addColumn("ALAMAT");
        tbl.addColumn("PASSWORD");
        tbl.addColumn("NOHP");
        table2.setModel(tbl);
        try {
             Statement statement =(Statement)Koneksi.getkoneksi().createStatement();
            ResultSet res=statement.executeQuery("SELECT * from peminjam where email LIKE '%"+txt_email2.getText()+"%'");
            while(res.next())
            {        
             tbl.addRow(new Object[]{
                res.getString("email"),
                res.getString("nama"),
                res.getString("alamat"),
                res.getString("password"),
                res.getString("noHP")
            });
            table2.setModel(tbl);
            }
        } catch (Exception e) {
         }
    }//GEN-LAST:event_txt_email2KeyReleased

    private void txtIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyReleased
        // TODO add your handling code here:
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("ID Transaksi");
        tbl.addColumn("TGL PINJAM");
        tbl.addColumn("KEMBALI");
        tbl.addColumn("EMAIL");
        tbl.addColumn("HARGA TOTAL");
        tbl.addColumn("qty");
        
        table3.setModel(tbl);
        try {
             Statement statement =(Statement)Koneksi.getkoneksi().createStatement();
            ResultSet res=statement.executeQuery("select * from detail_peminjaman where Id_transaksi LIKE '%"+txtID.getText()+"%' ");
            while(res.next())
            {        
             tbl.addRow(new Object[]{
                res.getString("Id_transaksi"),
                res.getString("tgl_pinjam"),
                res.getString("kembali"),
                res.getString("email"),
                res.getString("hrg_total"),
                res.getString("banyak_pinjam"),
                });
            table3.setModel(tbl);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtIDKeyReleased

    private void txt_idKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_idKeyReleased
        tb();        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idKeyReleased

    private void txt_judulKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_judulKeyReleased
        tb();        // TODO add your handling code here:
    }//GEN-LAST:event_txt_judulKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuAdmin1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Akun;
    private javax.swing.JPanel BodyPanel;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPanel MenuPanel;
    private javax.swing.JPanel Peminjaman;
    private javax.swing.JButton btn_buku;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_hapus2;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btn_simpan2;
    private javax.swing.JButton btn_transaksi;
    private javax.swing.JButton btn_update;
    private javax.swing.JButton btn_user;
    private javax.swing.JPanel buku;
    private javax.swing.JPanel buku_dipinjam;
    private javax.swing.JButton clear;
    private javax.swing.JComboBox<String> cmb_jenis;
    public static final javax.swing.JTextField denda = new javax.swing.JTextField();
    private javax.swing.JButton detail_pinjam;
    private javax.swing.JButton hapus;
    private javax.swing.JButton hapus1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel labelfoto;
    public static final javax.swing.JTextField qty = new javax.swing.JTextField();
    public static final javax.swing.JTextField qtyy = new javax.swing.JTextField();
    private javax.swing.JTable table;
    private javax.swing.JTable table2;
    private javax.swing.JTable table3;
    private javax.swing.JTable table4;
    private com.toedter.calendar.JDateChooser tanggal_now;
    private com.toedter.calendar.JDateChooser tanggal_now1;
    private com.toedter.calendar.JDateChooser tgl_kembali;
    private com.toedter.calendar.JDateChooser tgl_kembali1;
    private com.toedter.calendar.JDateChooser tgl_pinjam;
    private com.toedter.calendar.JDateChooser thnterbit;
    public static final javax.swing.JTextField tot = new javax.swing.JTextField();
    public static final javax.swing.JTextField tott = new javax.swing.JTextField();
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtID1;
    private javax.swing.JTextField txtStok;
    private javax.swing.JTextArea txt_alamat;
    private javax.swing.JTextField txt_email2;
    public static final javax.swing.JTextField txt_email3 = new javax.swing.JTextField();
    private javax.swing.JTextField txt_harga;
    private javax.swing.JTextField txt_id;
    public static final javax.swing.JTextField txt_idbk4 = new javax.swing.JTextField();
    private javax.swing.JTextField txt_judul;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_nohp;
    private javax.swing.JTextField txt_pass;
    private javax.swing.JTextArea txt_sinopsis;
    private javax.swing.JButton update;
    private javax.swing.JButton update1;
    private javax.swing.JButton upload_gmb;
    // End of variables declaration//GEN-END:variables
private void ID (){
    cmb_id = (String) cmb_jenis.getSelectedItem();
    if ("artikel".equals(cmb_id)) {
     id_buku= "D";
      } else if ("dongeng".equals(cmb_id)) {
     id_buku = "A";
      } else if ("koran".equals(cmb_id)) {
     id_buku = "K";
      } else if("novel".equals(cmb_id)){
       id_buku = "B";
      }else if("komik".equals(cmb_id)){
          id_buku = "C";
      }
txt_id.setText(id_buku);

        try{
                Statement state=(Statement)Koneksi.getkoneksi().createStatement();
		String sql = "select max(right(id_buku,4)) as no_terakhir from detail_buku where id_buku Like '%"+id_buku+"%'";
		ResultSet rs = state.executeQuery(sql);
		if(rs.first()==false){
                    txt_id.setText(id_buku);
		}
		else{
			rs.last();
			int no=rs.getInt(1)+1;
			String cno=String.valueOf(no);
			int pjg_cno=cno.length();
			for(int i=0;i<2 - pjg_cno; i++);
			{
				cno="000"+cno;
			}
			txt_id.setText(id_buku+cno);
                        
		}
                    
		rs.close();
    }
		catch(Exception ex){
			
		}
	
    }
    
       
    private void kosong (){
    Date date = null;
    txt_id.setText(null);
    txt_judul.setText(null);
    thnterbit.setDate(date);
    txt_sinopsis.setText(null);
    cmb_jenis.setSelectedItem("artikel");
    txt_harga.setText(null);
    labelfoto.setIcon(null);
    txtStok.setText(null);
    datatable();
    }

    private Icon ResizeImage(String path) {
       ImageIcon MyImage = new ImageIcon(path);
        Image img = MyImage.getImage();
        Image newImage = img.getScaledInstance(labelfoto.getWidth(), labelfoto.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }

     private static class gambar {

        public gambar() {
        }
    }
     
     private void getTot(){
       try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date tglpinjam = format.parse(pinjam2);
            Date tglkemabli = format.parse(kembali2);
            long tglpinjam1 = tglpinjam.getTime();
            long tglkembali1 = tglkemabli.getTime();
            long diff = tglpinjam1 - tglkembali1;
            long lamatgl = diff / (24 * 60 * 60 * 1000);
            String lg = (Long.toString(lamatgl)+ "");
            int gl = Integer.parseInt(lg);
            int dnd = 2000;
            hitung = dnd * gl;
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
            
}

}
     


