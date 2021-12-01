package dataAccessObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import model.MIndex;
import valueObject.OIndex;

public class DIndex {
	
	private MIndex mIndex;
	public DIndex() {
	}
	
	private static final String PATHNAME = "data/";
	private static final String PATHNAME2 = "HakgwaList/";

	public Vector<OIndex> readAll(String fileName) {
		Vector<OIndex> indices = new Vector<OIndex>();
		try {
			//���̵� �´� mMember�� ã�ƾ� �ϴ� ����. 
			File file = new File(PATHNAME + fileName);
			//�̸��� �����͸� �ٿ�����. scanner�� �ƴ϶�
			//��Ʈ���� �̴�� ���� ���� �ʱ� ������ ���� �������.
			Scanner scanner = new Scanner(file);
			this.mIndex = new MIndex();
			while(mIndex.read(scanner))
				//read �Լ��� true false �Լ��� return���ִ� ����.
			{
				OIndex oIndex = new OIndex();
				oIndex.set(mIndex);
				indices.add(oIndex);
				//n���� ���Ҹ� ������ �� �ִ� ������ ���� �ٱ���, 
				//�Ѳ����� n���� ���Ҹ� ���� �� �� ����. 
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return indices;
	}

	public Vector<OIndex> HakgwareadAll(String fileName) {
		Vector<OIndex> indices = new Vector<OIndex>();
		
		try {
			File file = new File(PATHNAME2 + fileName);
			Scanner scanner = new Scanner(file);
			this.mIndex = new MIndex();
			while(mIndex.read(scanner))
			{
				OIndex oIndex = new OIndex();
				oIndex.set(mIndex);
				indices.add(oIndex);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return indices;
	}

	public Vector<OIndex> HakgwaGet(String fileName) {
		Vector<OIndex> indices = new Vector<OIndex>();
		try {
			File file = new File(PATHNAME2 + fileName);
			Scanner scanner = new Scanner(file);
			this.mIndex = new MIndex();
			while(mIndex.readHakgwa(scanner))
			{
				OIndex oIndex = new OIndex();
				oIndex.set(mIndex);
				indices.add(oIndex);
			}
			scanner.close();
			return indices;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
