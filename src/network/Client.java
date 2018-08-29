package network;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import org.openweathermap.api.WeatherClientRequestException;

import service.WeatherSystem;

/**
 * @class The Client class implements a client that is invoking remote methods
 * available on the server.
 *
 * @author  João Paulo (vilarjp3@ufrn.edu.br)
 * @author  Luis Eduardo  (cruxiu@ufrn.edu.br)
 * @version 29.08.2018
 */

public class Client {
	public static void main(String[] args) throws RemoteException, 
		NotBoundException, MalformedURLException {
		
		Scanner input = new Scanner(System.in);	
		String city;
		double temperature;
		double humidity;
		double pressure;
		
		/* Search in the remote communication module (RMI Registry).
		* An object reference is returned to the server stub,
		* through which it is possible to perform the invocation of remote methods */
		try {
			WeatherSystem stub = (WeatherSystem) Naming.lookup("rmi://localhost/WeatherSystem");
			System.out.print("\nWeather Information System");
			System.out.print("\nEnter the name of a city: ");
			city = input.next().toString();
			temperature = stub.temperature(city);
			humidity = stub.humidity(city);
			pressure = stub.pressure(city);
			System.out.print("Current temperature is " + temperature + "°C \n");
			System.out.print("Current humidity is " + humidity + "% \n");
			System.out.print("Current pressure is " + pressure + "hPa \n");
		 } catch(RemoteException ex) {
			 System.out.println("\nError while executing remote method: " + ex.getMessage());
			 ex.printStackTrace();
		 } catch(NotBoundException ex) {
			 System.out.println("\nFail at search the server: " + ex.getMessage());
			 ex.printStackTrace();
		 } catch(MalformedURLException ex) {
			 System.out.println("\nFail at creating the server, wrong adress input: \"" + ex.getMessage());
			 ex.printStackTrace();
		 } catch(WeatherClientRequestException ex) {
			System.out.print("City not found: " + ex.getMessage());
			ex.printStackTrace();
		 } catch(Exception ex) {
			System.out.println("\nError: " + ex.getMessage());
			ex.printStackTrace();
		 }
		
		input.close();
	}
}
