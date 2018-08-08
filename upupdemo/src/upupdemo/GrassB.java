package upupdemo;

public class GrassB extends Grass{
	String baseName ="Âø¯óB";
	public GrassB(int id,int plantid) {
		this.id =id;
		this.name = baseName + String.valueOf(plantid);
		this.life = test.plantBaseLife + test.grassBlifeAdd;
		this.growSpeed = test.grassBaseGrowSpeed+test.grassBGrowSpeedAdd;
	}
}
