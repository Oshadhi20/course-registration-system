
package edu.ijse.crs.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import edu.ijse.crs.dao.UserDao;

public class LoginForm extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private UserDao userDao;

    public LoginForm() {
        userDao = new UserDao();

        setTitle("Course Registration - Login");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                System.out.println("Attempting login for user: " + username);

                if (userDao.validateUser(username, password)) {
                    JOptionPane.showMessageDialog(LoginForm.this, "Login Successful!");                    
                    new MainDashboard().setVisible(true);
                    dispose();
                } else {
                    System.out.println("Attempting login for user: " + username);
                    JOptionPane.showMessageDialog(LoginForm.this, "Invalid Credentials!");
                }
            }
        });

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(new JLabel()); // Empty label for spacing
        add(loginButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginForm().setVisible(true));
    }
}
