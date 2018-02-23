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
        private String cargo;
        private int idArea;
	private boolean permisosAdmin; //true si es admin
	
        public Personal(){
            
        }
	
        public void Personal(String nombre , String apellidos , int dni, String ruc,String cargo,int idarea,boolean permisosadmin){
            this.setNombre(nombre);
            this.setApellidos(apellidos);
            this.setDni(dni);
            this.setRuc(ruc);
            this.setCargo(cargo);
            this.setIdArea(idArea);
            this.setPermisosAdmin(permisosadmin);
            
        }
	//Setter y getter para el id
	
	public int getId()
	{
		return idPersona;
	}

	//Setter y getter para el nombre
	
	public String getNombre()
	{
		return nombre;
	}
	
	//Setter y getter para apellidos
	
	public String getApellidos()
	{
		return apellidos;
	}
	
	//Setter y getter para el dni
	public int getDNI()
	{
		return dni;
	}
	
	//Setter y getter para el ruc
	public String getRuc()
	{
		return ruc;
	}
	
	//Setter y getter para el idArea
	
	//Setter y getter para los permisos de admin
	public boolean getPermisos()
	{
		return permisosAdmin;
	}
	
	/*
	//entrada de usuario
	public void marcaEntrada(){
		this.entrada = true;
		Fecha horaEntrada = new Fecha();
		this.registroEntrada = horaEntrada;
	}
	
	//salida de usuario
	public void marcaSalida() {
		Fecha horaSalida = new Fecha();
		this.registroEntrada = horaSalida;
		this.entrada = false;
	}
*/

    /**
    // * @param cargo the cargo to set
//
     * @return  */
//    public void setCargo(String cargo) {
//        this.cargo = cargo;
//    }
    public String getCargo(){
        return cargo;
    }

    /**
     * @param idPersona the idPersona to set
     */
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(int dni) {
        this.dni = dni;
    }

    /**
     * @param ruc the ruc to set
     */
    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @param permisosAdmin the permisosAdmin to set
     */
    public void setPermisosAdmin(boolean permisosAdmin) {
        this.permisosAdmin = permisosAdmin;
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

    public void setText(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
