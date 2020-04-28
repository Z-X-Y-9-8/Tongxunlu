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
	
	
   AnNiu bo;//引用对象
	
	/*用户信息*/
	JTextField txtNum;//编号
	JTextField txtName;//姓名
	JTextField txtAge ;//年龄

	JRadioButton rBtnMale;//男
	JRadioButton rBtnFemale;//女
	
	JTextField txtTel;//联系方式
	
	JTextField txtPhotoAddr;//照片路径
	JLabel lblPhotoShow;//照片
	public JTextField txttime=new JTextField();
	JLabel lbltime; //时间
	
	/*浏览按钮与操作按钮*/
        JButton btnFirst;//第一条
        JButton btnPrevious;//上一条
        JButton btnNext;//下一条
        JButton btnLast;//最后一条

        JButton btnAdd ;//增加 	
        JButton btnSave;//保存
        JButton btnExit ;//退出
        JButton btnAbout ;//关于
        JButton btnCx;   //查寻
        JButton btnEt;  //帮助
        
        JLabel lblSaved;//提示已保存的标签
        JButton btnPhoto;//浏览图片的按钮
	
        /*时间*/
        Thread clock;	
    	public String timeInfo="";
    
    	public void start(){ //开始进程
    		if (clock==null){ //如果进程为空值
    			clock=new Thread(this); //实例化进程
    			clock.start(); //开始进程
    		}
    	}
    	
    	public void run(){  //运行进程
    		while (clock!=null){ 
    			 //调用paint方法重绘界面
    			try{
    				Calendar now=new GregorianCalendar(); //实例化日历对象
    				 //输出信息
    				int hour=now.get(Calendar.HOUR_OF_DAY); //得到小时数
    				int minute=now.get(Calendar.MINUTE);   //得到分数
    				int second=now.get(Calendar.SECOND);  //得到秒数
    				
    				if (hour<=9) 
    					timeInfo+="0"+hour+":"; //格式化输出
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

    				txttime.setText(timeInfo);//输出时间
    				
    				
    				timeInfo="";
    				Thread.sleep(1000);  //线程暂停一秒(1000毫秒)
    			}
    			catch (InterruptedException ex){
    				ex.printStackTrace();  //输出出错信息
    			}
    		}	
    	}
    	
    	public void stop(){  //停止进程
    		clock=null;
    	}
    	
    	
    	/*窗体方法的实现*/
        public MainWindow(){
        start();
        this.setTitle("通讯录");
		this.setSize(350, 430);
		this.setLocationRelativeTo(null);//窗口居中
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		bo = new AnNiu();
		
		//面板
		Container con = this.getContentPane();
		con.setLayout(null);          //设置此容器的布局管理
		
		JLabel lblNum = new JLabel("用户编号:");
		lblNum.setBounds(20, 20, 60, 25);//标签位置
		con.add(lblNum);
		txtNum = new JTextField();
		txtNum.setBounds(90, 20, 100, 25);//文本框位置
		txtNum.setEditable(false);//用户编号文本框不可变
		con.add(txtNum);
		
		JLabel lblName = new JLabel("姓        名:");
		lblName.setBounds(20, 55, 60, 25);
		con.add(lblName);
		txtName = new JTextField();
		txtName.setBounds(90, 55, 100, 25);

		con.add(txtName);
		
		JLabel lblAge = new JLabel("年        龄:");
		lblAge.setBounds(20, 90, 60, 25);
		con.add(lblAge);
		txtAge = new JTextField();
		txtAge.setBounds(90, 90, 50, 25);
		con.add(txtAge);
		
		JLabel lblSex = new JLabel("性        别:");
		lblSex.setBounds(20, 125, 60, 25);
		con.add(lblSex);	
		rBtnMale = new JRadioButton("男");
		rBtnMale.setBounds(90, 125, 50, 25);
		rBtnMale.setSelected(true);
		con.add(rBtnMale);
		rBtnFemale = new JRadioButton("女");
		rBtnFemale.setBounds(150, 125, 50, 25);
		con.add(rBtnFemale);
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(rBtnMale);
		btnGroup.add(rBtnFemale);
		
		JLabel lblTel = new JLabel("联系方式:");
		lblTel.setBounds(20, 160, 60, 25);
		con.add(lblTel);
		txtTel = new JTextField();
		txtTel.setBounds(90, 160, 150, 25);
		con.add(txtTel);
		
		JLabel  lblPhoto = new JLabel("照片路径:");
		lblPhoto.setBounds(20, 195, 60, 25);
		con.add(lblPhoto);
		txtPhotoAddr = new JTextField();
		txtPhotoAddr.setBounds(90, 195, 150, 25);
		con.add(txtPhotoAddr);
		
		lblPhotoShow = new JLabel("            照片");
		lblPhotoShow.setBounds(233, 20, 100, 120);
		lblPhotoShow.setBorder(BorderFactory.createLineBorder(Color.gray));//边框 灰色
		con.add(lblPhotoShow);
		
		
		//浏览按钮
		JPanel panelScan = new JPanel();
		panelScan.setBounds(5, 225, 340, 60);
		panelScan.setBorder(BorderFactory.createTitledBorder("  浏览"));
		con.add(panelScan);
		
		//操作按钮区
		JPanel panelOperation = new JPanel();
		panelOperation.setBounds(5, 285, 340, 60);
		panelOperation.setBorder(BorderFactory.createTitledBorder("  操作"));
		con.add(panelOperation);
		
		//浏览按钮
		JPanel panelcx = new JPanel();
		panelcx.setBounds(5, 345, 340, 60);
		panelcx.setBorder(BorderFactory.createTitledBorder("  查询"));
		con.add(panelcx);
		
		btnFirst = new JButton("第一条");
		btnPrevious = new JButton("上一条");
		btnNext = new JButton("下一条");
		btnLast = new JButton("后一条");
		
		panelScan.setLayout(new FlowLayout());
		panelScan.add(btnFirst);
		panelScan.add(btnPrevious);
		panelScan.add(btnNext);
		panelScan.add(btnLast);
		
		btnAdd = new JButton("新增(A)");	
		btnAdd.setMnemonic('A');//ALT+A
		btnAdd.setToolTipText("增加记录");   
		btnSave = new JButton("保存(S)");
		btnSave.setMnemonic('S');
		btnSave.setToolTipText("保存记录");
		
		btnExit = new JButton("退出(E)");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setMnemonic('E');
		btnAbout = new JButton("关于(H)");
		btnAbout.setMnemonic('H');
		
		btnCx = new JButton("查询(C)");	
		btnEt= new JButton("帮助(B)");
		btnEt.setMnemonic('B');
	    panelcx.add(btnCx);
	    panelcx.add(btnEt);
	    
	    JLabel  lbltime = new JLabel("当前时间:");
		//lblPhoto.setBounds(20, 195, 60, 25);
		panelcx.add(lbltime);
    	   panelcx.add(txttime);
    	   panelOperation.setLayout(new FlowLayout());
           panelOperation.add(btnAdd);
           panelOperation.add(btnSave);
           panelOperation.add(btnExit);
           panelOperation.add(btnAbout);
    	   
	  
           /****************进入查寻中*************/
           
        btnCx.addActionListener(new ActionListener() {
			public void actionPerformed( ActionEvent e) {
				setVisible(false);
			new chaxun();
			}
			});
		
               
               
                /*监听,激发*/
	    btnFirst.addActionListener(this);
		btnPrevious.addActionListener(this);
		btnNext.addActionListener(this);
		btnLast.addActionListener(this);
		
		btnAdd.addActionListener(this);
		btnSave.addActionListener(this);
		btnAbout.addActionListener(this);
		btnEt.addActionListener(this);
		txttime.addActionListener(this);
		
		/*启动时显示第一条*/
		displayUserInfo(bo.first());
	        
		//保存成功按钮
		
		lblSaved = new JLabel();
		lblSaved.setBounds(249, 163, 66, 18);
		con.add(lblSaved);

		btnPhoto = new JButton("浏览");                  //点浏览打开选择框
		btnPhoto.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		JFileChooser fileChooser = new JFileChooser();   //弹出一个文件选择器对话框
		if(fileChooser.showOpenDialog(null) == 0){
        File selectedFile = fileChooser.getSelectedFile(); //返回选中文件路径
        lblPhotoShow.setIcon(new ImageIcon(selectedFile.getAbsolutePath()));
        txtPhotoAddr.setText(selectedFile.getAbsolutePath());
				}
			}
		});
		btnPhoto.setBounds(246, 193, 74, 28);
		con.add(btnPhoto);
		
        this.setVisible(true); //可见
	}
	
