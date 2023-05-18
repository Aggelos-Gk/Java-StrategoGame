package model.board;

import model.piece.Types;
import model.pieceCollection.pieceCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * a class with the name Board that makes
 * the table of the game and its information
 */
public class Board {
    private List<pieceCollection> boardPieces;
    public String Board[][];
    public Types BoardReduced[][];
    private Random r = new Random();
    private int sumDragon, sumMage, sumKnight, sumBeast, sumSorc, sumYeti;
    private int sumLava, sumElf, sumDwarf, sumScout, sumSlayer, sumFlag, sumTrap;
    private int sumOfDragon, sumOfMage, sumOfKnight, sumOfBeast;
    private int sumOfSorc, sumOfLava, sumOfYeti, sumOfElf, sumOfDwarf;
    private int sumOfScout, sumOfSlayer, sumOfTrap, sumOfFlag;
    private int n,m;
    /**
     * <b>constructor</b>: Constructs a new Board with the given
     * capacity <br />
     * <b>postcondition</b>: constructs a new Board with the given
     * standard capacity and also the pieces to take palce on it
     * The board is an integer array that every array's place
     * is an ID of something.
     */
    public Board(int mode){
        sumOfDragon = 0;
        sumOfMage = 0;
        sumOfKnight = 0;
        sumOfBeast = 0;
        sumOfSorc = 0;
        sumOfLava = 0;
        sumOfYeti = 0;
        sumOfElf = 0;
        sumOfDwarf = 0;
        sumOfScout = 0;
        sumOfSlayer = 0;
        sumOfTrap = 0;
        sumOfFlag = 0;
        boardPieces = new ArrayList<>();
        Board= new String[8][10];
        BoardReduced = new Types[8][10];
        initBoard(mode);
    }

    /**
     * <b>transformer(mutative)</b>:setSums <br />
     * <p><b>Postcondition:</b> it sets the sums of pieces to 0 </p>
     */
    public void setSums(){
        sumOfDragon = 0;
        sumOfMage = 0;
        sumOfKnight = 0;
        sumOfBeast = 0;
        sumOfSorc = 0;
        sumOfLava = 0;
        sumOfYeti = 0;
        sumOfElf = 0;
        sumOfDwarf = 0;
        sumOfScout = 0;
        sumOfSlayer = 0;
        sumOfTrap = 0;
        sumOfFlag = 0;
    }

    /**
     * <b>transformer(mutative)</b>:setNormalMode <br />
     * <p><b>Postcondition:</b> set some needed things to initialize to normal mode or to swap back to normal mode</p>
     */
    public void setNormalMode(){
        sumDragon = 1;
        sumMage = 1;
        sumKnight = 2;
        sumBeast = 3;
        sumSorc = 2;
        sumLava = 2;
        sumYeti = 2;
        sumElf = 2;
        sumDwarf = 5;
        sumScout = 4;
        sumSlayer = 1;
        sumTrap = 6;
        sumFlag = 1;
        for(int i=0; i<8; i++){
            for(int j=0; j<10; j++){
                Board[i][j] = null;
            }
        }
        Board[3][0] = "point";
        n = 4;
        m = 9;
    }

    /**
     * <b>transformer(mutative)</b>:setReducArmyMode <br />
     * <p><b>Postcondition:</b> sets some needed things to swap mode </p>
     */
    public void setReduceArmyMode(){
        sumDragon = 1;
        sumMage = 1;
        sumKnight = 1;
        sumBeast = 1;
        sumSorc = 1;
        sumLava = 1;
        sumYeti = 1;
        sumElf = 1;
        sumDwarf = 2;
        sumScout = 2;
        sumSlayer = 1;
        sumTrap = 3;
        sumFlag = 1;
        for(int i=0; i<8; i++){
            for(int j=0; j<10; j++){
                Board[i][j] = null;
            }
        }
        Board[1][6] = "point";
        n = 6;
        m = 3;
    }

