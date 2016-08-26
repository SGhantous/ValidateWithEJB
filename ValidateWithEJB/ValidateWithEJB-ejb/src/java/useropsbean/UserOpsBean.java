/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package useropsbean;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author 339250
 */
@Stateless
public class UserOpsBean implements UserOpsBeanLocal {

    @Override
    public void resetPassword(String username) {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            InitialContext ic = new InitialContext();
            DataSource ds;
            ds = (DataSource) ic.lookup("jdbc/Assignment4Pool");
            Connection conn=ds.getConnection();
            
            CallableStatement cstmt = conn.prepareCall("{call resetPassword(?)}");
            cstmt.setString(1,username);
            
            ResultSet rs = cstmt.executeQuery();
            
        } 
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NamingException | SQLException ex) {
            Logger.getLogger(UserOpsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteUser(String username) {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            InitialContext ic = new InitialContext();
            DataSource ds;
            ds = (DataSource) ic.lookup("jdbc/Assignment4Pool");
            Connection conn=ds.getConnection();
            
            CallableStatement cstmt = conn.prepareCall("{call deleteUser(?)}");
            cstmt.setString(1,username);
            
            ResultSet rs = cstmt.executeQuery();
        } 
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NamingException | SQLException ex) {
            Logger.getLogger(UserOpsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
