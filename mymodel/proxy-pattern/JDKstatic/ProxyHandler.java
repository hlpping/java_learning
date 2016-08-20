package JDKstatic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler {

	private Object target;
	private PersonIntercepter pi = new PersonIntercepter();

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		Object result = null ; 
		if(method.getName().equals("info")){
			pi.method1();
			result=method.invoke(target, args);
			pi.method2();
		}else{
			result=method.invoke(target, args);
		}
		return result;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

}
