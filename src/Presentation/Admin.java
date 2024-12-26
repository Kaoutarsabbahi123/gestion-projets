package Presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends JFrame implements ActionListener {
    private JLabel bienvenue;
    private JButton accueil;
    private JButton prof;
    private JButton etd;
    private JButton fil;
    private JButton labo;
    private JButton dep;
    private JButton entrp;
    private JButton projet;
    private JPanel panel;
    private JButton logout;
    ImageIcon icon2 = new ImageIcon(this.getClass().getResource("/education (3).png"));
    public void initialiser(){
        panel=new JPanel(null);
        bienvenue =new JLabel("BIENVENUE");
        prof= new JButton("PROFESSEUR");
        etd= new JButton("ETUDIANT");
        fil= new JButton("FILIERE");
        labo= new JButton("LABORATOIRE");
        dep= new JButton("DEPARTEMENT");
        projet= new JButton("PROJET");
        entrp= new JButton("ENTREPRISE");
    }
    public Admin(){
        this.initialiser();
        this.Dessiner();
        this.setSize(new Dimension(900,600));
        this.setTitle("Admin");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setIconImage(icon2.getImage());
        this.setVisible(true);
        getContentPane().setBackground(Color.white);
        getContentPane().add(panel);
    }

    public void Dessiner(){
        Color c=new Color(0, 176, 255);

        bienvenue.setForeground(c);
        bienvenue.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        bienvenue.setBounds(387,10,180,70);


        prof.setBackground(c);
        prof.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        prof.setForeground(Color.white);
        prof.setBorder(BorderFactory.createTitledBorder(new EmptyBorder(new Insets(2, 14, 5, 14))));
        prof.setBounds(480,95,200,50);



        etd.setBackground(c);
        etd.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        etd.setForeground(Color.white);
        etd.setBorder(BorderFactory.createTitledBorder(new EmptyBorder(new Insets(2, 14, 5, 14))));
        etd.setBounds(200,95,200,50);


        fil.setBackground(c);
        fil.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        fil.setForeground(Color.white);
        fil.setBorder(BorderFactory.createTitledBorder(new EmptyBorder(new Insets(2, 14, 5, 14))));
        fil.setBounds(480,200,200,50);


        labo.setBackground(c);
        labo.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        labo.setForeground(Color.white);
        labo.setBorder(BorderFactory.createTitledBorder(new EmptyBorder(new Insets(2, 14, 5, 14))));
        labo.setBounds(200,200,200,50);


        dep.setBackground(c);
        dep.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        dep.setForeground(Color.white);
        dep.setBorder(BorderFactory.createTitledBorder(new EmptyBorder(new Insets(2, 14, 5, 14))));
        dep.setBounds(480,305,200,50);


        projet.setBackground(c);
        projet.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        projet.setForeground(Color.white);
        projet.setBorder(BorderFactory.createTitledBorder(new EmptyBorder(new Insets(2, 14, 5, 14))));
        projet.setBounds(200,305,200,50);


        entrp.setBackground(c);
        entrp.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        entrp.setForeground(Color.white);
        entrp.setBorder(BorderFactory.createTitledBorder(new EmptyBorder(new Insets(2, 14, 5, 14))));
        entrp.setBounds(340,410,200,50);

        Icon icon= new ImageIcon("C:\\m.png");
        logout=new JButton(icon);
        logout.setBounds(800,500,36,36);
        logout.setOpaque(false);
        logout.setContentAreaFilled(false);
        logout.setBorderPainted(false);
        logout.addActionListener(this);

        panel.add(logout);
        panel.add(bienvenue);
        panel.add(prof);
        panel.add(etd);
        panel.add(fil);
        panel.add(labo);
        panel.add(dep);
        panel.add(projet);
        panel.add(entrp);
        prof.addActionListener(this);
        projet.addActionListener(this);
        etd.addActionListener(this);
        dep.addActionListener(this);
        fil.addActionListener(this);
        entrp.addActionListener(this);
        labo.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==logout){
            System.exit(0);
        }
        /*if(e.getSource()==accueil){
            this.setVisible(false);
            Accueil a= new Accueil();
        }*/
        if(e.getSource()==prof){
            this.setVisible(false);
            Professeur_admi p=new Professeur_admi();
        }
        if(e.getSource()==etd){
            this.setVisible(false);
            Etudiant_admi et=new Etudiant_admi();
        }
        if(e.getSource()==projet){
            this.setVisible(false);
            Projet_admi pr=new Projet_admi();
        }
        if(e.getSource()==dep){
            this.setVisible(false);
            Departement_admi d=new Departement_admi();
        }
        if(e.getSource()==fil){
            this.setVisible(false);
            filiere_admi f=new filiere_admi();
        }
        if(e.getSource()==entrp){
            this.setVisible(false);
            entreprise_admi entrprise=new entreprise_admi();
        }

        if(e.getSource()==labo){
            this.setVisible(false);
            labo_admin l=new labo_admin();
        }
    }
}
