# Weather System
 A weather information system using RMI.

### Prerequisites

You will need to install the modules below to run the program: 
* [java 8.0 or greater](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [gson 2.8.5 or greater](http://central.maven.org/maven2/com/google/code/gson/gson/)
* [apache commons lang 3.0 or greater](https://mvnrepository.com/artifact/org.apache.commons/commons-lang3/3.0)
* [openwheathermap 1.2 or greater](https://mvnrepository.com/artifact/org.openweathermap.java-api)

Also, to use the OpenweatherMap API, you need to get an API key [here](https://home.openweathermap.org/users/sign_up). And then put your key in the API_KEY variable contained in the OpenWeatherMapSystem class.

### Running

There are two ways to run this software:

* Compile the IDE (Eclipse - Java IDE):
1. Just open the IDE.
2. Import the project folder as a Java Project and all libraries.
3. After, click in the "Run" button in the class Server.
4. After, click in the "Run" button in the class Client.
5. From this it only interacts with the system.

* Compile by terminal:
1. Enter the src folder and compile all the .java files with the following command:
```
$ java * .java -d <target_address_name>
```
2. Enter the chosen destination directory and run the following command:
```
$ java network.Server
```
3. Enter the chosen destination directory and run the following command:
```
$ java network.Client
```
4. From this it only interacts with the system.

## Built With

* [Eclipse](https://www.eclipse.org/) - A IDE used

## Authors
### Developers: 
* **João Paulo Rosner Vilar ([vilarjp3@ufrn.edu.br](mailto:vilarjp3@ufrn.edu.br))**
* **Luís Eduardo Anunciado Silva ([cruxiu@ufrn.edu.br](mailto:cruxiu@ufrn.edu.br))** 
### Project Advisor: 
* **Everton Ranielly de Sousa Cavalcante ([everton@dimap.ufrn.br](mailto:everton@dimap.ufrn.br))** 

See also the list of [contributors](https://github.com/cruxiu/DIM0614-WeatherSystem/contributors) who participated in this project.

## License

This project is licensed under the GPL 3.0 - see the [LICENSE](LICENSE) file for details

