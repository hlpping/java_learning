package chap02.observer.demo1;

public class CurrentContitionsDisplay implements Observer, DisplayElement {

	private float temperature;
	private float humidity;
	private float pressure;
	private Subject weatherdata;

	public CurrentContitionsDisplay(Subject subject) {
		this.weatherdata = subject;
		weatherdata.registerObserver(this);
	}

	public void update(float temp, float humidity, float pressure) {
		// TODO Auto-generated method stub
		this.temperature = temp;
		this.humidity = humidity;
		display();
	}

	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Current condition : " + temperature + "--"
				+ humidity+"% humidity"+pressure +" pressure");
	}

}
