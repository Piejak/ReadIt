package com.bpiejak.readit;

/**
 * Created by Brian on 3/22/2016.
 */
public class Post {
    private int upvotes;
    private int downvotes;
    private String op;
    private String link;

    public Post(int upvotes, int downvotes, String op, String link) {
        this.upvotes = upvotes;
        this.downvotes = downvotes;
        this.op = op;
        this.link = link;
    }

    public Post() {
        this(0, 0, null, null);
    }

    public int getUpvotes() {
        return upvotes;
    }

    public int getDownvotes() {
        return downvotes;
    }

    public String getOp() {
        return op;
    }

    public String getLink() {
        return link;
    }
}
