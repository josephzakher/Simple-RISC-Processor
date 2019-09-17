
public class MUX {

	int input1;
	int input2;
	String output;

	int signal;

	public MUX(int signal) {
		this.signal = signal;

	}

	int mux(int signal, String input1, String input2) {
		if (signal == 1)
			output = input2;
		else if (signal == 0)
			output = input1;
		else
			System.out.println("wrong signal type, please insert a 1 or a 0.");

		return signal;
	}

	public MUX() {

	}

}
