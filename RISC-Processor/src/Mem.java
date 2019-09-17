import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

//import java.util.Scanner;

public class Mem {

	String imm;

	int n;
	
	

	// Store the instructions as MIPS
	String[] instructions = new String[n];
	
	

	public void numInstruction(int k) {
		instructions = new String[k];
	}

	// Memory size: 4Kb
	String[] address = new String[4095];

	// Store the instructions as machine language (binary)
	ArrayList<String> machineLanguage = new ArrayList<>();

	public Mem(String imm) {
		this.imm = imm;

	}

	public Mem() {

	}

	public void setInstructions(String[] instructions) {
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < instructions.length; i++) {
			instructions[i] = scan.nextLine();
		}
		scan.close();
	}

	public String Binary(int data) {

		int a;
		int temp = data;
		String x = "";

		if (temp == 0)
			x = "0000";

		while (temp > 0) {
			a = temp % 2;
			x = a + "" + x;
			temp = temp / 2;
		}

		DecimalFormat f = new DecimalFormat("0000000");

		int y = Integer.parseInt(x);

		return f.format(y);
	}

	public String BinaryJ(int data) {

		int a;
		int temp = data;
		String x = "";

		if (temp == 0)
			x = "0000";

		while (temp > 0) {
			a = temp % 2;
			x = a + "" + x;
			temp = temp / 2;
		}

		DecimalFormat f = new DecimalFormat("0000000000000");

		int y = Integer.parseInt(x);

		return f.format(y);
	}

	@Override
	public String toString() {
		return "Mem [machineLanguage=" + machineLanguage + "]";
	}

}
