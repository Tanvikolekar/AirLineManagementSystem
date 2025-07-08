package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AddCustomer extends JFrame implements ActionListener{
    
    JTextField tfname,tfnationality,tfadhar,tfaddress,tfphone;
    JRadioButton rbmale,rbfemale;
    
    public AddCustomer(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel ("Add Customer Details");
        heading.setBounds(300,20,500,35);
        heading.setFont(new Font("TAHOMA",Font.PLAIN,32));
        heading.setForeground(Color.blue);
        add(heading);
        
        JLabel lblName = new JLabel ("Name");
        lblName.setBounds(80,80,150,25);
        lblName.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblName);
        
        tfname = new JTextField();
        tfname.setBounds(200,80,250,25);
        tfname.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(tfname);
        
        JLabel lblnationality = new JLabel ("Nationality");
       lblnationality.setBounds(80,130,150,25);
       lblnationality.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblnationality);
        
        tfnationality = new JTextField();
        tfnationality.setBounds(200,130,250,25);
        tfnationality.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(tfnationality);
        
        JLabel lbladhar = new JLabel ("Adhar Number");
       lbladhar.setBounds(80,180,150,25);
       lbladhar.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lbladhar);
        
        tfadhar = new JTextField();
        tfadhar.setBounds(200,180,250,25);
        tfadhar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(tfadhar);
        
        JLabel lbladdress = new JLabel ("Address");
       lbladdress.setBounds(80,230,150,25);
       lbladdress.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lbladdress);
        
        tfaddress= new JTextField();
        tfaddress.setBounds(200,230,250,25);
        tfaddress.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(tfaddress);
        
        JLabel lblgender = new JLabel ("Gender");
       lblgender.setBounds(80,280,150,25);
       lblgender.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblgender);
        
        ButtonGroup gendergroup = new ButtonGroup();
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(220,280,70,25);
        rbmale.setBackground(Color.white);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(300,280,70,25);
        rbfemale.setBackground(Color.white);
        add(rbfemale);
        
        gendergroup.add(rbmale);
        gendergroup.add(rbfemale);
        
        JLabel lblphone = new JLabel ("Phone Number");
       lblphone.setBounds(80,330,150,25);
       lblphone.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblphone);
        
        tfphone= new JTextField();
        tfphone.setBounds(200,330,250,25);
        tfphone.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(tfphone);
        
        JButton save = new JButton("Save");
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.setBounds(220,400,180,25);
        save.addActionListener(this);
        add(save);
        
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/emp.png"));
        JLabel lblimage = new JLabel();
        lblimage.setBounds(450,80,300,400);
        lblimage.setIcon(image);
        add(lblimage);
        
        setSize(900,600);
        setLocation(300,150);
        setVisible(true);
    }
    
    
     public void actionPerformed(ActionEvent ae) {
         String name = tfname.getText();
         String nationality = tfnationality.getText();
         String phone = tfphone.getText();
         String adhar = tfadhar.getText();
         String address = tfaddress.getText();
         String gender = null;
         
         if(rbmale.isSelected()){
             gender = "male";
        }else{
             gender = "female";
         }
             
        try{
            Conn conn = new Conn();
            
String query = "insert into passenger(name, nationality, phone, adhar, address, gender) " +
               "values('"+name+"', '"+nationality+"', '"+phone+"', '"+adhar+"', '"+address+"', '"+gender+"')";
           conn.s.executeUpdate(query);
           
           JOptionPane.showMessageDialog(null,"Costomer Detailed Added Susccessfully");
        }
        catch(Exception e){
        e.printStackTrace();
        }
        
    }
    
    public static void main (String args[]){
         new AddCustomer();
        
    }

   
   
}
