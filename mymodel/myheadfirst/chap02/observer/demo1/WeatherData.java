package chap02.observer.demo1;

import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class WeatherData implements Subject {

	public ArrayList observers;
	public float temperature;
	public float humidity;
	public float pressure;

	public WeatherData() {
		observers = new ArrayList();
	}

	public void notifyObservers() {
		// TODO Auto-generated method stub
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer) observers.get(i);
			observer.update(temperature, humidity, pressure);
		}
	}

	public void registerObserver(Observer o) {
		// TODO Auto-generated method stub
		observers.add(o);
	}

	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub
		int i = observers.indexOf(o);
		if (1 > 0) {
			observers.remove(o);
		}
	}

	public void setMeasurements(float temp, float humidity, float pressure) {
		this.temperature = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementChanged();
	}

	public void measurementChanged() {
		notifyObservers();
	}

}
