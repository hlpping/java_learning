package cn.test.createmodel.factoryMethod;

public class StudentWorkFactory implements IWorkFactory {
	public Work getWork() {
		return new StudentWork();
	}
}