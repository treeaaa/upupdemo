package upupdemo;

public abstract class Biological {		//�ͪ���H���O
	int id;
	String name;
	float age=0;
	float life;
	boolean survive=true;
	void initial() {} ;//��l��
	abstract void Grow(); 	//���j
	abstract void DeathJudgment();
	void AgeAdd() {
		this.age =this.age++;
	}
	void Encounter(Animal anobio) {//���ؾD�J
		this.life =this.life - anobio.power;
	}
}
