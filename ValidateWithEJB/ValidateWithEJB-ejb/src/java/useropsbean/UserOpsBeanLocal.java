/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package useropsbean;

import javax.ejb.Local;

/**
 *
 * @author 339250
 */
@Local
public interface UserOpsBeanLocal {
    
    void resetPassword(String username);
    void deleteUser(String username);    
}
