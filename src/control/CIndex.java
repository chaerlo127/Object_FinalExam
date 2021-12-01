package control;

import java.util.Vector;

import dataAccessObject.DIndex;
import valueObject.OIndex;

public class CIndex {
	private DIndex dIndex;

	public CIndex() {
		this.dIndex = new DIndex();
	}

	public Vector<OIndex> getAll(String fileName) {
		Vector<OIndex> indices = this.dIndex.readAll(fileName);
		return indices;
	}

	//ȸ�� ù ȭ�鿡�� �а� �д� ��
	public Vector<OIndex> HakgwaGetAll(String fileName) {
		Vector<OIndex> indices = this.dIndex.HakgwareadAll(fileName);
		return indices;
	}

	public Vector<OIndex> HakgwaGet(String fileName) {
		Vector<OIndex> indices = this.dIndex.HakgwaGet(fileName);
		return indices;
	}

}
