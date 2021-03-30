package org.iesfm.redSocial;

import org.iesfm.redSocial.exceptions.UserNotFoundException;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class SocialNetworkTest {

   @Test
    public void getWallPostsTetst() throws UserNotFoundException {

       ArrayList<String > trandingTopics = new ArrayList<>();
       trandingTopics.add("Algo");
        HashMap<String, User> users = new HashMap<>();
      TreeSet<Post>posts = new TreeSet<>();
        HashSet<String> tags = new HashSet<>();

       posts.add(  new Post("Jose", "Hola mundo", "2021-03-04", tags));
       posts.add(  new Post("Jose", "Adios mundo", "2021-03-04", tags));


        users.put("Jose", new User("Jose", posts));
        users.put("Pablo", new User("Pablo", posts));


        SocialNetwork socialNetwork = new SocialNetwork("Twat", users, trandingTopics);

       TreeSet<Post> username = socialNetwork.getWallPosts("Jose");


       Set <Post> expectedPost = new TreeSet<>();
       expectedPost.add(new Post("Jose", "Hola mundo", "2021-03-04", tags));
       expectedPost.add(  new Post("Jose", "Adios mundo", "2021-03-04", tags));

       Assert.assertEquals(expectedPost, username);
   }

   @Test(expected = UserNotFoundException.class)
    public void getWallPostsUserNotFoundTetst() throws UserNotFoundException {


       ArrayList<String > trandingTopics = new ArrayList<>();
       trandingTopics.add("Algo");
       HashMap<String, User> users = new HashMap<>();
      TreeSet<Post>posts = new TreeSet<>();
        HashSet<String> tags = new HashSet<>();

       posts.add(  new Post("Jose", "Hola mundo", "2021-03-04", tags));
       posts.add(  new Post("Jose", "Adios mundo", "2021-03-04", tags));


        users.put("Manolo", new User("Jose", posts));
        users.put("Pablo", new User("Pablo", posts));


        SocialNetwork socialNetwork = new SocialNetwork("Twat", users, trandingTopics);

       TreeSet<Post> username = socialNetwork.getWallPosts("Jose");


       Set <Post> expectedPost = new TreeSet<>();
       expectedPost.add(new Post("Jose", "Hola mundo", "2021-03-04", tags));
       expectedPost.add(  new Post("Jose", "Adios mundo", "2021-03-04", tags));

   }



}
