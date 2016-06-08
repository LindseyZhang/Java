package SelectBox;
import java.awt.*;

import javax.swing.*;

import cookTimer.ClockModel;
import LapTimer.Model;

import java.awt.event.*;
public class Select extends JFrame implements ActionListener{
	JRadioButton lap;
	JRadioButton cook;
    public Select(){
    	setTitle("start");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setSize(500,200);
    	Container content=getContentPane();
    	
    	JPanel panel=new JPanel(new BorderLayout());
    	JLabel label=new JLabel("please select a timer:");
    	label.setFont(new Font("",Font.ITALIC,20));
    	panel.add(label,BorderLayout.NORTH);
    	JPanel buttonPanel=new JPanel(new GridLayout(2,1));
    	
    	lap=new JRadioButton("Lap timer");
  //  	lap.addActionListener(this);
    	cook=new JRadioButton("cooking timer");
   // 	cook.addActionListener(this);
    	lap.setFont(new Font("",Font.PLAIN,15));
    	cook.setFont(new Font("",Font.PLAIN,15));
    	
    	ButtonGroup buttonGroup=new ButtonGroup();
    	buttonGroup.add(lap);
    	buttonGroup.add(cook);
    	
    	buttonPanel.add(lap);
    	buttonPanel.add(cook);
    	panel.add(buttonPanel,BorderLayout.CENTER);
    	JButton start=new JButton("start");
    	start.addActionListener(this);
    	panel.add(start,BorderLayout.SOUTH);
    	content.add(panel);
    	setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(lap.isSelected()){
			new Model();
		}else if(cook.isSelected()){
			//inputTime();
			new ClockModel(0,3,2);
		}
		
	}
/*	public void inputTime(){
		JFrame frame=new JFrame("input time");
		
	}*/
    
}
