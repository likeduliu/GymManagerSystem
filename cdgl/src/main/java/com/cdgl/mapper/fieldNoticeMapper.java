package com.cdgl.mapper;


import com.cdgl.pojo.fieldnotice;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface fieldNoticeMapper {

    //查询公告
    List<fieldnotice> findAllNotice();
    //编辑公告中的查询
    fieldnotice fefieldnotice(Integer fieldnoticeid);
    //更新公告
    public void updateFieldNotice(fieldnotice fieldnotice);
    //删除公告
    public void deleteFieldNotice(Integer fieldnoticeid);

    //添加公告
    public void addFieldNotice(fieldnotice fieldnotice);
}
