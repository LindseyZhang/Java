package lifeGame;

public class Model {
	private int col,row;
	private int current[][];
	private int next[][];
	private DisplayPanel view;
	private Thread thread;
	
	public Model(DisplayPanel view){
		this.view=view;
		col=Global.Width/Global.CellSize;
		row=Global.Height/Global.CellSize;
		current=new int[row][col];
		next=new int[row][col];
		init();	
	}
	public void init(){
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				int temp=(int) (Math.random()*1.2);
				current[i][j]=temp;
				next[i][j]=0;
			}
		}
	}
	public void clearNext(){
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
	          next[i][j]=0;
			}
		}
	}
	public synchronized void judgeLive(int row,int col){
		int neigbour=0;
		for(int i=row-1;i<row+2;i++){
			for(int j=col-1;j<col+2;j++){
				if(current[((i+this.row)%this.row)][((j+this.col)%this.col)]==1){
					neigbour++;
				}
			}
		}
		if(current[row][col]==1){
			neigbour--;
		}
			if(neigbour==3){
				next[row][col]=1;
			}else if(neigbour>3||neigbour<2){
				next[row][col]=0;
			}else {
				next[row][col]=current[row][col];			
			}	
	}
	public void start(){
		thread=new Thread(new LifeGeneration());
		thread.start();
	}
	protected class LifeGeneration implements Runnable{

		public void run() {
			while(true){
			 view.showCell();
				for(int i=0;i<row;i++){
					for(int j=0;j<col;j++){
						judgeLive(i,j);
						// next=current;
						//current[i][j]=next[i][j];
					}
				}
				for(int i=0;i<row;i++){
					for(int j=0;j<col;j++){
						current[i][j]=next[i][j];
					}
				}
			 clearNext();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}		
	}
	}

	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int[][] getCurrent() {
		return current;
	}
	public void setCurrent(int[][] current) {
		this.current = current;
	}
	public int[][] getNext() {
		return next;
	}
	public void setNext(int[][] next) {
		this.next = next;
	}
	public int getCellState(int i,int j){
		return current[i][j];
	}
	
}
