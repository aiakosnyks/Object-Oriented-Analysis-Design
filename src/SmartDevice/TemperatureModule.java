package SmartDevice;

public class TemperatureModule implements ITemperatureModule, IObserver{
	private float temperature;
	
	public TemperatureModule(Builder builder) {
	    this.temperature = builder.temperature;
	}
	
	public void showTemperature() {
		System.out.println("Temperature is " + temperature + "degrees.");
	}
	
	@Override
	public void update(float temperature) {
		// TODO Auto-generated method stub
		this.temperature = temperature;
	}	
	
    public static class Builder {
		
		private float temperature;
		
		public Builder temperature(final float temperature)
		{
			this.temperature = temperature;
			return this;
		}
		
		public TemperatureModule build() {
			return new TemperatureModule(this);
		}

		
	}
}
