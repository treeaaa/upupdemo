package upupdemo;
/*�y�{
 ���o�����H����
 ���o���ؼƶq�H����
���ͷs����
��s�Ҧ����ت��A ex.�O�q �]�t
���ج۹J{
 �]�w���إͦs=false
 }
 �Ӫ�����  �^�_�ͩR
 �Ҧ����ئ���		�~��Ӥj �ͦs=false
 �Ҧ��ʪ��W�[���j��	���j�Ӥj �ͦs=false
�qarray��������
*/
//�󪺥\��:���C���j  ���:�^�_�ͩR
//ID:�ߤ@�ѧO(number)�q0�}�l 
//�׭��ʪ��n���˧O�H�������~��Y�����
public class test {
	static float animalBaseLife= 100;  //�ʪ���¦�ͩR
	//�ʪ��ͩR = �ʪ���¦�ͩR+���P�ʪ��[��(���W��)
	static float animalDegreeHunger =50;  //�ʪ���¦���j�{��
	static float animalDegreeHungerMax =100;	//�ʪ����j�{�פW��   ��100�P�w���`
	static float animalDegreeHungerAdd =10;	//�ʪ����鰧�j�׼W�[
	static float animalEatDegreeHungerAdd =-10;		//�ʪ��Y�F��  ���j�פU��
	static float animalRestLifeAdd = 10;		//�J�����  �ͩR�W�[
	
	static float animalGrowSpeed =1;  //�ʪ��ͪ��t��  ���@��
	//�ͪ��t�׼v�T�~��   �~���v�T�O�q,�]���t��
	//�w�p �O�q= ��¦+sin��� �F����X�ͻP�I�Ѯɸ��z,���~�ɸ��j
	//�w�p �]�t = �O�q+random() �F��������z�p���@�観�i��k�`
	static float animalPowerBase =30;		//�ʪ���¦�O�q
	static float animalPowerAddK=10;		//power =base+k*sin()  �o�ӬO�`��
	static float animalBaseAgeMax = 30; //�ʪ���¦�~���W��  �F��h���`
	//�~���W�� = �ʪ���¦�~���W��+���إ[��
	static float plantBaseLife = 10;  //�Ӫ���¦�ͩR
	static float plantUsedLifeAdd =-1;		//�Ӫ��Q�ϥΤ��᪺�ͩR�ȴ��
	//�Ӫ��ͩR = �Ȫ���¦�ͩR+���P�Ӫ��[��(�S���W��)
	//�Q�ϥΫh-1
	static float grassBaseGrowSpeed =1.2f;  //�󪺰�¦�ͪ��t��
	static float treeBaseGrowSpeed  = 0.8f; //����¦���ͪ��t��
	//�Ӫ��ͪ��t�� = ��¦�ͪ��t��+���P�����Ӫ��[��
	static float carnivoreALifeAdd =10;  //�׭��ʪ��ͩR�[��
	static float carnivoreBLifeAdd =15;
	static float carnivoreCLifeAdd =20;
	static float carnivoreAAgeAdd = 5; //�׭��ʪ��~���[��
	static float carnivoreBAgeAdd =2;
	static float carnivoreCAgeAdd =-3;

	static float herbivoreALifeAdd =15;  //�󭹰ʪ��ͩR�[��
	static float herbivoreBLifeAdd =25;
	static float herbivoreCLifeAdd =35;
	static float herbivoreAAgeAdd = 6; //�󭹰ʪ��~���[��
	static float herbivoreBAgeAdd =8;
	static float herbivoreCAgeAdd =10;

	static float grassALifeAdd = 2;  //�Ӫ��ͩR�[��
	static float grassBlifeAdd = 4;
	static float grassClifeAdd = 5;
	static float grassAGrowSpeedAdd =0.6f;  //�Ӫ��ͪ��t�ץ[��
	static float grassBGrowSpeedAdd =0.8f;
	static float grassCGrowSpeedAdd =1.0f;

	static float treeALifeAdd = 8;  //�Ӫ��ͩR�[��
	static float treeBlifeAdd = 5;
	static float treeClifeAdd = 3;
	static float treeAGrowSpeedAdd =0.3f;  //�Ӫ��ͪ��t�ץ[��
	static float treeBGrowSpeedAdd =0.2f;
	static float treeCGrowSpeedAdd =0.4f;
	public static void main(String args[]){
		/*for(int i=0;i<a.speciesNum.length;i++) {
			System.out.println(i+a.speciesName[i]+": "+a.speciesNum[i]);
		}
		*/
		System.out.println("aa");
		BiologicalRecord a = new BiologicalRecord();	//�гy����
		a.Initial();		//��l��

		while(a.day<5){
			a.getSpeciesRandom();	//�����H��
			a.getSpeciesNumRandom();	//���ؼƶq�H��
			System.out.println("��"+a.day+"��,,,����"+a.speciesName[a.speciesRandom]+",,,�ƶq��"+a.speciesNumRandom);
			a.CreateBiological(a.speciesRandom,a.speciesNumRandom);	//���ͷs����			
			a.BiologicalMeet();//�ͪ��۹J			
			a.GrowUp();	//����  �ʪ��W�[���j �O�q���� �Ӫ��^�_�ͩR
			a.removeDeathBiological();//�����w���`�ͪ�
			a.day++;//���++
		}
		
		
		
	}
	
	
}
