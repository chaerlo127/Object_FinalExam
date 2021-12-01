package dataAccessObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import model.MHwewon;
import valueObject.OHwewon;

public class DHwewonDeungrok {
	private MHwewon mHwewon;
	private static final String HWEWON = "hwewon/Hwewon";

	public DHwewonDeungrok() {
	}

	
	//ȸ������ ����
	public boolean save(OHwewon oHwewon) {

		try {
			File file = new File(HWEWON);
			if(file.exists()) {
				boolean i = this.savecorrect(oHwewon, file);
				if (i) {
					FileWriter Filewriter = new FileWriter(file, true);
					this.mHwewon = new MHwewon();
					this.mHwewon.save(Filewriter, oHwewon);
					Filewriter.close();
					return true;
				}
			}
			else {
				FileWriter Filewriter = new FileWriter(file, true);
				this.mHwewon = new MHwewon();
				this.mHwewon.save(Filewriter, oHwewon);
				Filewriter.close();
				return true;
			}
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	// id �ߺ� Ȯ��
	public boolean savecorrect(OHwewon oHwewon, File file) {
		try {
			if(file.exists())
			{
				Scanner scanner = new Scanner(file);
				this.mHwewon = new MHwewon();
				while (this.mHwewon.read(scanner)) {
					if (this.mHwewon.getId().equals(oHwewon.getId())) {
						return false;
					}
				}
				scanner.close();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	public OHwewon read(String id) {
		// mHwewon�� ���� Data read
		// oHwewon ����
		// mHwewon���� oHwewon���� ������ �̵�
		try {
			File file = new File(HWEWON);
			OHwewon oHwewon = new OHwewon();
			boolean i = file.exists();
			if (i) {
				Scanner scanner = new Scanner(file);
				this.mHwewon = new MHwewon();
				while (this.mHwewon.read(scanner))
				// read �Լ��� true false �Լ��� return���ִ� ����.
				{
					if (this.mHwewon.getId().equals(id)) {
						oHwewon.set(mHwewon);
					}
				}
				scanner.close();
				return oHwewon;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// ȸ�� ���� �� �о����
	public Vector<OHwewon> getAll() {
		Vector<OHwewon> hwewons = new Vector<OHwewon>();
		try {
			// ���̵� �´� mMember�� ã�ƾ� �ϴ� ����.
			File file = new File(HWEWON);
			Scanner scanner = new Scanner(file);
			this.mHwewon = new MHwewon();
			while (this.mHwewon.read(scanner))
			// read �Լ��� true false �Լ��� return���ִ� ����.
			{
				OHwewon oHwewon = new OHwewon();
				oHwewon.set(this.mHwewon);
				hwewons.add(oHwewon);
				// n���� ���Ҹ� ������ �� �ִ� ������ ���� �ٱ���,
				// �Ѳ����� n���� ���Ҹ� ���� �� �� ����.
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return hwewons;
	}

	public String idsearch(OHwewon oHwewon) {

		try {
			File file = new File(HWEWON);
			Scanner scanner = new Scanner(file);
			this.mHwewon = new MHwewon();
			while (this.mHwewon.read(scanner)) {

				if (this.mHwewon.getName().equals(oHwewon.getName())) {
					if (this.mHwewon.getHwakgwa().equals(oHwewon.getHwakgwa())) {
						if (this.mHwewon.getCampus().equals(oHwewon.getCampus())) {
							return this.mHwewon.getId();
						}
					}
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String passwordsearch(OHwewon oHwewon) {
		// TODO Auto-generated method stub
		try {
			File file = new File(HWEWON);
			Scanner scanner = new Scanner(file);
			this.mHwewon = new MHwewon();
			while (this.mHwewon.read(scanner)) {
				if (this.mHwewon.getId().equals(oHwewon.getId())) {
					if (this.mHwewon.getName().equals(oHwewon.getName())) {
						if (this.mHwewon.getHwakgwa().equals(oHwewon.getHwakgwa())) {
							if (this.mHwewon.getCampus().equals(oHwewon.getCampus())) {
								return this.mHwewon.getPassword();
							}
						}
					}
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	//ȸ�� Ż�𿡼�, ȸ�� Ż���� ������ ����� vector�� ����
	public Vector<OHwewon> Delete(OHwewon oHwewon) {
		Vector<OHwewon> hwewons = new Vector<OHwewon>();
		//oHwewon�� ������ �׸��� ��� ����, ������ oHwewon�� ���� �̸� ��� �ξ�� ��.
		String id = oHwewon.getId();
		String password = oHwewon.getPassword();
		String name = oHwewon.getName();
		String address = oHwewon.getAddress();
		String hwakgwa = oHwewon.getHwakgwa();
		String campus = oHwewon.getCampus();
		
		try {
			File file = new File(HWEWON);
			Scanner scanner = new Scanner(file);
			this.mHwewon = new MHwewon();
			
			while (this.mHwewon.read(scanner)) {
				if (mHwewon.getId().equals(id)) {
					if (mHwewon.getPassword().equals(password)) {
						if (mHwewon.getName().equals(name)) {
							if (mHwewon.getAddress().equals(address)) {
								if (mHwewon.getHwakgwa().equals(hwakgwa)) {
									if (mHwewon.getCampus().equals(campus)) {
										continue;
									}
								}
							}
						}
					}
				}
				else {
					oHwewon = new OHwewon();
					oHwewon.set(mHwewon);
					hwewons.add(oHwewon);
				}
			}
			scanner.close();
			file.delete();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return hwewons;
	}

	public boolean DeleteHwewon(OHwewon oHwewon) {
		Vector<OHwewon> hwewons = this.Delete(oHwewon);
	
		try {
			File file = new File(HWEWON);
			boolean exist = file.exists();
			if(!exist)
			{
				FileWriter filewriter = new FileWriter(file, true);
				this.mHwewon.WriteAll(filewriter, hwewons);
				filewriter.close();
				return true;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public Vector<OHwewon> showHwewonList() {
		Vector<OHwewon> hwewons = new Vector<OHwewon>();
		try {
			File file = new File(HWEWON);
			if(file.exists())
			{
				Scanner scanner = new Scanner(file);
				this.mHwewon = new MHwewon();
				while (this.mHwewon.read(scanner))
				{
					OHwewon oHwewon = new OHwewon();
					oHwewon.set(this.mHwewon);
					hwewons.add(oHwewon);
				}
				scanner.close();
			}
			}
		 catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return hwewons;
	}

}
