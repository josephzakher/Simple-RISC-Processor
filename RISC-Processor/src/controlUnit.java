import java.util.Scanner;

public class controlUnit {

	Scanner scan = new Scanner(System.in);

	void select(Mem memory, dp datapath) {

		pc pc = new pc();
		int x = 0;
		int y = 0;
		int i;

		for (i = 0; i < memory.instructions.length; i++) {

			if (memory.instructions[i].substring(0, 4).equals("plus")
					|| memory.instructions[i].substring(0, 4).equals("mnus")) {

				datapath.regDst.mux(0, memory.instructions[i].substring(14, 19),
						memory.instructions[i].substring(22, 27));

				datapath.aluSrc.mux(0, memory.instructions[i].substring(14, 19),
						memory.instructions[i].substring(22, 27));

				datapath.memToReg.mux(0, memory.instructions[i].substring(6, 11), null);

				datapath.branch.mux(0, null, null);

				switch (memory.instructions[i].substring(6)) {
				case "$gprs0, $gprs0, $gprs0":
					ALU.arithmetic(datapath.$gprs0, datapath.$gprs0, datapath.$gprs0,
							memory.instructions[i].substring(0, 4), memory);
					break;
				case "$gprs0, $gprs0, $gprs1":
					ALU.arithmetic(datapath.$gprs0, datapath.$gprs0, datapath.$gprs1,
							memory.instructions[i].substring(0, 4), memory);
					break;
				case "$gprs0, $gprs1, $gprs0":
					ALU.arithmetic(datapath.$gprs0, datapath.$gprs1, datapath.$gprs0,
							memory.instructions[i].substring(0, 4), memory);
					break;
				case "$gprs0, $gprs1, $gprs1":
					ALU.arithmetic(datapath.$gprs0, datapath.$gprs1, datapath.$gprs1,
							memory.instructions[i].substring(0, 4), memory);
					break;
				case "$gprs1, $gprs0, $gprs0":
					ALU.arithmetic(datapath.$gprs1, datapath.$gprs0, datapath.$gprs0,
							memory.instructions[i].substring(0, 4), memory);
					break;
				case "$gprs1, $gprs0, $gprs1":
					ALU.arithmetic(datapath.$gprs1, datapath.$gprs0, datapath.$gprs1,
							memory.instructions[i].substring(0, 4), memory);
					break;
				case "$gprs1, $gprs1, $gprs0":
					ALU.arithmetic(datapath.$gprs1, datapath.$gprs1, datapath.$gprs0,
							memory.instructions[i].substring(0, 4), memory);
					break;
				case "$gprs1, $gprs1, $gprs1":
					ALU.arithmetic(datapath.$gprs1, datapath.$gprs1, datapath.$gprs1,
							memory.instructions[i].substring(0, 4), memory);
					break;
				case "$gprs0, $gprs1, $gprs2":
					ALU.arithmetic(datapath.$gprs0, datapath.$gprs1, datapath.$gprs2,
							memory.instructions[i].substring(0, 4), memory);
					break;
				case "$gprs2, $gprs2, $gprs4":
					ALU.arithmetic(datapath.$gprs2, datapath.$gprs2, datapath.$gprs4,
							memory.instructions[i].substring(0, 4), memory);
					break;
				case "$gprs1, $gprs1, $gprs3":
					ALU.arithmetic(datapath.$gprs1, datapath.$gprs1, datapath.$gprs3,
							memory.instructions[i].substring(0, 4), memory);
					break;

				// CONTINUE FOR ALL REGISTERS
				// (343 possibilities!)

				}

			}

			else if (memory.instructions[i].substring(0, 4).equals("rwrd")) {
				memory.imm = memory.instructions[i].substring(14);

				datapath.aluSrc.mux(1, memory.instructions[i].substring(14), null);

				datapath.memToReg.mux(1, null, null);

				datapath.branch.mux(0, null, null);

				switch (memory.instructions[i].charAt(11)) {
				case '0':
					datapath.$gprs0.setData(Integer.parseInt(memory.imm));
					memory.machineLanguage
							.add("010 000" + datapath.$gprs0.toStringNum() + datapath.$gprs0.toStringData());
					break;
				case '1':
					datapath.$gprs1.setData(Integer.parseInt(memory.imm));
					memory.machineLanguage
							.add("010 000" + datapath.$gprs1.toStringNum() + datapath.$gprs1.toStringData());
					break;
				case '2':
					datapath.$gprs2.setData(Integer.parseInt(memory.imm));
					memory.machineLanguage
							.add("010 000" + datapath.$gprs2.toStringNum() + datapath.$gprs2.toStringData());
					break;
				case '3':
					datapath.$gprs3.setData(Integer.parseInt(memory.imm));
					memory.machineLanguage
							.add("010 000" + datapath.$gprs3.toStringNum() + datapath.$gprs3.toStringData());
					break;
				case '4':
					datapath.$gprs4.setData(Integer.parseInt(memory.imm));
					memory.machineLanguage
							.add("010 000" + datapath.$gprs4.toStringNum() + datapath.$gprs4.toStringData());
					break;
				case '5':
					datapath.$gprs5.setData(Integer.parseInt(memory.imm));
					memory.machineLanguage
							.add("010 000" + datapath.$gprs5.toStringNum() + datapath.$gprs5.toStringData());
					break;
				case '6':
					datapath.$gprs6.setData(Integer.parseInt(memory.imm));
					memory.machineLanguage
							.add("010 000" + datapath.$gprs6.toStringNum() + datapath.$gprs6.toStringData());
					break;
				case '7':
					datapath.$gprs7.setData(Integer.parseInt(memory.imm));
					memory.machineLanguage
							.add("010 000" + datapath.$gprs7.toStringNum() + datapath.$gprs7.toStringData());
					break;
				}
			}

			else if (memory.instructions[i].substring(0, 4).equals("wwrd")) {

				datapath.regDst.mux(1, memory.instructions[i].substring(6, 11), null);

				datapath.aluSrc.mux(1, memory.instructions[i].substring(14), null);

				datapath.branch.mux(0, null, null);

				switch (memory.instructions[i].charAt(11)) {
				case '0':
					memory.imm = String.valueOf(datapath.$gprs0.getData());
					memory.machineLanguage
							.add("011 000" + datapath.$gprs0.toStringNum() + datapath.$gprs0.toStringData());
					break;
				case '1':
					memory.imm = String.valueOf(datapath.$gprs1.getData());
					memory.machineLanguage
							.add("011 000" + datapath.$gprs1.toStringNum() + datapath.$gprs1.toStringData());
					break;
				case '2':
					memory.imm = String.valueOf(datapath.$gprs2.getData());
					memory.machineLanguage
							.add("011 000" + datapath.$gprs2.toStringNum() + datapath.$gprs2.toStringData());
					break;
				case '3':
					memory.imm = String.valueOf(datapath.$gprs3.getData());
					memory.machineLanguage
							.add("011 000" + datapath.$gprs3.toStringNum() + datapath.$gprs3.toStringData());
					break;
				case '4':
					memory.imm = String.valueOf(datapath.$gprs4.getData());
					memory.machineLanguage
							.add("011 000" + datapath.$gprs4.toStringNum() + datapath.$gprs4.toStringData());
					break;
				case '5':
					memory.imm = String.valueOf(datapath.$gprs5.getData());
					memory.machineLanguage
							.add("011 000" + datapath.$gprs5.toStringNum() + datapath.$gprs5.toStringData());
					break;
				case '6':
					memory.imm = String.valueOf(datapath.$gprs6.getData());
					memory.machineLanguage
							.add("011 000" + datapath.$gprs6.toStringNum() + datapath.$gprs6.toStringData());
					break;
				case '7':
					memory.imm = String.valueOf(datapath.$gprs7.getData());
					memory.machineLanguage
							.add("011 000" + datapath.$gprs7.toStringNum() + datapath.$gprs7.toStringData());
					break;
				}

				datapath.memToReg.mux(1, memory.imm, null);

				memory.address[Integer.parseInt(memory.instructions[i].substring(14))] = memory.imm;

			}

			else if (memory.instructions[i].substring(0, 4).equals("rwid")) {

				datapath.regDst.mux(0, memory.instructions[i].substring(6, 11), null);

				datapath.aluSrc.mux(1, memory.instructions[i].substring(14), null);

				datapath.branch.mux(0, null, null);

				datapath.memToReg.mux(0, memory.instructions[i].substring(14), null);

				switch (memory.instructions[i].charAt(11)) {
				case '0':
					datapath.$gprs0.setData(Integer.parseInt(memory.instructions[i].substring(14)));
					System.out.println("$gprs0 data set to " + datapath.$gprs0.getData());
					memory.machineLanguage
							.add("100 000" + datapath.$gprs0.toStringNum() + datapath.$gprs0.toStringData());
					break;
				case '1':
					datapath.$gprs1.setData(Integer.parseInt(memory.instructions[i].substring(14)));
					System.out.println("$gprs1 data set to " + memory.instructions[i].substring(14));
					memory.machineLanguage
							.add("100 000" + datapath.$gprs1.toStringNum() + datapath.$gprs1.toStringData());
					break;
				case '2':
					datapath.$gprs2.setData(Integer.parseInt(memory.instructions[i].substring(14)));
					System.out.println("$gprs2 data set to " + memory.instructions[i].substring(14));
					memory.machineLanguage
							.add("100 000" + datapath.$gprs2.toStringNum() + datapath.$gprs2.toStringData());
					break;
				case '3':
					datapath.$gprs3.setData(Integer.parseInt(memory.instructions[i].substring(14)));
					System.out.println("$gprs3 data set to " + memory.instructions[i].substring(14));
					memory.machineLanguage
							.add("100 000" + datapath.$gprs3.toStringNum() + datapath.$gprs3.toStringData());
					break;
				case '4':
					datapath.$gprs4.setData(Integer.parseInt(memory.instructions[i].substring(14)));
					System.out.println("$gprs4 data set to " + memory.instructions[i].substring(14));
					memory.machineLanguage
							.add("100 000" + datapath.$gprs4.toStringNum() + datapath.$gprs4.toStringData());
					break;
				case '5':
					datapath.$gprs5.setData(Integer.parseInt(memory.instructions[i].substring(14)));
					System.out.println("$gprs5 data set to " + memory.instructions[i].substring(14));
					memory.machineLanguage
							.add("100 000" + datapath.$gprs5.toStringNum() + datapath.$gprs5.toStringData());
					break;
				case '6':
					datapath.$gprs6.setData(Integer.parseInt(memory.instructions[i].substring(14)));
					System.out.println("$gprs6 data set to " + memory.instructions[i].substring(14));
					memory.machineLanguage
							.add("100 000" + datapath.$gprs6.toStringNum() + datapath.$gprs6.toStringData());
					break;
				case '7':
					datapath.$gprs7.setData(Integer.parseInt(memory.instructions[i].substring(14)));
					System.out.println("$gprs7 data set to " + memory.instructions[i].substring(14));
					memory.machineLanguage
							.add("100 000" + datapath.$gprs7.toStringNum() + datapath.$gprs7.toStringData());
					break;
				}

			}

			else if (memory.instructions[i].substring(0, 4).equals("bzer")) {

				datapath.regDst.mux(0, null, null);

				datapath.aluSrc.mux(0, memory.instructions[i].substring(14, 19), null);

				datapath.memToReg.mux(0, null, null);

				datapath.branch.mux(1, memory.instructions[i].substring(22), null);

				int j = 0;
				int k = 0;

				switch (memory.instructions[i].charAt(11)) {
				case '0':
					x = datapath.$gprs0.getData();
					j = 0;
					break;
				case '1':
					x = datapath.$gprs1.getData();
					j = 1;
					break;
				case '2':
					x = datapath.$gprs2.getData();
					j = 2;
					break;
				case '3':
					x = datapath.$gprs3.getData();
					j = 3;
					break;
				case '4':
					x = datapath.$gprs4.getData();
					j = 4;
					break;
				case '5':
					x = datapath.$gprs5.getData();
					j = 5;
					break;
				case '6':
					x = datapath.$gprs6.getData();
					j = 6;
					break;
				case '7':
					x = datapath.$gprs7.getData();
					j = 7;
					break;
				}

				switch (memory.instructions[i].charAt(19)) {
				case '0':
					y = datapath.$gprs0.getData();
					k = 0;
					break;
				case '1':
					y = datapath.$gprs1.getData();
					k = 1;
					break;
				case '2':
					y = datapath.$gprs2.getData();
					k = 2;
					break;
				case '3':
					y = datapath.$gprs3.getData();
					k = 3;
					break;
				case '4':
					y = datapath.$gprs4.getData();
					k = 4;
					break;
				case '5':
					y = datapath.$gprs5.getData();
					k = 5;
					break;
				case '6':
					y = datapath.$gprs6.getData();
					k = 6;
					break;
				case '7':
					y = datapath.$gprs7.getData();
					k = 7;
					break;
				}

				datapath.gpr.setNum(j);
				datapath.gprs.setNum(k);

				int b = Integer.parseInt(memory.instructions[i].substring(22));

				if (x - y == 0) {
					pc.inc = Integer.parseInt(memory.instructions[i].substring(22));
					System.out.println("branched to adress: " + memory.instructions[i].substring(22));
					System.out.println(memory.instructions[pc.inc]);
					memory.machineLanguage
							.add("101 " + datapath.gpr.toStringNum() + datapath.gprs.toStringNum() + memory.Binary(b));
					break;
				} else {
					System.out.println(x + " is not equal to " + y + ".");
					memory.machineLanguage
							.add("101 " + datapath.gpr.toStringNum() + datapath.gprs.toStringNum() + memory.Binary(b));

				}
			}

			else if (memory.instructions[i].substring(0, 4).equals("boxx")) {

				datapath.regDst.mux(0, null, null);

				datapath.aluSrc.mux(0, memory.instructions[i].substring(14, 19), null);

				datapath.memToReg.mux(0, null, null);

				datapath.branch.mux(1, memory.instructions[i].substring(22), null);

				int j = 0;
				int k = 0;

				switch (memory.instructions[i].charAt(11)) {
				case '0':
					x = datapath.$gprs0.getData();
					j = 0;
					break;
				case '1':
					x = datapath.$gprs1.getData();
					j = 1;
					break;
				case '2':
					x = datapath.$gprs2.getData();
					j = 2;
					break;
				case '3':
					x = datapath.$gprs3.getData();
					j = 3;
					break;
				case '4':
					x = datapath.$gprs4.getData();
					j = 4;
					break;
				case '5':
					x = datapath.$gprs5.getData();
					j = 5;
					break;
				case '6':
					x = datapath.$gprs6.getData();
					j = 6;
					break;
				case '7':
					x = datapath.$gprs7.getData();
					j = 7;
					break;
				}

				switch (memory.instructions[i].charAt(19)) {
				case '0':
					y = datapath.$gprs0.getData();
					k = 0;
					break;
				case '1':
					y = datapath.$gprs1.getData();
					k = 1;
					break;
				case '2':
					y = datapath.$gprs2.getData();
					k = 2;
					break;
				case '3':
					y = datapath.$gprs3.getData();
					k = 3;
					break;
				case '4':
					y = datapath.$gprs4.getData();
					k = 4;
					break;
				case '5':
					y = datapath.$gprs5.getData();
					k = 5;
					break;
				case '6':
					y = datapath.$gprs6.getData();
					k = 6;
					break;
				case '7':
					y = datapath.$gprs7.getData();
					k = 7;
					break;
				}

				datapath.gpr.setNum(j);
				datapath.gprs.setNum(k);

				int b = Integer.parseInt(memory.instructions[i].substring(22));

				if (x > y) {
					pc.inc = Integer.parseInt(memory.instructions[i].substring(22));
					System.out.println("branched to adress: " + memory.instructions[i].substring(22));
					System.out.println(memory.instructions[pc.inc]);
					memory.machineLanguage
							.add("110 " + datapath.gpr.toStringNum() + datapath.gprs.toStringNum() + memory.Binary(b));
					break;
				} else {
					System.out.println(x + " is not greater than " + y + ".");
					memory.machineLanguage
							.add("110 " + datapath.gpr.toStringNum() + datapath.gprs.toStringNum() + memory.Binary(b));
				}
			}

			else if (memory.instructions[i].substring(0, 4).equals("goto")) {
				pc.inc = Integer.parseInt(memory.instructions[i].substring(6));
				i = pc.inc - 1;
				memory.machineLanguage.add("111 " + memory.BinaryJ(pc.inc));
			} else {
				System.out.println(memory.instructions[i]);
				
			}
			
			System.out.println(i);
		}
	}
}
