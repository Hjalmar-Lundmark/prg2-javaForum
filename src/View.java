import javax.swing.*;

public class View {
    private JPanel root;
    private JTextArea textArea1;
    private JButton registerButton;
    private JButton loginButton;

    public JPanel getPanel() {
        return root;
    }

    public void addPost(String in) {
        textArea1.append(in);
    }

    public JButton getRegisterButton() {
        return registerButton;
    }

    public JButton getLoginButton() {
        return loginButton;
    }
}
