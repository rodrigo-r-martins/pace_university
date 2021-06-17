import javax.swing.JFrame;

class GUIDisplay {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculate Average");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GUIPanel panel = new GUIPanel();

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);

    }
}
