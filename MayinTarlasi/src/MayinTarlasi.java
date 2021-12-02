import java.util.Random;
import java.util.Scanner;

public class MayinTarlasi {
	int rowNumber, colNumber,size;
	int[][] map;
	int[][] board;
	boolean game = true;
	
	Random rand=new Random();
	Scanner scan=new Scanner(System.in);
	
	MayinTarlasi(int rowNumber,int colNumber){
		this.rowNumber=rowNumber;
		this.colNumber=colNumber;
		this.map = new int [rowNumber][colNumber];
		this.board=new int [rowNumber][colNumber];
		this.size=rowNumber*colNumber;
		
	}
	
	public void run() {
		int row,col,success=0;
		prepareGame();
		print(map);
		System.out.println("Oyun Baþladý !");
		while(game) {
			print(board);
			System.out.println("Satýr :");
			row = scan.nextInt();
			System.out.println("Sütun :");
			col = scan.nextInt();
			if(row < 0 || row >= rowNumber) {
				System.out.println("Geçersiz koordinat !");
				continue;
			}
			if(col < 0 || col >= colNumber) {
				System.out.println("Geçersiz koordinat !");
				continue;
			}
			
			if(map[row][col]!= -1) {
				check(row,col);
				success++;
				if(success == (size -(size/4))){
					System.out.println("baþardýnýz !! Hiç Bir Mayýna Basmadýnýz.");
					break; 
				}
			}else {
				game = false;
				System.out.println("Game Over !");
			}
		}
	}
	
	public void check(int r, int c) {
		if(map[r][c] == 0) {
			if((c < colNumber -1) && (map[r][c+1] == -1)) {
				board[r][c]++; 
			}
			if((r < rowNumber -3) && (map[r+1][c] == -1)) {
				board[r][c]++; 
			}
			if((r > 0) && (map[r-1][c] == -1)) {
				board[r][c]++; 
			}
			if((c > 0) && (map[r][c-1] == -1)) {
				board[r][c]++; 
			}
			if(board[r][c] == 0) {
				board[r][c] = -2;
			}
		}
		
	}
	
	public void prepareGame() {
		int randRow,randCol,count=0;
		//for(int i=0;i<=(size/4);i++) 
		while(count!=(size/4)){
			randRow = rand.nextInt(rowNumber);
			randCol = rand.nextInt(colNumber);
			if(map[randRow][randCol]!= -1) {
				map[randRow][randCol]= -1;
				count++;
			}
		}
	}
	
	public void print(int[][] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				if(arr[i][j]>=0)
					System.out.print(" ");
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	

}
