package game;
import java.util.*;
//import java.util.L

public class Main {
	static ArrayList<Integer> playPositions=new ArrayList<Integer>();
	static ArrayList<Integer> cpuPositions=new ArrayList<Integer>();
	
	
public static void printgameBoard(char [][] gameBoard) {
	
	for(char [] rows:gameBoard)
	{
		for(char c:rows)
			System.out.print(c);
	
	System.out.println();
		}
	}

public static void placePiece(char [][] gameBoard,int pos,String user) {
	char symbol='X';
	if(user.equals("player")) {
		playPositions.add(pos);
		symbol='X';}
		else if(user.equals("cpu")) {
			symbol='0';
			cpuPositions.add(pos);}
	switch(pos) {
	case 1:
		gameBoard[0][0]=symbol;
		break;
	case 2:
		gameBoard[0][2]=symbol;
		break;
	case 3:
		gameBoard[0][4]=symbol;
		break;
	case 4:
		gameBoard[2][0]=symbol;
		break;
	case 5:
		gameBoard[2][2]=symbol;
		break;

	case 6:
		gameBoard[2][4]=symbol;
		break;
	case 7:
		gameBoard[4][0]=symbol;
		break;
	case 8:
		gameBoard[4][2]=symbol;
		break;
	case 9:
		gameBoard[4][4]=symbol;
		break;
	default:
		break;
	}
	//printgameBoard(gameBoard);

}
 public static String check() {
	 List toprow=Arrays.asList(1,2,3);
	 List midrow=Arrays.asList(4,5,6);
	 List botrow=Arrays.asList(7,8,9);
	 List leftcol=Arrays.asList(1,4,7);
	 List midcol=Arrays.asList(2,5,8);
	 List rightcol=Arrays.asList(3,6,9);

	 List cross1=Arrays.asList(1,5,9);
	 List cross2=Arrays.asList(3,5,7);
	 
	 List<List>winner=new ArrayList<List>();
	 winner.add(toprow);	 
	 winner.add(midrow);
	 winner.add(botrow );
	 winner.add(leftcol );
	 winner.add(midcol );
	 winner.add(rightcol );
	 winner.add(cross1);
	 winner.add(cross2);
	 
	 for(List l:winner) {
		 if(playPositions.containsAll(l)) {
			 return "Congratulation you won";}
		 
		 else if(cpuPositions.containsAll(l)) {
			 return "CPU wins Sorry";}
		 
		 else if(playPositions.size()+cpuPositions.size()==9) {
			 return "CAT!"; }
	 }
	 
	 
	 return ""; 
 }
 
 
 
 
 
 
public static void main(String[] args) {
		// TODO Auto-generated method stub
char [] [] gameBoard= {{' ','|',' ','|',' '},
		{'-','+','-','+','-'},
		{' ','|',' ','|',' '},
		{'-','+','-','+','-'},
		{' ','|',' ','|',' '}};
printgameBoard(gameBoard);
Scanner sc=new Scanner (System.in);
while(true) {
System.out.println("Enter the position(1-9) ");
int pos=sc.nextInt();
while(playPositions.contains(pos)|| 
		 cpuPositions.contains(pos)) {
	 System.out.println("position taken ! enter valid position");
	 pos=sc.nextInt();
}
placePiece(gameBoard,pos,"player");
String res=check();
if(res.length()>0) {
	System.out.println(res);
	break;}
Random rand=new Random();
int cpuPos=rand.nextInt(9)+1;
 while(playPositions.contains(cpuPos)|| 
		 cpuPositions.contains(cpuPos)) {
	 cpuPos=rand.nextInt(9)+1;
 }
placePiece(gameBoard,cpuPos,"cpu");
printgameBoard(gameBoard);


}
}}
