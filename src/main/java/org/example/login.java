package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class login {
    private JPasswordField passwordtxt;
    public JPanel mainPanel;
    private JTextField usertxt;
    private JButton loginButton;
    private JButton registerButton;

    public login() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url ="jdbc:mysql://localhost:3306/estudiantes2024b";
                String user = "root";
                String password= "";

                try{
                    String parameter= usertxt.getText();
                    String pass= passwordtxt.getText();
                    Connection con= DriverManager.getConnection(url, user, password);
                    System.out.println("Se ha conectado con la base de datos");
                    Statement stmt = con.createStatement();
                    String query = "select * from estudiantes where cedula="+parameter;
                    String query2= "select * from estudiantes where cedula="+pass;


                    ResultSet rs = stmt.executeQuery(query);
                    while(rs.next()){
                        System.out.println(rs.getString("cedula"));
                        System.out.println(rs.getString("nombre"));
                        System.out.println(rs.getString("b1"));
                        System.out.println(rs.getString("b2"));
                    }
                    con.close();

                } catch (SQLException e1){
                    throw new RuntimeException(e1);
                }
            }
        });
    }
}


