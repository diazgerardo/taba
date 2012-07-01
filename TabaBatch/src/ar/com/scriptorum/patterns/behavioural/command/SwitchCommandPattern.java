package ar.com.scriptorum.patterns.behavioural.command;

public class SwitchCommandPattern {
	public static void main(String[] args) {
		Light testLight = new Light();
		LightOnCommand testLOC = new LightOnCommand(testLight);
		LightOffCommand testLFC = new LightOffCommand(testLight);
		Switch testSwitch = new Switch(testLOC, testLFC);
		testSwitch.flipUp();
		testSwitch.flipDown();
		Fan testFan = new Fan();
		FanOnCommand foc = new FanOnCommand(testFan);
		FanOffCommand ffc = new FanOffCommand(testFan);
		Switch ts = new Switch(foc, ffc);
		ts.flipUp();
		ts.flipDown();
	}
}

interface Command {
	public abstract void execute();
}

class Switch {
	private Command upCommand, downCommand;

	public Switch(Command Up, Command Down) {
		upCommand = Up; // concrete Command registers itself with the
						// invoker
		downCommand = Down;
	}

	void flipUp() { // invoker calls back concrete Command, which executes
					// the Command on the receiver
		upCommand.execute();
	}

	void flipDown() {
		downCommand.execute();
	}
}

class Fan {
	public void startRotate() {
		System.out.println("Fan is rotating");
	}

	public void stopRotate() {
		System.out.println("Fan is not rotating");
	}
}

class FanOnCommand implements Command {
	private Fan fan;

	public FanOnCommand(Fan fan) {
		this.fan = fan;
	}

	public void execute() {
		this.fan.startRotate();
	}
}

class FanOffCommand implements Command {
	private Fan myFan;

	public FanOffCommand(Fan F) {
		myFan = F;
	}

	public void execute() {
		myFan.stopRotate();
	}
}

class Light {

	public Light() {
	}

	public void turnOn() {
		System.out.println("Light is on ");
	}

	public void turnOff() {
		System.out.println("Light is off");
	}
}

class LightOnCommand implements Command {
	private Light light;

	public LightOnCommand(Light light) {
		this.light = light;
	}

	public void execute() {
		this.light.turnOn();
	}
}

class LightOffCommand implements Command {
	private Light light;

	public LightOffCommand(Light light) {
		this.light = light;
	}

	public void execute() {
		this.light.turnOff();
	}
}
