package control;

import dataAccessObject.DHwewonDeungrok;
import valueObject.OHwewon;
import valueObject.OLogin;

public class CLogin {
//����̳� ��踦 �ϴ� �� controller, logic�� ������.
	private DHwewonDeungrok dHwewonDeungrok;

	public CLogin() {
		this.dHwewonDeungrok = new DHwewonDeungrok();
	}

	public OHwewon validate(OLogin oLogin) {
		OHwewon oHwewon = this.dHwewonDeungrok.read(oLogin.getId());
		// �ش� ���̵� = key
		if (oHwewon != null) {
			if (oLogin.getPassword().equals(oHwewon.getPassword())) {
				return oHwewon;
			}
		}
		return null;
	}

}
