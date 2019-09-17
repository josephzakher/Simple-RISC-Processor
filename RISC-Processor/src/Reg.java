import java.text.DecimalFormat;

public class Reg {

	int num;
	private int data;

	public Reg(int num, int data) {
		this.num = num;
		this.data = data;
	}

	public Reg() {

	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Reg(int num) {
		this.num = num;
	}

	public String toStringNum() {

		switch (num) {
		case 0:
			return " 000 ";
		case 1:
			return " 001 ";
		case 2:
			return " 010 ";
		case 3:
			return " 011 ";
		case 4:
			return " 100 ";
		case 5:
			return " 101 ";
		case 6:
			return " 110 ";
		case 7:
			return " 111 ";
		}
		return null;

	}

	public String toStringData() {

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

}
