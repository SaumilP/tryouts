package org.saumil.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by saumil on 2014/04/25.
 */
@Entity
public class RelatedBlog {
    @Id
    @NotNull
    private Long postId;

    @NotNull
    private Long relatedBlogId;

    private RelatedBlog(long postId, long relatedBlogId ){
        this.postId = postId;
        this.relatedBlogId = relatedBlogId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getRelatedBlogId() {
        return relatedBlogId;
    }

    public void setRelatedBlogId(Long relatedBlogId) {
        this.relatedBlogId = relatedBlogId;
    }
}
