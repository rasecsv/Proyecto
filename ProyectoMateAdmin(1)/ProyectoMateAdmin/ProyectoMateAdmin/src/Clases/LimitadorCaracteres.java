/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author HOLA
 */
public class LimitadorCaracteres  extends PlainDocument{
     private JTextField editor; //input a parsear
    private int numeroMaximoCaracteres; //num máximo de caracteres

    /**
     * Crea una instancia de LimitadorCaracteres.
     * 
     * @param editor Editor en el que se quieren limitar los caracteres.
     * @param numeroMaximoCaracteres Número máximo de caracteres que queremos
     * en el editor.
     */
    public LimitadorCaracteres(JTextField editor, int numeroMaximoCaracteres)
    {
        this.editor=editor;
        this.numeroMaximoCaracteres=numeroMaximoCaracteres;
    }
    
    /**
     * Método al que llama el editor cada vez que se intenta insertar caracteres.
     * El método comprueba que no se sobrepasa el límite. Si es así, llama al
     * método de la clase padre para que se inserten los caracteres. Si se 
     * sobrepasa el límite, retorna sin hacer nada.
     */
    public void insertString(int offs, String cadena, AttributeSet arg2) throws BadLocationException
    {	
        if ((editor.getText().length()+cadena.length())>this.numeroMaximoCaracteres || !cadena.matches("[+-]?\\d*(\\.\\d+)?"))
            return ;
        super.insertString(offs, cadena, arg2);
    } 
}
