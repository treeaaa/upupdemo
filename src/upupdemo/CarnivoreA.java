package upupdemo;

public class CarnivoreA extends Carnivore{	//¦×­¹°Êª«A
	String baseName =test.speciesName[0];
	public CarnivoreA(int id,int animalid) {
		this.id = id;
		this.name = this.baseName+String.valueOf(animalid);
		this.life = test.animalBaseLife+test.carnivoreALifeAdd;
		this.ageMax =test.animalBaseAgeMax +test.carnivoreAAgeAdd;
		this.power = test.animalPowerBase;
		this.degreeHunger = test.animalDegreeHunger;
	}
	
}
