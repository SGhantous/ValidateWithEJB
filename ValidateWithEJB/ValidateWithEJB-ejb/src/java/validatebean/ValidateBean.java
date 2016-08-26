/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validatebean;

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
public class ValidateBean implements ValidateBeanLocal {

    @Override
    public boolean validateLogin(String username) {
        
        try 
        {            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            InitialContext ic = new InitialContext();
            DataSource ds;
            ds = (DataSource) ic.lookup("jdbc/Assignment4Pool");
            Connection conn=ds.getConnection();
            
            CallableStatement cstmt = conn.prepareCall("{call userExists(?)}");
            cstmt.setString(1,username);
            ResultSet rs = cstmt.executeQuery();
            rs.next();
            if(rs.getString(1).equals("1"))
            {
                return true;
            }
            
        } 
        catch (ClassNotFoundException | NamingException | InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(ValidateBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
