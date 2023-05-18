package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import controller.Controller;
import model.board.Board;
import model.piece.Types;
import model.pieceCollection.colourCollection;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.border.LineBorder;


public class GraphicUI extends JFrame implements ActionListener {

    private Types captived;
    //public String BGUI[][];
    private Image img, img1;
    private String typeClicked1, typeClicked2;
    private int click;
    private ImageIcon img2;
    private JButton captive;
    private List<JButton> button = new ArrayList<>();
    private List<JButton> captivedButton = new ArrayList<>();
    private JButton rescue;
    private JButton jb1, jb2;
    private JPanel jPanel1, jPanel2;
    private JLabel jt1, jt2, jt3, jt4, jt5, jt6, jt7, jt8;
    private URL imageURL;
    private ClassLoader cldr;
    private JFrame jf;
    private Controller game = new Controller();

    private String space = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private int sumDRAGON,sumMAGE,sumKNIGHT,sumLAVAYETI,sumSORC,sumBEAST,sumDWARF,sumELF,sumSCOUT;

    /**
     * <b>constructor</b>: Creates a new Window and initializes some buttons and panels <br />
     * <b>postconditions</b>: Creates a new Window and initializes some buttons and panels
     * starting a new game.
     */
    public GraphicUI() {
        this.click = 0;
        //BGUI = new String[8][10];

        jf = new JFrame("STRATEGO");
        jf.setLayout(null);
        jf.setPreferredSize(new Dimension(1110, 770));
        jf.setSize(800, 800);
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jb1 = new JButton();
        jb2 = new JButton();

        jPanel1.setPreferredSize(new Dimension(750, 680));
        jPanel1.setSize(750, 680);

        jPanel2.setPreferredSize(new Dimension(300, 300));
        jPanel2.setBounds(770, 0, 300, 700);
        jPanel2.setBackground(Color.lightGray);

        jt1 = new JLabel("Ενεργοί Κανόνες");
        jt1.setPreferredSize(new Dimension(250, 25));
        jt1.setBounds(72,15,150,25);
        jt1.setFont(new Font("TextField.font", Font.BOLD, 18));
        jt1.setBackground(Color.LIGHT_GRAY);

        jt2 = new JLabel("<html>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Μειωμένος στρατός:<br/><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Καμία υποχώρηση:</html");
        jt2.setPreferredSize(new Dimension(280, 50));
        jt2.setBounds(0,55,300,85);
        jt2.setFont(new Font("TextField.font", Font.BOLD, 12));
        jt2.setBackground(Color.GRAY);
        jt2.setForeground(Color.WHITE);
        jt2.setOpaque(true);
        jt2.setLayout(null);

        jb1.setPreferredSize(new Dimension(25,25));
        jb1.setBounds(190,15,25,25);
        jb2.setPreferredSize(new Dimension(25,25));
        jb2.setBounds(190,48,25,25);
        jb1.addActionListener(this);
        jb2.addActionListener(this);

        jt3 = new JLabel("Στατιστικά");
        jt3.setPreferredSize(new Dimension(250, 400));
        jt3.setBounds(105,230,150,25);
        jt3.setFont(new Font("TextField.font", Font.BOLD, 18));
        jt3.setBackground(Color.WHITE);

        jt4 = new JLabel("Player 1 turn");
        jt4.setPreferredSize(new Dimension(280, 50));
        jt4.setBounds(0,260,300,40);
        jt4.setHorizontalAlignment(SwingConstants.CENTER);
        jt4.setFont(new Font("TextField.font", Font.BOLD, 13));
        jt4.setBackground(Color.GRAY);
        jt4.setForeground(Color.WHITE);
        jt4.setOpaque(true);
        jt4.setLayout(null);

        jt5 = new JLabel("<html>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ποσοστό&nbsp;επιτ.&nbsp;επίθεσης: <br/><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Διασώσεις:</html");
        jt5.setPreferredSize(new Dimension(280, 50));
        jt5.setBounds(0,280,195,100);
        jt5.setFont(new Font("TextField.font", Font.BOLD, 12));
        jt5.setBackground(Color.GRAY);
        jt5.setForeground(Color.WHITE);
        jt5.setOpaque(true);
        jt5.setLayout(null);

        jt6 = new JLabel("<html><br/><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Γύρος:&nbsp;1</html");
        jt6.setPreferredSize(new Dimension(280, 50));
        jt6.setBounds(180,280,120,100);
        jt6.setFont(new Font("TextField.font", Font.BOLD, 12));
        jt6.setBackground(Color.GRAY);
        jt6.setForeground(Color.WHITE);
        jt6.setOpaque(true);
        jt6.setLayout(null);

        jt7 = new JLabel("Αιχμαλωτίσεις");
        jt7.setPreferredSize(new Dimension(250, 400));
        jt7.setBounds(83,430,150,25);
        jt7.setFont(new Font("TextField.font", Font.BOLD, 18));
        jt7.setBackground(Color.WHITE);

        jt8 = new JLabel("<html><br/><br/><br/>"+space + space + "0" + space + space +"0" + space + space + "&nbsp;0" + "<br/><br/><br/><br/>"+space + space + "0" + space + space +"0" + space + space + "&nbsp;0" +"<br/><br/><br/><br/>" +space + space + "0" + space + space +"0" + space + space + "&nbsp;0" + "<br/><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Συνολικές Αιχμαλωτίσεις:&nbsp;&nbsp;0</html");
        jt8.setPreferredSize(new Dimension(280, 50));
        jt8.setBounds(0,460,300,230);
        jt8.setFont(new Font("TextField.font", Font.BOLD, 12));
        jt8.setBackground(Color.GRAY);
        jt8.setForeground(Color.WHITE);
        jt8.setOpaque(true);
        jt8.setLayout(null);

        captivedButton.add(new JButton("DRAGON"));
        captivedButton.get(0).setPreferredSize(new Dimension(30,30));
        captivedButton.get(0).setBounds(10,5,75,60);


        captivedButton.add(new JButton("MAGE"));
        captivedButton.get(1).setPreferredSize(new Dimension(30,30));
        captivedButton.get(1).setBounds(110,5,75,60);

        captivedButton.add(new JButton("KNIGHT"));
        captivedButton.get(2).setPreferredSize(new Dimension(30,30));
        captivedButton.get(2).setBounds(210,5,75,60);

        captivedButton.add(new JButton("SORCERESS"));
        captivedButton.get(3).setPreferredSize(new Dimension(30,30));
        captivedButton.get(3).setBounds(10,70,75,60);

        captivedButton.add(new JButton("LAVA"));
        captivedButton.get(4).setPreferredSize(new Dimension(30,30));
        captivedButton.get(4).setBounds(110,70,75,60);

        captivedButton.add(new JButton("ELF"));
        captivedButton.get(5).setPreferredSize(new Dimension(30,30));
        captivedButton.get(5).setBounds(210,70,75,60);

        captivedButton.add(new JButton("DWARF"));
        captivedButton.get(6).setPreferredSize(new Dimension(30,30));
        captivedButton.get(6).setBounds(10,135,75,60);

        captivedButton.add(new JButton("SCOUT"));
        captivedButton.get(7).setPreferredSize(new Dimension(30,30));
        captivedButton.get(7).setBounds(110,135,75,60);

        captivedButton.add(new JButton("BEASTRIDER"));
        captivedButton.get(8).setPreferredSize(new Dimension(30,30));
        captivedButton.get(8).setBounds(210,135,75,60);

        for (int i=0; i<captivedButton.size(); i++){
            captivedButton.get(i).addActionListener(this);
        }

        jPanel2.add(jt1);
        jPanel2.add(jt2);
        jPanel2.add(jt3);
        jPanel2.add(jt4);
        jPanel2.add(jt5);
        jPanel2.add(jt6);
        jPanel2.add(jt7);
        jPanel2.add(jt8);

        jt2.add(jb1);
        jt2.add(jb2);
        jt8.add(captivedButton.get(0));
        jt8.add(captivedButton.get(1));
        jt8.add(captivedButton.get(2));
        jt8.add(captivedButton.get(3));
        jt8.add(captivedButton.get(4));
        jt8.add(captivedButton.get(5));
        jt8.add(captivedButton.get(6));
        jt8.add(captivedButton.get(7));
        jt8.add(captivedButton.get(8));



        jPanel1.setLayout(null);
        jPanel2.setLayout(null);

        initPieces(game.board.Board);
    }

