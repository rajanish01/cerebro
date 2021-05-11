package com.epex.cerebro.inner;

import com.epex.cerebro.validator.MoveValidator;
import com.epex.cosmos.domain.ChessPiece;
import com.epex.cosmos.domain.GameBoard;
import com.epex.cosmos.enums.Position;
import com.google.common.collect.Lists;

import java.util.List;

public class PermissiblePositionGenerator {

    public static List<Position> possiblePositionsForPawn(GameBoard gameBoard, ChessPiece activePawn) throws Exception {
        List<Position> validPositions = Lists.newArrayList();
        int currentColumn = activePawn.getCurrentPosition().getColumn();
        int currentRow = activePawn.getCurrentPosition().getRow();
        Position validPosition;
        if (currentRow == 1) {
            validPosition = Position.fromValue(currentColumn, currentRow + 1);
            if (MoveValidator.isPlaceOccupied(gameBoard, validPosition))
                validPositions.add(validPosition);
            validPosition = Position.fromValue(currentColumn, currentRow + 2);
            if (MoveValidator.isPlaceOccupied(gameBoard, validPosition))
                validPositions.add(validPosition);
        } else if (currentColumn == 6) {
            validPosition = Position.fromValue(currentColumn, currentRow - 1);
            if (MoveValidator.isPlaceOccupied(gameBoard, validPosition))
                validPositions.add(validPosition);
            validPosition = Position.fromValue(currentColumn, currentRow - 2);
            if (MoveValidator.isPlaceOccupied(gameBoard, validPosition))
                validPositions.add(validPosition);
        }
        return validPositions;
    }

    public static List<Position> possiblePositionsForRook(GameBoard gameBoard, Position currentPosition) {
        return Lists.newArrayList();
    }

    public static List<Position> possiblePositionsForBishop(GameBoard gameBoard, Position currentPosition) {
        return Lists.newArrayList();
    }

    public static List<Position> possiblePositionsForKnight(GameBoard gameBoard, Position currentPosition) {
        return Lists.newArrayList();
    }

    public static List<Position> possiblePositionsForQueen(GameBoard gameBoard, Position currentPosition) {
        return Lists.newArrayList();
    }

    public static List<Position> possiblePositionsForKing(GameBoard gameBoard, Position currentPosition) {
        return Lists.newArrayList();
    }

}
