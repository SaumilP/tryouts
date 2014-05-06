package org.saumil.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by saumil on 2014/04/25.
 */
@Entity
public class Tag {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 45, min = 0)
    private String tag;

    @Size(max= 45)
    private String tagClean;

    public Tag(long id, String  tag, String tagClean){
        this.id = id;
        this.tag = tag;
        this.tagClean = tagClean;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTagClean() {
        return tagClean;
    }

    public void setTagClean(String tagClean) {
        this.tagClean = tagClean;
    }
}
