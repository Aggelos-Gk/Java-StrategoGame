package model.piece;

/**
 * a class with the name ImmovablePiece and it creates
 * a new immovable piece by his characteristics and type
 */
public class ImmovablePiece implements Piece {

    private Types type;
    private int ranking, ability;

    /**
     * <b>constructor</b>: Constructs a new type of piece <br />
     * <b>postcondition</b>: Constructs a new immovable piece by its type
     * and initialize the characteristics by the method
     * @param type the type of the piece by the enum type.
     */
    public ImmovablePiece(Types type){
        this.type = type;
        initPiece(type);
    }

    /**
     * <b>transformer(mutative)</b>: initPiece <br />
     * <p><b>Postcondition:</b>  it initializes a new immovable piece
     * by its characteristics. Every combination of ranking and ability
     * will means something to the game </p>
     */
    public void initPiece(Types type){
        if (type == Types.TRAP_R || type == Types.TRAP_B) {
            this.ranking = 0;
            this.ability = 0;
        }
        if (type == Types.RED_FLAG_R){
            this.ranking = 0;
            this.ability = 0;
        }
        if (type == Types.RED_FLAG_R){
            this.ranking = 0;
            this.ability = 0;
        }

    }

    /**
     * <b>accessor(selector)</b>: getType  <br />
     * <p><b>Postcondition:</b> Returns the type of the immovablepiece (type i mean trap or dragon or dwarf etc)
     * in this case we can only return types flags or trap </p>
     * @return the type of an immovable piece.
     */
    public Types getType(){
        return type;
    }

    /**
     * <b>accessor(selector)</b>: getRanking  <br />
     * <p><b>Postcondition:</b> Returns the ranking of the immovablepiece (type i mean trap or dragon or dwarf etc)
     * in this case we can only return ranking of  flags or trap </p>
     * @return the ranking of an immovable piece.
     */
    public int getRanking(){
        return ranking;
    }

    /**
     * <b>accessor(selector)</b>: getAbility  <br />
     * <p><b>Postcondition:</b> Returns the ability of the immovablepiece (type i mean trap or dragon or dwarf etc)
     * in this case we can only return ability of  flags or trap </p>
     * @return the ability of an immovable piece.
     */
    public int getAbility() {
        return ability;
    }

}
