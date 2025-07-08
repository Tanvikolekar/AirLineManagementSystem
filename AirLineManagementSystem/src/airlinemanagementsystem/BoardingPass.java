
package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;


public class BoardingPass extends JFrame implements ActionListener{
    
    JTextField tfpnr;
    JLabel tfname,lblsrc,tfnationality,lbldest,labelfname,labelfcode,labeldate;
    JButton fetchButton;
    
    public BoardingPass(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel ("AIR INDIA");
        heading.setBounds(380,10,450,35);
        heading.setFont(new Font("TAHOMA",Font.PLAIN,32));
        add(heading);
        
        JLabel subheading = new JLabel ("Boarding Pass");
        subheading.setBounds(360,50,330,30);
        subheading.setFont(new Font("TAHOMA",Font.PLAIN,24));
        subheading.setForeground(Color.blue);
        add(subheading);
        
        JLabel lblpnrdetails = new JLabel ("PNR DETAILS");
        lblpnrdetails.setBounds(60,100,150,25);
        lblpnrdetails.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblpnrdetails);
        
        tfpnr = new JTextField();
        tfpnr.setBounds(200,100,150,25);
        tfpnr.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(tfpnr);
        
        fetchButton = new JButton("Fetch User");
        fetchButton.setBackground(Color.black);
        fetchButton.setForeground(Color.white);
        fetchButton.setBounds(380, 100, 120, 25);
        fetchButton.addActionListener(this);
        add(fetchButton);
        
        JLabel lblName = new JLabel ("NAME");
        lblName.setBounds(80,140,150,25);
        lblName.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblName);
        
        tfname = new JLabel();
        tfname.setBounds(200,140,150,25);
        add(tfname);
        
        JLabel lblnationality = new JLabel ("NATIONALITY");
        lblnationality.setBounds(80,180,150,25);
        lblnationality.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblnationality);
        
        tfnationality = new JLabel();
        tfnationality.setBounds(200,180,150,25);
        add(tfnationality);
        
        
        JLabel lbladdress = new JLabel ("SRC");
        lbladdress.setBounds(80,220,150,25);
        lbladdress.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lbladdress);
        
        lblsrc= new JLabel();
        lblsrc.setBounds(200,220,150,25);
        add(lblsrc);
        
        JLabel lbldestination = new JLabel ("DEST");
        lbldestination.setBounds(380,220,150,25);
        lbldestination.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lbldestination);
        
        lbldest = new JLabel ();
        lbldest.setBounds(540,220,150,25);
        add(lbldest);
        
        JLabel lblfname = new JLabel ("FLIGHT NAME");
        lblfname.setBounds(80,260,150,25);
        lblfname.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblfname);
        
        labelfname= new JLabel();
        labelfname.setBounds(200, 260, 150, 25);
        add(labelfname);
        
        JLabel lblcode = new JLabel ("FLIGHT CODE");
        lblcode.setBounds(380,260,150,25);
        lblcode.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblcode);
        
        labelfcode= new JLabel();
        labelfcode.setBounds(540,260,150,25);
        add(labelfcode);
        
        JLabel lbldate = new JLabel ("DATE");
        lbldate.setBounds(80,300,150,25);
        lbldate.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lbldate);
        
        labeldate= new JLabel();
        labeldate.setBounds(200,300,150,25);
        add(labeldate);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/airindia.png"));
        Image i2 = i1.getImage().getScaledInstance(300,230,Image.SCALE_DEFAULT);
        ImageIcon image  = new ImageIcon(i2);
        JLabel lblimage = new JLabel();
        lblimage.setBounds(600,0,300,300);
        lblimage.setIcon(image);
        add(lblimage);
        
        setSize(1000,450);
        setLocation(300,150);
        setVisible(true);
    }
    
    
     public void actionPerformed(ActionEvent ae) {
        String pnr = tfpnr.getText();

        try {
            Conn conn = new Conn();

            String query = "select * from reservation where PNR = '" + pnr+ "'";
            ResultSet rs = conn.s.executeQuery(query);
            if(rs.next()){
                tfname.setText(rs.getString("name"));
                lblsrc.setText(rs.getString("src"));
                tfnationality.setText(rs.getString("nationality"));
                lbldest.setText(rs.getString("dest"));
                labelfname.setText(rs.getString("flightname"));
                labelfcode.setText(rs.getString("flightcode"));
                labeldate.setText(rs.getString("ddate"));
            }else{
                JOptionPane.showMessageDialog(null,"please enter correct PNR");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     public static void main(String[] args) {
    new BoardingPass();
}      
}

