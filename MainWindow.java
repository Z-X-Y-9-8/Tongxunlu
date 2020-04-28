import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class MainWindow extends JFrame implements ActionListener,Runnable{	
	private static final long serialVersionUID = 1L;
	
	
   AnNiu bo;//���ö���
	
	/*�û���Ϣ*/
	JTextField txtNum;//���
	JTextField txtName;//����
	JTextField txtAge ;//����

	JRadioButton rBtnMale;//��
	JRadioButton rBtnFemale;//Ů
	
	JTextField txtTel;//��ϵ��ʽ
	
	JTextField txtPhotoAddr;//��Ƭ·��
	JLabel lblPhotoShow;//��Ƭ
	public JTextField txttime=new JTextField();
	JLabel lbltime; //ʱ��
	
	/*�����ť�������ť*/
        JButton btnFirst;//��һ��
        JButton btnPrevious;//��һ��
        JButton btnNext;//��һ��
        JButton btnLast;//���һ��

        JButton btnAdd ;//���� 	
        JButton btnSave;//����
        JButton btnExit ;//�˳�
        JButton btnAbout ;//����
        JButton btnCx;   //��Ѱ
        JButton btnEt;  //����
        
        JLabel lblSaved;//��ʾ�ѱ���ı�ǩ
        JButton btnPhoto;//���ͼƬ�İ�ť
	
        /*ʱ��*/
        Thread clock;	
    	public String timeInfo="";
    
    	public void start(){ //��ʼ����
    		if (clock==null){ //�������Ϊ��ֵ
    			clock=new Thread(this); //ʵ��������
    			clock.start(); //��ʼ����
    		}
    	}
    	
    	public void run(){  //���н���
    		while (clock!=null){ 
    			 //����paint�����ػ����
    			try{
    				Calendar now=new GregorianCalendar(); //ʵ������������
    				 //�����Ϣ
    				int hour=now.get(Calendar.HOUR_OF_DAY); //�õ�Сʱ��
    				int minute=now.get(Calendar.MINUTE);   //�õ�����
    				int second=now.get(Calendar.SECOND);  //�õ�����
    				
    				if (hour<=9) 
    					timeInfo+="0"+hour+":"; //��ʽ�����
    				else 
    					timeInfo+=hour+":";
    				if (minute<=9)
    					timeInfo+="0"+minute+":";
    				else
    					timeInfo+=minute+":";
    				if (second<=9)
    					timeInfo+="0"+second;
    				else
    					timeInfo+=second;

    				txttime.setText(timeInfo);//���ʱ��
    				
    				
    				timeInfo="";
    				Thread.sleep(1000);  //�߳���ͣһ��(1000����)
    			}
    			catch (InterruptedException ex){
    				ex.printStackTrace();  //���������Ϣ
    			}
    		}	
    	}
    	
    	public void stop(){  //ֹͣ����
    		clock=null;
    	}
    	
    	
    	/*���巽����ʵ��*/
        public MainWindow(){
        start();
        this.setTitle("ͨѶ¼");
		this.setSize(350, 430);
		this.setLocationRelativeTo(null);//���ھ���
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		bo = new AnNiu();
		
		//���
		Container con = this.getContentPane();
		con.setLayout(null);          //���ô������Ĳ��ֹ���
		
		JLabel lblNum = new JLabel("�û����:");
		lblNum.setBounds(20, 20, 60, 25);//��ǩλ��
		con.add(lblNum);
		txtNum = new JTextField();
		txtNum.setBounds(90, 20, 100, 25);//�ı���λ��
		txtNum.setEditable(false);//�û�����ı��򲻿ɱ�
		con.add(txtNum);
		
		JLabel lblName = new JLabel("��        ��:");
		lblName.setBounds(20, 55, 60, 25);
		con.add(lblName);
		txtName = new JTextField();
		txtName.setBounds(90, 55, 100, 25);

		con.add(txtName);
		
		JLabel lblAge = new JLabel("��        ��:");
		lblAge.setBounds(20, 90, 60, 25);
		con.add(lblAge);
		txtAge = new JTextField();
		txtAge.setBounds(90, 90, 50, 25);
		con.add(txtAge);
		
		JLabel lblSex = new JLabel("��        ��:");
		lblSex.setBounds(20, 125, 60, 25);
		con.add(lblSex);	
		rBtnMale = new JRadioButton("��");
		rBtnMale.setBounds(90, 125, 50, 25);
		rBtnMale.setSelected(true);
		con.add(rBtnMale);
		rBtnFemale = new JRadioButton("Ů");
		rBtnFemale.setBounds(150, 125, 50, 25);
		con.add(rBtnFemale);
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(rBtnMale);
		btnGroup.add(rBtnFemale);
		
		JLabel lblTel = new JLabel("��ϵ��ʽ:");
		lblTel.setBounds(20, 160, 60, 25);
		con.add(lblTel);
		txtTel = new JTextField();
		txtTel.setBounds(90, 160, 150, 25);
		con.add(txtTel);
		
		JLabel  lblPhoto = new JLabel("��Ƭ·��:");
		lblPhoto.setBounds(20, 195, 60, 25);
		con.add(lblPhoto);
		txtPhotoAddr = new JTextField();
		txtPhotoAddr.setBounds(90, 195, 150, 25);
		con.add(txtPhotoAddr);
		
		lblPhotoShow = new JLabel("            ��Ƭ");
		lblPhotoShow.setBounds(233, 20, 100, 120);
		lblPhotoShow.setBorder(BorderFactory.createLineBorder(Color.gray));//�߿� ��ɫ
		con.add(lblPhotoShow);
		
		
		//�����ť
		JPanel panelScan = new JPanel();
		panelScan.setBounds(5, 225, 340, 60);
		panelScan.setBorder(BorderFactory.createTitledBorder("  ���"));
		con.add(panelScan);
		
		//������ť��
		JPanel panelOperation = new JPanel();
		panelOperation.setBounds(5, 285, 340, 60);
		panelOperation.setBorder(BorderFactory.createTitledBorder("  ����"));
		con.add(panelOperation);
		
		//�����ť
		JPanel panelcx = new JPanel();
		panelcx.setBounds(5, 345, 340, 60);
		panelcx.setBorder(BorderFactory.createTitledBorder("  ��ѯ"));
		con.add(panelcx);
		
		btnFirst = new JButton("��һ��");
		btnPrevious = new JButton("��һ��");
		btnNext = new JButton("��һ��");
		btnLast = new JButton("��һ��");
		
		panelScan.setLayout(new FlowLayout());
		panelScan.add(btnFirst);
		panelScan.add(btnPrevious);
		panelScan.add(btnNext);
		panelScan.add(btnLast);
		
		btnAdd = new JButton("����(A)");	
		btnAdd.setMnemonic('A');//ALT+A
		btnAdd.setToolTipText("���Ӽ�¼");   
		btnSave = new JButton("����(S)");
		btnSave.setMnemonic('S');
		btnSave.setToolTipText("�����¼");
		
		btnExit = new JButton("�˳�(E)");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setMnemonic('E');
		btnAbout = new JButton("����(H)");
		btnAbout.setMnemonic('H');
		
		btnCx = new JButton("��ѯ(C)");	
		btnEt= new JButton("����(B)");
		btnEt.setMnemonic('B');
	    panelcx.add(btnCx);
	    panelcx.add(btnEt);
	    
	    JLabel  lbltime = new JLabel("��ǰʱ��:");
		//lblPhoto.setBounds(20, 195, 60, 25);
		panelcx.add(lbltime);
    	   panelcx.add(txttime);
    	   panelOperation.setLayout(new FlowLayout());
           panelOperation.add(btnAdd);
           panelOperation.add(btnSave);
           panelOperation.add(btnExit);
           panelOperation.add(btnAbout);
    	   
	  
           /****************�����Ѱ��*************/
           
        btnCx.addActionListener(new ActionListener() {
			public void actionPerformed( ActionEvent e) {
				setVisible(false);
			new chaxun();
			}
			});
		
               
               
                /*����,����*/
	    btnFirst.addActionListener(this);
		btnPrevious.addActionListener(this);
		btnNext.addActionListener(this);
		btnLast.addActionListener(this);
		
		btnAdd.addActionListener(this);
		btnSave.addActionListener(this);
		btnAbout.addActionListener(this);
		btnEt.addActionListener(this);
		txttime.addActionListener(this);
		
		/*����ʱ��ʾ��һ��*/
		displayUserInfo(bo.first());
	        
		//����ɹ���ť
		
		lblSaved = new JLabel();
		lblSaved.setBounds(249, 163, 66, 18);
		con.add(lblSaved);

		btnPhoto = new JButton("���");                  //�������ѡ���
		btnPhoto.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		JFileChooser fileChooser = new JFileChooser();   //����һ���ļ�ѡ�����Ի���
		if(fileChooser.showOpenDialog(null) == 0){
        File selectedFile = fileChooser.getSelectedFile(); //����ѡ���ļ�·��
        lblPhotoShow.setIcon(new ImageIcon(selectedFile.getAbsolutePath()));
        txtPhotoAddr.setText(selectedFile.getAbsolutePath());
				}
			}
		});
		btnPhoto.setBounds(246, 193, 74, 28);
		con.add(btnPhoto);
		
        this.setVisible(true); //�ɼ�
	}
	
