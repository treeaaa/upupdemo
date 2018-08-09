package upupdemo;
import java.util.List;
import java.util.ArrayList;
import java.lang.*;
public class BiologicalRecord {
	int id=0;		//從0開始++  命名用
	int speciesRandom;	//種類隨機 0~11
	int speciesNumRandom;	//數量隨機 1~10
	int day=0;
	List<Biological> listAll = new ArrayList(); //用來記錄已產生物種  裡面放實際產生的生物物件
	List<Integer> abc = new ArrayList();
	int[] speciesNum = new int[12]; //紀錄物總個別產生多少個 0~2 肉食ABC 3~5 草食ABC 6~8 草 9~11 樹
	public void Initial() {
		for(int i =0;i<speciesNum.length;i++) {//初始化 把arraynum裡面都設為0
			this.speciesNum[i] =0; 	
		}	
	}
	public void getSpeciesRandom() {	//種類隨機 0~11
		int a =(int)(Math.random()*12);
		this.speciesRandom= a;
	}
	public void getSpeciesNumRandom() {		//數量隨機 1~10
		int a =(int)(Math.random()*10+1);
		this.speciesNumRandom= a;
	}
	public void CreateBiological(int species ,int speciesNumber) {//選擇生物種類,數量  產生物件並加入list
		 switch(species) {
		 case 0:
			 for(int i =0;i<speciesNumber;i++) {		//數量
				 listAll.add(new CarnivoreA(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		 case 1:
			 for(int i =0;i<speciesNumber;i++) {		//數量
				 listAll.add(new CarnivoreB(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		 case 2:
			 for(int i =0;i<speciesNumber;i++) {		//數量
				 listAll.add(new CarnivoreC(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		 case 3:
			 for(int i =0;i<speciesNumber;i++) {		//數量
				 listAll.add(new HerbivoreA(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		 case 4:
			 for(int i =0;i<speciesNumber;i++) {		//數量
				 listAll.add(new HerbivoreB(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		 case 5:
			 for(int i =0;i<speciesNumber;i++) {		//數量
				 listAll.add(new HerbivoreC(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		 case 6:
			 for(int i =0;i<speciesNumber;i++) {		//數量
				 listAll.add(new GrassA(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		 case 7:
			 for(int i =0;i<speciesNumber;i++) {		//數量
				 listAll.add(new GrassB(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		 case 8:
			 for(int i =0;i<speciesNumber;i++) {		//數量
				 listAll.add(new GrassC(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		 case 9:
			 for(int i =0;i<speciesNumber;i++) {		//數量
				 listAll.add(new TreeA(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		 case 10:
			 for(int i =0;i<speciesNumber;i++) {		//數量
				 listAll.add(new TreeB(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		 case 11:
			 for(int i =0;i<speciesNumber;i++) {		//數量
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
				}while(i==anotherBioIndex||!anotherBio.survive);//i與anotherbioindex 為索引  !ano.survive不能選到死的 
				Biological bioA =null,bioB =null;
				int actionJudgeA=0,actionJudgeB=0;
				///肉食2	草食3	雜早5	樹木7
				///透過兩個質數相成 得到唯一解答
				if( listAll.get(i) instanceof Carnivore) {
					bioA = (Carnivore)listAll.get(i);//A是肉食動物
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
				///肉食2	草食3	雜草5	樹木7

				bioA.Encounter(bioB);
				bioB.Encounter(bioA);
				
				switch(actionJudgeA*actionJudgeB) {
					case 4://2*2 2*3 3*3 都是打架
					case 6:
					case 9:
						Animal a =(Animal)bioA;
						Animal b =(Animal)bioB;
						System.out.println(bioA.name+"與"+bioB.name+"打架,,,"+bioA.name+"生命剩下"+bioA.life+",,,"+bioB.name+"生命剩下"+bioB.life);
						if(bioA.life>0&&bioB.life<=0) {		//a存活b死亡
							 System.out.println(bioA.name+"吃了"+bioB.name);
							 a.Eat();
						 }
						 else if(bioA.life<=0&&bioB.life>0) {//a死亡b存活
							 System.out.println(bioB.name+"吃了"+bioA.name);
							 b.Eat();
						 }
						break;	
					case 15: // 5*3 是吃草
						Animal aa =(Animal)bioA;
						System.out.println(bioA.name+"吃了"+bioB.name+",,,現在飢餓度為"+aa.degreeHunger+",,,"+bioB.name+"剩下"+bioB.life+"生命");
						break;	
					case 14:	//7*2 7*3 都是休息
					case 21:
						System.out.println(bioA.name+"休息了,,,現在生命為:"+bioA.life+",,,"+bioB.name+"生命剩下"+bioB.life);
						break;
				}
			}
		}
	}
	
	void GrowUp() {		//成長  動物增加飢餓度  植物恢復生命
		for(int i =0;i<listAll.size();i++) {
			if(listAll.get(i) instanceof Animal) {
				Animal a =(Animal)listAll.get(i);
				a.DegreeHungerAdd();	//所有動物飢餓度提高 年齡增加
				a.AgeAdd();
				a.ResetPower();//重新設定力量  依照年紀
				a.DeathJudgment();
			}
			else if (listAll.get(i) instanceof Plant) {
				Plant a =(Plant)listAll.get(i);
				a.AgeAdd();
				a.Grow();
				a.DeathJudgment();
			}
		}
		System.out.println("----所有動物增加飢餓度,植物回復生命----");
	}
	void removeDeathBiological() {		//移除死往生物
		boolean a;
		for(int i =0;i<listAll.size();i++) {
			a= listAll.get(i).survive;
			if(!a) {//a=true 存活  a=false=死亡
				System.out.println(listAll.get(i).name+"死亡,移出遊戲");
				listAll.remove(i);
				i--;
			}
		}
	}
	
}
