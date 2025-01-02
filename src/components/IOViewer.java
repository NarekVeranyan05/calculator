package src.components;

import javax.swing.*;
import java.awt.*;

import src.state.OutputData;

// calculator input/output screen class
public class IOViewer extends JPanel {
    private final int MARGIN_TOP_BOTTOM = 5, MARGIN_HORIZONTAL = 10;

    // dimensions of the panel
    private int width = 10;
    private int height = 10;

    // components
    private TextField outputField;
    private TextField inputField;


    public IOViewer(int width, int height) {
        if(width >= 0 && height >= 0) {
            this.width = width - 2 * MARGIN_HORIZONTAL;
            this.height = height;
        }

        setSize(this.width, this.height);
        setBorder(BorderFactory.createEmptyBorder(MARGIN_TOP_BOTTOM, 0, MARGIN_TOP_BOTTOM, 0));

        // styling panel
        setLayout(new GridLayout(2, 1));
        setOpaque(false);

        // adds output line component
        outputField = new TextField(this.width, this.height / 2, OutputData.getCalculatedOutput());
        OutputData.addSubscriber(outputField);
        add(outputField);

        // adds input line component
        inputField = new TextField(this.width, this.height / 2, OutputData.getCommandInput());
        OutputData.addSubscriber(inputField);
        add(inputField);
    }

    @Override
    protected void paintComponent(Graphics g) {
        RenderingHints hints = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON
        );
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.addRenderingHints(hints);
        super.paintComponent(g2d);

        g2d.setColor(new Color(255, 135, 0));
        g2d.fillRoundRect(0, 0, this.width, this.height, 10, 10);

        g2d.dispose();
    }

    @Override
    public void repaint() {
        if(outputField != null){
            outputField.setText(OutputData.getCalculatedOutput());
            outputField.repaint();
        }
        if(inputField != null){
            inputField.setText(OutputData.getCommandInput());
            inputField.repaint();
        }
        super.repaint();
    }

    @Override
    protected void paintBorder(Graphics g) {
        super.paintBorder(g);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(this.width, this.height);
    }
}