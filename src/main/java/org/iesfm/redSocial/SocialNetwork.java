package org.iesfm.redSocial;

import java.util.*;

public class SocialNetwork implements ISocialNetwork {
    private String name;
    private TreeMap<String, User>  users;
    private ArrayList<String > trendingTopics;

    public SocialNetwork(String name, TreeMap<String, User> users, ArrayList<String> trendingTopics) {
        this.name = name;
        this.users = users;
        this.trendingTopics = trendingTopics;
    }

    @Override
    public TreeSet<Post> getWallPosts(String username) {
       User checkUser = users.get(username);

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
