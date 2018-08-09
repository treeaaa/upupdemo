package upupdemo;

public class HerbivoreA extends Herbivore{
	String baseName =test.speciesName[3];
	public HerbivoreA(int id,int animalid) {
		this.id = id;
		this.name = this.baseName+String.valueOf(animalid);
		this.life = test.animalBaseLife+test.herbivoreALifeAdd;
		this.ageMax =test.animalBaseAgeMax +test.herbivoreAAgeAdd;
		this.power = test.animalPowerBase;
		this.degreeHunger = test.animalDegreeHunger;
	}
}
