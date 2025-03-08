/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MetroInterfaz;

/**
 *
 * @author ile1
 */
public class Start extends javax.swing.JFrame {

    int mouseX, mouseY;
    
    public Start() {
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

        bg = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        Bomb1 = new javax.swing.JLabel();
        bomb2 = new javax.swing.JLabel();
        Bandera = new javax.swing.JLabel();
        Title = new javax.swing.JLabel();
        Title1 = new javax.swing.JLabel();
        paint1 = new javax.swing.JLabel();
        paint2 = new javax.swing.JLabel();
        paint3 = new javax.swing.JLabel();
        unimet_image = new javax.swing.JLabel();
        Boom = new javax.swing.JLabel();
        new_game2 = new javax.swing.JLabel();
        Salir_button = new javax.swing.JButton();
        New_game_button1 = new javax.swing.JButton();
        Continuar_button = new javax.swing.JButton();
        Tutorial = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(800, 500));

        bg.setBackground(new java.awt.Color(255, 102, 0));
        bg.setPreferredSize(new java.awt.Dimension(800, 500));
        bg.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                bgMouseDragged(evt);
            }
        });
        bg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bgMousePressed(evt);
            }
        });
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 226));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Bomb1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Bomb1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/download-removebg-preview (1).png"))); // NOI18N
        Bomb1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(Bomb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 130, -1));

        bomb2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/download-removebg-preview (1)_1.png"))); // NOI18N
        jPanel1.add(bomb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, -1, -1));

        Bandera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/download-removebg-preview.png"))); // NOI18N
        jPanel1.add(Bandera, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, -1, -1));

        Title.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        Title.setForeground(new java.awt.Color(0, 0, 0));
        Title.setText("BUSCAMINAS");
        jPanel1.add(Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 130, 30));

        Title1.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        Title1.setForeground(new java.awt.Color(0, 0, 0));
        Title1.setText("METRO");
        Title1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(Title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 70, 30));

        paint1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/png-clipart-poster-decorations-white-paint-removebg-preview.png"))); // NOI18N
        jPanel1.add(paint1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, -1, -1));

        paint2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/png-clipart-poster-decorations-white-paint-removebg-preview.png"))); // NOI18N
        jPanel1.add(paint2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, -1, -1));

        paint3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/png-clipart-poster-decorations-white-paint-removebg-preview.png"))); // NOI18N
        jPanel1.add(paint3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, -1, -1));

        unimet_image.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        unimet_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Unimet.png"))); // NOI18N
        jPanel1.add(unimet_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 90));

        Boom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Boom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/istockphoto-1371914725-612x612-removebg-preview.png"))); // NOI18N
        jPanel1.add(Boom, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 800, -1));

        new_game2.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        new_game2.setForeground(new java.awt.Color(0, 0, 0));
        new_game2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(new_game2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 300, 800, -1));

        Salir_button.setBackground(new java.awt.Color(255, 255, 226));
        Salir_button.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        Salir_button.setForeground(new java.awt.Color(0, 0, 0));
        Salir_button.setText("SALIR");
        Salir_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Salir_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Salir_buttonActionPerformed(evt);
            }
        });
        jPanel1.add(Salir_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 400, 160, -1));

        New_game_button1.setBackground(new java.awt.Color(255, 255, 226));
        New_game_button1.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        New_game_button1.setForeground(new java.awt.Color(0, 0, 0));
        New_game_button1.setText("NUEVO JUEGO");
        New_game_button1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        New_game_button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                New_game_button1ActionPerformed(evt);
            }
        });
        jPanel1.add(New_game_button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 160, -1));

        Continuar_button.setBackground(new java.awt.Color(255, 255, 226));
        Continuar_button.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        Continuar_button.setForeground(new java.awt.Color(0, 0, 0));
        Continuar_button.setText("CONTINUAR");
        Continuar_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Continuar_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Continuar_buttonActionPerformed(evt);
            }
        });
        jPanel1.add(Continuar_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, 160, -1));

        Tutorial.setBackground(new java.awt.Color(255, 255, 226));
        Tutorial.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        Tutorial.setForeground(new java.awt.Color(0, 0, 0));
        Tutorial.setText("¿COMO JUGAR?");
        Tutorial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Tutorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TutorialActionPerformed(evt);
            }
        });
        jPanel1.add(Tutorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 350, 180, -1));

        bg.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 760, 460));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Salir_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Salir_buttonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_Salir_buttonActionPerformed

    private void New_game_button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_New_game_button1ActionPerformed
        New_game game = new New_game();
        game.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_New_game_button1ActionPerformed

    private void Continuar_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Continuar_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Continuar_buttonActionPerformed

    private void TutorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TutorialActionPerformed
        Guia tuto = new Guia();
        tuto.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_TutorialActionPerformed

    private void bgMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgMousePressed
        mouseX = evt.getX();
        mouseY = evt.getY();
    }//GEN-LAST:event_bgMousePressed

    private void bgMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - mouseX, y - mouseY);
    }//GEN-LAST:event_bgMouseDragged

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
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Start().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Bandera;
    private javax.swing.JLabel Bomb1;
    private javax.swing.JLabel Boom;
    private javax.swing.JButton Continuar_button;
    private javax.swing.JButton New_game_button1;
    private javax.swing.JButton Salir_button;
    private javax.swing.JLabel Title;
    private javax.swing.JLabel Title1;
    private javax.swing.JButton Tutorial;
    private javax.swing.JPanel bg;
    private javax.swing.JLabel bomb2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel new_game2;
    private javax.swing.JLabel paint1;
    private javax.swing.JLabel paint2;
    private javax.swing.JLabel paint3;
    private javax.swing.JLabel unimet_image;
    // End of variables declaration//GEN-END:variables
}
