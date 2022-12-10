package connection;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class calculate_bill extends JFrame implements ActionListener {

	private JPanel contentPane;
	JPanel p, p1;
	JLabel l1, l2, l3, l4, l5;

	JTextArea t1;
	JButton b1, b2;
	Choice c1, c2;
	Font f;

	public calculate_bill() {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super("Pay Bill");
		setLocation(200, 200);
		setSize(800, 400);
		// setBounds(100, 100, 739, 347);
		setResizable(false);
		p = new JPanel();

		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(p);
		p.setLayout(null);

		f = new Font("Times New Roman", Font.BOLD, 15);
		l1 = new JLabel("Meter Number");
		l1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		l1.setBounds(110, 81, 134, 30);
		l2 = new JLabel("Month");
		l2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		l2.setBounds(110, 133, 93, 24);
		l3 = new JLabel("Payment");
		l3.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		l3.setBounds(110, 177, 185, 30);
		l5 = new JLabel("Pay Bill");
		l5.setHorizontalAlignment(JLabel.CENTER);
		l5.setFont(new Font("Times New Roman", Font.PLAIN, 25));

		c1 = new Choice();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cm = DriverManager.getConnection("Jdbc:mysql://localhost:3306/billing", "root", "");
			java.sql.Statement stm = cm.createStatement();
			String q1 = "select * from bill";
			ResultSet res = stm.executeQuery(q1);

			while (res.next()) {
				c1.add(res.getString("meter"));
			}
		} catch (Exception e) {

		}

		c1.setFont(f);

		c2 = new Choice();

		c2 = new Choice();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cm = DriverManager.getConnection("Jdbc:mysql://localhost:3306/billing", "root", "");
			java.sql.Statement stm = cm.createStatement();
			String q1 = "select * from bill";
			ResultSet res = stm.executeQuery(q1);

			while (res.next()) {
				c2.add(res.getString("month"));
			}
		} catch (Exception e) {
			// TODO: handle exception

		}

		c2.setFont(f);

		t1 = new JTextArea();
		t1.setFont(f);

		b1 = new JButton("Submit");
		b2 = new JButton("Show");

		b1.setBackground(Color.LIGHT_GRAY);
		b1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		b1.setSize(50, 50);
		b2.setBackground(Color.LIGHT_GRAY);
		b2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		b1.setForeground(Color.BLACK);
		b2.setForeground(Color.BLACK);

		b1.setSize(50, 50);
		p = new JPanel();
		p.setLayout(new GridLayout(5, 3, 30, 30));
		p.add(l1);
		p.add(c1);
		p.add(l2);
		p.add(c2);
		p.add(l3);
		p.add(t1);
		p.add(b1);
		p.add(b2);

		p1 = new JPanel();
		p1.setLayout(new GridLayout(1, 1));
//		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource(""));
//		Image image = img.getImage().getScaledInstance(270, 270, Image.SCALE_DEFAULT);
//		ImageIcon img2 = new ImageIcon(image);
		l4 = new JLabel();
		p.add(l4);
		setLayout(new BorderLayout(30, 30));
		add(l5, "North");
		add(p1, "West");
		add(p, "Center");

		b1.addActionListener(this);
		b2.addActionListener(this);

	}

//	public void actionPerformed1(ActionEvent ev) {
//		if (ev.getSource() == b1) {
//			t1.setText("");
//			try {
//				connection_class ob = new connection_class();
//				String meter = c1.getSelectedItem();
//				String month = c2.getSelectedItem();
//				int amount = Integer.parseInt(t1.getText());
//				String q = "insert into complete values('" + meter + "','" + month + "','" + amount + "')";
//				ob.stm.executeUpdate(q);
//				JOptionPane.showMessageDialog(null, "Data Inserted....");
//				setVisible(false);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	}

	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() == b2) {
			t1.setText("");
			String meter = c1.getSelectedItem();
			String month = c2.getSelectedItem();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection cm = DriverManager.getConnection("Jdbc:mysql://localhost:3306/billing", "root", "");
				Statement stm = cm.createStatement();

				String q = "select * from bill where meter = '" + meter + "' and month='" + month + "'";
				ResultSet rSet3 = stm.executeQuery(q);
				while (rSet3.next()) {
					// t1.append("\nnmeter no :" + rSet3.getString("meter"));
					// t1.append("\nmonth :" + rSet3.getString("month"));
					// t1.append("\nunits :" + rSet3.getString("units"));
					t1.append(rSet3.getString("amount"));
					// t1.append("\n-----------------------------------");
					// t1.append("\nTotal Paybill :" + rSet3.getString("amount"));
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (ev.getSource() == b1) {

			try {
				connection_class ob = new connection_class();
				String meter = c1.getSelectedItem();
				String month = c2.getSelectedItem();
				int amount = Integer.parseInt(t1.getText());
				String q = "insert into complete values('" + meter + "','" + month + "','" + amount + "')";
				ob.stm.executeUpdate(q);
				JOptionPane.showMessageDialog(null, "Data Inserted....");
				setVisible(false);
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
//		if (ev.getSource() == JFrame.EXIT_ON_CLOSE) {
//			JOptionPane.showMessageDialog(null, "you Pressed Cancle");
//			setVisible(false);
//		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calculate_bill frame = new calculate_bill();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
