package LapTimer;

import javax.swing.*;

import java.awt.*;

public class LapTimer extends JFrame {
    private JTextField hh;
    private JTextField mm;
    private JTextField ss;
    private JTextArea lapDetails;
    private StartButton startStop;
    private LapButton lap;

    private Model model;
    
	public LapTimer(Model model){
	 super("A Lap Timer...");
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setSize(450,350);
     this.model=model;
     Font preferredFont = new Font("OCR A EXTENDED",Font.BOLD,50);

     Container contentPane =getContentPane();

     JPanel appLayout = new JPanel(new BorderLayout());

     JPanel timeArea = new JPanel(new FlowLayout(FlowLayout.CENTER,25,5));
     timeArea.setBackground(Color.BLACK);
     hh = new JTextField("00",2);
     hh.setFont(preferredFont);
     hh.setForeground(Color.RED);
     hh.setHorizontalAlignment(JTextField.CENTER);
     hh.setPreferredSize(new Dimension(50,50));
     hh.setOpaque(false);
     hh.setEditable(false);
     mm = new JTextField("00",2);
     mm.setFont(preferredFont);
     mm.setForeground(Color.RED);
     mm.setHorizontalAlignment(JTextField.CENTER);
     mm.setPreferredSize(new Dimension(50,50));
     mm.setOpaque(false);
     mm.setEditable(false);
     ss = new JTextField("00",2);
     ss.setFont(preferredFont);
     ss.setForeground(Color.RED);
     ss.setHorizontalAlignment(JTextField.CENTER);
     ss.setPreferredSize(new Dimension(50,50));
     ss.setOpaque(false);
     ss.setEditable(false);
     timeArea.add(hh);
     timeArea.add(mm);
     timeArea.add(ss);

     lapDetails = new JTextArea(12,15);
     lapDetails.setBackground(Color.BLACK);
     lapDetails.setForeground(Color.YELLOW);
     lapDetails.setFont(new Font("Calibri",Font.BOLD,14));
     JScrollPane laps = new JScrollPane(lapDetails);

     JPanel buttonArea = new JPanel(new FlowLayout(FlowLayout.CENTER));
     buttonArea.setBackground(Color.BLACK);
     startStop = new StartButton(model);
     startStop.setBackground(Color.GREEN);
  //   startStop.addActionListener(this);
     lap = new LapButton(model);
     lap.setBackground(Color.BLUE);
     lap.setForeground(Color.WHITE);
  //   lap.addActionListener(this);        
     buttonArea.add(startStop);
     buttonArea.add(lap);

     appLayout.add(timeArea,BorderLayout.NORTH);
     appLayout.add(laps,BorderLayout.CENTER);// Centre od screen is blank
     appLayout.add(buttonArea,BorderLayout.SOUTH);
     contentPane.add(appLayout);

    setVisible(true);
	}
	public void updateTime(String t){
		  hh.setText(t.substring(0,2));
          mm.setText(t.substring(3,5));
          ss.setText(t.substring(6));		
	}
/*	public void updateLap(int lapCounter,String s,String t){
        lapDetails.append("Lap " + String.format("%02d",lapCounter) + 
                " : " + s + 
                " - duration " + t + "\n");
	}*/
	public String returnLapInfo(int lapCounter,String s,String t){
		return "Lap " + String.format("%02d",lapCounter) + 
                " : " + s + 
                " - duration " + t + "\n";
	}
	public void updateLap(String s){
		lapDetails.append(s);
	}
	public void reset(){
		lapDetails.setText("");
	}
}
