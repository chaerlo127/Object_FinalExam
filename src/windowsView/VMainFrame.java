package windowsView;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import constants.Conflg.FVMainFrame;

public class VMainFrame extends JFrame {
	//�� ȭ�鿡 Ȯ��
	
	//attribute
	private static final long serialVersionUID = 1L;

	//������ ���¸� ��Ÿ���� ��ȣ , update
	
	//conponents
	
	private VLogin vLogin;
	public VMainFrame(){
		super();
		
		//attributes
		this.setLocation(FVMainFrame.location);
		this.setSize(FVMainFrame.size);//code�� �������� �ʰ� constant�� ���� �����Ѵ�. 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//components
		this.vLogin = new VLogin();
		JScrollPane pane = new JScrollPane(this.vLogin);
		this.add(pane);
	}
	private void initialize() {
		//variable attributes(���ϴ� �Ӽ� ��)
		
		//components initialize
//		this.vLogin.initialize();
	}
	public static void main(String[] args) {//�ֻ��� class
		VMainFrame vMain = new VMainFrame();
		vMain.initialize();
		vMain.setVisible(true);
	}


	}
	
