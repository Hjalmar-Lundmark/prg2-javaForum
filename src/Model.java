import java.sql.*;
import java.util.Objects;

public class Model {
    private Connection conn = null;
    private String user = dbData.user;
    private String db = dbData.URL;
    private String host = dbData.host;
    private String pwd = dbData.pwd;
    private Statement stmt;
    private String SQLQuery;
    private ResultSet result;
    private boolean loggedIn = false;
    private String username = "";
    private String error = "";

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void connect() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + db + ":3306/" + host + "? "+
                    "allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",user,pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getPosts() {  //maybe change to return result and do while(rslt.next)... in controller?
        String output = "";
        try {
            stmt = conn.createStatement();
            SQLQuery = "SELECT * FROM hl21forum ORDER BY id DESC";
            result = stmt.executeQuery(SQLQuery);

            while (result.next()) {
                output += "Posted by: " + result.getInt("authorId") + "\n" +
                        result.getString("title") + "\n" +
                        result.getString("content") + "\n" +
                        "Posted: " + result.getTimestamp("createdAt") + "\n" + "\n";
            }

            /*//INSERT command
            SQLQuery = "INSERT INTO hl21forum(title,content) VALUES ('"+"HEJ"+"', '"+"brödtext"+"')";
            stmt.executeUpdate(SQLQuery);
            */

            /*//UPDATE
            SQLQuery = "UPDATE hl21forum SET title='"+"Tjena"+"' WHERE id="+2+"";
            stmt.executeUpdate(SQLQuery);
            */

            /*//Full create post in my forum
            SQLQuery = "INSERT INTO hl21forum(title,content,authorId) VALUES ('"+"Java post 2"+"', '"+"Mer innehåll från java"+"', "+2+")";
            stmt.executeUpdate(SQLQuery);
            */

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return output;
    }

    public void login(String u, String pwd) {
        // check login creds, then loggedIn = true
        error = "";
        if (u.length() < 2) {
            //error
            error += "Username is Required \n";
        }
        if (pwd.length() < 2) {
            error += "Password is Required \n";
        }

        if (error.length() < 5) { // if error exists, dont run this
            try {
                System.out.println("please work 2");
                stmt = conn.createStatement();
                SQLQuery = "SELECT * FROM hl21users WHERE name='" + u + "'";
                result = stmt.executeQuery(SQLQuery);

                System.out.println("please work 3");
                System.out.println(result.getString("name") + " och " + u);
                if (u == result.getString("name")) {
                    //bcrypt
                    System.out.println(result.getString("password") + " och " + pwd);
                    if (BCrypt.checkpw(pwd, result.getString("password"))) {
                        loggedIn = true;
                        username = u;
                    }
                }

                stmt.close();
                conn.close();

                System.out.println("Login worked");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(error);
        }
    }

    public void register(String u, String pwd, String pwdCon) {
        error = "";
        if (u.length() < 2) {
            error += "Username is Required \n";
        }
        if (pwd.length() < 2) {
            error += "Password is Required \n";
        }
        if (pwd.equals(pwdCon)) {
            error += "Password and confirmation does not match \n";
        }

        if (error.length() < 5) {
            try {
                stmt = conn.createStatement();
                SQLQuery = "SELECT * FROM hl21users WHERE name=" + u + "";
                result = stmt.executeQuery(SQLQuery);

                if (u == result.getString("name")) {
                    SQLQuery = "INSERT INTO hl21users(name, password) VALUES (" + u + ", " + BCrypt.hashpw(pwd, BCrypt.gensalt()) + ")";
                    result = stmt.executeQuery(SQLQuery);

                    loggedIn = true;
                    username = u;
                }

                stmt.close();
                conn.close();

                System.out.println("Register and login worked");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(error);
        }
    }
}
