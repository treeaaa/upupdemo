package upupdemo;

public class HerbivoreB extends Herbivore{
	String baseName ="��B";
	public HerbivoreB(int id,int animalid) {
		this.id = id;
		this.name = this.baseName+String.valueOf(animalid);
		this.life = test.animalBaseLife+test.herbivoreBLifeAdd;
		this.ageMax =test.animalBaseAgeMax +test.herbivoreBAgeAdd;
		this.power = test.animalPowerBase;
		this.degreeHunger = test.animalDegreeHunger;
	}
}
