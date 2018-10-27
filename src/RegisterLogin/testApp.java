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
	    JButton prethodni,sledeci,izbrisati,novi,update,ok;
		JTextField ime,prezime,grad,email,dob;
		JLabel imeL,prezimeL,gradL,emailL,dobL;
		Dimension dim = new Dimension(90, 30);
		prethodni=new JButton("Nazad");
		prethodni.setPreferredSize(dim);
		sledeci=new JButton("Naprijed");
		sledeci.setPreferredSize(dim);
		izbrisati=new JButton("Izbriši");
		izbrisati.setPreferredSize(dim);
		novi=new JButton("Novi");
		novi.setPreferredSize(dim);
		update=new JButton("Izmjeni");
		update.setPreferredSize(dim);
		ok=new JButton("Potvrdi");
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
		sL.putConstraint(SpringLayout.WEST,izbrisati, 205, SpringLayout.NORTH, panel);
		sL.putConstraint(SpringLayout.NORTH, update, 420, SpringLayout.WEST, panel);
		sL.putConstraint(SpringLayout.WEST, update, 305, SpringLayout.NORTH, panel);
		sL.putConstraint(SpringLayout.NORTH, sledeci, 420, SpringLayout.WEST, panel);
		sL.putConstraint(SpringLayout.WEST,sledeci, 405, SpringLayout.NORTH, panel);
		
		userForm.pack();
		userForm.setVisible(true);
		prethodni.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		sledeci.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
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
