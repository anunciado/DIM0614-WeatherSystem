/*
 ===============================================================================
 ARQUIVO............: WeatherSystem.java
 DESCRICAO..........: Codigo-fonte correspondente a definicao de uma interface 
 					  remota, que especifica os metodos a serem providos do lado
 					  servidor.
 AUTOR..............: Luís Eduardo (cruxiu@ufrn.edu.br)
 MODIFICADO EM......: 24/08/2018
 ===============================================================================
*/

import java.rmi.Remote;
import java.rmi.RemoteException;

// The implemented interface must always extend the remote interface
public interface WeatherSystem extends Remote {
	
// All methods must throw the RemoteException
	// Temperature
	public double temperature(String city) throws RemoteException;
	
	// Humidity
	public double humidity(String city) throws RemoteException;
	
	// Pressure
	public double pressure(String city) throws RemoteException;
}
