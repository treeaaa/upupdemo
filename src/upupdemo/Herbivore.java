package upupdemo;

public abstract class Herbivore extends Animal{		//草食動物
	void Encounter(Carnivore b) {
		this.life = this.life -b.power;
	}
	void Encounter(Herbivore b) {
		this.life = this.life -b.power;	//A生命下降  被B攻擊
	}
	void Encounter(Grass b) {
		Eat();
	}
	void Encounter(Tree b) {
		Rest();	//休息
	}
	void Encounter(Biological b) {
		
	}
}
