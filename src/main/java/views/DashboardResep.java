/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import controllers.ResepController;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import models.Resep;

public class DashboardResep extends javax.swing.JFrame {
    private ResepController resepController;
    private List<Resep> listResepTerpajang;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DashboardResep.class.getName());

    
    public DashboardResep() {
        initComponents();
        resepController = new ResepController();
        muatDataResep();
}

    public void muatDataResep() {
        // Ambil data dari database melalui controller
        listResepTerpajang = resepController.getAllResep();
        
        JLabel[] labelJudul = {jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9, jLabel10};
        JLabel[] labelGambar = {resepCardImage1, resepCardImage2, resepCardImage3, resepCardImage4, resepCardImage5, resepCardImage6, resepCardImage7};
        javax.swing.JPanel[] cards = {resepCard1, resepCard2, resepCard3, resepcard4, resepCard5, resepCard6, resepCard7};

        for (int i = 0; i < cards.length; i++) {
            if (i < listResepTerpajang.size()) {
                Resep r = listResepTerpajang.get(i);
                labelJudul[i].setText(r.getJudul());
                
                cards[i].setOpaque(false);
                
                if (r.getFotoUtama() != null && !r.getFotoUtama().isEmpty()) {
                    setGambarResep(labelGambar[i], r.getFotoUtama());
                }
                cards[i].setVisible(true);
            } else {
                cards[i].setVisible(false); 
            }
        }
    }
    
    // Di dalam class DashboardResep
    private void bukaDetail(int index) {
        if (index >= 0 && index < listResepTerpajang.size()) {
            Resep resepSingkat = listResepTerpajang.get(index);

            // Ambil data lengkap (termasuk bahan baku) melalui controller
            Resep resepLengkap = resepController.getDetailResep(resepSingkat);

            ResepDetail detailFrame = new ResepDetail(resepLengkap);
            detailFrame.setVisible(true);
            this.dispose(); // Sembunyikan dashboard
    }
}
    
    public void setGambarResep(JLabel label, String path) {
        try {
            java.net.URL imgUrl = getClass().getResource("/images/" + path);
            if (imgUrl != null) {
                ImageIcon icon = new ImageIcon(imgUrl);
                Image img = icon.getImage().getScaledInstance(170, 100, Image.SCALE_SMOOTH);
                label.setIcon(new ImageIcon(img));
            }
        } catch (Exception e) {
            logger.log(java.util.logging.Level.SEVERE, "Gagal set gambar", e);
        }
    }
    
    
    public void setImage() {
    java.net.URL imgUrl = getClass().getResource("/images/bakso.jpg");
    System.out.println("URL GAMBAR = " + imgUrl);

    if (imgUrl == null) {
        System.out.println("GAMBAR TIDAK DITEMUKAN");
        return;
    }

    resepCardImage1.setIcon(new ImageIcon(imgUrl));
}
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tulisResepButton = new RoundedPanel(15);
        jLabel2 = new javax.swing.JLabel();
        resepCard1 = new RoundedPanel (15)
        ;
        resepCardImage1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        resepCard2 = new RoundedPanel (15)
        ;
        resepCardImage2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        resepCard3 = new RoundedPanel (15)
        ;
        resepCardImage3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        resepcard4 = new RoundedPanel (15)
        ;
        resepCardImage4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        resepCard5 = new RoundedPanel (15)
        ;
        resepCardImage5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        resepCard6 = new RoundedPanel (15)
        ;
        resepCardImage6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        resepCard7 = new RoundedPanel (15)
        ;
        resepCardImage7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cariTextFiled = new javax.swing.JTextField();
        cariButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1366, 768));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Daftar Resep");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setText("MADANGG ");

        tulisResepButton.setBackground(new java.awt.Color(255, 102, 0));
        tulisResepButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tulisResepButtonMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("+ Tulis Resep");

        javax.swing.GroupLayout tulisResepButtonLayout = new javax.swing.GroupLayout(tulisResepButton);
        tulisResepButton.setLayout(tulisResepButtonLayout);
        tulisResepButtonLayout.setHorizontalGroup(
            tulisResepButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tulisResepButtonLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        tulisResepButtonLayout.setVerticalGroup(
            tulisResepButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
        );

        resepCard1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resepCard1MouseClicked(evt);
            }
        });

        jLabel4.setText("Bakso Padang");

        javax.swing.GroupLayout resepCard1Layout = new javax.swing.GroupLayout(resepCard1);
        resepCard1.setLayout(resepCard1Layout);
        resepCard1Layout.setHorizontalGroup(
            resepCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(resepCardImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(resepCard1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4))
        );
        resepCard1Layout.setVerticalGroup(
            resepCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resepCard1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resepCardImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );

        resepCard2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resepCard2MouseClicked(evt);
            }
        });

        jLabel5.setText("sate ayam");

        javax.swing.GroupLayout resepCard2Layout = new javax.swing.GroupLayout(resepCard2);
        resepCard2.setLayout(resepCard2Layout);
        resepCard2Layout.setHorizontalGroup(
            resepCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(resepCardImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(resepCard2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5))
        );
        resepCard2Layout.setVerticalGroup(
            resepCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resepCard2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resepCardImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );

        resepCard3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resepCard3MouseClicked(evt);
            }
        });

        jLabel6.setText("sate ayam");

        javax.swing.GroupLayout resepCard3Layout = new javax.swing.GroupLayout(resepCard3);
        resepCard3.setLayout(resepCard3Layout);
        resepCard3Layout.setHorizontalGroup(
            resepCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(resepCardImage3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(resepCard3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6))
        );
        resepCard3Layout.setVerticalGroup(
            resepCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resepCard3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resepCardImage3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );

        resepcard4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resepcard4MouseClicked(evt);
            }
        });

        jLabel7.setText("sate ayam");

        javax.swing.GroupLayout resepcard4Layout = new javax.swing.GroupLayout(resepcard4);
        resepcard4.setLayout(resepcard4Layout);
        resepcard4Layout.setHorizontalGroup(
            resepcard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(resepCardImage4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(resepcard4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7))
        );
        resepcard4Layout.setVerticalGroup(
            resepcard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resepcard4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resepCardImage4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );

        resepCard5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resepCard5MouseClicked(evt);
            }
        });

        jLabel8.setText("sate ayam");

        javax.swing.GroupLayout resepCard5Layout = new javax.swing.GroupLayout(resepCard5);
        resepCard5.setLayout(resepCard5Layout);
        resepCard5Layout.setHorizontalGroup(
            resepCard5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(resepCardImage5, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(resepCard5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8))
        );
        resepCard5Layout.setVerticalGroup(
            resepCard5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resepCard5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resepCardImage5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );

        resepCard6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resepCard6MouseClicked(evt);
            }
        });

        jLabel9.setText("sate ayam");

        javax.swing.GroupLayout resepCard6Layout = new javax.swing.GroupLayout(resepCard6);
        resepCard6.setLayout(resepCard6Layout);
        resepCard6Layout.setHorizontalGroup(
            resepCard6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(resepCardImage6, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(resepCard6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9))
        );
        resepCard6Layout.setVerticalGroup(
            resepCard6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resepCard6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resepCardImage6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );

        resepCard7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resepCard7MouseClicked(evt);
            }
        });

        jLabel10.setText("sate ayam");

        javax.swing.GroupLayout resepCard7Layout = new javax.swing.GroupLayout(resepCard7);
        resepCard7.setLayout(resepCard7Layout);
        resepCard7Layout.setHorizontalGroup(
            resepCard7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(resepCardImage7, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(resepCard7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10))
        );
        resepCard7Layout.setVerticalGroup(
            resepCard7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resepCard7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resepCardImage7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );

        cariTextFiled.setText("Cari Resep");
        cariTextFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariTextFiledActionPerformed(evt);
            }
        });

        cariButton.setText("Cari");
        cariButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(538, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(536, 536, 536))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(tulisResepButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cariTextFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cariButton)
                        .addGap(430, 430, 430))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(resepCard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(resepCard2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(resepCard3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(resepcard4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(resepCard5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(resepCard6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(resepCard7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 44, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(resepCard2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tulisResepButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(resepCard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cariTextFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cariButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(resepcard4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(resepCard5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(resepCard6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(resepCard7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(resepCard3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(371, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void cariTextFiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariTextFiledActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cariTextFiledActionPerformed

    private void cariButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariButtonActionPerformed
        // TODO add your handling code here:
     
    }//GEN-LAST:event_cariButtonActionPerformed

    private void resepCard1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resepCard1MouseClicked
        // TODO add your handling code here:
        bukaDetail(0);
    }//GEN-LAST:event_resepCard1MouseClicked

    private void resepCard2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resepCard2MouseClicked
        // TODO add your handling code here:
        bukaDetail(1);
        
    }//GEN-LAST:event_resepCard2MouseClicked

    private void resepCard3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resepCard3MouseClicked
        // TODO add your handling code here:
        bukaDetail(2);
    }//GEN-LAST:event_resepCard3MouseClicked

    private void resepcard4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resepcard4MouseClicked
        // TODO add your handling code here:
        bukaDetail(3);
    }//GEN-LAST:event_resepcard4MouseClicked

    private void resepCard5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resepCard5MouseClicked
        // TODO add your handling code here:
        bukaDetail(4);
    }//GEN-LAST:event_resepCard5MouseClicked

    private void resepCard6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resepCard6MouseClicked
        // TODO add your handling code here:
        bukaDetail(5);
    }//GEN-LAST:event_resepCard6MouseClicked

    private void resepCard7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resepCard7MouseClicked
        // TODO add your handling code here:
        bukaDetail(6);
    }//GEN-LAST:event_resepCard7MouseClicked

    private void tulisResepButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tulisResepButtonMouseClicked
        // TODO add your handling code here:
        FormResep formTambah = new FormResep();
        formTambah.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_tulisResepButtonMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cariButton;
    private javax.swing.JTextField cariTextFiled;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel resepCard1;
    private javax.swing.JPanel resepCard2;
    private javax.swing.JPanel resepCard3;
    private javax.swing.JPanel resepCard5;
    private javax.swing.JPanel resepCard6;
    private javax.swing.JPanel resepCard7;
    private javax.swing.JLabel resepCardImage1;
    private javax.swing.JLabel resepCardImage2;
    private javax.swing.JLabel resepCardImage3;
    private javax.swing.JLabel resepCardImage4;
    private javax.swing.JLabel resepCardImage5;
    private javax.swing.JLabel resepCardImage6;
    private javax.swing.JLabel resepCardImage7;
    private javax.swing.JPanel resepcard4;
    private javax.swing.JPanel tulisResepButton;
    // End of variables declaration//GEN-END:variables
}
