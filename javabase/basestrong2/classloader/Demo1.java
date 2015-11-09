package basestrong2.classloader;

import sun.net.spi.nameservice.dns.DNSNameService;

public class Demo1 {
	public static void main(String[] args) {		
		//获取类加载器   null   BootStrap加载
		System.out.println(Integer.class.getClassLoader());
		
		//ExtClassLoader  sun.misc.Launcher$ExtClassLoader@addbf1
		System.out.println(DNSNameService.class.getClassLoader());
		
		//AppClassLoader  sun.misc.Launcher$AppClassLoader@19821f
		System.out.println(Demo1.class.getClassLoader());
	}

}
