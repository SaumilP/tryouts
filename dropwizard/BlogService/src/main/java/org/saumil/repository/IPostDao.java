package org.saumil.repository;

import org.saumil.models.Post;

/**
 * Created by saumil on 2014/04/25.
 */
public interface IPostDao {
    Post getById(long id);
    Post save(Post post);
}
