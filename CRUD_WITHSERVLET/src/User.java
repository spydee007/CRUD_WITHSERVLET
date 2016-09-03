
public class User {
	private int id;
	private String name , address  , emailid , pass;
	
	public void setId(int id){
		this.id = id;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public void setEmail(String emailid){
		this.emailid = emailid;
	}
	
	public void setPass(String pass){
		this.pass = pass;
	}
	
	public int getId(){
		return id;	
	}
	public String getName(){
		return name;
	}
	public String getAddress(){
		return address;
	}
	public String getEmail(){
		return emailid;
	}
	public String getPass(){
		return pass;
	}

}
