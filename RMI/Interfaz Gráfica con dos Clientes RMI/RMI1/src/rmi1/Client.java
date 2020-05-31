/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi1;

/**
 *
 * @author manue
 */
import java.applet.Applet;
import java.awt.Button;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client extends Applet {

    static String opcion;
    Label saludo = new Label("1.Saludar");
    Label suma = new Label("2.Sumar");
    Label palindrome = new Label("3.Palindrome");
    Label jLabel = new Label("Ingrese requerimiento");
    static TextArea result = new TextArea();
    TextField field = new TextField(20);
    Button button = new Button("Enviar");

    public void init() {
        add(saludo);
        add(suma);
        add(palindrome);
        add(jLabel);
        add(field);
        add(button);
        add(result);
    }

    public boolean action(Event event, Object ob) {

        if (event.target == button) {
            try {
                opcion = field.getText();
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
        
        int[] arr = new int[80];
        int m = 20;
        for (int i = 0; i < 80; i++) {
            arr[i] = m++;
        }

        switch (opcion) {

            case "1":
                System.out.println("opcion 1");
                String re=testRemote1.mensajeSaludo("Manuel Cordoba");
                System.out.println(re);
                DesencriptarDatos desencriptarDatos = new DesencriptarDatos(re);
                System.out.println(desencriptarDatos.Cifrado());
                result.setText(desencriptarDatos.Cifrado());

                break;

            case "3":

                String res=testRemote1.palindromo("ano");
                result.setText(res);
                break;

            case "2":
                break;

            default:

        }
        TestRemote testRemote2 = (TestRemote) registry.lookup("datoKey");

    }

//    public static void main(String[] args) throws RemoteException, NotBoundException {
//
//        Registry registry = LocateRegistry.getRegistry();
//
//        TestRemote testRemote1 = (TestRemote) registry.lookup("datoKey");
//
//        System.out.println(testRemote1.mensajeSaludo("Emilio Barajasssss"));
//        int[] arr = new int[80];
//        int m = 20;
//        for (int i = 0; i < 80; i++) {
//            arr[i] = m++;
//        }
//
//        switch (opcion) {
//
//            case "1":
//
//                result.setText(testRemote1.mensajeSaludo("Juan Barajasssss"));
//
//                break;
//
//            case "2":
//
//                System.out.println(testRemote1.getData2(arr));
//                break;
//
//            case "3":
//                break;
//
//            default:
//
//        }
//        TestRemote testRemote2 = (TestRemote) registry.lookup("datoKey");
//
//    }

}
