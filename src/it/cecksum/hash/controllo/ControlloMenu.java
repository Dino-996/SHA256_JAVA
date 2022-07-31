package it.cecksum.hash.controllo;

import it.cecksum.hash.Applicazione;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloMenu {
    
    private final Action azioneEsci = new AzioneEsci();
    private final Action azioneInfo = new AzioneInfo();
    
    public Action getAzioneEsci() {
        return this.azioneEsci;
    }
    
    public Action getAzioneInfo() {
        return this.azioneInfo;
    }
    
    private class AzioneInfo extends AbstractAction {
        
        public AzioneInfo() {
            this.putValue(Action.NAME, "Info");
            this.putValue(Action.SHORT_DESCRIPTION, "Informazioni su SHA256");
            this.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_I);
            this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt I"));
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            Applicazione.getIstance().getFrame().getMessaggio("PASSAGGI GUIDATI"
                    + "\nPasso 1: Aprire il prompt di PowerShell e digitare quindi get-filehash seguito dal nome "
                    + "\ndel file da verificare (percorso completo)."
                    + "\nCopia e incolla il risultato ottenuto nel primo campo."
                    + "\nPasso 2: Nel secondo campo inserisci lo SHA256 ottenuto dal produttore del software da verificare.");
        }
    }
    
    private class AzioneEsci extends AbstractAction {
        
        public AzioneEsci() {
            this.putValue(Action.NAME, "Esci");
            this.putValue(Action.SHORT_DESCRIPTION, "Esci dall'applicazione");
            this.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_E);
            this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt E"));
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
