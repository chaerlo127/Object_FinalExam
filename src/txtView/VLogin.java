package txtView;

import java.util.Scanner;

import control.CLogin;
import valueObject.OHwewon;
import valueObject.OLogin;

public class VLogin {

	private Scanner scanner;
	private CLogin clogin;
	
	public VLogin(Scanner scanner) {
		this.scanner = scanner;
		this.clogin = new CLogin();
	}

	public OHwewon show() {
		
		System.out.println("���̵�� ��й�ȣ�� �Է��ϼ���");
		OLogin oLogin = new OLogin();
		System.out.print("���̵� �Է�: ");
		String id = scanner.next();
		oLogin.setId(id);
		
		System.out.print("��й�ȣ: ");
		String password = scanner.next();
		oLogin.setPassword(password);
		
		OHwewon ohwewon = this.clogin.validate(oLogin);
		//validate�� Ȯ���ϴ� ����
		
		if(ohwewon != null) {
			return ohwewon;			
		}else 
		{
			System.out.println("���̵�� ��й�ȣ�� �ùٸ��� �ʽ��ϴ�");
			System.out.println("�ٽ� �Է����ּ���");//�� ���
			return null;
		}
	}
	
}
