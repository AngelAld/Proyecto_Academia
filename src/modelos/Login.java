/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author laboratorio_computo
 */
import capaDatos.Conexion;
import capaNegocio.ELogin;
import capaNegocio.EUsuarios;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Juan
 */
public class Login {
    
    Conexion objConex = new Conexion();
    CallableStatement stmt;
    ResultSet rs;
    Connection connect = null;
    
    public Login() throws SQLException, ClassNotFoundException{
        connect = objConex.getConexion();
    }
    
    public ArrayList iniciarSesion(ELogin objLogin)
    {
        ArrayList arrayList = new ArrayList();
            
        try{
            System.out.println(objLogin.getUsername());
            System.out.println(objLogin.getPassword());
            stmt = connect.prepareCall("SELECT * FROM func_login(?, ?)");
            stmt.setString(1, objLogin.getUsername());
            stmt.setString(2, objLogin.getPassword());
            rs = stmt.executeQuery();
            
            if(rs.next()){
                EUsuarios objUser = new EUsuarios();
                objUser.setId(rs.getInt("id"));
                objUser.setNombres(rs.getString("nombres"));
                objUser.setUsuario(rs.getString("usuario"));
                objUser.setEstado(rs.getString("estado"));
                arrayList.add(objUser);
            }
            
        }catch(SQLException ex){
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return arrayList;
    }
}