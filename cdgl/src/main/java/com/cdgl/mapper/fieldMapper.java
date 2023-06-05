package com.cdgl.mapper;

import com.cdgl.pojo.field;
import com.cdgl.pojo.fieldnotice;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface fieldMapper {


    //查询全部场地
    @Select("Select * from field")
    List<field> findAll();
    //查询未预约的场地
    @Select("Select *from field where book='2' ")
    List<field> unbook();
    //查询已预约场地
    @Select("Select *from field where book='1'")
    List<field> booked();

    //删除并更新
    @Delete("Delete from field where fieldid=#{fieldid} ")
    public void DelField(Integer fieldid);

    @Update("ALTER TABLE field AUTO_INCREMENT = #{fieldid}")
    public void UpdateFieldId(Integer fieldid);
    //添加场地
    @Insert("INSERT INTO `field` (`fieldName`, `kind`,`book`,`rate`) VALUES (#{fieldName}, #{kind}, #{book},#{rate});")
    public void AddField(field field);
    //预约场地
    @Update("UPDATE field SET book = 1,bookusername=#{bookusername},bookstarttime=#{bookstarttime},bookendtime=#{bookendtime} WHERE fieldid = #{fieldid};")
    public void BookField(field field);
    //取消预约
    @Update("UPDATE field SET book=2 WHERE fieldid=#{fieldid}")
    public void CancleBook(Integer fieldid);
}
