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
import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
///import javax.rmi.CORBA.Stub;

public class Server {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        System.out.println("Iniciando servidor");
        Remote ObjCliente1 = UnicastRemoteObject.exportObject(new TestRemote() {
            @Override
            public String mensajeSaludo(String name) throws RemoteException {
                String mensaje = "Hola " + name + " BIENVENIDO, su codigo es 9900373189";
                CifradoDatos cifradoDatos = new CifradoDatos(mensaje);
                return cifradoDatos.Cifrado();
            }

            public int getData2(int[] arr) throws RemoteException {
                int sum = 0;
                for (int i = 0; i < 80; i++) {
                    sum = sum + arr[i];
                }

                return sum;
            }

            @Override
            public String palindromo(String s) throws RemoteException {
               

                s = s.replace(" ", "");
                s = s.replace(",", "");
                s = s.replace(".", "");
                System.out.print(s);
                int fin = s.length() - 1;
                int ini = 0;
                boolean espalin = true;

                while (ini < fin) {
                    if (s.charAt(ini) != s.charAt(fin)) {
                        espalin = false;
                    }
                    ini++;
                    fin--;
                }
                if (espalin) {
                    return("\nEs palindromo.");
                } else {
                    return("\nNo es palindromo.");
                }

            }

            @Override
            public String calcularPrestamo(String salario) throws RemoteException {
               DesencriptarDatos desencriptarDatos = new DesencriptarDatos(salario);
               int intSal = Integer.parseInt(desencriptarDatos.Cifrado());
                System.out.println(intSal);
                CifradoDatos cd;
                if(intSal<=900000){
                    cd = new CifradoDatos("No ha sido aprobado su credito");
                return cd.Cifrado();
                }else{
                    cd = new CifradoDatos("Ha sido aprobado su credito");
                return cd.Cifrado();
                }
                
            }

        }, 0);
        //Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        Registry registry = LocateRegistry.createRegistry(1099);

        registry.bind("datoKey", ObjCliente1);

    }
}
