package ru.datatex.database;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hsqldb.rights.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.datatex.model.Users;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginDataProvider {
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

}
