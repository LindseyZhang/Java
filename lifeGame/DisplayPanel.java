package lifeGame;

import javax.swing.*;
import java.awt.*;

public class DisplayPanel extends JFrame{
    private Model model;
	private JTextField current[][];
	public DisplayPanel(){
          model=new Model(this);
		  init();
	//	  showCell();
          model.start();
	}

	public void init(){
		setTitle("Game of life");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Global.Width,Global.Height);

		current=new JTextField[model.getRow()][model.getCol()];
		Container content=getContentPane();
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(model.getRow(),model.getCol()));
		for(int i=0;i<model.getRow();i++){
			for(int j=0;j<model.getCol();j++){
				current[i][j]=new JTextField();
				if(current[i][j]!=null)
					panel.add(current[i][j]);
				current[i][j].setEditable(false);
				current[i][j].setFocusable(false);
			//	JPanel j1=new JPanel();
			//	panel.add(j1);
			}
		}
		content.add(panel);
		setVisible(true);
	}
	public void showCell(){
		for(int i=0;i<model.getRow();i++){
			for(int j=0;j<model.getCol();j++){
				if(model.getCellState(i, j)==0){
					current[i][j].setBackground(Color.white);
				}else{
					current[i][j].setBackground(Color.black);
				}
			}
		}
	}

	public static void main(String agrc[]){
		new DisplayPanel();
	}

}