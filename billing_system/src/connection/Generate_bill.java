package connection;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Generate_bill extends JFrame implements ActionListener {

	private JPanel contentPane;

	JLabel l1, l2;
	JButton b1, b2;
	JTextArea t1;
	Choice c1, c2;
	JPanel p, p1;
	Font f;

	public Generate_bill() {
		super("Generate Bill");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(100, 100, 450, 300);
		setSize(450, 700);
		setLocation(400, 90);
		// dispose();
		p = new JPanel();
		f = new Font("airel", Font.BOLD, 15);
		p1 = new JPanel();
		l1 = new JLabel("Meter no");
		l2 = new JLabel("Month");
		l2.setFont(f);
		l1.setFont(f);
		// contentPane = new JPanel();
		// contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// contentPane.setLayout(new BorderLayout(0, 0));
		// setContentPane(contentPane);
		c1 = new Choice();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cm = DriverManager.getConnection("Jdbc:mysql://localhost:3306/billing", "root", "");
			java.sql.Statement stm = cm.createStatement();
			String q1 = "select * from meter";
			ResultSet res = stm.executeQuery(q1);

			while (res.next()) {
				c1.add(res.getString("meter"));
			}
		} catch (Exception e) {
			// TODO: handle exception

		}

		c1.setFont(f);

		c2 = new Choice();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cm = DriverManager.getConnection("Jdbc:mysql://localhost:3306/billing", "root", "");
			java.sql.Statement stm = cm.createStatement();
			String q1 = "select * from complete";
			ResultSet res = stm.executeQuery(q1);

			while (res.next()) {
				c2.add(res.getString("month"));
			}
		} catch (Exception e) {

		}

		c2.setFont(f);

		t1 = new JTextArea(50, 15);
		t1.setFont(f);

		b1 = new JButton("Print");
		b2 = new JButton("Show");
		b1.setFont(f);
		b2.setFont(f);
		setLayout(new BorderLayout());
		p.add(l1);
		p.add(c1);
		p.add(l2);
		p.add(c2);

		add(p, "North");
		p1.add(b1);
		p1.add(b2);
		add(p1, "South");
		add(t1);
		JScrollPane sPane = new JScrollPane(t1);
		add(sPane);
		b1.addActionListener(this);
		b2.addActionListener(this);

	}

	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() == b2) {
			String meter = c1.getSelectedItem();
			String month = c2.getSelectedItem();
			t1.setText("Reliance Power " + month + ",2022\n\n");

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection cm = DriverManager.getConnection("Jdbc:mysql://localhost:3306/billing", "root", "");
				Statement stm = cm.createStatement();
				String q1 = "select * from customer_info where meter = '" + meter + "'";
				ResultSet rSet = stm.executeQuery(q1);
				while (rSet.next()) {
					t1.append("\nname : " + rSet.getString("user"));
					t1.append("\nmeter : " + rSet.getString("meter"));
					t1.append("\naddress : " + rSet.getString("address"));
					t1.append("\nstate : " + rSet.getString("state"));
					t1.append("\ncity : " + rSet.getString("city"));
					t1.append("\nemail : " + rSet.getString("email"));
					t1.append("\nphone : " + rSet.getString("phone"));
				}
				t1.append("\n------------------------------");
				String q2 = "select * from tax";
				ResultSet rSet2 = stm.executeQuery(q2);
				while (rSet2.next()) {
					t1.append("\nmeter loaction :" + rSet2.getString("meter_location"));
					t1.append("\nmeter type :" + rSet2.getString("meter_type"));
					t1.append("\nphase cose :" + rSet2.getString("phase_code"));
					t1.append("\nbill type :" + rSet2.getString("bill_type"));
					t1.append("\ndays :" + rSet2.getString("days"));

					t1.append("\n--------------------------------------------");
					t1.append("\nmeter rent :" + rSet2.getString("meter_rent"));
					t1.append("\nservice rent :" + rSet2.getString("service_rent"));
					t1.append("\ngst :" + rSet2.getString("gst"));
					t1.append("\nmcb rent :" + rSet2.getString("mcb_rent"));
				}
				t1.append("\n");
				String q = "select * from bill where meter = '" + meter + "' and month='" + month + "'";
				ResultSet rSet3 = stm.executeQuery(q);
				while (rSet3.next()) {
					t1.append("\nnmeter no :" + rSet3.getString("meter"));
					t1.append("\nmonth :" + rSet3.getString("month"));
					t1.append("\nunits :" + rSet3.getString("units"));
					t1.append("\namount :" + rSet3.getString("amount"));
					t1.append("\n-----------------------------------");
					t1.append("\nTotal Paybill :" + rSet3.getString("amount"));
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (ev.getSource() == b1) {
			try {
				t1.print();
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Generate_bill frame = new Generate_bill();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();

				}
			}
		});
	}

}
