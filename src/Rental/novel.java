package Rental;

import javax.swing.JOptionPane;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class novel extends javax.swing.JFrame {

    /**
     * Creates new form novel
     */
    public novel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        txt_novel = new javax.swing.JPanel();
        btn_populer = new javax.swing.JButton();
        btn_terbaru = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();
        txt_nvl = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();

        jButton2.setText("jButton2");

        jButton7.setText("jButton7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txt_novel.setBackground(new java.awt.Color(196, 196, 196));
        txt_novel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_populer.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_populer.setText("POPULER");
        btn_populer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_populerActionPerformed(evt);
            }
        });
        txt_novel.add(btn_populer, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 280, 439, 75));

        btn_terbaru.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_terbaru.setText("TERBARU");
        btn_terbaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_terbaruActionPerformed(evt);
            }
        });
        txt_novel.add(btn_terbaru, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 460, 439, 75));

        btn_back.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_back.setText("BACK");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });
        txt_novel.add(btn_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 740, 150, 40));

        txt_nvl.setBackground(new java.awt.Color(255, 255, 255));
        txt_nvl.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        txt_nvl.setForeground(new java.awt.Color(255, 255, 255));
        txt_nvl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_nvl.setText("NOVEL");
        txt_novel.add(txt_nvl, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 40, 90, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menu/bg.png"))); // NOI18N
        txt_novel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, -1, -1));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menu/semuadiuseratas.png"))); // NOI18N
        txt_novel.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 350, 160));

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
        txt_novel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

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
        txt_novel.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, -1, -1));

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
        txt_novel.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, -1, -1));

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
        txt_novel.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, -1, -1));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menu/pinggiran.png"))); // NOI18N
        jLabel25.setText("jLabel3");
        txt_novel.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_novel, javax.swing.GroupLayout.DEFAULT_SIZE, 1322, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_novel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_populerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_populerActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new Pop_novel().setVisible(true);
            
    }//GEN-LAST:event_btn_populerActionPerformed

    private void btn_terbaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_terbaruActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new Terb_novel().setVisible(true);
    }//GEN-LAST:event_btn_terbaruActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new MenuUtama().setVisible(true);
    }//GEN-LAST:event_btn_backActionPerformed

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
            java.util.logging.Logger.getLogger(novel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(novel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(novel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(novel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new novel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_populer;
    private javax.swing.JButton btn_terbaru;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel txt_novel;
    private javax.swing.JLabel txt_nvl;
    // End of variables declaration//GEN-END:variables
}
