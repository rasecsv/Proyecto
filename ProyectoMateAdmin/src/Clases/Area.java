package Clases;

import java.util.Date;

public class Area {
      private int ID;
    private String Nombre;
    private String HoraIn;
    private String HoraOut;
    
    public  Area(){
        
    }

    public Area(String nombre , String horaIn, String horaOut){
        this.Nombre = nombre;
        this.HoraIn =horaIn;
        this.HoraOut = horaOut;
    }
    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the HoraIn
     */
    public String getHoraIn() {
        return HoraIn;
    }

    /**
     * @param HoraIn the HoraIn to set
     */
    public void setHoraIn(String HoraIn) {
        this.HoraIn = HoraIn;
    }

    /**
     * @return the HoraOut
     */
    public String getHoraOut() {
        return HoraOut;
    }

    /**
     * @param HoraOut the HoraOut to set
     */
    public void setHoraOut(String HoraOut) {
        this.HoraOut = HoraOut;
    }

    /**
     * @return the HoraIn
     */
//    public Date getHoraIn() {
//        return HoraIn;
//    }
//
//    /**
//     * @param HoraIn the HoraIn to set
//     */
//    public void setHoraIn(Date HoraIn) {
//        this.HoraIn = HoraIn;
//    }
//
//    /**
//     * @return the HoraOut
//     */
//    public Date getHoraOut() {
//        return HoraOut;
//    }
//
//    /**
//     * @param HoraOut the HoraOut to set
//     */
//    public void setHoraOut(Date HoraOut) {
//        this.HoraOut = HoraOut;
//    }
}
