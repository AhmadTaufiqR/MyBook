/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rental;

import com.mysql.jdbc.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class Pop_novel extends javax.swing.JFrame {

    /**
     * Creates new form coba
     */
    public Pop_novel() {
        initComponents();
        load_table();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        sinopsis1 = new javax.swing.JTextArea();
        jLabel24 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(196, 196, 196));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable2);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 540, 930, 380));

        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 230, 217, 250));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("PINJAM");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 440, 150, 40));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setText("KEMBALI");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 440, 150, 40));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("POPULER");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 40, -1, -1));

        sinopsis1.setColumns(20);
        sinopsis1.setLineWrap(true);
        sinopsis1.setRows(5);
        sinopsis1.setToolTipText(""); // NOI18N
        sinopsis1.setBorder(javax.swing.BorderFactory.createTitledBorder("Sinopsis"));
        jScrollPane2.setViewportView(sinopsis1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 220, 350, 190));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menu/semuadiuseratas.png"))); // NOI18N
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 350, 160));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menu/menu.png"))); // NOI18N
        jLabel9.setText(" MENU");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menu/profil.png"))); // NOI18N
        jLabel26.setText(" PROFILE");
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, -1, -1));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menu/transaksi.png"))); // NOI18N
        jLabel27.setText(" PEMINJAMAN");
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, -1, -1));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menu/logout.png"))); // NOI18N
        jLabel28.setText(" LOGOUT");
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, -1, -1));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menu/pinggiran.png"))); // NOI18N
        jLabel25.setText("jLabel3");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, -1));

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

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
     try{   
         int row = jTable2.getSelectedRow();
        String nama = (String) jTable2.getValueAt(row, 0);
        Statement statement = (Statement)Koneksi.getkoneksi().createStatement();
            ResultSet res = statement.executeQuery("select * from detail_buku where id_buku = '"+ nama +"';");
        while (res.next()) {
            Blob gambar = (Blob) res.getBlob("gambar");
            int ukuran = (int) (gambar.length());
            ImageIcon tampilkan = new ImageIcon(gambar.getBytes(1, ukuran));
            jLabel1.setIcon(tampilkan);
        }
     } catch (SQLException ex){
         Logger.getLogger(gambar.class.getName()).log(Level.SEVERE, null, ex);
     }
     
     try{   
         int row = jTable2.getSelectedRow();
        String nama = (String) jTable2.getValueAt(row, 0);
        Statement statement = (Statement)Koneksi.getkoneksi().createStatement();
            ResultSet res = statement.executeQuery("select * from detail_buku where id_buku = '"+ nama +"';");
        while (res.next()) {
            sinopsis1.setText(res.getString(6));
        }
     } catch (SQLException ex){
     }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:Peminjaman pm = new Peminjaman();
        Peminjaman1 pm = new Peminjaman1();
        int row = jTable2.getSelectedRow();
        String nama = (String)jTable2.getValueAt(row, 0);
        String hrg = (String)jTable2.getValueAt(row, 4);
        
        pm.txt_idbukupmn.setText(nama);
        pm.txt_harga.setText(hrg);
        
        this.setVisible(false);
        pm.setVisible(true);
        pm.pack();
        pm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new novel().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new MenuUtama().setVisible(true);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Profil().setVisible(true);
    }//GEN-LAST:event_jLabel26MouseClicked

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Peminjaman1().setVisible(true);
    }//GEN-LAST:event_jLabel27MouseClicked

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Ingin Keluar???", "Confirmation", JOptionPane.YES_NO_OPTION);

        if (ok == 0) {
            new MainMenu().setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_jLabel28MouseClicked

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
            java.util.logging.Logger.getLogger(Pop_novel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pop_novel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pop_novel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pop_novel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pop_novel().setVisible(true);
            }
        });
    }

    private void load_table (){
    //membuat tampilan tabel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id Buku");
        model.addColumn("judul");
        model.addColumn("Tahun Terbit");
        model.addColumn("Jenis");
        model.addColumn("Harga Satuan");
        model.addColumn("Stok");
        //menampilkan database dalam tabel
        try {
            int no=1;
            String sql = "SELECT detail_buku.id_buku, detail_buku.judul_buku, detail_buku.tahun_terbit, detail_buku.jenis, detail_buku.harga_satuan, detail_buku.stok, COUNT(log_peminjam.id_buku) AS LG, SUM(log_peminjam.qty) AS sm FROM log_peminjam JOIN detail_buku ON detail_buku.id_buku = log_peminjam.id_buku WHERE detail_buku.jenis = 'novel' GROUP BY log_peminjam.id_buku HAVING sm >5;";
            java.sql.Connection conn = (Connection) Koneksi.getkoneksi();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
                model.addRow(new Object[]{res.getString("id_buku"),
                res.getString("judul_buku"),res.getString("tahun_terbit"),res.getString("jenis"),res.getString("harga_satuan"), res.getString("stok")});
            }
            jTable2.setModel(model);
        } catch (Exception e) {
        }
    };
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea sinopsis1;
    // End of variables declaration//GEN-END:variables

    private static class gambar {

        public gambar() {
        }
    }
}
