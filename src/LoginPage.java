import model.User;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Sat Nov 09 01:19:45 IST 2019
 */



/**
 * @author abishek Yelagani
 */
public class LoginPage extends JPanel {
    public LoginPage() {
        initComponents();
        Login.setVisible(true);
    }

    private void loginActionPerformed(ActionEvent e) {
        String userName = textField1.getText();
        String password = passwordField1.getText();
        //TODO:verify username,password if null.
        DatabaseController databaseController = new DatabaseController();
        databaseController.initialiseDatabase();
        if(password.equals(databaseController.Verify(userName)))
        {
            User user = databaseController.getUserDetails(userName.toString());
            if(!user.getStatus().equals("Free"))
            {
                databaseController.closeDatabaseConnection();
                StatusPage statusPage = new StatusPage(user);
                statusPage.setVisible(true);
                Login.dispose();
            }
            else
            {
                databaseController.closeDatabaseConnection();
                MainPage mainPage = new MainPage(userName);
                mainPage.setVisible(true);
                Login.dispose();
            }

        }
        else
        {
            databaseController.closeDatabaseConnection();
            JOptionPane.showMessageDialog(null,"Please Enter Correct Details");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - abishek Yelagani
        Login = new JFrame();
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        passwordField1 = new JPasswordField();
        button1 = new JButton();

        //======== Login ========
        {
            Login.setTitle("LOGIN");
            Container LoginContentPane = Login.getContentPane();

            //---- label1 ----
            label1.setText("UserName");

            //---- label2 ----
            label2.setText("Password");

            //---- button1 ----
            button1.setText("LOGIN");
            button1.addActionListener(e -> loginActionPerformed(e));

            GroupLayout LoginContentPaneLayout = new GroupLayout(LoginContentPane);
            LoginContentPane.setLayout(LoginContentPaneLayout);
            LoginContentPaneLayout.setHorizontalGroup(
                LoginContentPaneLayout.createParallelGroup()
                    .addGroup(LoginContentPaneLayout.createSequentialGroup()
                        .addGroup(LoginContentPaneLayout.createParallelGroup()
                            .addGroup(LoginContentPaneLayout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addGroup(LoginContentPaneLayout.createParallelGroup()
                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
                                .addGap(72, 72, 72)
                                .addGroup(LoginContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                    .addComponent(passwordField1, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)))
                            .addGroup(LoginContentPaneLayout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addComponent(button1, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(40, Short.MAX_VALUE))
            );
            LoginContentPaneLayout.setVerticalGroup(
                LoginContentPaneLayout.createParallelGroup()
                    .addGroup(LoginContentPaneLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(LoginContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(LoginContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addComponent(button1)
                        .addContainerGap(56, Short.MAX_VALUE))
            );
            Login.pack();
            Login.setLocationRelativeTo(Login.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - abishek Yelagani
    private JFrame Login;
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
