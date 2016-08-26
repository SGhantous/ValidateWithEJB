/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminpagehelper;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author 339250
 */
public class AdminPageHelper {
    
    public AdminPageHelper()
    {
        
    }
    
    public String displayTable() throws ClassNotFoundException, NamingException, InstantiationException, IllegalAccessException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        InitialContext ic = new InitialContext();
        DataSource ds;
        ds = (DataSource) ic.lookup("jdbc/Assignment4Pool");
        Connection conn=ds.getConnection();
        
        String tableDisplay = "<table border = 1><tr><th>Username</th><th>Reset</th><th>Delete</th></tr>";
        
        CallableStatement cstmt = conn.prepareCall("{call getAllUsers()}");
        ResultSet rs = cstmt.executeQuery();
        
        while(rs.next())
        {
            tableDisplay+=("<tr>");
                tableDisplay+=("<td>"+rs.getString(1) + "</td>");
                tableDisplay+=("<td><a href='UserOpsServlet?reset="+rs.getString(1) + "'>Reset</a></td>");
                tableDisplay+=("<td><a href='UserOpsServlet?delete=" + rs.getString(1) + "'>Delete</a></td></tr>");
        }
        
        cstmt.close();
        rs.close();
        conn.close();
        return tableDisplay += "</table>";
    }
}
