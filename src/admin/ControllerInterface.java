/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package admin;

/**
 *
 * @author Pieter Pletinckx
 */
public interface ControllerInterface {
    
    public void setApp(Main application);
    public void setUpWithModel(Model model);
    public void setMaster(HomeController homeController);
}
