package cookTimer;

import java.awt.event.*;
import javax.swing.Timer;
public class ClockModel implements ActionListener{
    private int timeInSeconds;
    ClockView view;
    Timer timer ;
    public ClockModel(int timeInSeconds) {
        this.timeInSeconds = timeInSeconds;
        view = new ClockView(this);
          timer = new Timer(1000,this);
        // Start the timer
      //  timer.start();
    }

    public void actionPerformed(ActionEvent event) {
        // Alter the model using the model's tick() method
        // This has the effect of incrementing the clock by one second
       tick();
    }
        

    
    public ClockModel() {
        this(0);
    }

    public ClockModel(int hours, int minutes, int seconds) {
        this(hours*3600 + minutes*60 + seconds);
    }
    
    public void tick() {
    	// Alter the data stored by the model
    	timeInSeconds--;
    	if(timeInSeconds>=0){
    
    	// Advise (signal) the View that the data has changed
    	// and get it to update the view (i.e. modify the display)
    	view.update();
    }
    }
    
    public int currentTime() {
        return timeInSeconds;
    }
     public void stop(){
        timer.stop();
    }
    public void start(){
        timer.start();
    }
}
    
