/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import capaDatos.Conexion;
import capaNegocio.EPagos;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 *
 * @author an
 */
public class Pagos {

    Conexion objConexion = new Conexion();
    CallableStatement stmt;
    ResultSet rs;
    Connection connect = null;

    public Pagos() {
        connect = objConexion.getConexion();
    }

    public ArrayList getAll() {
        ArrayList arrayList = new ArrayList();
        try {
            stmt = connect.prepareCall("SELECT * FROM func_listar_pago_admin()");
            rs = stmt.executeQuery();

            while (rs.next()) {
                EPagos objPago = new EPagos();

                objPago.setId(rs.getInt("id"));
                objPago.setTotal(rs.getFloat("total"));
                objPago.setNumCuotas(rs.getInt("numCuotas"));
                objPago.setEstado(rs.getString("estado"));
                objPago.setMatriculaId(rs.getInt("MATRICULAid"));
                objPago.setAlumno(rs.getString("alumno"));
                objPago.setGrupo_horario(rs.getString("grupo_horario"));

                arrayList.add(objPago);

            }

        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
        }
        return arrayList;
    }

    public ArrayList searchById(int id) {
        ArrayList arrayList = new ArrayList();

        try {
            stmt = connect.prepareCall("SELECT * FROM func_buscar_pago_admin(?)");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                EPagos objPago = new EPagos();

                objPago.setId(rs.getInt("id"));
                objPago.setTotal(rs.getFloat("total"));
                objPago.setNumCuotas(rs.getInt("numCuotas"));
                objPago.setEstado(rs.getString("estado"));
                objPago.setMatriculaId(rs.getInt("MATRICULAid"));
                objPago.setAlumno(rs.getString("alumno"));
                objPago.setGrupo_horario(rs.getString("grupo_horario"));

                arrayList.add(objPago);

            }

        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
        }
        return arrayList;
    }

    public ArrayList searchByAlumno(String alumno) {
        ArrayList arrayList = new ArrayList();

        try {
            stmt = connect.prepareCall("SELECT * FROM func_buscar_pago_alumno_admin(?)");
            stmt.setString(1, alumno);
            rs = stmt.executeQuery();

            while (rs.next()) {
                EPagos objPago = new EPagos();

                objPago.setId(rs.getInt("id"));
                objPago.setTotal(rs.getFloat("total"));
                objPago.setNumCuotas(rs.getInt("numCuotas"));
                objPago.setEstado(rs.getString("estado"));
                objPago.setMatriculaId(rs.getInt("MATRICULAid"));
                objPago.setAlumno(rs.getString("alumno"));
                objPago.setGrupo_horario(rs.getString("grupo_horario"));

                arrayList.add(objPago);

            }

        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
        }

        return arrayList;
    }

    public String create(EPagos objPago) {
        String message = "";
        try {
            stmt = connect.prepareCall("call sp_registrar_pago(cast(? as numeric), ?, ?, ?, ?)");

            stmt.setFloat(1, objPago.getTotal());
            stmt.setInt(2, objPago.getNumCuotas());
            stmt.setString(3, objPago.getEstado());
            stmt.setInt(4, objPago.getMatriculaId());
            stmt.registerOutParameter(5, Types.VARCHAR);
            stmt.executeUpdate();
            message = stmt.getString(5);
        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
        }
        return message;
    }

    public String update(EPagos objPago) {
        String message = "";
        try {
            stmt = connect.prepareCall("call sp_actualizar_pago(?, cast(? as numeric), ?, ?, ?, ?)");

            stmt.setInt(1, objPago.getId());
            stmt.setFloat(2, objPago.getTotal());
            stmt.setInt(3, objPago.getNumCuotas());
            stmt.setString(4, objPago.getEstado());
            stmt.setInt(5, objPago.getMatriculaId());
            stmt.registerOutParameter(6, Types.VARCHAR);
            stmt.executeUpdate();
            message = stmt.getString(6);
        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
        }
        return message;
    }

}
