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

public class Server {
	public static void main(String[] args) throws RemoteException, MalformedURLException {
		// Execu��o do modulo de referencia remota (RMI Registry)
		LocateRegistry.createRegistry(1099);
		
		// Instanciacao do servene
		OpenWeatherMapSystem weatherSystem = new OpenWeatherMapSystem();
		
		// Registro do servente no modulo de referencia remota (RMI Registry)
		Naming.rebind("rmi://localhost/WeatherSystem", weatherSystem);
		System.out.println("Servidor pronto e registrado no RMI Registry.");
	}
}
