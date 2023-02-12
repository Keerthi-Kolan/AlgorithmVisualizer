package AlgorithmVisualizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BubbleSort {

     Timer timer1,timer2;
    static JButton[] button;
    static JButton reset;
    static JLabel label;
    static int length=0,len=0,index=0;
    int count=0;
    public void BubbleSortdesign(int[] array) {

        JFrame frame=new JFrame("Bubble Sort");
        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout(3,1));
        JPanel buttonpanel= new JPanel();
        buttonpanel.setLayout(new FlowLayout());
        JPanel southpanel=new JPanel();
        JPanel labelpanel=new JPanel();
        len=array.length;
        length=len;
        button=new JButton[len];
        for(int i=0;i<len;i++)
        {
            button[i]=new JButton(array[i]+"");
            button[i].setFont(new Font("Footlight MT light",Font.PLAIN,120));
            button[i].setBackground(Color.white);
            buttonpanel.add(button[i]);
        }
        reset=new JButton("RESET");
        reset.setFont(new Font("Footlight MT light",Font.BOLD,90));
        label=new JLabel();
        labelpanel.add(label);
        JButton start= new JButton("START");
        start.setFont((new Font("Footlight MT light",Font.BOLD,90)));
        southpanel.add(start);
        southpanel.add(reset);
        panel.add(buttonpanel);
        panel.add(labelpanel);
        panel.add(southpanel);
        frame.add(panel);


        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start.setVisible(false);
                label.setFont(new Font("Footlight MT Light",Font.PLAIN,100));
                label.setText("Sorting started!");
                reset.setVisible(false);
                new BubbleSort().sort();
            }
        });
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                index=0;
                frame.dispose();
                new SecondPage().secondframe(array);

            }
        });
        frame.setSize(2000,1800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public void sort()
        {

            timer1= new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {


                    int first,second;
                    first = Integer.parseInt(button[index].getText());
                    second = Integer.parseInt(button[index+1].getText());
                    if (first > second) {
                        label.setText("Numbers "+first+" and "+second+" are swapped.");
                        button[index].setText(second + "");

                        button[index+1].setText(first + "");
                    }
                    else {
                        label.setText("Numbers "+ first+" and "+second+" are in the right position.");
                    }
                    index++;
                    if(index==len-1)
                    {
                        if(count==(length-2)) {
                            button[index].setBackground(Color.MAGENTA);
                            button[index-1].setBackground(Color.MAGENTA);
                            label.setText("Array is sorted!");
                            timer1.stop();
                            reset.setVisible(true);
                        }
                        else {
                            button[index].setBackground(Color.MAGENTA);
                            count++;
                            len=length-count;
                            index = 0;
                        }
                    }

                }
            });
            timer1.start();


        }
}

