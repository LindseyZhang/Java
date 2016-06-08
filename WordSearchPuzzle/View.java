package puzzle;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class View extends JFrame {
	private JLabel puzzleCell[][];
	private WordSearchPuzzle model;
	
	public View(){
		model=new WordSearchPuzzle(this);
		model.getPuzzleAsString();
		init(model.getPuzzleSize());
	}
	
	public void init(int size){
		setTitle("Word Search Puzzle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(size*60,size*60);

		puzzleCell=new JLabel[size][size];
		Container content=getContentPane();
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(size,size));
		
		String s=model.getPuzzleAsString();
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				puzzleCell[i][j]=new JLabel();
				if(puzzleCell[i][j]!=null){
					char character=s.charAt(i*size+j);
			//		System.out.print(character);
					puzzleCell[i][j].setText(String.valueOf(character));
					panel.add(puzzleCell[i][j]);					
				}
				puzzleCell[i][j].setFocusable(false);
			}
		}
		content.add(panel);
		setVisible(true);
	}	
	public static void main(String argc[]){
		new View();
	}

}
