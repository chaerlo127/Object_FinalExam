package txtView;

import java.util.Scanner;
import java.util.Vector;

import control.CLecture;
import valueObject.OHwewon;
import valueObject.OLecture;

public class VSincheong {
	private CLecture cLecture;
	private Scanner scanner;
	private String FileName;
	private String MiriFile;
	private static final String MIRI = "M";
	private static final String SUGANG = "S";
	private static final int NUMCREDIT = 18;// ����
	private int sum;
	private int remain;
	private float prSum;// ���� ���� ���� ��

	public VSincheong(Scanner scanner) {
		this.cLecture = new CLecture();
		this.scanner = scanner;
	}

	public void show(String id, OLecture oLecture, VSugangsincheon vSugangsincheon) {
		String input = null;
		this.FileName = id + SUGANG;
		this.MiriFile = id + MIRI;
		do {
			System.out.println("===================================================================");
			System.out.println("������û(1) �̸���⿡ ����Ǿ� �ִ� ���� ������û(2)");
			System.out.println("������û öȸ(3) �� ������û Ȯ���ϱ�(4)  ������û ���� ��ü �����(5) �������� ����(6) ������û ������(0)");
			System.out.println("====================================================================");
			input = this.scanner.next();

			// ������û
			if (input.equals("1")) {
				String id3 = null;
				do {
					System.out.println("������û�� �����մϴ�");
					boolean i = this.cLecture.ExistFile(this.FileName);
					if (i) {
						Vector<OLecture> lectures = this.cLecture.MSgetAll(this.FileName);
						sum = this.cLecture.creditSum(lectures);
						if (sum < NUMCREDIT - 2)// �ִ������� 18
						{
							this.SugangSincheong(oLecture, input, vSugangsincheon);
						} else {
							System.out
									.println("=======================================================================");
							System.out.println(
									"��û�� �� �ִ� ������ " + NUMCREDIT + "�����Դϴ�. ������ �ʰ��Ǿ����ϴ�. �ٸ� ���¸� öȸ�ϰ� �ٽ� �õ����ּ���.");
							System.out
									.println("=======================================================================");
						}

					} else {
						this.SugangSincheong(oLecture, input, vSugangsincheon);
					}
					System.out.println("������û(1) ������û ������(0)");
					id3 = this.scanner.next();
				} while (!id3.equals("0"));
			}

			// �̸���� ���� �ִ� ���� ������û
			else if (input.equals("2")) {
				System.out.println("�̸���⿡ ����Ǿ� �ִ� ����Ʈ �߿��� ������û�� �����մϴ�.");
				System.out.println("�̸���� ����Ʈ");
				System.out.println("============================");
				boolean exist = this.cLecture.ExistFile(id + MIRI);
				if (exist) {
					Vector<OLecture> Mirilectures = this.cLecture.MSgetAll(this.MiriFile);
					this.List(Mirilectures);// �̸���� ���δ� �о����
					System.out.println("������û�� ���¸� �������ּ���:");
					String sugangid = this.scanner.next();
					for (OLecture lecture : Mirilectures) {//
						if (lecture.getId().equals(sugangid)) {
							boolean i = this.cLecture.ExistFile(this.FileName);
							if (i) {
								Vector<OLecture> Suganglectures = this.cLecture.MSgetAll(this.FileName);
								sum = this.cLecture.creditSum(Suganglectures);
								if (sum < NUMCREDIT - 2) {
									boolean a = this.Write(this.FileName, lecture);
									if (a) {
										System.out.println("============================");
										System.out.println(id + "���� ������û");
										Vector<OLecture> lectures1 = this.cLecture.MSgetAll(this.FileName);
										this.List(lectures1);
										this.sum = 0;
										this.sum = this.cLecture.creditSum(lectures1);
										System.out.println(id + "������û �� ����: " + this.sum);
										System.out.println("============================");
										System.out.println("�̸���⿡ ���� ���ֱ�(1) �̸���� ����(2)");
										input = this.scanner.next();

										if (input.equals("1")) {
											this.Delete(Mirilectures, sugangid, this.MiriFile);
											break;
										}

										else if (input.equals("2")) {
											break;
										}
									} else {
										System.out.println("�ٽ� �Է����ּ���.");
									}
								} else {
									System.out.println(
											"=======================================================================");
									System.out.println(
											"��û�� �� �ִ� ������ " + NUMCREDIT + "�����Դϴ�. ������ �ʰ��Ǿ����ϴ�. �ٸ� ���¸� öȸ�ϰ� �ٽ� �õ����ּ���.");
									System.out.println(
											"=======================================================================");
								}

							} else {
								boolean a = this.Write(this.FileName, lecture);
								if (a) {
									System.out.println("�̸���⿡ ���� ���ֱ�(1) �̸���� ����(2)");
									input = this.scanner.next();

									if (input.equals("1")) {
										this.Delete(Mirilectures, sugangid, this.MiriFile);
										break;
									}

									else if (input.equals("2")) {
										break;
									}
								}

							}

						}
					}
				} else
					System.out.println("å������ ����ֽ��ϴ�.");
			}

			// ������û öȸ
			else if (input.equals("3")) {
				String id1 = "99999999999";
				System.out.println("������û öȸ�� �����մϴ�.");
				System.out.println("============================");
				boolean exist = this.cLecture.ExistFile(this.FileName);
				if (exist) {
					do {
						System.out.println(id + "���� ������û");
						Vector<OLecture> lectures = this.cLecture.MSgetAll(this.FileName);
						this.List(lectures);// ������û ����Ʈ ���� �о����
						System.out.println("====================================================");
						System.out.println("������û öȸ(1) �̸����� ����(2)");
						String put = this.scanner.next();
						System.out.println("öȸ�� ������û ���� ��ȣ�� �ϳ� �������ּ���. �������� 0���� �����ּ���.");
						System.out.println("====================================================");
						// ���� ��û öȸ
						if (put.equals("1")) {
							id1 = this.scanner.next();
							this.Delete(lectures, id1, this.FileName);
						}
						// �̸����� ����
						else if (put.equals("2")) {
							id1 = this.scanner.next();

							for (OLecture lecture : lectures) {
								if (lecture.getId().equals(id1)) {
									boolean i = this.Write(this.MiriFile, lecture);
									if (i) {
										this.Delete(lectures, id1, this.FileName);
										System.out.println("�̸����� ����Ǿ����ϴ�.");
										break;
									} else {

									}

								}
							}
						} else {
							System.out.println("�߸� �Է��ϼ̽��ϴ�.");
						}
					} while (!id1.equals("0"));
				} else {
					System.out.println("������û ���°� ����ֽ��ϴ�");
				}
			}

			// �� ������û Ȯ���ϱ�
			else if (input.equals("4")) {
				System.out.println(id + "���� ������û");
				this.sum = 0;
				boolean exist = this.cLecture.ExistFile(this.FileName);
				if (exist) {
					Vector<OLecture> lectures = this.cLecture.MSgetAll(this.FileName);
					this.List(lectures);
					this.sum = this.cLecture.creditSum(lectures);
					System.out.println(id + "���� ������û ����: " + this.sum);
					this.remain = this.cLecture.remainCredit(NUMCREDIT);
					System.out.println("��û�� �� �ִ� ����: " + this.remain);
				} else {
					System.out.println("������û ���°� ����ֽ��ϴ�");
					System.out.println(id + "���� ������û ����: " + this.sum);
					System.out.println("��û�� �� �ִ� ����: " + NUMCREDIT);
				}

			}

			// ������û ���� ��ü �����
			else if (input.equals("5")) {
				System.out.println("������ ���� ����ðڽ��ϱ�?");
				System.out.println("��(1) �ƴϿ�(2)");
				input = this.scanner.next();
				// ���� ����
				if (input.equals("1")) {
					boolean i = this.cLecture.DeleteAll(this.FileName);
					if (i == true) {
						System.out.println("���¸� ��� �������ϴ�.");
					}
					// ������û�� ����� �ִ� ���
					else if (i == false) {
						System.out.println("������û�� �� ���°� ����, ���� ���°� �����ϴ�.");
					}

				} else if (input.equals("2")) {
					System.out.println("���� ����⸦ ����մϴ�.");
				} else {
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				}
			}
			// ������û ���� ���� ����
			else if (input.equals("6")) {
				boolean exist = this.cLecture.ExistFile(this.FileName);
				if (exist) {
					Vector<OLecture> lectures = this.cLecture.MSgetAll(this.FileName);
					this.List(lectures);
					int lectureNum = 0;// ���� ���� �ʱ�ȭ, ���α׷� ��� ���� ��, �����Ǳ� ����
					lectureNum = this.cLecture.NumCredit(lectures);
					if (lectureNum != 0) {
						System.out.println("���� ������ ���ʷ� �Է����ּ���.");
						System.out.println("A+(4.5) A(4) B+(3.5) B(3) C+(2.5) C(2) D(1.5) D+(1) F(0)");
						
						for (int i = 0; i < lectureNum; i++) {
							String j = this.scanner.next();
							this.prSum = this.cLecture.predictCredit(j);
						}
						System.out.println(id + "���� ���������� " + this.prSum / lectureNum + "�Դϴ�.");
						this.cLecture.prSumInitialization();//cLecture prsum �ʱ�ȭ
					} else {
						System.out.println("������û ������ ����ֽ��ϴ�.");
					}

				} else {
					System.out.println("������û ������ ����ֽ��ϴ�.");
				}

			}

			else {
				if (input.equals("0"))
					break;
				else
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}

		} while (!input.equals(null));// ������û ������

		return;

	}

