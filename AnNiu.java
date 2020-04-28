import java.util.List;


public class AnNiu {
    int i;            //下标
    User[] users;              //用户数组，该数组中存User对象
    XieruDuqu proutil;    //对配置文件读取的操作
    /*public static void main(String[] args){System.out.print("AnNiu");}*/  
    
    public AnNiu(){
       i = 0;
        proutil = new XieruDuqu("config/telephone.dat");   //初始化XieruDuqu
	    users = getAllUsers();
	}
	
    /*返回最大用户个数*/
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
