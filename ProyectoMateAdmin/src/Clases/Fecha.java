/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author HOLA
 */
public class Fecha extends GregorianCalendar{
    
    protected int hora;
	protected int minuto;
	protected int segundo;
	protected int mes;
	protected int anio;
	
	
	GregorianCalendar fechaTotal = new GregorianCalendar();
	
	public int getHora() {
		this.hora = fechaTotal.get(Calendar.DAY_OF_MONTH)
				+ fechaTotal.get(Calendar.MONTH)
				+ fechaTotal.get(Calendar.YEAR);
             return hora;
	}
	
	public String getFecha() {
		return fechaTotal.getTime().toString().split(" ")[3];
	}
	
}
