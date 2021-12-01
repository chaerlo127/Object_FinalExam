package windowsView;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import control.CIndex;
import valueObject.OIndex;

public class VIndex extends JTable {
	private static final long serialVersionUID = 1L;
	// association
	private CIndex cIndex;
	private DefaultTableModel model;
	private JCheckBox jCheckBox;
	private Object[] row;
	private String name;

	//
	public VIndex() {
		super();
		// �׸� �����
		// attributes(���������� ��ȭ���� �ʴ� ��)
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// components
		this.jCheckBox = new JCheckBox();
		this.model = (DefaultTableModel) this.getModel();
		model.addColumn("���¸�");
		// association
	}

	// �ʱ�ȭ�Ǿ��� �� �ʱ�ȭ �Ǵ� ���� ����
	// ������ ���� ���� �� ���� ������ ��(components, association)
	public void initialize() {
		// ������ ä���

		// �̸� �����ϱ� ����, file���� �о�;��� column�� row�� ����ǰ� ���� �� �ִ� ����.
		model.setNumRows(0);// row �ʱ�ȭ

	}

	public String getData(String fileName) {
		this.cIndex = new CIndex();
		Vector<OIndex> oindices = this.cIndex.getAll(fileName);
		OIndex oIndex1 = new OIndex();
		row = new Object[model.getColumnCount()];// �� ���� 3���� �����Ǿ� ����
		for (OIndex oIndex : oindices) {

			row[0] = oIndex.getFileName();
			model.addRow(row);
		}

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					Point point = e.getPoint();
					int column = getSelectedColumn();
					int row = rowAtPoint(point);
					String name = (String) getValueAt(row, column);
					System.out.print(name);
					oIndex1.setFileName(name);
				}
			}

		});
		this.updateUI();// jtable�� ui�� �ٽ� �׷���
		return oIndex1.getFileName();

	}


}
