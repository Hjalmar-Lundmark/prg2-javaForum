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

    public String getTextField1() {
        return textField1.getText();
    }

    public String getPasswordField1() {
        return passwordField1.getText();
    }

    public String getPasswordField2() {
        return passwordField2.getText();
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
