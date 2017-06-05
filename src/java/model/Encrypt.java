/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.Arrays;
/**
 *
 * @author albertcahyawan
 */
public class Encrypt {
    private String encrpty;

    public Encrypt( ) { 
    }

    public Encrypt(String test) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
 

    public String getEncrpty() { 
        return encrpty;
    }

    public void setEncrpty(String encrpty) {  
        String temp =""; 
        for(int i=0;i< encrpty.length() ;i++){ 
        temp += Character.toString((char) (1+encrpty.charAt(i)))  ;
        }
        
        this.encrpty = temp;
    }
    
}
