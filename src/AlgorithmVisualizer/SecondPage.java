package AlgorithmVisualizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SecondPage {
    JFrame fr=new JFrame("Sorting Visualizer");
    JPanel pan=new JPanel();
    JPanel panNorth=new JPanel();
    JPanel panCenter=new JPanel();
    JPanel panSouth=new JPanel();
    static JButton[] button;
    JButton bubble = new JButton("Bubble sort");

    JButton merge = new JButton("Merge sort");
    JButton quick= new JButton("Quick sort");
    JButton heap =new JButton("Heap sort");
    JButton next=new JButton("Next");
    JLabel label=new JLabel();
    JButton reset;
    int len,arraylen,index;
    Boolean sorted=false;
    static int[] input_array;

    public void FrameDesign(String array)
    {
        pan.setLayout(new GridLayout(3,1));
        panNorth.setLayout(new FlowLayout());
        panCenter.setLayout(new FlowLayout());
        panSouth.setLayout(new FlowLayout());
        String[] input=array.split(",");
        len=input.length;
        button=new JButton[len];
        input_array=new int[len];
        panNorth.add(bubble);
        panNorth.add(merge);
        panNorth.add(quick);
        panNorth.add(heap);
        bubble.setFont(new Font("Footlight MT light",Font.BOLD,90));
        merge.setFont(new Font("Footlight MT light",Font.BOLD,90));
        quick.setFont(new Font("Footlight MT light",Font.BOLD,90));
        heap.setFont(new Font("Footlight MT light",Font.BOLD,90));
        for(int i=0;i<len;i++)
        {
            input_array[i]=Integer.parseInt(input[i]);
            button[i]=new JButton(input[i]);
            button[i].setFont(new Font("Footlight MT light",Font.PLAIN,120));
            button[i].setBackground(Color.white);
            panCenter.add(button[i]);
        }
        label.setFont(new Font("Footlight MT light",Font.BOLD,50));
        reset=new JButton("RESET");
        reset.setFont(new Font("Footlight MT light",Font.BOLD,70));
        next.setVisible(false);
        panSouth.add(reset);
        panSouth.add(label);
        panSouth.add(next);
        pan.add(panNorth);
        pan.add(panCenter);
        pan.add(panSouth);
        fr.add(pan);
        fr.setSize(2000,1800);
        fr.setLocationRelativeTo(null);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setResizable(false);
        fr.setVisible(true);
    }
    public void secondframe(String array) {
        FrameDesign(array);
        bubble.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                fr.dispose();
                BubbleSort bu = new BubbleSort();
                bu.sort(array);
            }
        });
        merge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(sorted)
                    label.setText("Array is already sorted.Click on reset");
                else {
                    reset.setVisible(false);
                    MergeSort mer = new MergeSort();
                    int value=mer.sort(len);
                    if(value==1) {
                        sorted = true;
                        label.setText("Array is sorted");
                        reset.setVisible(true);
                    }
                }
            }
        });
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sorted=false;
                label.setText("");
                for(int i=0;i<len;i++)
                {
                    button[i].setText(input_array[i]+"");
                    button[i].setBackground(Color.white);

                }
            }
        });

    }







}

