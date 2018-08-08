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
	String[] speciesName = {"肉食A","肉食B","肉食C","草食A","草食B","草食C","雜草A","雜草B","雜草C","樹木A","樹木B","樹木C"};
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
	public void CreateBiological(int species ,int speciesNum) {//選擇生物種類,數量  產生物件並加入list
		 switch(species) {
		 case 0:
			 for(int i =0;i<speciesNum;i++) {		//數量
				 listAll.add(new CarnivoreA(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		 case 1:
			 for(int i =0;i<speciesNum;i++) {		//數量
				 listAll.add(new CarnivoreB(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		 case 2:
			 for(int i =0;i<speciesNum;i++) {		//數量
				 listAll.add(new CarnivoreC(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		 case 3:
			 for(int i =0;i<speciesNum;i++) {		//數量
				 listAll.add(new HerbivoreA(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		 case 4:
			 for(int i =0;i<speciesNum;i++) {		//數量
				 listAll.add(new HerbivoreB(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		 case 5:
			 for(int i =0;i<speciesNum;i++) {		//數量
				 listAll.add(new HerbivoreC(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		 case 6:
			 for(int i =0;i<speciesNum;i++) {		//數量
				 listAll.add(new GrassA(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		 case 7:
			 for(int i =0;i<speciesNum;i++) {		//數量
				 listAll.add(new GrassB(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		 case 8:
			 for(int i =0;i<speciesNum;i++) {		//數量
				 listAll.add(new GrassC(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		 case 9:
			 for(int i =0;i<speciesNum;i++) {		//數量
				 listAll.add(new TreeA(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		 case 10:
			 for(int i =0;i<speciesNum;i++) {		//數量
				 listAll.add(new TreeB(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		 case 11:
			 for(int i =0;i<speciesNum;i++) {		//數量
				 listAll.add(new TreeC(id,this.speciesNum[species]));
				 this.id++;
				 this.speciesNum[species]++;
			 }
			 break;
		}
		 
	}
	public void BiologicalMeet() {//生物相遇
		 for(int i=0;i<listAll.size();i++) {//收尋所有在listall裡的生物物件 並彼此相遇
			 //listAll.get(i).
			 if(listAll.get(i).survive) {		//先判斷第一個生物生存 =true
				 int anotherBiological =(int)(Math.random()*listAll.size());//找到另一個生物
				 if(listAll.get(anotherBiological).survive) {	//第二個生物是否生存
					 while(i==anotherBiological) {
						 anotherBiological =(int)(Math.random()*listAll.size());//遇到與自己重複時,從新選擇對象
					 }
					 if(listAll.get(i) instanceof Carnivore) {//A是肉食	
						 Carnivore a = (Carnivore)listAll.get(i);
						 if(listAll.get(anotherBiological) instanceof Carnivore) {//B是肉食		
							 Carnivore b = (Carnivore)listAll.get(anotherBiological);
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
						 else if (listAll.get(anotherBiological) instanceof Herbivore) {//B是草食
							 Herbivore b = (Herbivore)listAll.get(anotherBiological);
							 a.life =a.life -b.power;
							 b.life =b.life -a.power;
							 a.DeathJudgment();
							 b.DeathJudgment();
							 
							 System.out.println(a.name+"與"+b.name+"打架,,,"+a.name+"生命剩下"+a.life+",,,"+b.name+"生命剩下"+b.life);
						 }
						 else if (listAll.get(anotherBiological) instanceof Grass) {//B雜草
							 Grass b = (Grass)listAll.get(anotherBiological);
						 }
						 else if (listAll.get(anotherBiological) instanceof Tree) {//B是樹木
							 Tree b = (Tree)listAll.get(anotherBiological);
							 a.Rest();
							 b.Used();
							 System.out.println(a.name+"休息了,,,現在生命為:"+a.life+",,,"+b.name+"生命剩下"+b.life);
						 }
					 }
					 else if (listAll.get(i) instanceof Herbivore) {//A是草食
						 Herbivore a = (Herbivore)listAll.get(i);
						 if(listAll.get(anotherBiological) instanceof Carnivore) {//B是肉食		
							 Carnivore b = (Carnivore)listAll.get(anotherBiological);
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
						 else if (listAll.get(anotherBiological) instanceof Herbivore) {//B是草食
							 Herbivore b = (Herbivore)listAll.get(anotherBiological);
							 a.life =a.life -b.power;
							 b.life =b.life -a.power;
							 a.DeathJudgment();
							 b.DeathJudgment();
							 System.out.println(a.name+"與"+b.name+"打架,,,"+a.name+"生命剩下"+a.life+",,,"+b.name+"生命剩下"+b.life);
						 }
						 else if (listAll.get(anotherBiological) instanceof Grass) {//B雜草
							 Grass b = (Grass)listAll.get(anotherBiological);
							 a.Eat();
							 b.Used();
							 System.out.println(a.name+"吃了"+b.name+",,,現在飢餓度為"+a.degreeHunger+",,,"+b.name+"剩下"+b.life+"生命");
						 }
						 else if (listAll.get(anotherBiological) instanceof Tree) {//B是樹木
							 Tree b = (Tree)listAll.get(anotherBiological);
							 a.Rest();
							 b.Used();
							 System.out.println(a.name+"休息了,,,現在生命為:"+a.life+",,,"+b.name+"剩下"+b.life+"生命");
						 }
					 }
					 /*
					 else if (listAll.get(i) instanceof Grass) {//A雜草
						 Grass a = (Grass)listAll.get(i);
						 if(listAll.get(anotherBiological) instanceof Carnivore) {//B是肉食		
							 Carnivore b = (Carnivore)listAll.get(anotherBiological);
						 }
						 else if (listAll.get(anotherBiological) instanceof Herbivore) {//B是草食
							 Herbivore b = (Herbivore)listAll.get(anotherBiological);
							 b.Eat();
							 a.Used();
							 System.out.println(b.name+"吃了"+a.name+",,,現在飢餓度為"+b.degreeHunger+",,,"+a.name+"生命剩下"+a.life);
						 }
						 else if (listAll.get(anotherBiological) instanceof Grass) {//B雜草
							 Grass b = (Grass)listAll.get(anotherBiological);
						 }
						 else if (listAll.get(anotherBiological) instanceof Tree) {//B是樹木
							 Tree b = (Tree)listAll.get(anotherBiological);
						 }						 
					 }
					 else if (listAll.get(i) instanceof Tree) {//A是樹木
						 Tree a = (Tree)listAll.get(i);
						 if(listAll.get(anotherBiological) instanceof Carnivore) {//B是肉食		
							 Carnivore b = (Carnivore)listAll.get(anotherBiological);
							 b.Rest();
							 a.Used();
							 System.out.println(b.name+"休息了,,,現在生命為:"+b.life+",,,"+a.name+"生命剩下"+a.life);
						 }
						 else if (listAll.get(anotherBiological) instanceof Herbivore) {//B是草食
							 Herbivore b = (Herbivore)listAll.get(anotherBiological);
							 b.Rest();
							 a.Used();
							 System.out.println(b.name+"休息了,,,現在生命為:"+b.life+",,,"+a.name+"生命剩下"+a.life);
						 }
						 else if (listAll.get(anotherBiological) instanceof Grass) {//B雜草
							 Grass b = (Grass)listAll.get(anotherBiological);
						 }
						 else if (listAll.get(anotherBiological) instanceof Tree) {//B是樹木
							 Tree b = (Tree)listAll.get(anotherBiological);
						 }
					 }
					 */
				 }
			}
		}
	 }
	void GrowUp() {		//成長  動物增加飢餓度  植物恢復生命
		for(int i =0;i<listAll.size();i++) {
			if(listAll.get(i) instanceof Animal) {
				Animal a =(Animal)listAll.get(i);
				a.degreeHunger =a.degreeHunger+test.animalDegreeHungerAdd;	//所有動物飢餓度提高
				a.DeathJudgment();
			}
			else if (listAll.get(i) instanceof Plant) {
				Plant a =(Plant)listAll.get(i);
				a.Grow();
				a.DeathJudgment();
			}
		}
		System.out.println("----所有動物增加飢餓度,植物回復生命----");
	}
	void removeDeathBiological() {
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
