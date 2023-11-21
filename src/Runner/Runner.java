package Runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Function.Functions;
import Pojo.Holder;
import Pojo.Snack;

public class Runner {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
			
		Functions functions = new Functions();
		
		while(true) {
			System.out.println("Are you willing to play snack and lader game(y/n)");
			char entry = sc.next().charAt(0);
			if (entry == 'y' || entry == 'Y') {
				while(true) {
				System.out.println("Press 1 to start New game");
				System.out.println("Press 2 to start Quit game");
				int entry1 = sc.nextInt();
				if(entry1==1) {
					Holder head = new Holder(4, 7);
					Holder tail = new Holder(4, 2);
					Holder food = null;
					List<Integer> body = new ArrayList<Integer>();
					body.add(4);
					body.add(6);
					body.add(4);
					body.add(5);
					body.add(4);
					body.add(4);
					body.add(4);
					body.add(3);
					
					Snack snack = new Snack(head, tail,null, body,0,0);
					
					snack=functions.foodGenerater(snack);
					
					functions.display(snack);
					while(true) {
						System.out.println("Press W to click Uparrow");
						System.out.println("Press A to click Leftarrow");
						System.out.println("Press D to click Rightarrow");
						System.out.println("Press S to click Downtarrow");
						System.out.println("Press Q to go for menu");
						char entry2 = sc.next().charAt(0);
						if(entry2 == 'w' || entry2 == 'W') {
							snack=functions.clickUpArrow(snack);
						}
						if (entry2 == 'a' || entry2 == 'A') {
							snack=functions.clickLeftArrow(snack);
						}
						if(entry2 == 'd' || entry2 == 'D') {
							snack=functions.clickRightArrow(snack);
						}
						if(entry2 == 's' || entry2 == 'S') {
							snack=functions.clickDownArrow(snack);
						}
						if(snack.getRef() == 0) {
							System.out.println("GAME OVER");
							break;
						}
						if(entry2 == 5)
							break;
						else {
							System.out.println("select correct option");
						}
					}
				}
				}
			}
		}
	}

}
