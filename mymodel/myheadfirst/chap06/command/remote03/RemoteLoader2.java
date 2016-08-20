package chap06.command.remote03;

public class RemoteLoader2 {
 
	public static void main(String[] args) {
		RemoteControl remoteControl = new RemoteControl();

		Light light = new Light("Living Room");
		TV tv = new TV("Living Room");
 
		LightOnCommand lightOn = new LightOnCommand(light);
		TVOnCommand tvOn = new TVOnCommand(tv);
		LightOffCommand lightOff = new LightOffCommand(light);
		TVOffCommand tvOff = new TVOffCommand(tv);

		Command[] partyOn = { lightOn, tvOn};
		Command[] partyOff = { lightOff, tvOff};
  
		MacroCommand partyOnMacro = new MacroCommand(partyOn);
		MacroCommand partyOffMacro = new MacroCommand(partyOff);
 
		remoteControl.setCommand(0, partyOnMacro, partyOffMacro);
  
		System.out.println(remoteControl);
		System.out.println("--- Pushing Macro On---");
		remoteControl.onButtonWasPushed(0);
		System.out.println("--- Pushing Macro Off---");
		remoteControl.offButtonWasPushed(0);
	}
}
