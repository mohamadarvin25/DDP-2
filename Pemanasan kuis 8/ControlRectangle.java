import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ControlRectangle extends JFrame {
    private JButton jbtEnlarge = new JButton("Enlarge");
    private JButton jbtShrink = new JButton("Shrink");
    private RectanglePanel canvas = new RectanglePanel();

    public ControlRectangle() {
        JPanel panel = new JPanel(); // Use the panel to group buttons
        panel.add(jbtEnlarge);
        panel.add(jbtShrink);

        this.setLayout(new BorderLayout(5, 5));
        this.add(canvas, BorderLayout.CENTER); // Add canvas to center
        this.add(panel, BorderLayout.SOUTH); // Add buttons to the frame

        jbtEnlarge.addActionListener(new EnlargeListener());
        jbtShrink.addActionListener(new ShrinkListener());
    }

    /** Main method */
    public static void main(String[] args) {
        JFrame frame = new ControlRectangle();
        frame.setTitle("ControlCircle");
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    class EnlargeListener implements ActionListener { // Inner class
        @Override
        public void actionPerformed(ActionEvent e) {
            canvas.enlarge();
        }
    }

    class ShrinkListener implements ActionListener { // Inner class
        @Override
        public void actionPerformed(ActionEvent e) {
            canvas.shrink();
        }
    }

    class RectanglePanel extends JPanel { // Inner class
        private int width = 10; // Default rectangle width
        private int height = 8; // Default rectangle height

        /** Enlarge the rectangle */
        public void enlarge() {
            width *= 2;
            height *= 2;
            repaint(); // --> indirectly call paintComponent(...)
        }

        public void shrink() {
            width /= 2;
            height /= 2;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawRect(getWidth() / 2 - width / 2,
                    getHeight() / 2 - height / 2,
                    width,
                    height);
        }
    }
}