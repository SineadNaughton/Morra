/*
Morra.java
S Naughton
12/04/2018
*/
import java.lang.Math;
import javax.swing.JOptionPane;

public class Morra{

	private String choice,roundWinner;
	private int humanFingers,humanEven,humanOdd,humanPoints,humanBonusPoints,humanRoundPoints,humanGamePoints;
	private int compFingers,compEven,compOdd,compPoints,compBonusPoints,compRoundPoints,compGamePoints;
	private int fingerSum;
	private int roundWin,roundLose;



	public Morra(String choice,int humanFingers){
		this.choice=choice;
		this.humanFingers=humanFingers;
		compFingers=(int)(Math.random()*10+1);
		fingerSum=0;
		humanPoints=0;
		compPoints=0;
		humanBonusPoints=0;
		compBonusPoints=0;
		humanRoundPoints=0;
		compRoundPoints=0;
		roundLose=0;
		roundWin=0;
		compGamePoints=0;
		humanGamePoints=0;
		roundWinner="";
	}


	public void compute(){

		//CHECK NORMAL POINT WINNER AND ROUNF WINNER
		fingerSum=humanFingers+compFingers;
		if(choice.equals("odds")){
			if(fingerSum%2==0){
				compPoints=2;
				roundWinner="Computer";
				roundLose++;
			}
			else
			{
				humanPoints=2;
				roundWinner="You";
				roundWin++;
			}
		}
		else if(choice.equals("evens")){
			if(fingerSum%2==0){
				humanPoints=2;
				roundWinner="You";
				roundWin++;
			}
			else {
				compPoints=2;
				roundWinner="Computer";
				roundLose++;
			}
		}
		else{
			JOptionPane.showMessageDialog(null, "Invalid choice entered, Please try again");
		}


		//CHECK BONUS POINT WINNER
		if((fingerSum-humanFingers)<(fingerSum-compFingers)){
			humanBonusPoints++;
		}
		else if((fingerSum-humanFingers)>(fingerSum-compFingers)){
			compBonusPoints++;
		}
		else{
			humanBonusPoints++;
			compBonusPoints++;
		}


		//ADD TOTAL ROUND POINTS
		compRoundPoints=compPoints+compBonusPoints;
		humanRoundPoints=humanPoints+humanBonusPoints;

		//CHECK IF ODD OR EVEN NUMBER PICKED
		if(compFingers%2==0){
			compEven++;
		}
		else{
			compOdd++;
		}

		if(humanFingers%2==0){
			humanEven++;
		}
		else{
			humanOdd++;
		}


	}



	//GETTERS FOR ROUND INFO
	//round points
	public int getHumanRoundPoints(){
		return humanRoundPoints;
	}


	public int getCompRoundPoints(){
		return compRoundPoints;
	}



	//round winner
	public String getRoundWinner(){
		return roundWinner;
	}



	//bonus points
	public int getHumanBonusPoints(){
		return humanBonusPoints;
	}


	public int getCompBonusPoints(){
		return compBonusPoints;
	}


	//comp odd number picked
	public int getCompOdd(){
		return compOdd;
	}



	//comp even number picked
	public int getCompEven(){
		return compEven;
	}



	//human even number picked
	public int getHumanEven(){
		return humanEven;
	}



	//human odd number picked
	public int getHumanOdd(){
		return humanOdd;
	}



	//round win
	public int getRoundWin(){
		return roundWin;

	}



	//round lose
	public int getRoundLose(){
		return roundLose;

	}



	//comp fingers picked
	public int getCompFingers(){
		return compFingers;
	}

}

