package txtView;

import java.util.Scanner;

import valueObject.OHwewon;
import valueObject.OLecture;

public class VSugangsincheon {
	private Scanner scanner;

	private VIndex vcampus;
	private VIndex vCollege;
	private VIndex vdepartment;
	private VLecture vLecture;
	private VMiridamgi vMiridamgi;
	private VSincheong vSincheong;
	private VHwewonChangeDelete vhwewonDelete;
	private VHwewonChangeDelete vHwewonChange;
	private static final String FIRSTFILENAME = "root";

	public VSugangsincheon(Scanner scanner) {
		this.scanner = scanner;
		this.vcampus = new VIndex(this.scanner);
		this.vCollege = new VIndex(this.scanner);
		this.vdepartment = new VIndex(this.scanner);
		this.vLecture = new VLecture(this.scanner);
		this.vMiridamgi = new VMiridamgi(this.scanner);
		this.vSincheong = new VSincheong(this.scanner);
		this.vhwewonDelete = new VHwewonChangeDelete(this.scanner);
		this.vHwewonChange = new VHwewonChangeDelete(this.scanner);

	}

	public OLecture sugang() {// data file �б�
		String campusFileName = this.vcampus.show(FIRSTFILENAME, "ķ�۽���");
		OLecture oLecture = new OLecture();
		if (campusFileName != null) {
			
			String collegeFileName = this.vCollege.show(campusFileName, "������");
			if (collegeFileName != null) {
				String departmentFileName = this.vdepartment.show(collegeFileName, "�а���");
				if (departmentFileName != null) {
					oLecture = this.vLecture.show(departmentFileName, "���¸�");
					
				}
			}
		}
		return oLecture;
	}

	public void show(OHwewon oHwewon) {// ������û ȭ��
		String input = null;
		do {
			System.out.println(oHwewon.getName() + "�� �ȳ��ϼ���");
			System.out.println("==========================================");
			System.out.println(oHwewon.getName() + "���� ȸ������");
			System.out.println("���̵�:" + oHwewon.getId() + " �ּ�:" + oHwewon.getAddress());
			System.out.println("�а�:" + oHwewon.getHwakgwa() + " �Ҽ�ķ�۽�:" + oHwewon.getCampus() + "ķ�۽�");
			System.out.println("==========================================");
			System.out.println("���� ����� �����ϼ���");
			System.out.println("�̸����(1) ������û(2) ȸ�� Ż��(3) ȸ������ ����(4) ���� �ѷ�����(5) �α׾ƿ�(0)");
			input = this.scanner.next();
			OLecture oLecture = new OLecture();
			// �̸����
			if (input.equals("1")) {
				oLecture = new OLecture();
				this.vMiridamgi.show(oHwewon.getId(), oLecture, this);
			}
			// ������û
			else if (input.equals("2")) {
				oLecture = new OLecture();
				this.vSincheong.show(oHwewon.getId(), oLecture, this);
			}
			// ȸ�� Ż��
			else if (input.equals("3")) {
				boolean i = this.vhwewonDelete.showDelete(oHwewon);
				if (i) {
					this.vMiridamgi.mDeleteAll(oHwewon.getId());
					this.vSincheong.sDeleteAll(oHwewon.getId());
				}
				return;
			}
			// ȸ������ ����
			else if (input.equals("4")) {
				OHwewon changeoHwewon = this.vHwewonChange.showChange(oHwewon);
				this.vMiridamgi.changeFileName(changeoHwewon, oHwewon);
				this.vSincheong.changeFileName(changeoHwewon, oHwewon);
				oHwewon = changeoHwewon;
			}
			//���� �ѷ�����
			else if (input.equals("5"))
			{
				this.sugang();
			}
			// �α׾ƿ�
			else {
				if (input.equals("0"))
					break;
				// �� ���� ���� �Է½�
				else
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}

		} while (!input.equals("0"));// ���� ��û ������

		return;
	}
}
