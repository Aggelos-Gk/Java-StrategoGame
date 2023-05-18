package model.piece;

/**
 * an interface with the name Piece that organized
 * all the methods which an implement class of a piece needs
 * Information in evey method i give in the classes
 */
public interface Piece {

    /**
     * <b>transformer(mutative)</b>: initPiece <br />
     * <p><b>Postcondition:</b>  it initializes a new  piece
     * by its characteristics. Every combination of ranking and ability
     * will means something to the game </p>
     */
    public void initPiece(Types type);

    /**
     * <b>accessor(selector)</b>: getType  <br />
     * <p><b>Postcondition:</b> Returns the type of the piece
     * @return the type of a piece.
     */
    public Types getType();
    /**
     * <b>accessor(selector)</b>: getRanking  <br />
     * <p><b>Postcondition:</b> Returns the ranking of the piece
     * @return the ranking of a piece.
     */
    public int getRanking();



}