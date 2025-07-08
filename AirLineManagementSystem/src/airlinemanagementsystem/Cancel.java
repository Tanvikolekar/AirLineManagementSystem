
package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;


public class Cancel extends JFrame implements ActionListener{
    
    JTextField tfpnr;
    JLabel tfname,tffcode,cancellationno,labeldateoftravelled;
    JButton fetchButton,cancel;
    
    public Cancel(){
        
        Random random = new Random();
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel ("CANCELLATION");
        heading.setBounds(180,20,500,35);
        heading.setFont(new Font("TAHOMA",Font.PLAIN,32));
        heading.setForeground(Color.blue);
        add(heading);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/cancel.jpg"));
        Image i2 = i1.getImage().getScaledInstance(250,250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(470,120,250,250);
        add(image);
                
        
        JLabel lblpnr = new JLabel ("PNR Number");
       lblpnr.setBounds(60,80,150,25);
       lblpnr.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblpnr);
        
        tfpnr = new JTextField();
        tfpnr.setBounds(200,80,150,25);
        tfpnr.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(tfpnr);
        
        fetchButton = new JButton("Show Details");
        fetchButton.setBackground(Color.black);
        fetchButton.setForeground(Color.white);
        fetchButton.setBounds(380, 80, 120, 25);
        fetchButton.addActionListener(this);
        add(fetchButton);
        
        JLabel lblName = new JLabel ("Name");
        lblName.setBounds(80,130,150,25);
        lblName.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblName);
        
        tfname = new JLabel();
        tfname.setBounds(200,130,150,25);
        add(tfname);
        
        JLabel lblcancellation = new JLabel ("Cancellation No");
        lblcancellation.setBounds(80,180,150,25);
        lblcancellation.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblcancellation);
        
        cancellationno = new JLabel(" " + random.nextInt(100000) );
        cancellationno.setBounds(200,180,150,25);
        add(cancellationno);
        
        
        JLabel lblfcode = new JLabel ("Flight Code");
        lblfcode.setBounds(80,230,150,25);
        lblfcode.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblfcode);
        
        tffcode= new JLabel();
        tffcode.setBounds(200,230,150,25);
        add(tffcode);
        
        JLabel lbldateoftravelled = new JLabel ("Date");
        lbldateoftravelled.setBounds(80,280,150,25);
        lbldateoftravelled.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lbldateoftravelled);
        
        labeldateoftravelled = new JLabel ();
        labeldateoftravelled.setBounds(200,280,150,25);
        add(labeldateoftravelled);
        
        
        cancel= new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(220,330,120,25);
        cancel.addActionListener(this);
        add(cancel);
         
        setSize(800,450);
        setLocation(350,150);
        setVisible(true);
    }
    
    
     public void actionPerformed(ActionEvent ae) {
         if(ae.getSource()== fetchButton){
         String pnr = tfpnr.getText();
   
        try{
            Conn conn = new Conn();
            
            String query = "select * from reservation where PNR = '"+pnr+"'";
            ResultSet rs = conn.s.executeQuery(query);
            if(rs.next()){
                tfname.setText(rs.getString("name"));
                tffcode.setText(rs.getString("flightcode"));
                labeldateoftravelled.setText(rs.getString("ddate"));
            }else{
                JOptionPane.showMessageDialog(null,"please enter correct PNR");
            }
        }
        catch(Exception e){
        e.printStackTrace();
        }
         }
         else{
              if(ae.getSource()== cancel){
         String name = tfname.getText();
         String pnr = tfpnr.getText(); 
         String cancelno = cancellationno.getText();
         String fcode = tffcode.getText();
         String date = labeldateoftravelled.getText();
   
        try{
            Conn conn = new Conn();
            
            String query = "insert into cancel values('"+pnr+"','"+name+"','"+cancelno+"','"+fcode+"','"+date+"')";
            conn.s.executeUpdate(query);
            conn.s.executeUpdate("delete from reservation where PNR = '"+pnr+"'");
            
             JOptionPane.showMessageDialog(null,"Ticket Cancelled");
             setVisible(false);
            
        }
        catch(Exception e){
        e.printStackTrace();
        }
        }  
              }
         }
     public static void main(String[] args) {
    new Cancel();
}      
}




