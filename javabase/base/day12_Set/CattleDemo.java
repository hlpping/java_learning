package base.day12_Set;

import java.util.ArrayList;

class CattleDemo {

	public static void main(String[] args) {
		long start = System.currentTimeMillis(); // 从1970年1月1日0时, 到现在经过了多少毫秒.

		Cattle.farm.add(new Cattle());
		Cattle.farm.add(new Cattle());

		for (int i = 0; i < 50; i++) {
			ArrayList<Cattle> temp = new ArrayList<Cattle>();
			temp.addAll(Cattle.farm);
			for (int j = 0; j < temp.size(); j++) { // 让farm中所有牛调用growUp()方法
				if (temp.get(j) != null)
					temp.get(j).growUp();
			}
		}

		System.out.println("一共有" + Cattle.farm.size() + "头牛");

		long end = System.currentTimeMillis(); // 从1970年1月1日0时, 到现在经过了多少毫秒.

		System.out.println(end - start);
	}
}

class Cattle {
	private int age;
	public static ArrayList<Cattle> farm = new ArrayList<Cattle>();

	public void growUp() {
		age++;
		if (age % 3 == 0)
			farm.add(new Cattle());
		if (age == 10)
			farm.remove(this);
	}
}