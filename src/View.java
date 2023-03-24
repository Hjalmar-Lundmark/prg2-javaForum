import javax.swing.*;

public class View {
    private JPanel root;
    private JTextArea textArea1;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton button1;

    public JPanel getPanel() {
        return root;
    }

    public void addPost(String in) {
        textArea1.append(in);
    }
}
