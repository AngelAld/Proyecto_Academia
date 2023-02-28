/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;
import capaDatos.Conexion;
import capaNegocio.EAlumno;
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
public class Alumno {
    Conexion objConex = new Conexion();
    CallableStatement stmt;
    ResultSet rs;
    Connection connect = null;
    
    public Alumno(){
        connect = objConex.getConexion();
    }
    
    public ArrayList getAll(){
        ArrayList arrayList = new ArrayList();
            
        try{
            
            stmt = connect.prepareCall("SELECT * FROM func_listar_alumno_admin()");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                EAlumno objAlumno = new EAlumno();
                objAlumno.setId(rs.getInt("id"));
                objAlumno.setDni(rs.getString("dni"));
                objAlumno.setNombres(rs.getString("nombres"));
                objAlumno.setSexo(rs.getString("sexo"));
                objAlumno.setEstado(rs.getString("estado"));
                objAlumno.setDireccion(rs.getString("direccion"));
                objAlumno.setEmail(rs.getString("email"));
                objAlumno.setTelefono(rs.getString("telefono"));                
                arrayList.add(objAlumno);
            }
            
        }catch(SQLException ex){
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return arrayList;
    }
    
    public ArrayList searchById(int id){
        ArrayList arrayList = new ArrayList();
            
        try{
            
            stmt = connect.prepareCall("SELECT * FROM func_buscar_alumno_admin(?)");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            if(rs.next()){
                EAlumno objAlumno = new EAlumno();
                objAlumno.setId(rs.getInt("id"));
                objAlumno.setDni(rs.getString("dni"));
                objAlumno.setNombres(rs.getString("nombres"));
                objAlumno.setSexo(rs.getString("sexo"));
                objAlumno.setEstado(rs.getString("estado"));
                objAlumno.setDireccion(rs.getString("direccion"));
                objAlumno.setEmail(rs.getString("email"));
                objAlumno.setTelefono(rs.getString("telefono"));                
                arrayList.add(objAlumno);
            }
            
        }catch(SQLException ex){
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return arrayList;
    }
    
    public ArrayList searchByName(String name){
        ArrayList arrayList = new ArrayList();
        
        try{
            
            stmt = connect.prepareCall("SELECT * FROM func_buscar_alumno_nombre_admin (?)");
            stmt.setString(1, name);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                EAlumno objAlumno = new EAlumno();
                objAlumno.setId(rs.getInt("id"));
                objAlumno.setDni(rs.getString("dni"));
                objAlumno.setNombres(rs.getString("nombres"));
                objAlumno.setSexo(rs.getString("sexo"));
                objAlumno.setEstado(rs.getString("estado"));
                objAlumno.setDireccion(rs.getString("direccion"));
                objAlumno.setEmail(rs.getString("email"));
                objAlumno.setTelefono(rs.getString("telefono"));                
                arrayList.add(objAlumno);
            }
            
        }catch(SQLException ex){
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return arrayList;
    }
    
    public String create(EAlumno objaAlumno){
        String message = "";
        
        try{
            
            stmt = connect.prepareCall("call sp_registrar_alumno(?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, objaAlumno.getDni());
            stmt.setString(2, objaAlumno.getNombres());
            stmt.setString(3, objaAlumno.getSexo());
            stmt.setString(4, objaAlumno.getEstado());
            stmt.setString(5, objaAlumno.getDireccion());
            stmt.setString(6, objaAlumno.getEmail());
            stmt.setString(7, objaAlumno.getTelefono());
            stmt.registerOutParameter(8, Types.VARCHAR, 100);
            stmt.executeUpdate();
            message = stmt.getString(8);
                    
        }catch(SQLException ex){
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return message;
    }
    
    public String update(EAlumno objaAlumno){
        String message = "";
        
        try{
            
            stmt = connect.prepareCall("call sp_actualizar_alumno(?, ?, ?, ?,?, ?, ?, ?,?)");
            stmt.setInt(1, objaAlumno.getId());
            stmt.setString(2, objaAlumno.getDni());
            stmt.setString(3, objaAlumno.getNombres());
            stmt.setString(4, objaAlumno.getSexo());
            stmt.setString(5, objaAlumno.getEstado());
            stmt.setString(6, objaAlumno.getDireccion());
            stmt.setString(7, objaAlumno.getEmail());
            stmt.setString(8, objaAlumno.getTelefono());
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
            EAlumno Alumno = (EAlumno)arrayList.get(i);
            comboBox.addElement(new EComboBox(Alumno.getId(), Alumno.getNombres()));
        }
        
        return comboBox;
    }
}
