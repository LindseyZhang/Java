package cookTimer;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

public class ClockView {
    JPanel displayArea;
  //  JTextField limerickClock; 
    ClockModel model; 
    private JTextField hh;
    private JTextField mm;
    private JTextField ss;
    private JPanel lapDetails;
    private Timer clock;
    private PlayButton startStop;
    private StopButton lap;

    public ClockView(ClockModel model) {
        JFrame clockFace = new JFrame("Clock MVC");
        clockFace.setSize(450,350);
        clockFace.setLocationRelativeTo(null);
        clockFace.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Font preferredFont = new Font("OCR A EXTENDED",Font.BOLD,50);

        Container contentPane = clockFace.getContentPane();
        
        
        
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

        lapDetails = new JPanel();
        lapDetails.setBackground(Color.BLACK);
        lapDetails.setForeground(Color.YELLOW);
        
        

        JPanel buttonArea = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonArea.setBackground(Color.BLACK);
     //  startStop = new JButton("Start");

        startStop=new PlayButton(model);
        startStop.setBackground(Color.GREEN);          
        lap = new StopButton(model);
        lap.setBackground(Color.BLUE);
        lap.setForeground(Color.WHITE);
                
        buttonArea.add(startStop);
        buttonArea.add(lap);

        appLayout.add(timeArea,BorderLayout.NORTH);
        appLayout.add(lapDetails,BorderLayout.CENTER);
      
        appLayout.add(buttonArea,BorderLayout.SOUTH);
        contentPane.add(appLayout);

        // Create a timer that will trigger ActionEvents 
        

        this.model = model;
        //new ClockController(model);

        update();
        clockFace.setVisible(true);
    }

    public void update() {
        ss.setText(secondsAsTimeText(model.currentTime()));
        mm.setText(minutesAsTimeText(model.currentTime()));
        hh.setText(hoursAsTimeText(model.currentTime()));
        
    }

    public String secondsAsTimeText(int timeInSeconds) {
        int seconds,minutes, hours ;
        minutes = timeInSeconds / 60;
        seconds = timeInSeconds % 60;
        return String.format("%02d",seconds);
    }
    public String minutesAsTimeText(int timeInSeconds) {
        int hours,minutes, seconds ;
        minutes = timeInSeconds / 60;
        seconds = timeInSeconds % 60;
        hours = minutes / 60;
        minutes = minutes % 60;
        return String.format("%02d",minutes);
    }
    public String hoursAsTimeText(int timeInSeconds) {
        int hours, minutes, seconds ;
        minutes = timeInSeconds / 60;
        seconds = timeInSeconds % 60;
        hours = minutes / 60;
        minutes = minutes % 60;
        return String.format("%02d",hours);
    }
    
}
