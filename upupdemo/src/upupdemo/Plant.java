package upupdemo;

public abstract class Plant extends Biological{
	float growSpeed;		//�ͪ��t��  ��¦+�[��		��_�Ӫ��ͩR��
	void Used() {
		this.life =this.life+test.plantUsedLifeAdd;		//�Q�ϥΤ���ͩR���
	}
	void Grow() {	//�Ӫ��ͪ�  ��_�ͩR
		this.life =this.life+this.growSpeed;
	}
	void DeathJudgment() {		//���`�P�w
		if(this.life<0) {
			this.survive =false;
		}
	}
}
