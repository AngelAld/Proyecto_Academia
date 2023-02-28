/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capaNegocio;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author laboratorio_computo
 */
public class EGrupohorario {

    private int id;
    private String nombre;
    private int id_deporte;
    private int id_docente;
    private String f_inicio;
    private String f_fin;
    private int hora_inicio;
    private int hora_fin;
    private String estado;
    private int id_ambiente;
    private String deporte;
    private String docente;
    private String ambiente;
    private float costo;

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }
    private final String pattern = "yyyy-MM-dd";
    DateFormat formatter = new SimpleDateFormat(pattern);

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the id_deporte
     */
    public int getId_deporte() {
        return id_deporte;
    }

    /**
     * @param id_deporte the id_deporte to set
     */
    public void setId_deporte(int id_deporte) {
        this.id_deporte = id_deporte;
    }

    /**
     * @return the id_docente
     */
    public int getId_docente() {
        return id_docente;
    }

    /**
     * @param id_docente the id_docente to set
     */
    public void setId_docente(int id_docente) {
        this.id_docente = id_docente;
    }

    /**
     * @return the f_inicio
     */
    public String getF_inicio() {
        return f_inicio;
    }

    /**
     * @param f_inicio the f_inicio to set
     */
    public void setF_inicio(String f_inicio) {
        this.f_inicio = f_inicio;
    }

    /**
     * @return the f_fin
     */
    public String getF_fin() {
        return f_fin;
    }

    /**
     * @param f_fin the f_fin to set
     */
    public void setF_fin(String f_fin) {
        this.f_fin = f_fin;
    }

    /**
     * @return the hora_inicio
     */
    /**
     * @param hora_fin the hora_fin to set
     */
    public void setHora_fin(String hora_fin) {
        this.setHora_fin(hora_fin);
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the id_ambiente
     */
    public int getId_ambiente() {
        return id_ambiente;
    }

    /**
     * @param id_ambiente the id_ambiente to set
     */
    public void setId_ambiente(int id_ambiente) {
        this.id_ambiente = id_ambiente;
    }

    /**
     * @param hora_inicio the hora_inicio to set
     */
    public void setHora_inicio(int hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    /**
     * @param hora_fin the hora_fin to set
     */
    public void setHora_fin(int hora_fin) {
        this.hora_fin = hora_fin;
    }

    /**
     * @return the deporte
     */
    public String getDeporte() {
        return deporte;
    }

    /**
     * @param deporte the deporte to set
     */
    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    /**
     * @return the docente
     */
    public String getDocente() {
        return docente;
    }

    /**
     * @param docente the docente to set
     */
    public void setDocente(String docente) {
        this.docente = docente;
    }

    /**
     * @return the ambiente
     */
    public String getAmbiente() {
        return ambiente;
    }

    /**
     * @param ambiente the ambiente to set
     */
    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    /**
     * @return the hora_inicio
     */
    public int getHora_inicio() {
        return hora_inicio;
    }

    /**
     * @return the hora_fin
     */
    public int getHora_fin() {
        return hora_fin;
    }

    public Date get_fin() {
        try {
            return formatter.parse(f_fin);
        } catch (ParseException ex) {
            Logger.getLogger(EGrupohorario.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

}
