package JavaTestMainFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("TITLE");
        JPanel panel = new JPanel(); //interfacce complesse
        JLabel label = new JLabel("HELLO WORLD!!!"); //Usato per testi e immagini

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try{
            File icon = new File("/res/icon.png"); //TODO capire i path realitvi e assoluti su java
            frame.setIconImage(ImageIO.read(icon));
        }
        catch (IOException e) { System.out.println("Catch");}

        frame.setSize(1280, 720);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.add(panel);
        frame.add(label);
    }
}
