package upupdemo;

public class TreeB extends Tree{
	String baseName =test.speciesName[10];
	public TreeB(int id,int plantid) {
		this.id =id;
		this.name = baseName + String.valueOf(plantid);
		this.life = test.plantBaseLife + test.treeBlifeAdd;
		this.growSpeed = test.treeBaseGrowSpeed+test.treeBGrowSpeedAdd;
	}
}
