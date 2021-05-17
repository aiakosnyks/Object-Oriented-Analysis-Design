package SmartDevice;

import java.util.Scanner;

public class SmartDevice 
{
	
	private final INetwork network;
	private final IActuator actuator;
	private final ITemperatureModule temperatureModule;	
	private final ISubject subject;

	private static final int TURNOFF_COOLER = 1;
	private static final int TURNON_COOLER = 2;
	private static final int SHOW_TEMPERATURE = 3;
	private static final int EXIT = 4;

	
	private SmartDevice(Builder builder )
	{
		this.network = builder.network;
		this.actuator = builder.actuator;
		this.temperatureModule = builder.temperatureModule;
		this.subject = builder.subject;
	}

	public INetwork getNetwork() {
		return network;
	}

	public ISubject getSubject() {
		return subject;
	}


	public ITemperatureModule getTemperatureModule() {
		return temperatureModule;
	}
	
	public IActuator getActuator() {
		return actuator;
	}	
    public int getInput() {
    	Scanner input = new Scanner(System.in);    //System.in is a standard input stream  
        return input.nextInt();   
        }
    
	  public void showMessage(String message) {
	        System.out.println(message);
	    }

	    public void cleanScreen() {
	    
	    }
	    
		public void start() {
			subject.attach((IObserver)temperatureModule);
			showMessage("Enter User ID.");
			AdditionalTools.interrupt(2000);
			int userId=this.getInput();
			if(userId!=0){
				showMessage("Enter Password.");
				int password= getInput();
				UserAccount userAccount = network.verifyUser(userId, password);
				if (userAccount != null){
					showMessage("User verified...:"+ userAccount);
					options(network, userAccount);
				} else{
					showMessage("User can not be verified...");
					showOptions();
				}
			} else{
				showMessage("User can not be 0");
				showOptions();
			}
		}
		private void options(INetwork network, UserAccount userAccount){
			int selection;
			 do{
			    selection=showOptions();
			 	cleanScreen();
				switch (selection) {
					case TURNOFF_COOLER:
						IRun turnOffCooler=new TurnOffCooler(actuator);
						turnOffCooler.run();
						break;
						
					case TURNON_COOLER:
						IRun turnOnCooler=new TurnOnCooler(actuator);
						turnOnCooler.run();
						break;

					 case SHOW_TEMPERATURE:
						IRun showTemperature=new ShowTemperature(temperatureModule);
						subject.notifyall();
						showTemperature.run();
						break; 

					case EXIT:
						showMessage("EXITING...");
						return;			
						
					default:
						showMessage("Enter a number between 1-4");
				}
			}while(selection!=4);
		}

		private int showOptions()
		{
			showMessage("**********************************************");
			showMessage("Main Menu");
			showMessage("1-Turn Off Cooler");
			showMessage("2-Turn On Cooler");
			showMessage("3-Show Temperature");
			showMessage("4-EXIT");
			showMessage("Select:");
			showMessage("**********************************************");
			return getInput();
		}		
	
		
	public static class Builder {
		
		private INetwork network;
		private IActuator actuator;
		private ITemperatureModule temperatureModule;	
		private ISubject subject;

		public Builder network(final INetwork network)
		{
			this.network = network;
			return this;
		}
		
		public Builder actuator(final IActuator actuator)
		{
			this.actuator = actuator;
			return this;
		}
		
		public Builder temperatureModule(final ITemperatureModule temperatureModule)
		{
			this.temperatureModule = temperatureModule;
			return this;
		}
		
		public Builder subject(final ISubject subject)
		{
			this.subject = subject;
			return this;
		}
		
		
		public SmartDevice build() {
			return new SmartDevice(this);
		}

		
	}
	
}