    /**
     * <b>transformer(mutative)</b>: initBoard <br />
     * <p><b>Postcondition:</b>  it initializes the board of the game
     * with positions of pieces at the table and dangers of every square
     * of the table. every place of the array has a number with the information like
     * nothing or dragon or mage or dwarf or trap or danger. </p>
     */
    public  void initBoard(int mode) {
        int x;
        int j;
        setSums();
        for (int i = 0; i < 8; i++) {
            for (j = 0; j < 10; j++) {
                Board[i][j] = null;
            }
        }
        String colour = "RED";
        String y = null;
        if (mode == 0){
            setNormalMode();
        }
        if (mode == 1){
            setReduceArmyMode();
        }

        for (int i = 0; i < 8; i++) {
            for ( j = 0; j < 10; j++) {
                x = r.nextInt(11);
                while (Board[i][j] == y) {
                    if (i==0 && j==4){
                        Board[i][j] = Types.RED_FLAG_R.toString();
                        x = 12;
                    }
                    if (i==7 && j==4){
                        Board[i][j] = Types.BLUE_FLAG_B.toString();
                        x = 12;
                    }
                    if (x == 10 && sumOfDragon < sumDragon) {
                        if (colour == "RED") {
                            Board[i][j] = Types.DRAGON_R.toString();
                        }
                        else{Board[i][j] = Types.DRAGON_B.toString();}
                        sumOfDragon = sumOfDragon + 1;
                    }
                    if (x == 9 && sumOfMage < sumMage) {
                        if (colour == "RED") {
                            Board[i][j] = Types.MAGE_R.toString();
                        }
                        else{Board[i][j] = Types.MAGE_B.toString();}
                        sumOfMage++;
                    }
                    if (x == 8 && sumOfKnight < sumKnight) {
                        if (colour == "RED") {
                            Board[i][j] = Types.KNIGHT_R.toString();
                        }
                        else{Board[i][j] = Types.KNIGHT_B.toString();}
                        sumOfKnight++;
                    }
                    if (x == 7 && sumOfBeast < sumBeast) {
                        if (colour == "RED") {
                            Board[i][j] = Types.BEASTRIDER_R.toString();
                        }
                        else{Board[i][j] = Types.BEASTRIDER_B.toString();}
                        sumOfBeast++;
                    }
                    if (x == 6 && sumOfSorc < sumSorc) {
                        if (colour == "RED") {
                            Board[i][j] = Types.SORCERESS_R.toString();
                        }
                        else{Board[i][j] = Types.SORCERESS_B.toString();}
                        sumOfSorc++;
                    }
                    if (colour == "RED") {
                        if (x == 5 && sumOfLava < sumLava) {
                            Board[i][j] = Types.LAVABEAST_R.toString();
                            sumOfLava++;
                        }
                    }else {
                        if (x == 5 && sumOfYeti < sumYeti) {
                            Board[i][j] = Types.YETI_B.toString();
                            sumOfYeti++;
                        }
                    }
                    if (x == 4 && sumOfElf < sumElf) {
                        if (colour == "RED") {
                            Board[i][j] = Types.ELF_R.toString();
                        }
                        else{Board[i][j] = Types.ELF_B.toString();}
                        sumOfElf++;
                    }
                    if (x == 3 && sumOfDwarf < sumDwarf) {
                        if (colour == "RED") {
                            Board[i][j] = Types.DWARF_R.toString();
                        }
                        else{Board[i][j] = Types.DWARF_B.toString();}
                        sumOfDwarf++;
                    }
                    if (x == 2 && sumOfScout < sumScout) {
                        if (colour == "RED") {
                            Board[i][j] = Types.SCOUT_R.toString();
                        }
                        else{Board[i][j] = Types.SCOUT_B.toString();}
                        sumOfScout++;
                    }
                    if (x == 1 && sumOfSlayer < sumSlayer) {
                        if (colour == "RED") {
                            Board[i][j] = Types.SLAYER_R.toString();
                        }
                        else{Board[i][j] = Types.SLAYER_B.toString();}
                        sumOfSlayer++;
                    }
                    if (x == 0 && sumOfTrap < sumTrap) {
                        if (colour == "RED") {
                            Board[i][j] = Types.TRAP_R.toString();
                        }
                        else{Board[i][j] = Types.TRAP_B.toString();}
                        sumOfTrap++;
                    }
                    if (colour == "RED") {
                        if (x == 11 && sumOfFlag < sumFlag) {
                                sumOfFlag++;
                        }
                    } else if (colour == "BLUE") {
                        if (x == 11 && sumOfFlag < sumFlag) {
                            sumOfFlag++;
                        }
                    }
                    x = r.nextInt(12);
                }
                if (Board[i][j] == "point"){
                    Board[i][j] = null;
                    y = Types.DRAGON_R.toString();
                }
                if (i == n && j == m){
                    y = null;
                    colour = "BLUE";
                    setSums();
                }
            }
        }

    }


}