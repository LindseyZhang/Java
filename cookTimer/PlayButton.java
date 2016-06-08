package cookTimer;


	import java.awt.Color;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.JButton;

	public class PlayButton extends JButton implements ActionListener{
		ClockModel model;

		public PlayButton(ClockModel model){
			super("play");
			this.model=model;
			addActionListener(this);
		}
		public void actionPerformed(ActionEvent e) {
		model.start();
		}
		}



