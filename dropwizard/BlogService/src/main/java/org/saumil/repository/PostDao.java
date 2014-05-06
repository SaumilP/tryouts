package org.saumil.repository;

import com.google.inject.persist.Transactional;
import org.saumil.models.Post;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by saumil on 2014/04/25.
 */
public class PostDao implements IPostDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Post getById(long id) {
        return em.find(Post.class, id);
    }

    @Override
    @Transactional
    public Post save(Post post) {
        em.persist(post);
        return post;
    }
}
