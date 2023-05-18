package model.pieceCollection;

import model.piece.*;
import java.util.ArrayList;
import java.util.List;
/**
 * a class with the name pieceCollection and its the class
 * that initialize a new complete collection of pieces.
 */

public class pieceCollection {
    private colourCollection colour;
    private Piece p;
    public List<Piece> pieces;

    /**
     * <b>constructor</b>: Constructs a new Collection of pieces <br />
     * <b>postcondition</b>: also constructs the colour of the collection
     * and call the initialize method.
     * @param colour is the colour collection of his pawns-pieces (RED or BLUE).
     */
    public pieceCollection(colourCollection colour){
        this.colour = colour;
        pieces = new ArrayList<>();
        initializePieces();
    }

    /**
     * <b>transformer(mutative)</b>: initializePieces <br />
     * <p><b>Postcondition:</b>  it initializes the collection of pieces of a player.
     * This method is called only one time for each player and is called automated by
     * the constructor of the class. </p>
     */
    public void initializePieces(){
        if (colour == colourCollection.VOLCANDRIA_RED) {
            pieces.add(new SpecialMoveablePiece(Types.ELF_R));
            pieces.add(new MoveablePiece(Types.DRAGON_R));
            pieces.add(new MoveablePiece(Types.MAGE_R));
            pieces.add(new MoveablePiece(Types.KNIGHT_R));
            pieces.add(new MoveablePiece(Types.KNIGHT_R));
            pieces.add(new MoveablePiece(Types.BEASTRIDER_R));
            pieces.add(new MoveablePiece(Types.BEASTRIDER_R));
            pieces.add(new MoveablePiece(Types.BEASTRIDER_R));
            pieces.add(new MoveablePiece(Types.SORCERESS_R));
            pieces.add(new MoveablePiece(Types.SORCERESS_R));
            pieces.add(new MoveablePiece(Types.LAVABEAST_R));
            pieces.add(new MoveablePiece(Types.LAVABEAST_R));
            pieces.add(new SpecialMoveablePiece(Types.ELF_R));
            pieces.add(new SpecialMoveablePiece(Types.ELF_R));
            pieces.add(new SpecialMoveablePiece(Types.DWARF_R));
            pieces.add(new SpecialMoveablePiece(Types.DWARF_R));
            pieces.add(new SpecialMoveablePiece(Types.DWARF_R));
            pieces.add(new SpecialMoveablePiece(Types.DWARF_R));
            pieces.add(new SpecialMoveablePiece(Types.DWARF_R));
            pieces.add(new SpecialMoveablePiece(Types.SCOUT_R));
            pieces.add(new SpecialMoveablePiece(Types.SCOUT_R));
            pieces.add(new SpecialMoveablePiece(Types.SCOUT_R));
            pieces.add(new SpecialMoveablePiece(Types.SCOUT_R));
            pieces.add(new SpecialMoveablePiece(Types.SLAYER_R));
            pieces.add(new ImmovablePiece(Types.TRAP_R));
            pieces.add(new ImmovablePiece(Types.TRAP_R));
            pieces.add(new ImmovablePiece(Types.TRAP_R));
            pieces.add(new ImmovablePiece(Types.TRAP_R));
            pieces.add(new ImmovablePiece(Types.TRAP_R));
            pieces.add(new ImmovablePiece(Types.TRAP_R));
            pieces.add(new ImmovablePiece(Types.RED_FLAG_R));
        }
        if (colour == colourCollection.EVERWINTER_BLUE) {
            pieces.add(new MoveablePiece(Types.DRAGON_B));
            pieces.add(new MoveablePiece(Types.MAGE_B));
            pieces.add(new MoveablePiece(Types.KNIGHT_B));
            pieces.add(new MoveablePiece(Types.KNIGHT_B));
            pieces.add(new MoveablePiece(Types.BEASTRIDER_B));
            pieces.add(new MoveablePiece(Types.BEASTRIDER_B));
            pieces.add(new MoveablePiece(Types.BEASTRIDER_B));
            pieces.add(new MoveablePiece(Types.SORCERESS_B));
            pieces.add(new MoveablePiece(Types.SORCERESS_B));
            pieces.add(new MoveablePiece(Types.YETI_B));
            pieces.add(new MoveablePiece(Types.YETI_B));
            pieces.add(new SpecialMoveablePiece(Types.ELF_B));
            pieces.add(new SpecialMoveablePiece(Types.ELF_B));
            pieces.add(new SpecialMoveablePiece(Types.DWARF_B));
            pieces.add(new SpecialMoveablePiece(Types.DWARF_B));
            pieces.add(new SpecialMoveablePiece(Types.DWARF_B));
            pieces.add(new SpecialMoveablePiece(Types.DWARF_B));
            pieces.add(new SpecialMoveablePiece(Types.DWARF_B));
            pieces.add(new SpecialMoveablePiece(Types.SCOUT_B));
            pieces.add(new SpecialMoveablePiece(Types.SCOUT_B));
            pieces.add(new SpecialMoveablePiece(Types.SCOUT_B));
            pieces.add(new SpecialMoveablePiece(Types.SCOUT_B));
            pieces.add(new SpecialMoveablePiece(Types.SLAYER_B));
            pieces.add(new ImmovablePiece(Types.TRAP_B));
            pieces.add(new ImmovablePiece(Types.TRAP_B));
            pieces.add(new ImmovablePiece(Types.TRAP_B));
            pieces.add(new ImmovablePiece(Types.TRAP_B));
            pieces.add(new ImmovablePiece(Types.TRAP_B));
            pieces.add(new ImmovablePiece(Types.TRAP_B));
            pieces.add(new ImmovablePiece(Types.BLUE_FLAG_B));

        }

    }

    /**
     * <b>transformer(mutative)</b>: addPiece  <br />
     * <p><b>Postcondition:</b>  it will add a piece to the array list of the
     * collection. This method will be used by the previus method to help
     * the initialize </p>
     * @param piece type of piece
     */
    public void addPiece(Piece piece){
        this.pieces.add(piece);
    }


}
