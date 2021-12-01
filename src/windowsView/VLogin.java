package windowsView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import constants.Conflg.FVMainPanel;
import control.CLogin;
import valueObject.OHwewon;
import valueObject.OLogin;

public class VLogin extends JPanel {
	private static final long serialVersionUID = 1L;

	private VMainPanel vMainPanel;
	private JLabel id;
	private JLabel password;
	private JTextField txtID;
	private JTextField txtPassword;// ��ȣȭ�� �ؼ� �����ִ� field
	private JButton LoginButton;
	private JButton HwewonButton;
	private CLogin cLogin;
	private boolean bLoginCheck;

	public VLogin() {
		super();	
		this.setBackground(FVMainPanel.background);
		
		
		this.cLogin = new CLogin();
		this.id = new JLabel("ID: ");
		this.txtID = new JTextField(10);
		this.password = new JLabel("Password:");
		this.txtPassword = new JTextField(10);
		this.LoginButton = new JButton("�α���");
		this.HwewonButton = new JButton("ȸ�����");
		this.add(this.id);
		this.add(this.txtID);
		this.add(this.password);
		this.add(this.txtPassword);
		this.add(this.LoginButton);
		this.add(this.HwewonButton);
		this.vMainPanel = new VMainPanel();
        JScrollPane pane = new JScrollPane(vMainPanel);
		add(pane);
		

		LoginButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                LoginCheck();
	            }
	        });
		HwewonButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	VHwewonDeungrok vHwewondeungrok = new VHwewonDeungrok();	            	
	            }
	            
	        });


	
	}

	
	public void LoginCheck(){
		OLogin oLogin = new OLogin();
		oLogin.setId(txtID.getText());
		oLogin.setPassword(txtPassword.getText());
		OHwewon oHwewon = this.cLogin.validate(oLogin);
		
        if(oHwewon!=null){
            bLoginCheck = true;
           
            // �α��� �����̶�� �Ŵ���â ����
            if(isLogin()){
            	JOptionPane.showMessageDialog(null, "�α��� ����");
            	this.vMainPanel.initialize(oHwewon);
            }                  
        }else{
        	JOptionPane.showMessageDialog(null, "���̵� ��й�ȣ�� Ʋ���ϴ�. �ٽ� �Է����ּ���.");
        }
    }

	  public boolean isLogin() {     
	        return bLoginCheck;
	    }

//	public void initialize() {
//		this.vMainPanel.initialize();
//	}
}
