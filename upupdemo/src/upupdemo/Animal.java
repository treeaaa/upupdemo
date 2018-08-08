package upupdemo;
import java.lang.Math;
public abstract class Animal extends Biological{		//動物抽象類別 繼承 biological
	float power;		//力量
	float powerAdd;
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
	void ResetPower() {		//重新設定力量  依照年紀
		float a= 180/ageMax;
		a=a*age;
		power =(float)(test.animalPowerBase + test.animalPowerAddK*Math.sin((age*Math.PI)/ageMax));
		//希望agemax是一個180度   age*180/agemax成為角度  age==agemax 就是180  sin180=0  角度*math.pi/180轉成弧度給sin用
	}
}
