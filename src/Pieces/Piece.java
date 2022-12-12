package Pieces;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import static Main.GamePanel.blockSize;

public abstract class Piece {
    public static final int WHITE = 0;
    public static final int BLACK = 1;
    public final String resourcePath = "./src/Materials/Graphics/Pieces/";
    public int color;
    public int row, col;
    private BufferedImage image;

    public Piece(int color, int col, int row, String imageFile) {
        this.color = color;
        this.col = col;
        this.row = row;
        try {
            this.image = ImageIO.read(new File(resourcePath + imageFile + ".png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {

    }

    public void draw(Graphics2D g) {
        g.drawImage(image, col * blockSize + 5, row * blockSize + 5, null);
    }

    public void move(int col, int row) {

    }
}
