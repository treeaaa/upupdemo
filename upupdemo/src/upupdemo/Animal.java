package upupdemo;
import java.lang.Math;
public abstract class Animal extends Biological{		//�ʪ���H���O �~�� biological
	float power;		//�O�q
	float powerAdd;
	float degreeHunger;		//���j��
	float ageMax;		//�̤j�~��  �u���ʪ���
	
	void Rest() {
		this.life = this.life+test.animalRestLifeAdd;		//�𮧫�_�ͩR
	}
	void Fight(float enemyPower) {
		this.life = this.life - enemyPower;		//�ͩR�l��=�ͩR-�ĤHpower
	}
	void Eat() {		//�Y�F��
		this.degreeHunger = this.degreeHunger+test.animalEatDegreeHungerAdd;
	}		
	void Grow() {		//����
		this.age = this.age+ test.animalGrowSpeed;
	}
	void DeathJudgment() {		//���`�P�w
		if(this.life<=0||this.degreeHunger>test.animalDegreeHungerMax||this.age>this.ageMax) {//�ͩR<0 ,���j��>�̤j�W��,�~���W�L�W��
			this.survive =false;
		}
	}
	void ResetPower() {		//���s�]�w�O�q  �̷Ӧ~��
		float a= 180/ageMax;
		a=a*age;
		power =(float)(test.animalPowerBase + test.animalPowerAddK*Math.sin((age*Math.PI)/ageMax));
		//�Ʊ�agemax�O�@��180��   age*180/agemax��������  age==agemax �N�O180  sin180=0  ����*math.pi/180�ন���׵�sin��
	}
}
