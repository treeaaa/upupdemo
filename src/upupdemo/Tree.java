package upupdemo;

public abstract class Tree extends Plant{
	void Encounter(Animal b) {		//動物遇到樹都可以休息
		Used();   //被吃掉了	
	}
	void grow() {
		this.age = this.age +0f;
	}
	void Encounter(Biological b) {
		
	}
}
