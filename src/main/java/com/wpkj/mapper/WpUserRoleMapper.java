package com.wpkj.mapper;

import com.wpkj.domain.WpUserRole;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface WpUserRoleMapper {
    int countByExample(WpUserRole example);

    int deleteByExample(WpUserRole example);

    int deleteByPrimaryKey(String id);

    int insert(WpUserRole record);

    int insertSelective(WpUserRole record);

    List<WpUserRole> selectByExampleWithRowbounds(WpUserRole example, RowBounds rowBounds);

    List<WpUserRole> selectByExample(WpUserRole example);

    WpUserRole selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WpUserRole record, @Param("example") WpUserRole example);

    int updateByExample(@Param("record") WpUserRole record, @Param("example") WpUserRole example);

    int updateByPrimaryKeySelective(WpUserRole record);

    int updateByPrimaryKey(WpUserRole record);
}