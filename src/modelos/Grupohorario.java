/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import capaDatos.Conexion;
import capaNegocio.EComboBox;
import capaNegocio.EGrupohorario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author IVAN
 */
public class Grupohorario {

    Conexion objConex = new Conexion();
    CallableStatement stmt;
    ResultSet rs;
    Connection connect = null;

    public Grupohorario() {
        connect = objConex.getConexion();
    }

    public ArrayList getAll() {
        ArrayList arrayList = new ArrayList();

        try {

            stmt = connect.prepareCall("SELECT * FROM func_listar_grupo_horario_admin()");
            rs = stmt.executeQuery();

            while (rs.next()) {
                EGrupohorario objgrupo = new EGrupohorario();
                objgrupo.setId(rs.getInt("id"));
                objgrupo.setNombre(rs.getString("nombre"));
                objgrupo.setId_deporte(rs.getInt("id_deporte"));
                objgrupo.setId_docente(rs.getInt("id_docente"));
                objgrupo.setF_inicio(rs.getString("f_inicio"));
                objgrupo.setF_fin(rs.getString("f_fin"));
                objgrupo.setHora_inicio(rs.getInt("hora_inicio"));
                objgrupo.setHora_fin(rs.getInt("hora_fin"));
                objgrupo.setEstado(rs.getString("estado"));
                objgrupo.setId_ambiente(rs.getInt("id_ambiente"));
                objgrupo.setDeporte(rs.getString("deporte"));
                objgrupo.setDocente(rs.getString("docente"));
                objgrupo.setAmbiente(rs.getString("ambiente"));
                objgrupo.setCosto(rs.getFloat("costo"));
                arrayList.add(objgrupo);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arrayList;
    }

    public ArrayList searchById(int id) {
        ArrayList arrayList = new ArrayList();

        try {

            stmt = connect.prepareCall("SELECT * FROM func_buscar_grupo_horario_admin(?)");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                EGrupohorario objgrupo = new EGrupohorario();
                objgrupo.setId(rs.getInt("id"));
                objgrupo.setNombre(rs.getString("nombre"));
                objgrupo.setId_deporte(rs.getInt("id_deporte"));
                objgrupo.setId_docente(rs.getInt("id_docente"));
                objgrupo.setF_inicio(rs.getString("f_inicio"));
                objgrupo.setF_fin(rs.getString("f_fin"));
                objgrupo.setHora_inicio(rs.getInt("hora_inicio"));
                objgrupo.setHora_fin(rs.getInt("hora_fin"));
                objgrupo.setEstado(rs.getString("estado"));
                objgrupo.setId_ambiente(rs.getInt("id_ambiente"));
                objgrupo.setDeporte(rs.getString("deporte"));
                objgrupo.setDocente(rs.getString("docente"));
                objgrupo.setAmbiente(rs.getString("ambiente"));
                objgrupo.setCosto(rs.getFloat("costo"));
                arrayList.add(objgrupo);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arrayList;
    }

    public ArrayList searchByName(String name) {
        ArrayList arrayList = new ArrayList();

        try {

            stmt = connect.prepareCall("SELECT * FROM func_buscar_grupo_horario_nombres_admin  (?)");
            stmt.setString(1, name);
            rs = stmt.executeQuery();

            while (rs.next()) {
                EGrupohorario objgrupo = new EGrupohorario();
                objgrupo.setId(rs.getInt("id"));
                objgrupo.setNombre(rs.getString("nombre"));
                objgrupo.setId_deporte(rs.getInt("id_deporte"));
                objgrupo.setId_docente(rs.getInt("id_docente"));
                objgrupo.setF_inicio(rs.getString("f_inicio"));
                objgrupo.setF_fin(rs.getString("f_fin"));
                objgrupo.setHora_inicio(rs.getInt("hora_inicio"));
                objgrupo.setHora_fin(rs.getInt("hora_fin"));
                objgrupo.setEstado(rs.getString("estado"));
                objgrupo.setId_ambiente(rs.getInt("id_ambiente"));
                objgrupo.setDeporte(rs.getString("deporte"));
                objgrupo.setDocente(rs.getString("docente"));
                objgrupo.setAmbiente(rs.getString("ambiente"));
                objgrupo.setCosto(rs.getFloat("costo"));
                arrayList.add(objgrupo);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arrayList;
    }

    public String create(EGrupohorario objGrupohorario) {
        String message = "";

        try {

            stmt = connect.prepareCall("call sp_registrar_grupo_horario(?, ?, ?, ?, ?, ?, ?, ?,?, cast(? as numeric), ?)");
            stmt.setString(1, objGrupohorario.getNombre());
            stmt.setInt(2, objGrupohorario.getId_deporte());
            stmt.setInt(3, objGrupohorario.getId_docente());
            stmt.setDate(4, Date.valueOf(objGrupohorario.getF_inicio()));
            stmt.setDate(5, Date.valueOf(objGrupohorario.getF_fin()));
            stmt.setInt(6, objGrupohorario.getHora_inicio());
            stmt.setInt(7, objGrupohorario.getHora_fin());
            stmt.setString(8, objGrupohorario.getEstado());
            stmt.setInt(9, objGrupohorario.getId_ambiente());
            stmt.setFloat(10, objGrupohorario.getCosto());
            stmt.registerOutParameter(11, Types.VARCHAR, 100);
            stmt.executeUpdate();
            message = stmt.getString(11);

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        return message;
    }

    public String update(EGrupohorario objGrupohorario) {
        String message = "";

        try {

            stmt = connect.prepareCall("call sp_actualizar_grupo_horario(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, cast(? as numeric), ?)");
            stmt.setInt(1, objGrupohorario.getId());
            stmt.setString(2, objGrupohorario.getNombre());
            stmt.setInt(3, objGrupohorario.getId_deporte());
            stmt.setInt(4, objGrupohorario.getId_docente());
            stmt.setDate(5, Date.valueOf(objGrupohorario.getF_inicio()));
            stmt.setDate(6, Date.valueOf(objGrupohorario.getF_fin()));
            stmt.setInt(7, objGrupohorario.getHora_inicio());
            stmt.setInt(8, objGrupohorario.getHora_fin());
            stmt.setString(9, objGrupohorario.getEstado());
            stmt.setInt(10, objGrupohorario.getId_ambiente());
            stmt.setFloat(11, objGrupohorario.getCosto());
            stmt.registerOutParameter(12, Types.VARCHAR, 100);
            stmt.executeUpdate();
            message = stmt.getString(12);

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        return message;
    }

    public ComboBoxModel fillCombobox() {
        DefaultComboBoxModel comboBox = new DefaultComboBoxModel();

        ArrayList arrayList = this.getAll();
        for (int i = 0; i < arrayList.size(); i++) {
            EGrupohorario grupo = (EGrupohorario) arrayList.get(i);
            comboBox.addElement(new EComboBox(grupo.getId(), grupo.getNombre()));
        }

        return comboBox;
    }
}
