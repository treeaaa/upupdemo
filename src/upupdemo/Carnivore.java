package upupdemo;

public abstract class Carnivore extends Animal{		//�׭��ʪ�
	void Encounter(Carnivore b) {
		this.life = this.life -b.power;
	}
	void Encounter(Herbivore b) {
		this.life = this.life -b.power;	//A�ͩR�U��  �QB����
	}
	void Encounter(Tree b) {
		Rest();	//��
	}
	void Encounter(Biological b) {
		
	}
}
