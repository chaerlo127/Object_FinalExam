package constants;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

public final class Conflg {//final ����μ� ���� �������� ����. 
	//symbol�� �ǹ̿� ���ؼ� variable �� ���� ������ �� �ִ� ���̰�, constant�� ������ ���� ���ϴ� ��
	//symbol, �ǹ̿� ���� ������ �ʰ� �����ϸ� constant
	//symbol, �ǹ̿� ���� ���ϴ� ���� variable
	//size location�� ���� �����ϴ� ��
	//�޸� ��ġ�� ���� ������ �ʴ´�. 
	public static class FVMainFrame{//F�� ������ conflg
		public static final Point location =new Point(300, 100);
		//location �ܾ�� ��ǥ 200 300���� �������ѳ��� ���̴�. 
		//vmain frame�� location�� �Ǵ� ���̴�. 
		//�̸��� ���� ������ �̸��� �����ص� ����� ����. ������ ���ؼ� �̷������ name space�� �ٸ��� �����̴�. 
		public static final Dimension size = new Dimension(800, 600);
	}
	public static class FVMainPanel
	{
		public static final Color background = Color.white;
	}
	
	public static class FVHwewonDeungrok
	{
		public static final Point location =new Point(300, 100);
		public static final Dimension size = new Dimension(400, 400);
	}
	
	public static class FVCampus
	{
		public static final String FirstFileName = "root";
	}

}
