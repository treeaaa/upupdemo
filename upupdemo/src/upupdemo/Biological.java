package upupdemo;

public abstract class Biological {		//�ͪ���H���O
	int id;
	String name;
	float age=0;
	float life;
	boolean survive=true;
	void initial() {}	//��l��
	void grow() {}	//���j
	void DeathJudgment() {}
}
