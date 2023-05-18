package model.player;

import model.piece.Piece;
import model.piece.Types;
import model.pieceCollection.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Player class describes the characteristics of a player
 * and provides methods for some of its modes.
 * (from their fields-characteristics)
 */

public class Player {

    public pieceCollection collection;
    private int choice, rescues;
    private float sumOfAttacks;
    private float sumOfCaptives;
    private colourCollection color;
    private boolean has_finished, hasPlayed;
    public List<String> captivePieces;

    /**
     * <b>constructor</b>: Constructs a new Player with the given
     * parameter colour of collection (RED OR BLUE).<br />
     * <b>postcondition</b>: Creates and initializes a player with the given colour.
     * Also initializes some variables like his choice if he wants for example to
     * capture or to save a pawnn. Or if he finished his move etc.
     * @param colour is the colour collection of his pawns-pieces (RED or BLUE).
     */
    public Player(colourCollection colour){
        this.color = colour;
        this.collection = new pieceCollection(colour);
        this.captivePieces = new ArrayList<>();
        this.choice = 0;
        this.has_finished = false;
        this.hasPlayed = false;
        this.rescues = 0;
        this.sumOfAttacks = 0;
        this.sumOfCaptives = 0;
    }



    /**
     * <b>transformer(mutative)</b>: captivity or 'attack' <br />
     * <p><b>Postcondition:</b>  captures the enemy's pawn (if it's possible by rank or ability)</p>
     * @param player the enemy's player object that you want to attack his pawn
     */
    public Types captivity(Player player, String A, String B){
        int i,x=100,y=100;
        Types tA= Types.point;
        Types tB = Types.point;
        int rankA=0, rankB=0;
        this.sumOfAttacks++;

        for (i=0; i<collection.pieces.size(); i++){
            System.out.println(A);
            if (A.toLowerCase().contains(collection.pieces.get(i).getType().toString().toLowerCase())){
                tA = collection.pieces.get(i).getType();
                rankA = collection.pieces.get(i).getRanking();
                x = i;
            }
        }
        for (i=0; i<player.collection.pieces.size(); i++){
            if (B.toLowerCase().contains(player.collection.pieces.get(i).getType().toString().toLowerCase())){
                tB = player.collection.pieces.get(i).getType();
                rankB = player.collection.pieces.get(i).getRanking();
                y = i;
            }
        }
        if (tB.toString().toLowerCase().contains("TRAP".toLowerCase())){
            if (tA.toString().toLowerCase().contains("DWARF".toLowerCase())){
                this.sumOfCaptives++;
                return tB;
            }
            captivePieces.add(tA.toString());
            collection.pieces.remove(x);
            return tA;
        }
        if (tA.toString().toLowerCase().contains("SLAYER".toLowerCase())){
            this.sumOfCaptives++;
            return tB;
        }
        if (rankA > rankB && x!=100 && y!=100){
            this.sumOfCaptives =this.sumOfCaptives + 1;
            return tB;
        }
        if (rankA < rankB && x!=100 && y!=100){
            captivePieces.add(tA.toString());
            collection.pieces.remove(x);

            return tA;
        }
        if (rankA == rankB && x!=100 && y!=100){
            captivePieces.add(tA.toString());
            collection.pieces.remove(x);
        }

        return Types.point;
    }


    /**
     * <b>transformer(mutative)</b>: rescue or 'save' <br />
     * <p><b>Postcondition:</b>  save your pawn (it can be for 3 times) </p>
     */
    public String rescue(String A){
        String tA = "point";
        int i;
        for (i=0; i<captivePieces.size(); i++) {
            if (A.toLowerCase().contains(captivePieces.get(i).toString()) && rescues<=3) {
                rescues++;
                tA = captivePieces.get(i).toString();
                return tA;
            }
        }
        return tA;

    }

    /**
     * <b>Observer</b>:hasPlayed <br />
     * <p><b>Postcondition:</b> return the hasPlayed attribute of player </p>
     */
    public boolean hasPlayed(){
        return this.hasPlayed;
    }
    /**
     * <b>transformer(mutative)</b>: Played - sets the variable hasPlayed to true
     * <p><b>Postcondition:</b>  sets the variable hasPlayed to true if the integer of parameter is 0.</p>
     * @parametr int b
     */
    public void Played(int b) {
        if (b == 0){
            this.hasPlayed = false;
        }
        else {
            this.hasPlayed = true;
        }
    }

    /**
     * <b>Accessor(Selector)</b>:getRescues <br />
     * <p><b>Postcondition:</b> it returns the number of rescues </p>
     */
    public int getRescues(){
        return this.rescues;
    }

    /**
     * <b>Accessor(selector)</b>:getColor <br />
     * <p><b>Postcondition:</b> it returns the color of the player </p>
     */
    public colourCollection getColor(){
        return this.color;
    }

    /**
     * <b>Accessor(selector)</b>:getAverageCaptives <br />
     * <p><b>Postcondition:</b> a float method that returns the average captives </p>
     */
    public float getAverageCaptives(){
        if (sumOfCaptives == 0 && sumOfAttacks == 0){
            return 0;
        }
        else {
            System.out.println(sumOfCaptives / sumOfAttacks * 100);
            return (sumOfCaptives / sumOfAttacks * 100);
        }
    }

}