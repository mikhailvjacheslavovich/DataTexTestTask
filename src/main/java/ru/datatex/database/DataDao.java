package ru.datatex.database;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.datatex.model.Disk;
import ru.datatex.model.Users;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class DataDao {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public List<Users> getAllUsers() {
        List<Users> users = new ArrayList<Users>();
        try {
            Session session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(Users.class);
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            users = criteria.list();

            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return users;
    }

    //getFreeDisks
    @Transactional
    public List<Disk> getFreeDisks(Long id) {
        List<Disk> disks = new ArrayList<Disk>();
        try {
            Session session = sessionFactory.openSession();
            Criteria crit = session.createCriteria(Disk.class);
            crit.createAlias("users", "us");
            crit.add(Restrictions.eq("us.id", new Long(4)));
            crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            disks = (List<Disk>) crit.list();

            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return disks;
    }

    @Transactional
    public void addDisk(String title, String rating, String description) {
        try {
            Session session = sessionFactory.openSession();

            Criteria cr = session.createCriteria(Users.class);
            cr.add(Restrictions.eq("id",new Long(4)));
            Set<Users> lst = new HashSet<Users>();
            Users us  = (Users) cr.uniqueResult();
            lst.add(us);
            session.beginTransaction();
            session.saveOrUpdate(new Disk(new Long(1), title, rating, description, lst));
            session.getTransaction().commit();

            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Transactional
    public void rentDisk(Long diskId, Long userId) {
        Session session = sessionFactory.openSession();
        try {

            Criteria crit = session.createCriteria(Disk.class);
            crit.add(Restrictions.eq("id", diskId));
            Disk disk = (Disk) crit.uniqueResult();
            Criteria cr = session.createCriteria(Users.class);
            cr.add(Restrictions.eq("id", userId));
            Users user = (Users) cr.uniqueResult();
            session.beginTransaction();

            disk.getUsers().clear();
            disk.getUsers().add(user);

            session.saveOrUpdate(disk);
            session.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        session.close();
    }

    @Transactional
    public void returnDisk(Long diskId, Long userId) {
        Session session = sessionFactory.openSession();
        try{
            Criteria crit = session.createCriteria(Disk.class);
            crit.add(Restrictions.eq("id", diskId));
            Disk disk = (Disk) crit.uniqueResult();
            Criteria cr = session.createCriteria(Users.class);
            cr.add(Restrictions.eq("id", new Long(4)));
            Users user = (Users) cr.uniqueResult();

            disk.getUsers().clear();
            disk.getUsers().add(user);

            session.beginTransaction();
            session.saveOrUpdate(disk);
            session.getTransaction().commit();

        }catch (Exception ex){
            ex.printStackTrace();
        }
        session.close();
    }

    @Transactional
    public List<Disk> getTakenDisk(Long id) {
        List<Disk> disks = new ArrayList<Disk>();
        try {
            Session session = sessionFactory.openSession();

            Criteria crit = session.createCriteria(Disk.class);
            crit.createAlias("users", "us");
            crit.add(Restrictions.eq("us.id", id));
            crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            disks = (List<Disk>) crit.list();
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return disks;
    }

    @Transactional
    public List<Disk> getGivenDisks(Long id) {
        List<Disk> disks = new ArrayList<Disk>();
        try {
            Session session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(Disk.class);
            criteria.add(Restrictions.eq("owner", id));
            criteria.createAlias("users", "us");
            criteria.add(Restrictions.ne("us.id", new Long(4)));
            criteria.add(Restrictions.ne("us.id", new Long(1)));
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            disks = (List<Disk>) criteria.list();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return disks;
    }

}
