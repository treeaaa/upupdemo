package upupdemo;

public class CarnivoreA extends Carnivore{	//�׭��ʪ�A
	String baseName ="�׭�A";
	public CarnivoreA(int id,int animalid) {
		this.id = id;
		this.name = this.baseName+String.valueOf(animalid);
		this.life = test.animalBaseLife+test.carnivoreALifeAdd;
		this.ageMax =test.animalBaseAgeMax +test.carnivoreAAgeAdd;
		this.power = test.animalPowerBase;
		this.degreeHunger = test.animalDegreeHunger;
	}
	
}
