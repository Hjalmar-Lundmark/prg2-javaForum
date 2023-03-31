import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    View theView;
    Model theModel;

    public Controller(View theView, Model theModel) {
        this.theView = theView;
        this.theModel = theModel;

        login loginPage;
        register registerPage;
        post postPage;

        JFrame frame = new JFrame("Forum");
        frame.setContentPane(theView.getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);


        theModel.connect();
        theView.addPost(theModel.getPosts());

        theView.getLoginButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //set loginView visible

            }
        });
        theView.getRegisterButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //set registerView visible

            }
        });
        theView.getCreatePostButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //set postView visible

            }
        });

        //TODO: fix, just an idea for now
        if (theModel.isLoggedIn()) {
            theView.changeLabel("Logged in as " + theModel.getUsername());
            theView.getLoginButton().setVisible(false);
            theView.getRegisterButton().setVisible(false);
        } else {
            theView.changeLabel("Guest");
        }

    }

    public static void main(String[] args) {
        View theView = new View();
        Model theModel = new Model();
        Controller theController = new Controller(theView,theModel);
    }
}
