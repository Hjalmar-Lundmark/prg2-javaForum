import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    View theView;
    Model theModel;
    login loginPage;
    register registerPage;
    post postPage;

    public Controller(View theView, Model theModel, login l, register r, post p) {
        this.theView = theView;
        this.theModel = theModel;

        //sub pages
        loginPage = l;
        registerPage = r;
        postPage = p;

        JFrame frame = new JFrame("Forum");
        frame.setContentPane(theView.getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);

        JFrame loginFrame = new JFrame("Login");
        loginFrame.setContentPane(loginPage.getRoot());
        loginFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        loginFrame.pack();

        JFrame registerFrame = new JFrame("Login");
        registerFrame.setContentPane(registerPage.getRoot());
        registerFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        registerFrame.pack();

        JFrame postFrame = new JFrame("Login");
        postFrame.setContentPane(postPage.getRoot());
        postFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        postFrame.pack();

        theModel.connect();
        theView.addPost(theModel.getPosts());

        // Open other views
        theView.getLoginButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginFrame.setVisible(true);
            }
        });
        theView.getRegisterButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerFrame.setVisible(true);
            }
        });
        theView.getCreatePostButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                postFrame.setVisible(true);
            }
        });

        // stuff
        loginPage.getLoginButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                theModel.connect();
                System.out.println(loginPage.getTextField1() + " och " + loginPage.getPasswordField1());
                theModel.login(loginPage.getTextField1(), loginPage.getPasswordField1());
                if (theModel.isLoggedIn()) {
                    theView.changeLabel("Logged in as " + theModel.getUsername());
                    theView.getLoginButton().setVisible(false);
                    theView.getRegisterButton().setVisible(false);
                    theView.getCreatePostButton().setEnabled(true);
                } else {
                    theView.changeLabel("Guest test");
                }
                loginFrame.setVisible(false);
            }
        });
        registerPage.getRegisterButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(loginPage.getTextField1() + " och " + loginPage.getPasswordField1() + " och " + registerPage.getPasswordField2());
                theModel.register(registerPage.getTextField1(), registerPage.getPasswordField1(), registerPage.getPasswordField2());


                registerFrame.setVisible(false);
            }
        });


    }

    public static void main(String[] args) {
        View theView = new View();
        Model theModel = new Model();
        login l = new login();
        register r = new register();
        post p = new post();
        Controller theController = new Controller(theView,theModel, l, r, p);
    }
}
