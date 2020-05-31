package rmi1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 310
 */
class CifradoDatos extends CifrarD {
    public CifradoDatos(String cadena){
    super(cadena);
    
    }
    public String Cifrado(){
        String cadenaC="";
        char c,cc;
        System.out.println(cadena);
        System.out.println(cadena.length());
            for(int i=0;i<cadena.length();i++){
                System.out.println(i);
            cc=caracterCifrado(cadena.charAt(i),cadena.length(),i);
            cadenaC +=cc;
                System.out.print(cc);
            
        }
        return cadenaC;
    }
private char caracterCifrado(char c, int lon,int i){
        char cc;
        int indice;
        if(pc.indexOf(String.valueOf(c)) != -1){
            indice=pd.indexOf(c);
            cc=pc.charAt(indice);
            return cc;
        }
               return c;
        
    }
}
