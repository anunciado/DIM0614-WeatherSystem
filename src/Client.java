/*
 ===============================================================================
 ARQUIVO............: Cliente.java
 DESCRICAO..........: Codigo-fonte correspondente a implementacao do cliente,
 					  fazendo invocao de metodos remotos disponibilizados no
 					  servidor. 
 AUTOR..............: Everton Cavalcante (everton@dimap.ufrn.br)
 MODIFICADO EM......: 16/08/2018
 ===============================================================================
*/

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import org.openweathermap.api.WeatherClientRequestException;

public class Client {
	public static void main(String[] args) throws RemoteException, 
		NotBoundException, MalformedURLException {
		
		Scanner input = new Scanner(System.in);	
		String city;
		double temperature;
		double humidity;
		double pressure;
		
		/* Busca no modulo de comunicacao remota (RMI Registry).
		 * Retorna-se uma referencia de objeto para o stub de servidor, 
		 * atraves do qual e possivel realizar a invocacao de metodos remotos */
		try {
			WeatherSystem stub = (WeatherSystem) Naming.lookup("rmi://localhost/WeatherSystem");
			System.out.print("\nSistema de Informações Meteorológicas");
			System.out.print("\nDigite o nome de uma cidade: ");
			city = input.next().toString();
			temperature = stub.temperature(city);
			humidity = stub.humidity(city);
			pressure = stub.pressure(city);
			System.out.print("Temperatura atual é " + temperature + "°C \n");
			System.out.print("Umidade atual é " + humidity + "% \n");
			System.out.print("Pressão Atmosférica atual é " + pressure + "hPa \n");
		 } catch(RemoteException ex) {
			 System.out.println("\nErro durante a execucao de metodo remoto: " + ex.getMessage());
			 ex.printStackTrace();
		 } catch(NotBoundException ex) {
			 System.out.println("\nErro durante a procura pelo servidor: " + ex.getMessage());
			 ex.printStackTrace();
		 } catch(MalformedURLException ex) {
			 System.out.println("\nErro ao buscar servidor, endereco especificado de forma incorreta: \"" + ex.getMessage());
			 ex.printStackTrace();
		 } catch(WeatherClientRequestException ex) {
			System.out.print("Cidade não encontrada: " + ex.getMessage());
			ex.printStackTrace();
		 } catch(Exception ex) {
			System.out.println("\nErro: " + ex.getMessage());
			ex.printStackTrace();
		 }
		
		input.close();
	}
}
