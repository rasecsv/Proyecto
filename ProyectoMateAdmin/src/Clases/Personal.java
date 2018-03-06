/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author HOLA
 */
public class Personal {
        private int idPersona;
	private String nombre;
	private String apellidos;
	private int dni;
	private String ruc;
        private boolean cargo;//true si es admin
        private int idArea;
	private int permisosAdmin; 
	
        public Personal(){
            
        }
	
        public void Personal(String nombre , String apellidos , int dni, String ruc,boolean cargo,int idarea,int permisosadmin){
            this.setNombre(nombre);
            this.setApellidos(apellidos);
            this.setDni(dni);
            this.setRuc(ruc);
            this.setCargo(cargo);
            this.setIdArea(idarea);
            this.setPermisosAdmin(permisosadmin);
            
        }

    /**
     * @return the idPersona
     */
    public int getIdPersona() {
        return idPersona;
    }

    /**
     * @param idPersona the idPersona to set
     */
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
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
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the dni
     */
    public int getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(int dni) {
        this.dni = dni;
    }

    /**
     * @return the ruc
     */
    public String getRuc() {
        return ruc;
    }

    /**
     * @param ruc the ruc to set
     */
    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    /**
     * @return the cargo
     */
    public boolean isCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(boolean cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the idArea
     */
    public int getIdArea() {
        return idArea;
    }

    /**
     * @param idArea the idArea to set
     */
    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    /**
     * @return the permisosAdmin
     */
    public int getPermisosAdmin() {
        return permisosAdmin;
    }

    /**
     * @param permisosAdmin the permisosAdmin to set
     */
    public void setPermisosAdmin(int permisosAdmin) {
        this.permisosAdmin = permisosAdmin;
    }

   	
}
