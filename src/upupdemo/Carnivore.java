package upupdemo;

public abstract class Carnivore extends Animal{		//肉食動物
	void Encounter(Carnivore b) {
		this.life = this.life -b.power;
	}
	void Encounter(Herbivore b) {
		this.life = this.life -b.power;	//A生命下降  被B攻擊
	}
	void Encounter(Tree b) {
		Rest();	//休息
	}
	void Encounter(Biological b) {
		
	}
}
