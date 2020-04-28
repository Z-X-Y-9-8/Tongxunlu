import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = 5612649006026227700L;
	private String no;
//	private String name1;
//	private String mima;
    private String name;
    private int age;
    private String sex;
    private String phone;
    private String imagePath;
	/*public static void main(String[] args){System.out.print("User");} */
	public String getNo() {
		return no;
	}
	public void setNo(String x) {
		no = x;
	}
	public String getName() {
		return name;
	}
//	public String getName1() {
//		return name1;
//	}
//	public void setName1(String name1) {
//		this.name = name1;
//	}
//	public String getmima() {
//		return mima;
//	}
//	public void mima(String mima) {
//		this.name =mima;
//	}
	public void setName(String name) { //构造器name遮蔽对象name
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
    
}
