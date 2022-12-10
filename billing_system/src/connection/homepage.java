package connection;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

public class homepage extends JFrame implements ActionListener {

	private JPanel contentPane;
	JLabel l1;

	public homepage() {
		super("Electricity billing system");
		setSize(1600, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// First coloum

		JMenuBar mb = new JMenuBar();
		JMenu master = new JMenu("MASTER");
		JMenuItem mi1 = new JMenuItem("New Customer");
		JMenuItem mi2 = new JMenuItem("Customer Details");
		master.setForeground(Color.BLUE);

		// New Customer

		Font font = new Font("monospaced", Font.PLAIN, 16);
		mi1.setFont(font);
		mi1.setMnemonic('D');
		mi1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		mi1.setBackground(Color.WHITE);

		// Customer Detail

		mi2.setFont(font);
		mi2.setMnemonic('M');
		mi2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
		mi2.setBackground(Color.WHITE);

		mi1.addActionListener(this);
		mi2.addActionListener(this);

		// Second Colomm

		JMenu user = new JMenu("USER");
		JMenuItem ui1 = new JMenuItem("Pay Bill");
		JMenuItem ui2 = new JMenuItem("Calculate Bill");
		// JMenuItem ui3 = new JMenuItem("Last Bill");

		// Pay Bill Detail

		ui1.setFont(font);
		ui1.setMnemonic('F');
		ui1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
		ui1.setBackground(Color.WHITE);

		ui2.setFont(font);
		ui2.setMnemonic('C');
		ui2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		ui2.setBackground(Color.WHITE);

//		ui3.setFont(font);
//		ui3.setMnemonic('L');
//		ui3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
//		ui3.setBackground(Color.WHITE);

		ui1.addActionListener(this);
		ui2.addActionListener(this);
		// ui3.addActionListener(this);

		// Third Colom

		JMenu report = new JMenu("REPORT");
		JMenuItem ri = new JMenuItem("Generate Bill");

		ri.setFont(font);
		ri.setMnemonic('G');
		ri.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
		ri.setBackground(Color.WHITE);

		ri.addActionListener(this);

		// Forth Colom

		JMenu exit = new JMenu("EXIT");
		JMenuItem ex = new JMenuItem("Exit");

		ex.setFont(font);
		ex.setMnemonic('E');
		ex.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		ex.setBackground(Color.WHITE);

		ex.addActionListener(this);

		// Add Menu

		master.add(mi1);
		master.add(mi2);

		user.add(ui1);
		user.add(ui2);
		// user.add(ui3);

		report.add(ri);

		exit.add(ex);

		mb.add(master);
		mb.add(user);
		mb.add(report);
		mb.add(exit);

		setJMenuBar(mb);
		setFont(new Font("Senserif", font.BOLD, 16));
		setLayout(new FlowLayout());
		setVisible(false);
	}

	public void actionPerformed(ActionEvent e) {
		{
			String msg = e.getActionCommand();
			if (msg.equals("New Customer")) {
				new new_customer().setVisible(true);
			} else if (msg.equals("Customer Details")) {
				new customer_details().setVisible(true);
			} else if (msg.equals("Pay Bill")) {
				new calculate_bill().setVisible(true);
			} else if (msg.equals("Calculate Bill")) {
				new pay_bill().setVisible(true);
			} else if (msg.equals("Generate Bill")) {
				new Generate_bill().setVisible(true);
			} else if (msg.equals("Exit")) {
				dispose();
				new loginpage().setVisible(true);

			} else {
				System.out.print("Wrong");
			}
		}

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homepage frame = new homepage();
					// frame.setVisible(true);
					new homepage().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
