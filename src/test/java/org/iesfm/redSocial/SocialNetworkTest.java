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
       posts.add(  new Post("Jose", "Adios mundo", "2021-03-09", tags));


        users.put("Jose", new User("Jose", posts));
        users.put("Pablo", new User("Pablo", posts));


        SocialNetwork socialNetwork = new SocialNetwork("Twat", users, trandingTopics);

       TreeSet<Post> username = socialNetwork.getWallPosts("Jose");


       Set <Post> expectedPost = new TreeSet<>();
       expectedPost.add(new Post("Jose", "Hola mundo", "2021-03-04", tags));
       expectedPost.add(  new Post("Jose", "Adios mundo", "2021-03-09", tags));

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
       posts.add(  new Post("Jose", "Adios mundo", "2021-03-09", tags));


        users.put("Manolo", new User("Jose", posts));
        users.put("Pablo", new User("Pablo", posts));


        SocialNetwork socialNetwork = new SocialNetwork("Twat", users, trandingTopics);

       TreeSet<Post> username = socialNetwork.getWallPosts("Jose");


       Set <Post> expectedPost = new TreeSet<>();
       expectedPost.add(new Post("Jose", "Hola mundo", "2021-03-04", tags));
       expectedPost.add(  new Post("Jose", "Adios mundo", "2021-03-09", tags));

   }


    @Test
    public void getPostsByUserAndtTagTetst() throws UserNotFoundException {

        ArrayList<String > trandingTopics = new ArrayList<>();
        trandingTopics.add("Algo");
        HashMap<String, User> users = new HashMap<>();
        TreeSet<Post>posts = new TreeSet<>();

        HashSet<String> tagsA = new HashSet<>();
        tagsA.add("Texto");


        posts.add(  new Post("Jose", "Hola mundo", "2021-03-04", tagsA));
        posts.add(  new Post("Jose", "Adios mundo", "2021-03-09", tagsA));
        posts.add(  new Post("Jose", "1-2-3-4-5", "2021-03-04",  new HashSet<>()));


        users.put("Jose", new User("Jose", posts));
        users.put("Pablo", new User("Pablo", posts));


        SocialNetwork socialNetwork = new SocialNetwork("Twat", users, trandingTopics);

        TreeSet<Post> postToFind = socialNetwork.getPostsByUserAndTag("Jose", "Texto" );


        Set <Post> expectedPost = new TreeSet<>();
        expectedPost.add(new Post("Jose", "Hola mundo", "2021-03-04", tagsA));
        expectedPost.add(  new Post("Jose", "Adios mundo", "2021-03-09", tagsA));

        Assert.assertEquals(expectedPost, postToFind);
    }

    @Test
    public void insterPostsTetst() throws UserNotFoundException {

        ArrayList<String > trandingTopics = new ArrayList<>();
        trandingTopics.add("Algo");

        HashMap<String, User> users = new HashMap<>();

        TreeSet<Post>posts = new TreeSet<>();

        HashSet<String> tags = new HashSet<>();

        tags.add("Texto");


        posts.add(  new Post("Jose", "Hola mundo", "2021-03-04", tags));



        users.put("Jose", new User("Jose", posts));


        SocialNetwork socialNetwork = new SocialNetwork("", users, trandingTopics);

        TreeSet<Post> postToMake = socialNetwork.insertPosts( "Jose", "Adios mundo", "2020-01-09", "Texto2");


        Set <Post> expectedPost = new TreeSet<>();
        expectedPost.add(new Post("Jose", "Hola mundo", "2021-03-04", tags));
        expectedPost.add(new Post("Jose", "Adios mundo", "2020-01-09", tags));


        Assert.assertEquals(expectedPost, postToMake);
    }

    @Test
    public void listsPostsTest() throws UserNotFoundException{
        ArrayList<String > trandingTopics = new ArrayList<>();
        trandingTopics.add("Algo");

        HashMap<String, User> users = new HashMap<>();

        TreeSet<Post> posts = new TreeSet<>();

        HashSet<String> tags = new HashSet<>();
        tags.add("Texto");

        posts.add(  new Post("Jose", "Hola mundo", "2021-03-04", tags));
        posts.add(  new Post("Jose", "Adios mundo", "2021-03-05", tags));
        posts.add(  new Post("Jose", "12344", "2021-03-04", tags));
        posts.add(  new Post("Pablo", "Odnum Aloh", "2021-03-04", tags));


        users.put("Jose", new User("Jose", posts));
        users.put("Pablo", new User("Pablo", posts));


        SocialNetwork socialNetwork = new SocialNetwork("Twat", users, trandingTopics);

        ArrayList<Post> username = socialNetwork.listPosts("Jose");


        List <Post> expectedPost = new ArrayList<>();
        expectedPost.add(  new Post("Jose", "Hola mundo", "2021-03-04", tags));
        expectedPost.add(  new Post("Jose", "Adios mundo", "2021-03-05", tags));
        expectedPost.add(  new Post("Jose", "12344", "2021-03-04", tags));

        Assert.assertEquals(expectedPost, username);
    }
}
