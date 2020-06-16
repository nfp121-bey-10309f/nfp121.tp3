package question1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IHMPile extends JFrame implements ActionListener {

    private JTextField donnee = new JTextField(6);
    private JTextField sommet = new JTextField(6);
    private JLabel contenu = new JLabel("[]");

    private Pile p;

    public IHMPile() {
        super("IHM Pile");
        JButton boutonEmpiler = new JButton("empiler");
        JButton boutonDepiler = new JButton("depiler");

        JPanel enHaut = new JPanel();
        enHaut.add(donnee);
        enHaut.add(boutonEmpiler);
        enHaut.add(boutonDepiler);
        enHaut.add(sommet);
        setLayout(new BorderLayout(5, 5));
        add("North", enHaut);
        add("Center", contenu);
        enHaut.setBackground(Color.red);
        setLocation(100, 100);
        pack();
        setVisible(true);
        boutonEmpiler.addActionListener(this);
        boutonDepiler.addActionListener(this);

        p = new Pile(5);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("empiler")) {

            //Q1.1 start
            if (donnee.getText() == null || donnee.getText().isEmpty()) {
                contenu.setText("Rien a empiler!");
                return;
            }

            try {
                p.empiler(donnee.getText());
                sommet.setText(donnee.getText());
                contenu.setText(p.toString());
                donnee.setText("");
            } catch (PilePleineException ex) {
                contenu.setText(p.toString() + " est Pleine !");
            }

        } else {

            try {
                p.depiler();
                contenu.setText(p.toString());

                //setting the sommet
                String separator = ",";
                int sepPos = p.toString().indexOf(separator);

                String separator2 = "]";
                int sepPos2 = p.toString().indexOf(separator2);

                if (sepPos == -1) {//case one more item left
                    sommet.setText(p.toString().substring(1, sepPos2));;
                } else { //case more than one item separataed by a comma
                    sommet.setText(p.toString().substring(1, sepPos));
                }

            } catch (PileVideException ex) {
                contenu.setText(p.toString() + " est Vide!");
            }
            //Q1.1 end
        }
    }

    public static void main(String[] args) {
        new IHMPile();
    }
}
