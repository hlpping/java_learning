package chap02.observer.demo2;

import java.util.Observable;
import java.util.Observer;

public class CurrentContitionsDisplay implements Observer, DisplayElement {

	Observable observable;
	private float temperature;
	private float humidity;
	private float pressure;

	public CurrentContitionsDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	public void update(Observable observable, Object object) {
		// TODO Auto-generated method stub
		if (observable instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) object;

			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			display();
		}
	}

	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Current condition : " + temperature + "--"
				+ humidity + "% humidity" + pressure + " pressure");
	}
	
}
