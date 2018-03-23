package homework;

public class User {
	private Integer id;
	private String username;
	private String password;
	private String job;
	private String note;

	public User() {

	}
	
	public User(Integer id,String username, String password) {
		super();
		this.id=id;
		this.username = username;
		this.password = password;
	}
	
	public User(Integer id,String username, String password,String job, String note) {
		super();
		this.id=id;
		this.username = username;
		this.password = password;
		this.job = job;
		this.note = note;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
}
