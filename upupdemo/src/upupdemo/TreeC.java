package upupdemo;

public class TreeC extends Tree{
	String baseName ="���C";
	public TreeC(int id,int plantid) {
		this.id =id;
		this.name = baseName + String.valueOf(plantid);
		this.life = test.plantBaseLife + test.treeClifeAdd;
		this.growSpeed = test.treeBaseGrowSpeed+test.treeCGrowSpeedAdd;
	}
}
