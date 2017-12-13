package com.tg.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface TG_CarDeletePicDao {
    public boolean deletePicByUrl(String pic);
}
