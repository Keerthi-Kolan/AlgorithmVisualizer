package AlgorithmVisualizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class SecondPage {
    Boolean sorted=false;

    public void secondframe(int[] array) {
        JFrame fr=new JFrame("Algorithm Visualizer");
        JPanel pan=new JPanel();
        JPanel panNorth=new JPanel();
        JPanel panCenter=new JPanel();
        JPanel panSouth=new JPanel();
        JButton[] button;
        JButton bubble = new JButton("Bubble sort");
        JButton merge = new JButton("Merge sort");
        JButton quick= new JButton("Quick sort");
        JButton heap =new JButton("Heap sort");
        JButton mainpage=new JButton("Go to Main page");
        JLabel label=new JLabel("Click on any algorithm");

        int len;
        pan.setLayout(new GridLayout(3,1));
        panNorth.setLayout(new FlowLayout());
        panCenter.setLayout(new FlowLayout());
        panSouth.setLayout(new FlowLayout());
        panNorth.add(bubble);
        panNorth.add(merge);
        panNorth.add(quick);
        panNorth.add(heap);
        bubble.setFont(new Font("Footlight MT light",Font.BOLD,90));
        merge.setFont(new Font("Footlight MT light",Font.BOLD,90));
        quick.setFont(new Font("Footlight MT light",Font.BOLD,90));
        heap.setFont(new Font("Footlight MT light",Font.BOLD,90));
        label.setFont(new Font("Footlight MT light",Font.BOLD,120));
        pan.add(panNorth);
        pan.add(panCenter);
        pan.add(panSouth);
        panSouth.add(label);
        panSouth.add(mainpage);
        mainpage.setFont(new Font("Footlight MT light",Font.BOLD,90));
        mainpage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StartPage().firstframe();
                fr.dispose();
            }
        });
        fr.add(pan);
        fr.setSize(2000,1800);
        fr.setLocationRelativeTo(null);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setResizable(false);
        fr.setVisible(true);
        len=array.length;
        button=new JButton[len];
        for(int i=0;i<len;i++)
        {
            button[i]=new JButton(array[i]+"");
            button[i].setFont(new Font("Footlight MT light",Font.PLAIN,120));
            button[i].setBackground(Color.white);
            panCenter.add(button[i]);
        }
        bubble.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                fr.dispose();
                new BubbleSort().BubbleSortdesign(array);

            }
        });
        merge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(sorted)
                    label.setText("Array is already sorted.Click on reset");
                else {

                    MergeSort mer = new MergeSort();


                }
            }
        });


    }







}

