/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import artRoom.entities.User;
import artRoom.services.UserServiceRemote;




public class UserSingleton {

	public static User user;
	public static String username;
	public static String password;

	private UserSingleton() {}
		
			

	public static void clearInstance() {
		user = null;
	}

	public static User getInstance() {
		if (user == null) {
			new UserSingleton();
		}
		return user;
	}

	public static void setUsername(String username) {
		UserSingleton.username = username;
	}

	public static void setPassword(String password) {
		UserSingleton.password = password;
	}

}
