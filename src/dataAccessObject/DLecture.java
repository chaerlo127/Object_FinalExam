package dataAccessObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import model.MLecture;
import valueObject.OLecture;

public class DLecture {

	private static final String PATHNAME = "data/";
	private static final String PATHNAME2 = "user/";
	private MLecture mLecture;

	public DLecture() {
	}

	public Vector<OLecture> readAll(String fileName) {
		// ������û �� ���� ��������
		Vector<OLecture> lectures = new Vector<OLecture>();
		try {
			// ���̵� �´� mMember�� ã�ƾ� �ϴ� ����.
			File file = new File(PATHNAME + fileName);
			Scanner scanner = new Scanner(file);
			this.mLecture = new MLecture();
			while (this.mLecture.read(scanner)) {
				OLecture oLecture = new OLecture();
				oLecture.set(this.mLecture);
				lectures.add(oLecture);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return lectures;
	}

	public Vector<OLecture> MSreadAll(String fileName) {
		// �̸����, ���� ��û �� ���� ��������
		Vector<OLecture> lectures = new Vector<OLecture>();
		try {
			// ���̵� �´� mMember�� ã�ƾ� �ϴ� ����.
			File file = new File(PATHNAME2 + fileName);
			boolean exist = file.exists();
			this.mLecture = new MLecture();
			if (exist) {
				Scanner scanner = new Scanner(file);
				while (this.mLecture.read(scanner))
				// read �Լ��� true false �Լ��� return���ִ� ����.
				{
					OLecture oLecture = new OLecture();
					oLecture.set(this.mLecture);
					lectures.add(oLecture);
				}
				scanner.close();
				return lectures;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return null;

	}

	public Vector<OLecture> Delete(String id1, String FileName) {
		// �̸����, ������û ���� �����ϱ� ���� �Լ�
		Vector<OLecture> lectures = new Vector<OLecture>();
		try {
			File file = new File(PATHNAME2 + FileName);
			boolean exist = file.exists();
			if (exist) {
				file.canWrite();
				Scanner scanner = new Scanner(file);
				this.mLecture = new MLecture();
				while (this.mLecture.read(scanner)) {
					if (this.mLecture.getId().equals(id1)) {
						continue;
					} else {
						OLecture oLecture = new OLecture();
						oLecture.set(this.mLecture);
						lectures.add(oLecture);
					}
				}
				scanner.close();
				file.delete();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lectures;
	}

	public boolean MSWriteAll(String id1, String fileName) {
		// ���� �� �о����
		Vector<OLecture> lectures = this.Delete(id1, fileName);
		try {
			File file = new File(PATHNAME2 + fileName);
			boolean exist = file.exists();
			if (!exist) {
				FileWriter Filewriter = new FileWriter(file, true);
				mLecture.MWriteAll(Filewriter, lectures);
				Filewriter.close();
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean Write(String FileName, OLecture oLecture) {
		// �̸���� ���� ����
		try {
			File file = new File(PATHNAME2 + FileName);
			boolean i = file.exists();
			if (i) {
				Scanner scanner = new Scanner(file);
				this.mLecture = new MLecture();
				while (this.mLecture.read(scanner)) {
					if (mLecture.getId().equals(oLecture.getId())) {// ���� �ߺ�Ȯ��
						i = false;
					}
				}
				scanner.close();
				if(i == false)
				{
					return i;
				}
				else {
					FileWriter Filewriter = new FileWriter(file, true);
					this.mLecture.Write(Filewriter, oLecture);
					Filewriter.close();
				}
				
			} else {
				FileWriter Filewriter = new FileWriter(file, true);
				this.mLecture = new MLecture();
				this.mLecture.Write(Filewriter, oLecture);
				Filewriter.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean DeleteAll(String fileName) {
		// ���� ���� �� �����
		File file = new File(PATHNAME2 + fileName);
		boolean exist = file.exists();
		if (exist) {
			file.delete();
			return true;
		} else
			return false;
	}

	//���� ���翩�� Ȯ��
	public boolean ExistFile(String fileName) {
		File file = new File(PATHNAME2 + fileName);
		boolean exist = file.exists();
		if (exist) {
			return true;
		}
		return false;
	}

	//ȸ������ ���� ��, �̸����, ������û ���� �̸� ����
	public void changeFileName(String id, String originid) {
		File file = new File(PATHNAME2+originid);//���� ����
		File fileNew = new File(PATHNAME2+id);//���ο� ����
		boolean exist = file.exists();
		if (exist)
			file.renameTo(fileNew);
	}

}
