package com.wpkj.mapper;

import com.wpkj.domain.WpUsers;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface WpUsersMapper {
    int countByExample(WpUsers example);

    int deleteByExample(WpUsers example);

    int deleteByPrimaryKey(String id);

    int insert(WpUsers record);

    int insertSelective(WpUsers record);

    List<WpUsers> selectByExampleWithRowbounds(WpUsers example, RowBounds rowBounds);

    List<WpUsers> selectByExample(WpUsers example);

    WpUsers selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WpUsers record, @Param("example") WpUsers example);

    int updateByExample(@Param("record") WpUsers record, @Param("example") WpUsers example);

    int updateByPrimaryKeySelective(WpUsers record);

    int updateByPrimaryKey(WpUsers record);
}