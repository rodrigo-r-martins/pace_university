import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class GUIPanel extends JPanel {

    private JLabel lMidtermLabel;
    private JTextField tMidtermExam;
    private JLabel lFinalLabel;
    private JTextField tFinalExam;
    private JLabel lResultLabel;
    private JLabel lResultDisplay;

    GUIPanel() {

        lMidtermLabel = new JLabel("Midterm Exam: ");
        tMidtermExam= new JTextField(5);
        lFinalLabel= new JLabel("Final Exam: ");
        tFinalExam= new JTextField(5);
        lResultLabel = new JLabel("Average Value:");
        lResultDisplay = new JLabel("****");

        JButton bCalc = new JButton();
        bCalc.setLabel("Calculate Average");
        bCalc.addActionListener(new GUIButtonListener());

        setLayout(new GridLayout(4, 2));

        add(lMidtermLabel);
        add(tMidtermExam);
        add(lFinalLabel);
        add(tFinalExam);
        add(lResultLabel);
        add(lResultDisplay);
        add(bCalc);

        setPreferredSize(new Dimension(300,75));
        // setBackground(Color.blue);

    }

    private class GUIButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            int mExam, fExam;
            double avg;
            System.out.println("In Listener");
            String strMidExam = tMidtermExam.getText();
            System.out.println("midterm=" + strMidExam );
            String strFinExam = tFinalExam.getText();
            System.out.println("final=" + strFinExam );

            mExam = Integer.parseInt(strMidExam);
            fExam = Integer.parseInt(strFinExam);

            avg = (mExam + fExam) / 2.0;

            lResultDisplay.setText(Double.toString(avg));

        }

    } // end private class

}