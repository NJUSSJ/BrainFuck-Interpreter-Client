package application;

public class User {

	private String username;
	private String password;
	private String promptFile;
	public String[] file_list;
	public String prompt_code;

	public User(String username) {
		// TODO 自动生成的构造函数存根
		this.username=username;
	}

	public void setUsername(String username){
		this.username=username;
	}

	public String getUsername(){
		return username;
	}

	public void setPassword(String password){
		this.password=password;
	}

	public String getPassword(){
		return password;
	}

	public String getPomptFile(){
		return promptFile;
	}

	public void setPrompt(String prompt){
		this.promptFile=prompt;
	}
	public String[] getList(){
		return file_list;
	}

	public void setList(String [] file_list){
		this.file_list=file_list;
	}

	public String getCode(){
		return prompt_code;
	}
	
	public void setCode(String code){
		this.prompt_code=code;
	}
}
