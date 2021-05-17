package SmartDevice;

import Database.PostgreSQLServer;

public class SmartDeviceApp {
	
	 public static void main(String args[]){
		 		 
         Network network = new Network.Builder()
        		 .database(new PostgreSQLServer())
        		 .build();
         ITemperatureModule temperatureModule = new TemperatureModule.Builder()
        		                               .temperature(0)
        		                               .build();
		 SmartDevice smartDevice = new SmartDevice.Builder()
	        		.network(network)
	        		.actuator(new Actuator())
	        		.temperatureModule(temperatureModule)
	        		.subject(new TemperaturePublisher())
	        		.build();
	    smartDevice.start();
    }
}