    /**
     * <b>transformer(mutative)</b>:setImageURL <br />
     * <p><b>Postcondition:</b> it sets the URL's of the images </p>
     */
    public void setImageURL(String type) {
        //RED PIECES
        if (type.toLowerCase().contains(Types.DRAGON_R.toString().toLowerCase())) {
            cldr = this.getClass().getClassLoader();
            imageURL = cldr.getResource("images/RedPieces/dragonR.png");
        }
        if (type.toLowerCase().contains(Types.MAGE_R.toString().toLowerCase())) {
            cldr = this.getClass().getClassLoader();
            imageURL = cldr.getResource("images/RedPieces/mageR.png");
        }
        if (type.toLowerCase().contains(Types.KNIGHT_R.toString().toLowerCase())) {
            cldr = this.getClass().getClassLoader();
            imageURL = cldr.getResource("images/RedPieces/knightR.png");
        }
        if (type.toLowerCase().contains(Types.BEASTRIDER_R.toString().toLowerCase())) {
            cldr = this.getClass().getClassLoader();
            imageURL = cldr.getResource("images/RedPieces/beastRiderR.png");
        }
        if (type.toLowerCase().contains(Types.SORCERESS_R.toString().toLowerCase())) {
            cldr = this.getClass().getClassLoader();
            imageURL = cldr.getResource("images/RedPieces/sorceressR.png");
        }
        if (type.toLowerCase().contains(Types.LAVABEAST_R.toString().toLowerCase())) {
            cldr = this.getClass().getClassLoader();
            imageURL = cldr.getResource("images/RedPieces/lavaBeast.png");
        }
        if (type.toLowerCase().contains(Types.DWARF_R.toString().toLowerCase())) {
            cldr = this.getClass().getClassLoader();
            imageURL = cldr.getResource("images/RedPieces/dwarfR.png");
        }
        if (type.toLowerCase().contains(Types.ELF_R.toString().toLowerCase())) {
            cldr = this.getClass().getClassLoader();
            imageURL = cldr.getResource("images/RedPieces/elfR.png");
        }
        if (type.toLowerCase().contains(Types.SCOUT_R.toString().toLowerCase())) {
            cldr = this.getClass().getClassLoader();
            imageURL = cldr.getResource("images/RedPieces/scoutR.png");
        }
        if (type.toLowerCase().contains(Types.SLAYER_R.toString().toLowerCase())) {
            cldr = this.getClass().getClassLoader();
            imageURL = cldr.getResource("images/RedPieces/slayerR.png");
        }
        if (type.toLowerCase().contains(Types.TRAP_R.toString().toLowerCase())) {
            cldr = this.getClass().getClassLoader();
            imageURL = cldr.getResource("images/RedPieces/trapR.png");
        }
        if (type.toLowerCase().contains(Types.RED_FLAG_R.toString().toLowerCase())) {
            cldr = this.getClass().getClassLoader();
            imageURL = cldr.getResource("images/RedPieces/flagR.png");
        }
        //BLUE PIECES
        if (type.toLowerCase().contains(Types.DRAGON_B.toString().toLowerCase())) {
            cldr = this.getClass().getClassLoader();
            imageURL = cldr.getResource("images/bluePieces/dragonB.png");
        }
        if (type.toLowerCase().contains(Types.MAGE_B.toString().toLowerCase())) {
            cldr = this.getClass().getClassLoader();
            imageURL = cldr.getResource("images/bluePieces/mageB.png");
        }
        if (type.toLowerCase().contains(Types.KNIGHT_B.toString().toLowerCase())) {
            cldr = this.getClass().getClassLoader();
            imageURL = cldr.getResource("images/bluePieces/knightB.png");
        }
        if (type.toLowerCase().contains(Types.BEASTRIDER_B.toString().toLowerCase())) {
            cldr = this.getClass().getClassLoader();
            imageURL = cldr.getResource("images/bluePieces/beastRiderB.png");
        }
        if (type.toLowerCase().contains(Types.SORCERESS_B.toString().toLowerCase())) {
            cldr = this.getClass().getClassLoader();
            imageURL = cldr.getResource("images/bluePieces/sorceressB.png");
        }
        if (type.toLowerCase().contains(Types.YETI_B.toString().toLowerCase())) {
            cldr = this.getClass().getClassLoader();
            imageURL = cldr.getResource("images/bluePieces/yeti.png");
        }
        if (type.toLowerCase().contains(Types.DWARF_B.toString().toLowerCase())) {
            cldr = this.getClass().getClassLoader();
            imageURL = cldr.getResource("images/bluePieces/dwarfB.png");
        }
        if (type.toLowerCase().contains(Types.ELF_B.toString().toLowerCase())) {
            cldr = this.getClass().getClassLoader();
            imageURL = cldr.getResource("images/bluePieces/elfB.png");
        }
        if (type.toLowerCase().contains(Types.SCOUT_B.toString().toLowerCase())) {
            cldr = this.getClass().getClassLoader();
            imageURL = cldr.getResource("images/bluePieces/scoutB.png");
        }
        if (type.toLowerCase().contains(Types.SLAYER_B.toString().toLowerCase())) {
            cldr = this.getClass().getClassLoader();
            imageURL = cldr.getResource("images/bluePieces/slayerB.png");
        }
        if (type.toLowerCase().contains(Types.TRAP_B.toString().toLowerCase())) {
            cldr = this.getClass().getClassLoader();
            imageURL = cldr.getResource("images/bluePieces/trapB.png");
        }
        if (type.toLowerCase().contains(Types.BLUE_FLAG_B.toString().toLowerCase())) {
            cldr = this.getClass().getClassLoader();
            imageURL = cldr.getResource("images/bluePieces/flagB.png");
        }
    }

