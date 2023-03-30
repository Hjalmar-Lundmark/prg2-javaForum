import javax.swing.*;

public class register {
    private JPanel root;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JButton registerButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Register");
        frame.setContentPane(new register().root);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        //frame.setVisible(true);
    }
}
