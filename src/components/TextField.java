package src.components;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

public class TextField extends JTextField {
    private int width = 10;
    private int height = 10;
    private String textToView = "";

    public TextField(int width, int height, String textToView){
        if(textToView != null){
            this.textToView = textToView;
        }
        if(width >= 0){
            this.width = width;
            this.height = height;
        }

        setSize(this.width, this.height);
        setOpaque(false);
        setText(textToView);
        setHorizontalAlignment(SwingConstants.RIGHT);
        setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        setEnabled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(this.width, this.height);
    }
}
