/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package capaPresentacion;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author an
 */
public class FrmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void llamarFrm(JInternalFrame frame) {
        try {
            contenedor.add(frame);
            frame.setMaximum(true);
            frame.setVisible(true);
            frame.setResizable(false);
            frame.setClosable(true);
            frame.setMaximizable(true);
            frame.setIconifiable(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
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
        jLabel12 = new javax.swing.JLabel();
        lblNombres = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        btnUsuarios = new javax.swing.JButton();
        btnAmbientes = new javax.swing.JButton();
        btnRoles = new javax.swing.JButton();
        btnALumnos = new javax.swing.JButton();
        btnDocente = new javax.swing.JButton();
        btnDeportes = new javax.swing.JButton();
        btnGH = new javax.swing.JButton();
        btnMatriculas = new javax.swing.JButton();
        btnPagos = new javax.swing.JButton();
        btnDocumentos = new javax.swing.JButton();
        ImageIcon icon = new ImageIcon(getClass().getResource("/recursos/back.jpg"));
        Image image = icon.getImage();
        contenedor = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }

        };

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("BIENVENIDO(A)");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 280, 70));

        lblNombres.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        lblNombres.setForeground(new java.awt.Color(255, 255, 255));
        lblNombres.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombres.setText("USUARIO");
        jPanel1.add(lblNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 280, 70));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 300, -1));

        jLabel17.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("DOCUMENTOS");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, -1, 60));

        jLabel15.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("ALUMNOS");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, -1, 60));

        jLabel13.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("USUARIOS");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 730, -1, 60));

        jLabel16.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("ROLES");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 670, -1, 60));

        jLabel18.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("AMBIENTES");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, 60));

        jLabel19.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("DOCENTES");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, -1, 60));

        jLabel20.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("DEPORTES");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, -1, 60));

        jLabel21.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("GRUPOS HORARIOS");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, 60));

        jLabel22.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("MATRICULAS");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, 60));

        jLabel23.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("PAGOS");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, 60));

        btnUsuarios.setBackground(new java.awt.Color(102, 102, 102));
        btnUsuarios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnUsuarios.setBorderPainted(false);
        btnUsuarios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnUsuarios.setIconTextGap(8);
        btnUsuarios.setName(""); // NOI18N
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });
        jPanel1.add(btnUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 730, 340, 60));

        btnAmbientes.setBackground(new java.awt.Color(102, 102, 102));
        btnAmbientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAmbientes.setBorderPainted(false);
        btnAmbientes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAmbientes.setIconTextGap(8);
        btnAmbientes.setName(""); // NOI18N
        btnAmbientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAmbientesActionPerformed(evt);
            }
        });
        jPanel1.add(btnAmbientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 340, 60));

        btnRoles.setBackground(new java.awt.Color(102, 102, 102));
        btnRoles.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnRoles.setBorderPainted(false);
        btnRoles.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnRoles.setIconTextGap(8);
        btnRoles.setName(""); // NOI18N
        btnRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRolesActionPerformed(evt);
            }
        });
        jPanel1.add(btnRoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 670, 340, 60));

        btnALumnos.setBackground(new java.awt.Color(102, 102, 102));
        btnALumnos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnALumnos.setBorderPainted(false);
        btnALumnos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnALumnos.setIconTextGap(8);
        btnALumnos.setName(""); // NOI18N
        btnALumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnALumnosActionPerformed(evt);
            }
        });
        jPanel1.add(btnALumnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 340, 60));

        btnDocente.setBackground(new java.awt.Color(102, 102, 102));
        btnDocente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnDocente.setBorderPainted(false);
        btnDocente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDocente.setIconTextGap(8);
        btnDocente.setName(""); // NOI18N
        btnDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocenteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 340, 60));

        btnDeportes.setBackground(new java.awt.Color(102, 102, 102));
        btnDeportes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnDeportes.setBorderPainted(false);
        btnDeportes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDeportes.setIconTextGap(8);
        btnDeportes.setName(""); // NOI18N
        btnDeportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeportesActionPerformed(evt);
            }
        });
        jPanel1.add(btnDeportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 340, 60));

        btnGH.setBackground(new java.awt.Color(102, 102, 102));
        btnGH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnGH.setBorderPainted(false);
        btnGH.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnGH.setIconTextGap(8);
        btnGH.setName(""); // NOI18N
        btnGH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGHActionPerformed(evt);
            }
        });
        jPanel1.add(btnGH, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 340, 60));

        btnMatriculas.setBackground(new java.awt.Color(102, 102, 102));
        btnMatriculas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnMatriculas.setBorderPainted(false);
        btnMatriculas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMatriculas.setIconTextGap(8);
        btnMatriculas.setName(""); // NOI18N
        btnMatriculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatriculasActionPerformed(evt);
            }
        });
        jPanel1.add(btnMatriculas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 340, 60));

        btnPagos.setBackground(new java.awt.Color(102, 102, 102));
        btnPagos.setForeground(new java.awt.Color(255, 255, 255));
        btnPagos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnPagos.setBorderPainted(false);
        btnPagos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPagos.setIconTextGap(8);
        btnPagos.setName(""); // NOI18N
        btnPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagosActionPerformed(evt);
            }
        });
        jPanel1.add(btnPagos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 340, 60));

        btnDocumentos.setBackground(new java.awt.Color(102, 102, 102));
        btnDocumentos.setForeground(new java.awt.Color(255, 255, 255));
        btnDocumentos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnDocumentos.setBorderPainted(false);
        btnDocumentos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDocumentos.setIconTextGap(8);
        btnDocumentos.setName(""); // NOI18N
        btnDocumentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocumentosActionPerformed(evt);
            }
        });
        jPanel1.add(btnDocumentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 610, 340, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 790));

        javax.swing.GroupLayout contenedorLayout = new javax.swing.GroupLayout(contenedor);
        contenedor.setLayout(contenedorLayout);
        contenedorLayout.setHorizontalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1100, Short.MAX_VALUE)
        );
        contenedorLayout.setVerticalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 790, Short.MAX_VALUE)
        );

        getContentPane().add(contenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 1100, 790));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        lblNombres.setText(Module.userName);
    }//GEN-LAST:event_formWindowOpened

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        FrmListadoUsuarios frmListadoUsuarios = new FrmListadoUsuarios();
        llamarFrm(frmListadoUsuarios);
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnAmbientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAmbientesActionPerformed
        FrmListadoAmbientes frmListadoAmbientes = new FrmListadoAmbientes();
        llamarFrm(frmListadoAmbientes);
    }//GEN-LAST:event_btnAmbientesActionPerformed

    private void btnRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRolesActionPerformed
        FrmListadoRoles frmListadoRoles = new FrmListadoRoles();
        llamarFrm(frmListadoRoles);
    }//GEN-LAST:event_btnRolesActionPerformed

    private void btnALumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnALumnosActionPerformed
        FrmListadoAlumnos frmListadoAlumnos = new FrmListadoAlumnos();
        llamarFrm(frmListadoAlumnos);
    }//GEN-LAST:event_btnALumnosActionPerformed

    private void btnDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocenteActionPerformed
        FrmListadoDocente frmListadoDocente = new FrmListadoDocente();
        llamarFrm(frmListadoDocente);
    }//GEN-LAST:event_btnDocenteActionPerformed

    private void btnDeportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeportesActionPerformed
        FrmListadoDeportes2 frmListadoDeportes = new FrmListadoDeportes2();
        llamarFrm(frmListadoDeportes);
    }//GEN-LAST:event_btnDeportesActionPerformed

    private void btnGHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGHActionPerformed
        FrmListadoGH flgh = new FrmListadoGH();
        llamarFrm(flgh);
    }//GEN-LAST:event_btnGHActionPerformed

    private void btnMatriculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatriculasActionPerformed
        FrmListadoMatriculas flm = new FrmListadoMatriculas();
        llamarFrm(flm);
    }//GEN-LAST:event_btnMatriculasActionPerformed

    private void btnPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagosActionPerformed
        FrmListadoPagos flp = new FrmListadoPagos();
        llamarFrm(flp);
    }//GEN-LAST:event_btnPagosActionPerformed

    private void btnDocumentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocumentosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDocumentosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        //</editor-fold>

        try {
            UIManager.setLookAndFeel(new FlatLightLaf());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnALumnos;
    private javax.swing.JButton btnAmbientes;
    private javax.swing.JButton btnDeportes;
    private javax.swing.JButton btnDocente;
    private javax.swing.JButton btnDocumentos;
    private javax.swing.JButton btnGH;
    private javax.swing.JButton btnMatriculas;
    private javax.swing.JButton btnPagos;
    private javax.swing.JButton btnRoles;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JDesktopPane contenedor;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblNombres;
    // End of variables declaration//GEN-END:variables
}
