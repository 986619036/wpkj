package com.wpkj.mapper;

import com.wpkj.domain.WpRoleMenus;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface WpRoleMenusMapper {
    int countByExample(WpRoleMenus example);

    int deleteByExample(WpRoleMenus example);

    int deleteByPrimaryKey(String id);

    int insert(WpRoleMenus record);

    int insertSelective(WpRoleMenus record);

    List<WpRoleMenus> selectByExampleWithRowbounds(WpRoleMenus example, RowBounds rowBounds);

    List<WpRoleMenus> selectByExample(WpRoleMenus example);

    WpRoleMenus selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WpRoleMenus record, @Param("example") WpRoleMenus example);

    int updateByExample(@Param("record") WpRoleMenus record, @Param("example") WpRoleMenus example);

    int updateByPrimaryKeySelective(WpRoleMenus record);

    int updateByPrimaryKey(WpRoleMenus record);
}