    /**
     * <b>transformer(mutative)</b>:initializes  buttons , labels, menu and everything else the programm needs for graphics <br />
     * <p><b>Postcondition:</b> initializes buttons and labels </p>
     */
    private void initPieces(String B[][]) {
        int i, j, x = 0, y = 0, k = 0, n = 0;

        for (i = 0; i < 8; i++) {
            for (j = 0; j < 10; j++) {
                if (B[i][j] != null) {
                    game.board.Board[i][j] = B[i][j].toString() + k;
                } else {
                    game.board.Board[i][j] = "" + k;
                }
                k++;
            }
        }

         for (int z=0; z<captivedButton.size(); z++){
             if (game.turn.getPlayersTurnColour() == game.P2.getColor()) {
                 setImageURL(captivedButton.get(z).getText() + "_B");
                 if (captivedButton.get(z).getText() == "LAVA"){
                     setImageURL("YETI_B");
                 }
                 img = new ImageIcon(imageURL).getImage();
                 img1 = img.getScaledInstance(captivedButton.get(z).getWidth(), captivedButton.get(z).getHeight(), Image.SCALE_SMOOTH);
                 img2 = new ImageIcon(img1);
                 captivedButton.get(z).setIcon(img2);
             }
             else{
                 setImageURL(captivedButton.get(z).getText() + "_R");
                 if (captivedButton.get(z).getText() == "LAVA"){
                     setImageURL("LAVABEAST_R");
                 }
                 img = new ImageIcon(imageURL).getImage();
                 img1 = img.getScaledInstance(captivedButton.get(z).getWidth(), captivedButton.get(z).getHeight(), Image.SCALE_SMOOTH);
                 img2 = new ImageIcon(img1);
                 captivedButton.get(z).setIcon(img2);
             }
        }

        k = 0;
        for (i = 0; i < 8; i++) {
            for (j = 0; j < 10; j++) {
                x = i * 85;
                y = j * 75;
                if (game.board.Board[i][j].length() < 3) {
                    button.add(new JButton("" + k));
                    button.get(k).setPreferredSize(new Dimension(75, 85));
                    button.get(k).setBounds(y, x, 75, 85);
                    button.get(k).setBackground(Color.WHITE);
                    button.get(k).setForeground(Color.WHITE);
                    n = Integer.parseInt(game.board.Board[i][j]);
                    if (n == 32 || n == 33 || n == 42 || n == 43) {
                        button.get(k).setBackground(Color.YELLOW);
                        button.get(k).setForeground(Color.YELLOW);
                    }
                    if (n == 36 || n == 37 || n == 46 || n == 47) {
                        button.get(k).setBackground(Color.YELLOW);
                        button.get(k).setForeground(Color.YELLOW);
                    }
                    button.get(k).setLayout(null);
                    button.get(k).addActionListener(this);
                } else if (game.board.Board[i][j].length() > 3) {
                    button.add(new JButton(game.board.Board[i][j]));
                    button.get(k).setPreferredSize(new Dimension(75, 85));
                    button.get(k).setBounds(y, x, 75, 85);
                    button.get(k).setLayout(null);
                    if (game.turn.getPlayersTurnColour() == game.P2.getColor()) {
                            game.P2.Played(1);
                        if (game.board.Board[i][j].toLowerCase().contains("_B".toLowerCase())) {
                            setImageURL(game.board.Board[i][j]);
                        } else {
                            cldr = this.getClass().getClassLoader();
                            imageURL = cldr.getResource("images/redPieces/redHidden.png");
                        }
                    } else {
                        game.P1.Played(1);
                        if (game.board.Board[i][j].toLowerCase().contains("_R".toLowerCase())) {
                            setImageURL(game.board.Board[i][j]);
                        } else {
                            cldr = this.getClass().getClassLoader();
                            imageURL = cldr.getResource("images/bluePieces/blueHidden.png");
                        }
                    }
                    img = new ImageIcon(imageURL).getImage();
                    img1 = img.getScaledInstance(button.get(k).getWidth(), button.get(k).getHeight(), Image.SCALE_SMOOTH);
                    img2 = new ImageIcon(img1);
                    button.get(k).setIcon(img2);
                    button.get(k).addActionListener(this);
                }
                jPanel1.add(button.get(k));
                k++;
            }
        }

        jPanel1.setVisible(true);
        jPanel2.setVisible(true);
        jt2.setVisible(true);
        jt3.setVisible(true);
        jf.add(jPanel1);
        jf.add(jPanel2);
        jf.pack(); //code wouldnt work if i comment out this line
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSumCAPTIVED();
    }

