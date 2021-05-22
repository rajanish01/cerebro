package com.epex.cerebro.validator;

import com.epex.cosmos.domain.Game;
import com.epex.cosmos.enums.Position;
import com.epex.cosmos.enums.Side;

public class MoveValidator {

    /**
     * https://en.wikipedia.org/wiki/Castling
     * Castling is permissible provided all of the following conditions hold:
     * The castling must be kingside or queenside.
     * Neither the king nor the chosen rook has previously moved.
     * There are no pieces between the king and the chosen rook.
     * The king is not currently in check.
     * The king does not pass through a square that is attacked by an enemy piece.
     * The king does not end up in check. (True of any legal move.)
     *
     * @param game
     * @param side
     * @return
     */
    public static boolean isCastlingValidForKingSide(Game game, Side side) {
        return true;
    }

    public static boolean isCastlingValidForQueenSide(Game game, Side side) {
        return true;
    }

    public static boolean isPawnEnPassing(Game game, Position position) {
        return false;
    }

    public static boolean isKingInCheck(Game game) {
        return false;
    }

    public static boolean isPawnAttackingAtPosition(Game game, Position position) {
        var chessPieceAtPosition = game.getGameBoard().getChessPieces()[position.getColumn()][position.getRow()];
        return chessPieceAtPosition != null && chessPieceAtPosition.getPiece().getSide() != game.getBotSide();
    }

    public static boolean isPawnBlockedAtPosition(Game game, Position position) {
        var chessPieceAtPosition = game.getGameBoard().getChessPieces()[position.getColumn()][position.getRow()];
        return chessPieceAtPosition != null;
    }

    public static boolean isPositionOccupied(Game game, Position position) {
        var chessPieceAtPosition = game.getGameBoard().getChessPieces()[position.getColumn()][position.getRow()];
        return chessPieceAtPosition != null && chessPieceAtPosition.getPiece().getSide() == game.getBotSide();
    }

    public static boolean isValidPositionToMove(Game game, Position position) {
        return !isPositionOccupied(game, position) && !isKingInCheck(game);
    }

}
