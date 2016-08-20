package cn.test.createmodel.factoryMethod;

public class TeacherWorkFactory implements IWorkFactory {
	public Work getWork() {
		return new TeacherWork();
	}
}