import javax.swing.*;

public class register {
    private JPanel root;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JButton registerButton;

    public JPanel getRoot() {
        return root;
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public JPasswordField getPasswordField1() {
        return passwordField1;
    }

    public JPasswordField getPasswordField2() {
        return passwordField2;
    }

    public JButton getRegisterButton() {
        return registerButton;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Register");
        frame.setContentPane(new register().root);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        //frame.setVisible(true);
    }
}
