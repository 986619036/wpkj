package com.wpkj.mapper;

import com.wpkj.domain.WpMenus;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface WpMenusMapper {
    int countByExample(WpMenus example);

    int deleteByExample(WpMenus example);

    int deleteByPrimaryKey(String id);

    int insert(WpMenus record);

    int insertSelective(WpMenus record);

    List<WpMenus> selectByExampleWithRowbounds(WpMenus example, RowBounds rowBounds);

    List<WpMenus> selectByExample(WpMenus example);

    WpMenus selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WpMenus record, @Param("example") WpMenus example);

    int updateByExample(@Param("record") WpMenus record, @Param("example") WpMenus example);

    int updateByPrimaryKeySelective(WpMenus record);

    int updateByPrimaryKey(WpMenus record);
}