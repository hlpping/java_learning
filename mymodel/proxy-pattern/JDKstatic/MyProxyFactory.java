package JDKstatic;

import java.lang.reflect.Proxy;

public class MyProxyFactory {
	public static Object getProxy(Object target) {
		ProxyHandler handler = new ProxyHandler();
		handler.setTarget(target);
		return Proxy.newProxyInstance(PersonImpl.class.getClassLoader(), target
				.getClass().getInterfaces(), handler);
	}
}
