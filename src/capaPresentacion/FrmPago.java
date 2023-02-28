/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package capaPresentacion;

import capaNegocio.ECuotas;
import capaNegocio.EPagos;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import modelos.Cuotas;
import modelos.Pagos;

/**
 *
 * @author an
 */
public class FrmPago extends javax.swing.JFrame {

    DefaultTableModel defaultTable = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    Pagos clsPagos = new Pagos();
    EForm formActive;
    private final int id;
    private int id_matricula;

    /**
     * Creates new form FrmPafo
     */
    public FrmPago() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);

        formActive = Module.formActive;
        id = 1;

        if (id == 0) {
            this.setTitle("Nuevo Pago");
        } else {
            this.setTitle("Editar Pago");

            ArrayList arrayList = clsPagos.searchById(id);

            EPagos pago = (EPagos) arrayList.get(0);

            txtEstudiante.setText(pago.getAlumno());
            txtGH.setText(pago.getGrupo_horario());
            cboEstado.setSelectedItem(pago.getEstado());
            jspNumCuotas.setValue(pago.getNumCuotas());
            txtTotal.setText(pago.getTotal() + "");
            id_matricula = pago.getMatriculaId();
        }

        this.defaultTable.addColumn("Id");
        this.defaultTable.addColumn("Monto");
        this.defaultTable.addColumn("Fecha vencimiento");
        this.defaultTable.addColumn("Fecha Pago");
        this.defaultTable.addColumn("Estado");
        this.tblCuotas.setModel(defaultTable);

        TableColumnModel columModel = tblCuotas.getColumnModel();
        columModel.getColumn(0).setPreferredWidth(15);
        tblCuotas.setRowHeight(25);
        loadTable();

    }

    private void loadTable() {
        try {
            for (int i = this.defaultTable.getRowCount() - 1; i >= 0; i--) {
                this.defaultTable.removeRow(i);
            }
            Cuotas clsCuotas = new Cuotas();
            ArrayList arrayList = clsCuotas.searchByPago(id);

            for (int i = 0; i < arrayList.size(); i++) {
                ECuotas cuota = (ECuotas) arrayList.get(i);
                this.defaultTable.addRow(new Object[]{});
                this.defaultTable.setValueAt(cuota.getId(), i, 0);
                this.defaultTable.setValueAt(cuota.getMonto(), i, 1);
                this.defaultTable.setValueAt(cuota.getFecha_v(), i, 2);
                this.defaultTable.setValueAt(cuota.getFecha_v(), i, 3);
                this.defaultTable.setValueAt(cuota.getEstado(), i, 4);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(), "", JOptionPane.ERROR_MESSAGE);

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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtGH = new javax.swing.JTextField();
        txtEstudiante = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cboEstado = new javax.swing.JComboBox<>();
        jspNumCuotas = new javax.swing.JSpinner();
        as = new javax.swing.JSeparator();
        btnActualizar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCuotas = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtGH1 = new javax.swing.JTextField();
        txtEstudiante1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTotal1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cboEstado1 = new javax.swing.JComboBox<>();
        jspNumCuotas1 = new javax.swing.JSpinner();
        as1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("Estudiante:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 130, -1));

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Grupo Horario:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 130, -1));

        txtGH.setEditable(false);
        txtGH.setBackground(new java.awt.Color(255, 255, 255));
        txtGH.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        jPanel2.add(txtGH, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 240, 30));

        txtEstudiante.setEditable(false);
        txtEstudiante.setBackground(new java.awt.Color(255, 255, 255));
        txtEstudiante.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        jPanel2.add(txtEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 240, 30));

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Total:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 130, -1));

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });
        jPanel2.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 150, 30));

        jLabel4.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Num. Cuotas:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 130, -1));

        jLabel5.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Estado");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 130, -1));

        cboEstado.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        cboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PENDIENTE", "PAGADO" }));
        cboEstado.setSelectedIndex(-1);
        jPanel2.add(cboEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 150, 30));

        jspNumCuotas.setModel(new javax.swing.SpinnerNumberModel(1, 1, 4, 1));
        jPanel2.add(jspNumCuotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 150, 30));

        as.setForeground(new java.awt.Color(153, 153, 153));
        jPanel2.add(as, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 840, 30));

        btnActualizar.setBackground(new java.awt.Color(193, 39, 98));
        btnActualizar.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel2.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 120, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 880, 220));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tblCuotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblCuotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCuotasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCuotas);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 868, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 880, 270));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 523, 860, 10));

        jButton1.setBackground(new java.awt.Color(48, 48, 48));
        jButton1.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("CANCELAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 540, -1, 40));

        btnGuardar.setBackground(new java.awt.Color(193, 39, 98));
        btnGuardar.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 540, 100, 40));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Estudiante:");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 130, -1));

        jLabel7.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setText("Grupo Horario:");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 130, -1));

        txtGH1.setEditable(false);
        txtGH1.setBackground(new java.awt.Color(255, 255, 255));
        txtGH1.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        jPanel4.add(txtGH1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 240, 30));

        txtEstudiante1.setEditable(false);
        txtEstudiante1.setBackground(new java.awt.Color(255, 255, 255));
        txtEstudiante1.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        jPanel4.add(txtEstudiante1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 240, 30));

        jLabel8.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel8.setText("Total:");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 130, -1));

        txtTotal1.setEditable(false);
        txtTotal1.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        jPanel4.add(txtTotal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 150, 30));

        jLabel9.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel9.setText("Num. Cuotas:");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 130, -1));

        jLabel10.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel10.setText("Estado");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 130, -1));

        cboEstado1.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        cboEstado1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PENDIENTE", "PAGADO" }));
        cboEstado1.setSelectedIndex(-1);
        jPanel4.add(cboEstado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 150, 30));

        jspNumCuotas1.setModel(new javax.swing.SpinnerNumberModel(1, 1, 4, 1));
        jPanel4.add(jspNumCuotas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 150, 30));

        as1.setForeground(new java.awt.Color(153, 153, 153));
        jPanel4.add(as1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 840, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 880, 220));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 905, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        int a = JOptionPane.showConfirmDialog(this, "¿Está seguro de cambiar el numero de cuotas?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (a == 1) {
            //no   
        } else {
            //si
            Pagos clsPagos = new Pagos();
            Cuotas clsCuotas = new Cuotas();
            ArrayList arrayList = clsPagos.searchById(id);

            EPagos pago = (EPagos) arrayList.get(0);

            String message = clsCuotas.recalculate(pago, (int) jspNumCuotas.getValue());

            JOptionPane.showMessageDialog(this, message);
            loadTable();
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            Pagos clsPagos = new Pagos();
            Cuotas clsCuotas = new Cuotas();

            int id_pago = id;
            float total = Float.parseFloat(txtTotal.getText());
            int numCuotas = (int) jspNumCuotas.getValue();
            String estado = cboEstado.getSelectedItem().toString();
            int MATRICULAid = id_matricula;

            System.out.println(numCuotas);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void tblCuotasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCuotasMouseClicked
        if (evt.getClickCount() == 2) {
            int id_cuota = (int) tblCuotas.getValueAt(tblCuotas.getSelectedRow(), 0);

            int a = JOptionPane.showConfirmDialog(this, "¿DESEA PAGAR ESTA CUOTA?", "", JOptionPane.YES_OPTION);
            if (a == 0) {
                Cuotas clsCuotas = new Cuotas();
                ArrayList arrayList = clsCuotas.searchById(id_cuota);
                ECuotas cuota = (ECuotas) arrayList.get(0);
                cuota.setEstado("PAGADO");
                clsCuotas.update(cuota);

            }
        }
    }//GEN-LAST:event_tblCuotasMouseClicked

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
            java.util.logging.Logger.getLogger(FrmPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPago().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator as;
    private javax.swing.JSeparator as1;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cboEstado;
    private javax.swing.JComboBox<String> cboEstado1;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSpinner jspNumCuotas;
    private javax.swing.JSpinner jspNumCuotas1;
    private javax.swing.JTable tblCuotas;
    private javax.swing.JTextField txtEstudiante;
    private javax.swing.JTextField txtEstudiante1;
    private javax.swing.JTextField txtGH;
    private javax.swing.JTextField txtGH1;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTotal1;
    // End of variables declaration//GEN-END:variables
}