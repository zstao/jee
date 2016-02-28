package com.jee.ssh.dao;

import com.jee.ssh.model.Pager;
import com.jee.ssh.model.SystemContext;
import com.jee.ssh.model.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ZSt on 2016/2/28.
 */

@Repository("userDao")
public class UserDao extends HibernateDaoSupport implements IUserDao{

    @Resource
    public void setSuperSessionFactory(SessionFactory sessionFactory){
        this.setSessionFactory(sessionFactory);
    }

    @Override
    public void add(User user) {
        this.getHibernateTemplate().save(user);
    }

    @Override
    public void delete(int id) {
        User user = this.load(id);
        this.getHibernateTemplate().delete(user);
    }

    @Override
    public void update(User user) {
        this.getHibernateTemplate().update(user);
    }

    @Override
    public User load(int id) {
        return this.getHibernateTemplate().load(User.class, id);
    }

    @Override
    public List list() {
        return this.getSessionFactory().getCurrentSession().createQuery("from User").list();
    }

    @Override
    public Pager<User> find() {
        int size = SystemContext.getSize();
        int offset = SystemContext.getOffset();
        Query query = this.getSessionFactory().getCurrentSession().createQuery("from User");
        query.setFirstResult(offset).setMaxResults(size);
        List<User> datas = query.list();

        Pager<User> us = new Pager<User>();
        us.setDatas(datas);
        us.setOffset(offset);
        us.setSize(size);

        long total = (Long) this.getSessionFactory().getCurrentSession().createQuery("select count(*) from User").uniqueResult();
        us.setTotal(total);
        return us;
    }
}
