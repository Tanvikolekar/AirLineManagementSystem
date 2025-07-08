package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;


public class BookFlight extends JFrame implements ActionListener{
    
    JTextField tfadhar;
    JLabel tfname,tfaddress,tfnationality,labelgender,labelfname,labelfcode;
    JButton fetchButton,flight, bookflight;
    Choice source,destination;
    JDateChooser dcdate;
    
    
    public BookFlight(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel ("Book Flight");
        heading.setBounds(420,20,500,35);
        heading.setFont(new Font("TAHOMA",Font.PLAIN,32));
        heading.setForeground(Color.blue);
        add(heading);
        
        JLabel lbladhar = new JLabel ("Adhar Number");
       lbladhar.setBounds(60,80,150,25);
       lbladhar.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lbladhar);
        
        tfadhar = new JTextField();
        tfadhar.setBounds(200,80,150,25);
        tfadhar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(tfadhar);
        
        fetchButton = new JButton("Fetch User");
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
        
        JLabel lblnationality = new JLabel ("Nationality");
        lblnationality.setBounds(80,180,150,25);
        lblnationality.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblnationality);
        
        tfnationality = new JLabel();
        tfnationality.setBounds(200,180,150,25);
        add(tfnationality);
        
        
        JLabel lbladdress = new JLabel ("Address");
        lbladdress.setBounds(80,230,150,25);
        lbladdress.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lbladdress);
        
        tfaddress= new JLabel();
        tfaddress.setBounds(200,230,150,25);
        add(tfaddress);
        
        JLabel lblgender = new JLabel ("Gender");
        lblgender.setBounds(80,280,150,25);
        lblgender.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblgender);
        
        labelgender = new JLabel ();
        labelgender.setBounds(200,280,150,25);
        add(labelgender);
        
        JLabel lblsource = new JLabel ("Source");
        lblsource.setBounds(80,330,150,25);
        lblsource.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblsource);
        
        source = new Choice();
        source.setBounds(230,330,120,25);
        add(source);
        
        JLabel lbldest = new JLabel ("Destination");
        lbldest.setBounds(80,380,150,25);
        lbldest.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lbldest);
        
        destination = new Choice();
        destination.setBounds(230,380,120,25);
        add(destination);
        
        try{
            Conn conn = new Conn();
            String query ="select*from flightdetails";
            ResultSet rs = conn.s.executeQuery(query);
            
            while(rs.next()){
                source.add(rs.getString("source"));
                destination.add(rs.getString("destination"));
            }
        }catch(Exception e){
        e.printStackTrace();
        }
        
        flight = new JButton(" fetch flights");
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.WHITE);
        flight.setBounds(380,380,120,25);
        flight.addActionListener(this);
        add(flight);
        
         JLabel lblfname = new JLabel ("Flight Name");
        lblfname.setBounds(80,430,150,25);
        lblfname.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblfname);
        
        labelfname= new JLabel();
        labelfname.setBounds(200,430,150,25);
        add(labelfname);
        
        JLabel lblcode = new JLabel ("Flight Code");
        lblcode.setBounds(80,480,150,25);
        lblcode.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblcode);
        
        labelfcode= new JLabel();
        labelfcode.setBounds(200,480,150,25);
        add(labelfcode);
        
        JLabel lbldate = new JLabel ("Date of travel");
        lbldate.setBounds(80,530,150,25);
        lbldate.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lbldate);
        
        dcdate= new JDateChooser();
        dcdate.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        dcdate.setBounds(200,530,150,25);
        add(dcdate);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/details.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450,320,Image.SCALE_DEFAULT);
        ImageIcon image  = new ImageIcon(i2);
        JLabel lblimage = new JLabel();
        lblimage.setBounds(550,80,500,410);
        lblimage.setIcon(image);
        add(lblimage);
        
        bookflight = new JButton(" Book Flight");
        bookflight.setBackground(Color.BLACK);
        bookflight.setForeground(Color.WHITE);
        bookflight.setBounds(200,580,150,25);
        bookflight.addActionListener(this);
        add(bookflight);
        
        setSize(1100,650);
        setLocation(300,150);
        setVisible(true);
    }
    
    
     public void actionPerformed(ActionEvent ae) {
         if(ae.getSource()== fetchButton){
         String adhar = tfadhar.getText();
   
        try{
            Conn conn = new Conn();
            
            String query = "select * from passenger where adhar = '"+adhar+"'";
            ResultSet rs = conn.s.executeQuery(query);
            if(rs.next()){
                tfname.setText(rs.getString("name"));
                tfaddress.setText(rs.getString("address"));
                tfnationality.setText(rs.getString("nationality"));
                labelgender.setText(rs.getString("gender"));
            }else{
                JOptionPane.showMessageDialog(null,"please enter correct adhar");
            }
        }
        catch(Exception e){
        e.printStackTrace();
        }
         }
         else{
              if(ae.getSource()== flight){
         String src = source.getSelectedItem();
         String dest = destination.getSelectedItem(); 
   
        try{
            Conn conn = new Conn();
            
            String query = "select * from flightdetails where source = '"+src+"' and destination = '"+dest+"'";
            ResultSet rs = conn.s.executeQuery(query);
            if(rs.next()){
                labelfname.setText(rs.getString("f_name"));
                labelfcode.setText(rs.getString("f_code"));
             
            }else{
                JOptionPane.showMessageDialog(null,"NO Flights Found");
            }
        }
        catch(Exception e){
        e.printStackTrace();
        }
         }else{
                Random random = new Random();
                String adhar = tfadhar.getText();
                String name = tfname.getText();
                String nationality = tfnationality.getText();
                String flightname = labelfname.getText();
                String flightcode = labelfcode.getText();
                String src =  source.getSelectedItem();
                String dest = destination.getSelectedItem();
                String ddate = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
                
                try{
                Conn conn = new Conn();
            
                String query = "insert into reservation values( 'PNR-"+random.nextInt(1000000)+"','TIC-"+random.nextInt(1000)+"','"+name+"', '"+nationality+"', '"+adhar+"', '"+flightname+"', '"+flightcode+"','"+src+"','"+dest+"','"+ddate+"')";
                conn.s.executeUpdate(query);
 
                JOptionPane.showMessageDialog(null,"Ticket Booked Successfully");
                setVisible(false);
            }catch(Exception e){
        e.printStackTrace();
        }
        }
                
              }
              
         }
     public static void main(String[] args) {
    new BookFlight();
}      
}



