package upupdemo;

public abstract class Animal extends Biological{		//動物抽象類別 繼承 biological
	float power;		//力量
	float degreeHunger;		//飢餓度
	float ageMax;		//最大年齡  只有動物有
	void Rest() {
		this.life = this.life+test.animalRestLifeAdd;		//休息恢復生命
	}
	void Fight(float enemyPower) {
		this.life = this.life - enemyPower;		//生命損失=生命-敵人power
	}
	void Eat() {		//吃東西
		this.degreeHunger = this.degreeHunger+test.animalEatDegreeHungerAdd;
	}		
	void Grow() {		//成長
		this.age = this.age+ test.animalGrowSpeed;
	}
	void DeathJudgment() {		//死亡判定
		if(this.life<=0||this.degreeHunger>test.animalDegreeHungerMax||this.age>this.ageMax) {//生命<0 ,飢餓度>最大上限,年紀超過上限
			this.survive =false;
		}
	}		
}