//	
//	public static void main(String[] args){
//		new MainWindow();
//		
//	}
//	

	/*��ʾ�û���Ϣ*/
	public  void displayUserInfo(User user){
                txtNum.setText(user.getNo());
                txtName.setText(user.getName());
               
                txtAge.setText(user.getAge()+"");
                if(user.getSex().equals("M")){
                        rBtnMale.setSelected(true);
                }else if(user.getSex().equals("F")){
                        rBtnFemale.setSelected(true);
                }
                txtTel.setText(user.getPhone());
                txtPhotoAddr.setText(user.getImagePath());
                lblPhotoShow.setIcon(new ImageIcon(user.getImagePath()));
	}

	
	/* ��ť��ʵ��*/
	public void actionPerformed(ActionEvent e) {
		lblSaved.setText("");		                //�����ť��ʵ��
		if(e.getSource() == btnFirst){	
				displayUserInfo(bo.first());
		}else if(e.getSource() == btnPrevious){
			displayUserInfo(bo.previous());
		}else if(e.getSource() == btnNext){
			displayUserInfo(bo.next());
		}else if(e.getSource() == btnLast){
			displayUserInfo(bo.last());
			
		}else if(e.getSource() == btnAdd){          //��Ӱ�ť��ʵ��
			txtNum.setText(""+(bo.users.length+1));
			txtName.setText("");
			txtAge.setText("");
			rBtnMale.setSelected(true);
			txtTel.setText("");
			txtPhotoAddr.setText("");
			lblPhotoShow.setIcon(null);
			
		}else if(e.getSource() == btnSave){         //���水ť��ʵ��
			if(txtNum.getText() != null){		
           User u =  new User();
           u.setNo(txtNum.getText());
           u.setName(txtName.getText());
           u.setAge( Integer.parseInt(txtAge.getText()));//����ʲô��
           if(rBtnMale.isSelected()){
           u.setSex("M");
           }else{
         u.setSex("F");
                 }
          u.setPhone(txtTel.getText());                                
          u.setImagePath(txtPhotoAddr.getText());                            
          bo.saveUser(u);
         lblSaved.setText("����ɹ�");
			}
		}else if(e.getSource() == btnAbout){
			JOptionPane.showMessageDialog(this," ͨѶ¼JXIN1.0","�汾��",
				JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getSource() == btnEt){
			JOptionPane.showMessageDialog(this," ������ѯ�����ѯ���棬���������Բ鿴�û�ͷ��...","����",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	}
