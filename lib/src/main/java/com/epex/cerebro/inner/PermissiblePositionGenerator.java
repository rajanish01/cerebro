package com.epex.cerebro.inner;

import com.epex.cerebro.validator.MoveValidator;
import com.epex.cosmos.domain.ChessPiece;
import com.epex.cosmos.domain.Game;
import com.epex.cosmos.enums.Position;
import com.epex.cosmos.enums.Side;
import com.google.common.collect.Lists;

import java.util.List;

@SuppressWarnings("unused")
public class PermissiblePositionGenerator {

    private static final int MAX_ROW = 7;
    private static final int MIN_ROW = 0;

    private static final int MAX_COL = 7;
    private static final int MIN_COL = 0;

    private PermissiblePositionGenerator() {
        throw new IllegalStateException("Utility Class");
    }

    public static List<Position> possiblePositionsForPawn(Game game, ChessPiece activePawn) throws Exception {
        List<Position> validPositions = Lists.newArrayList();
        int currentColumn = activePawn.getCurrentPosition().getColumn();
        int currentRow = activePawn.getCurrentPosition().getRow();
        Position expectedPosition;
        if (activePawn.getPiece().getSide() == Side.WHITE) {
            if (currentRow == 6) {
                expectedPosition = Position.fromValue(currentColumn, currentRow - 1);
                if (MoveValidator.isValidPositionToMove(game, expectedPosition))
                    validPositions.add(expectedPosition);
                expectedPosition = Position.fromValue(currentColumn, currentRow - 2);
                if (MoveValidator.isValidPositionToMove(game, expectedPosition))
                    validPositions.add(expectedPosition);
            } else {
                expectedPosition = Position.fromValue(currentColumn, currentRow - 1);
                if (MoveValidator.isValidPositionToMove(game, expectedPosition))
                    validPositions.add(expectedPosition);
            }
            expectedPosition = Position.fromValue(currentColumn - 1, currentRow - 1);
            if (MoveValidator.isPawnAttacking(game, expectedPosition))
                validPositions.add(expectedPosition);
            expectedPosition = Position.fromValue(currentColumn + 1, currentRow - 1);
            if (MoveValidator.isPawnAttacking(game, expectedPosition))
                validPositions.add(expectedPosition);
        } else {
            if (currentRow == 1) {
                expectedPosition = Position.fromValue(currentColumn, currentRow + 1);
                if (MoveValidator.isValidPositionToMove(game, expectedPosition))
                    validPositions.add(expectedPosition);
                expectedPosition = Position.fromValue(currentColumn, currentRow + 2);
                if (MoveValidator.isValidPositionToMove(game, expectedPosition))
                    validPositions.add(expectedPosition);
            } else {
                expectedPosition = Position.fromValue(currentColumn, currentRow + 1);
                if (MoveValidator.isValidPositionToMove(game, expectedPosition))
                    validPositions.add(expectedPosition);
            }
            expectedPosition = Position.fromValue(currentColumn - 1, currentRow + 1);
            if (MoveValidator.isPawnAttacking(game, expectedPosition))
                validPositions.add(expectedPosition);
            expectedPosition = Position.fromValue(currentColumn + 1, currentRow + 1);
            if (MoveValidator.isPawnAttacking(game, expectedPosition))
                validPositions.add(expectedPosition);
        }
        return validPositions;
    }

    public static List<Position> possiblePositionsForRook(Game game, ChessPiece activeRook) throws Exception {
        List<Position> validPositions = Lists.newArrayList();
        int currentColumn = activeRook.getCurrentPosition().getColumn();
        int currentRow = activeRook.getCurrentPosition().getRow();
        Position expectedPosition;
        int colItr = currentColumn - 1;
        int rowItr = currentRow - 1;
        while (colItr >= MIN_COL) {
            expectedPosition = Position.fromValue(colItr, currentRow);
            if (MoveValidator.isValidPositionToMove(game, expectedPosition)) break;
            validPositions.add(expectedPosition);
            colItr--;
        }
        colItr = currentColumn + 1;
        while (colItr <= MAX_COL) {
            expectedPosition = Position.fromValue(colItr, currentRow);
            if (MoveValidator.isValidPositionToMove(game, expectedPosition)) break;
            validPositions.add(expectedPosition);
            colItr++;
        }
        while (rowItr >= MIN_ROW) {
            expectedPosition = Position.fromValue(currentColumn, rowItr);
            if (MoveValidator.isValidPositionToMove(game, expectedPosition)) break;
            validPositions.add(expectedPosition);
            rowItr--;
        }
        rowItr = currentRow + 1;
        while (rowItr <= MAX_ROW) {
            expectedPosition = Position.fromValue(currentColumn, rowItr);
            if (MoveValidator.isValidPositionToMove(game, expectedPosition)) break;
            validPositions.add(expectedPosition);
            rowItr++;
        }
        return validPositions;
    }

