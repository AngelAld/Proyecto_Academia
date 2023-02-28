/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capaNegocio;

/**
 *
 * @author an
 */
public class EPagos {

    private int id;
    private float total;
    private int numCuotas;
    private String estado;
    private int matriculaId;
    private String alumno;
    private String grupo_horario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getNumCuotas() {
        return numCuotas;
    }

    public void setNumCuotas(int numCuotas) {
        this.numCuotas = numCuotas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getMatriculaId() {
        return matriculaId;
    }

    public void setMatriculaId(int matriculaId) {
        this.matriculaId = matriculaId;
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    public String getGrupo_horario() {
        return grupo_horario;
    }

    public void setGrupo_horario(String grupo_horario) {
        this.grupo_horario = grupo_horario;
    }

}
