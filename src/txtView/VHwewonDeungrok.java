package txtView;

import java.util.Scanner;
import java.util.Vector;

import control.CHwewonDeungrok;
import control.CIndex;
import valueObject.OHwewon;
import valueObject.OIndex;

public class VHwewonDeungrok {

	private Scanner scanner;
	private CIndex cIndex;
	private CHwewonDeungrok cHwewonDeungrok;
	private static final String FIRSTFILENAME = "List";

	public VHwewonDeungrok(Scanner scanner) {
		this.scanner = scanner;
		this.cHwewonDeungrok = new CHwewonDeungrok();
		this.cIndex = new CIndex();
	}

	public void show() {
		System.out.println("ȸ�������� �Է��ϼ���.");
		OHwewon oHwewon = new OHwewon();
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

		boolean i = this.cHwewonDeungrok.saveHwewon(oHwewon);
		if (i == true) {
			System.out.println("ȸ�� ��ϵǾ����ϴ�.");
		} else {
			System.out.println("�ߺ��� ���̵� �Դϴ�. ���̵� �ٽ� �����ϼ���.");
		}
	}

	// ���̵� ã��
	public void idsearch() {
		System.out.println("�̸�, �а�, ķ�۽��� �����ּ���.");

		OHwewon oHwewon = new OHwewon();
		System.out.print("�̸�:");
		String name = this.scanner.next();
		oHwewon.setName(name);

		System.out.print("�а�:");
		String hwakgwa = this.scanner.next();
		oHwewon.setHwakgwa(hwakgwa);

		System.out.print("ķ�۽�:");
		String campus = this.scanner.next();
		oHwewon.setCampus(campus);

		String id = this.cHwewonDeungrok.idsearch(oHwewon);
		if (id != null) {
			System.out.println(oHwewon.getName() + "���� ���̵�: " + id);
		} else {
			System.out.println("ȸ�������� �߸��Ǿ����ϴ�. �ٽ� �Է����ּ���.");
		}
	}

	// ��й�ȣ ã��
	public void passwordsearch() {
		System.out.println("���̵�, �̸�, �а�, ķ�۽��� �����ּ���.");

		OHwewon oHwewon = new OHwewon();
		System.out.print("���̵�:");
		String id = this.scanner.next();
		oHwewon.setId(id);

		System.out.print("�̸�:");
		String name = this.scanner.next();
		oHwewon.setName(name);

		System.out.print("�а�:");
		String hwakgwa = this.scanner.next();
		oHwewon.setHwakgwa(hwakgwa);

		System.out.print("ķ�۽�:");
		String campus = this.scanner.next();
		oHwewon.setCampus(campus);

		String password = this.cHwewonDeungrok.passwordsearch(oHwewon);
		if (password != null) {
			System.out.println(oHwewon.getName() + "���� ��й�ȣ: " + password);
		} else {
			System.out.println("ȸ�������� �߸��Ǿ����ϴ�. �ٽ� �Է����ּ���.");
		}
	}

	//ȸ����� ����Ʈ
	public void showHwewonList() {
		Vector<OHwewon> hwewons = this.cHwewonDeungrok.readHwewonList();
		if (hwewons != null) {
			System.out.println("Ȯ���ϰ�, �ڽ��� ȸ�� ����Ʈ�� ���ٸ� ȸ�������� �������ּ���.");
			System.out.println("===========================================");
			System.out.println("������û ���α׷� ȸ������ ����Ʈ");
			for (OHwewon oHwewon : hwewons) {
				System.out.println("���̵�: " + oHwewon.getId() + " �̸�: " + oHwewon.getName());
			}
		}
		else
		{
			System.out.println("ȸ������� �л��� �����ϴ�.");
		}
	}
	
	
	//�а� ����Ʈ
	public void showHakgwaList() {
		Vector<OIndex> indices = cIndex.HakgwaGetAll(FIRSTFILENAME);
		for (OIndex oIndex : indices) {
			System.out.println(oIndex.getId() + " " + oIndex.getName());
		}
		System.out.println("ȸ������ ��, �б��� �ִ� �а��� ã�ƺ��ñ� �ٶ��ϴ�.");
		System.out.println("�ڽ��� �����ִ� �а��� Full Name�� �����ּ���. Ex) ��ǻ�Ͱ��а�");
		System.out.println("������� �а��� �������ּ���.");
		String input = this.scanner.next();
		System.out.println("===========================================");
		for (OIndex oIndex : indices) {
			if (oIndex.getId().equals(input)) {
				Vector<OIndex> indices2 = cIndex.HakgwaGet(oIndex.getFileName());
				for (OIndex oIndex1 : indices2)
				{
					System.out.println(oIndex1.getName());
				}
			}
		}
	}
}
