package txtView;

import java.util.Scanner;

import valueObject.OHwewon;

public class VInitial {

	private Scanner scanner;
	private VHwewonDeungrok hwewonDeungrok;
	private VHwewonDeungrok searchId;
	private VHwewonDeungrok searchPassword;
	private VHwewonDeungrok vHakgwaList;
	private VLogin login;
	private VSugangsincheon vSugangsincheon;
	

	public VInitial(Scanner scanner) {
		this.scanner = scanner;
		this.hwewonDeungrok = new VHwewonDeungrok(scanner);
		this.login = new VLogin(scanner);
		this.vHakgwaList = new VHwewonDeungrok(scanner);
		this.searchId = new VHwewonDeungrok(scanner);
		this.searchPassword = new VHwewonDeungrok(scanner);
	}

	public void show() {
		String input = null;

		do {
			System.out.println("���� ����� ���� �ϼ���");
			System.out.println("�α���(1), ȸ�����(2), ���̵� ã��(3), ��й�ȣ ã��(4), ȸ������ �ο� ����Ʈ(5), �б� �а� ����Ʈ(6)");
			input = scanner.next();

			// �α���
			if (input.equals("1")) {
				// login dialog show
				OHwewon OHwewon = this.login.show();
				// ��й�ȣ�� ���� ��
				if (OHwewon != null) {
					this.vSugangsincheon = new VSugangsincheon(this.scanner);
					this.vSugangsincheon.show(OHwewon);
				}
				// ��й�ȣ�� ���� ���� ��
				else if (OHwewon == null) {
					System.out.println("ȸ������� �Ͻðڽ��ϱ�?");
					System.out.println("��(1) �ƴϿ�(2)");

					input = this.scanner.next();
					if (input.equals("1")) {
						this.hwewonDeungrok.show();
					}
				}
			}

			// ȸ�����
			else if (input.equals("2")) {
				this.hwewonDeungrok.show();
			}

			// ���̵� ã��
			else if (input.equals("3")) {
				this.searchId.idsearch();
			}

			// ��й�ȣ ã��
			else if (input.equals("4")) {
				this.searchPassword.passwordsearch();
			}

			// ȸ�� ����� �л� ����Ʈ Ȯ��
			else if (input.equals("5")) {
				this.hwewonDeungrok.showHwewonList();
			}
			//�б� �а� ����Ʈ
			else if (input.equals("6")) {
				this.vHakgwaList.showHakgwaList();
			} else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
			System.out.println("===========================================");
			System.out.println("������û ���α׷� ����ϱ�(1) ������(0)");
			input = this.scanner.next();

		} while (!input.equals("0"));

		return;
	}

}
