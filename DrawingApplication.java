import java.awt.*;
import java.awt.event.*;

public class DrawingApplication extends Frame
        implements ActionListener, MouseListener {

    Button rectBtn, circleBtn, textBtn;
    String shape = "";

    // Constructor
    DrawingApplication() {

        setTitle("Drawing Application");
        setSize(600, 400);

        // Layout Manager
        setLayout(new BorderLayout());

        // Panel for Buttons
        Panel p = new Panel();
        p.setLayout(new FlowLayout());

        // Buttons
        rectBtn = new Button("Rectangle");
        circleBtn = new Button("Circle");
        textBtn = new Button("Text");

        // Add Buttons to Panel
        p.add(rectBtn);
        p.add(circleBtn);
        p.add(textBtn);

        // Add Panel to Frame
        add(p, BorderLayout.NORTH);

        // Register Action Events
        rectBtn.addActionListener(this);
        circleBtn.addActionListener(this);
        textBtn.addActionListener(this);

        // Register Mouse Event
        addMouseListener(this);

        setVisible(true);

        // Window Closing
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }

    // Button Action Handling
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == rectBtn) {
            shape = "RECTANGLE";
        }

        else if (e.getSource() == circleBtn) {
            shape = "CIRCLE";
        }

        else if (e.getSource() == textBtn) {
            shape = "TEXT";
        }

        repaint();
    }

    // Drawing Shapes
    public void paint(Graphics g) {

        // Draw Rectangle
        if (shape.equals("RECTANGLE")) {

            g.setColor(Color.RED);

            g.fillRect(180, 140, 180, 100);
        }

        // Draw Circle
        else if (shape.equals("CIRCLE")) {

            g.setColor(Color.BLUE);

            g.fillOval(220, 120, 120, 120);
        }

        // Draw Text
        else if (shape.equals("TEXT")) {

            g.setColor(Color.GREEN);

            g.setFont(
                    new Font(
                            "Arial",
                            Font.BOLD,
                            24));

            g.drawString(
                    "Java AWT Drawing",
                    170,
                    220);
        }
    }

    // Mouse Click Event
    public void mouseClicked(MouseEvent e) {

        Graphics g = getGraphics();

        g.setColor(Color.MAGENTA);

        // Small Dot at Mouse Position
        g.fillOval(
                e.getX(),
                e.getY(),
                10,
                10);
    }

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    // Main Method
    public static void main(String[] args) {

        new DrawingApplication();
    }
}