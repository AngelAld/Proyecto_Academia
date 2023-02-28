/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package capaPresentacion;

import capaNegocio.EUsuarios;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import modelos.Usuarios;

/**
 *
 * @author an
 */
public class FrmListadoUsuarios extends javax.swing.JInternalFrame implements IFormActive{

    Usuarios clsUsuarios = new Usuarios();

    DefaultTableModel defaultTable = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    /**
     * Creates new form FrmListadoUsuarios
     */
    public FrmListadoUsuarios() {
        initComponents();
        this.setTitle("Usuarios");
        this.defaultTable.addColumn("Id");
        this.defaultTable.addColumn("Tipo de Usuario");
        this.defaultTable.addColumn("Nombres");
        this.defaultTable.addColumn("Usuario");
        this.defaultTable.addColumn("Correo");
        this.defaultTable.addColumn("Estado");
        this.tblUsuarios.setModel(defaultTable);
        
        tblUsuarios.setRowHeight(25);
        TableColumnModel columnModel = tblUsuarios.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(15);
        
        loadTable();
    }

    
    
    @Override
    public final void loadTable()
    {
        try{
            
            for (int i=this.defaultTable.getRowCount()-1;i>=0;i--){
                this.defaultTable.removeRow(i);
            }
            
            ArrayList arrayList = clsUsuarios.getAll();
            
            for (int i = 0; i < arrayList.size(); i++) {
                EUsuarios usuario = (EUsuarios)arrayList.get(i);
                this.defaultTable.addRow(new Object[]{});
                this.defaultTable.setValueAt(usuario.getId(), i, 0);
                this.defaultTable.setValueAt(usuario.getTipoRol(), i, 1);
                this.defaultTable.setValueAt(usuario.getNombres(), i, 2);
                this.defaultTable.setValueAt(usuario.getUsuario(), i, 3);
                this.defaultTable.setValueAt(usuario.getCorreo(), i, 4);
                this.defaultTable.setValueAt(usuario.getEstado(), i, 5);
            }
            
            
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString(), Module.titleMessage, JOptionPane.ERROR_MESSAGE);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "TIPO USUARIO", "NOMBRES", "USUARIO", "CORREO", "ESTADO"
            }
        ));
        tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsuarios);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 1030, 650));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("BUSCAR");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 43, -1, -1));

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        jPanel1.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 34, 397, 35));

        btnNuevo.setBackground(new java.awt.Color(193, 39, 98));
        btnNuevo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevo.setText("NUEVO");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, 94, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int id = (int) tblUsuarios.getValueAt(tblUsuarios.getSelectedRow(), 0);
            Module.id = id;

            EForm formActive = Module.formActive;
            formActive.setCaller(this);

            FrmUsuarios formUser = new FrmUsuarios();
            formUser.setVisible(true);
        }
    }//GEN-LAST:event_tblUsuariosMouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        try {

            String txtNombre = this.txtSearch.getText().trim();
            if (txtNombre.equals("")) {
                loadTable();
                return;
            }

            for (int i = this.defaultTable.getRowCount() - 1; i >= 0; i--) {
                this.defaultTable.removeRow(i);
            }

            Usuarios clsUsuario = new Usuarios();
            ArrayList arrayList = clsUsuario.searchByName(txtNombre);

            for (int i = 0; i < arrayList.size(); i++) {
                EUsuarios usuario = (EUsuarios) arrayList.get(i);
                this.defaultTable.addRow(new Object[]{});
                this.defaultTable.setValueAt(usuario.getId(), i, 0);
                this.defaultTable.setValueAt(usuario.getTipoRol(), i, 1);
                this.defaultTable.setValueAt(usuario.getNombres(), i, 2);
                this.defaultTable.setValueAt(usuario.getUsuario(), i, 3);
                this.defaultTable.setValueAt(usuario.getCorreo(), i, 4);
                this.defaultTable.setValueAt(usuario.getEstado(), i, 5);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), Module.titleMessage, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        EForm formActive = Module.formActive;
        formActive.setCaller(this);
        Module.id = 0;

        FrmUsuarios formUser = new FrmUsuarios();
        formUser.setVisible(true);
    }//GEN-LAST:event_btnNuevoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}