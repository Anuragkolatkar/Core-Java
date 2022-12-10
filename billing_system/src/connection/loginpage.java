package connection;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class loginpage extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField passs;

	public loginpage() {
		super("Login page");
		setLocation(450, 200);
		setSize(500, 330);
		setResizable(false);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(100, 100, 519, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(188, 24, 125, 44);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("USER NAME");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(34, 95, 164, 24);
		contentPane.add(lblNewLabel_1);

		user = new JTextField();
		user.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		user.setBounds(208, 95, 214, 26);
		contentPane.add(user);
		user.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(34, 159, 144, 26);
		contentPane.add(lblNewLabel_2);

		JButton login = new JButton("LOGIN");
		login.setBackground(UIManager.getColor("Button.background"));
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection cm = DriverManager.getConnection("Jdbc:mysql://localhost:3306/billing", "root", "");

					if (e.getSource() == login) {
						String name = user.getText();
						String password = passs.getText();
						String q = "select * from logindata where user='" + name + "' and passs='" + password + "'";
						Statement stm = cm.createStatement();
						ResultSet set = stm.executeQuery(q);
						if (set.next()) {
							new homepage().setVisible(true);

							this.setVisible(false);
						} else {
							JOptionPane.showMessageDialog(null, "Invalid login");
							setVisible(false);
						}
					}

				} catch (Exception ev) {
					ev.getStackTrace();
					System.out.print("errror...");
				}

			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub

			}
		});
		login.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		login.setBounds(34, 222, 176, 32);
		contentPane.add(login);

		passs = new JPasswordField();
		passs.setBounds(208, 159, 214, 26);
		contentPane.add(passs);

		JButton btnNewButton = new JButton("CANCLE");
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnNewButton) {
					JOptionPane.showMessageDialog(null, "Sorrry you press Cancle button.....");
					setVisible(false);
				}
			}

		});

		btnNewButton.setBounds(238, 222, 153, 32);
		contentPane.add(btnNewButton);

	}

	public static void main(String[] args) {
		// loginpage frame = new loginpage();
		// frame.setVisible(true);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginpage frame = new loginpage();
					frame.setVisible(true);
					new loginpage().setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
