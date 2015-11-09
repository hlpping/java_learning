package base.day08_exception;
/*
在鼠标和键盘两个类中重写turnOff()方法.
给电脑设计关机方法, 将所有UsbSolts中的设备关闭.
给电脑再添加一个摄像头, 在开机的时候能让摄像头启动, 关机的时候能让摄像头关闭.
给电脑设计一个方法, 可以移除所有Usb设备, 再写一个方法移除指定设备.
*/
public class ComputerDemo {
	public static void main(String[] args) {
		Computer computer =new Computer();
		Mouse mouse =new Mouse();
		
		computer.installUsb(mouse);
		
		
		computer.turnOn();
		
		computer.remove(mouse);
		computer.removeAll();
		
		System.out.println();
		computer.turnOff();
	}
}
class Computer{
	private Usb[] usbSolts=new Usb[10];
	
	public void removeAll(){
		for(int i=0;i<usbSolts.length;i++){
			if(usbSolts[i]!=null)
				usbSolts[i] =null;
		}		
	}
	public void remove(Usb usb){
		for(int i=0;i<usbSolts.length;i++)
			if(usbSolts[i]==usb)
				usbSolts[i] =null;				
	}
	public void installUsb(Usb usb){
		for(int i=0;i<usbSolts.length;i++){
			if(usbSolts[i]==null){
				usbSolts[i]=usb;
				break;
			}
		}	
	}
	public void turnOn(){
		for(int i=0;i<usbSolts.length;i++){
			if(usbSolts[i]!=null)
				usbSolts[i].turnOn();			
		}
			System.out.println("电脑开机成功");			
	}
	public void turnOff(){
		for(int i=0;i<usbSolts.length;i++){
			if(usbSolts[i]!=null)
				usbSolts[i].turnOff();			
		}
			System.out.println("电脑关机成功");			
	}
}
interface Usb{
	void turnOn();
	void turnOff();
}
class Mouse implements Usb{
	public void turnOff() {
		System.out.println("鼠标关闭");	
	}
	public void turnOn() {
		System.out.println("鼠标启动");	
	}	
}
