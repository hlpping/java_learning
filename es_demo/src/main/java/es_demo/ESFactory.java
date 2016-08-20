package es_demo;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;

public class ESFactory {
	
	private static String host="http://192.168.1.190:9200/";
	private static JestClient client;
	
	private ESFactory(){}
	
	public synchronized static JestClient getClient(){
		if (client == null){
			JestClientFactory factory = new JestClientFactory();
			HttpClientConfig config = new HttpClientConfig.Builder(host).multiThreaded(true).build();
			factory.setHttpClientConfig(config);
			
			client=factory.getObject();
		}
		return client;
		
	}
	
	public static void main(String[] args) {
		System.out.println(getClient());
		
		
	}
	
}
