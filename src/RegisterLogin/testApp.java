package RegisterLogin;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.TableModel;

public class testApp extends JFrame {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	public static JButton logIn;
	public static JButton register;
	public static JTextField username = new JTextField("");
	public static JTextField password = new JTextField("");
	public static JLabel user = new JLabel("Username:");
	public static JLabel pass = new JLabel("Password:");
	public static JFrame introForm = new JFrame("Login/Register");
	public static JFrame registerForm = new JFrame("Register");
	public static JFrame userForm = new JFrame("Info");
	static JTable t;
	static TableModel tm;
	private int id;
	private int role;
	static int loged;
	int userID;
	static int row = 0;

	static void userForm() throws SQLException {
		userForm = new JFrame();
		userForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		userForm.setResizable(false);
		userForm.setPreferredSize(new Dimension(500, 500));
		userForm.setMinimumSize(new Dimension(300, 300));
		Container panel = userForm.getContentPane();
		SpringLayout sL = new SpringLayout();
		panel.setLayout(sL);

		KorisnikDaoImpl test = new KorisnikDaoImpl();

		t = test.getTable(loged);

		JScrollPane pane = new JScrollPane(t);
		pane.setPreferredSize(new Dimension(300, 200));
		t.setPreferredSize(new Dimension(300, 400));
		panel.add(pane);
		sL.putConstraint(SpringLayout.NORTH, pane, 20, SpringLayout.WEST, panel);
		sL.putConstraint(SpringLayout.WEST, pane, 100, SpringLayout.NORTH, panel);
		JButton prethodni, sledeci, izbrisati, novi, update, ok;
		JTextField ime, prezime, grad, email, dob;
		JLabel imeL, prezimeL, gradL, emailL, dobL;
		imeL = new JLabel("Ime");
		prezimeL = new JLabel("Prezime");
		gradL = new JLabel("Grad");
		emailL = new JLabel("Email");
		dobL = new JLabel("DOB");
		Dimension dim = new Dimension(90, 30);
		prethodni = new JButton("Nazad");
		prethodni.setPreferredSize(dim);
		sledeci = new JButton("Naprijed");
		sledeci.setPreferredSize(dim);
		izbrisati = new JButton("Izbriši");
		izbrisati.setPreferredSize(dim);
		novi = new JButton("Novi");
		novi.setPreferredSize(dim);
		update = new JButton("Izmjeni");
		update.setPreferredSize(dim);
		ok = new JButton("Potvrdi");
		ok.setPreferredSize(dim);
		panel.add(prethodni);
		panel.add(sledeci);
		panel.add(izbrisati);
		panel.add(novi);
		panel.add(update);
		panel.add(ok);
		ok.setVisible(false);
		sL.putConstraint(SpringLayout.NORTH, prethodni, 420, SpringLayout.WEST, panel);
		sL.putConstraint(SpringLayout.WEST, prethodni, 5, SpringLayout.NORTH, panel);

		sL.putConstraint(SpringLayout.NORTH, novi, 420, SpringLayout.WEST, panel);
		sL.putConstraint(SpringLayout.WEST, novi, 105, SpringLayout.NORTH, panel);
		sL.putConstraint(SpringLayout.NORTH, izbrisati, 420, SpringLayout.WEST, panel);
		sL.putConstraint(SpringLayout.WEST, izbrisati, 205, SpringLayout.NORTH, panel);
		sL.putConstraint(SpringLayout.NORTH, update, 420, SpringLayout.WEST, panel);
		sL.putConstraint(SpringLayout.WEST, update, 305, SpringLayout.NORTH, panel);
		sL.putConstraint(SpringLayout.NORTH, sledeci, 420, SpringLayout.WEST, panel);
		sL.putConstraint(SpringLayout.WEST, sledeci, 405, SpringLayout.NORTH, panel);
		dim = new Dimension(100, 40);
		ime = new JTextField();
		ime.setPreferredSize(dim);
		prezime = new JTextField();
		prezime.setPreferredSize(dim);
		email = new JTextField();
		email.setPreferredSize(dim);
		grad = new JTextField();
		grad.setPreferredSize(dim);
		dob = new JTextField();
		dob.setPreferredSize(dim);
		panel.add(ime);
		panel.add(imeL);
		sL.putConstraint(SpringLayout.NORTH, imeL, 250, SpringLayout.WEST, panel);
		sL.putConstraint(SpringLayout.WEST, imeL, 5, SpringLayout.NORTH, panel);
		sL.putConstraint(SpringLayout.NORTH, ime, 250, SpringLayout.WEST, panel);
		sL.putConstraint(SpringLayout.WEST, ime, 40, SpringLayout.NORTH, panel);
		panel.add(prezimeL);
		panel.add(prezime);
		sL.putConstraint(SpringLayout.NORTH, prezimeL, 250, SpringLayout.WEST, panel);
		sL.putConstraint(SpringLayout.WEST, prezimeL, 150, SpringLayout.NORTH, panel);
		sL.putConstraint(SpringLayout.NORTH, prezime, 250, SpringLayout.WEST, panel);
		sL.putConstraint(SpringLayout.WEST, prezime, 210, SpringLayout.NORTH, panel);
		panel.add(emailL);
		panel.add(email);
		sL.putConstraint(SpringLayout.NORTH, emailL, 250, SpringLayout.WEST, panel);
		sL.putConstraint(SpringLayout.WEST, emailL, 320, SpringLayout.NORTH, panel);
		sL.putConstraint(SpringLayout.NORTH, email, 250, SpringLayout.WEST, panel);
		sL.putConstraint(SpringLayout.WEST, email, 360, SpringLayout.NORTH, panel);
		panel.add(gradL);
		panel.add(grad);
		sL.putConstraint(SpringLayout.NORTH, gradL, 300, SpringLayout.WEST, panel);
		sL.putConstraint(SpringLayout.WEST, gradL, 5, SpringLayout.NORTH, panel);
		sL.putConstraint(SpringLayout.NORTH, grad, 300, SpringLayout.WEST, panel);
		sL.putConstraint(SpringLayout.WEST, grad, 40, SpringLayout.NORTH, panel);
		panel.add(dobL);
		panel.add(dob);
		sL.putConstraint(SpringLayout.NORTH, dobL, 300, SpringLayout.WEST, panel);
		sL.putConstraint(SpringLayout.WEST, dobL, 150, SpringLayout.NORTH, panel);
		sL.putConstraint(SpringLayout.NORTH, dob, 300, SpringLayout.WEST, panel);
		sL.putConstraint(SpringLayout.WEST, dob, 210, SpringLayout.NORTH, panel);

		ime.setText(t.getModel().getValueAt(row, 0).toString());
		prezime.setText(t.getModel().getValueAt(row, 1).toString());
		email.setText(t.getModel().getValueAt(row, 2).toString());
		grad.setText(t.getModel().getValueAt(row, 3).toString());
		dob.setText(t.getModel().getValueAt(row, 4).toString());
		userForm.pack();
		userForm.setVisible(true);
		prethodni.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int count = t.getRowCount();
				if (row > 0) {
					row--;
					ime.setText(t.getModel().getValueAt(row, 0).toString());
					prezime.setText(t.getModel().getValueAt(row, 1).toString());
					email.setText(t.getModel().getValueAt(row, 2).toString());
					grad.setText(t.getModel().getValueAt(row, 3).toString());
					dob.setText(t.getModel().getValueAt(row, 4).toString());
				} else if (row == 0) {
					row = t.getRowCount() - 1;
				}
			}

		});
		sledeci.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int count = t.getRowCount() - 1;

				if (count > row) {
					row++;
					ime.setText(t.getModel().getValueAt(row, 0).toString());
					prezime.setText(t.getModel().getValueAt(row, 1).toString());
					email.setText(t.getModel().getValueAt(row, 2).toString());
					grad.setText(t.getModel().getValueAt(row, 3).toString());
					dob.setText(t.getModel().getValueAt(row, 4).toString());
				} else if (row == count) {
					row = 0;
					ime.setText(t.getModel().getValueAt(row, 0).toString());
					prezime.setText(t.getModel().getValueAt(row, 1).toString());
					email.setText(t.getModel().getValueAt(row, 2).toString());
					grad.setText(t.getModel().getValueAt(row, 3).toString());
					dob.setText(t.getModel().getValueAt(row, 4).toString());
				}
			}

		});
		izbrisati.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});
		novi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				imenik user = new imenik(ime.getText(), prezime.getText(), email.getText(), grad.getText(),
						dob.getText());
				try {
					test.addToImenik(user);
					t = test.getTable(loged);
					userForm();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			

		});
		update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});
	}

	static void initForm() {
		introForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		introForm.setResizable(false);
		introForm.setPreferredSize(new Dimension(500, 500));
		Container panel = introForm.getContentPane();
		SpringLayout sL = new SpringLayout();
		panel.setLayout(sL);
		Dimension introButton = new Dimension(200, 40);
		logIn = new JButton("LOGIN");
		logIn.setPreferredSize(introButton);
		register = new JButton("REGISTER");
		register.setPreferredSize(introButton);
		user = new JLabel("Username:");
		user.setPreferredSize(introButton);
		pass = new JLabel("Password:");
		pass.setPreferredSize(introButton);
		username.setPreferredSize(introButton);
		password.setPreferredSize(introButton);
		panel.add(logIn);
		panel.add(register);
		panel.add(user);
		panel.add(pass);
		panel.add(username);
		panel.add(password);
		sL.putConstraint(SpringLayout.NORTH, user, 100, SpringLayout.WEST, panel);
		sL.putConstraint(SpringLayout.WEST, user, 125, SpringLayout.NORTH, panel);
		sL.putConstraint(SpringLayout.NORTH, username, 140, SpringLayout.WEST, panel);
		sL.putConstraint(SpringLayout.WEST, username, 125, SpringLayout.NORTH, panel);
		sL.putConstraint(SpringLayout.NORTH, pass, 180, SpringLayout.WEST, panel);
		sL.putConstraint(SpringLayout.WEST, pass, 125, SpringLayout.NORTH, panel);
		sL.putConstraint(SpringLayout.NORTH, password, 220, SpringLayout.WEST, panel);
		sL.putConstraint(SpringLayout.WEST, password, 125, SpringLayout.NORTH, panel);
		sL.putConstraint(SpringLayout.NORTH, logIn, 260, SpringLayout.WEST, panel);
		sL.putConstraint(SpringLayout.WEST, logIn, 125, SpringLayout.NORTH, panel);
		sL.putConstraint(SpringLayout.NORTH, register, 300, SpringLayout.WEST, panel);
		sL.putConstraint(SpringLayout.WEST, register, 125, SpringLayout.NORTH, panel);
		logIn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				KorisnikDaoImpl test = new KorisnikDaoImpl();
				try {
					if (test.isExist(username.getText(), password.getText())) {
						introForm.setVisible(false);
						userForm();
						loged = test.setKorisnikId(username.getText(), password.getText());
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		register.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});
		introForm.pack();
		introForm.setVisible(true);
	}

	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				initForm();

			}

		});
	}

}
