package upupdemo;

public abstract class Biological {		//生物抽象類別
	int id;
	String name;
	float age=0;
	float life;
	boolean survive=true;
	void initial() {} ;//初始化
	abstract void Grow(); 	//長大
	abstract void DeathJudgment();
	void AgeAdd() {
		this.age =this.age++;
	}
	abstract void Encounter(Biological b);//物種遭遇
		
}
