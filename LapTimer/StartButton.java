package LapTimer;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class StartButton extends JButton implements ActionListener{
	Model model;
	public StartButton(Model model){
		super("start");
		this.model=model;
		addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		JButton startStop=(JButton) e.getSource();
		if(startStop.getText().equals("Stop")) {// Its on STOP
            startStop.setBackground(Color.GREEN);
            startStop.setText("Start");
            model.getTimer().stop();
        } else {
            startStop.setBackground(Color.RED);
            startStop.setText("Stop");
           model.setToZero();	
           model.getTimer().start();
	}
	}
}
