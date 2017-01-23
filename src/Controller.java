
public class Controller {
	private static View view;
	private static Model model;

	public Controller() {
		this.view = new View(this);
		this.model = new Model(this);
	}

	public void onClick_Num(int i) {
		model.handleValue(i);
	}

	public void onClick_Clear() {
		model.setState(Model.State.Idle);
	}

	public void onClick_Subtract() {
		model.setState(Model.State.Subtract);
	}

	public void onClick_Add() {
		model.setState(Model.State.Add);
	}

	public void onUpdate() {
		view.onUpdate(model.getValue());
	}

}