    /**
     * <b>transformer(mutative)</b>:setSumCAPTIVED <br />
     * <p><b>Postcondition:</b> it sets the sums of pieces to 0. These are needed to summarize the captived pawns </p>
     */
    public void setSumCAPTIVED(){
        this.sumDRAGON = 0;
        this.sumKNIGHT = 0;
        this.sumMAGE = 0;
        this.sumLAVAYETI = 0;
        this.sumBEAST = 0;
        this.sumSORC = 0;
        this.sumELF = 0;
        this.sumDWARF = 0;
        this.sumSCOUT = 0;
    }
    /**
     * <b>transformer(mutative)</b>:paintBoard<br />
     * <p><b>Postcondition:</b> the infos from the String and paint in jPanel</p>
     * Also sychronize some rounds and stuff
     * parametr String B[][] paint the String
     */
    public void paintBoard(String B[][]) {
        int i, j, x = 0, y = 0, k = 0, n;
        if (game.P1.hasPlayed() == true && game.P2.hasPlayed() == true){
            game.P1.Played(0);
            game.P2.Played(0);
            game.turn.setRound();
            jt6.setText("<html><br/><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Γύρος:&nbsp;" + game.turn.getRound() +"</html");
            jPanel2.revalidate();
            jPanel2.repaint();
        }
        if (game.turn.getPlayersTurnColour() == colourCollection.VOLCANDRIA_RED) {
            game.turn.setLastPlayerColor(colourCollection.EVERWINTER_BLUE);
            System.out.println(("AVERAGEEEE() = " + game.P2.getAverageCaptives()));
            jt5.setText("<html>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ποσοστό&nbsp;επιτ.&nbsp;επίθεσης: &nbsp;" + game.P2.getAverageCaptives() + "<br/><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Διασώσεις:"+ game.P1.getRescues() +"</html");
            jPanel2.revalidate();
            jPanel2.repaint();
            game.P2.Played(1);
        } else {
            game.turn.setLastPlayerColor(colourCollection.VOLCANDRIA_RED);
            System.out.println(("AVERAGEEEE() = " + game.P1.getAverageCaptives()));
            jt5.setText("<html>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ποσοστό&nbsp;επιτ.&nbsp;επίθεσης: &nbsp;" + game.P1.getAverageCaptives() + "<br/><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Διασώσεις:"+ game.P1.getRescues() +"</html");
            jPanel2.revalidate();
            jPanel2.repaint();
            game.P1.Played(1);
        }

        for (int z=0; z<captivedButton.size(); z++){
            if (game.turn.getPlayersTurnColour() == game.P2.getColor()) {
                setImageURL(captivedButton.get(z).getText() + "_B");
                if (captivedButton.get(z).getText() == "LAVA"){
                    setImageURL("YETI_B");
                }
                img = new ImageIcon(imageURL).getImage();
                img1 = img.getScaledInstance(captivedButton.get(z).getWidth(), captivedButton.get(z).getHeight(), Image.SCALE_SMOOTH);
                img2 = new ImageIcon(img1);
                captivedButton.get(z).setIcon(img2);
            }
            else{
                setImageURL(captivedButton.get(z).getText() + "_R");
                if (captivedButton.get(z).getText() == "LAVA"){
                    setImageURL("LAVABEAST_R");
                }
                img = new ImageIcon(imageURL).getImage();
                img1 = img.getScaledInstance(captivedButton.get(z).getWidth(), captivedButton.get(z).getHeight(), Image.SCALE_SMOOTH);
                img2 = new ImageIcon(img1);
                captivedButton.get(z).setIcon(img2);
            }
        }
        if (game.turn.getPlayersTurnColour() == game.P1.getColor()) {
            for (int c = 0; c < game.P1.captivePieces.size(); c++) {
                if (game.P1.captivePieces.get(c).toString() == "DRAGON_R") {
                    sumDRAGON++;
                }
                if (game.P1.captivePieces.get(c).toString() == "MAGE_R") {
                    sumMAGE++;
                }
                if (game.P1.captivePieces.get(c).toString() == "KNIGHT_R") {
                    sumKNIGHT++;
                }
                if (game.P1.captivePieces.get(c).toString() == "BEASTRIDER_R") {
                    sumBEAST++;
                }
                if (game.P1.captivePieces.get(c).toString() == "LAVABEAST_R") {
                    sumLAVAYETI++;
                }
                if (game.P1.captivePieces.get(c).toString() == "SORCERESS_R") {
                    sumSORC++;
                }
                if (game.P1.captivePieces.get(c).toString() == "ELF_R") {
                    sumELF++;
                }
                if (game.P1.captivePieces.get(c).toString() == "DWARF_R") {
                    sumDWARF++;
                }
                if (game.P1.captivePieces.get(c).toString() == "SCOUT_R") {
                    sumSCOUT++;
                }
            }
        }
        else{
                for (int c=0; c<game.P2.captivePieces.size(); c++){
                    if (game.P2.captivePieces.get(c).toString() == "DRAGON_B"){
                        sumDRAGON++;
                    }
                    if (game.P2.captivePieces.get(c).toString() == "MAGE_B"){
                        sumMAGE++;
                    }
                    if (game.P2.captivePieces.get(c).toString() == "KNIGHT_B"){
                        sumKNIGHT++;
                    }
                    if (game.P2.captivePieces.get(c).toString() == "BEASTRIDER_B"){
                        sumBEAST++;
                    }
                    if (game.P2.captivePieces.get(c).toString() == "YETI_B"){
                        sumLAVAYETI++;
                    }
                    if (game.P2.captivePieces.get(c).toString() == "SORCERESS_B"){
                        sumSORC++;
                    }
                    if (game.P2.captivePieces.get(c).toString() == "ELF_B"){
                        sumELF++;
                    }
                    if (game.P2.captivePieces.get(c).toString() == "DWARF_B"){
                        sumDWARF++;
                    }
                    if (game.P2.captivePieces.get(c).toString() == "SCOUT_B"){
                        sumSCOUT++;
                    }
                }
            }
        int numb;
        if (game.turn.getPlayersTurnColour() == game.P1.getColor()){
            numb = game.P2.captivePieces.size();
        }
        else{
            numb = game.P1.captivePieces.size();
        }
        String str = "AGA";
        jt8.setText("<html><br/><br/><br/>"+space + space + sumDRAGON + space + space +sumMAGE + space + space + "&nbsp;" + sumKNIGHT + "<br/><br/><br/><br/>"+space + space + sumSORC + space + space +sumLAVAYETI + space + space + "&nbsp;"+sumELF +"<br/><br/><br/><br/>" +space + space + sumDWARF + space + space +sumSCOUT + space + space + "&nbsp;" + sumBEAST + "<br/><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Συνολικές Αιχμαλωτίσεις:&nbsp;"+numb+"&nbsp;</html");
        jPanel2.revalidate();
        jPanel2.repaint();
        setSumCAPTIVED();

        for (i = 0; i < 8; i++) {
            System.out.println();
            for (j = 0; j < 10; j++) {
                if (game.board.Board[i][j].length() < 3) {
                    button.get(k).setText("" + k);
                    button.get(k).setIcon(null);
                    button.get(k).setBackground(Color.WHITE);
                    button.get(k).setForeground(Color.WHITE);
                    n = Integer.parseInt(game.board.Board[i][j]);
                    if (n == 32 || n == 33 || n == 42 || n == 43) {
                        button.get(k).setBackground(Color.YELLOW);
                        button.get(k).setForeground(Color.YELLOW);
                    }
                    if (n == 36 || n == 37 || n == 46 || n == 47) {
                        button.get(k).setBackground(Color.YELLOW);
                        button.get(k).setForeground(Color.YELLOW);
                    }
                    button.get(k).revalidate();
                    button.get(k).repaint();
                } else if (game.board.Board[i][j].length() > 3) {
                    button.get(k).setText(game.board.Board[i][j]);
                    if (game.turn.getPlayersTurnColour() == game.P2.getColor()) {

                        if (game.board.Board[i][j].toLowerCase().contains("_B".toLowerCase())) {
                            setImageURL(game.board.Board[i][j]);
                        } else {
                            cldr = this.getClass().getClassLoader();
                            imageURL = cldr.getResource("images/redPieces/redHidden.png");
                        }
                    } else {
                        if (game.board.Board[i][j].toLowerCase().contains("_R".toLowerCase())) {
                            setImageURL(game.board.Board[i][j]);
                        } else {
                            cldr = this.getClass().getClassLoader();
                            imageURL = cldr.getResource("images/bluePieces/blueHidden.png");
                        }
                    }
                    img = new ImageIcon(imageURL).getImage();
                    img1 = img.getScaledInstance(button.get(k).getWidth(), button.get(k).getHeight(), Image.SCALE_SMOOTH);
                    img2 = new ImageIcon(img1);
                    button.get(k).setIcon(img2);
                    button.get(k).revalidate();
                    button.get(k).repaint();
                }
                k++;
                jPanel1.revalidate();
                jPanel1.repaint();
            }
        }
        game.check_who_won(game.board.Board);
    }

