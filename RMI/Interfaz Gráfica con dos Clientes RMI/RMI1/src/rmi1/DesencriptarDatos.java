package rmi1;

public class DesencriptarDatos extends CifrarD{
    public DesencriptarDatos(String cadena) {
        super(cadena);
    }
public String Cifrado (){
        
        String cadenac="";
        char c,cc;
        for(int i=0;i<cadena.length();i++){
            
            cc=caracterDesencriptado(cadena.charAt(i),cadena.length(),i);
            cadenac +=cc;
            
        }
        return cadenac;
    }
private char caracterDesencriptado(char c, int lon,int i){
        char cc;
        int indice;
        if(pd.indexOf(String.valueOf(c)) != -1){
            indice=pc.indexOf(c);
            cc=pd.charAt(indice);
            return cc;
        }
               return c;
        
    }
}