package Rental;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static Rental.Hasil_Pinjam.struksewa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author acer
 */
public class Peminjaman extends javax.swing.JFrame {

    public Statement st;
    public ResultSet rs;
    public DefaultTableModel tabmodel;
    String pinjam1 = null;
    String kembali = null;

    /**
     * Creates new form
     */
    public Peminjaman() {
        initComponents();
        getTot();
        tgl();
        trs();
        tampiltmp();
        judul();
        reset();
        tambah();
    }

    private void tampiltmp() {
        try {
            java.sql.Connection cn = (Connection) Koneksi.getkoneksi();
            st = cn.createStatement();
            tabmodel.getDataVector().removeAllElements();
            tabmodel.fireTableDataChanged();
            rs = st.executeQuery("select * from detail_keranjang");
            while (rs.next()) {
                Object[] data = {
                    rs.getString("id_buku"),
                    rs.getString("tgl_pinjam"),
                    rs.getString("kembali"),
                    rs.getString("harga_total"),
                    rs.getString("qty")
                };
                tabmodel.addRow(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void judul() {
        Object[] judul = {"Id Buku", "tanggal pinjam", "tanggal kembali", "lama pinjam", "harga total", "qty"};
        tabmodel = new DefaultTableModel(null, judul);
        keranjang.setModel(tabmodel);
    }

    private void reset() {
        txt_idbukupmn.setText("");
        jumlah.setText("");
        tgl_kembali.setDate(null);
        lama.setText("");
        txt_tot.setText("");
    }

    public void tgl() {
        Date ys = new Date();
        tgl_pinjam.setDate(ys);
    }

    public void kosong() {
        DefaultTableModel model = (DefaultTableModel) keranjang.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }

    public void tambah() {
        try {
            int total = 0;
            java.sql.Connection cn = (Connection) Koneksi.getkoneksi();
            st = cn.createStatement();
            rs = st.executeQuery("select sum(harga_total) AS d from detail_keranjang;");
            while (rs.next()) {
                total = total + Integer.parseInt(rs.getString("d"));
             }
            this.HargaTotal.setText("" + total);
        } catch (SQLException ex) {
            Logger.getLogger(Peminjaman.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void struk() {
        String IDT = txt_IDT.getText();
        String ml = txt_emailpmn1.getText();
        String hrgt = HargaTotal.getText();
        
        tabmodel = (DefaultTableModel) keranjang.getModel();
        
        struksewa.setText(struksewa.getText() + "-----------------------------------------------------------------------------------------------------------------------" + "\n");
        struksewa.setText(struksewa.getText() + "\t" + "\t" + "              My BOOk" + "\n");
        struksewa.setText(struksewa.getText() + "\t" + "\t" + "        Perpustakaan Online" + "\n");
        struksewa.setText(struksewa.getText() + "\t" + "\t" + "Jl. Nasional III, Sumberbaru, Jember" + "\n");
        struksewa.setText(struksewa.getText() + "***********************************************************************************************************************" + "\n");
        struksewa.setText(struksewa.getText() + "\n");
        struksewa.setText(struksewa.getText() + "ID TRANSAKSI :" + IDT + "\n");
        struksewa.setText(struksewa.getText() + "Email :" + ml + "\n");
        struksewa.setText(struksewa.getText() + "***********************************************************************************************************************" + "\n");
        struksewa.setText(struksewa.getText() + "ID BUKU" +"\t" + "Pinjam" + "\t"+ "Kembali" +"\t" + "Jumlah" + "\t" + "Lama" + "\t" + "Total" +"\n");
        
        for (int i = 0; i < tabmodel.getRowCount(); i++) {
            String bk = (String) tabmodel.getValueAt(i, 0);
            String gl = (String) tabmodel.getValueAt(i, 1);
            String jm = (String) tabmodel.getValueAt(i, 5);
            String lp = (String) tabmodel.getValueAt(i, 3);
            String km = (String) tabmodel.getValueAt(i, 2);
            String hgt = (String) tabmodel.getValueAt(i, 4);
        struksewa.setText(struksewa.getText() + bk + "\t" + gl + "\t" + km + "\t" + jm + "\t" + lp + "\t" + hgt + "\n");    
        }
        struksewa.setText(struksewa.getText() + "-----------------------------------------------------------------------------------------------------------------------" + "\n");
        struksewa.setText(struksewa.getText() + "\n");
        struksewa.setText(struksewa.getText() + "\t"+"\t"+"\t"+"HARGA TOTAL :" + hrgt + "\n" + "\n");
        struksewa.setText(struksewa.getText() + "-----------------------------------------------------------------------------------------------------------------------" + "\n");
        struksewa.setText(struksewa.getText() + "\t" + "\t" + "Terima Kasih Telah berbelanja di " + "\n" + "MY BOOK");
    }

    public void trs() {
        try {
            java.sql.Connection conn = (Connection) Koneksi.getkoneksi();
            java.sql.Statement st = conn.createStatement();
            java.sql.ResultSet rs = st.executeQuery("SELECT * FROM detail_peminjaman order by Id_detail;");
            
            if (rs.next()) {
                String kode = rs.getString("Id_detail").substring(1);
                String AN = "" + (Integer.parseInt(kode) + 1);
                String Nol = "";
                
                if (AN.length() == 1) {
                    Nol = "000";
                } else if (AN.length() == 2){
                    Nol = "00";
                } else if (AN.length() == 3){
                    Nol = "0";
                } else if (AN.length() == 4){
                    Nol = "";
                }
                txt_IDT.setText("T" + Nol + AN);
            } else {
                txt_IDT.setText("T0001");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_kembali = new javax.swing.JButton();
        lama = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tgl_pinjam = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_tot = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tgl_kembali = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        keranjang = new javax.swing.JTable();
        btn_tambah = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        txt_IDT = new javax.swing.JTextField();
        HargaTotal = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PEMINJAMAN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("EMAIL :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, 80, 20));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ID BUKU :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, 90, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("TGL PINJAM :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 130, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("LAMA PINJAM :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 170, -1, -1));
        jPanel1.add(txt_emailpmn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 170, 210, 28));
        jPanel1.add(txt_idbukupmn, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 210, 210, 28));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("NB : APABILA TIDAK MENGEMBALIKAN TEPAT BUKU TEPAT");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 630, -1, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("WAKTU DIKENAKAN DENDA SENILAI 2.000");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 650, -1, -1));

        btn_kembali.setBackground(new java.awt.Color(228, 139, 97));
        btn_kembali.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_kembali.setForeground(new java.awt.Color(255, 255, 255));
        btn_kembali.setText("KEMBALI");
        btn_kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kembaliActionPerformed(evt);
            }
        });
        jPanel1.add(btn_kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 490, 150, 40));

        lama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lamaActionPerformed(evt);
            }
        });
        jPanel1.add(lama, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 170, 60, 28));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("HARGA SEWA :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 210, -1, -1));

        txt_harga.setEditable(false);
        txt_harga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hargaActionPerformed(evt);
            }
        });
        txt_harga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_hargaKeyReleased(evt);
            }
        });
        jPanel1.add(txt_harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 210, 70, 28));

        tgl_pinjam.setDateFormatString("yyyy-MM-dd");
        tgl_pinjam.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tgl_pinjamPropertyChange(evt);
            }
        });
        jPanel1.add(tgl_pinjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 250, 210, 28));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("HARI");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 170, -1, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("HARGA TOTAL :");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 250, -1, -1));

        txt_tot.setEditable(false);
        txt_tot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totActionPerformed(evt);
            }
        });
        txt_tot.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txt_totPropertyChange(evt);
            }
        });
        txt_tot.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_totKeyReleased(evt);
            }
        });
        jPanel1.add(txt_tot, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 250, 200, 33));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("/HARI");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 210, -1, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("TGL KEMBALI :");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 130, -1, -1));

        tgl_kembali.setDateFormatString("yyyy-MM-dd");
        tgl_kembali.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tgl_kembaliPropertyChange(evt);
            }
        });
        jPanel1.add(tgl_kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 130, 210, 28));
        jPanel1.add(jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 290, 210, 28));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("JUMLAH :");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 90, -1));

        keranjang.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(keranjang);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 370, 730, 240));

        btn_tambah.setBackground(new java.awt.Color(228, 139, 97));
        btn_tambah.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_tambah.setForeground(new java.awt.Color(255, 255, 255));
        btn_tambah.setText("TAMBAH");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });
        jPanel1.add(btn_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 370, 150, 40));

        btn_hapus.setBackground(new java.awt.Color(228, 139, 97));
        btn_hapus.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_hapus.setForeground(new java.awt.Color(255, 255, 255));
        btn_hapus.setText("HAPUS");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        jPanel1.add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 430, 150, 40));

        jButton1.setBackground(new java.awt.Color(228, 139, 97));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("PINJAM");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 550, 150, 40));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("ID TRANSAKSI");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, -1, -1));

        txt_IDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_IDTActionPerformed(evt);
            }
        });
        jPanel1.add(txt_IDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, 210, 28));

        HargaTotal.setEditable(false);
        HargaTotal.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        HargaTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HargaTotalActionPerformed(evt);
            }
        });
        jPanel1.add(HargaTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 690, 360, 80));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("TOTAL");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 690, -1, -1));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder desain figma/Menu/logout.png"))); // NOI18N
        jLabel24.setText(" LOGOUT");
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, -1, -1));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder desain figma/Menu/transaksi.png"))); // NOI18N
        jLabel25.setText(" PEMINJAMAN");
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, -1, -1));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder desain figma/Menu/profil.png"))); // NOI18N
        jLabel26.setText(" PROFILE");
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder desain figma/Menu/menu.png"))); // NOI18N
        jLabel9.setText(" MENU");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder desain figma/Menu/semuadiuseratas.png"))); // NOI18N
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 350, 160));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder desain figma/menu baru/bg menu.png"))); // NOI18N
        jLabel28.setText("jLabel3");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1322, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kembaliActionPerformed
        this.setVisible(false);
        new MenuUtama().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_kembaliActionPerformed

    private void tgl_pinjamPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tgl_pinjamPropertyChange
        // TODO add your handling code here
        if (tgl_pinjam.getDate() != null) {
            SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy");
            pinjam1 = format.format(tgl_pinjam.getDate());
        }
        if (pinjam1 != null && kembali != null) {
            getTot();
        }
    }//GEN-LAST:event_tgl_pinjamPropertyChange

    private void txt_hargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hargaActionPerformed

    private void txt_totPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txt_totPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totPropertyChange

    private void txt_totActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totActionPerformed

    }//GEN-LAST:event_txt_totActionPerformed

    private void txt_totKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_totKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totKeyReleased

    private void txt_hargaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_hargaKeyReleased
        // TODO add your handling code here:  
    }//GEN-LAST:event_txt_hargaKeyReleased

    private void lamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lamaActionPerformed
        // TODO add your handling code here:
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy");
            Date tglpinjam = format.parse(pinjam1);
            Date tglkemabli = format.parse(kembali);
            long tglpinjam1 = tglpinjam.getTime();
            long tglkembali1 = tglkemabli.getTime();
            long diff = tglkembali1 - tglpinjam1;
            long lamatgl = diff / (24 * 60 * 60 * 1000);
            lama.setText(Long.toString(lamatgl) + "");
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
    }//GEN-LAST:event_lamaActionPerformed

    private void tgl_kembaliPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tgl_kembaliPropertyChange
        // TODO add your handling code here:
        if (tgl_kembali.getDate() != null) {
            SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy");
            kembali = format.format(tgl_kembali.getDate());
        }
        if (pinjam1 != null && kembali != null) {
            getTot();
        }
    }//GEN-LAST:event_tgl_kembaliPropertyChange

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btn_hapusActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:struk();

        if (txt_emailpmn1.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "MASUKKAN HARGA TOTAL");
        } else {
            SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
            String tanggal = (String) fm.format(tgl_pinjam.getDate());
            String tgl = (String) fm.format(tgl_kembali.getDate());
            try {
                String hari = lama.getText();
                String idbk = txt_idbukupmn.getText();
                String jml = jumlah.getText();
                String user = txt_emailpmn1.getText();
                String Tot = txt_tot.getText();
                String sql = "INSERT INTO detail_peminjaman (Id_detail,tgl_pinjam, kembali, lama_pinjam, id_buku, email, hrg_total, qty) VALUES (NULL,'" + tanggal + "','" + tgl + "', '" + hari + "', '" + idbk + "', '" + user + "', '" + Tot + "', '" + jml + "');";
                java.sql.Connection conn = (Connection) Koneksi.getkoneksi();
                java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
                tampiltmp();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Data Tidak berhasil Disimpan");
            }
        }
        struk();
        DefaultTableModel model = (DefaultTableModel) keranjang.getModel();
        model.setRowCount(0);
        try {
            Hasil_Pinjam.struksewa.print();
        } catch (java.awt.print.PrinterException e) {
            System.err.format("Tidak Ada Printer Yang Ditemukan", e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_IDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_IDTActionPerformed
        trs();        // TODO add your handling code here:

    }//GEN-LAST:event_txt_IDTActionPerformed

    private void HargaTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HargaTotalActionPerformed

    }//GEN-LAST:event_HargaTotalActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal = (String) fm.format(tgl_pinjam.getDate());
        String tgl = (String) fm.format(tgl_kembali.getDate());
        try {
            java.sql.Connection cn = (Connection) Koneksi.getkoneksi();
            st = cn.createStatement();
            st.executeUpdate("insert into detail_keranjang (id_buku, tgl_pinjam, kembali, lama_pinjam, harga_total, qty) values ('" + txt_idbukupmn.getText() + "', '" + tanggal + "', '" + tgl + "', '" + lama.getText() + "','" + txt_tot.getText() + "', '" + jumlah.getText() + "');");
            tampiltmp();
            reset();
            tambah();

            JOptionPane.showMessageDialog(null, "Berhasil");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_btn_tambahActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        tampiltmp();
    }//GEN-LAST:event_formWindowOpened

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Ingin Keluar???", "Confirmation", JOptionPane.YES_NO_OPTION);

        if (ok == 0) {
            new MainMenu().setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Peminjaman1().setVisible(true);
    }//GEN-LAST:event_jLabel25MouseClicked

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Profil().setVisible(true);
    }//GEN-LAST:event_jLabel26MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new MenuUtama().setVisible(true);
    }//GEN-LAST:event_jLabel9MouseClicked

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
            java.util.logging.Logger.getLogger(Peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Peminjaman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField HargaTotal;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_kembali;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public final javax.swing.JTextField jumlah = new javax.swing.JTextField();
    private javax.swing.JTable keranjang;
    public javax.swing.JTextField lama;
    private com.toedter.calendar.JDateChooser tgl_kembali;
    private com.toedter.calendar.JDateChooser tgl_pinjam;
    private static javax.swing.JTextField txt_IDT;
    public static final javax.swing.JTextField txt_emailpmn1 = new javax.swing.JTextField();
    public static final javax.swing.JTextField txt_harga = new javax.swing.JTextField();
    public final javax.swing.JTextField txt_idbukupmn = new javax.swing.JTextField();
    private javax.swing.JTextField txt_tot;
    // End of variables declaration//GEN-END:variables

    private void getTot() {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy");
            Date tglpinjam = format.parse(pinjam1);
            Date tglkemabli = format.parse(kembali);
            long tglpinjam1 = tglpinjam.getTime();
            long tglkembali1 = tglkemabli.getTime();
            long diff = tglkembali1 - tglpinjam1;
            long lamatgl = diff / (24 * 60 * 60 * 1000);
            lama.setText(Long.toString(lamatgl) + "");
            int hitung = Integer.parseInt(jumlah.getText()) * Integer.parseInt(lama.getText()) * Integer.parseInt(txt_harga.getText());
            txt_tot.setText(Integer.toString(hitung));
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
    }

}
