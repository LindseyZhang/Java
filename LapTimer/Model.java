package LapTimer;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.event.*;

public class Model implements ActionListener{
    private int lapCounter;
    private int lastLap;
    private int currentTime;
    private Timer clock;    
    private LapTimer view;
    List<String> lapDetail;
   
    public Model(){
    	lapCounter=0;
    	lastLap=0;
    	currentTime=0;
    	lapDetail=new ArrayList<String>();
    	view=new LapTimer(this);
    	clock=new Timer(1000,this);  
    //	clock.start();
    }
    
    public void setToZero(){
    currentTime = 0;
    lapCounter = 0;
    lastLap = 0;
    lapDetail.clear();
    view.reset();
    }

   public void increseLapCounter(){
	   lapCounter++;	   
	   String s=view.returnLapInfo(lapCounter, timeAsText(currentTime), timeAsText(currentTime - lastLap));
	   lapDetail.add(s);
	   view.reset();
	   for(int i=lapDetail.size()-1;i>=0;i--){
		   view.updateLap(lapDetail.get(i));
	   }
	   lastLap=currentTime;
	//   view.updateLap(lapCounter, timeAsText(currentTime),timeAsText(currentTime - lastLap));
   }
   public int getLapCounter(){
	   return lapCounter;
   }
	public void actionPerformed(ActionEvent arg0) {		
		currentTime++;
		view.updateTime(timeAsText(currentTime));		
	}
	  public String timeAsText(int currentTime) {
	        int currentHH = 0;
	        int currentMM = 0;
	        int currentSS = 0;
	        currentMM = currentTime / 60;
	        currentSS = currentTime % 60;
	        currentHH = currentMM / 60;
	        currentMM = currentMM % 60;
	        return String.format("%02d:%02d:%02d",currentHH,currentMM,currentSS);
	    }
	  public Timer getTimer(){
		  return clock;
	  }
}