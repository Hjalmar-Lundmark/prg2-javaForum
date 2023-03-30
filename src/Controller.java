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
                //set login visible

            }
        });
        theView.getRegisterButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //set register visible

            }
        });

    }

    public static void main(String[] args) {
        View theView = new View();
        Model theModel = new Model();
        Controller theController = new Controller(theView,theModel);
    }
}
