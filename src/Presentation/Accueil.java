package Presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Metier.Gestionnaires.*;
import Presentation.tools.ShadowButton;


public class Accueil extends JFrame  implements ActionListener {
    private JPanel pan;
    private JPanel p;
    private JPanel e;
    private JPanel pr;
    private JPanel f;
    private JPanel d;

    private JLabel prof;
    private JLabel etudiant;
    private JLabel projet;
    private JLabel fil;
    private JLabel depar;
    private JLabel titre;
    private JLabel frameicon;
    private JLabel pf;
    private JLabel proj;
    private JLabel eut;
    private JLabel fi;
    private JLabel depa;
    private JButton retour;
    private ShadowButton connect;
    Gestionnaire_fil gf=new Gestionnaire_fil();
    Gestionnaire_Etudiant et=new Gestionnaire_Etudiant();
    Gestionnaire_dep dep=new Gestionnaire_dep();
    Gestionnaire_prof prf=new Gestionnaire_prof();
    Gestionnaire_projet prj=new Gestionnaire_projet();
    Color c=new Color(0, 176, 255);
    ImageIcon icon2 = new ImageIcon(this.getClass().getResource("/education (3).png"));
    public void initialiser(){
        titre= new JLabel("<html>APPLICATION DE GESTION<br>DES PROJETS ACADEMIQUES<html>");
        Icon icon= new ImageIcon("C:\\education (3).png");
        frameicon=new JLabel(icon);

        pan=new JPanel(null);
        p=new JPanel(new FlowLayout());

        pf=new JLabel("Professeurs");
        pr=new JPanel(new FlowLayout());

        proj=new JLabel("Projets");
        e=new JPanel(new FlowLayout());

        eut=new JLabel("Etudiants");
        f=new JPanel(new FlowLayout());

        fi=new JLabel("Filières");
        d=new JPanel(new FlowLayout());

         depa=new JLabel("Départements");
         connect = new ShadowButton("se connecter",c,c);
    }
    public void dessiner(){

        titre.setBounds(90,16,200,100);
        titre.setForeground(Color.BLACK);
        titre.setFont(new Font(Font.SERIF,Font.BOLD,16));


        frameicon.setBounds(10,35,64,64);

        p.setBounds(90,180,200,70);
        p.setBackground(Color.white);
        p.setBorder(BorderFactory.createMatteBorder(0, 4, 0, 0, Color.red));
        String nbrprf=String.valueOf(prf.nbr_prof());
        prof=new JLabel(nbrprf);

        prof.setFont(new Font(Font.SERIF, Font.BOLD, 38));
        prof.setForeground(c);
        prof.setBounds(90,450,100,100);

        pf.setFont(new Font(Font.SERIF, Font.BOLD, 30));
        p.add(prof);
        p.add(pf);


        e.setBounds(350,180,200,70);
        e.setBackground(Color.white);
        e.setBorder(BorderFactory.createMatteBorder(0, 4, 0, 0, Color.red));
        String nbretd=String.valueOf(et.countEtudiant());
        etudiant=new JLabel(nbretd);
        etudiant.setFont(new Font(Font.SERIF, Font.BOLD, 38));
        etudiant.setForeground(c);
        etudiant.setBounds(90,450,100,100);

        eut.setFont(new Font(Font.SERIF, Font.BOLD, 28));
        e.add(etudiant);
        e.add(eut);

        pr.setBounds(610,180,200,70);
        pr.setBackground(Color.white);
        pr.setBorder(BorderFactory.createMatteBorder(0, 4, 0, 0, Color.red));
        String nbrprj=String.valueOf(prj.nombre_proj());
        projet=new JLabel(nbretd);

        projet.setFont(new Font(Font.SERIF, Font.BOLD, 38));
        projet.setForeground(c);
        projet.setBounds(90,450,100,100);
        proj.setFont(new Font(Font.SERIF, Font.BOLD, 30));

        pr.add(projet);
        pr.add(proj);

        f.setBounds(190,330,200,70);
        f.setBackground(Color.white);
        f.setBorder(BorderFactory.createMatteBorder(0, 4, 0, 0, Color.red));
        String nbrfil=String.valueOf(gf.nbr_fil());
        fil=new JLabel(nbrfil);
        fil.setFont(new Font(Font.SERIF, Font.BOLD, 38));
        fil.setForeground(c);
        fil.setBounds(90,450,100,100);
        fi.setFont(new Font(Font.SERIF, Font.BOLD, 30));
        f.add(fil);
        f.add(fi);

        d.setBounds(500,330,200,70);
        d.setBackground(Color.white);
        d.setBorder(BorderFactory.createMatteBorder(0, 4, 0, 0, Color.red));
        String nbrdep=String.valueOf(dep.nbr_dep());
        depar=new JLabel(nbrdep);

        depar.setFont(new Font(Font.SERIF, Font.BOLD, 38));
        depar.setForeground(c);
        depar.setBounds(90,450,100,100);
        depa.setFont(new Font(Font.SERIF, Font.BOLD, 27));
        d.add(depar);
        d.add(depa);

        connect.setBounds(730,40,130,40);
        connect.setFont(new Font(Font.SERIF, Font.BOLD, 18));
        connect.setBackground(c);
        connect.setForeground(Color.white);

        pan.add(p);
        pan.add(e);
        pan.add(pr);
        pan.add(f);
        pan.add(d);
        pan.add(connect);
        pan.add(titre);
        pan.add(frameicon);
    }
    public Accueil(){
        this.setSize(new Dimension(910,550));
        this.setTitle("Accueil");
        setIconImage(icon2.getImage());
        this.initialiser();
        this.dessiner();
        getContentPane().add(pan);
        connect.addActionListener(this);
        this.setVisible(true);
    }
   public static void main(String[] args) {
        Accueil l=new Accueil();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==connect){
            this.setVisible(false);
            Login l=new Login();
        }
    }
}