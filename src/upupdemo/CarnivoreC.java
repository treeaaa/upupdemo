package upupdemo;

public class CarnivoreC extends Carnivore{		//�׭��ʪ�C
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
		this.life = this.life -b.power;	//A�ͩR�U��  �QB����
	}
	void Encounter(Tree b) {
		Rest();	//��
	}
}
