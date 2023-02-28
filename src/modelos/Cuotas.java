package modelos;

import capaDatos.Conexion;
import capaNegocio.ECuotas;
import capaNegocio.EGrupohorario;
import capaNegocio.EMatricula;
import capaNegocio.EPagos;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 *
 * @author an
 */
public class Cuotas {

    private final String pattern = "yyyy-MM-dd";
    DateFormat formatter = new SimpleDateFormat(pattern);
    Conexion objConexion = new Conexion();
    CallableStatement stmt;
    ResultSet rs;
    Connection connect = null;

    public Cuotas() {
        connect = objConexion.getConexion();
    }

    public ArrayList getAll() {
        ArrayList arrayList = new ArrayList();

        return arrayList;
    }

    public ArrayList searchById(int id) {
        ArrayList arrayList = new ArrayList();
        try {
            stmt = connect.prepareCall("SELECT * FROM func_buscar_cuota(?) WHERE estado != 'ELIMINADO'");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ECuotas objCuota = new ECuotas();

                objCuota.setId(rs.getInt("id"));
                objCuota.setMonto(rs.getFloat("monto"));
                objCuota.setFecha_v(rs.getString("fecha_v"));
                objCuota.setFecha_p(rs.getString("fecha_p"));
                objCuota.setEstado(rs.getString("estado"));
                objCuota.setId_pago(rs.getInt("id_pago"));

                arrayList.add(objCuota);

            }

        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
        }

        return arrayList;
    }
    
    
    
    
    
    
    public ArrayList searchByPago(int pago_id) {
        ArrayList arrayList = new ArrayList();
        try {
            stmt = connect.prepareCall("SELECT * FROM func_buscar_cuota_pago(?) WHERE estado != 'ELIMINADO'");
            stmt.setInt(1, pago_id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ECuotas objCuota = new ECuotas();

                objCuota.setId(rs.getInt("id"));
                objCuota.setMonto(rs.getFloat("monto"));
                objCuota.setFecha_v(rs.getString("fecha_v"));
                objCuota.setFecha_p(rs.getString("fecha_p"));
                objCuota.setEstado(rs.getString("estado"));
                objCuota.setId_pago(rs.getInt("id_pago"));

                arrayList.add(objCuota);

            }

        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
        }

        return arrayList;
    }

    public String create(ECuotas objCuota) {
        String message = "";
        try {
            stmt = connect.prepareCall("call sp_registrar_cuota(cast(? as numeric), ?, null, ?, ?, ?)");
            stmt.setFloat(1, objCuota.getMonto());
            stmt.setDate(2, Date.valueOf(objCuota.getFecha_v()));
            //stmt.setDate(3, Date.valueOf(objCuota.getFecha_p()));
            stmt.setString(3, objCuota.getEstado());
            stmt.setInt(4, objCuota.getId_pago());
            stmt.registerOutParameter(5, Types.VARCHAR);
            stmt.executeUpdate();
            message = stmt.getString(5);
        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
        }
        return message;
    }

    public String update(ECuotas objCuota) {
        String message = "";
        try {
            stmt = connect.prepareCall("call sp_actualizar_cuota(?, cast(? as numeric), ?, ?, ?, ?, ?)");

            stmt.setInt(1, objCuota.getId());
            stmt.setFloat(2, objCuota.getMonto());
            stmt.setDate(3, Date.valueOf(objCuota.getFecha_v()));
            if (objCuota.getFecha_p() == null) {
                stmt.setNull(4, Types.DATE);
            } else {
                stmt.setDate(4, Date.valueOf(objCuota.getFecha_p()));
            }
            stmt.setString(5, objCuota.getEstado());
            stmt.setInt(6, objCuota.getId_pago());
            stmt.registerOutParameter(7, Types.VARCHAR);
            stmt.executeUpdate();
            message = stmt.getString(7);
        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
        }
        return message;
    }

    public String recalculate(EPagos objPago, int num) {
        String message = "";
        ArrayList arrayList;
        ArrayList pendientes = new ArrayList();
        ArrayList nuevo = new ArrayList();
        int contador = 0;
        float deuda = 0;
        float deudaI = 0;
        try {

            Grupohorario clsGrupo = new Grupohorario();
            Matricula clsMatricula = new Matricula();

            ArrayList matricula = clsMatricula.searchById(objPago.getMatriculaId());
            EMatricula mat = (EMatricula) matricula.get(0);
            ArrayList grupo = clsGrupo.searchById(mat.getId_gh());
            EGrupohorario gh = (EGrupohorario) grupo.get(0);
            String fechaV = formatter.format(gh.get_fin());
            arrayList = searchByPago(objPago.getId());

            if (num < objPago.getNumCuotas()) {
                message = "FUNCIÓN NO SOPORTADA";
                return message;
            }

            if (!(arrayList.isEmpty())) {
                for (int i = 0; i < arrayList.size(); i++) {
                    ECuotas cuota = (ECuotas) arrayList.get(i);
                    if ((!(cuota.getEstado().equalsIgnoreCase("PAGADO"))) && (!(cuota.getEstado().equalsIgnoreCase("ELIMINADO")))) {
                        pendientes.add(cuota);
                        contador = contador + 1;
                        cuota.setEstado("ELIMINADO");
                        update(cuota);
                    }
                }
                for (int j = 0; j < pendientes.size(); j++) {
                    ECuotas cuota = (ECuotas) arrayList.get(j);
                    deuda = deuda + cuota.getMonto();
                }

            } else {
                deuda = objPago.getTotal();
            }

            int iterator = 0;

            if (contador == 0 && (arrayList.isEmpty())) {
                iterator = num;
            } else {
                if (contador == 0 && !(arrayList.isEmpty())) {
                    message = "TODAS LAS CUOTAS PAGADAS";
                    return message;
                } else {
                    iterator = contador;
                }

            }

            deudaI = (float) (Math.round((deuda / (float) iterator) * 100.0) / 100.0);

            for (int i = 0; i < iterator; i++) {
                ECuotas cuota = new ECuotas();
                cuota.setEstado("PENDIENTE");
                cuota.setFecha_v(fechaV);
                System.out.println(cuota.getFecha_v());
                cuota.setId_pago(objPago.getId());
                cuota.setMonto(deudaI);
                create(cuota);
            }

            message = "Cuotas generadas correctamente";
        } catch (Exception e) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            message = e.toString();
        }

        return message;
    }

}
