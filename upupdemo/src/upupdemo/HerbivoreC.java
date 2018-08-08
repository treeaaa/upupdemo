package upupdemo;

public class HerbivoreC extends Herbivore{
	String baseName ="¯ó­¹C";
	public HerbivoreC(int id,int animalid) {
		this.id = id;
		this.name = this.baseName+String.valueOf(animalid);
		this.life = test.animalBaseLife+test.herbivoreCLifeAdd;
		this.ageMax =test.animalBaseAgeMax +test.herbivoreCAgeAdd;
		this.power = test.animalPowerBase;
		this.degreeHunger = test.animalDegreeHunger;
	}
}
