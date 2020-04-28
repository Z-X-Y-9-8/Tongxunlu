import java.util.List;


public class AnNiu {
    int i;            //�±�
    User[] users;              //�û����飬�������д�User����
    XieruDuqu proutil;    //�������ļ���ȡ�Ĳ���
    /*public static void main(String[] args){System.out.print("AnNiu");}*/  
    
    public AnNiu(){
       i = 0;
        proutil = new XieruDuqu("config/telephone.dat");   //��ʼ��XieruDuqu
	    users = getAllUsers();
	}
	
    /*��������û�����*/
	public User[] getAllUsers() {        
		List <User> list = proutil.getUsers();
		User[] users2 = new User[list.size()];
		for(int i =0;i<list.size();i++){
			users2[i]=list.get(i);
		}
		return users2;
	}

	
	public User first() {
		i =0;
		return users[i];
	}


	public User previous() {
		if(i >0){
			i --;
		}
		return users[i];
	}


	public User next() {
		if(i < users.length - 1){
			i ++;
		}
		return users[i];
	}


	public User last() {
		i = users.length - 1;
		return users[i];
	}


	public void saveUser(User user) {
		proutil.save(user);
		users = getAllUsers();
		i = Integer.parseInt(user.getNo()) - 1;
	}
    
    
}
