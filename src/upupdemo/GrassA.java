package upupdemo;

public class GrassA extends Grass{
	String baseName =test.speciesName[6];
	public GrassA(int id,int plantid) {
		this.id =id;
		this.name = baseName + String.valueOf(plantid);
		this.life = test.plantBaseLife + test.grassALifeAdd;
		this.growSpeed = test.grassBaseGrowSpeed+test.grassAGrowSpeedAdd;
	}
}
