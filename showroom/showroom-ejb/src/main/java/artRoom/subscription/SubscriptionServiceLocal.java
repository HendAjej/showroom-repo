package artRoom.subscription;

import artRoom.entities.GalleryAssistant;
import artRoom.entities.User;

public interface SubscriptionServiceLocal {
	User login(String firstName, String password);
	GalleryAssistant findAssistantByName(String firstName);
}
