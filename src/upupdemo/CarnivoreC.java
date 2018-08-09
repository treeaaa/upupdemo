package upupdemo;

public class CarnivoreC extends Carnivore{		//¦×­¹°Êª«C
	String baseName =test.speciesName[2];
	public CarnivoreC(int id,int animalid) {
		this.id = id;
		this.name = this.baseName+String.valueOf(animalid);
		this.life = test.animalBaseLife+test.carnivoreCLifeAdd;
		this.ageMax =test.animalBaseAgeMax +test.carnivoreCAgeAdd;
		this.power = test.animalPowerBase;
		this.degreeHunger = test.animalDegreeHunger;
	}
}
