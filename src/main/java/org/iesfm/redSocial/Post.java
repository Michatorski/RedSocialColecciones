package org.iesfm.redSocial;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class Post {
    private String author;
    private String message;
    private String date;
    private HashSet<String> tag;

    public Post(String author, String message, String date, HashSet<String> tag) {
        this.author = author;
        this.message = message;
        this.date = date;
        this.tag = tag;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public HashSet<String> getTag() {
        return tag;
    }

    public void setTag(HashSet<String> tag) {
        this.tag = tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(author, post.author) &&
                Objects.equals(message, post.message) &&
                Objects.equals(date, post.date) &&
                Objects.equals(tag, post.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, message, date, tag);
    }
}
