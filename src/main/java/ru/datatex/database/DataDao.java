package ru.datatex.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.datatex.model.Users;

import java.util.List;

/**
 * Created by MainWork on 01.04.2017.
 */
@Service
public class DataDao {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public List<Users> getAllUsers(){
        Session session = sessionFactory.getCurrentSession();
        List<Users> userList = session.createQuery("from Users").list();
        return userList;
    }
}
