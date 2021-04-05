package org.iesfm.redSocial;

import org.iesfm.redSocial.exceptions.UserNotFoundException;

import java.util.*;

public class SocialNetwork implements ISocialNetwork {
    private String name;
    private HashMap<String, User>  users;
    private ArrayList<String > trendingTopics;

    public SocialNetwork(String name, HashMap<String, User> users, ArrayList<String> trendingTopics) {
        this.name = name;
        this.users = users;
        this.trendingTopics = trendingTopics;
    }

    @Override
    public TreeSet< Post> getWallPosts(String username) throws UserNotFoundException {
       User checkUser = users.get(username);

       if (checkUser == null){
           throw new UserNotFoundException();
       }

        return checkUser.getWall();
    }


    @Override
    public TreeSet<Post> getPostsByUserAndTag(String username, String tag) throws UserNotFoundException {


        TreeSet<Post> postsOnWall = new TreeSet<>();

       for( Post postOfUser : getWallPosts(username)){
            if (postOfUser.getTag().contains(tag)){
                postsOnWall.add(postOfUser);
            }
       }

        return postsOnWall;
    }

    @Override
    public TreeSet< Post> insertPosts(String  username, String  message, String date, String  tag) throws UserNotFoundException {


        TreeSet<Post> postsOnWall = getWallPosts(username);
        HashSet<String> setTag = new HashSet<>();
        setTag.add(tag);

        postsOnWall.add(new Post(username, message, date, setTag));

        return postsOnWall;
    }

    @Override
    public ArrayList<Post> getListPosts(String username) throws UserNotFoundException {
    ArrayList<Post> allThePosts = new ArrayList<>();

        for(User user : users.values()){
           allThePosts.addAll(user.getAuthorPost(username));
        }
    return allThePosts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, User> getUsers() {
        return users;
    }

    public void setUsers(HashMap<String, User> users) {
        this.users = users;
    }

    public ArrayList<String> getTrendingTopics() {
        return trendingTopics;
    }

    public void setTrendingTopics(ArrayList<String> trendingTopics) {
        this.trendingTopics = trendingTopics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SocialNetwork that = (SocialNetwork) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(users, that.users) &&
                Objects.equals(trendingTopics, that.trendingTopics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, users, trendingTopics);
    }
}
