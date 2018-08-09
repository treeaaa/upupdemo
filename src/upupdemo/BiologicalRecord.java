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
	public void BiologicalMeet() {
		for(int i =0;i<listAll.size();i++) {
			Biological bio = listAll.get(i);
			if(bio.survive&&bio instanceof Animal) {
				int anotherBioIndex;
				Biological anotherBio = null;
				do {
					anotherBioIndex = (int)(Math.random()*listAll.size());
					anotherBio = listAll.get( anotherBioIndex);
				}while(i==anotherBioIndex||!anotherBio.survive);//i�Panotherbioindex ������  !ano.survive�����즺�� 
				Biological bioA =null,bioB =null;
				int actionJudgeA=0,actionJudgeB=0;
				///�׭�2	��3	����5	���7
				///�z�L��ӽ�Ƭۦ� �o��ߤ@�ѵ�
				if( listAll.get(i) instanceof Carnivore) {
					bioA = (Carnivore)listAll.get(i);//A�O�׭��ʪ�
					actionJudgeA=2;
				}
				else if (listAll.get(i) instanceof Herbivore) {
					bioA = (Herbivore)listAll.get(i);
					actionJudgeA=3;
				}
				else if (listAll.get(i) instanceof Grass) {
					bioA = (Grass)listAll.get(i);
					actionJudgeA=5;
				}
				else if (listAll.get(i) instanceof Tree) {
					bioA = (Tree)listAll.get(i);
					actionJudgeA=7;
				}
				if(listAll.get(anotherBioIndex) instanceof Carnivore) {
					bioB = (Carnivore)listAll.get(anotherBioIndex);
					actionJudgeB=2;
				}
				else if (listAll.get(anotherBioIndex) instanceof Herbivore) {
					bioB = (Herbivore)listAll.get(anotherBioIndex);
					actionJudgeB=3;
				}
				else if (listAll.get(anotherBioIndex) instanceof Grass) {
					bioB = (Grass)listAll.get(anotherBioIndex);
					actionJudgeB=5;
				}
				else if (listAll.get(anotherBioIndex) instanceof Tree) {
					bioB = (Tree)listAll.get(anotherBioIndex);
					actionJudgeB=7;
				} 
				///�׭�2	��3	����5	���7

				bioA.Encounter(bioB);
				bioB.Encounter(bioA);
				
				switch(actionJudgeA*actionJudgeB) {
					case 4://2*2 2*3 3*3 ���O���[
					case 6:
					case 9:
						Animal a =(Animal)bioA;
						Animal b =(Animal)bioB;
						System.out.println(bioA.name+"�P"+bioB.name+"���[,,,"+bioA.name+"�ͩR�ѤU"+bioA.life+",,,"+bioB.name+"�ͩR�ѤU"+bioB.life);
						if(bioA.life>0&&bioB.life<=0) {		//a�s��b���`
							 System.out.println(bioA.name+"�Y�F"+bioB.name);
							 a.Eat();
						 }
						 else if(bioA.life<=0&&bioB.life>0) {//a���`b�s��
							 System.out.println(bioB.name+"�Y�F"+bioA.name);
							 b.Eat();
						 }
						break;	
					case 15: // 5*3 �O�Y��
						Animal aa =(Animal)bioA;
						System.out.println(bioA.name+"�Y�F"+bioB.name+",,,�{�b���j�׬�"+aa.degreeHunger+",,,"+bioB.name+"�ѤU"+bioB.life+"�ͩR");
						break;	
					case 14:	//7*2 7*3 ���O��
					case 21:
						System.out.println(bioA.name+"�𮧤F,,,�{�b�ͩR��:"+bioA.life+",,,"+bioB.name+"�ͩR�ѤU"+bioB.life);
						break;
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
