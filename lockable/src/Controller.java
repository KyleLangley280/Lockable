
import java.awt.Dimension;
import java.awt.Toolkit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jdewi
 */
public class Controller {
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Boolean running = true;
        String code;
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        
        MainMenuGui gui = new MainMenuGui();
        MakeCodeGui getCode = new MakeCodeGui();
        LockedGui lockedScreen = new LockedGui();
        CoinFlipGui coinFlipScreen = new CoinFlipGui();
        
        gui.setLocation(dim.width/2-gui.getSize().width/2, dim.height/2-gui.getSize().height/2);
        getCode.setLocation(dim.width/2-getCode.getSize().width/2, dim.height/2-getCode.getSize().height/2);
        lockedScreen.setLocation(dim.width/2-lockedScreen.getSize().width/2, dim.height/2-lockedScreen.getSize().height/2);
        coinFlipScreen.setLocation(dim.width/2-coinFlipScreen.getSize().width/2, dim.height/2-coinFlipScreen.getSize().height/2);
        
        gui.setResizable(false);
        getCode.setResizable(false);
        lockedScreen.setResizable(false);
        coinFlipScreen.setResizable(false);
        
        while (running) {
            
            if (gui.getNewCode()){
                
                gui.setVisible(false);
                getCode.setVisible(true);
                
                if (getCode.getCodeSet()) {
                    code = getCode.getCodeValue();
                    
                    lockedScreen.setCorrectCode(code);
                    getCode.setCodeSet(false);
                    gui.setNewCode(false);
                }
            } else if(gui.getLockProgram()) {
                
                gui.setVisible(false);
                lockedScreen.setVisible(true);
                
                if (lockedScreen.getUnlocked()){
                    
                    lockedScreen.setUnlocked(false);
                    gui.setLockProgram(false);
                }
            } else if(gui.getPlayCoinToss()) {
                
                gui.setVisible(false);
                coinFlipScreen.setVisible(true);
                
                if (coinFlipScreen.getBackPressed()) {
                    
                    coinFlipScreen.setBackPressed(false);
                    gui.setPlayCoinToss(false);
                }
            } else {
                
                System.out.print("");
                gui.setVisible(true);
                getCode.setVisible(false);
                lockedScreen.setVisible(false);
                coinFlipScreen.setVisible(false);
            }
        }
        
    }
    
    
    
}
