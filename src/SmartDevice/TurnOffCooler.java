package SmartDevice;

public class TurnOffCooler implements IRun {
	    private IActuator actuator;

	    TurnOffCooler(IActuator actuator) {
	        this.actuator = actuator;
	    }
	    
	    public void run() {
	        actuator.TurnOff();
	    }

}
