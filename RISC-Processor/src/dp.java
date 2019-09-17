
public class dp {

	// Registers
	Reg gpr = new Reg();
	Reg gprs = new Reg();

	Reg $gprs0 = new Reg(0);
	Reg $gprs1 = new Reg(1);
	Reg $gprs2 = new Reg(2);
	Reg $gprs3 = new Reg(3);
	Reg $gprs4 = new Reg(4);
	Reg $gprs5 = new Reg(5);
	Reg $gprs6 = new Reg(6);
	Reg $gprs7 = new Reg(7);

	// ALU
	ALU alu = new ALU();

	// Multiplexers
	MUX regDst = new MUX();
	MUX aluSrc = new MUX();
	MUX memToReg = new MUX();
	MUX branch = new MUX();

	public dp(Reg $gprs0, Reg $gprs1, Reg $gprs2, Reg $gprs3, Reg $gprs4, Reg $gprs5, Reg $gprs6, Reg $gprs7) {
		this.$gprs0 = $gprs0;
		this.$gprs1 = $gprs1;
		this.$gprs2 = $gprs2;
		this.$gprs3 = $gprs3;
		this.$gprs4 = $gprs4;
		this.$gprs5 = $gprs5;
		this.$gprs6 = $gprs6;
		this.$gprs7 = $gprs7;
	}

	public dp() {
	}

}
