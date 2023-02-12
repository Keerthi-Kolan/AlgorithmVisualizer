package AlgorithmVisualizer;

import javax.swing.*;
import java.awt.*;

public class BubbleSort {
    static JFrame frame=new JFrame("Bubble Sort");
    static JPanel panel=new JPanel();
    static JButton[] button;
    int first=0,second;
    public void sort(String array) {


        String[] input=array.split(",");
        int len=input.length;
        button=new JButton[len];

        for(int i=0;i<len;i++)
        {
            System.out.println("No problem till index="+i);
            button[i]=new JButton(input[i]+"");
            button[i].setFont(new Font("Footlight MT light",Font.PLAIN,120));
            button[i].setBackground(Color.white);
            panel.add(button[i]);
        }

        frame.add(panel);
        frame.setSize(2000,1800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        for(int i=0;i<len;i++)
        {
            for(int j=1;j<len-i;j++)
            {
                int first = Integer.parseInt(button[j - 1].getText());
                int second = Integer.parseInt(button[j].getText());
                if (first > second) {
                    button[j - 1].setText(second + "");
                    button[j].setText(first + "");
                }
            }
            button[len-i-1].setBackground(Color.yellow);
        }
        System.out.println("Array is sorted");

    }

}