//	
//	public static void main(String[] args){
//		new MainWindow();
//		
//	}
//	

	/*显示用户信息*/
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

	
	/* 按钮的实现*/
	public void actionPerformed(ActionEvent e) {
		lblSaved.setText("");		                //浏览按钮的实现
		if(e.getSource() == btnFirst){	
				displayUserInfo(bo.first());
		}else if(e.getSource() == btnPrevious){
			displayUserInfo(bo.previous());
		}else if(e.getSource() == btnNext){
			displayUserInfo(bo.next());
		}else if(e.getSource() == btnLast){
			displayUserInfo(bo.last());
			
		}else if(e.getSource() == btnAdd){          //添加按钮的实现
			txtNum.setText(""+(bo.users.length+1));
			txtName.setText("");
			txtAge.setText("");
			rBtnMale.setSelected(true);
			txtTel.setText("");
			txtPhotoAddr.setText("");
			lblPhotoShow.setIcon(null);
			
		}else if(e.getSource() == btnSave){         //保存按钮的实现
			if(txtNum.getText() != null){		
           User u =  new User();
           u.setNo(txtNum.getText());
           u.setName(txtName.getText());
           u.setAge( Integer.parseInt(txtAge.getText()));//不管什么符
           if(rBtnMale.isSelected()){
           u.setSex("M");
           }else{
         u.setSex("F");
                 }
          u.setPhone(txtTel.getText());                                
          u.setImagePath(txtPhotoAddr.getText());                            
          bo.saveUser(u);
         lblSaved.setText("保存成功");
			}
		}else if(e.getSource() == btnAbout){
			JOptionPane.showMessageDialog(this," 通讯录JXIN1.0","版本号",
				JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getSource() == btnEt){
			JOptionPane.showMessageDialog(this," 单击查询进入查询界面，点击浏览可以查看用户头像...","帮助",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	}
