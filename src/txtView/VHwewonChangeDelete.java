package txtView;

import java.util.Scanner;

import control.CHwewonDeungrok;
import valueObject.OHwewon;

public class VHwewonChangeDelete {

	private Scanner scanner;
	private CHwewonDeungrok cHwewonDeungrok;
	private boolean i;
	
	public VHwewonChangeDelete(Scanner scanner) {
		this.scanner = scanner;
		this.cHwewonDeungrok = new CHwewonDeungrok();
	}

	public OHwewon showChange(OHwewon oHwewon) {
		System.out.println("ȸ������ ������ �Ͻðڽ��ϱ�?");
		System.out.println("��(1) �ƴϿ�(2)");
		String input = this.scanner.next();
		//ȸ������ ����
		if(input.equals("1"))
		{
			this.i = this.cHwewonDeungrok.DeleteHwewon(oHwewon);
			if(i)
			{
				oHwewon = new OHwewon();
				System.out.print("���̵� �Է�: ");
				String id = scanner.next();
				oHwewon.setId(id);

				System.out.print("��й�ȣ: ");
				String password = scanner.next();
				oHwewon.setPassword(password);

				System.out.print("�̸�: ");
				String name = scanner.next();
				oHwewon.setName(name);

				System.out.print("�ּ�: ");
				String address = scanner.next();
				oHwewon.setAddress(address);

				System.out.print("�а�(Full Name�� �����ּ���): ");
				String hwakgwa = scanner.next();
				oHwewon.setHwakgwa(hwakgwa);

				System.out.print("ķ�۽�(����/����, �α��ڷ� ���ּ���): ");
				String campus = scanner.next();
				oHwewon.setCampus(campus);

				boolean j = this.cHwewonDeungrok.saveHwewon(oHwewon);
				if (j == true) {
					System.out.println("ȸ�� ��ϵǾ����ϴ�.");
				} else {
					System.out.println("�ߺ��� ���̵� �Դϴ�. ���̵� �ٽ� �����ϼ���.");
				}
			}
		}
		else {
			System.out.println("ȸ������ ������ ����մϴ�.");
		}
		return oHwewon;
	}
	
	public boolean showDelete(OHwewon oHwewon) {
		System.out.println("���� ȸ���� Ż���Ͻðڽ��ϱ�?");
		System.out.println("��(1) �ƴϿ�(2)");
		String input = this.scanner.next();
		if(input.equals("1"))
		{
			this.i = this.cHwewonDeungrok.DeleteHwewon(oHwewon);			
		}
		else
		{
			System.out.println("ȸ��Ż�� ����մϴ�.");
		}
		return this.i;
	}
	
}
