package it.cecksum.hash.controllo;

import it.cecksum.hash.Applicazione;
import it.cecksum.hash.modello.Costanti;
import it.cecksum.hash.modello.Hash;
import it.cecksum.hash.vista.VistaPrincipale;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloPrincipale {

    private final Action azioneVerifica = new AzioneVerifica();

    public Action getAzioneVerifica() {
        return this.azioneVerifica;
    }

    private class AzioneVerifica extends AbstractAction {

        public AzioneVerifica() {
            this.putValue(Action.NAME, "Verifica");
            this.putValue(Action.SHORT_DESCRIPTION, "Verifica i due SHA256");
            this.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_V);
            this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt V"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vista = Applicazione.getIstance().getVistaPrincipale();
            String hash1 = vista.getHash1();
            String hash2 = vista.getHash2();
            String convalida = errori(hash1, hash2);
            if (!convalida.isEmpty()) {
                Applicazione.getIstance().getFrame().getErrore(convalida);
                return;
            }
            Hash hash = new Hash(hash1, hash2);
            if (hash.getHash1().equalsIgnoreCase(hash.getHash2())) {
                String vero = "Vero";
                Applicazione.getIstance().getModello().putBean(Costanti.VERIFICA, vero);
            } else {
                String falso = "Falso";
                Applicazione.getIstance().getModello().putBean(Costanti.VERIFICA, falso);
            }
            vista.aggiornaConfronto();
        }
    }

    private String errori(String e1, String e2) {
        StringBuilder sb = new StringBuilder();
        if (e1.trim().isEmpty()) {
            sb.append("Il campo di inserimento per il primo hash e' vuoto!\n");
        } else if ((e1.chars().count() != Costanti.CARATTERI_SHA256)) {
            sb.append("Nel campo di inserimento del primo hash inserire ESATTAMENTE ").append(Costanti.CARATTERI_SHA256).append(" caratteri (con codifica a 256 bit, 32 byte)").append("\nCaratteri trovati nel primo campo: ").append(e1.chars().count()).append("\n");
        }
        if (e2.trim().isEmpty()) {
            sb.append("Il campo di inserimento per il secondo hash e' vuoto!\n");
        } else if ((e2.chars().count() != Costanti.CARATTERI_SHA256)) {
            sb.append("Nel campo di inserimento del secondo hash inserire ESATTAMENTE ").append(Costanti.CARATTERI_SHA256).append(" caratteri (con codifica a 256 bit, 32 byte)").append("\nCaratteri trovati nel secondo campo: ").append(e2.chars().count()).append("\n");
        }
        return sb.toString();
    }
}
