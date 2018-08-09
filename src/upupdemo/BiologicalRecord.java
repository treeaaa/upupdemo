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
	public void BiologicalMeett() {
		for(int i =0;i<listAll.size();i++) {
			Biological bio = listAll.get(i);
			if(bio.survive) {
				int anotherBioIndex;
				Biological anotherBio = null;
				do {
					anotherBioIndex = (int)(Math.random()*listAll.size());
					anotherBio = listAll.get( anotherBioIndex);
				}while(i==anotherBioIndex||!anotherBio.survive);//i與anotherbioindex 為索引  !ano.survive不能選到死的 
				if(listAll.get(i) instanceof Carnivore) {//A是肉食	
					 Carnivore a = (Carnivore)listAll.get(i);
					 if(listAll.get(anotherBioIndex) instanceof Carnivore) {//B是肉食		
						 Carnivore b = (Carnivore)listAll.get(anotherBioIndex);
						 a.life =a.life -b.power;
						 b.life =b.life -a.power;
						 a.DeathJudgment();
						 b.DeathJudgment();
						 System.out.println(a.name+"與"+b.name+"打架,,,"+a.name+"生命剩下"+a.life+",,,"+b.name+"生命剩下"+b.life);
						 if(a.life>0&&b.life<=0) {		//a存活b死亡
							 System.out.println(a.name+"吃了"+b.name);
							 a.Eat();
						 }
						 else if(a.life<=0&&b.life>0) {//a死亡b存活
							 System.out.println(b.name+"吃了"+a.name);
							 b.Eat();
						 }
						 
					 }
					 else if (listAll.get(anotherBioIndex) instanceof Herbivore) {//B是草食
						 Herbivore b = (Herbivore)listAll.get(anotherBioIndex);
						 a.life =a.life -b.power;
						 b.life =b.life -a.power;
						 a.DeathJudgment();
						 b.DeathJudgment();
						 
						 System.out.println(a.name+"與"+b.name+"打架,,,"+a.name+"生命剩下"+a.life+",,,"+b.name+"生命剩下"+b.life);
					 }
					 else if (listAll.get(anotherBioIndex) instanceof Grass) {//B雜草
						 Grass b = (Grass)listAll.get(anotherBioIndex);
					 }
					 else if (listAll.get(anotherBioIndex) instanceof Tree) {//B是樹木
						 Tree b = (Tree)listAll.get(anotherBioIndex);
						 a.Rest();
						 b.Used();
						 System.out.println(a.name+"休息了,,,現在生命為:"+a.life+",,,"+b.name+"生命剩下"+b.life);
					 }
				 }
				 else if (listAll.get(i) instanceof Herbivore) {//A是草食
					 Herbivore a = (Herbivore)listAll.get(i);
					 if(listAll.get(anotherBioIndex) instanceof Carnivore) {//B是肉食		
						 Carnivore b = (Carnivore)listAll.get(anotherBioIndex);
						 a.life =a.life -b.power;
						 b.life =b.life -a.power;
						 a.DeathJudgment();
						 b.DeathJudgment();
						 System.out.println(a.name+"與"+b.name+"打架,,,"+a.name+"生命剩下"+a.life+",,,"+b.name+"生命剩下"+b.life);
						 if(a.life<=0&&b.life>0) {//a死亡b存活
							 System.out.println(b.name+"吃了"+a.name);
							 b.Eat();
						 }
					 }
					 else if (listAll.get(anotherBioIndex) instanceof Herbivore) {//B是草食
						 Herbivore b = (Herbivore)listAll.get(anotherBioIndex);
						 a.life =a.life -b.power;
						 b.life =b.life -a.power;
						 a.DeathJudgment();
						 b.DeathJudgment();
						 System.out.println(a.name+"與"+b.name+"打架,,,"+a.name+"生命剩下"+a.life+",,,"+b.name+"生命剩下"+b.life);
					 }
					 else if (listAll.get(anotherBioIndex) instanceof Grass) {//B雜草
						 Grass b = (Grass)listAll.get(anotherBioIndex);
						 a.Eat();
						 b.Used();
						 System.out.println(a.name+"吃了"+b.name+",,,現在飢餓度為"+a.degreeHunger+",,,"+b.name+"剩下"+b.life+"生命");
					 }
					 else if (listAll.get(anotherBioIndex) instanceof Tree) {//B是樹木
						 Tree b = (Tree)listAll.get(anotherBioIndex);
						 a.Rest();
						 b.Used();
						 System.out.println(a.name+"休息了,,,現在生命為:"+a.life+",,,"+b.name+"剩下"+b.life+"生命");
					 }
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
