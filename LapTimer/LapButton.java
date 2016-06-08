package LapTimer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class LapButton extends JButton implements ActionListener{
    private Model model;
    public LapButton(Model model){
    	super("Lap");
    	this.model=model;
		addActionListener(this);
    }
	@Override
	public void actionPerformed(ActionEvent arg0) {
		   model.increseLapCounter();

         // lapDetails.append("Lap " + String.format("%02d",lapCounter) + " : " +model.timeAsText() + "\n");		        
	}

}

