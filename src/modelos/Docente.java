/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;
import capaDatos.Conexion;
import capaNegocio.EDocente;
import capaNegocio.EComboBox;
import java.sql.CallableStatement;
import java.sql.Connection;
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
 * @author laboratorio_computo
 */
public class Docente {
    Conexion objConex = new Conexion();
    CallableStatement stmt;
    ResultSet rs;
    Connection connect = null;
    
    public Docente(){
        connect = objConex.getConexion();
    }
    
    public ArrayList getAll(){
        ArrayList arrayList = new ArrayList();
            
        try{
            
            stmt = connect.prepareCall("SELECT * FROM func_listar_docente_admin()");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                EDocente objDocente = new EDocente();
                objDocente.setId(rs.getInt("id"));
                objDocente.setDni(rs.getString("dni"));
                objDocente.setNombres(rs.getString("nombres"));
                objDocente.setSexo(rs.getString("sexo"));
                objDocente.setEstado(rs.getString("estado"));
                objDocente.setDireccion(rs.getString("direccion"));
                objDocente.setEmail(rs.getString("email"));
                objDocente.setTelefono(rs.getString("telefono"));                
                arrayList.add(objDocente);
            }
            
        }catch(SQLException ex){
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return arrayList;
    }
    
    public ArrayList searchById(int id){
        ArrayList arrayList = new ArrayList();
            
        try{
            
            stmt = connect.prepareCall("SELECT * FROM func_buscar_docente_admin(?)");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            if(rs.next()){
                 EDocente objDocente = new EDocente();
                objDocente.setId(rs.getInt("id"));
                objDocente.setDni(rs.getString("dni"));
                objDocente.setNombres(rs.getString("nombres"));
                objDocente.setSexo(rs.getString("sexo"));
                objDocente.setEstado(rs.getString("estado"));
                objDocente.setDireccion(rs.getString("direccion"));
                objDocente.setEmail(rs.getString("email"));
                objDocente.setTelefono(rs.getString("telefono"));                
                arrayList.add(objDocente);
            }
            
        }catch(SQLException ex){
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return arrayList;
    }
    
    public ArrayList searchByName(String name){
        ArrayList arrayList = new ArrayList();
        
        try{
            
            stmt = connect.prepareCall("SELECT * FROM func_buscar_docente_nombres_admin  (?)");
            stmt.setString(1, name);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                  EDocente objDocente = new EDocente();
                objDocente.setId(rs.getInt("id"));
                objDocente.setDni(rs.getString("dni"));
                objDocente.setNombres(rs.getString("nombres"));
                objDocente.setSexo(rs.getString("sexo"));
                objDocente.setEstado(rs.getString("estado"));
                objDocente.setDireccion(rs.getString("direccion"));
                objDocente.setEmail(rs.getString("email"));
                objDocente.setTelefono(rs.getString("telefono"));                
                arrayList.add(objDocente);
            }
            
        }catch(SQLException ex){
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return arrayList;
    }
    
    public String create(EDocente objDocente){
        String message = "";
        
        try{
            
            stmt = connect.prepareCall("call sp_registrar_docente(?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, objDocente.getDni());
            stmt.setString(2, objDocente.getNombres());
            stmt.setString(3, objDocente.getSexo());
            stmt.setString(4, objDocente.getEstado());
            stmt.setString(5, objDocente.getDireccion());
            stmt.setString(6, objDocente.getEmail());
            stmt.setString(7, objDocente.getTelefono());
            stmt.registerOutParameter(8, Types.VARCHAR, 100);
            stmt.executeUpdate();
            message = stmt.getString(8);
            
            
            
            
            
            
                    
        }catch(SQLException ex){
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return message;
    }
    
    public String update(EDocente objDocente){
        String message = "";
        
        try{
            
            stmt = connect.prepareCall("call sp_actualizar_docente(?, ?, ?, ?,?, ?, ?, ?,?)");
            stmt.setInt(1, objDocente.getId());
            stmt.setString(2, objDocente.getDni());
            stmt.setString(3, objDocente.getNombres());
            stmt.setString(4, objDocente.getSexo());
            stmt.setString(5, objDocente.getEstado());
            stmt.setString(6, objDocente.getDireccion());
            stmt.setString(7, objDocente.getEmail());
            stmt.setString(8, objDocente.getTelefono());
            stmt.registerOutParameter(9, Types.VARCHAR, 100);
            stmt.executeUpdate();
            message = stmt.getString(9);
                    
        }catch(SQLException ex){
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return message;
    }
    
    public ComboBoxModel fillCombobox(){
        DefaultComboBoxModel comboBox = new DefaultComboBoxModel();
        
        ArrayList arrayList = this.getAll();
        for (int i = 0; i < arrayList.size(); i++) {
            EDocente Docente = (EDocente)arrayList.get(i);
            comboBox.addElement(new EComboBox(Docente.getId(), Docente.getNombres()));
        }
        
        return comboBox;
    }
}
