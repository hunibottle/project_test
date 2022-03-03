package sec05.ex01;

public class Member {

	private String name;
	
	private int age;
	
	public static Builder builder() {
		return new Builder();
	}
 	
	static class Builder {
		
		private Member member;
		
		public Builder() {
			member = new Member();
		}
		
		public Builder name(String name) {
			member.name = name;
			return this;
		}
		
		public Builder age(int age) {
			member.age = age;
			return this;
		}
		
		public Member build() {
			return member;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