    public static List<Position> possiblePositionsForBishop(Game game, ChessPiece activeBishop) throws Exception {
        List<Position> validPositions = Lists.newArrayList();
        int currentColumn = activeBishop.getCurrentPosition().getColumn();
        int currentRow = activeBishop.getCurrentPosition().getRow();
        Position expectedPosition;
        int colItr = currentColumn - 1;
        int rowItr = currentRow - 1;
        while (colItr >= MIN_COL && rowItr >= MIN_ROW) {
            expectedPosition = Position.fromValue(colItr, rowItr);
            if (MoveValidator.isValidPositionToMove(game, expectedPosition)) break;
            validPositions.add(expectedPosition);
            colItr--;
            rowItr--;
        }
        colItr = currentColumn - 1;
        rowItr = currentRow + 1;
        while (colItr >= MIN_COL && rowItr <= MAX_COL) {
            expectedPosition = Position.fromValue(colItr, rowItr);
            if (MoveValidator.isValidPositionToMove(game, expectedPosition)) break;
            validPositions.add(expectedPosition);
            colItr--;
            rowItr++;
        }
        colItr = currentColumn + 1;
        rowItr = currentRow - 1;
        while (colItr < MAX_ROW && rowItr >= MIN_ROW) {
            expectedPosition = Position.fromValue(colItr, rowItr);
            if (MoveValidator.isValidPositionToMove(game, expectedPosition)) break;
            validPositions.add(expectedPosition);
            colItr++;
            rowItr--;
        }
        colItr = currentColumn + 1;
        rowItr = currentRow + 1;
        while (colItr <= MAX_COL && rowItr <= MAX_ROW) {
            expectedPosition = Position.fromValue(colItr, rowItr);
            if (MoveValidator.isValidPositionToMove(game, expectedPosition)) break;
            validPositions.add(expectedPosition);
            colItr++;
            rowItr++;
        }
        return validPositions;
    }

    public static List<Position> possiblePositionsForKnight(Game game, ChessPiece activeKnight) throws Exception {
        List<Position> validPositions = Lists.newArrayList();
        int currentColumn = activeKnight.getCurrentPosition().getColumn();
        int currentRow = activeKnight.getCurrentPosition().getRow();
        Position expectedPosition;

        if (currentColumn - 2 >= MIN_COL && currentRow - 1 >= MIN_ROW) {
            expectedPosition = Position.fromValue(currentColumn - 2, currentRow - 1);
            if (MoveValidator.isValidPositionToMove(game, expectedPosition))
                validPositions.add(expectedPosition);
        }
        if (currentColumn - 1 >= MIN_COL && currentRow - 2 >= MIN_ROW) {
            expectedPosition = Position.fromValue(currentColumn - 1, currentRow - 2);
            if (MoveValidator.isValidPositionToMove(game, expectedPosition))
                validPositions.add(expectedPosition);
        }
        if (currentColumn + 1 <= MAX_COL && currentRow - 2 >= MIN_ROW) {
            expectedPosition = Position.fromValue(currentColumn + 1, currentRow - 2);
            if (MoveValidator.isValidPositionToMove(game, expectedPosition))
                validPositions.add(expectedPosition);
        }
        if (currentColumn + 2 <= MAX_COL && currentRow - 1 >= MIN_ROW) {
            expectedPosition = Position.fromValue(currentColumn + 2, currentRow - 1);
            if (MoveValidator.isValidPositionToMove(game, expectedPosition))
                validPositions.add(expectedPosition);
        }
        if (currentColumn - 2 >= MIN_COL && currentRow + 1 <= MAX_ROW) {
            expectedPosition = Position.fromValue(currentColumn - 2, currentRow + 1);
            if (MoveValidator.isValidPositionToMove(game, expectedPosition))
                validPositions.add(expectedPosition);
        }
        if (currentColumn - 1 >= MIN_COL && currentRow + 2 <= MAX_ROW) {
            expectedPosition = Position.fromValue(currentColumn - 1, currentRow + 2);
            if (MoveValidator.isValidPositionToMove(game, expectedPosition))
                validPositions.add(expectedPosition);
        }
        if (currentColumn + 1 <= MAX_COL && currentRow + 2 <= MAX_ROW) {
            expectedPosition = Position.fromValue(currentColumn + 1, currentRow + 2);
            if (MoveValidator.isValidPositionToMove(game, expectedPosition))
                validPositions.add(expectedPosition);
        }
        if (currentColumn + 2 <= MAX_COL && currentRow + 1 <= MAX_ROW) {
            expectedPosition = Position.fromValue(currentColumn + 2, currentRow + 1);
            if (MoveValidator.isValidPositionToMove(game, expectedPosition))
                validPositions.add(expectedPosition);
        }
        return validPositions;
    }

    public static List<Position> possiblePositionsForQueen(Game game, ChessPiece activeQueen) throws Exception {
        List<Position> validPositions = possiblePositionsForBishop(game, activeQueen);
        validPositions.addAll(possiblePositionsForRook(game, activeQueen));
        return validPositions;
    }

    public static List<Position> possiblePositionsForKing(Game game, ChessPiece activeKing) throws Exception {
        List<Position> validPositions = Lists.newArrayList();
        int currentColumn = activeKing.getCurrentPosition().getColumn();
        int currentRow = activeKing.getCurrentPosition().getRow();
        Position expectedPosition;

        if (currentColumn + 1 <= MAX_COL) {
            expectedPosition = Position.fromValue(currentColumn + 1, currentRow);
            if (MoveValidator.isValidPositionToMove(game, expectedPosition))
                validPositions.add(expectedPosition);
        }
        if (currentRow - 1 >= MIN_ROW) {
            expectedPosition = Position.fromValue(currentColumn, currentRow - 1);
            if (MoveValidator.isValidPositionToMove(game, expectedPosition))
                validPositions.add(expectedPosition);
        }
        if (currentColumn - 1 >= MIN_COL) {
            expectedPosition = Position.fromValue(currentColumn - 1, currentRow);
            if (MoveValidator.isValidPositionToMove(game, expectedPosition))
                validPositions.add(expectedPosition);
        }
        if (currentRow + 1 <= MAX_ROW) {
            expectedPosition = Position.fromValue(currentColumn, currentRow + 1);
            if (MoveValidator.isValidPositionToMove(game, expectedPosition))
                validPositions.add(expectedPosition);
        }
        return validPositions;
    }

}
