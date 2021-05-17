package SmartDevice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TemperaturePublisher implements ISubject {

    private List<IObserver> subscribers = new ArrayList<>();
    private final float start = -40;
    private final float end = 50;
    @Override
    public void attach(IObserver subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void detach(IObserver subscriber) {
        subscribers.remove(subscriber);
    }

	@Override
	public void notifyall() {
		float random = new Random().nextFloat();
		float tmp = start + (random * (end - start));
		// TODO Auto-generated method stub
		for (IObserver o: subscribers) {
		    o.update(tmp);
		}
	}

}
