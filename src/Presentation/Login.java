package Presentation;
import Metier.Gestionnaires.Gestionnaire_prof;
import Persistance.DAO_PROFESSEUR;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Persistance.*;
import Presentation.tools.RoundedPasswordField;
import Presentation.tools.RoundedTextField;

public class Login extends JFrame implements ActionListener{
    private JLabel connect;
    private JTextField username;
    private JPasswordField pwd;
    private JButton login;
    private JPanel l;
    private JComboBox type;
    private JLabel labeltype;
    private Gestionnaire_prof prof= new Gestionnaire_prof();
    ImageIcon icon2 = new ImageIcon(this.getClass().getResource("/login (2).png"));
    public void initialiser(){
        username = new JTextField("username");
        pwd = new JPasswordField("Password");
        labeltype=new JLabel("Type :");
        String s[]={"Etudiant","Encadrant","chef de filière","chef de département","responsable","Admin"};
        type=new JComboBox(s);
        login=new JButton("Connecter");
        l=new JPanel(null);
        Icon icon=new ImageIcon("C:\\login (3).png");
        connect =new JLabel(icon);
    }
    public void dessiner(){
        Color c=new Color(0, 176, 255);

        connect.setHorizontalAlignment(JLabel.CENTER);
        connect.setBounds(130,20,128,128);

        username.setBorder(BorderFactory.createTitledBorder(new EmptyBorder(new Insets(2, 14, 5, 14))));
        pwd.setBorder(BorderFactory.createTitledBorder(new EmptyBorder(new Insets(2, 14, 5, 14))));
        username.setBounds(96, 168, 200, 30);
        pwd.setBounds(96, 218, 200, 30);
        username.setHorizontalAlignment(SwingConstants.CENTER);
        pwd.setHorizontalAlignment(SwingConstants.CENTER);
        username.setBackground(Color.decode("#E8EBEE"));
        username.setForeground(Color.decode("#939699"));
        pwd.setBackground(Color.decode("#E8EBEE"));
        pwd.setForeground(Color.decode("#939699"));

        String s[]={"Admin","Etudiant","Encadrant","chef de filière","chef de département","responsable"};
        type=new JComboBox(s);
        type.setBounds(96,268,200,30);
        type.setBackground(Color.decode("#E8EBEE"));
        type.setForeground(Color.decode("#939699"));
        type.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        login.setBounds(96, 330, 200, 30);
        login.setBackground(c);
        login.setForeground(Color.white);
        login.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        login.setBorder(BorderFactory.createTitledBorder(new EmptyBorder(new Insets(2, 14, 5, 14))));

        l.add(connect);
        l.add(username);
        l.add(pwd);
        l.add(login);
        l.add(type);
        l.add(labeltype);
        l.setBackground(Color.decode("#A3D7F7"));
    }
    public Login(){
        this.initialiser();
        this.dessiner();
        setTitle("Login");
        login.addActionListener(this);
        this.setSize(new Dimension(400,450));
        this.setLocationRelativeTo(null);
        this.setIconImage(icon2.getImage());
        getContentPane().add(l);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==login){
            if(type.getSelectedItem().equals("Admin")){
                 if(username.getText().equals("Admin") && pwd.getText().equals("Admin")){
                     this.setVisible(false);
                       Admin a= new Admin();
                 }
                 else{
                     JOptionPane.showMessageDialog(null, "échec", "Message d'erreur",
                             JOptionPane.ERROR_MESSAGE);
                 }
            }
            if(type.getSelectedItem().equals("chef de filière"))
            {
                if(prof.authentif_chefFil(username.getText(),pwd.getText())){
                    this.setVisible(false);
                    chef_fil fil=new chef_fil();
                }
                else{
                    JOptionPane.showMessageDialog(null, "échec", "Message d'erreur",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
            if(type.getSelectedItem().equals("responsable"))
            {
                if(prof.authentif_respo(username.getText(),pwd.getText())){
                    this.setVisible(false);
                    respo_labo r=new respo_labo();
                }
                else{
                    JOptionPane.showMessageDialog(null, "échec", "Message d'erreur",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
            if(type.getSelectedItem().equals("chef de département")){
                if(prof.authentif_Chefdep(username.getText(),pwd.getText())){
                    this.setVisible(false);
                    chef_dep d= new chef_dep();
                }
                else{
                    JOptionPane.showMessageDialog(null, "échec", "Message d'erreur",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
        }
    }
}
