import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;


public class AccountLogin extends JFrame{

	static AccountLogin frame;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AccountLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public AccountLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,450,300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		
		JLabel lblAccountLogin = new JLabel("Account Login");
		lblAccountLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAccountLogin.setForeground(Color.DARK_GRAY);
		
		JLabel lblName = new JLabel("Name:");
		textField = new JTextField();
		
		JLabel lblPassword = new JLabel("Password:");
		passwordField = new JPasswordField();
		
		JButton btnLogin = new JButton();
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name=textField.getText();
				String password=String.valueOf(passwordField.getPassword());
				boolean status = AccountDao.Validate(name, password);
				
				if(status) {
					AccountSection.main(new String[] {});
					frame.dispose();
				}
				else {
					JOptionPane.showMessageDialog(AccountLogin.this,"Sorry, username or password error!","Login error!",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		JButton btnBack = new JButton("back");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(28)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPassword)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblName)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(76)
											.addComponent(lblAccountLogin))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(54)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(passwordField)
												.addComponent(textField, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)))))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(158)
							.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addGap(52)
							.addComponent(btnBack)))
					.addContainerGap(78, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAccountLogin)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBack))
					.addContainerGap(96, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	}

