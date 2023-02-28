/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import capaDatos.Conexion;
import capaNegocio.EAmbiente;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author laboratorio_computo
 */
public class Ambiente {

    Conexion objConex = new Conexion();
    CallableStatement stmt;
    ResultSet rs;
    Connection connect = null;

    public Ambiente() {
        connect = objConex.getConexion();
    }

    public ArrayList getAll() {
        ArrayList arrayList = new ArrayList();

        try {

            stmt = connect.prepareCall("select * from func_listar_ambiente_admin()");
            rs = stmt.executeQuery();

            while (rs.next()) {
                EAmbiente objAmbiente = new EAmbiente();
                objAmbiente.setId(rs.getInt("ID"));
                objAmbiente.setNombre(rs.getString("nombre"));
                objAmbiente.setDescripcion(rs.getString("descripcion"));
                objAmbiente.setCapacidad(rs.getInt("capacidad"));
                objAmbiente.setEstado(rs.getString("estado"));
                arrayList.add(objAmbiente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            //Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arrayList;
    }

    public ArrayList searchById(int id) {
        ArrayList arrayList = new ArrayList();

        try {

            stmt = connect.prepareCall("SELECT * FROM func_buscar_ambiente_admin(?)");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                EAmbiente objAmbiente = new EAmbiente();
                objAmbiente.setId(rs.getInt("ID"));
                objAmbiente.setNombre(rs.getString("nombre"));
                objAmbiente.setDescripcion(rs.getString("descripcion"));
                objAmbiente.setCapacidad(rs.getInt("capacidad"));
                objAmbiente.setEstado(rs.getString("estado"));
                arrayList.add(objAmbiente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arrayList;
    }

    public ArrayList searchByName(String name) {
        ArrayList arrayList = new ArrayList();

        try {

            stmt = connect.prepareCall("SELECT * FROM func_buscar_ambiente_nombre_admin (?)");
            stmt.setString(1, name);
            rs = stmt.executeQuery();

            while (rs.next()) {
                EAmbiente objAmbiente = new EAmbiente();
                objAmbiente.setId(rs.getInt("ID"));
                objAmbiente.setNombre(rs.getString("nombre"));
                objAmbiente.setDescripcion(rs.getString("descripcion"));
                objAmbiente.setCapacidad(rs.getInt("capacidad"));
                objAmbiente.setEstado(rs.getString("estado"));
                arrayList.add(objAmbiente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arrayList;
    }

    public String create(EAmbiente objAmbiente) {
        String message = "";

        try {

            stmt = connect.prepareCall("call sp_registrar_ambiente(?, ?, ?, ?, ?)");
            stmt.setString(1, objAmbiente.getNombre());
            stmt.setString(2, objAmbiente.getDescripcion());
            stmt.setInt(3, objAmbiente.getCapacidad());
            stmt.setString(4, objAmbiente.getEstado());
            stmt.registerOutParameter(5, Types.VARCHAR);
            stmt.executeUpdate();
            message = stmt.getString(5);

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        return message;
    }

    public String update(EAmbiente objAmbiente) {
        String message = "";

        try {

            stmt = connect.prepareCall("call sp_actualizar_ambiente(?, ?, ?, ?, ?,?)");
            stmt.setInt(1, objAmbiente.getId());
            stmt.setString(2, objAmbiente.getNombre());
            stmt.setString(3, objAmbiente.getDescripcion());
            stmt.setInt(4, objAmbiente.getCapacidad());
            stmt.setString(5, objAmbiente.getEstado());
            stmt.registerOutParameter(6, Types.VARCHAR, 100);
            stmt.executeUpdate();
            message = stmt.getString(6);

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);

        }

        return message;
    }

}
