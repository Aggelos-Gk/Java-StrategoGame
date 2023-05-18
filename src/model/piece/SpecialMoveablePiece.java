package model.piece;

/**
 * a class with the name SpecialMoveablePiece and it creates
 * a new moveable piece by his characteristics and type
 */
public class SpecialMoveablePiece extends MoveablePiece {

    private Types type;
    private  int ranking;

    /**
     * <b>constructor</b>: Constructs a new type of piece <br />
     * <b>postcondition</b>: Constructs a new special moveable piece by its type
     * and initialize the characteristics by the method
     * @param type the type of the piece by the enum type.
     */
    public SpecialMoveablePiece(Types type){
        super(type);
        this.type = type;
        initPiece(this.type);

    }

    /**
     * <b>transformer(mutative)</b>: initPiece <br />
     * <p><b>Postcondition:</b>  it initializes a new  special moveable piece
     * by its characteristics. Every combination of ranking and ability
     * will means something to the game </p>
     */
    public void initPiece(Types type){
        // RED PIECES
        if (type == Types.ELF_R) {
            this.ranking = 4;
        }
        if (type == Types.DWARF_R) {
            this.ranking = 3;
        }
        if (type == Types.SCOUT_R) {
            this.ranking = 2;
        }
        if (type == Types.SLAYER_R) {
            this.ranking = 1;
        }
        //BLUE PIECES
        if (type == Types.ELF_B) {
            this.ranking = 4;
        }
        if (type == Types.DWARF_B) {
            this.ranking = 3;
        }
        if (type == Types.SCOUT_B) {
            this.ranking = 2;
        }
        if (type == Types.SLAYER_B) {
            this.ranking = 1;
        }

    }

    /**
     * <b>accessor(selector)</b>: getType  <br />
     * <p><b>Postcondition:</b> Returns the type of the special moveable piece (type i mean trap or dragon or dwarf etc)
     * @return the type of a special moveable piece.
     */
    public Types getType(){
        return type;
    }

    /**
     * <b>accessor(selector)</b>: getRanking  <br />
     * <p><b>Postcondition:</b> Returns the ranking of the special moveable (type i mean trap or dragon or dwarf etc)
     * in this case we can only return ranking of dwarf etc with an ability type pieces </p>
     * @return the ranking of a special moveable piece.
     */
    public int getRanking(){
        return ranking;
    }


}
