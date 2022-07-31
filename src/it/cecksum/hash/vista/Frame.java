package it.cecksum.hash.vista;

import it.cecksum.hash.Applicazione;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Frame extends javax.swing.JFrame {

    static {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
        }
    }
    
    public void inizializza() {
        this.initComponents();
        this.aggiornaIconaFrame();
        VistaPrincipale vista = Applicazione.getIstance().getVistaPrincipale();
        this.setContentPane(new JScrollPane(vista));
        this.inizializzaAzioni();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void inizializzaAzioni() {
        this.menuVerifica.setAction(Applicazione.getIstance().getControlloPrincipale().getAzioneVerifica());
        this.menuInfo.setAction(Applicazione.getIstance().getControlloMenu().getAzioneInfo());
        this.menuEsci.setAction(Applicazione.getIstance().getControlloMenu().getAzioneEsci());
    }

    public void getMessaggio(String messaggio) {
        JOptionPane.showMessageDialog(this, messaggio, this.getTitle() + " - Messaggio", JOptionPane.INFORMATION_MESSAGE);
    }

    public void getErrore(String errore) {
        JOptionPane.showMessageDialog(this, errore, this.getTitle() + " - Errore", JOptionPane.ERROR_MESSAGE);
    }
    
    private void aggiornaIconaFrame() {
        Frame frame = Applicazione.getIstance().getFrame();
        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/sha256.png"));
        try {
            frame.setIconImage(image);
        } catch (Exception e) {
            System.out.println("L'icona dell'applicazione non e' stata trovata");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JMenuBar jMenuBar1 = new javax.swing.JMenuBar();
        javax.swing.JMenu jMenu1 = new javax.swing.JMenu();
        menuVerifica = new javax.swing.JMenuItem();
        menuInfo = new javax.swing.JMenuItem();
        menuEsci = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SHA256");

        jMenu1.setText("File");

        menuVerifica.setText("Verifica");
        jMenu1.add(menuVerifica);

        menuInfo.setText("Info");
        menuInfo.setActionCommand("");
        jMenu1.add(menuInfo);

        menuEsci.setText("Esci");
        jMenu1.add(menuEsci);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem menuEsci;
    private javax.swing.JMenuItem menuInfo;
    private javax.swing.JMenuItem menuVerifica;
    // End of variables declaration//GEN-END:variables
}
