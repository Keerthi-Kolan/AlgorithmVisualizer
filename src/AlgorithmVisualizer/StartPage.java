package AlgorithmVisualizer;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPage {
    public static void main(String[] args) {
        new StartPage().firstframe();
    }
    int[] array;
    public void firstframe() {
        JFrame frame=new JFrame("Sorting Visualizer");
        JPanel panel=new JPanel();
        panel.setLayout(new FlowLayout());
        JLabel label=new JLabel("ENTER THE ELEMENTS OF THE ARRAY");
        label.setFont(new Font("Times New Roman", Font.PLAIN, 90));
        JTextArea textArea=new JTextArea(30,80);
        textArea.setFont(new Font("Times New Roman",Font.BOLD,30));
        JButton button=new JButton("SUBMIT");
        button.setFont(new Font("Times New Roman",Font.BOLD,70));
        panel.add(label);
        panel.add(textArea);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    try {
                        String text = textArea.getText();
                        String[] input = text.split(",");
                        array = new int[input.length];
                        for (int i = 0; i < input.length; i++) {
                            array[i] = Integer.parseInt(input[i]);
                        }
                        SecondPage st = new SecondPage();
                        st.secondframe(array);
                        frame.dispose();
                    }
                    catch(Exception ex)
                    {
                        JLabel label=new JLabel();
                        label.setFont(new Font("Times New Roman",Font.PLAIN,50));
                        label.setText("Enter comma separated integer values only");
                        UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Times New Roman",Font.PLAIN,50)));
                        JOptionPane.showMessageDialog(null,label,"Error",JOptionPane.PLAIN_MESSAGE,null);
                    }


            }
        });
        frame.add(panel);
        frame.setSize(2000,1800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}

