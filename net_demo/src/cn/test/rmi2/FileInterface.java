package cn.test.rmi2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FileInterface extends Remote{
	
	public byte[] downloadFile(String fileName) throws RemoteException;
}
//它必须声明为public，这样客户机才能加载实现远程接口 的远程对象。
//它必须扩展为Remote接口，以满足使该对象成为远程对象的 要求。
//这个接口中的每种方法都必须投出一个java.rmi.RemoteException。