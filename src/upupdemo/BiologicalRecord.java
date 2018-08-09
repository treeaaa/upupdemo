package upupdemo;
import java.util.List;
import java.util.ArrayList;
import java.lang.*;
public class BiologicalRecord {
	int id=0;		//�q0�}�l++  �R�W��
	int speciesRandom;	//�����H�� 0~11
	int speciesNumRandom;	//�ƶq�H�� 1~10
	int day=0;
	List<Biological> listAll = new ArrayList(); //�ΨӰO���w���ͪ���  �̭����ڲ��ͪ��ͪ�����
	List<Integer> abc = new ArrayList();
	int[] speciesNum = new int[12]; //�������`�ӧO���ͦh�֭� 0~2 �׭�ABC 3~5 ��ABC 6~8 �� 9~11 ��
	public void Initial() {
		for(int i =0;i<speciesNum.length;i++) {//��l�� ��arraynum�̭����]��0
			this.speciesNum[i] =0; 	
		}	
	}
	public void getSpeciesRandom() {	//�����H�� 0~11
		int a =(int)(Math.random()*12);
		this.speciesRandom= a;
	}
	public void getSpeciesNumRandom() {		//�ƶq�H�� 1~10
		int a =(int)(Math.random()*10+1);
		this.speciesNumRandom= a;
	}
	public void CreateBiological(int species ,int speciesNumber) {//��ܥͪ�����,�ƶq  ���ͪ���å[�Jlist
		 switch(species) {
		 case 0:
			 for(int i =0;i<speciesNumber;i++) {		//�ƶq
				 listAll.add(new CarnivoreA(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		 case 1:
			 for(int i =0;i<speciesNumber;i++) {		//�ƶq
				 listAll.add(new CarnivoreB(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		 case 2:
			 for(int i =0;i<speciesNumber;i++) {		//�ƶq
				 listAll.add(new CarnivoreC(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		 case 3:
			 for(int i =0;i<speciesNumber;i++) {		//�ƶq
				 listAll.add(new HerbivoreA(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		 case 4:
			 for(int i =0;i<speciesNumber;i++) {		//�ƶq
				 listAll.add(new HerbivoreB(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		 case 5:
			 for(int i =0;i<speciesNumber;i++) {		//�ƶq
				 listAll.add(new HerbivoreC(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		 case 6:
			 for(int i =0;i<speciesNumber;i++) {		//�ƶq
				 listAll.add(new GrassA(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		 case 7:
			 for(int i =0;i<speciesNumber;i++) {		//�ƶq
				 listAll.add(new GrassB(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		 case 8:
			 for(int i =0;i<speciesNumber;i++) {		//�ƶq
				 listAll.add(new GrassC(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		 case 9:
			 for(int i =0;i<speciesNumber;i++) {		//�ƶq
				 listAll.add(new TreeA(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		 case 10:
			 for(int i =0;i<speciesNumber;i++) {		//�ƶq
				 listAll.add(new TreeB(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		 case 11:
			 for(int i =0;i<speciesNumber;i++) {		//�ƶq
				 listAll.add(new TreeC(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		}
		 
	}
	public void BiologicalMeett() {
		for(int i =0;i<listAll.size();i++) {
			Biological bio = listAll.get(i);
			if(bio.survive) {
				int anotherBioIndex;
				Biological anotherBio = null;
				do {
					anotherBioIndex = (int)(Math.random()*listAll.size());
					anotherBio = listAll.get( anotherBioIndex);
				}while(i==anotherBioIndex||!anotherBio.survive);//i�Panotherbioindex ������  !ano.survive�����즺�� 
				if(listAll.get(i) instanceof Carnivore) {//A�O�׭�	
					 Carnivore a = (Carnivore)listAll.get(i);
					 if(listAll.get(anotherBioIndex) instanceof Carnivore) {//B�O�׭�		
						 Carnivore b = (Carnivore)listAll.get(anotherBioIndex);
						 a.life =a.life -b.power;
						 b.life =b.life -a.power;
						 a.DeathJudgment();
						 b.DeathJudgment();
						 System.out.println(a.name+"�P"+b.name+"���[,,,"+a.name+"�ͩR�ѤU"+a.life+",,,"+b.name+"�ͩR�ѤU"+b.life);
						 if(a.life>0&&b.life<=0) {		//a�s��b���`
							 System.out.println(a.name+"�Y�F"+b.name);
							 a.Eat();
						 }
						 else if(a.life<=0&&b.life>0) {//a���`b�s��
							 System.out.println(b.name+"�Y�F"+a.name);
							 b.Eat();
						 }
						 
					 }
					 else if (listAll.get(anotherBioIndex) instanceof Herbivore) {//B�O��
						 Herbivore b = (Herbivore)listAll.get(anotherBioIndex);
						 a.life =a.life -b.power;
						 b.life =b.life -a.power;
						 a.DeathJudgment();
						 b.DeathJudgment();
						 
						 System.out.println(a.name+"�P"+b.name+"���[,,,"+a.name+"�ͩR�ѤU"+a.life+",,,"+b.name+"�ͩR�ѤU"+b.life);
					 }
					 else if (listAll.get(anotherBioIndex) instanceof Grass) {//B����
						 Grass b = (Grass)listAll.get(anotherBioIndex);
					 }
					 else if (listAll.get(anotherBioIndex) instanceof Tree) {//B�O���
						 Tree b = (Tree)listAll.get(anotherBioIndex);
						 a.Rest();
						 b.Used();
						 System.out.println(a.name+"�𮧤F,,,�{�b�ͩR��:"+a.life+",,,"+b.name+"�ͩR�ѤU"+b.life);
					 }
				 }
				 else if (listAll.get(i) instanceof Herbivore) {//A�O��
					 Herbivore a = (Herbivore)listAll.get(i);
					 if(listAll.get(anotherBioIndex) instanceof Carnivore) {//B�O�׭�		
						 Carnivore b = (Carnivore)listAll.get(anotherBioIndex);
						 a.life =a.life -b.power;
						 b.life =b.life -a.power;
						 a.DeathJudgment();
						 b.DeathJudgment();
						 System.out.println(a.name+"�P"+b.name+"���[,,,"+a.name+"�ͩR�ѤU"+a.life+",,,"+b.name+"�ͩR�ѤU"+b.life);
						 if(a.life<=0&&b.life>0) {//a���`b�s��
							 System.out.println(b.name+"�Y�F"+a.name);
							 b.Eat();
						 }
					 }
					 else if (listAll.get(anotherBioIndex) instanceof Herbivore) {//B�O��
						 Herbivore b = (Herbivore)listAll.get(anotherBioIndex);
						 a.life =a.life -b.power;
						 b.life =b.life -a.power;
						 a.DeathJudgment();
						 b.DeathJudgment();
						 System.out.println(a.name+"�P"+b.name+"���[,,,"+a.name+"�ͩR�ѤU"+a.life+",,,"+b.name+"�ͩR�ѤU"+b.life);
					 }
					 else if (listAll.get(anotherBioIndex) instanceof Grass) {//B����
						 Grass b = (Grass)listAll.get(anotherBioIndex);
						 a.Eat();
						 b.Used();
						 System.out.println(a.name+"�Y�F"+b.name+",,,�{�b���j�׬�"+a.degreeHunger+",,,"+b.name+"�ѤU"+b.life+"�ͩR");
					 }
					 else if (listAll.get(anotherBioIndex) instanceof Tree) {//B�O���
						 Tree b = (Tree)listAll.get(anotherBioIndex);
						 a.Rest();
						 b.Used();
						 System.out.println(a.name+"�𮧤F,,,�{�b�ͩR��:"+a.life+",,,"+b.name+"�ѤU"+b.life+"�ͩR");
					 }
				 }
			}
		}
	}
	void GrowUp() {		//����  �ʪ��W�[���j��  �Ӫ���_�ͩR
		for(int i =0;i<listAll.size();i++) {
			if(listAll.get(i) instanceof Animal) {
				Animal a =(Animal)listAll.get(i);
				a.DegreeHungerAdd();	//�Ҧ��ʪ����j�״��� �~�ּW�[
				a.AgeAdd();
				a.ResetPower();//���s�]�w�O�q  �̷Ӧ~��
				a.DeathJudgment();
			}
			else if (listAll.get(i) instanceof Plant) {
				Plant a =(Plant)listAll.get(i);
				a.AgeAdd();
				a.Grow();
				a.DeathJudgment();
			}
		}
		System.out.println("----�Ҧ��ʪ��W�[���j��,�Ӫ��^�_�ͩR----");
	}
	void removeDeathBiological() {		//���������ͪ�
		boolean a;
		for(int i =0;i<listAll.size();i++) {
			a= listAll.get(i).survive;
			if(!a) {//a=true �s��  a=false=���`
				System.out.println(listAll.get(i).name+"���`,���X�C��");
				listAll.remove(i);
				i--;
			}
		}
	}
	
}
