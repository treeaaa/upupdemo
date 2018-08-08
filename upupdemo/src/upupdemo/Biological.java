package upupdemo;

public abstract class Biological {		//生物抽象類別
	int id;
	String name;
	float age=0;
	float life;
	boolean survive=true;
	void initial() {}	//初始化
	void grow() {}	//長大
	void DeathJudgment() {}
}
