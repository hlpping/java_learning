package base.day05_oop_static;

public class ShoppingDemo {
	public static void main(String[] args) {
		Person p = new Person("仲衡");
		Market m = new Market("家乐福", new Product[]{new Product("洗衣机")
													 ,new Product("电视机")
													 ,new Product("榨汁机")
													 ,new Product("豆浆机")
													 ,new Product("吹风机")});
		
		Product result =p.shopping(m, "豆浆机") ;
		if(result!=null){
			System.out.println("Thanks");
		}else
			System.out.println("白跑了一趟");
	}
}

class Product {
	private String name;

	public Product(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

class Market {
	private String name; // 成员变量
	private Product[] productArr;

	Market(String name, Product[] productArr) {
		this.name = name; // 构造方法
		this.productArr = productArr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Product[] getProductArr() {
		return productArr;
	}

	public void setProductArr(Product[] productArr) {
		this.productArr = productArr;
	}

	/*
	 * 超市的卖货方法, 指定卖什么东西, 在货架中查找, 有就卖.
	 */
	public Product sell(String name) {
		for (int i = 0; i < productArr.length; i++) {
			if (productArr[i].getName() == name) {
				return productArr[i];
			}
		}
		return null;
	}
}

class Person {
	private String name;
	Person(){
		
	}
	
	Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/*
	 * Person的购物方法, 指定去哪个Market, 指定买什么, 返回买到的东西.
	 */
	public Product shopping(Market m ,String name){
		return m.sell(name);
	}
}