package control;

import java.util.Vector;

import dataAccessObject.DLecture;
import valueObject.OLecture;

public class CLecture {

	private DLecture dLecture;
	private int sum;
	private float prSum;
	private int remain;
	private int lectureNum;

	public CLecture() {
		this.dLecture = new DLecture();
	}

	// ������û(ķ�۽�, �а�, �к� ��) ���� ���� ��������
	public Vector<OLecture> getAll(String fileName) {
		Vector<OLecture> lectures = this.dLecture.readAll(fileName);
		return lectures;
	}

	// �̸����, ������û ���� ���� ��������
	public Vector<OLecture> MSgetAll(String fileName) {
		Vector<OLecture> lectures = this.dLecture.MSreadAll(fileName);
		return lectures;
	}

	// �̸���⿡ ���� ����
	public boolean Write(String FileName, OLecture oLecture) {
		boolean i = this.dLecture.Write(FileName, oLecture);
		return i;
	}

	public boolean MSWriteAll(String id1, String FileName) {
		boolean exist = this.dLecture.MSWriteAll(id1, FileName);
		return exist;
	}

	// ������û, �̸���� �� ��û ���� Ȯ���ϱ�
	public int creditSum(Vector<OLecture> lectures) {
		this.sum = 0;
		for (OLecture lecture : lectures) {
			this.sum += Integer.parseInt(lecture.getCredit());
		}

		return this.sum;
	}

	// ���� ���� ����
	public int remainCredit(int numcredit) {
		this.remain = numcredit - this.sum;
		return remain;
	}

	
	// ���� ��� ����
	public float predictCredit(String j) {
		this.prSum += Float.parseFloat(j);
		return this.prSum;
	}

	// ���� ���� �� �����
	public boolean DeleteAll(String fileName) {
		boolean i = this.dLecture.DeleteAll(fileName);
		return i;
	}

	// ���� �����ϴ� �� Ȯ��
	public boolean ExistFile(String fileName) {
		boolean exist = this.dLecture.ExistFile(fileName);
		if (exist) {
			return true;
		}
		return false;
	}
	
	//���� �� ����
	public int NumCredit(Vector<OLecture> lectures) {
		this.lectureNum = 0;
		for (OLecture lecture : lectures) {
			this.lectureNum++;
		}
		return lectureNum;
	}
	
	//ȸ�� ���� ���� ��, ȸ�� ���� ���� ����
	public void changeFileName(String id, String originid) {
		this.dLecture.changeFileName(id, originid);
	}

	public void prSumInitialization()//prsum �ʱ�ȭ
	{
		this.prSum = 0;
	}
}
