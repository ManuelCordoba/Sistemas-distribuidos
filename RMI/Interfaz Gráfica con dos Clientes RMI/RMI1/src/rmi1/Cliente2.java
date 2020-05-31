/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi1;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import static rmi1.Client.opcion;

/**
 *
 * @author manue
 */
public class Cliente2 extends Applet {
    String sal;
     Label titulo = new Label("Gestion de prestamo");
     Label mensaje = new Label("Ingrese salario");
     Label resultado = new Label("");
     TextField salario = new TextField(20);
     Button button = new Button("Enviar");
     
     public void init(){
     add(titulo);
     add(mensaje);
     add(salario);
     add(button);
     add(resultado);
     }
     
      public boolean action(Event event, Object ob) {

        if (event.target == button) {
            try {
                sal = salario.getText();
                operar();
                return true;
            } catch (RemoteException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
       public void paint(Graphics g) {

    }
       
       public void operar() throws RemoteException, NotBoundException{
    
        Registry registry = LocateRegistry.getRegistry();

        TestRemote testRemote1 = (TestRemote) registry.lookup("datoKey");
       
        
            CifradoDatos cifradoDatos = new CifradoDatos(sal);
            
                String re=testRemote1.calcularPrestamo(cifradoDatos.Cifrado());
                System.out.println(re);
                DesencriptarDatos desencriptarDatos = new DesencriptarDatos(re);
                resultado.setText(desencriptarDatos.Cifrado());
            

    }
    
    
}
