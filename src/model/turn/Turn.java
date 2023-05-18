package model.turn;


import model.pieceCollection.colourCollection;

/**
 * a class with the name Turn that gives characteristcs
 * of every turn in the game.
 */
public class Turn {
    private colourCollection playerColour, lastPlayer;
    private int turn, round;

    /**
     * <b>constructor</b>: Turn <br />
     * <b>postcondition</b>: constructs a new turn
     * of a player and the last player who played. That is an example
     * of the Strings - colours.
     */
    public Turn(colourCollection color){
        this.playerColour = color;
        this.round = 1;
    }

    /**
     * <b>transformer(mutative)</b>: setLastPlayerColor  <br />
     * <p><b>Postcondition:</b>  set the last players  color if someone finished
     * colour can be "RED" or "BLUE" like the flags. </p>
     * @parametr colourCollection color
     */
    public void setLastPlayerColor(colourCollection color){
        this.playerColour = color;
    }

    /**
     * <b>accessor(selector)</b>: getPlayerTurnColour <br />
     * <p><b>Postcondition:</b> Returns the player's color </p>
     * @return the player's colour as a String who played last.
     */
    public colourCollection getPlayersTurnColour(){
        return playerColour;
    }

    /**
     * <b>transformer(mutative)</b>:setRound <br />
     * <p><b>Postcondition:</b> sets the round attribute to +1 </p>
     */
    public void setRound(){
        this.round = this.round + 1;
    }

    /**
     * <b>Accessor(Selector)</b>:getRound <br />
     * <p><b>Postcondition:</b> returns the round of the game </p>
     */
    public int getRound(){
        return this.round;
    }




}
