package com.jee.ssh;

import com.jee.ssh.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by ZSt on 2016/2/14.
 */
public class TestCon {

    @Test
    public void test(){

        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();


            // TODO: 2016/2/14

            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if(session!=null) session.getTransaction().rollback();
        } finally {
            HibernateUtil.getSessionFactory().close();
        }
    }
}
