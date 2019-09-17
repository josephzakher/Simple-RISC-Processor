import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Color;
import java.awt.Font;
import java.util.Scanner;
import java.util.ArrayList;

public class GUI extends JFrame implements ActionListener {
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

	private JFrame frame;
	private static JButton button;
	private static JButton button2;
	private static JButton button3;
	private static JButton button4;
	private JPanel panel;
	private JTextArea textarea1;
	private JTextArea textarea2;
	private JTextArea textarea3;
	private JTextArea textarea4;
	private JTextArea textarea5;
	private JTextArea textarea6;
	private JScrollPane scroll;
	private ImageIcon image1;
	private ImageIcon image2;
	private ImageIcon image3;
	private ImageIcon image4;
	private ImageIcon image5;
	private JLabel label1;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					button.addActionListener(frame);
					button2.addActionListener(frame);
					button3.addActionListener(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public GUI(Reg $gprs0, Reg $gprs1, Reg $gprs2, Reg $gprs3, Reg $gprs4, Reg $gprs5, Reg $gprs6, Reg $gprs7) {
		this.$gprs0 = $gprs0;
		this.$gprs1 = $gprs1;
		this.$gprs2 = $gprs2;
		this.$gprs3 = $gprs3;
		this.$gprs4 = $gprs4;
		this.$gprs5 = $gprs5;
		this.$gprs6 = $gprs6;
		this.$gprs7 = $gprs7;
	}

	public GUI() {
		// creating an instance of JFrame with name "Processor simulation"
		frame = new JFrame("Processor simulation");

		// creates an instance of JButton
		button = new JButton("Convert to Assembly languange");
		button.setFont(new Font("Tahoma", Font.PLAIN, 13));

		button.setBounds(295, 154, 223, 25);

		// creates an instance of JButton
		button2 = new JButton("Convert to Machine languange");
		button2.setFont(new Font("Tahoma", Font.PLAIN, 13));

		button2.setBounds(297, 478, 221, 25);

		// creates an instance of JButton
		button3 = new JButton("Set DataPath Instructions");
		button3.setFont(new Font("Tahoma", Font.PLAIN, 13));

		button3.setBounds(1176, 134, 205, 25);

		// create an object of JTextArea
		textarea1 = new JTextArea(15, 30);
		textarea1.setBounds(11, 7, 274, 319);
		textarea1.setToolTipText("Enter C code here");
		textarea1.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textarea1.setBackground(Color.LIGHT_GRAY);

		// create an object of JTextArea
		textarea2 = new JTextArea(15, 43);
		textarea2.setBounds(528, 7, 391, 319);
		textarea2.setToolTipText("Assembly Language Output");
		textarea2.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textarea2.setBackground(Color.LIGHT_GRAY);
		textarea2.setEditable(false);

		// create an object of JTextArea
		textarea3 = new JTextArea(15, 30);
		textarea3.setBounds(11, 331, 274, 319);
		textarea3.setToolTipText("Assembly Language Input");
		textarea3.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textarea3.setBackground(Color.LIGHT_GRAY);

		// create an object of JTextArea
		textarea4 = new JTextArea(15, 41);
		textarea4.setToolTipText("Machine Language Output");
		textarea4.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textarea4.setBackground(Color.LIGHT_GRAY);
		textarea4.setEditable(false);
		scroll = new JScrollPane(textarea4);
		scroll.setBounds(528, 330, 392, 321);
		scroll.setViewportBorder(null);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		// create an object of JTextArea
		textarea5 = new JTextArea(15, 30);
		textarea5.setBounds(1083, 7, 391, 100);
		textarea5.setToolTipText("Assembly Language Input");
		textarea5.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textarea5.setBackground(Color.LIGHT_GRAY);

		// create an object of JTextArea
		textarea6 = new JTextArea(5, 5);
		textarea6.setBounds(297, 333, 30, 30);
		textarea6.setToolTipText("Set Number of Instructions");
		textarea6.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textarea6.setBackground(Color.LIGHT_GRAY);

		// create an object of ImageIcon
		image1 = new ImageIcon("Untitled.png");
		label1 = new JLabel(image1);
		label1.setSize(629, 480);
		label1.setLocation(964, 170);

		// create an panel to add buttons and textfield
		panel = new JPanel();
		panel.setLayout(null);

		// add buttons and textfields to panel
		panel.add(textarea1);
		panel.add(button);
		panel.add(textarea2);
		panel.add(textarea3);
		panel.add(button2);
		panel.add(scroll);
		panel.add(label1);
		panel.add(button3);
		panel.add(textarea5);
		panel.add(textarea6);

		// add panel to frame
		frame.getContentPane().add(panel);
		// set the size of frame
		frame.setSize(1920, 1080);

		// setting close operation
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// makes the frame visible
		frame.setVisible(true);

	}

	int pos = 0;

	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		String stx;
		
//		if(s.equals("Set Number of Instructions")) {
//				int st1=Integer.parseInt(textarea6.getText());
//				System.out.println(st1);
//				Mem m = new Mem();
//				m.numInstruction(st1);
//				System.out.println(st1);
//			
//		}
		
		if (s.equals("Convert to Machine languange")) {
			try {
				
				
				Mem memory = new Mem();
				processor p = new processor();

				p.datapath.$gprs2.setData(0);
				p.datapath.$gprs3.setData(1);
				p.datapath.$gprs4.setData(5);
				
				int n=Integer.parseInt(textarea6.getText());
				System.out.println(n);
				memory.numInstruction(n);
				System.out.println(n);
				
				// create a temp file
				File temp = new File("tempfile.txt");
				// write it
				BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
				bw.write(textarea3.getText());
				bw.close();

				BufferedReader br1 = new BufferedReader(new FileReader(temp));
				String st1 = br1.readLine();
				String st2 = "";
				int i = 0;

				while (st1 != null) {
					memory.instructions[i] = st1;
					i++;
					st1 = br1.readLine();
				}

				p.process(memory, p.datapath);

				Iterator<String> it = memory.machineLanguage.iterator();
				int z = 0;
				while (it.hasNext()) {
					memory.address[z] = it.next();
					z += 2;
				}

				for (int j = 0; j < memory.address.length; j++) {
					if (memory.address[j] != null)
						st2 += "address " + j + ": " + memory.address[j] + "\n";
				}
				textarea4.setText(st2);

			} catch (IOException error) {

				error.printStackTrace();

			}
		}

		if (s.equals("Convert to Assembly languange")) {
			try {

				// create a temp file
				File temp = new File("tempfile.txt");
				File example = new File("example.txt");
				File mipsoutput = new File("mipsoutput.txt");

				// write it
				BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
				bw.write(textarea1.getText());
				bw.close();

				BufferedReader br1 = new BufferedReader(new FileReader(temp));
				BufferedReader br2 = new BufferedReader(new FileReader(example));
				BufferedReader br3 = new BufferedReader(new FileReader(mipsoutput));
				String st1 = br1.readLine();
				String st2 = br2.readLine();
				String st3 = br3.readLine();
				String st4 = "";
				
				boolean areEqual = true;

				while (st1 != null || st2 != null) {
					if (st1 == null || st2 == null) {
						areEqual = false;
						break;
					} else if (!st1.equalsIgnoreCase(st2)) {
						areEqual = false;
						break;
					}
					st1 = br1.readLine();
					st2 = br2.readLine();
				}

				if (areEqual) {
					while (st3 != null) {
						st4 = st4 + st3 + "\n";
						st3 = br3.readLine();
					}
					textarea2.setText(st4);
					textarea3.setText(st4);
				} else {
					System.out.println("Fail");
					textarea2.setText("Please enter the correct code");
				}
				br1.close();
				br2.close();

			} catch (IOException error) {

				error.printStackTrace();
			}
		}

		if (s.equals("Set DataPath Instructions")) {
			try {

				// create a temp file
				File temp = new File("tempfile.txt");

				// write it
				BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
				bw.write(textarea4.getText());
				bw.close();
				ArrayList<String> a1 = new ArrayList<String>();
				Scanner scan = new Scanner(new FileReader(temp));
				while (scan.hasNextLine()) {
					a1.add(scan.nextLine());
				}
				if (pos >= a1.size()) {
					pos = 0;
					textarea5.setText(a1.get(0));
				}
				stx = a1.get(pos);
				String[] arr = stx.split(" ");
				String st2 = arr[2];

				if (st2.equals("100") || st2.equals("011") || st2.equals("010")) {
					image2 = new ImageIcon("TR-Format Datapath.jpg");
					label1.setIcon(image2);
					textarea5.setText(stx);
					pos++;
				} else if (st2.equals("101") || st2.equals("110")) {
					image3 = new ImageIcon("B-Format Datapath.jpg");
					label1.setIcon(image3);
					textarea5.setText(stx);
					pos++;
				} else if (st2.equals("000") || st2.equals("001")) {
					image4 = new ImageIcon("Q-Format Datapath.jpg");
					label1.setIcon(image4);
					textarea5.setText(stx);
					pos++;
				} else if (st2.equals("111")) {
					image5 = new ImageIcon("GOTO-Format Datapath.jpg");
					label1.setIcon(image5);
					textarea5.setText(stx);
					pos++;
				}

			} catch (IOException error) {

				error.printStackTrace();
			}
		}

	}

}
