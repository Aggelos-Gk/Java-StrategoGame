package model.piece;

/**
 * a class with the name MoveablePiece and it creates
 * a new moveable piece by his characteristics and type
 */
public class MoveablePiece implements Piece {

    private Types type;
    private int ranking;

    /**
     * <b>constructor</b>: Constructs a new type of piece <br />
     * <b>postcondition</b>: Constructs a new moveable piece by its type
     * and initialize the characteristics by the method
     * @param type the type of the piece by the enum type.
     */
    public MoveablePiece(Types type){
        this.type = type;
        initPiece(this.type);
    }

    /**
     * <b>transformer(mutative)</b>: initPiece <br />
     * <p><b>Postcondition:</b>  it initializes a new moveable piece
     * by its characteristics. Every combination of ranking and ability
     * will means something to the game </p>
     */
    public void initPiece(Types type){
        if (type == Types.DRAGON_R) {
            this.ranking = 10;
        }
        if (type == Types.MAGE_R) {
            this.ranking = 9;
        }
        if (type == Types.KNIGHT_R) {
            this.ranking = 8;
        }
        if (type == Types.BEASTRIDER_R) {
            this.ranking = 7;
        }
        if (type == Types.SORCERESS_R) {
            this.ranking = 6;
        }
        if (type == Types.ELF_R) {
            this.ranking = 4;
        }
        if (type == Types.LAVABEAST_R || type == Types.YETI_B){
            this.ranking = 5;
        }

        if (type == Types.DRAGON_B) {
            this.ranking = 10;
        }
        if (type == Types.MAGE_B) {
            this.ranking = 9;
        }
        if (type == Types.KNIGHT_B) {
            this.ranking = 8;
        }
        if (type == Types.BEASTRIDER_B) {
            this.ranking = 7;
        }
        if (type == Types.SORCERESS_B) {
            this.ranking = 6;
        }
        if (type == Types.ELF_B) {
            this.ranking = 4;
        }


    }

    /**
     * <b>accessor(selector)</b>: getType  <br />
     * <p><b>Postcondition:</b> Returns the type of the moveable (type i mean trap or dragon or dwarf etc)
     * in this case we can only return types dragon, mages etc without an ability pieces. </p>
     * @return the type of a moveable piece.
     */
    public Types getType(){
        return type;
    }
    /**
     * <b>accessor(selector)</b>: getRanking  <br />
     * <p><b>Postcondition:</b> Returns the ranking of the moveable (type i mean trap or dragon or dwarf etc)
     * in this case we can only return ranking of  dragon, mage etc without an ability </p>
     * @return the ranking of a moveable piece.
     */
    public int getRanking(){
        return ranking;
    }


}
