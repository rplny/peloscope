import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

public class PeloscopeTurtle extends JPanel {
    private JFrame frame;
    private double curX, curY, angle = -90;
    private final List<Line2D.Double> lines = new ArrayList<>();
    private Color penColor = new Color(17, 202, 160);

    public void setup(int w, int h) {
        frame = new JFrame("Peloscope Cosmic Canvas");
        frame.setSize(w, h);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBackground(new Color(15, 23, 42));
        curX = w / 2.0; curY = h / 2.0;
        frame.add(this);
        frame.setVisible(true);
    }

    public void move(double dist) {
        double nextX = curX + dist * Math.cos(Math.toRadians(angle));
        double nextY = curY + dist * Math.sin(Math.toRadians(angle));
        lines.add(new Line2D.Double(curX, curY, nextX, nextY));
        curX = nextX; curY = nextY;
        repaint();
        try { Thread.sleep(50); } catch (InterruptedException ignored) {}
    }

    public void turn(double deg) { angle += deg; }
    public void setPenColor(Color c) { this.penColor = c; }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(2.5f));
        g2d.setColor(penColor);
        for (Line2D.Double line : lines) { g2d.draw(line); }
    }
}