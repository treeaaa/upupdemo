package upupdemo;

public class CarnivoreC extends Carnivore{		//肉食動物C
	String baseName =test.speciesName[2];
	public CarnivoreC(int id,int animalid) {
		this.id = id;
		this.name = this.baseName+String.valueOf(animalid);
		this.life = test.animalBaseLife+test.carnivoreCLifeAdd;
		this.ageMax =test.animalBaseAgeMax +test.carnivoreCAgeAdd;
		this.power = test.animalPowerBase;
		this.degreeHunger = test.animalDegreeHunger;
	}
	void Encounter(Carnivore b) {
		this.life = this.life -b.power;
	}
	void Encounter(Herbivore b) {
		this.life = this.life -b.power;	//A生命下降  被B攻擊
	}
	void Encounter(Tree b) {
		Rest();	//休息
	}
}