    /**
     * <b>transformer(mutative)</b>:MovePiece<br />
     * <p><b>Postcondition:</b> it change the String A to String B positon at the board for repainting</p>
     */

    public void MovePiece(String A, String B) {
        int i, j, k = 0, x = 0, y = 1;
        for (i = 0; i < 8; i++) {
            for (j = 0; j < 10; j++) {
                if (game.board.Board[i][j].length() < 3 && B.length() < 3) {
                    x = Integer.parseInt(game.board.Board[i][j]);
                    y = Integer.parseInt(B);
                }
                if (game.board.Board[i][j] == A) {
                    game.board.Board[i][j] = "" + k;
                }
                if (game.board.Board[i][j] == B) {
                    game.board.Board[i][j] = A;
                }
                if (x == y) {
                    game.board.Board[i][j] = A;
                    x = 0;
                    y = 1;
                }
                k++;
            }
        }
    }

    /**
     * <b>transformer(mutative)</b>:setCaptived <br />
     * <p><b>Postcondition:</b> it delete's the captived pawn from the board </p>
     */
    public void setCaptived(String A , String B) {
        int i, j, k = 0, x = 0, y = 1;

        for (i = 0; i < 8; i++) {
            for (j = 0; j < 10; j++) {
                if (captived == Types.point){
                    if (game.board.Board[i][j] == A){
                        game.board.Board[i][j] = "" + k;
                    }
                    if (game.board.Board[i][j] == B){
                        game.board.Board[i][j] = "" + k;
                    }
                }
                if (game.board.Board[i][j] == A) {
                    game.board.Board[i][j] = "" + k;
                }
                k++;
            }
        }
    }

    /**
     * <b>transformer(mutative)</b>:setRescue <br />
     * <p><b>Postcondition:</b> rescue a piece to the board if its possible </p>
     */
    public void setRescue(String A, String B){
        int i,j;
        boolean check = false,check2 = false;
        if (B.length() > 3){
            game.wmessage.errorMessage();
            return;
        }
        for (i=0; i<8; i++) {
            for (j = 0; j < 10; j++) {
                if (A.toLowerCase().contains("_R".toLowerCase())) {
                    if (game.board.Board[i][j].toLowerCase().contains("_R".toLowerCase()) && i == 7) {
                        check = true;
                    }
                }
                if (A.toLowerCase().contains("_B".toLowerCase())) {
                    if (game.board.Board[i][j].toLowerCase().contains("_B".toLowerCase()) && i == 0) {
                        check = true;
                    }
                }
            }
        }
        if (check == true){
            if (game.turn.getPlayersTurnColour() == colourCollection.VOLCANDRIA_RED ) {
                for (i = 0; i < game.P1.captivePieces.size(); i++) {
                    if (game.P1.captivePieces.get(i).toString().toLowerCase().contains(A.toLowerCase())) {
                        game.P1.captivePieces.remove(i);
                        check2 = true;
                    }
                }
            }else{
                for (i = 0; i<game.P2.captivePieces.size(); i++) {
                    if (game.P2.captivePieces.get(i).toString().toLowerCase().contains(A.toLowerCase())) {
                        game.P2.captivePieces.remove(i);
                        check2 = true;
                    }
                }
            }
        }
        if (check2 == true) {
            for (i = 0; i < 8; i++) {
                for (j = 0; j < 10; j++) {
                    if (B.toLowerCase().contains(game.board.Board[i][j].toLowerCase())) {
                        game.board.Board[i][j] = A + j;
                    }
                }
            }
        }
        else {
            game.wmessage.errorMessage();
            return;
        }
        paintBoard(game.board.Board);
    }

