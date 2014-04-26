package org.saumil.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by saumil on 2014/04/25.
 */
@Entity
public class Comment {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long postId;

    @NotNull
    private long replyToPost;

    @NotEmpty
    private String comment;

    @NotNull
    private Integer userId;

    public Comment(long id, long postId, long replyToPost, String comment, int userId){
        this.id = id;
        this.postId = postId;
        this.replyToPost = replyToPost;
        this.comment = comment;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public long getReplyToPost() {
        return replyToPost;
    }

    public void setReplyToPost(long replyToPost) {
        this.replyToPost = replyToPost;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
