
package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Home extends JFrame implements ActionListener{
    
    public Home(){
        
    setLayout(null);
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/front.jpg"));
    JLabel image = new JLabel(i1);
    image.setBounds(0,0,1600,800);
    add(image);
    
    JLabel heading = new JLabel("AIR INDIA WELCOMES YOU ");
    heading.setBounds(500, 40, 1000, 40);
    heading.setForeground(Color.blue);
    heading.setFont (new Font("Tahoma" ,Font.PLAIN ,36));
    image.add(heading);
    
    JMenuBar menubar = new JMenuBar();
    setJMenuBar(menubar);
    
    JMenu details = new JMenu("Details");
    menubar.add(details);
    
    JMenuItem flightDetails = new JMenuItem("Flight Details");
    flightDetails.addActionListener(this);
    details.add(flightDetails);
    
    JMenuItem coustmerDetails = new JMenuItem("Add coustmer Details");
    coustmerDetails.addActionListener(this);
    details.add(coustmerDetails);
    
    JMenuItem bookFlight = new JMenuItem("Book Flight");
     bookFlight.addActionListener(this);
    details.add(bookFlight);
    
    JMenuItem journyDetails = new JMenuItem("Journy Details");
    journyDetails.addActionListener(this);
    details.add(journyDetails);
    
    JMenuItem ticketCancellation = new JMenuItem("Cancel Ticket");
    ticketCancellation.addActionListener(this);
    details.add(ticketCancellation);
    
    JMenu ticket = new JMenu("Ticket");
    menubar.add(ticket);
    
    JMenuItem bordingPass = new JMenuItem("Bording Pass");
    bordingPass.addActionListener(this);
    ticket.add(bordingPass);
    
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    setLocation(600,250);
    setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
            String text = ae.getActionCommand();
            if(text.equals("Add coustmer Details")){
                new AddCustomer();
            }else if(text.equals("Flight Details")){
                new FlightInfo();
            }else if(text.equals("Book Flight")){
                new BookFlight();
            }else if(text.equals("Journy Details")){
                new JourneyDetails();
            }
            else if(text.equals("Cancel Ticket")){
                new Cancel();
            }
            else if(text.equals("Bording Pass")){
                new BoardingPass();
            }
        }
        
    public static void main(String args []){
        new Home();
    }
}

