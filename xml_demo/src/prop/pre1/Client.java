package prop.pre1;

public class Client {

	public static void main(String[] args) {

//		PropertiesUtils.readProperties(PropConfig.config);

		System.out.println("----------------");

		PropertiesUtils.readPropertiesByKey(PropConfig.config, "ad_key01");

		System.out.println("----------------");

		PropertiesUtils.readPropertiesByKeys(PropConfig.config, "mail");
	}
}
