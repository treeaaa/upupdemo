package upupdemo;

public class GrassC extends Grass{
	String baseName =test.speciesName[8];
	public GrassC(int id,int plantid) {
		this.id =id;
		this.name = baseName + String.valueOf(plantid);
		this.life = test.plantBaseLife + test.grassClifeAdd;
		this.growSpeed = test.grassBaseGrowSpeed+test.grassCGrowSpeedAdd;
	}
}
