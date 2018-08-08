package upupdemo;

public class TreeA extends Tree{
	String baseName ="¾ð¤ìA";
	public TreeA(int id,int plantid) {
		this.id =id;
		this.name = baseName + String.valueOf(plantid);
		this.life = test.plantBaseLife + test.treeALifeAdd;
		this.growSpeed = test.treeBaseGrowSpeed+test.treeAGrowSpeedAdd;
	}
}
