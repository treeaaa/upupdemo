package upupdemo;

public class GrassC extends Grass{
	String baseName ="����C";
	public GrassC(int id,int plantid) {
		this.id =id;
		this.name = baseName + String.valueOf(plantid);
		this.life = test.plantBaseLife + test.grassClifeAdd;
		this.growSpeed = test.grassBaseGrowSpeed+test.grassCGrowSpeedAdd;
	}
}
