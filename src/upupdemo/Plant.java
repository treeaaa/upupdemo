package upupdemo;

public abstract class Plant extends Biological{
	float growSpeed;		//生長速度  基礎+加成		恢復植物生命值
	void Used() {
		this.life =this.life+test.plantUsedLifeAdd;		//被使用之後生命減少
	}
	void Grow() {	//植物生長  恢復生命
		this.life =this.life+this.growSpeed;
	}
	void DeathJudgment() {		//死亡判定
		if(this.life<0) {
			this.survive =false;
		}
	}
}
