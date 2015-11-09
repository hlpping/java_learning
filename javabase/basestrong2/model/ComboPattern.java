package basestrong2.model;
/**
 *	组合设计模式
 */
public class ComboPattern {
	public static void main(String[] args) {
		new Person(new Card()).shopping();
		
		new Student(new CreditCard()).shopping();
	}
}
class Person{
	private Card card;
	public Person(Card card){
		this.card=card;
	}
	public void shopping(){
		card.spend();
		System.out.println("买了一台IPHONE5");
	}
	
	public Card getCard(){
		return card;	
	}	
	public void setCard(Card card){
		this.card = card;
	}
}
class Student extends Person{

	public Student(Card card) {
		super(card);
	}
}
class Card{
	public void spend(){
		System.out.println("刷卡消费, 一不小心花了100元.");	
	}	
}
class CreditCard extends Card{
	public void spend(){
		System.out.println("信用卡刷卡消费, 先欠着.");	
	}
}
