package SmartDevice;

public class TurnOnCooler implements IRun {
    private IActuator actuator;

    TurnOnCooler(IActuator actuator) {
        this.actuator = actuator;
    }
    
    public void run() {
        actuator.TurnOn();
    }
}

