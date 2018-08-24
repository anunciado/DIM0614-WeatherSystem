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

public class Client {
	public static void main(String[] args) throws RemoteException, 
		NotBoundException, MalformedURLException {
		
		/* Busca no modulo de comunicacao remota (RMI Registry).
		 * Retorna-se uma referencia de objeto para o stub de servidor, 
		 * atraves do qual e possivel realizar a invocacao de metodos remotos */
		WeatherSystem stub = (WeatherSystem) Naming.lookup("rmi://localhost/WeatherSystem");

		// Opcao escolhida pelo usuario
		Scanner input = new Scanner(System.in);
		int choice = 0;
		
		String city; 		// Argumentos aos metodos a serem invocados
		double result; 	// Resultado da operacao
		
		try {
			// Interacao com o usuario, que escolhe a operacao a ser executada
			while (true) {
				System.out.print("\nSistema de Informações Meteorológicas");
				System.out.print("\n1-Temperatura\n2-Umidade\n3-Pressão Atmosférica\n4-Sair");
				System.out.print("\n\nEscolha uma opcao: ");
				
				choice = input.nextInt();
				switch (choice) {
					case 1: // Adicao
						System.out.print("\nTemperatura");
						System.out.print("\nDigite o nome de uma cidade: ");
						city = input.next().toString();
						result = stub.temperature(city); 	// Invocacao do metodo
						System.out.print("Temperatura atual é " + result + "\n");
						break;
					case 2: // Subtracao
						System.out.print("\nUmidade");
						System.out.print("\nDigite o nome de uma cidade: ");
						city = input.next().toString();
						result = stub.temperature(city); 	// Invocacao do metodo
						System.out.print("Umidade atual é " + result + "\n");
						break;
					case 3: // Multiplicacao
						System.out.print("\nPressão Atmosférica");
						System.out.print("\nDigite o nome de uma cidade: ");
						city = input.next().toString();
						result = stub.temperature(city); 	// Invocacao do metodo
						System.out.print("Pressão Atmosférica atual é " + result + "\n");
						break;
					case 4:	// Sair
						System.out.println("O programa sera encerrado.");
						return;
					default:
						System.out.println("Opcao invalida. Por favor, tente novamente.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		input.close();
	}
}
