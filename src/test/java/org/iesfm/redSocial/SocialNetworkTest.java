package org.iesfm.redSocial;

import org.iesfm.redSocial.exceptions.UserNotFoundException;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class SocialNetworkTest {

   @Test
    public void getWallPostsTetst() throws UserNotFoundException {

        HashMap<String, User> users = new HashMap<>();
       HashMap<String ,Post>posts = new HashMap<>();
        HashSet<String> tags = new HashSet<>();

       posts.put( "Jose", new Post("Jose", "Hola mundo", "2021-03-04", tags));
       posts.put("Pablo",  new Post("Pablo", "Adios mundo", "2021-03-04", tags));


        users.put("Jose", new User("Jose", posts));
        users.put("Pablo", new User("Palo", posts));
        users.put("Manolo", new User("Manolo", posts));


        SocialNetwork socialNetwork = new SocialNetwork("Twat", users, new ArrayList<>());

       HashMap<String ,Post> username = socialNetwork.getWallPosts("Jose");


       Map<String ,Post> expectedPost = new HashMap<>();
       posts.put( "Jose", new Post("Jose", "Hola mundo", "2021-03-04", tags));
       posts.put("Pablo",  new Post("Pablo", "Adios mundo", "2021-03-04", tags));

       Assert.assertEquals(expectedPost, username);
   }


}
