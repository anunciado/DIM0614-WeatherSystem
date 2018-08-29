package service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import org.openweathermap.api.DataWeatherClient;
import org.openweathermap.api.UrlConnectionDataWeatherClient;
import org.openweathermap.api.model.currentweather.CurrentWeather;
import org.openweathermap.api.query.*;
import org.openweathermap.api.query.currentweather.CurrentWeatherOneLocationQuery;

/**
 * @class The OpenWeatherMapSystem class that extends the class UnicastRemoteObject
 * and implements the interface WeatherSystem, to provide meteorological information
 * to be provided on the server side.
 *
 * @author  João Paulo (vilarjp3@ufrn.edu.br)
 * @author  Luis Eduardo  (cruxiu@ufrn.edu.br)
 * @version 29.08.2018
 */

@SuppressWarnings("serial")
public class OpenWeatherMapSystem extends UnicastRemoteObject implements WeatherSystem {
	
	private static final String API_KEY = "YOUR_API_KEY";
	
	/**
	* Creates a new OpenWeatherMapSystem object.
	*/
	public OpenWeatherMapSystem() throws RemoteException { 
		super(); 
	}
	
	/**
	 * Creates a new CurrentWeatherOneLocationQuery object.
	 * 
	 * @param city A String that represents the name of the city.
	 * @return A CurrentWeatherOneLocationQuery that represents an object containing
	 * information about the given city.
	 * @exception RemoteException Fail at creating the server.
	 */
	private CurrentWeather currentWeather(String city) throws RemoteException {
		DataWeatherClient client = new UrlConnectionDataWeatherClient(API_KEY);
        CurrentWeatherOneLocationQuery currentWeatherOneLocationQuery = QueryBuilderPicker.pick()
                .currentWeather()                   // get current weather
                .oneLocation()                      // for one location
                .byCityName(city)             		// the cite given as parameter
                .type(Type.ACCURATE)                // with Accurate search
                .language(Language.PORTUGUESE)         // in Portuguese language
                .responseFormat(ResponseFormat.JSON)// with JSON response format
                .unitFormat(UnitFormat.METRIC)      // in metric units
                .build();
        return client.getCurrentWeather(currentWeatherOneLocationQuery);
	}
	
	/**
	 * Get the temperature given name of a city.
	 * 
	 * @param city A String that represents the name of the city.
	 * @return A Double that represents the current temperature of the city passed
	 * as a parameter.
	 * @exception RemoteException Fail at creating the server.
	 */
	public double temperature(String city) throws RemoteException {
		CurrentWeather currentWeather = currentWeather(city);
		return currentWeather.getMainParameters().getTemperature();
	}
	
	/**
	 * Get the humidity given name of a city.
	 * 
	 * @param city A String that represents the name of the city.
	 * @return A Double that represents the current humidity of the city passed
	 * as a parameter.
	 * @exception RemoteException Fail at creating the server.
	 */
	public double humidity(String city) throws RemoteException {
		CurrentWeather currentWeather = currentWeather(city);
		return currentWeather.getMainParameters().getHumidity();
	}
	
	/**
	 * Get the pressure given name of a city.
	 * 
	 * @param city A String that represents the name of the city.
	 * @return A Double that represents the current pressure of the city passed
	 * as a parameter.
	 * @exception RemoteException Fail at creating the server.
	 */
	public double pressure(String city) throws RemoteException {
		CurrentWeather currentWeather = currentWeather(city);
		return currentWeather.getMainParameters().getPressure();
	}
	
}
