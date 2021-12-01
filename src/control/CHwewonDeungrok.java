package control;

import java.util.Vector;

import dataAccessObject.DHwewonDeungrok;
import valueObject.OHwewon;

public class CHwewonDeungrok {
	//����̳� ��踦 �ϴ� �� controller, logic�� ������.
	private DHwewonDeungrok dHwewonDeungrok;
	public CHwewonDeungrok() {
		this.dHwewonDeungrok = new DHwewonDeungrok();
	}

	//ȸ�� ���� �о����
	public OHwewon readHwewon(String id) {
		OHwewon oHwewon = this.dHwewonDeungrok.read(id);
		return oHwewon;
	}

	//ȸ������ �����ϱ�
	public boolean saveHwewon(OHwewon oHwewon) {
		boolean i = this.dHwewonDeungrok.save(oHwewon);
		return i;
		
	}

	public String idsearch(OHwewon oHwewon) {
		String id = this.dHwewonDeungrok.idsearch(oHwewon);
		return id;
	}

	public String passwordsearch(OHwewon oHwewon) {
		String password = this.dHwewonDeungrok.passwordsearch(oHwewon);
		return password;
	}

	public boolean DeleteHwewon(OHwewon oHwewon) {
		boolean i  = this.dHwewonDeungrok.DeleteHwewon(oHwewon);
		return i;
	}

	public Vector<OHwewon> readHwewonList() {
		Vector<OHwewon> hwewons = this.dHwewonDeungrok.showHwewonList();
		return hwewons;
	}
}
