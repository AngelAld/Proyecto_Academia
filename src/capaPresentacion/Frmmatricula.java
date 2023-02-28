/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package capaPresentacion;

import capaNegocio.EAlumno;
import capaNegocio.EGrupohorario;
import capaNegocio.EMatricula;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.Alumno;

import modelos.Grupohorario;
import modelos.Matricula;

/**
 *
 * @author IVAN
 */
public class Frmmatricula extends javax.swing.JFrame {

    Matricula clsMatricula = new Matricula();
    Grupohorario clsGrupohorario = new Grupohorario();
    Alumno clsAlumno = new Alumno();
    EForm formActive;
    private final int id;
    int id_alumno = 0;
    int id_gh = 0;

    private final String pattern = "yyyy-MM-dd";
    DateFormat formatter = new SimpleDateFormat(pattern);

    /**
     * Creates new form Frmmatricula
     */
    public Frmmatricula() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        formActive = Module.formActive;
        id = Module.id;

        if (id == 0) {
            this.setTitle("Nuevo Ambiente");
        } else {
            this.setTitle("Editar Ambiente");

            ArrayList arrayList = clsMatricula.searchById(id);
            EMatricula matric = (EMatricula) arrayList.get(0);
            this.cboestado.setSelectedItem(matric.getEstado());

            Module.id_alumno = matric.getId_alumno();
            Module.id_gh = matric.getId_gh();

            try {
                this.jdcfechamat.setDate(formatter.parse(matric.getF_matricula()));
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, ex, "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    private void cleanForm() {
        Module.id = 0;
        Module.id_gh = 0;
        Module.id_alumno = 0;
        txtalumno.setText("");
        txtgrupo.setText("");
        jdcfechamat.setDateFormatString("");
        cboestado.setSelectedIndex(0);
        formActive.getCaller().loadTable();
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
        txtalumno = new javax.swing.JTextField();
        txtgrupo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnidgh = new javax.swing.JButton();
        btnidalumno = new javax.swing.JButton();
        cboestado = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jdcfechamat = new com.toedter.calendar.JDateChooser();
        btnregistar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btncancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtalumno.setEditable(false);
        jPanel1.add(txtalumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 108, -1));

        txtgrupo.setEditable(false);
        txtgrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtgrupoActionPerformed(evt);
            }
        });
        jPanel1.add(txtgrupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 108, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Grupo horario:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 52, 110, -1));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Alumno");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 89, 110, -1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Fecha matricula:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 110, -1));

        btnidgh.setText("+");
        btnidgh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnidghActionPerformed(evt);
            }
        });
        jPanel1.add(btnidgh, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, -1, -1));

        btnidalumno.setText("+");
        btnidalumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnidalumnoActionPerformed(evt);
            }
        });
        jPanel1.add(btnidalumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, -1, -1));

        cboestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACTIVO", "INACTIVO" }));
        jPanel1.add(cboestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 108, -1));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel10.setText("Estado:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 132, 110, -1));
        jPanel1.add(jdcfechamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 108, -1));

        btnregistar.setBackground(new java.awt.Color(193, 39, 98));
        btnregistar.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        btnregistar.setForeground(new java.awt.Color(255, 255, 255));
        btnregistar.setText("GUARDAR");
        btnregistar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistarActionPerformed(evt);
            }
        });
        jPanel1.add(btnregistar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, -1, 30));

        jSeparator1.setName(""); // NOI18N
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 250, 30));

        btncancelar.setBackground(new java.awt.Color(48, 48, 48));
        btncancelar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btncancelar.setForeground(new java.awt.Color(255, 255, 255));
        btncancelar.setText("CANCELAR");
        btncancelar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btncancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 220, 80, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnidghActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnidghActionPerformed
        // TODO add your handling code here:

        FrmSelecionarGH frmgh = new FrmSelecionarGH();
        frmgh.setVisible(true);
    }//GEN-LAST:event_btnidghActionPerformed

    private void btnidalumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnidalumnoActionPerformed
        // TODO add your handling code here:
        FrmSeleccionarAlumno frmalumno = new FrmSeleccionarAlumno();
        frmalumno.setVisible(true);

    }//GEN-LAST:event_btnidalumnoActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        id_alumno = Module.id_alumno;
        id_gh = Module.id_gh;
        try {
            if (id_alumno == 0) {
            } else {
                ArrayList arrayList = clsAlumno.searchById(id_alumno);
                EAlumno ambient = (EAlumno) arrayList.get(0);
                this.txtalumno.setText(ambient.getNombres());
            }
            if (id_gh == 0) {
            } else {
                ArrayList arrayList2 = clsGrupohorario.searchById(id_gh);
                EGrupohorario grupo = (EGrupohorario) arrayList2.get(0);
                this.txtgrupo.setText(grupo.getNombre());

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_formWindowActivated

    private void btnregistarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistarActionPerformed
        // TODO add your handling code here:
        try {

            String estado = this.cboestado.getSelectedItem().toString();
            String fechamatri = formatter.format(jdcfechamat.getDate());

            if (fechamatri.equals("")) {
                JOptionPane.showMessageDialog(null, "Ingrese un fecha", Module.titleMessage, JOptionPane.CANCEL_OPTION);
            } else {

                EMatricula objmatricula = new EMatricula();
                if (id == 0) { //Registramos un nuevo rol
                    objmatricula.setId_gh(id_gh);
                    objmatricula.setId_alumno(id_alumno);
                    objmatricula.setEstado(estado);
                    objmatricula.setF_matricula(fechamatri);
                    String message = clsMatricula.create(objmatricula);
                    ArrayList arrayList = clsMatricula.searchByName(txtalumno.getText());
                    EMatricula mat = (EMatricula) arrayList.get(0);
                    String a = clsMatricula.generate(mat);
                    if (message.equals("Registrado correctamente")) {
                        JOptionPane.showMessageDialog(null, message, Module.titleMessage, JOptionPane.INFORMATION_MESSAGE);
                        JOptionPane.showMessageDialog(null, a, Module.titleMessage, JOptionPane.INFORMATION_MESSAGE);
                        cleanForm();
                    } else {
                        JOptionPane.showMessageDialog(null, message, Module.titleMessage, JOptionPane.CANCEL_OPTION);
                    }
                } else {
                    objmatricula.setId(id);
                    objmatricula.setId_gh(id_gh);
                    objmatricula.setId_alumno(id_alumno);
                    objmatricula.setEstado(estado);
                    objmatricula.setF_matricula(fechamatri);
                    String message = clsMatricula.create(objmatricula);

                    if (message.equals("Actualizado correctamente")) {
                        JOptionPane.showMessageDialog(null, message, Module.titleMessage, JOptionPane.INFORMATION_MESSAGE);

                        cleanForm();
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, message, Module.titleMessage, JOptionPane.CANCEL_OPTION);
                    }
                }
            }
        } catch (Exception e) {
        }


    }//GEN-LAST:event_btnregistarActionPerformed

    private void txtgrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtgrupoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtgrupoActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        cleanForm();
    }//GEN-LAST:event_formWindowClosed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btncancelarActionPerformed

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
            java.util.logging.Logger.getLogger(Frmmatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frmmatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frmmatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frmmatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frmmatricula().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnidalumno;
    private javax.swing.JButton btnidgh;
    private javax.swing.JButton btnregistar;
    private javax.swing.JComboBox<String> cboestado;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private com.toedter.calendar.JDateChooser jdcfechamat;
    private javax.swing.JTextField txtalumno;
    private javax.swing.JTextField txtgrupo;
    // End of variables declaration//GEN-END:variables
}