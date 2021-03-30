package org.iesfm.redSocial;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class SocialNetworkTest {

    private SocialNetwork socialNetwork;
    private TreeMap<String, User> users;
    private TreeSet<Post> posts;



   @Test
    public void getWallPostsTetst(){
       HashSet<String> tags = new HashSet<>();

       posts.add(new Post("Jose", "Hola mundo", "2021-03-04", tags));
       posts.add(new Post("Pablo", "Adios mundo", "2021-03-04", tags));


        users.put("Jose", new User("Jose", posts));
        users.put("Pablo", new User("Palo", posts));
        users.put("Manolo", new User("Manolo", posts));


        socialNetwork = new SocialNetwork("Twat", users, new ArrayList<>());

        TreeSet<Post> username = socialNetwork.getWallPosts("Jose");


       Set<Post> expectedPost = new TreeSet<>();
       posts.add(new Post("Jose", "Hola mundo", "2021-03-04", tags));
       posts.add(new Post("Pablo", "Adios mundo", "2021-03-04", tags));

       Assert.assertEquals(expectedPost, username);
   }


}
