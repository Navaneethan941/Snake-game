package Pojo;

import java.util.ArrayList;
import java.util.List;

public class Snack {
	private Holder head;
	private Holder tail;
	private Holder food;
	private List<Integer> body;
	private int ref;
	private int score;
	
	public Snack(Holder head, Holder tail, Holder food, List<Integer> body, int ref, int score) {
		super();
		this.head = head;
		this.tail = tail;
		this.food = food;
		this.body = body;
		this.ref = ref;
		this.score = score;
	}

	public Holder getHead() {
		return head;
	}

	public void setHead(Holder head) {
		this.head = head;
	}

	public Holder getTail() {
		return tail;
	}

	public void setTail(Holder tail) {
		this.tail = tail;
	}
	
	

	public Holder getFood() {
		return food;
	}

	public void setFood(Holder food) {
		this.food = food;
	}

	public List getBody() {
		return body;
	}

	public void setBody(List body) {
		this.body = body;
	}
	
	

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Snack [head=" + head + ", tail=" + tail + ", food=" + food + ", body=" + body + ", ref=" + ref
				+ ", score=" + score + "]";
	}

}
