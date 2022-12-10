package connection;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class new_customer extends JFrame {

	private JPanel contentPane;
	private JTextField t2;
	private JTextField t1;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField t6;
	private JTextField t7;

	JPanel p1, p2;
	JLabel j8, j9;

	public new_customer() {
		super("New Customer Detail");
		setLocation(350, 100);
		setSize(800, 450);
		setResizable(false);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(100, 100, 890, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("New Customer Details");
		lblNewLabel.setBounds(292, 10, 363, 34);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		contentPane.add(lblNewLabel);

//		p2 = new JPanel();
//		p2.setLayout(new GridLayout(1, 1));
//
//		
//
//		setLayout(new BorderLayout(30, 30));
//		add(j9, "North");
//		add(p1, "Center");
//		add(p2, "West");

		JLabel name = new JLabel("Name");
		name.setBounds(226, 67, 85, 25);
		name.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		contentPane.add(name);

		JLabel meter = new JLabel("Meter number");
		meter.setBounds(226, 102, 153, 25);
		meter.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		contentPane.add(meter);

		JLabel address = new JLabel("Address");
		address.setBounds(226, 137, 100, 22);
		address.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		contentPane.add(address);

		JLabel state = new JLabel("State");
		state.setBounds(227, 169, 84, 26);
		state.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		contentPane.add(state);

		JLabel city = new JLabel("City");
		city.setBounds(226, 205, 71, 25);
		city.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		contentPane.add(city);

		JLabel email = new JLabel("Email");
		email.setBounds(226, 240, 85, 25);
		email.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		contentPane.add(email);

		JLabel phone = new JLabel("Phone no");
		phone.setBounds(225, 275, 115, 22);
		phone.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		contentPane.add(phone);

		t2 = new JTextField();
		t2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		t2.setBounds(432, 109, 284, 19);
		contentPane.add(t2);
		t2.setColumns(10);

		t1 = new JTextField();
		t1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		t1.setBounds(432, 74, 284, 19);
		contentPane.add(t1);
		t1.setColumns(10);

		t3 = new JTextField();
		t3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		t3.setBounds(432, 143, 284, 19);
		contentPane.add(t3);
		t3.setColumns(10);

		t4 = new JTextField();
		t4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		t4.setBounds(432, 177, 284, 19);
		contentPane.add(t4);
		t4.setColumns(10);

		t5 = new JTextField();
		t5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		t5.setBounds(432, 212, 284, 19);
		contentPane.add(t5);
		t5.setColumns(10);

		t6 = new JTextField();
		t6.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		t6.setBounds(432, 247, 284, 19);
		contentPane.add(t6);
		t6.setColumns(10);

		t7 = new JTextField();
		t7.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		t7.setBounds(432, 281, 284, 19);
		contentPane.add(t7);
		t7.setColumns(10);

		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == submit) {

					String user = t1.getText();
					String meter = t2.getText();
					String address = t3.getText();
					String state = t4.getText();
					String city = t5.getText();
					String email = t6.getText();
					String phone = t7.getText();

					try {
						connection_class ob = new connection_class();

						String q = "insert into customer_info values('" + user + "','" + meter + "','" + address + "','"
								+ state + "','" + city + "','" + email + "','" + phone + "')";
						String q1 = "insert into meter values('" + meter + "')";
						ob.stm.executeUpdate(q);
						ob.stm.executeUpdate(q1);
					} catch (Exception ev) {
						ev.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Customer data insert");
					setVisible(false);
				}

			}

			private void getText() {
				// TODO Auto-generated method stub

			}
		});
		submit.setForeground(Color.WHITE);
		submit.setBackground(Color.BLACK);
		submit.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		submit.setBounds(226, 318, 193, 35);
		contentPane.add(submit);

		JButton cancle = new JButton("Cancle");
		cancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == cancle) {
					dispose();
				}
			}
		});
		cancle.setForeground(Color.WHITE);
		cancle.setBackground(Color.BLACK);
		cancle.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		cancle.setBounds(432, 318, 181, 35);
		contentPane.add(cancle);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new_customer frame = new new_customer();
					// frame.setVisible(true);
					new new_customer().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
