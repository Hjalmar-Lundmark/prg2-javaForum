import java.sql.*;
import java.util.Objects;

public class Model {
    Connection conn = null;
    String user = dbData.user;
    String db = dbData.URL;
    String host = dbData.host;
    String pwd = dbData.pwd;
    Statement stmt;
    String SQLQuery;
    ResultSet result;
    boolean loggedIn = false;

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

            /*ResultSetMetaData metadata = result.getMetaData();
            int numCols = metadata.getColumnCount();
            for (int i = 1 ; i <= numCols ; i++) {
                System.out.println(metadata.getColumnClassName(i));
            }*/

            /*
            while (result.next()) {
                String output = "";
                output += result.getInt("id") + ", " +
                        result.getString("title") + ", " +
                        result.getString("content") + ", " +
                        result.getTimestamp("createdAt") + ", " +
                        result.getInt("authorId");
                System.out.println(output);
            }
            */

            while (result.next()) {
                /*output += result.getInt("id") + ", " +
                        result.getString("title") + ", " +
                        result.getString("content") + ", " +
                        result.getTimestamp("createdAt") + ", " +
                        result.getInt("authorId") + "\n" + "\n";*/
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
        if (Objects.equals(u, "")) {
            //error

        }
        if (Objects.equals(pwd, "")) {
            //error

        }

        try {
            stmt = conn.createStatement();
            SQLQuery = "SELECT * FROM hl21users WHERE name=" + u + "";
            result = stmt.executeQuery(SQLQuery);

            if (u == result.getString("name")) {
                //bcrypt
                if (/*crypted pwd == pwdInDB */) {
                   loggedIn = true;
                }
            }



            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
