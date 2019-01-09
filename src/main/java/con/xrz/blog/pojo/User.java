package con.xrz.blog.pojo;

public class User {
    private Integer id;
    private String name;
    private String password;
    private int level;
    private String email;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.level=level;
    }

    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

    public User(Integer id, String name,String password,int level,String email){
        this.id = id;
        this.name = name;
        this.password = password;
        this.level = level;
        this.email = email;
    }

    public User(User user){
        this.id = user.id;
        this.name = user.name;
        this.password = user.password;
        this.level = user.level;
        this.email = user.email;

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLevel() {
        return String.valueOf(level);
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
