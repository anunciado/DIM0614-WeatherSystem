package service;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @class The WeatherSystem interface extends the remote interface and specifies 
 * the methods to provide meteorological information to be provided on the server
 * side.
 *
 * @author  João Paulo (vilarjp3@ufrn.edu.br)
 * @author  Luis Eduardo  (cruxiu@ufrn.edu.br)
 * @version 29.08.2018
 */
public interface WeatherSystem extends Remote {
	
	// All methods must throw the RemoteException
	
	/**
	 * Get the temperature given name of a city.
	 * 
	 * @param city A String that represents the name of the city.
	 * @return A Double that represents the current temperature of the city passed
	 * as a parameter.
	 * @exception RemoteException Fail at creating the server.
	 */
	public double temperature(String city) throws RemoteException;
	
	/**
	 * Get the humidity given name of a city.
	 * 
	 * @param city A String that represents the name of the city.
	 * @return A Double that represents the current humidity of the city passed
	 * as a parameter.
	 * @exception RemoteException Fail at creating the server.
	 */
	public double humidity(String city) throws RemoteException;
	
	/**
	 * Get the pressure given name of a city.
	 * 
	 * @param city A String that represents the name of the city.
	 * @return A Double that represents the current pressure of the city passed
	 * as a parameter.
	 * @exception RemoteException Fail at creating the server.
	 */
	public double pressure(String city) throws RemoteException;
}
