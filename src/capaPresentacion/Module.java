/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capaPresentacion;

import capaNegocio.ERoles;

/**
 *
 * @author laboratorio_computo
 */
public class Module {

    public static final String titleMessage = "Sistema de Academia";
    public static int userId;
    public static String userName = "USUARIO";
    public static String status;
    public static String tipoRol;
    public static ERoles rol = new ERoles();
    public static int id;
    public static int id_ambiente;
    public static int id_deporte;
    public static int id_alumno;
    public static int id_docente;
    public static int id_gh;

    public static EForm formActive = new EForm();
    public static EFormCart itemCart = new EFormCart();
    public static boolean editCart;

    public static String serieNI = "NI01";
    public static String serieNS = "NS01";

    /**
     * **** CONFIGURACION DE CORREOS **********
     */
    public static String serverHost = "smtp.gmail.com";
    public static String serverPort = "587";
    public static String userNameMail = "aaaldana50@gmail.com";
    public static String passwordMail = "cvpricunnrjjxbkl";

    public boolean isInteger(String numero) {
        try {
            Integer.valueOf(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
