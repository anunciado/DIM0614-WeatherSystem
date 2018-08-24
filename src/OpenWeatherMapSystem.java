/*
 ===============================================================================
 ARQUIVO............: Calculadora.java
 DESCRICAO..........: Codigo-fonte correspondente a implementacao de um servente,
 					  classe que define a implementacao dos metodos especificados
 					  na interface remota.
 AUTOR..............: Everton Cavalcante (everton@dimap.ufrn.br)
 MODIFICADO EM......: 16/08/2018
 ===============================================================================
*/

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import org.openweathermap.api.DataWeatherClient;
import org.openweathermap.api.UrlConnectionDataWeatherClient;
import org.openweathermap.api.model.currentweather.CurrentWeather;
import org.openweathermap.api.query.*;
import org.openweathermap.api.query.currentweather.CurrentWeatherOneLocationQuery;

@SuppressWarnings("serial")
public class OpenWeatherMapSystem extends UnicastRemoteObject implements WeatherSystem {
	
	private static final String API_KEY = "e727e62532fa3bedf05392e295969719";
	
	// Construtor default
	protected OpenWeatherMapSystem() throws RemoteException { 
		super(); 
	}
	
	private CurrentWeather currentWeather(String city){
		DataWeatherClient client = new UrlConnectionDataWeatherClient(API_KEY);
        CurrentWeatherOneLocationQuery currentWeatherOneLocationQuery = QueryBuilderPicker.pick()
                .currentWeather()                   // get current weather
                .oneLocation()                      // for one location
                .byCityName(city)              // for Kharkiv city
                .type(Type.ACCURATE)                // with Accurate search
                .language(Language.PORTUGUESE)         // in English language
                .responseFormat(ResponseFormat.JSON)// with JSON response format
                .unitFormat(UnitFormat.METRIC)      // in metric units
                .build();
        return client.getCurrentWeather(currentWeatherOneLocationQuery);
	}

	public double temperature(String city) throws RemoteException {
		CurrentWeather currentWeather = currentWeather(city);
		return currentWeather.getMainParameters().getTemperature();
	}

	public double humidity(String city) throws RemoteException {
		CurrentWeather currentWeather = currentWeather(city);
		return currentWeather.getMainParameters().getHumidity();
	}

	public double pressure(String city) throws RemoteException {
		CurrentWeather currentWeather = currentWeather(city);
		return currentWeather.getMainParameters().getPressure();
	}
	
}
