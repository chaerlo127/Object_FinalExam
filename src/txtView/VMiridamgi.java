package txtView;

import java.util.Scanner;
import java.util.Vector;

import control.CLecture;
import valueObject.OHwewon;
import valueObject.OLecture;

public class VMiridamgi {
	private CLecture cLecture;
	private Scanner scanner;
	private String FileName;
	private String SugangFile;
	private int sum;
	private int remain;
	private static final int NUMCREDIT = 24;
	private static final String MIRI = "M";
	private static final String SUGANG = "S";

	public VMiridamgi(Scanner scanner) {
		this.cLecture = new CLecture();
		this.scanner = scanner;
	}

	public void show(String id, OLecture oLecture, VSugangsincheon vSugangsincheon) {
		String input = "99";
		String id1 = "99";
		this.FileName = id + MIRI;
		this.SugangFile = id + SUGANG;
		do {
			System.out.println("�̸���� ��û(1) �̸���� öȸ(2) �� �̸���� Ȯ���ϱ�(3) ");
			System.out.println("������û ���� öȸ ��, �̸����� ����(4) �̸���� ���� ��ü �����(5) �̸���� ������(0)");
			input = this.scanner.next();

			// �̸���� ��û
			if (input.equals("1")) {
				System.out.println("�̸���⸦ �����մϴ�.");
				// ���� �ʰ� �� �̸���� ���ϰ� �ϱ�
				boolean i = this.cLecture.ExistFile(this.FileName);
				if (i) {
					Vector<OLecture> lectures = this.cLecture.MSgetAll(this.FileName);
					sum = this.cLecture.creditSum(lectures);
					if (sum < NUMCREDIT-2)// ���������� �� �� �ִ� ������ 24�����̹Ƿ� 2���� Ȥ�� 3������ �޴� ��� 21+2 or 3 �̹Ƿ� 24 �̳��� �ȴ�.
					{
						this.MiriSugang(oLecture, vSugangsincheon);
					} else {
						System.out.println("=======================================================================");
						System.out.println("��û�� �� �ִ� ������ "+NUMCREDIT +"�����Դϴ�. ������ �ʰ��Ǿ����ϴ�. �ٸ� ���¸� öȸ�ϰ� �ٽ� �õ����ּ���.");
						System.out.println("=======================================================================");
					}
				} else {
					this.MiriSugang(oLecture, vSugangsincheon);
				}

			}

			// �̸���� öȸ
			else if (input.equals("2")) {
				System.out.println("�̸���� öȸ�� �����մϴ�.");
				System.out.println(id + "���� �̸����");
				System.out.println("============================");
				boolean exist = this.cLecture.ExistFile(this.FileName);
				if (exist) {
					Vector<OLecture> lectures = this.cLecture.MSgetAll(this.FileName);
					this.List(lectures);
					System.out.println("============================");
					System.out.println("öȸ�� �̸���� ���� ��ȣ�� �ϳ� �������ּ���");
					id1 = this.scanner.next();
					System.out.println("============================");
					this.Delete(lectures, id1, this.FileName);
				} else
					System.out.println("å������ ����ֽ��ϴ�.");
			}

			// �� �̸���� Ȯ���ϱ�
			else if (input.equals("3")) {
				System.out.println(id + "���� �̸����");
				boolean exist = this.cLecture.ExistFile(this.FileName);
				this.sum = 0;
				if (exist) {
					Vector<OLecture> lectures = this.cLecture.MSgetAll(this.FileName);
					this.List(lectures);
					this.sum = this.cLecture.creditSum(lectures);
					System.out.println(id + "���� �̸���� ����: " + this.sum);
					this.remain = this.cLecture.remainCredit(NUMCREDIT);
					System.out.println("��û�� �� �ִ� ����: " + this.remain);
				} else
				{
					System.out.println("å������ ����ֽ��ϴ�.");
					System.out.println(id + "���� �̸���� ����: " + this.sum);
					System.out.println("��û�� �� �ִ� ����: " + NUMCREDIT);
				}
			}

			// ������û ���� �̸����� ����
			else if (input.equals("4")) {
				System.out.println(id + "���� ������û ����Ʈ");
				boolean exist = this.cLecture.ExistFile(this.SugangFile);
				if (exist) {
					Vector<OLecture> lectures = this.cLecture.MSgetAll(this.SugangFile);
					this.List(lectures);
					System.out.println("������û�� öȸ�ϰ� �̸����� �ű� ���¸� �������ּ���");
					String id2 = this.scanner.next();

					for (OLecture lecture : lectures) {
						if (lecture.getId().equals(id2)) {
							boolean i = this.cLecture.ExistFile(this.FileName);
							if (i)// true
							{
								Vector<OLecture> Mirilectures = this.cLecture.MSgetAll(this.FileName);// ���� ��
								sum = this.cLecture.creditSum(Mirilectures);
								if (sum < NUMCREDIT-2) {
									oLecture = lecture;
									boolean a = this.Write(this.FileName, oLecture);
									if (a) {
										this.Delete(lectures, id2, this.SugangFile);
										System.out.println(id + "���� �̸����");
										Vector<OLecture> lectures1 = this.cLecture.MSgetAll(this.FileName);
										this.List(lectures1);
									} else {
										//���� �ߺ�
										System.out.println("�ٽ� �õ��ϼ���.");
									}

								} else {
									System.out.println(
											"=======================================================================");
									System.out.println("��û�� �� �ִ� ������ "+NUMCREDIT +"�����Դϴ�. ������ �ʰ��Ǿ����ϴ�. �ٸ� ���¸� öȸ�ϰ� �ٽ� �õ����ּ���.");
									System.out.println(
											"=======================================================================");
								}

							} else {
								oLecture = lecture;
								boolean a = this.Write(this.FileName, oLecture);
								if (a) {
									this.Delete(lectures, id2, this.SugangFile);
									System.out.println(id + "���� �̸����");
									Vector<OLecture> lectures1 = this.cLecture.MSgetAll(this.FileName);
									this.List(lectures1);
								} else {
									System.out.println("�ٽ� �õ��ϼ���.");
								}

							}

						}
					}

				} else
					System.out.println("������û ������ ����ֽ��ϴ�.");
			}
			// �̸���� ��ü �����
			else if (input.equals("5")) {
				System.out.println("������ ���� ����ðڽ��ϱ�?");
				System.out.println("��(1) �ƴϿ�(2)");
				input = this.scanner.next();
				if (input.equals("1")) {
					boolean i = this.cLecture.DeleteAll(this.FileName);
					if (i == true) {
						System.out.println("���¸� ��� �������ϴ�.");
					} else if (i == false) {
						System.out.println("å������ ������־�, ���� ���°� �����ϴ�.");
					}

				} else if (input.equals("2")) {
					System.out.println("���� ����⸦ ����մϴ�.");
				} else {
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				}
			} else {
				if (input.equals("0")) {
					break;
				} else
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}

		} while (!input.equals("99"));// �̸���� ������

		return;
	}

