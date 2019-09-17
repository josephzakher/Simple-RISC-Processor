import java.util.Scanner;

public class ALU {

	Scanner scan = new Scanner(System.in);

	public static void arithmetic(Reg gpr, Reg gpr1, Reg gpr2, String op, Mem memory) {

		if (op.equals("plus")) {
			gpr.setData(gpr1.getData() + gpr2.getData());
			System.out.println("$gprs" + gpr.num + " data: " + gpr.getData());
//			System.out.println("opcode: 000 ");
			memory.machineLanguage
					.add("000 " + gpr.toStringNum() + gpr1.toStringNum() + gpr2.toStringNum() + " 0000");
		} else if (op.equals("mnus")) {
			gpr.setData(gpr1.getData() - gpr2.getData());
			System.out.println(gpr.getData());
//			System.out.println("opcode: 001 ");
			memory.machineLanguage
					.add("001" + gpr.toStringNum() + " " + gpr1.toStringNum() + " " + gpr2.toStringNum() + " 000");

		}

	}

}
