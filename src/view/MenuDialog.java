package view;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class MenuDialog {
    int option;
    String strin;
    URL imageURL;
    ClassLoader cldr = this.getClass().getClassLoader();


    /**
     * <b>transformer(mutative)</b>:reducedMODE <br />
     * <p><b>Postcondition:</b> information message for reduced army mode </p>
     */
    public void reducedMODE() {
        JOptionPane.showMessageDialog(null,
                "THIS IS THE REDUCED ARMY MODE\nIts the same rules as the normal mode, but you have half of your pieces.",
                "MODE INFORMATION",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * <b>transformer(mutative)</b>:normalMODE <br />
     * <p><b>Postcondition:</b> information message for normal mode </p>
     */
    public void normalMODE() {
        JOptionPane.showMessageDialog(null,
                "THIS IS THE NORMAL MODE",
                "MODE INFORMATION",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * <b>transformer(mutative)</b>:noRetreat <br />
     * <p><b>Postcondition:</b> information message for no retreat mode </p>
     */
    public void noRetreat() {
        JOptionPane.showMessageDialog(null,
                "THIS IS AN EXTRA NO RETREAT MODE\nAt this mode you cant move backward only left,right and forward(no diagonals).",
                "MODE INFORMATION",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * <b>transformer(mutative)</b>:withRetreat <br />
     * <p><b>Postcondition:</b> information message for back to normal movement mode </p>
     */
    public void withRetreat() {
        JOptionPane.showMessageDialog(null,
                "YOU ARE BACK TO NORMAL MOVEMENT MODE\nAt this mode you can move normally forwards, backwards, left and right (no diagonals).",
                "MODE INFORMATION",
                JOptionPane.INFORMATION_MESSAGE);
    }

}
