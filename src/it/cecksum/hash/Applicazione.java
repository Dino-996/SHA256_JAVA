package it.cecksum.hash;

import it.cecksum.hash.controllo.ControlloMenu;
import it.cecksum.hash.controllo.ControlloPrincipale;
import it.cecksum.hash.modello.Modello;
import it.cecksum.hash.vista.Frame;
import it.cecksum.hash.vista.VistaPrincipale;
import javax.swing.SwingUtilities;

public class Applicazione {

    private static final Applicazione singleton = new Applicazione();

    private Applicazione() {
    }

    public static Applicazione getIstance() {
        return singleton;
    }

    private Modello modello;
    private ControlloMenu controlloMenu;
    private ControlloPrincipale controlloPrincipale;
    private VistaPrincipale vistaPrincipale;
    private Frame frame;

    public void inizializza() {
        this.modello = new Modello();
        this.vistaPrincipale = new VistaPrincipale();
        this.frame = new Frame();
        this.controlloMenu = new ControlloMenu();
        this.controlloPrincipale = new ControlloPrincipale();

        this.vistaPrincipale.inizializza();
        this.frame.inizializza();
    }

    public Modello getModello() {
        return modello;
    }

    public ControlloMenu getControlloMenu() {
        return controlloMenu;
    }

    public ControlloPrincipale getControlloPrincipale() {
        return controlloPrincipale;
    }

    public VistaPrincipale getVistaPrincipale() {
        return vistaPrincipale;
    }

    public Frame getFrame() {
        return frame;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Applicazione.getIstance().inizializza();
        });
    }

}
