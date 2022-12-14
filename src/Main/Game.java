package Main;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Game {
    public static void main(String[] args) {
        JFrame window = new JFrame("The King's Rising");
        window.setIconImage(new ImageIcon("Materials/Graphics/Pieces/kirbyidle.gif").getImage());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new GamePanel());

        window.pack();
        window.setLocationRelativeTo(null);

        window.setVisible(true);
        // window.setResizable(false);
    }
}
