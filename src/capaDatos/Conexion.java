
package capaDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    
    private static final String URL = "jdbc:postgresql://localhost:5432/db_prueba";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "aa1273";
    
    private static Connection conexion;
    
    public Connection getConexion(){
        if (conexion == null) {
            try{

                Class.forName("org.postgresql.Driver");
                conexion = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return conexion;
    }
    
    
}
