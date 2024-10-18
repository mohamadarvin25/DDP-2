import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Kuis8 extends JFrame {
    private JButton jbtRect = new JButton("Rectangle");
    private JButton jbtCircle = new JButton("Circle");
    private CentralPanel canvas = new CentralPanel();

    public Kuis8() {
        JPanel panel = new JPanel(); // Use the panel to group buttons
        panel.add(jbtRect);
        panel.add(jbtCircle);

        this.setLayout(new BorderLayout(5, 5));
        this.add(canvas, BorderLayout.CENTER); // Add canvas to center
        this.add(panel, BorderLayout.SOUTH); // Add buttons to the frame

        jbtRect.addActionListener(new RectListener());
        jbtCircle.addActionListener(new CircleListener());
    }

    /** Main method */
    public static void main(String[] args) {
        JFrame frame = new Kuis8();
        frame.setTitle("Kuis 8");
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    class RectListener implements ActionListener { // Inner class
        @Override
        public void actionPerformed(ActionEvent e) {
            canvas.updateGeom(true);
            // lengkapi

        }
    }

    class CircleListener implements ActionListener { // Inner class
        @Override
        public void actionPerformed(ActionEvent e) {
            canvas.updateGeom(false);

            // lengkapi

        }
    }

    class CentralPanel extends JPanel { // Inner class
        private boolean isRectangle; // True: Rectangle, False: Circle

        /** Enlarge the rectangle */
        public void updateGeom(boolean isRectangle) {
            this.isRectangle = isRectangle;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // lengkapi bagian ini
            // hint: menggunakan conditionals
            if (this.isRectangle) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.blue);
                g2.drawRect(160, 170, 80, 60);

            } else {
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.blue);
                g2.drawOval(120, 120, 120, 120);

            }

        }

    }
}