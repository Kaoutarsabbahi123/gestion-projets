package Presentation;

import Metier.Gestionnaires.Gestionnaire_fil;
import Metier.Gestionnaires.Gestionnaire_prof;
import Presentation.tools.ShadowButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class chef_dep extends JFrame implements ActionListener {
    private JLabel labelIdProf;
    private JLabel labelfil;
    private JTextField textprof;
    private JTextField textfil;
    private ShadowButton valider;
    private JButton logout;
    private Icon icon;
    private Gestionnaire_fil fil= new Gestionnaire_fil();
    private Gestionnaire_prof prof= new Gestionnaire_prof();
    private JPanel pan;
    public void initialiser(){
        pan= new JPanel(null);
        labelIdProf= new JLabel("Id professeur :");
        labelfil=new JLabel("Filière :");
        textfil=new JTextField();
        textprof=new JTextField();
        valider= new ShadowButton("Valider", Color.decode("#1EEF28"), Color.decode("#01EEF28"));
        icon= new ImageIcon("C:\\m.png");
        logout=new JButton(icon);
    }
    public void dessiner(){
        labelIdProf.setBounds(60, 30, 100, 70);
        labelfil.setBounds(60, 60, 70, 70);
        textprof.setBounds(200, 55, 130, 20);
        textfil.setBounds(200, 85, 130, 20);
        valider.setBounds(140,150,100,30);
        valider.setBackground(Color.decode("#1EEF28"));
        logout.setBounds(320,200,36,36);
        logout.setOpaque(false);
        logout.setContentAreaFilled(false);
        logout.setBorderPainted(false);
        pan.add(labelfil);
        pan.add(labelIdProf);
        pan.add(textfil);
        pan.add(textprof);
        pan.add(valider);
        pan.add(logout);
        this.add(pan);
    }
    public chef_dep(){
        this.setTitle("Dessigner chef de filière");
        this.initialiser();
        this.dessiner();
        this.setSize(400,300);
        valider.addActionListener(this);
        logout.addActionListener(this);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == valider) {
            if (fil.existe(fil.getFilBYName(textfil.getText())) == 1) {
                if (prof.getprof(Integer.valueOf(textprof.getText())) &&
                        prof.verf(fil.getFilBYName(textfil.getText()), Integer.valueOf(textprof.getText()))) {
                    JOptionPane.showMessageDialog(null, "information enregistrer avec succé");
                } else {
                    JOptionPane.showMessageDialog(null, "échec", "message d'erreur",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "ce professeur n'appartient pas " +
                                "à cette filière", "message d'erreur",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        if(e.getSource()==logout)
        {
            System.exit(0);
        }
    }
}
