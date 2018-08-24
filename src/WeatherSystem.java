/*
 ===============================================================================
 ARQUIVO............: ICalc.java
 DESCRICAO..........: Codigo-fonte correspondente a definicao de uma interface 
 					  remota, que especifica os metodos a serem providos do lado
 					  servidor.
 AUTOR..............: Everton Cavalcante (everton@dimap.ufrn.br)
 MODIFICADO EM......: 16/08/2018
 ===============================================================================
*/

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface WeatherSystem extends Remote {

	// Subtracao
	public double temperature(String city) throws RemoteException;
	
	// Multiplicacao
	public double humidity(String city) throws RemoteException;
	
	// Divisao
	public double pressure(String city) throws RemoteException;
}
