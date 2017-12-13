package com.tg.action;

import com.opensymphony.xwork2.ActionSupport;
import com.tg.service.TG_CarDeletePicService;
import com.tg.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class TG_CarDeletePicAction extends ActionSupport{
    @Autowired
    private TG_CarDeletePicService tg_carDeletePicService;
    private String pic;

    private String msg;
    private int code;

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    public String execute() throws Exception{

        tg_carDeletePicService.deletePic(pic);
        ImageUtils.deleteFile(pic);
        code = 1;
        msg = "删除成功";
        return SUCCESS;
    }
}
