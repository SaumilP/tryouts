package org.saumil.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by saumil on 2014/04/25.
 */
@Entity
public class Post {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 144)
    private String title;

    @NotEmpty
    private String article;

    @Size(min = 2, max = 200)
    private String titleClean;

    @Size(min = 2, max = 45)
    private String file;

    @NotNull
    private long authorId;

    @NotNull
    private Date publishDate;

    @Size(min = 2, max = 50)
    private String bannerImage;

    @NotNull
    private Boolean featured;

    @NotNull
    private Boolean enabled;

    @NotNull
    private Boolean commentsEnabled;

    private Long totalViews;

    @NotNull
    private Date createDate;

    public Post(long id, String title, String article, String titleClean,
                String file, long authorId, Date publishDate,
                String bannerImage, boolean featured, boolean enabled,
                boolean commentsEnabled, long totalViews, Date createDate){
        this.id = id;
        this.title = title;
        this.article = article;
        this.titleClean = titleClean;
        this.file = file;
        this.authorId = authorId;
        this.publishDate =publishDate;
        this.featured = featured;
        this.bannerImage = bannerImage;
        this.enabled = enabled;
        this.commentsEnabled = commentsEnabled;
        this.totalViews =totalViews;
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getTitleClean() {
        return titleClean;
    }

    public void setTitleClean(String titleClean) {
        this.titleClean = titleClean;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getBannerImage() {
        return bannerImage;
    }

    public void setBannerImage(String bannerImage) {
        this.bannerImage = bannerImage;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getCommentsEnabled() {
        return commentsEnabled;
    }

    public void setCommentsEnabled(Boolean commentsEnabled) {
        this.commentsEnabled = commentsEnabled;
    }

    public Long getTotalViews() {
        return totalViews;
    }

    public void setTotalViews(Long totalViews) {
        this.totalViews = totalViews;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
