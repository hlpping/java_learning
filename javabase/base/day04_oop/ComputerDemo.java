package base.day04_oop;

public class ComputerDemo {
	public static void main(String[] args) {
		Computer c1=new Computer();
//		c1.turnOn();
		
		Cpu cpu =new Cpu();
		GraphicsCard gc = new GraphicsCard();
		Memory m = new Memory();
		
		cpu.name = "T5870";
		gc.name = "9300M";
		m.name = "金士顿2G";
		
		c1.name = "SL400";
		c1.cpu = cpu;						// 给电脑的cpu属性赋值
		c1.gc = gc;		
		c1.m = m;	
		
		c1.turnOn();
		
		System.out.println();
		
		Computer c2 = new Computer();
		c2.turnOn();
		c2.cpu = new Cpu();
		c2.turnOn();
		
	}
}
class Computer{
	String name;	
	Cpu cpu;
	GraphicsCard gc;
	Memory m;
	
	void turnOn(){
		if(cpu == null){
			System.out.println("cpu 没有安装, 不能开机");
		}else if(gc == null){
			System.out.println("显卡没有安装, 不能开机");	
		}else if(m == null){
			System.out.println("内存没有安装, 不能开机");	
		}else{
			System.out.println("开机成功");
			System.out.println("Cpu: " + cpu.name);
			System.out.println("GraphicsCard: " + gc.name);
			System.out.println("Memory: " + m.name);
			System.out.println(name);
		}
	}
}
class Cpu {
	String name;	
}

class GraphicsCard {
	String name;	
}

class Memory {
	String name;
}