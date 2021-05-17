package SmartDevice;

public class ShowTemperature implements IRun {
    private ITemperatureModule temperatureModule;

    ShowTemperature(ITemperatureModule temperatureModule) {
        this.temperatureModule = temperatureModule;
    }
    
    public void run() {
    	temperatureModule.showTemperature();
    }
}

