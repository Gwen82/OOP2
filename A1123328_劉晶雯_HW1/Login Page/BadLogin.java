
import javax.swing.*;
import java.awt.*;

public class BadLogin extends JFrame {

    public BadLogin() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel l1 = new JLabel("Username:");
        l1.setBounds(30, 25, 200, 25);

        JTextField t1 = new JTextField();
        t1.setBounds(90, 25, 160, 25);

        JLabel l2 = new JLabel("Password:");
        l2.setBounds(30, 65, 200, 25);

        JPasswordField t2 = new JPasswordField();
        t2.setBounds(90, 65, 160, 25);

        JButton btn = new JButton("Login");
        btn.setBounds(90, 110, 100, 30);

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(btn);

        btn.addActionListener(e -> {
            String account = t1.getText();
            String password = new String(t2.getPassword());

            if (account.equals("admin") && password.equals("123")) {
                System.out.println("Login Succes!");
                JOptionPane.showMessageDialog(this, "Login Succes!");
            } else {
                JOptionPane.showMessageDialog(this, "Username or Password wrong!");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new BadLogin();
    }
}