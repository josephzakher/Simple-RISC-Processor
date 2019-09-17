
/*
 *  This Class Is Responsible for showing the register Menu Screen With all the the registers and their respective values.
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import java.awt.Color;

public class RegisterGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterGUI frame = new RegisterGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegisterGUI() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 489, 669);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		dp datapath = new dp();

		setLocationRelativeTo(null);

		JLabel lblNewLabel = new JLabel("Registers");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(167, 0, 154, 36);
		contentPane.add(lblNewLabel);

		JLabel zero = new JLabel("\u2022 $gprs0:");
		zero.setFont(new Font("Tahoma", Font.BOLD, 16));
		zero.setBounds(15, 39, 90, 20);
		contentPane.add(zero);

		JLabel lbls = new JLabel("\u2022 $gprs1:");
		lbls.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbls.setBounds(15, 75, 90, 20);
		contentPane.add(lbls);

		JLabel lbls_1 = new JLabel("\u2022 $gprs2:");
		lbls_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbls_1.setBounds(15, 111, 90, 20);
		contentPane.add(lbls_1);

		JLabel lbls_2 = new JLabel("\u2022 $gprs3:");
		lbls_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbls_2.setBounds(15, 147, 90, 20);
		contentPane.add(lbls_2);

		JLabel lbls_3 = new JLabel("\u2022 $gprs4:");
		lbls_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbls_3.setBounds(15, 183, 90, 20);
		contentPane.add(lbls_3);

		JLabel lblt = new JLabel("\u2022 $gprs5:");
		lblt.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblt.setBounds(15, 219, 90, 20);
		contentPane.add(lblt);

		JLabel lblt_1 = new JLabel("\u2022 $gprs6:");
		lblt_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblt_1.setBounds(15, 255, 90, 20);
		contentPane.add(lblt_1);

		JLabel lblt_2 = new JLabel("\u2022 $gprs7:");
		lblt_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblt_2.setBounds(15, 291, 90, 20);
		contentPane.add(lblt_2);

		JLabel gprs0 = new JLabel(datapath.$gprs0.toStringData());
		gprs0.setForeground(Color.RED);
		if (!datapath.$gprs0.toStringData().equals("0000"))
			gprs0.setForeground(Color.BLUE);
		gprs0.setFont(new Font("Tahoma", Font.BOLD, 16));
		gprs0.setBounds(100, 39, 336, 20);
		contentPane.add(gprs0);

		JLabel gprs1 = new JLabel(datapath.$gprs1.toStringData());
		gprs1.setForeground(Color.RED);
		if (!datapath.$gprs1.toStringData().equals("0000"))
			gprs1.setForeground(Color.BLUE);
		gprs1.setFont(new Font("Tahoma", Font.BOLD, 16));
		gprs1.setBounds(100, 75, 336, 20);
		contentPane.add(gprs1);

		JLabel gprs2 = new JLabel(datapath.$gprs2.toStringData());
		gprs2.setForeground(Color.RED);
		if (!datapath.$gprs2.toStringData().equals("0000"))
			gprs2.setForeground(Color.BLUE);
		gprs2.setFont(new Font("Tahoma", Font.BOLD, 16));
		gprs2.setBounds(100, 111, 336, 20);
		contentPane.add(gprs2);

		JLabel gprs3 = new JLabel(datapath.$gprs3.toStringData());
		gprs3.setForeground(Color.RED);
		if (!datapath.$gprs3.toStringData().equals("0000"))
			gprs3.setForeground(Color.BLUE);
		gprs3.setFont(new Font("Tahoma", Font.BOLD, 16));
		gprs3.setBounds(100, 147, 336, 20);
		contentPane.add(gprs3);

		JLabel gprs4 = new JLabel(datapath.$gprs4.toStringData());
		gprs4.setForeground(Color.RED);
		if (!datapath.$gprs4.toStringData().equals("0000"))
			gprs4.setForeground(Color.BLUE);
		gprs4.setFont(new Font("Tahoma", Font.BOLD, 16));
		gprs4.setBounds(100, 183, 336, 20);
		contentPane.add(gprs4);

		JLabel gprs5 = new JLabel(datapath.$gprs5.toStringData());
		gprs5.setForeground(Color.RED);
		if (!datapath.$gprs5.toStringData().equals("0000"))
			gprs5.setForeground(Color.BLUE);
		gprs5.setFont(new Font("Tahoma", Font.BOLD, 16));
		gprs5.setBounds(100, 219, 336, 20);
		contentPane.add(gprs5);

		JLabel gprs6 = new JLabel(datapath.$gprs6.toStringData());
		gprs6.setForeground(Color.RED);
		if (!datapath.$gprs6.toStringData().equals("0000"))
			gprs6.setForeground(Color.BLUE);
		gprs6.setFont(new Font("Tahoma", Font.BOLD, 16));
		gprs6.setBounds(100, 255, 336, 20);
		contentPane.add(gprs6);

		JLabel gprs7 = new JLabel(datapath.$gprs7.toStringData());
		gprs7.setForeground(Color.RED);
		if (!datapath.$gprs7.toStringData().equals("0000"))
			gprs7.setForeground(Color.BLUE);
		gprs7.setFont(new Font("Tahoma", Font.BOLD, 16));
		gprs7.setBounds(100, 291, 336, 20);
		contentPane.add(gprs7);

		JLabel zeroint = new JLabel("= " + datapath.$gprs0.getData());
		zeroint.setFont(new Font("Tahoma", Font.BOLD, 16));
		zeroint.setBounds(401, 39, 69, 20);
		contentPane.add(zeroint);

		JLabel s0int = new JLabel("= " + datapath.$gprs1.getData());
		s0int.setFont(new Font("Tahoma", Font.BOLD, 16));
		s0int.setBounds(401, 75, 69, 20);
		contentPane.add(s0int);

		JLabel s1int = new JLabel("= " + datapath.$gprs2.getData());
		s1int.setFont(new Font("Tahoma", Font.BOLD, 16));
		s1int.setBounds(401, 111, 69, 20);
		contentPane.add(s1int);

		JLabel label_7 = new JLabel("= " + datapath.$gprs3.getData());
		label_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_7.setBounds(401, 147, 69, 20);
		contentPane.add(label_7);

		JLabel label_8 = new JLabel("= " + datapath.$gprs4.getData());
		label_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_8.setBounds(401, 183, 69, 20);
		contentPane.add(label_8);

		JLabel label_9 = new JLabel("= " + datapath.$gprs5.getData());
		label_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_9.setBounds(401, 219, 69, 20);
		contentPane.add(label_9);

		JLabel label_10 = new JLabel("= " + datapath.$gprs6.getData());
		label_10.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_10.setBounds(401, 255, 69, 20);
		contentPane.add(label_10);

		JLabel label_11 = new JLabel("= " + datapath.$gprs7.getData());
		label_11.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_11.setBounds(401, 291, 69, 20);
		contentPane.add(label_11);

	}
}
