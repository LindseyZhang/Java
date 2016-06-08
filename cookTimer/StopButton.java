package cookTimer;



import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class StopButton extends JButton implements ActionListener{
	ClockModel model;

	public StopButton(ClockModel model){
		super("stop");
		this.model=model;
		addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
	model.stop();
	}
	}

