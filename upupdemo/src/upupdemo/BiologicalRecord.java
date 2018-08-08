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
	String[] speciesName = {"�׭�A","�׭�B","�׭�C","��A","��B","��C","����A","����B","����C","���A","���B","���C"};
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
	public void CreateBiological(int species ,int speciesNum) {//��ܥͪ�����,�ƶq  ���ͪ���å[�Jlist
		 switch(species) {
		 case 0:
			 for(int i =0;i<speciesNum;i++) {		//�ƶq
				 listAll.add(new CarnivoreA(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		 case 1:
			 for(int i =0;i<speciesNum;i++) {		//�ƶq
				 listAll.add(new CarnivoreB(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		 case 2:
			 for(int i =0;i<speciesNum;i++) {		//�ƶq
				 listAll.add(new CarnivoreC(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		 case 3:
			 for(int i =0;i<speciesNum;i++) {		//�ƶq
				 listAll.add(new HerbivoreA(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		 case 4:
			 for(int i =0;i<speciesNum;i++) {		//�ƶq
				 listAll.add(new HerbivoreB(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		 case 5:
			 for(int i =0;i<speciesNum;i++) {		//�ƶq
				 listAll.add(new HerbivoreC(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		 case 6:
			 for(int i =0;i<speciesNum;i++) {		//�ƶq
				 listAll.add(new GrassA(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		 case 7:
			 for(int i =0;i<speciesNum;i++) {		//�ƶq
				 listAll.add(new GrassB(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		 case 8:
			 for(int i =0;i<speciesNum;i++) {		//�ƶq
				 listAll.add(new GrassC(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		 case 9:
			 for(int i =0;i<speciesNum;i++) {		//�ƶq
				 listAll.add(new TreeA(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		 case 10:
			 for(int i =0;i<speciesNum;i++) {		//�ƶq
				 listAll.add(new TreeB(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		 case 11:
			 for(int i =0;i<speciesNum;i++) {		//�ƶq
				 listAll.add(new TreeC(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		}
		 
	}
	public void BiologicalMeet() {//�ͪ��۹J
		 for(int i=0;i<listAll.size();i++) {//���M�Ҧ��blistall�̪��ͪ����� �é����۹J
			 //listAll.get(i).
			 if(listAll.get(i).survive) {		//���P�_�Ĥ@�ӥͪ��ͦs =true
				 int anotherBiological =(int)(Math.random()*listAll.size());//���t�@�ӥͪ�
				 if(listAll.get(anotherBiological).survive) {	//�ĤG�ӥͪ��O�_�ͦs
					 while(i==anotherBiological) {
						 anotherBiological =(int)(Math.random()*listAll.size());//�J��P�ۤv���Ʈ�,�q�s��ܹ�H
					 }
					 if(listAll.get(i) instanceof Carnivore) {//A�O�׭�	
						 Carnivore a = (Carnivore)listAll.get(i);
						 if(listAll.get(anotherBiological) instanceof Carnivore) {//B�O�׭�		
							 Carnivore b = (Carnivore)listAll.get(anotherBiological);
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
						 else if (listAll.get(anotherBiological) instanceof Herbivore) {//B�O��
							 Herbivore b = (Herbivore)listAll.get(anotherBiological);
							 a.life =a.life -b.power;
							 b.life =b.life -a.power;
							 a.DeathJudgment();
							 b.DeathJudgment();
							 
							 System.out.println(a.name+"�P"+b.name+"���[,,,"+a.name+"�ͩR�ѤU"+a.life+",,,"+b.name+"�ͩR�ѤU"+b.life);
						 }
						 else if (listAll.get(anotherBiological) instanceof Grass) {//B����
							 Grass b = (Grass)listAll.get(anotherBiological);
						 }
						 else if (listAll.get(anotherBiological) instanceof Tree) {//B�O���
							 Tree b = (Tree)listAll.get(anotherBiological);
							 a.Rest();
							 b.Used();
							 System.out.println(a.name+"�𮧤F,,,�{�b�ͩR��:"+a.life+",,,"+b.name+"�ͩR�ѤU"+b.life);
						 }
					 }
					 else if (listAll.get(i) instanceof Herbivore) {//A�O��
						 Herbivore a = (Herbivore)listAll.get(i);
						 if(listAll.get(anotherBiological) instanceof Carnivore) {//B�O�׭�		
							 Carnivore b = (Carnivore)listAll.get(anotherBiological);
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
						 else if (listAll.get(anotherBiological) instanceof Herbivore) {//B�O��
							 Herbivore b = (Herbivore)listAll.get(anotherBiological);
							 a.life =a.life -b.power;
							 b.life =b.life -a.power;
							 a.DeathJudgment();
							 b.DeathJudgment();
							 System.out.println(a.name+"�P"+b.name+"���[,,,"+a.name+"�ͩR�ѤU"+a.life+",,,"+b.name+"�ͩR�ѤU"+b.life);
						 }
						 else if (listAll.get(anotherBiological) instanceof Grass) {//B����
							 Grass b = (Grass)listAll.get(anotherBiological);
							 a.Eat();
							 b.Used();
							 System.out.println(a.name+"�Y�F"+b.name+",,,�{�b���j�׬�"+a.degreeHunger+",,,"+b.name+"�ѤU"+b.life+"�ͩR");
						 }
						 else if (listAll.get(anotherBiological) instanceof Tree) {//B�O���
							 Tree b = (Tree)listAll.get(anotherBiological);
							 a.Rest();
							 b.Used();
							 System.out.println(a.name+"�𮧤F,,,�{�b�ͩR��:"+a.life+",,,"+b.name+"�ѤU"+b.life+"�ͩR");
						 }
					 }
					 /*
					 else if (listAll.get(i) instanceof Grass) {//A����
						 Grass a = (Grass)listAll.get(i);
						 if(listAll.get(anotherBiological) instanceof Carnivore) {//B�O�׭�		
							 Carnivore b = (Carnivore)listAll.get(anotherBiological);
						 }
						 else if (listAll.get(anotherBiological) instanceof Herbivore) {//B�O��
							 Herbivore b = (Herbivore)listAll.get(anotherBiological);
							 b.Eat();
							 a.Used();
							 System.out.println(b.name+"�Y�F"+a.name+",,,�{�b���j�׬�"+b.degreeHunger+",,,"+a.name+"�ͩR�ѤU"+a.life);
						 }
						 else if (listAll.get(anotherBiological) instanceof Grass) {//B����
							 Grass b = (Grass)listAll.get(anotherBiological);
						 }
						 else if (listAll.get(anotherBiological) instanceof Tree) {//B�O���
							 Tree b = (Tree)listAll.get(anotherBiological);
						 }						 
					 }
					 else if (listAll.get(i) instanceof Tree) {//A�O���
						 Tree a = (Tree)listAll.get(i);
						 if(listAll.get(anotherBiological) instanceof Carnivore) {//B�O�׭�		
							 Carnivore b = (Carnivore)listAll.get(anotherBiological);
							 b.Rest();
							 a.Used();
							 System.out.println(b.name+"�𮧤F,,,�{�b�ͩR��:"+b.life+",,,"+a.name+"�ͩR�ѤU"+a.life);
						 }
						 else if (listAll.get(anotherBiological) instanceof Herbivore) {//B�O��
							 Herbivore b = (Herbivore)listAll.get(anotherBiological);
							 b.Rest();
							 a.Used();
							 System.out.println(b.name+"�𮧤F,,,�{�b�ͩR��:"+b.life+",,,"+a.name+"�ͩR�ѤU"+a.life);
						 }
						 else if (listAll.get(anotherBiological) instanceof Grass) {//B����
							 Grass b = (Grass)listAll.get(anotherBiological);
						 }
						 else if (listAll.get(anotherBiological) instanceof Tree) {//B�O���
							 Tree b = (Tree)listAll.get(anotherBiological);
						 }
					 }
					 */
				 }
			}
		}
	 }
	void GrowUp() {		//����  �ʪ��W�[���j��  �Ӫ���_�ͩR
		for(int i =0;i<listAll.size();i++) {
			if(listAll.get(i) instanceof Animal) {
				Animal a =(Animal)listAll.get(i);
				a.degreeHunger =a.degreeHunger+test.animalDegreeHungerAdd;	//�Ҧ��ʪ����j�״���
				a.DeathJudgment();
			}
			else if (listAll.get(i) instanceof Plant) {
				Plant a =(Plant)listAll.get(i);
				a.Grow();
				a.DeathJudgment();
			}
		}
		System.out.println("----�Ҧ��ʪ��W�[���j��,�Ӫ��^�_�ͩR----");
	}
	void removeDeathBiological() {
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
