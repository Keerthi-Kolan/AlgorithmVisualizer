package AlgorithmVisualizer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MergeSort {
    static int returnvalue=1;
    int iteration=0;
    public void divide(JButton[] button,int low, int high)
    {
        if(low==high&&returnvalue==1)
            return;
        if(returnvalue==1) {
            int mid = (low + high) / 2;
            divide(button, low, mid);
            divide(button, mid + 1, high);
            System.out.println(" In divide function low="+low+" high="+high+" mid="+mid+" returnvalue="+returnvalue);

            Timer timer=new Timer(5000,new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    merge(button, low, high);
                }
            });
            timer.start();
        }
    }
    public void merge(JButton[] button,int low,int high)
    {
        returnvalue=0;
        int[] temp=new int[(high-low)+1];
        int mid=(low+high)/2;
        int p1=low,p2=mid+1,index=0;
        while(p1<=mid&&p2<=high)
        {
            if(Integer.parseInt(button[p1].getText())<Integer.parseInt(button[p2].getText()))
                temp[index++]=Integer.parseInt(button[p1++].getText());
            else
                temp[index++]=Integer.parseInt(button[p2++].getText());
        }
        while(p1<=mid)
            temp[index++]=Integer.parseInt(button[p1++].getText());
        while(p2<=high)
            temp[index++]=Integer.parseInt(button[p2++].getText());
        iteration=0;
        int i=0;
        while(i<(high-low+1)) {
            button[low + i].setText(temp[i] + "");
            System.out.println("Index "+(low+i)+"sorted");
            i++;
        }
        /*System.out.println("Entered Merge function");
        while(returnvalue==0) {
            Timer timer = new Timer();
            TimerTask task2 = new TimerTask() {
                @Override
                public void run() {
                    if (iteration < (high - low + 1)) {
                       // System.out.println("low value=" + (low) + " high value=" + high + " iteration=" + iteration);
                        button[(low + iteration)].setText(temp[iteration] + "");
                        System.out.println("index " + (low + iteration) + " is sorted");
                        iteration++;
                    }
                    else {
                        //System.out.println("I just stopped");
                        returnvalue = 1;
                        timer.cancel();
                    }
                }
            };
            timer.scheduleAtFixedRate(task2, 0, 1000);
        }*/

    }


}

