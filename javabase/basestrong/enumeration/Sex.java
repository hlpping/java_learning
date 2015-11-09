package basestrong.enumeration;

public enum Sex {
	MALE("男"){
		public String getSex(){
			return this.name();
		}
	},
	FEMALE("女"){
		public String getSex(){
			return this.name();
		}
	};
	
	private String name;
	Sex(String na){
		name=na;
	}
	public String toString(){
		return "性别:"+name;
	}
	public abstract String getSex();
}
