package com.wpkj.mapper;

import com.wpkj.domain.WpRoles;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface WpRolesMapper {
    int countByExample(WpRoles example);

    int deleteByExample(WpRoles example);

    int deleteByPrimaryKey(String id);

    int insert(WpRoles record);

    int insertSelective(WpRoles record);

    List<WpRoles> selectByExampleWithRowbounds(WpRoles example, RowBounds rowBounds);

    List<WpRoles> selectByExample(WpRoles example);

    WpRoles selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WpRoles record, @Param("example") WpRoles example);

    int updateByExample(@Param("record") WpRoles record, @Param("example") WpRoles example);

    int updateByPrimaryKeySelective(WpRoles record);

    int updateByPrimaryKey(WpRoles record);
}