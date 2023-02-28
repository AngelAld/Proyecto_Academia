/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import capaDatos.Conexion;
import capaNegocio.EMatricula;
import capaNegocio.EComboBox;
import capaNegocio.EGrupohorario;
import capaNegocio.EPagos;
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

/**
 *
 * @author IVAN
 */
public class Matricula {

    Conexion objConex = new Conexion();
    CallableStatement stmt;
    ResultSet rs;
    Connection connect = null;

    public Matricula() {
        connect = objConex.getConexion();
    }

    public ArrayList getAll() {
        ArrayList arrayList = new ArrayList();

        try {

            stmt = connect.prepareCall("SELECT * FROM func_listar_matricula_admin()");
            rs = stmt.executeQuery();

            while (rs.next()) {
                EMatricula objmatri = new EMatricula();
                objmatri.setId(rs.getInt("id"));
                objmatri.setId_gh(rs.getInt("id_gh"));
                objmatri.setId_alumno(rs.getInt("id_alumno"));
                objmatri.setEstado(rs.getString("estado"));
                objmatri.setF_matricula(rs.getString("f_matricula"));
                objmatri.setGrupo_horario(rs.getString("grupo_horario"));
                objmatri.setAlumno(rs.getString("alumno"));
                arrayList.add(objmatri);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arrayList;
    }

    public ArrayList searchById(int id) {
        ArrayList arrayList = new ArrayList();

        try {

            stmt = connect.prepareCall("SELECT * FROM func_buscar_matricula_admin(?)");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                EMatricula objmatri = new EMatricula();
                objmatri.setId(rs.getInt("id"));
                objmatri.setId_gh(rs.getInt("id_gh"));
                objmatri.setId_alumno(rs.getInt("id_alumno"));
                objmatri.setEstado(rs.getString("estado"));
                objmatri.setF_matricula(rs.getString("f_matricula"));
                objmatri.setGrupo_horario(rs.getString("grupo_horario"));
                objmatri.setAlumno(rs.getString("alumno"));
                arrayList.add(objmatri);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arrayList;
    }

    public ArrayList searchByName(String name) {
        ArrayList arrayList = new ArrayList();

        try {

            stmt = connect.prepareCall("SELECT * FROM func_buscar_matricula_alumno_admin  (?)");
            stmt.setString(1, name);
            rs = stmt.executeQuery();

            while (rs.next()) {
                EMatricula objmatri = new EMatricula();
                objmatri.setId(rs.getInt("id"));
                objmatri.setId_gh(rs.getInt("id_gh"));
                objmatri.setId_alumno(rs.getInt("id_alumno"));
                objmatri.setEstado(rs.getString("estado"));
                objmatri.setF_matricula(rs.getString("f_matricula"));
                objmatri.setGrupo_horario(rs.getString("grupo_horario"));
                objmatri.setAlumno(rs.getString("alumno"));
                arrayList.add(objmatri);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arrayList;
    }

    public String create(EMatricula objmaMatricula) {
        String message = "";

        try {

            stmt = connect.prepareCall("call sp_registrar_matricula(?, ?, ?, ?, ?)");
            //stmt.setInt(1, objmaMatricula.getId());
            stmt.setInt(1, objmaMatricula.getId_gh());
            stmt.setInt(2, objmaMatricula.getId_alumno());
            stmt.setString(3, objmaMatricula.getEstado());
            stmt.setDate(4, Date.valueOf(objmaMatricula.getF_matricula()));
            stmt.registerOutParameter(5, Types.VARCHAR, 100);
            stmt.executeUpdate();
            message = stmt.getString(5);

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        return message;
    }

    public String generate(EMatricula objmaMatricula) {
        String message = "";
        try {
            System.out.println(objmaMatricula.getAlumno());
            ArrayList array = searchByName(objmaMatricula.getAlumno());
            EMatricula mat = (EMatricula) array.get(0);
            Grupohorario clsGrupo = new Grupohorario();
            ArrayList grupo = clsGrupo.searchById(objmaMatricula.getId_gh());
            EGrupohorario gh = (EGrupohorario) grupo.get(0);
            Pagos clsPagos = new Pagos();
            EPagos pago = new EPagos();
            pago.setEstado("PENDIENTE");
            pago.setMatriculaId(mat.getId());
            pago.setNumCuotas(1);
            pago.setTotal(gh.getCosto());
            clsPagos.create(pago);
            message = "PAGO GENERADO";
            
        } catch (Exception e) {
            message = e.toString();
        }

        return message;

    }

    public String update(EMatricula objmaMatricula) {
        String message = "";

        try {

            stmt = connect.prepareCall("call sp_actualizar_matricula(?, ?, ?, ?,?, ?)");
            stmt.setInt(1, objmaMatricula.getId());
            stmt.setInt(2, objmaMatricula.getId_gh());
            stmt.setInt(3, objmaMatricula.getId_alumno());
            stmt.setString(4, objmaMatricula.getEstado());
            stmt.setDate(5, Date.valueOf(objmaMatricula.getF_matricula()));
            stmt.registerOutParameter(6, Types.VARCHAR, 100);
            stmt.executeUpdate();
            message = stmt.getString(6);

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        return message;
    }

    public ComboBoxModel fillCombobox() {
        DefaultComboBoxModel comboBox = new DefaultComboBoxModel();

        ArrayList arrayList = this.getAll();
        for (int i = 0; i < arrayList.size(); i++) {
            EMatricula matricul = (EMatricula) arrayList.get(i);
            comboBox.addElement(new EComboBox(matricul.getId(), matricul.getAlumno()));
        }

        return comboBox;
    }
}
