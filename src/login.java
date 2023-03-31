import javax.swing.*;

public class login {
    private JPanel root;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton loginButton;

    public JPanel getRoot() {
        return root;
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public JPasswordField getPasswordField1() {
        return passwordField1;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Login");
        frame.setContentPane(new login().root);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        //frame.setVisible(true);
    }
}