	//��û ����Ʈ ���� �о����
	public void List(Vector<OLecture> lectures)
	{
		for (OLecture lecture : lectures) {
			System.out.println(lecture.getId() + " " + lecture.getName() + " " + lecture.getProfessor() + " "
					+ lecture.getCredit() + " " + lecture.getTime());
		}
	}

	public boolean Delete(Vector<OLecture> lectures, String id1, String MIRIfileName) {// Ư�� ���� �����
		for (OLecture lecture : lectures) {
			if (lecture.getId().equals(id1)) {
				boolean exist = this.cLecture.MSWriteAll(id1, MIRIfileName);
				if (exist) {
					System.out.println(lecture.getId() + "���°� ���� �Ǿ����ϴ�.");
					return true;
				}
			}
		}
		return false;
	}
	
	//�̸�������Ͽ� ���� ����
	public boolean Write(String fileName, OLecture oLecture) {
		boolean a = this.cLecture.Write(fileName, oLecture);
		if (a) {
			System.out.println("�̸���� �Ǿ����ϴ�.");
		} else {
			System.out.println("���°� �ߺ��Ǿ����ϴ�.");
		}
		return a;
	}

	//�̸���� ������û
	public void MiriSugang(OLecture oLecture, VSugangsincheon vSugangsincheon)
	{
		oLecture = vSugangsincheon.sugang();
		System.out.println("�̸���� �ϰڽ��ϱ�?");
		System.out.println("�̸���� ��û(1) ���(2)");
		String input = this.scanner.next();
		if(input.equals("1"))
		{
			this.Write(this.FileName, oLecture);
		}
		else {
			System.out.println("�̸���� ��û�� ����մϴ�.");
		}
	}
	
	//ȸ�� Ż�� ��, �̸���⿡ �ִ� ���� �� �����
	public void mDeleteAll(String id)
	{
		this.cLecture.DeleteAll(id+MIRI);
	}

	
	//ȸ�� ���� ���� ��, ȸ���� �̸���� ���� �̸��� ����
	public void changeFileName(OHwewon changeoHwewon, OHwewon oHwewon) {
		this.cLecture.changeFileName(changeoHwewon.getId()+MIRI, oHwewon.getId()+MIRI);
	}
}
