package chap02.observer.demo1;

import org.junit.Test;

public class TestObserver {
	
	@Test
	public void test1(){
		WeatherData data = new WeatherData();
		
		CurrentContitionsDisplay display =new CurrentContitionsDisplay(data);
		
		data.setMeasurements(80, 65, 30.4f);
	}
}
