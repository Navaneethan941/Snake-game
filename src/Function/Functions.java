package Function;

import java.util.List;
import java.util.Random;

import Pojo.Holder;
import Pojo.Snack;

public class Functions {
	
	public Snack foodGenerater(Snack snack) {
		
		Holder head = snack.getHead();
		Holder tail = snack.getTail();
		List<Integer> body = snack.getBody();
		Random random = new Random();
		while(true) {
		int x = random.nextInt(10);
		int y = random.nextInt(10);
		Holder food = new Holder(x, y);
		//System.out.println("in loop ");
		snack.setFood(food);
		snack = checkTechingBodyForFood(snack);
		if(snack.getRef()==1)
			break;
		}
		//System.out.println(snack);
		
		
		return snack;
		
	}

	public void display(Snack snack) {
		
		
		Holder head = snack.getHead();
		Holder tail = snack.getTail();
		Holder food = snack.getFood();
		List<Integer> body = snack.getBody();
		int score = snack.getScore();
		
		
		char[][] matrex = new char[10][10];
		System.out.println("# # # score:"+score+" # # #");
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				matrex[i][j]='*';
				for(int k = 0 ;k< body.size();k+=2) {
					if(body.get(k)==i && body.get(k+1)==j )
						matrex[i][j]='-';
				}
				
				if(i==head.x && j==head.y) {
					matrex[i][j]='H';
				}
				
				if(i==tail.getX() && j==tail.getY()) {
					matrex[i][j]='T';
				}
				
				if(i==food.x && j==food.y) {
					matrex[i][j]='$';
				}
				
			}
		}
		
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++)
				System.out.print(matrex[i][j]+" ");
			System.out.println();
		}
		System.out.println();
		System.out.println("@ @ @ @ @ @ @ @ @ @ @ @ @ @ @ @ @ @ @ @ @ @ @ @ @ @ @ @ @ @ @");
		System.out.println();
	}
	
	
	public Snack moveBodyForFood(Snack snack, Holder postHead) {
		Holder head = snack.getHead();
		Holder tail = snack.getTail();
		Holder food = snack.getFood();
		List<Integer> body = snack.getBody();
		int ref = snack.getRef();
		snack.setScore(snack.getScore()+1);
		
		//System.out.println("score "+score);
	
		body.add(0,postHead.y);
		body.add(0,postHead.x);
	
		//System.out.println("score "+ score);
		
		return new Snack(head, tail,food, body,ref,snack.getScore());
	
}


	public Snack moveBodyChangetail(Snack snack) {
		Holder head = snack.getHead();
		Holder tail = snack.getTail();
		Holder food = snack.getFood();
		List<Integer> body = snack.getBody();
		int ref = snack.getRef();
		int score = snack.getScore();
	
	
		body.add(0,head.y);
		body.add(0,head.x);
	
		tail.y = body.get(body.size()-1);
		body.remove(body.size()-1);
	
		tail.x = body.get(body.size()-1);
		body.remove(body.size()-1);
	
		return new Snack(head, tail,food, body,ref,score);
	
}


	public Snack clickDownArrow(Snack snack) {
		
		Holder head = snack.getHead();
		Holder newHead = new Holder(head.getX(), head.getY());
		Holder tail = snack.getTail();
		Holder food = snack.getFood();
		List<Integer> body = snack.getBody();
		int ref = snack.getRef();
		
		//System.out.println("snack geting in before update "+ snack);
		if(newHead.x<9) {
			newHead.x+=1;
		}
		else {
			newHead.x=0;
		}
		return decisionMaking(snack, newHead);
	}
	
	
public Snack clickUpArrow(Snack snack) {
	
		Holder head = snack.getHead();
		Holder newHead = new Holder(head.getX(), head.getY());
		Holder tail = snack.getTail();
		Holder food = snack.getFood();
		List<Integer> body = snack.getBody();
		int ref = snack.getRef();
		
		//System.out.println("snack geting in before update "+ snack);
		
		if(newHead.x>0) {
			newHead.x-=1;
		}
		else {
			newHead.x=9;
		}
		return decisionMaking(snack, newHead);
	}

public Snack clickRightArrow(Snack snack) {
	
	Holder head = snack.getHead();
	Holder newHead = new Holder(head.getX(), head.getY());
	Holder tail = snack.getTail();
	Holder food = snack.getFood();
	List<Integer> body = snack.getBody();
	int ref = snack.getRef();

	//System.out.println("snack geting in before update "+ snack);

	if(newHead.y<9) {
		newHead.y+=1;
	}
	else {
		newHead.y=0;
	}
	return decisionMaking(snack, newHead);
}

