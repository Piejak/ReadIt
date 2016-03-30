package com.bpiejak.readit;

/**
 * Created by Brian on 3/22/2016.
 */
public class Post {
    private int upvotes;
    private int downvotes;
    private String op;
    private String link;
    private boolean isUpvoted = false;
    private boolean isDownvoted = false;
    private boolean isSaved = false;

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

    public boolean isUpvoted() {
        return isUpvoted;
    }

    public boolean isDownvoted() {
        return isDownvoted;
    }

    public boolean isSaved() {
        return isSaved;
    }

    public void setUpvoted(boolean upvoted) {
        isUpvoted = upvoted;
    }

    public void setDownvoted(boolean downvoted) {
        isDownvoted = downvoted;
    }

    public void setSaved(boolean saved) {
        isSaved = saved;
    }
}
