package cn.test.behavior.command;
public abstract class Command {
    
    protected Receiver receiver;
    
    public Command(Receiver receiver) {
        this.receiver = receiver;
    }
    
    public abstract void execute();
}