	public Vector<OLecture> List(Vector<OLecture> lectures)// ������û ����Ʈ ���� �о����
	{

		for (OLecture lecture : lectures) {
			System.out.println(lecture.getId() + " " + lecture.getName() + " " + lecture.getProfessor() + " "
					+ lecture.getCredit() + " " + lecture.getTime());
		}

		return lectures;
	}

	public void Delete(Vector<OLecture> lectures, String id1, String SugangFileName) {
		for (OLecture lecture : lectures) {
			if (lecture.getId().equals(id1)) {
				boolean exist = this.cLecture.MSWriteAll(id1, SugangFileName);
				if (exist) {
					System.out.println(lecture.getId() + "���°� ���� �Ǿ����ϴ�.");
				} else {
					System.out.println("���� ������ ����ֽ��ϴ�.");
				}
			}
		}
	}

	// �ߺ��� ���� �ִ��� Ȯ���ϱ�
	public boolean Write(String fileName, OLecture oLecture) {
		boolean a = this.cLecture.Write(fileName, oLecture);
		if (a) {
			System.out.println("������û �Ǿ����ϴ�.");
		} else {
			System.out.println("���°� �ߺ��Ǿ����ϴ�.");
		}
		return a;
	}

	// ������û �ϱ�
	public void SugangSincheong(OLecture oLecture, String input, VSugangsincheon vSugangsincheon) {
		oLecture = vSugangsincheon.sugang();
		System.out.println("������û �ϰڽ��ϱ�?");
		System.out.println("���� ��û(1) ���(2)");
		input = this.scanner.next();
		if (input.equals("1")) {
			this.Write(this.FileName, oLecture);
		} else {
			System.out.println("���� ��û�� ����մϴ�.");
		}
	}

	// ���� ���� �� �����
	public void sDeleteAll(String id) {
		this.cLecture.DeleteAll(id + SUGANG);
	}

	// ȸ�� ���� �̸� ����, ȸ������ ���� ��
	public void changeFileName(OHwewon changeoHwewon, OHwewon oHwewon) {
		this.cLecture.changeFileName(changeoHwewon.getId() + SUGANG, oHwewon.getId() + SUGANG);
	}

}
