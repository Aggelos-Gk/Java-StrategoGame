package controller;

import model.piece.Types;
import model.pieceCollection.colourCollection;
import model.player.*;
import model.board.Board;
import model.turn.Turn;
import view.GraphicUI;
import view.MenuDialog;
import view.WishDialog;

import java.util.Random;

/**
 * Controller is the master of the game and controls all
 * of the operations executed
 */
public class Controller {

    public Player P1, P2;
    public Board board;
    public Turn turn ;

    private int random;
    private Random rand;

    public WishDialog wmessage;
    public MenuDialog mmessage;

    /**
     * <b>constructor</b>: Constructs a new Controller and sets the game as
     * eligible to start .<br />
     * <b>postcondition</b>: constructs a new controller with 2 players.
     * The player's cards are initialized by the players classes. (So i dont need to make a pieceCollection new object)
     * Also constructs the first move of the game, the board and turn objects.
     */
    public Controller () {

        P1 = new Player(colourCollection.VOLCANDRIA_RED);
        P2 = new Player(colourCollection.EVERWINTER_BLUE);
        board = new Board(0);
        rand = new Random();
        random = rand.nextInt(2);
        if (random == 0){
            turn = new Turn(P1.getColor());
        }
        else {
            turn = new Turn(P2.getColor());
        }

        wmessage = new WishDialog();
        mmessage = new MenuDialog();

    }


    /**
     * <b>transformer(mutative)</b>: captivity or 'attack' <br />
     * <p><b>Postcondition:</b>  captures the enemy's pawn (if it's possible by rank or ability)</p>
     * @param player the enemy's player object that you want to attack his pawn
     */
    public Types captivity(Player player, String A, String B){
        if (player == P1){
            return P2.captivity(P1,A,B);
        }
        else if (player == P2){
            return P1.captivity(P2,A,B);
        }
        return Types.point;
    }

    /**
     * <b>transformer(mutative)</b>: rescue or 'save' <br />
     * <p><b>Postcondition:</b>  save your pawn (it can be for 3 times) </p>
     */
    public String rescue(Player player, String A){
        if (player == P1){
            return P1.rescue(A);
        }
        else {
            return P2.rescue(A);
        }

    }




    /**
     * <b>transformer(mutative)</b>: gameChanges <br />
     * <p><b>Postcondition:</b>  methods that make changes on everything
     * every time need to do. like adding to board a piece that it was captured (by rescue)
     * remove pawns etc. </p>
     */
    public void changeMode(int i){
        board.initBoard(i);
    }

    /**
     * <b>transformer(mutative)</b>: roundFinished <br />
     * <p><b>Postcondition:</b>  it checks a round of a player is finished </p>
     */
    public void roundFinished(){

    }


    /**
     * <b>transformer(mutative)</b>: check_who_won <br />
     * <p><b>Postcondition:</b>  if game is finished the method checks who won by the player's pieces </p>
     */
    public void check_who_won(String[][] A){
        int i,j, flagR=0, flagB=0, piecesR=0, piecesB=0;

        for(i = 0; i<8; i++){
            for(j=0; j<10; j++){
                if (A[i][j].toLowerCase().contains("FLAG_R".toLowerCase())){
                    flagR = flagR + 1;
                }
                if (A[i][j].toLowerCase().contains("FLAG_B".toLowerCase())){
                    flagB = flagB + 1;
                }
                if (!A[i][j].toLowerCase().contains("TRAP_R".toLowerCase()) && !A[i][j].toLowerCase().contains("FLAG_R".toLowerCase())){
                    if (A[i][i].toLowerCase().contains("_R".toLowerCase())) {
                        piecesR = piecesR + 1;
                    }
                }
                if (!A[i][j].toLowerCase().contains("TRAP_B".toLowerCase()) && !A[i][j].toLowerCase().contains("FLAG_B".toLowerCase())){
                    if (A[i][i].toLowerCase().contains("_B".toLowerCase())) {
                        piecesB = piecesB + 1;
                    }
                }
            }
        }

        if (piecesB == 0){
            wmessage.winMessage("THE PLAYER WITH THE 'RED PIECES' WON!");
        }
        if (piecesR == 0){
            wmessage.winMessage("THE PLAYER WITH THE 'BLUE PIECES' WON!");
        }
        if (flagR == 0){
            wmessage.winMessage("THE PLAYER WITH THE 'BLUE PIECES' WON!");
        }
        if (flagB == 0){
            wmessage.winMessage("THE PLAYER WITH THE 'RED PIECES' WON!");
        }
    }

    public static void main(String[] args){
        GraphicUI g = new GraphicUI();
    }
}