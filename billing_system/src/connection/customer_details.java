package connection;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class customer_details extends JFrame implements ActionListener {

	private JPanel contentPane;
	int i = 0, j = 0;
	JTable t1;
	JButton b1, b2;
	String x[] = { "USER", "METER", "ADDRESS", "STATE", "CITY", "EMAIL", "PHONE" };
	String y[][] = new String[33][8];

	public customer_details() {
		super("Customer Details");
		setLocation(200, 100);
		setSize(1200, 650);
		setResizable(false);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(100, 100, 837, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		try {
			connection_class obj = new connection_class();
			String q = "select * from customer_info";
			ResultSet res = obj.stm.executeQuery(q);
			while (res.next()) {
				y[i][j++] = res.getString("user");
				y[i][j++] = res.getString("meter");
				y[i][j++] = res.getString("address");
				y[i][j++] = res.getString("state");
				y[i][j++] = res.getString("city");
				y[i][j++] = res.getString("email");
				y[i][j++] = res.getString("phone");
				i++;
				j = 0;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		t1 = new JTable(y, x);
		b1 = new JButton("Print");
		b1.setBounds(250, 557, 350, 50);
		b2 = new JButton("Exit");
		b2.setBounds(650, 557, 350, 50);
		add(b1);
		add(b2);
		JScrollPane sPane = new JScrollPane(t1);
		add(sPane);
		b1.addActionListener(this);
		b2.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() == b1) {
			try {
				t1.print();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (ev.getSource() == b2) {
			dispose();
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customer_details frame = new customer_details();
					frame.setVisible(true);
					new customer_details();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
