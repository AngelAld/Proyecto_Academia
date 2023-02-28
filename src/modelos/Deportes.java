/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import capaDatos.Conexion;
import capaNegocio.EDeportes;
import capaNegocio.EComboBox;
import java.lang.System.Logger;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 *
 * @author laboratorio_computo
 */
public class Deportes {

    Conexion objConexion = new Conexion();
    CallableStatement stmt;
    ResultSet rs;
    Connection connect = null;

    public Deportes() {
        connect = objConexion.getConexion();
    }

    public ArrayList getAll() {
        ArrayList arrayList = new ArrayList();
        try {
            stmt = connect.prepareCall("SELECT * FROM func_listar_deporte_admin()");

            rs = stmt.executeQuery();

            while (rs.next()) {
                EDeportes objDeporte = new EDeportes();
                objDeporte.setId(rs.getInt("id"));
                objDeporte.setNombre(rs.getString("nombre"));
                objDeporte.setDescripcion(rs.getString("descripcion"));
                objDeporte.setEstado(rs.getString("estado"));
                arrayList.add(objDeporte);
            }
        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
        }
        return arrayList;
    }

    public ArrayList searchById(int id) {
        ArrayList arrayList = new ArrayList();

        try {
            stmt = connect.prepareCall("SELECT * FROM func_buscar_deporte_admin(?)");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                EDeportes objDeporte = new EDeportes();
                objDeporte.setId(rs.getInt("id"));
                objDeporte.setNombre(rs.getString("nombre"));
                objDeporte.setDescripcion(rs.getString("descripcion"));
                objDeporte.setEstado(rs.getString("estado"));
                arrayList.add(objDeporte);
            }

        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);

        }

        return arrayList;
    }

    public ArrayList searchByName(String name) {
        ArrayList arrayList = new ArrayList();

        try {
            stmt = connect.prepareCall("SELECT * FROM func_buscar_deporte_nombre_admin(?)");
            stmt.setString(1, name);
            rs = stmt.executeQuery();

            while (rs.next()) {
                EDeportes objDeporte = new EDeportes();
                objDeporte.setId(rs.getInt("id"));
                objDeporte.setNombre(rs.getString("nombre"));
                objDeporte.setDescripcion(rs.getString("descripcion"));
                objDeporte.setEstado(rs.getString("estado"));
                arrayList.add(objDeporte);
            }

        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);

        }

        return arrayList;
    }

    public String create(EDeportes objDeporte) {
        String message = "";
        try {
            stmt = connect.prepareCall("call sp_registrar_deporte(?, ?, ?, ?)");
            stmt.setString(1, objDeporte.getNombre());
            stmt.setString(2, objDeporte.getDescripcion());
            stmt.setString(3, objDeporte.getEstado());
            stmt.registerOutParameter(4, Types.VARCHAR);
            stmt.executeUpdate();
            message = stmt.getString(4);

        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);

        }

        return message;
    }

    
    public String update(EDeportes objDeporte) {
        String message = "";
        try {
            stmt = connect.prepareCall("call sp_actualizar_deporte(?, ?, ?, ?, ?)");
            stmt.setInt(1, objDeporte.getId());
            stmt.setString(2, objDeporte.getNombre());
            stmt.setString(3, objDeporte.getDescripcion());
            stmt.setString(4, objDeporte.getEstado());
            stmt.registerOutParameter(5, Types.VARCHAR);
            stmt.executeUpdate();
            message = stmt.getString(5);

        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);

        }

        return message;
    }
}
