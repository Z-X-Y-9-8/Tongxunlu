import java.io.File;
import java.io.FileInputStream;//读取数据的原始字节流
import java.io.FileNotFoundException;//文件失败时引发的异常
import java.io.FileOutputStream;//FileOutputStream用于向一个文本文件写数据.用于写入诸如图像数据之类的原始字节的流
import java.io.IOException;//发生I/O 错误时引发的异常
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/*主要功能:1.文件的读取
          2.文件的写入
          3文件不存在时创建  */

public class XieruDuqu {         
	private ObjectInputStream ois = null;     //基本数据读出
	private ObjectOutputStream oos = null;     //基本数据写入
	private List<User> lstUsers = new ArrayList<User>();
	private String fileName = null;
	
	/*public static void main(String[] args){System.out.print("XieruDuqu");} */
	
	public XieruDuqu(String fileName){
			this.fileName = fileName; 
	}
	
	@SuppressWarnings("unchecked")  //屏蔽某些编译时的警告信息 在强制类型转换的时候编译器会给出警告 加上@SuppressWarnings("unchecked")就不会警告了
	public  List<User> getUsers(){
		try {
			  ois = new ObjectInputStream(new FileInputStream(fileName));		//将用户信息读取
			  lstUsers =  (ArrayList<User>)ois.readObject();
			  ois.close();
		   }catch(FileNotFoundException e){
			   intRecord();
		  } catch (ClassNotFoundException e) {
			e.printStackTrace();
		  } catch (IOException e) {
			e.printStackTrace();		
		  }
		 return lstUsers;
   }
	                                                                               //将用户信息写入
	public void save(User user){
		try {
			oos = new ObjectOutputStream(new FileOutputStream("config/telephone.dat"));
			int i;
			for( i = 0;i < lstUsers.size();i++){
//				if(user.getNo().equals(lstUsers.get(i).getNo())){
//					lstUsers.set(i, user);//修改
//					break;
//				}
			}
			if(i >= lstUsers.size()){
			    lstUsers.add(user);//新增
			}
			oos.writeObject(lstUsers);
			oos.flush();
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/* 若telephone文件不存在,则初始化记录文件*/
	private void intRecord(){
		//创建文件
		File f = new File("config/telephone.dat");
		try {
			f.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//新建一条记录
		User u = new User();
		u.setNo("1");
		u.setName("输入用户名");
		u.setAge(0);
		u.setSex("M");
		u.setPhone("请输入电话号码");
		u.setImagePath("输入图片路径");
		try {
			oos = new ObjectOutputStream(new FileOutputStream("config/telephone.dat"));
			lstUsers.add(u);
			oos.writeObject(lstUsers);
			oos.close();

            JOptionPane.showMessageDialog(null, "请重启本程序");
            System.exit(0);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
