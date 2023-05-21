package ru.kemichi.game.gui.windows.game;

import lombok.Data;
import ru.kemichi.game.enums.FieldState;
import ru.kemichi.game.enums.Player;
import ru.kemichi.game.figures.grid.GridLine;

import java.awt.*;
import java.io.File;
import java.util.Observable;

@Data
public class TicTacToe extends Observable {
    // player action
    private final Point userClickPosition = new Point(0, 0);

    // game state
    private Player turn = Player.X_PLAYER; // who's turn
    private Player winner = Player.NOBODY; // who's winner
    private boolean gameEnded = false; // game status

    private int winCounter = 0; // general win counter

    // how many times some player won
    private int xPlayerWins = 0;
    private int oPlayerWins = 0;


    // game grid
    private FieldState[][] board = new FieldState[3][3];
    private int filledFields;
    private GridLine line = new GridLine();

    // icons
    private File batsuIcon;
    private File maruIcon;

    private Dimension dimension;

    public TicTacToe(Dimension dimension) {
        this.dimension = dimension;
        batsuIcon = new File("src/main/resources/icons/batsu.png");
        maruIcon = new File("src/main/resources/icons/maru.png");
    }

    public void emptyGrid() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                board[i][j] = FieldState.EMPTY;
            }
        }
    }


    public void newTurn(Point point) {
        if (!gameEnded) {
            int iPosition = point.x / line.getOffset();
            int jPosition = point.y / line.getOffset();

            if (!checkIfLine(point) && board[iPosition][jPosition] == FieldState.EMPTY) {
                if (turn == Player.X_PLAYER) {
                    board[iPosition][jPosition] = FieldState.X_FIGURE;
                    turn = Player.O_PLAYER;
                    filledFields += 1;
                } else if (turn == Player.O_PLAYER) {
                    board[iPosition][jPosition] = FieldState.O_FIGURE;
                    turn = Player.X_PLAYER;
                    filledFields += 1;
                }
            }
            if (filledFields == 9) {
                gameEnded = true;
            }
            checkWinner();
        }
    }

    private void checkWinner() {
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != FieldState.EMPTY) {
            changeWinner(board[1][1]);
            gameEnded = true;
        }

        if (board[2][0] == board[1][1] && board[2][0] == board[0][2] && board[2][0] != FieldState.EMPTY) {
            changeWinner(board[1][1]);
            gameEnded = true;
        }

        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] != FieldState.EMPTY) {
                changeWinner(board[i][0]);
                gameEnded = true;
            }
            if (board[0][i] == board[1][i] && board[0][i] == board[2][i]  && board[0][i] != FieldState.EMPTY) {
                changeWinner(board[1][i]);
                gameEnded = true;
            }
        }
    }

    private void changeWinner(FieldState field) {
        if (field == FieldState.X_FIGURE) {
            winner = Player.X_PLAYER;
        }
        else {
            winner = Player.O_PLAYER;
        }
    }

    private boolean checkIfLine(Point point) {
        if (
                (point.x <= line.getOffset() + line.getFirstGridLinePosition().x + line.getWidth()/2
                        && point.x >= line.getOffset() + line.getFirstGridLinePosition().x - line.getWidth()) ||
                        (point.x <= line.getOffset() * 2 + line.getFirstGridLinePosition().x + line.getWidth()/2
                                && point.x >= line.getOffset() * 2 + line.getFirstGridLinePosition().x - line.getWidth())
        ) {
            return true;
        }
        if (
                (point.y <= line.getOffset() + line.getFirstGridLinePosition().y + line.getWidth()
                        && point.y >= line.getOffset() + line.getFirstGridLinePosition().y - line.getWidth()/2) ||
                        point.y <= line.getFirstGridLinePosition().y + line.getWidth()
                                && point.y >= line.getFirstGridLinePosition().y - line.getWidth()/2
        ) {
            return true;
        }
        return false;
    }
}
