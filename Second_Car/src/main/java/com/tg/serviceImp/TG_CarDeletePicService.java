package com.tg.serviceImp;

import com.tg.dao.TG_CarDeletePicDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TG_CarDeletePicService implements com.tg.service.TG_CarDeletePicService {
    @Autowired
    private TG_CarDeletePicDao tg_carDeletePicDao;
    @Override
    public boolean deletePic(String pic) {
        return tg_carDeletePicDao.deletePicByUrl(pic);
    }
}
