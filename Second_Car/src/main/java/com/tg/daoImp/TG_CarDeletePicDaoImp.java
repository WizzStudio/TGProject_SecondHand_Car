package com.tg.daoImp;

import com.tg.dao.TG_CarDeletePicDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TG_CarDeletePicDaoImp implements TG_CarDeletePicDao {
    @Autowired
    private SessionFactory sessionFactory;
    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    @Override
    public boolean deletePicByUrl(String pic) {
        String sql = "delete from TG_Car  where pic=?";
        Query query = getSession().createQuery(sql);
        query.setString(0,pic);
        if(query.executeUpdate()<0)
        {
            return false;
        }else{
            return true;
        }
    }
}
