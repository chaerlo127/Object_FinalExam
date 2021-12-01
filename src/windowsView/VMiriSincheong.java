package windowsView;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import control.CLecture;
import valueObject.OLecture;

public class VMiriSincheong extends JTable {
	private static final long serialVersionUID = 1L;
	// association
	private CLecture cLecture;
	private DefaultTableModel model;
	
	//
	public VMiriSincheong() {
		super();
		// �׸� �����
		// attributes(���������� ��ȭ���� �ʴ� ��)
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// components
		this.model = (DefaultTableModel) this.getModel();
		model.addColumn("���¸�");
		model.addColumn("�����");
		model.addColumn("�ð�");// ���� ���̴� ��, ��ȭ���� �ʴ� ���� constructer�� �����ϴ� ��
		// association
	}

	// �ʱ�ȭ�Ǿ��� �� �ʱ�ȭ �Ǵ� ���� ����
	// ������ ���� ���� �� ���� ������ ��(components, association)
	public void initialize() {
		// ������ ä���
		
		// �̸� �����ϱ� ����, file���� �о�;��� column�� row�� ����ǰ� ���� �� �ִ� ����.
		model.setNumRows(0);//row �ʱ�ȭ
		
	}
	public OLecture getData(String fileName) {
		this.cLecture = new CLecture();
//		this.cLecture.Write(fileName, oLectureGet.getId(), oLectureGet);
		Vector<OLecture> oLectures = this.cLecture.MSgetAll(fileName);
		if(oLectures!= null)
		{
			OLecture lecture = new OLecture();
			String[] row = new String[model.getColumnCount()];// �� ���� 3���� �����Ǿ� ����
			for (OLecture oLecture : oLectures) {
				row[0] = oLecture.getName();
				row[1] = oLecture.getProfessor();
				row[2] = oLecture.getTime();
				model.addRow(row);
				lecture = oLecture;
				
			}
			return lecture;
		}
		
		this.updateUI();// jtable�� ui�� �ٽ� �׷���
		return null;
	}

}
