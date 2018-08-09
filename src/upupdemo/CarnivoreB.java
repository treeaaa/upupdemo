package upupdemo;

public class CarnivoreB extends Carnivore{		//¦×­¹°Êª«B
	String baseName =test.speciesName[1];
	public CarnivoreB(int id,int animalid) {
		this.id = id;
		this.name = this.baseName+String.valueOf(animalid);
		this.life = test.animalBaseLife+test.carnivoreBLifeAdd;
		this.ageMax =test.animalBaseAgeMax +test.carnivoreBAgeAdd;
		this.power = test.animalPowerBase;
		this.degreeHunger = test.animalDegreeHunger;
	}
}
