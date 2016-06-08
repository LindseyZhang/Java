package puzzle;
import java.util.ArrayList;
import java.util.List;

import puzzle.Global.Direction;


public class WordSearchPuzzle{
	private char[][] puzzle;
	private List<String> puzzleWords;
	private View view;
	public int puzzleSize;

	public WordSearchPuzzle(View view){
		this.view=view;
		puzzleWords=new ArrayList<String>();
		
		getWordSearchList();
		setPuzzleSize();
		//puzzle=new char[puzzleSize][puzzleSize];
		getPuzzleAsGrid();
	}
	public WordSearchPuzzle(List<String> userSpecifiedWords){
		//puzzle generation using user specified words
		puzzleWords=userSpecifiedWords;
		
	}
	
	public WordSearchPuzzle(String wordFile, int wordCount, int shortest,int longest){
		//the words should appear one per line
	}
	//the dimensions of the puzzle grid should be set by summing the lengths of the words being used in
	//the puzzle and multiplying the sum by 1.5 or 1.75 or some other scaling factor to ensure that 
	//the grid will have enough additional characters to obscure the puzzle words.
	//once you have calculated how many characters you are going to have in the grid you can calculate the 
	//grid dimensions by getting the square root(rounded up) of the character
	
	public List<String> getWordSearchList(){
		//return the list of word used in the puzzle
		puzzleWords.add("encyclopeida");
		puzzleWords.add("trolley");
		puzzleWords.add("creek");
		puzzleWords.add("excursion");
		puzzleWords.add("hazardous");		
		return puzzleWords;		
	}
	public char[][] getPuzzleAsGrid(){
		
		//returns the generated grid as a two-dimensional array of characters
		puzzle=new char[puzzleSize][puzzleSize];
		for(int i=0;i<puzzleSize;i++){
			for(int j=0;j<puzzleSize;j++){
				puzzle[i][j]='-';
			}
		}
		for(String s:puzzleWords){
			boolean flag=insertWord(s.toLowerCase());

			while(!flag){
				flag=insertWord(s.toLowerCase());
			}
		}	
		
		
		for(int i=0;i<puzzleSize;i++){
			for(int j=0;j<puzzleSize;j++){
				if(puzzle[i][j]=='-'){
					int random=(int) (Math.random()*24)+97;
					puzzle[i][j]=(char) random;
				}
			}
		}
		return puzzle;
		
	}
	public boolean insertWord(String word){

		int i=(int) (Math.random()*(puzzleSize-1));
		int j=(int) (Math.random()*(puzzleSize-1));
		int k=(int) (Math.random()*Direction.values().length);
		Direction dirc;
		switch(k){
		case 0: dirc=Direction.UP;break;
		case 1: dirc=Direction.DOWN;break;
		case 2: dirc=Direction.LEFT;break;
		case 3: dirc=Direction.RIGHT;break;
		case 4: dirc=Direction.LEFTUPTORIGHTDOWN;break;
		case 5: dirc=Direction.RIGHTDOWNTOLEFTUP;break;
		case 6: dirc=Direction.LEFTDOWNTORIGHTUP; break;
		case 7: dirc=Direction.RIGHTUPTOLEFTDOWN;break;
		default: dirc=Direction.DOWN;
		}

		if(CanPutWord(word,i,j,dirc)){
			System.out.println(word+" ["+i+","+j+"] "+dirc.name());
			for(int a=0;a<word.length();a++){				
				puzzle[i][j]=word.charAt(a);
				switch(dirc){
				case UP:	i--;	break;
				case DOWN:	i++;	break;
				case LEFT:	j--;	break;
				case RIGHT:	j++;	break;
				case LEFTUPTORIGHTDOWN:	i++;j++; 	break;
				case RIGHTDOWNTOLEFTUP:	i--;j--; 	break;
				case LEFTDOWNTORIGHTUP:	i--;j++; 	break;
				case RIGHTUPTOLEFTDOWN:	i++;j--; 	break;
				default: 
				}
				if(i<0||i>=puzzleSize||j<0||j>=puzzleSize){
					return false;
				}
			}
			return true;
		}else{
			
			return false;
		}
		
	}
	public boolean CanPutWord(String word,int positionI,int positionJ,Direction direction){
//		if(word.length()==0){
//			return true;
//		}
					
//		if(positionI<0||positionI>=puzzleSize||positionJ<0||positionJ>=puzzleSize){
//			return false;
//		}
		for(int t=0;t<word.length();t++){
			char ch=word.charAt(t);	
			if(positionI<0||positionI>=puzzleSize||positionJ<0||positionJ>=puzzleSize){
			return false;
		}
		if(puzzle[positionI][positionJ]=='-'||ch==puzzle[positionI][positionJ]){			
			switch(direction){
			case UP:	positionI--;	break;
			case DOWN:	positionI++;	break;
			case LEFT:	positionJ--;	break;
			case RIGHT:	positionJ++;	break;
		
			case LEFTUPTORIGHTDOWN:	positionI++;positionJ++; 	break;
			case RIGHTDOWNTOLEFTUP:	positionI--;positionJ--; 	break;
			case LEFTDOWNTORIGHTUP:	positionI--;positionJ++; 	break;
			case RIGHTUPTOLEFTDOWN:	positionI++;positionJ--; 	break;
			default: 
			}
						
		}else{		
			return false;
		}
		
		}
		return true;
	}
	public String getPuzzleAsString(){
		//returns the generated grid as a string with newlines(i.t. \n) at the end of each line/row 
		//of the grid.

	/*	StringBuilder result=new StringBuilder();
        boolean flag=false;
        for (String string : puzzleWords) {
            if (flag) {
                result.append("\n");
            }else {
                flag=true;
            }
            result.append(string);
        }
        return result.toString();
        */
		StringBuilder result=new StringBuilder();
		for(int i=0;i<puzzleSize;i++){
			for(int j=0;j<puzzleSize;j++){  
			result.append(puzzle[i][j]);
			
			}
		}
		return result.toString();
		
	}
	public void showWordSearchPuzzle(boolean hide){
		// if hide =false,grid display should include details of where each word is located on the grid,
		//and the orientation used to place it.
	}
	
	private void generateWordSearchPuzzle(){
		//responsible for implementing the creation of the puzzle
		
	}
	public int getPuzzleSize(){
	    return puzzleSize;
	}
	public void setPuzzleSize() {
		//this.puzzleSize = puzzleSize;
		puzzleSize=0;
	    for (String string : puzzleWords) {
	     if(string.length()>puzzleSize){
	    	 puzzleSize=string.length();
	     }
	     puzzleSize=(int) (puzzleSize*1.05);
	}
	}


}
