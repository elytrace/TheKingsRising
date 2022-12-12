package Background;

import Pieces.*;

import java.awt.*;

import static Main.GamePanel.*;

public class Board {
    public static Pawn[] wpawns = new Pawn[8];
    public static Rook[] wrooks = new Rook[2];
    public static Knight[] wknights = new Knight[2];
    public static Bishop[] wbishops = new Bishop[2];
    public static Queen wqueen;
    public static King wking;
    public static Pawn[] bpawns = new Pawn[8];
    public static Rook[] brooks = new Rook[2];
    public static Knight[] bknights = new Knight[2];
    public static Bishop[] bbishops = new Bishop[2];
    public static Queen bqueen;
    public static King bking;

    public Graphics2D g;

    public Board(Graphics2D g) {
        this.g = g;

        placePieces();
    }
    public void drawBoard() {
        g.setColor(Color.WHITE);
        for(int row = 0; row < 8; row++) {
            for(int col = 0; col < 8; col++) {
                g.drawRoundRect(col * blockSize+1, row * blockSize+1, blockSize-2, blockSize-2, 10, 10);
            }
        }
    }

    public void placePieces() {
        for(int col = 0; col < 8; col++) {
            wpawns[col] = new Pawn(Piece.WHITE, col, 6, "wpawn");
            bpawns[col] = new Pawn(Piece.BLACK, col, 1, "bpawn");
        }
        int col = 0, j = 0;
        for(int i = col; i < 8; i += 7-col*2) {
            wrooks[j] = new Rook(Piece.WHITE, i, 7, "wrook");
            brooks[j] = new Rook(Piece.BLACK, i, 0, "brook");
            j = 1 - j;
        }
        col++;
        for(int i = col; i < 8; i += 7-col*2) {
            wknights[j] = new Knight(Piece.WHITE, i, 7, "wknight");
            bknights[j] = new Knight(Piece.BLACK, i, 0, "bknight");
            j = 1 - j;
        }
        col++;
        for(int i = col; i < 8; i += 7-col*2) {
            wbishops[j] = new Bishop(Piece.WHITE, i, 7, "wbishop");
            bbishops[j] = new Bishop(Piece.BLACK, i, 0, "bbishop");
            j = 1 - j;
        }
        col++;
        wqueen = new Queen(Piece.WHITE, col, 7, "wqueen");
        bqueen = new Queen(Piece.BLACK, col, 0, "bqueen");

        col++;
        wking = new King(Piece.WHITE, col, 7, "wking");
        bking = new King(Piece.BLACK, col, 0, "bking");
    }

    public void draw() {
        for(int col = 0; col < 8; col++) {
            wpawns[col].draw(g);
            bpawns[col].draw(g);
        }
        int col = 0, j = 0;
        for(int i = col; i < 8; i += 7-col*2) {
            wrooks[j].draw(g);
            brooks[j].draw(g);
            j = 1 - j;
        }
        col++;
        for(int i = col; i < 8; i += 7-col*2) {
            wknights[j].draw(g);
            bknights[j].draw(g);
            j = 1 - j;
        }
        col++;
        for(int i = col; i < 8; i += 7-col*2) {
            wbishops[j].draw(g);
            bbishops[j].draw(g);
            j = 1 - j;
        }
        col++;
        wqueen.draw(g);
        bqueen.draw(g);

        col++;
        wking.draw(g);
        bking.draw(g);
    }

    public static int[] positionOf(String position) {
        int[] pair = new int[2];

        pair[0] = position.charAt(0) - 'A';
        pair[1] = position.charAt(1) - '0';

        return pair;
    }
}
