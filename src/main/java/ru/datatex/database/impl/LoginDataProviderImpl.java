package ru.datatex.database.impl;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.datatex.database.LoginDataProvider;
import ru.datatex.model.UsersEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class LoginDataProviderImpl implements LoginDataProvider {
    private static final Logger log = Logger.getLogger(DiskDataProviderImpl.class.getName());

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public List<UsersEntity> getAllUsers() {
        List<UsersEntity> users = new ArrayList<UsersEntity>();
        try {
            Session session = sessionFactory.openSession();

            Criteria criteria = session.createCriteria(UsersEntity.class);
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            users = criteria.list();


        } catch (Exception ex) {
            log.info(ex.getMessage());
        }
        return users;
    }

}
