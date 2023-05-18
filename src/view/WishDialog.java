package view;

import java.net.URL;
import javax.swing.JOptionPane;

public class WishDialog {
    String s ;
    URL imageURL;
    ClassLoader cldr = this.getClass().getClassLoader();
    /**
     * <b>constructor</b>: WishDialog  <br />
     * <b>postconditions</b>: it shows a message with informations for starting the game.
     */
    public WishDialog(){
        JOptionPane.showMessageDialog(null,
                "GAME STARTS AT NORMAL MODE, YOU CAN CHANGE MODES AT THE MENU ONLY AT START!\n1)YOU CAN MOVE OR ATTACK ONLY AT GREEN LINES\n2)TO WIN YOU: YOU NEED TO TAKE THE ENEMIES FLAG OR PIECES\n3)THE MOST RANKING PIECE WINS\n4)YOU CANT RESCUE BACK TO GAME 3 OF YOUR PIECES\n   for more informations check the rules of the game.",
                "INFORMATION OF STRATEGO",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * <b>transformer(mutative)</b>:winMessage <br />
     * <p><b>Postcondition:</b> a message if someone wins. </p>
     */
    public void winMessage(String A){
        JOptionPane.showMessageDialog(null,
                A,
                "WINNER MESSAGE",
                JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * <b>transformer(mutative)</b>:errorMessage <br />
     * <p><b>Postcondition:</b> an error message for wrong choice of movement or attack </p>
     */
    public void errorMessage(){
        JOptionPane.showMessageDialog(null,
                "YOU CAN MOVE ONLY TO GREEN LINES!\nif you rescue a piece, you move only to empty places(except dangarous).",
                "CHOICE ERROR",
                JOptionPane.ERROR_MESSAGE);
    }

    /**
     * <b>transformer(mutative)</b>:errorMessage2 <br />
     * <p><b>Postcondition:</b> an error message for moving enemy's pawns or empty places </p>
     */
    public void errorMessage2(){
        JOptionPane.showMessageDialog(null,
                "YOU CANT MOVE ENEMIES PIECES OR EMPTY PLACES",
                "CHOICE MESSAGE",
                JOptionPane.ERROR_MESSAGE);
    }

    /**
     * <b>transformer(mutative)</b>:errorMessage3 <br />
     * <p><b>Postcondition:</b> an error message for moving immovable pieces </p>
     */
    public void errorMessage3(){
        JOptionPane.showMessageDialog(null,
                "YOU CANT MOVE TRAPS OR FLAGS",
                "CHOICE MESSAGE",
                JOptionPane.ERROR_MESSAGE);
    }
}