    /**
     * <b>Observer</b>:checkCanMove <br />
     * <p><b>Postcondition:</b> a boolean method that checks if 'by the rules of the game' a piece can move from String A position to B</p>
     * @parametr String A, String B
     */
    public boolean checkCanMove(String A, String B) {
        int i, j, x = 0, y = 50, x1 = 50, y1 = 0, k=0,l,n,m,b,v,c,d,z,a,s;
        if (A.toLowerCase().contains("TRAP".toLowerCase())){
            return false;
        }
        if (A.toLowerCase().contains("RED_FLAG".toLowerCase())){
            return false;
        }
        if (A.toLowerCase().contains("BLUE_FLAG".toLowerCase())){
            return false;
        }
        if (B.length() < 3) {
            n = Integer.parseInt(B);
            m = Integer.parseInt(game.board.Board[3][2]);
            b = Integer.parseInt(game.board.Board[3][3]);
            v = Integer.parseInt(game.board.Board[4][2]);
            c = Integer.parseInt(game.board.Board[4][3]);
            d = Integer.parseInt(game.board.Board[3][6]);
            z = Integer.parseInt(game.board.Board[3][7]);
            a = Integer.parseInt(game.board.Board[4][6]);
            s = Integer.parseInt(game.board.Board[4][7]);

            if (n == m || n == b || n == v || n == c || n == d || n == z || n == a || n == s) {
                 return false;
            }
        }
        if (jb2.getText() == "*") {
            for (i = 0; i < 8; i++) {
                for (j = 0; j < 10; j++) {
                    if (A == game.board.Board[i][j]) {
                        x = i;
                        y = j;
                    }
                    if (B == game.board.Board[i][j]) {
                        x1 = i;
                        y1 = j;
                    }
                    if (game.board.Board[i][j].length() < 3 && B.length() < 3) {
                        k = Integer.parseInt(game.board.Board[i][j]);
                        l = Integer.parseInt(B);
                        if (k == l) {
                            x1 = i;
                            y1 = j;
                        }
                    }
                    k++;
                }
            }
            if (game.board.Board[x][y].toLowerCase().contains("_B".toLowerCase())) {
                if (game.board.Board[x1][y1].toLowerCase().contains("_B".toLowerCase())) {
                    return false;
                }
            }
            if (game.board.Board[x][y].toLowerCase().contains("_R".toLowerCase())) {
                if (game.board.Board[x1][y1].toLowerCase().contains("_R".toLowerCase())) {
                    return false;
                }
            }
            if (x - x1 <= 1 && x - x1 >= -1 && y - y1 <= 1 && y - y1 >= -1) {
                if (x - x1 != 0 && (y - y1 != 0)) {
                    game.wmessage.errorMessage();
                    return false;
                }
                if (game.board.Board[x][y].toLowerCase().contains("_B".toLowerCase())){
                    if (x - x1>= 0){
                        return true;
                    }
                    else{
                        return false;
                    }
                }
                else if (game.board.Board[x][y].toLowerCase().contains("_R".toLowerCase())){
                    if (x - x1<= 0){
                        return true;
                    }
                    else{
                        return false;
                    }
                }
                else {
                    return false;
                }
            } else {
                return false;
            }
        }else{
            for (i = 0; i < 8; i++) {
                for (j = 0; j < 10; j++) {
                    if (A == game.board.Board[i][j]) {
                        x = i;
                        y = j;
                    }
                    if (B == game.board.Board[i][j]) {
                        x1 = i;
                        y1 = j;
                    }
                    if (game.board.Board[i][j].length() < 3 && B.length() < 3) {
                        k = Integer.parseInt(game.board.Board[i][j]);
                        l = Integer.parseInt(B);
                        if (k == l) {
                            x1 = i;
                            y1 = j;
                        }
                    }
                }
            }
            if (game.board.Board[x][y].toLowerCase().contains("_B".toLowerCase())) {
                if (game.board.Board[x1][y1].toLowerCase().contains("_B".toLowerCase())) {
                    return false;
                }
            }
            if (game.board.Board[x][y].toLowerCase().contains("_R".toLowerCase())) {
                if (game.board.Board[x1][y1].toLowerCase().contains("_R".toLowerCase())) {
                    return false;
                }
            }
            if (x - x1 <= 1 && x - x1 >= -1 && y - y1 <= 1 && y - y1 >= -1) {
                if (x - x1 != 0 && (y - y1 != 0)) {
                    return false;
                }
                return true;
            } else {
                return false;
            }
        }
    }
    /**
     * <b>transformer(mutative)</b>:setMODE <br />
     * <p><b>Postcondition:</b> sets the mode of the game and initialize the board of it. </p>
     */
    public void setMODE(){
        String B2[][] = new String[8][10];
        int k=0;
        for(int i=0; i<8; i++){
            for(int j=0; j<10; j++){
                if (game.board.Board[i][j] != null) {
                    game.board.Board[i][j] = game.board.Board[i][j] + k;
                }
                else {
                    game.board.Board[i][j] = "" + k;
                }
                k++;
            }
        }
    }

