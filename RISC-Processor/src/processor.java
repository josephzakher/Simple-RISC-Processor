import java.util.Iterator;
import java.util.Scanner;

public class processor {

	controlUnit cu = new controlUnit();
	dp datapath = new dp();

	void process(Mem memory, dp datapath) {
		cu.select(memory, datapath);
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Mem memory = new Mem();
		processor p = new processor();

		// C Code Example
		int m = 0;
		int y = 5;

		for (int i = 0; i < 10; i++) {
			m += y;
		}

		// Setting $gprs2 to m, $gprs3 to 1 (i++) and $gprs4 to y.
		p.datapath.$gprs2.setData(0);
		p.datapath.$gprs3.setData(1);
		p.datapath.$gprs4.setData(y);

		memory.numInstruction(7);

		// C Code Converted to MIPS.
		memory.instructions[0] = "rwid  $gprs0, 10";
		memory.instructions[1] = "rwid  $gprs1, 0";
		memory.instructions[2] = "bzer  $gprs1, $gprs0, 6";
		memory.instructions[3] = "plus  $gprs2, $gprs2, $gprs4";
		memory.instructions[4] = "plus  $gprs1, $gprs1, $gprs3";
		memory.instructions[5] = "goto  2";
		memory.instructions[6] = "end:";

//		memory.instructions[0] = "rwid  $gprs0, 10";
//		memory.instructions[1] = "rwid  $gprs1, 0";
//		memory.instructions[2] = "plus  $gprs1, $gprs1, $gprs0";
//		memory.instructions[3] = "plus  $gprs2, $gprs2, $gprs4";
//		memory.instructions[4] = "plus  $gprs1, $gprs1, $gprs3";
//		memory.instructions[5] = "wwrd  $gprs2, 8";
//
//		memory.instructions[6] = "end:";

		// MIPS Converted to Machine Language.
		p.process(memory, p.datapath);

		// Saving the Instructions in the Memory.
		Iterator<String> it = memory.machineLanguage.iterator();
		int i = 0;
		while (it.hasNext()) {
			memory.address[i] = it.next();
			i += 2;
		}

		// Printing the Address Only when Filled with Instructions.
		for (int j = 0; j < memory.address.length; j++) {
			if (memory.address[j] != null)
				System.out.println(j + "	" + memory.address[j]);
		}

		scan.close();
	}

}