public Snack clickLeftArrow(Snack snack) {

	Holder head = snack.getHead();
	Holder newHead = new Holder(head.getX(), head.getY());
	Holder tail = snack.getTail();
	Holder food = snack.getFood();
	List<Integer> body = snack.getBody();
	int ref = snack.getRef();
	
	//System.out.println("snack geting in before update "+ snack);
	
	if(newHead.y>0) {
		newHead.y-=1;
	}
	else {
		newHead.y=9;
	}
	return decisionMaking(snack, newHead);
}

public Snack checkTechingBody(Snack snack) {
	
	Holder head = snack.getHead();
	Holder tail = snack.getTail();
	Holder food = snack.getFood();
	List<Integer> body = snack.getBody();
	
	//System.out.println("head"+head.x+head.y +"tail"+tail.x+tail.y);
	if(head.getX()==tail.getX() && head.getY()==tail.getY() ) {
		snack.setRef(0);
		return snack;
	}
	
	for(int k = 0 ;k< body.size();k+=2) {
		//System.out.println("head"+head.x+head.y +"body"+body.get(k)+body.get(k+1));
		if(body.get(k)==head.getX() && body.get(k+1)==head.getY() ) {
			snack.setRef(0);
			return snack;
		}
	}
	//System.out.println("snack before display "+snack);
	display(snack);
	snack.setRef(1);
	return snack;
}

public Snack checkTechingBodyForFood(Snack snack) {
	
	Holder head = snack.getHead();
	Holder tail = snack.getTail();
	Holder food = snack.getFood();
	List<Integer> body = snack.getBody();
	//System.out.println("food"+food.x+food.y +"tail"+tail.x+tail.y);
	if(food.getX()==tail.getX() && food.getY()==tail.getY() ) {
		snack.setRef(0);
		return snack;
	}
	//System.out.println("food"+food.x+food.y +"head"+head.x+head.y);
	if(food.getX()==head.getX() && food.getY()==head.getY() ) {
		snack.setRef(0);
		return snack;
	}
	
	for(int k = 0 ;k< body.size();k+=2) {
		//System.out.println("food"+head.x+head.y +"body"+body.get(k)+body.get(k+1));
		if(body.get(k)==food.getX() && body.get(k+1)==food.getY() ) {
			snack.setRef(0);
			return snack;
		}
	}
	snack.setRef(1);
	return snack;
}


public Snack checkfood(Snack snack) {
	Holder head = snack.getHead();
	Holder tail = snack.getTail();
	Holder food = snack.getFood();
	List<Integer> body = snack.getBody();
	//System.out.println("**checking for head and food**");
	//System.out.println("food"+food.x+food.y +"head"+head.x+head.y);
	if(head.getX()==food.getX() && head.getY()==food.getY() ) {
		//System.out.println("1");
		snack = foodGenerater(snack);
		snack.setRef(1);
		return snack;
	}
	snack.setRef(0);
	//System.out.println("0");
	return snack;
	
}

public Snack decisionMaking(Snack snack, Holder newHead) {
	Holder head = snack.getHead();
	Holder tail = snack.getTail();
	Holder food = snack.getFood();
	List<Integer> body = snack.getBody();
	int ref = snack.getRef();
	int score = snack.getScore();
	//System.out.println("snack geting in after update "+ snack);
	Snack snackTemp = checkfood(new Snack(newHead, tail,food, body,ref,score));
	if(snackTemp.getRef()==0) {
		//System.out.println("moveBodyChangetail");
		//System.out.println("before"+snack);
		snack= moveBodyChangetail(snack);
		//System.out.println("after"+snack);
	}
	else {
		//System.out.println("***food eat ***");
		//System.out.println("moveBodyForFood");
		//System.out.println("before"+snackTemp);
		snackTemp = moveBodyForFood(snackTemp, head);
		//System.out.println("before"+snackTemp);
		//System.out.println("new head " +newHead);
		snackTemp.setHead(newHead);
		display(snackTemp);
		return snackTemp;
	}
	snack.setHead(newHead);
	return checkTechingBody( new Snack(newHead, tail,food, body,ref,score));
	
}


}
