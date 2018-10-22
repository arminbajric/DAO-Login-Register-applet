package RegisterLogin;

import java.awt.Container;
import java.awt.Dimension;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

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
