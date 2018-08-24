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

public interface WeatherSystem extends Remote {

	// Temperatura
	public double temperature(String city) throws RemoteException;
	
	// Humidade
	public double humidity(String city) throws RemoteException;
	
	// Pressão
	public double pressure(String city) throws RemoteException;
}
