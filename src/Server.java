/*
 ===============================================================================
 ARQUIVO............: Servidor.java
 DESCRICAO..........: Codigo-fonte correspondente a implementacao do servidor,
 					  fazendo uso do servente que implementa a interface remota.
 AUTOR..............: Everton Cavalcante (everton@dimap.ufrn.br)
 MODIFICADO EM......: 16/08/2018
 ===============================================================================
*/

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	public static void main(String[] args) throws RemoteException, MalformedURLException {
		// Create the RMI's Registry
		try {
			Registry r = LocateRegistry.createRegistry(1099);
			// Create the remote object
			OpenWeatherMapSystem weatherSystem = new OpenWeatherMapSystem();			
			// Register the remote object using the RMI	
			Naming.rebind("rmi://localhost/WeatherSystem", weatherSystem);
			System.out.println("Server is ready and registered in the RMI Registry.");
		} catch(RemoteException ex) {
			System.out.println("\nFail at creating the server: " + ex.getMessage());
			ex.printStackTrace();
		} catch(MalformedURLException ex) {
			System.out.println("\nFail at creating the server, wrong adress input: " + ex.getMessage());
			ex.printStackTrace();
		}	
		catch(Exception ex) {
			System.out.println("\nERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}
