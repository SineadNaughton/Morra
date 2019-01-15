/*
MorraApp.java
S Naughton
12/04/2018
*/
import java.lang.Math;
import javax.swing.JOptionPane;
import java.util.Arrays;
public class MorraApp{

	public static void main(String args[]){
		String choice="";
		int humanFingers=0;
		int compFingers=0;
		int fingerSum=0;
		String roundWinner="";
		int roundLose=0;
		int roundWin=0;
		int compGamePoints=0;
		int humanGamePoints=0;
		int compGameBonusPoints=0;
		int humanGameBonusPoints=0;
		String gameWinner="";
		String playAgain="";
		int compOdd=0;
		int compEven=0;
		int humanOdd=0;
		int humanEven=0;
		Morra[] myMorraArr=new Morra[1000]; //object array store instances of round
		Integer [] compBonusArr=new Integer[1000];//used Integer class array, as the default value for an object var is null (rather than 0) and therefore 0 values were not excluded when looping the array later in application
		Integer[] humanBonusArr=new Integer[1000];
		int[] humanFingersArr=new int[10];
		int[] compFingersArr=new int[10];




		do{//LOOP GAME

			//INPUT VERIFYING for odds/evens
			do{choice=JOptionPane.showInputDialog(null, "Enter if you would like to play 'odds' or 'evens'");
				choice=choice.toLowerCase();
			}while(!choice.equals("odds")&&!choice.equals("evens"));



			do{//LOOP ROUND

				//INPUT VERIFYING for fingers 1-10
				do{humanFingers=Integer.parseInt(JOptionPane.showInputDialog("Enter between 1-10 fingers"));
				}while(humanFingers<1||humanFingers>10);

				Morra myMorra=new Morra(choice,humanFingers);
				myMorra.compute();


				//ROUND OUTPUT (storing getter values for output)
				compGamePoints=compGamePoints+myMorra.getCompRoundPoints();
				humanGamePoints=humanGamePoints+myMorra.getHumanRoundPoints();
				roundWinner=myMorra.getRoundWinner();
				compFingers=myMorra.getCompFingers();
				JOptionPane.showMessageDialog(null, "The computer used "+compFingers+" finger(s).\n"+roundWinner+" won that round. \nYou now have "+humanGamePoints+" point(s), and the computer has "+compGamePoints+" point(s)");

				//STORE THE ROUND VALUES TO OBJECT ARRAY
				for(int i=0;i<myMorraArr.length;i++){
					if(myMorraArr[i]==null){
						myMorraArr[i]=myMorra;
						break;
					}
				}

				//STORE ROUND FINGERS TO ARRAYS FOR END OF GAME OUTPUT
				for(int i=0;i<humanFingersArr.length;i++){
					if(humanFingersArr[i]==0){
						humanFingersArr[i]=humanFingers;
						break;
					}
				}

				for(int i=0;i<compFingersArr.length;i++){
					if(compFingersArr[i]==0){
						compFingersArr[i]=compFingers;
						break;
					}
				}

				//GET ROUND BONUS POINTS AND ADD TO GAME BONUS POINTS
				compGameBonusPoints=compGameBonusPoints+myMorra.getCompBonusPoints();
				humanGameBonusPoints=humanGameBonusPoints+myMorra.getHumanBonusPoints();

			}
			while(compGamePoints<6&&humanGamePoints<6);


			//CHECK GAME WINNER
			if((humanGamePoints>=6)&&(compGamePoints>=6)){
				gameWinner="It's a draw!\n";
			}

			else if(humanGamePoints>=6){
				gameWinner="You won that game!\n";
			}
			else{
				gameWinner="Computer won that game!\n";
			}


			//USE A STRING BUILDER WITH THE LOOP TO ATTACHE OUTPUT FOR FINGERS PER ROUND TOGETHER - ATTACH STRING BUILDER TO THE OUTPUT WINDOW WITH TO STRING METHOD (BELOW)
			int h=0;
			StringBuilder hFingerReport = new StringBuilder();
			while(humanFingersArr[h]!=0){
				hFingerReport.append("In round "+(h+1)+" you played "+humanFingersArr[h]+" fingers.\n");
				h++;
			}

			int e=0;
			StringBuilder cFingerReport = new StringBuilder();
			while(compFingersArr[e]!=0){
				cFingerReport.append("In round "+(e+1)+" the computer played "+compFingersArr[e]+" fingers.\n");
				e++;
			}

			//GAME OUTPUT
			JOptionPane.showMessageDialog(null, gameWinner+"Your game summary\n"+hFingerReport.toString()+"\nComputer game summary\n"+cFingerReport.toString());


			//STORE BONUS POINTS PER GAME IN ARRAYS
			for(int i=0;i<compBonusArr.length;i++){
				if(compBonusArr[i]==null){
					compBonusArr[i]=compGameBonusPoints;
					break;
				}
			}
			for(int i=0;i<humanBonusArr.length;i++){
				if(humanBonusArr[i]==null){
					humanBonusArr[i]=humanGameBonusPoints;
					break;
				}
			}


			//RESET BONUS GAME BONUS POINTS (already stored in array)
			compGameBonusPoints=0;
			humanGameBonusPoints=0;

			//CLEAR VALUES FOR FINGERS PER ROUND ARRAYS
			compFingersArr=new int[10];
			humanFingersArr=new int[10];

			//CLEAR VALUES FOR GAME POINTS
			compGamePoints=0;
			humanGamePoints=0;


			//CHECK CONDITION TO PLAY AGAIN
			do{playAgain=JOptionPane.showInputDialog(null, "Would you like to play again? Enter yes or no");
			}while(!playAgain.equalsIgnoreCase("yes")&&!playAgain.equalsIgnoreCase("no"));


		}while(playAgain.equalsIgnoreCase("yes"));



		//STOP PLAYING OUTPUT
		//fetch rounds won
		int k=0;
		while(myMorraArr[k]!=null){
			Morra win=myMorraArr[k];
			roundWin=roundWin+win.getRoundWin();
			k++;
		}



		//fetch rounds lost
		int j=0;
		while(myMorraArr[j]!=null){
			Morra lose=myMorraArr[j];
			roundLose=roundLose+lose.getRoundLose();
			j++;
		}



		//fetch comp odd numbers chosen
		int m=0;
		while(myMorraArr[m]!=null){
			Morra odd=myMorraArr[m];
			compOdd=compOdd+odd.getCompOdd();
			m++;
		}




		//fetch comp even numbers chosen
		int n=0;
		while(myMorraArr[n]!=null){
			Morra even=myMorraArr[n];
			compEven=compEven+even.getCompEven();
			n++;
		}




		//fetch human odd numbers chosen
		int p=0;
		while(myMorraArr[p]!=null){
			Morra odd=myMorraArr[p];
			humanOdd=humanOdd+odd.getHumanOdd();
			p++;
		}




		//fetch human even numbers chosen
		int q=0;
		while(myMorraArr[q]!=null){
			Morra even=myMorraArr[q];
			humanEven=humanEven+even.getHumanEven();
			q++;
		}


		//HUMAN GAME BONUS OUTPUT: loop human game bonus points array to retrieve values
		int r=0;
		StringBuilder hBonusReport=new StringBuilder();
		while(humanBonusArr[r]!=null){
			hBonusReport.append("In game "+(r+1)+" you got "+humanBonusArr[r]+" bonus point(s)\n");
			r++;
		}


		 //COMP GAME BONUS OUTPUT:loop comp game bonus points array to retrieve values
		int s=0;
		StringBuilder cBonusReport=new StringBuilder();
		while(compBonusArr[s]!=null){
			cBonusReport.append("In game "+(s+1)+" computer got "+compBonusArr[s]+" bonus point(s)\n");
			s++;
		}


		//OUTPUT ABOVE VLAUES
		JOptionPane.showMessageDialog(null, "Playing History:\n\nYou won "+roundWin+" round(s), and lost "+roundLose+" round(s). \nComputer played "+compOdd+" odd number(s), and "+compEven+" even number(s). \nYou played "+humanEven+" even number(s), and "+humanOdd+"  odd number(s).\n"+hBonusReport.toString()+cBonusReport.toString());


	}
}


