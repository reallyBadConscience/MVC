
public class Model {
	public enum State {
		Idle, Add, Subtract
	}

	private State state;
	private Controller controller;
	private int currentValue = 0;

	public Model(Controller controller) {
		this.controller = controller;
		setState(Model.State.Idle);
	}

	public void setState(State state) {
		this.state = state;
	}

	public int getValue() {
		return currentValue;
	}

	public void handleValue(int val) {
		switch (state) {
		default:
			break;
		case Idle:
			currentValue = val;
			break;
		case Add:
			currentValue += val;
			break;
		case Subtract:
			currentValue -= val;
			break;
		}
		controller.onUpdate();
	}
}
