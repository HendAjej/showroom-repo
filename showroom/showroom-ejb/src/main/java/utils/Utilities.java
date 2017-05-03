package utils;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import artRoom.entities.Admin;
import artRoom.entities.Artist;
import artRoom.entities.Artwork;
import artRoom.entities.Gallery;
import artRoom.entities.GalleryAssistant;
import artRoom.entities.User;
import artRoom.services.UserServiceLocal;
/**
 * Session Bean implementation class Utilities
 */
@Singleton
@LocalBean
@Startup
public class Utilities {
	@EJB
	private UserServiceLocal userServiceLocal;;

	/**
	 * Default constructor.
	 */
	public Utilities() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void initDB() {
		long x=234566444;
		long y=21453465;
		long z=34565345;
		long r=54676765;
		long l=22222222;
		long m=54677865;

		User user= new User("a", "j", "a.j@ht.fr","tunis","azerty", "Client",x,false);
		User user1= new User("b","b","b","b","b",y , false,"Admin");
		User user2= new User("c","c","c","c","c",z, false,"GalleryOwner" );
		Artist artist1 = new Artist("art","ist","h","h","h",l, false,"Artist" );
		GalleryAssistant assist1 = new GalleryAssistant("assi","gallery","g","g","g",m, false,"GalleryOwner" );
       // Gallery gallerie1= new Gallery (1, "bizerte");
        Admin admin1= new Admin("amira","rached","projet.lartistou@gmail.com","amiraa","bizerte","Admin",r);
        userServiceLocal.addUser(user);
		userServiceLocal.addUser(user1);
		userServiceLocal.addUser(user2);
		userServiceLocal.addUser(admin1);
		userServiceLocal.addUser(artist1);
		userServiceLocal.addUser(assist1);



}
}
