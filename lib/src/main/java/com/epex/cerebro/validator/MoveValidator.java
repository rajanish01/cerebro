package com.epex.cerebro.validator;

import com.epex.cosmos.domain.GameBoard;
import com.epex.cosmos.enums.Side;

public class MoveValidator {

    /**
     * https://en.wikipedia.org/wiki/Castling
     * Castling is permissible provided all of the following conditions hold:
     *     The castling must be kingside or queenside.
     *     Neither the king nor the chosen rook has previously moved.
     *     There are no pieces between the king and the chosen rook.
     *     The king is not currently in check.
     *     The king does not pass through a square that is attacked by an enemy piece.
     *     The king does not end up in check. (True of any legal move.)
     * @param gameBoard
     * @param side
     * @return
     */
    public static boolean isCastlingValidForKingSide(GameBoard gameBoard, Side side) {
        return true;
    }

    public static boolean isCastlingValidForQueenSide(GameBoard gameBoard, Side side) {
        return true;
    }

    public static boolean isEnPassantTargetValid(GameBoard gameBoard,Side side){
        return true;
    }

}
