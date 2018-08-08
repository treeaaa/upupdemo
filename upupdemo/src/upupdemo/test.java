package upupdemo;
/*流程
 取得物種隨機數
 取得物種數量隨機數
產生新物種
更新所有物種狀態 ex.力量 跑速
物種相遇{
 設定物種生存=false
 }
 植物成長  回復生命
 所有物種成長		年能太大 生存=false
 所有動物增加飢餓度	飢餓太大 生存=false
從array移除物種
*/
//草的功能:降低飢餓  樹木:回復生命
//ID:唯一識別(number)從0開始 
//肉食動物要打倒別人的瞬間才能吃掉對方
public class test {
	static float animalBaseLife= 100;  //動物基礎生命
	//動物生命 = 動物基礎生命+不同動物加成(有上限)
	static float animalDegreeHunger =50;  //動物基礎飢餓程度
	static float animalDegreeHungerMax =100;	//動物飢餓程度上限   到100判定死亡
	static float animalDegreeHungerAdd =10;	//動物美日飢餓度增加
	static float animalEatDegreeHungerAdd =-10;		//動物吃東西  飢餓度下降
	static float animalRestLifeAdd = 10;		//遇到樹木休息  生命增加
	
	static float animalGrowSpeed =1;  //動物生長速度  都一樣
	//生長速度影響年紀   年紀影響力量,跑的速度
	//預計 力量= 基礎+sin函數 達成剛出生與衰老時較弱,中年時較強
	//預計 跑速 = 力量+random() 達成讓比較弱小的一方有可能逃亡
	static float animalPowerBase =30;		//動物基礎力量
	static float animalPowerAddK=10;		//power =base+k*sin()  這個是常數
	static float animalBaseAgeMax = 30; //動物基礎年紀上限  達到則死亡
	//年紀上限 = 動物基礎年紀上限+物種加成
	static float plantBaseLife = 10;  //植物基礎生命
	static float plantUsedLifeAdd =-1;		//植物被使用之後的生命值減少
	//植物生命 = 值物基礎生命+不同植物加成(沒有上限)
	//被使用則-1
	static float grassBaseGrowSpeed =1.2f;  //草的基礎生長速度
	static float treeBaseGrowSpeed  = 0.8f; //樹木基礎的生長速度
	//植物生長速度 = 基礎生長速度+不同種類植物加成
	static float carnivoreALifeAdd =10;  //肉食動物生命加成
	static float carnivoreBLifeAdd =15;
	static float carnivoreCLifeAdd =20;
	static float carnivoreAAgeAdd = 5; //肉食動物年紀加成
	static float carnivoreBAgeAdd =2;
	static float carnivoreCAgeAdd =-3;

	static float herbivoreALifeAdd =15;  //草食動物生命加成
	static float herbivoreBLifeAdd =25;
	static float herbivoreCLifeAdd =35;
	static float herbivoreAAgeAdd = 6; //草食動物年紀加成
	static float herbivoreBAgeAdd =8;
	static float herbivoreCAgeAdd =10;

	static float grassALifeAdd = 2;  //植物生命加成
	static float grassBlifeAdd = 4;
	static float grassClifeAdd = 5;
	static float grassAGrowSpeedAdd =0.6f;  //植物生長速度加成
	static float grassBGrowSpeedAdd =0.8f;
	static float grassCGrowSpeedAdd =1.0f;

	static float treeALifeAdd = 8;  //植物生命加成
	static float treeBlifeAdd = 5;
	static float treeClifeAdd = 3;
	static float treeAGrowSpeedAdd =0.3f;  //植物生長速度加成
	static float treeBGrowSpeedAdd =0.2f;
	static float treeCGrowSpeedAdd =0.4f;
	public static void main(String args[]){
		/*for(int i=0;i<a.speciesNum.length;i++) {
			System.out.println(i+a.speciesName[i]+": "+a.speciesNum[i]);
		}
		*/
		System.out.println("aa");
		BiologicalRecord a = new BiologicalRecord();	//創造物件
		a.Initial();		//初始化

		while(a.day<5){
			a.getSpeciesRandom();	//物種隨機
			a.getSpeciesNumRandom();	//物種數量隨機
			System.out.println("第"+a.day+"天,,,產生"+a.speciesName[a.speciesRandom]+",,,數量為"+a.speciesNumRandom);
			a.CreateBiological(a.speciesRandom,a.speciesNumRandom);	//產生新物種			
			a.BiologicalMeet();//生物相遇			
			a.GrowUp();	//成長  動物增加飢餓 力量改變 植物回復生命
			a.removeDeathBiological();//移除已死亡生物
			a.day++;//日期++
		}
		
		
		
	}
	
	
}
