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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class pay_bill extends JFrame implements ActionListener {

	JPanel p, p1;
	JLabel l1, l2, l3, l4, l5;

	JTextArea t1;
	JButton b1, b2;
	Choice c1, c2;
	Font f;

	public pay_bill() {
		super("Calculate Bill");
		setLocation(200, 200);
		setSize(800, 400);
		// setBounds(100, 100, 739, 347);
		setResizable(false);
		p = new JPanel();
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		l3 = new JLabel("Units Cunsumed");
		l3.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		l3.setBounds(110, 177, 185, 30);
		l5 = new JLabel("Calculate Bill");
		l5.setHorizontalAlignment(JLabel.CENTER);
		l5.setFont(new Font("Times New Roman", Font.PLAIN, 25));

		c1 = new Choice();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cm = DriverManager.getConnection("Jdbc:mysql://localhost:3306/billing", "root", "");
			java.sql.Statement stm = cm.createStatement();
			String q1 = "select * from customer_info";
			ResultSet res = stm.executeQuery(q1);

			while (res.next()) {
				c1.add(res.getString("meter"));
			}
		} catch (Exception e) {

		}
//		for (String s : TEAM_NAMES) {
//			c1.add(s);
//		}

		// c1.add("123");
		// c1.add("1003");

		c1.setFont(f);

		c2 = new Choice();
		c2.add("January");
		c2.add("February");
		c2.add("March");
		c2.add("April");
		c2.add("May");
		c2.add("June");
		c2.add("July");
		c2.add("August");
		c2.add("September");
		c2.add("October");
		c2.add("November");
		c2.add("December");

		c2.setFont(f);

		t1 = new JTextArea();
		t1.setFont(f);

		b1 = new JButton("Submit");
		b2 = new JButton("Cancle");

		b1.setBackground(Color.BLACK);
		b1.setFont(f);
		b1.setSize(50, 50);
		b2.setBackground(Color.BLACK);
		b2.setFont(f);
		b1.setForeground(Color.WHITE);
		b2.setForeground(Color.WHITE);

		// contentPane = new JPanel();
		// contentPane.setLayout(new GridLayout(4, 2, 30, 30));
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

		l4 = new JLabel();
		p.add(l4);
		setLayout(new BorderLayout(30, 30));
		add(l5, "North");
		add(p1, "West");
		add(p, "Center");

//		getContentPane().setLayout(new BorderLayout(30, 30));
//		getContentPane().add(l5, "North");
//		getContentPane().add(contentPane, "West");
//		getContentPane().add(p, "Center");

		b1.addActionListener(this);
		b2.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() == b1) {
			try {
				connection_class ob = new connection_class();
				String meter = c1.getSelectedItem();
				String month = c2.getSelectedItem();
				int units = Integer.parseInt(t1.getText());
				int amount = (units * 7) + 98 + 42 + 112 + 48;
				String q = "insert into bill values('" + meter + "','" + month + "','" + units + "','" + amount + "')";
				String q1 = "insert into bii1 values('" + meter + "','" + month + "')";
				ob.stm.executeUpdate(q);
				ob.stm.executeUpdate(q1);
				JOptionPane.showMessageDialog(null, "Data Inserted....");
				setVisible(false);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (ev.getSource() == b2) {
			JOptionPane.showMessageDialog(null, "you Pressed Cancle");
			setVisible(false);
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pay_bill frame = new pay_bill();
					// frame.setVisible(true);
					new pay_bill().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