    /**
     * <b>transformer(mutative)</b>: in this one every button of the game listens and do things. </p>
     */
    public void actionPerformed(ActionEvent e) {
        click++;
        if (e.getSource() == jb1 ){
            if (jb1.getText() == "") {
                jb1.setText("*");
                game.mmessage.reducedMODE();
                game.changeMode(1);
                setMODE();
                paintBoard(game.board.Board);
                click = 0;
            }
            else {
                jb1.setText("");
                game.mmessage.normalMODE();
                game.changeMode(0);
                setMODE();
                paintBoard(game.board.Board);
                click = 0;
            }
        }
        if (e.getSource() == jb2){
            if (jb2.getText() == "") {
                jb2.setText("*");
                game.mmessage.noRetreat();
                click=0;
            }
            else {
                jb2.setText("");
                game.mmessage.withRetreat();
                click = 0;
            }
        }
        if (click == 1){
            for(int i =0; i<captivedButton.size(); i++){
                if (e.getSource() == captivedButton.get(i)) {
                    typeClicked1 = captivedButton.get(i).getText();
                    click = 2;
                    return;

                }
            }
        }
        if (click == 3){
            for(int i =0; i<button.size(); i++){
                if (e.getSource() == button.get(i)) {
                    if (game.turn.getPlayersTurnColour() == colourCollection.VOLCANDRIA_RED ){
                        setRescue(typeClicked1 + "_R", button.get(i).getText());
                    }
                    else{
                        setRescue(typeClicked1 + "_B", button.get(i).getText());
                    }
                    typeClicked1 = "A";
                    typeClicked2 = "B";
                    //click = 0;
                }
            }
             click = 0;
        }


        for (int i = 0; i < button.size(); i++) {
            if (e.getSource() == button.get(i)) {
                if (button.get(i).getText().toLowerCase().contains("TRAP".toLowerCase()) && click == 1){
                    game.wmessage.errorMessage3();
                    click = 0;
                    return;
                }
                if (button.get(i).getText().toLowerCase().contains("RED_FLAG".toLowerCase()) && click == 1){
                    game.wmessage.errorMessage3();
                    click = 0;
                    return;
                }
                if (button.get(i).getText().toLowerCase().contains("BLUE_FLAG".toLowerCase()) && click == 1){
                    game.wmessage.errorMessage3();
                    click = 0;
                    return;
                }
                if (button.get(i).getText().length() < 3 && click == 1) {
                    click = 0;
                    game.wmessage.errorMessage2();
                    return;
                }
                if (click == 1) {
                    typeClicked1 = button.get(i).getText();
                    if (game.turn.getPlayersTurnColour() == colourCollection.EVERWINTER_BLUE) {
                        if (typeClicked1.toLowerCase().contains("_R".toLowerCase()) || typeClicked1.length() < 3) {
                            game.wmessage.errorMessage2();
                            click = 0;
                            return;
                        }
                    }
                    if (game.turn.getPlayersTurnColour() == colourCollection.VOLCANDRIA_RED || typeClicked1.length() < 3) {
                        if (typeClicked1.toLowerCase().contains("_B".toLowerCase())) {
                            click = 0;
                            game.wmessage.errorMessage2();
                            return;
                        }
                    }
                    paintGreenLine(typeClicked1);
                    if (jb2.getText() == "*") {
                        removeGreenLineBack(typeClicked1);
                    }
                }
                if (click == 2) {
                    typeClicked2 = button.get(i).getText();
                    if (typeClicked1 == typeClicked2) {
                        removeGreenLine();
                        click = 0;
                        typeClicked1 = "A";
                        typeClicked2 = "B";
                    } else {
                        if (typeClicked2.length() < 3) {
                            click = 2;
                            if (checkCanMove(typeClicked1, typeClicked2) == true) {
                                MovePiece(typeClicked1, typeClicked2);
                                removeGreenLine();
                                paintBoard(game.board.Board);
                            }
                            else {
                                game.wmessage.errorMessage();
                                typeClicked1 = "A";
                                typeClicked2 = "B";
                                removeGreenLine();
                                click = 0;
                                return;
                            }
                            removeGreenLine();
                            click = 0;
                            typeClicked1 = "A";
                            typeClicked2 = "B";
                        } else {
                            if (typeClicked1.toLowerCase().contains("_B".toLowerCase())) {
                                if (checkCanMove(typeClicked1, typeClicked2) == true) {
                                    captived = game.captivity(game.P1, typeClicked1, typeClicked2);
                                    if (typeClicked1.toString().toLowerCase().contains(captived.toString().toLowerCase())) {
                                        setCaptived(typeClicked1,typeClicked2);
                                        removeGreenLine();
                                        paintBoard(game.board.Board);
                                    } else {
                                        if (captived == Types.point) {
                                            game.P1.captivePieces.add(typeClicked1.toString());
                                            setCaptived(typeClicked1,typeClicked2);
                                        }
                                        else{
                                            game.P1.captivePieces.add(captived.toString());
                                            MovePiece(typeClicked1, typeClicked2);
                                        }
                                        removeGreenLine();
                                        paintBoard(game.board.Board);
                                    }
                                }
                                else{
                                    game.wmessage.errorMessage();
                                    typeClicked1 = "A";
                                    typeClicked2 = "B";
                                    removeGreenLine();
                                    click = 0;
                                    return;
                                }
                                removeGreenLine();
                                click = 0;
                                typeClicked1 = "A";
                                typeClicked2 = "B";
                            } else {
                                if (checkCanMove(typeClicked1, typeClicked2) == true) {
                                    captived = game.captivity(game.P2, typeClicked1, typeClicked2);
                                    if (typeClicked1.toString().toLowerCase().contains(captived.toString().toLowerCase())) {
                                        setCaptived(typeClicked1,typeClicked2);
                                        removeGreenLine();
                                        paintBoard(game.board.Board);
                                    } else {
                                        if (captived == Types.point) {
                                            game.P2.captivePieces.add(typeClicked1);
                                            setCaptived(typeClicked1,typeClicked2);
                                        }
                                        else{
                                            game.P2.captivePieces.add(captived.toString());
                                            MovePiece(typeClicked1, typeClicked2);
                                        }
                                        removeGreenLine();
                                        paintBoard(game.board.Board);
                                    }
                                }
                                else {
                                    game.wmessage.errorMessage();
                                    typeClicked1 = "A";
                                    typeClicked2 = "B";
                                    removeGreenLine();
                                    click = 0;
                                    return;
                                }
                                removeGreenLine();
                                click = 0;
                                typeClicked1 = "A";
                                typeClicked2 = "B";
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * <b>transformer(mutative)</b>:paintGreenline <br />
     * <p><b>Postcondition:</b> paint green lines to positions that a player can move </p>
     */
    public void paintGreenLine(String A) {
        int i, j, x = 0, y = 50, x1 = 50, y1 = 0, k = 0, l;
        int[] paintLine = new int[8];
        if (A.toLowerCase().contains("TRAP".toLowerCase())){
            return;
        }
        if (A.toLowerCase().contains("RED_FLAG".toLowerCase())){
            return;
        }
        if (A.toLowerCase().contains("BLUE_FLAG".toLowerCase())){
            return;
        }
        for (i = 0; i < 8; i++) {
            for (j = 0; j < 10; j++) {
                if (A == game.board.Board[i][j]) {
                    paintLine[0] = i;
                    paintLine[1] = j + 1;
                    paintLine[2] = i;
                    paintLine[3] = j - 1;
                    paintLine[4] = i + 1;
                    paintLine[5] = j;
                    paintLine[6] = i - 1;
                    paintLine[7] = j;
                }
            }
        }
        for (i = 0; i < 8; i++) {
            for (j = 0; j < 10; j++) {
                if (i == paintLine[0] && j == paintLine[1]) {
                    if (A.toLowerCase().contains("_R".toLowerCase())) {
                        if (game.board.Board[paintLine[0]][paintLine[1]].toLowerCase().contains("_R".toLowerCase()) && A.toLowerCase().contains("_R".toLowerCase()) || k == 32 || k==33 || k == 42 || k == 43 || k==46 || k==47 || k==36 ||k==37) {

                        } else {
                            if (button.get(k).getBorder() != null) {
                                button.get(k).setBorder(new LineBorder(Color.GREEN, 4));
                                button.get(k).revalidate();
                                button.get(k).repaint();
                            }
                        }
                    }
                    if (A.toLowerCase().contains("_B".toLowerCase())) {
                        if (game.board.Board[paintLine[0]][paintLine[1]].toLowerCase().contains("_B".toLowerCase()) && A.toLowerCase().contains("_B".toLowerCase()) || k == 32 || k==33 || k == 42 || k == 43 || k==46 || k==47 || k==36 ||k==37) {

                        } else {
                            if (button.get(k).getBorder() != null) {
                                button.get(k).setBorder(new LineBorder(Color.GREEN, 4));
                                button.get(k).revalidate();
                                button.get(k).repaint();
                            }
                        }
                    }
                }
                if (i == paintLine[2] && j == paintLine[3]) {
                    if (A.toLowerCase().contains("_R".toLowerCase())) {
                        if (game.board.Board[paintLine[2]][paintLine[3]].toLowerCase().contains("_R".toLowerCase()) && A.toLowerCase().contains("_R".toLowerCase()) || k == 32 || k==33 || k == 42 || k == 43 || k==46 || k==47 || k==36 ||k==37) {

                        } else {
                            System.out.println(button.get(k).getBorder());
                            if (button.get(k).getBorder() != null) {
                                button.get(k).setBorder(new LineBorder(Color.GREEN, 4));
                                button.get(k).revalidate();
                                button.get(k).repaint();
                            }
                        }
                    }
                    if (A.toLowerCase().contains("_B".toLowerCase())) {
                        if (game.board.Board[paintLine[2]][paintLine[3]].toLowerCase().contains("_B".toLowerCase()) && A.toLowerCase().contains("_B".toLowerCase())|| k == 32 || k==33 || k == 42 || k == 43 || k==46 || k==47 || k==36 ||k==37) {

                        } else {
                            System.out.println(button.get(k).getBorder());
                            if (button.get(k).getBorder() != null) {
                                button.get(k).setBorder(new LineBorder(Color.GREEN, 4));
                                button.get(k).revalidate();
                                button.get(k).repaint();
                            }
                        }
                    }
                }
                if (i == paintLine[4] && j == paintLine[5]) {
                    if (A.toLowerCase().contains("_R".toLowerCase())) {
                        if (game.board.Board[paintLine[4]][paintLine[5]].toLowerCase().contains("_R".toLowerCase()) && A.toLowerCase().contains("_R".toLowerCase())|| k == 32 || k==33 || k == 42 || k == 43 || k==46 || k==47 || k==36 ||k==37) {

                        } else {
                            if (button.get(k).getBorder() != null) {
                                button.get(k).setBorder(new LineBorder(Color.GREEN, 4));
                                button.get(k).revalidate();
                                button.get(k).repaint();
                            }
                        }
                    }
                    if (A.toLowerCase().contains("_B".toLowerCase())) {
                        if (game.board.Board[paintLine[4]][paintLine[5]].toLowerCase().contains("_B".toLowerCase()) && A.toLowerCase().contains("_B".toLowerCase())|| k == 32 || k==33 || k == 42 || k == 43 || k==46 || k==47 || k==36 ||k==37) {

                        } else {
                            if (button.get(k).getBorder() != null) {
                                button.get(k).setBorder(new LineBorder(Color.GREEN, 4));
                                button.get(k).revalidate();
                                button.get(k).repaint();
                            }
                        }
                    }
                }
                if (i == paintLine[6] && j == paintLine[7]) {
                    if (A.toLowerCase().contains("_R".toLowerCase())) {
                        if (game.board.Board[paintLine[6]][paintLine[7]].toLowerCase().contains("_R".toLowerCase()) && A.toLowerCase().contains("_R".toLowerCase())|| k == 32 || k==33 || k == 42 || k == 43 || k==46 || k==47 || k==36 ||k==37) {

                        } else {
                            if (button.get(k).getBorder() != null) {
                                button.get(k).setBorder(new LineBorder(Color.GREEN, 4));
                                button.get(k).revalidate();
                                button.get(k).repaint();
                            }
                        }
                    }
                    if (A.toLowerCase().contains("_B".toLowerCase())) {
                        if (game.board.Board[paintLine[6]][paintLine[7]].toLowerCase().contains("_B".toLowerCase()) && A.toLowerCase().contains("_B".toLowerCase())|| k == 32 || k==33 || k == 42 || k == 43 || k==46 || k==47 || k==36 ||k==37) {

                        } else {
                            if (button.get(k).getBorder() != null) {
                                button.get(k).setBorder(new LineBorder(Color.GREEN, 4));
                                button.get(k).revalidate();
                                button.get(k).repaint();
                            }
                        }
                    }
                }
                k++;
            }
        }

    }

    /**
     * <b>transformer(mutative)</b>:removeGreenline <br />
     * <p><b>Postcondition:</b> Remove the green lines when its not necessary. </p>
     */
    public void removeGreenLine(){
        int i,j,k=0;
        for (i=0; i<8; i++){
            for (j=0; j<10; j++){
                if (button.get(k).getBorder() != null){
                    button.get(k).setBorder(new LineBorder(Color.gray, 1));
                }
                k++;
            }
        }
    }

    /**
     * <b>transformer(mutative)</b>:removeGreenlineBack <br />
     * <p><b>Postcondition:</b> remove the green lines at no backwards mode of the game. So remove only the backward position of moves.</p>
     */
    public void removeGreenLineBack(String A){
        int i,j,k=0, x=100, y = 100;
        for (i=0; i<8; i++){
            for (j=0; j<10; j++){
                if (A == game.board.Board[i][j]){
                    if (A.toLowerCase().contains("_R".toLowerCase())){
                        if (i>0){
                            x = i - 1;
                            y = j;
                        }
                    }
                    if (A.toLowerCase().contains("_B".toLowerCase())){
                        if (i>=0){
                            x = i + 1;
                            y = j;
                        }
                    }

                }
            }
        }
        for (i=0; i<8; i++) {
            for (j = 0; j < 10; j++) {
                if (i == x && j == y){
                    button.get(k).setBorder(new LineBorder(Color.gray, 1));
                }
                k++;
            }
        }

    }



}
