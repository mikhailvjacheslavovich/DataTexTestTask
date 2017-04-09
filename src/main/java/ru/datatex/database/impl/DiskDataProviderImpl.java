package ru.datatex.database.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.datatex.database.DiskDataProvider;
import ru.datatex.database.base.BaseDataProvider;
import ru.datatex.model.DiskEntity;
import ru.datatex.model.UsersEntity;
import ru.datatex.util.AppConstants;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;


@Repository
public class DiskDataProviderImpl extends BaseDataProvider implements DiskDataProvider{

    private static final Logger log = Logger.getLogger(DiskDataProviderImpl.class.getName());

    @Autowired
    AppConstants appConstants;

    @Transactional
    public List<DiskEntity> getFreeDisks() {
        List<DiskEntity> disks = new ArrayList<DiskEntity>();
        try {
            Session session = getSession();
            Criteria criteria = session.createCriteria(DiskEntity.class);
            criteria.createAlias("users", "us");
            criteria.add(Restrictions.eq("us.id", appConstants.ADMINID));
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            disks = (List<DiskEntity>) criteria.list();
        } catch (Exception ex) {
            log.info(ex.getMessage());
        }
        return disks;
    }

    @Transactional
    public void addDisk(String title, String rating, String description,Long ownerId) {
        try {
            Session session = getSession();

            Criteria criteria = session.createCriteria(UsersEntity.class);
            criteria.add(Restrictions.eq("id",appConstants.ADMINID));
            Set<UsersEntity> lst = new HashSet<UsersEntity>();
            UsersEntity us  = (UsersEntity) criteria.uniqueResult();
            lst.add(us);
            session.saveOrUpdate(new DiskEntity(ownerId, title, rating, description, lst));
        } catch (Exception ex) {
            log.info(ex.getMessage());
        }
    }

    @Transactional
    public void rentDisk(Long diskId, Long userId) {
        Session session = getSession();
        try {

            Criteria criteria = session.createCriteria(DiskEntity.class);
            criteria.add(Restrictions.eq("id", diskId));
            DiskEntity disk = (DiskEntity) criteria.uniqueResult();
            Criteria cr = session.createCriteria(UsersEntity.class);
            cr.add(Restrictions.eq("id", userId));
            UsersEntity user = (UsersEntity) cr.uniqueResult();


            disk.getUsers().clear();
            disk.getUsers().add(user);

            session.saveOrUpdate(disk);
        } catch (Exception ex) {
            log.info(ex.getMessage());
        }
    }

    @Transactional
    public void returnDisk(Long diskId) {
        Session session = getSession();
        try{
            Criteria criteria = session.createCriteria(DiskEntity.class);
            criteria.add(Restrictions.eq("id", diskId));
            DiskEntity disk = (DiskEntity) criteria.uniqueResult();
            Criteria cr = session.createCriteria(UsersEntity.class);
            cr.add(Restrictions.eq("id", appConstants.ADMINID));
            UsersEntity user = (UsersEntity) cr.uniqueResult();

            disk.getUsers().clear();
            disk.getUsers().add(user);

            session.saveOrUpdate(disk);
        }catch (Exception ex){
            log.info(ex.getMessage());
        }
    }

    @Transactional
    public List<DiskEntity> getTakenDisk(Long id) {
        List<DiskEntity> disks = new ArrayList<DiskEntity>();
        try {
            Session session = getSession();

            Criteria criteria = session.createCriteria(DiskEntity.class);
            criteria.createAlias("users", "us");
            criteria.add(Restrictions.eq("us.id", id));
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            disks = (List<DiskEntity>) criteria.list();

        } catch (Exception ex) {
            log.info(ex.getMessage());
        }
        return disks;
    }

    @Transactional
    public List<DiskEntity> getGivenDisks(Long id) {
        List<DiskEntity> disks = new ArrayList<DiskEntity>();
        try {
            Session session = getSession();
            Criteria criteria = session.createCriteria(DiskEntity.class);
            criteria.add(Restrictions.eq("owner", id));
            criteria.createAlias("users", "us");
            criteria.add(Restrictions.ne("us.id", appConstants.ADMINID));
            criteria.add(Restrictions.ne("us.id", id));
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            disks = (List<DiskEntity>) criteria.list();

        } catch (Exception ex) {
            log.info(ex.getMessage());
        }
        return disks;
    }
}
