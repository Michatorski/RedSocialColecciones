package org.iesfm.redSocial;

import java.lang.reflect.Array;
import java.util.*;

public class SocialNetworkNetwork implements ISocialNetwork {
    private String name;
    private TreeMap<String, User>  users;
    private ArrayList<String > trendingTopics;

    public SocialNetworkNetwork(String name, TreeMap<String, User> users, ArrayList<String> trendingTopics) {
        this.name = name;
        this.users = users;
        this.trendingTopics = trendingTopics;
    }

    @Override
    public TreeSet<Post> getWallPosts(String username) {
       User checkUser = users.get(username);
        if (checkUser == null) {
            System.out.println("Post no encontrado");
        }
        return checkUser.getWall();
    }


    @Override
    public TreeSet<Post> getWallPosts(String username, String tag) {
        User checkUser = users.get(username);

        for (User user: users.values()) {
            if (user.getWall().contains(tag)){

            }
        }

        return checkUser.getWall();
    }

    @Override
    public TreeSet<Post> insertPosts(String user, String tag, String date) {
        return null;
    }

    @Override
    public TreeSet<Post> listPosts(String user) {
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeMap<String, User> getUsers() {
        return users;
    }

    public void setUsers(TreeMap<String, User> users) {
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
        SocialNetworkNetwork socialNetwork = (SocialNetworkNetwork) o;
        return Objects.equals(name, socialNetwork.name) &&
                Objects.equals(users, socialNetwork.users) &&
                Objects.equals(trendingTopics, socialNetwork.trendingTopics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, users, trendingTopics);
    }
}
