package com.guat.myosotis.dao.impl;

import com.guat.myosotis.bean.Property;
import com.guat.myosotis.dao.PropertyDao;
import com.guat.myosotis.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class PropertyDaoImpl implements PropertyDao {
    @Override
    public int insert(Property property) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        return sqlSession.insert("property.insert", property);
    }

    @Override
    public List<Property> selectAll() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        return sqlSession.selectList("property.selectAll");
    }

    @Override
    public int updatePropertyById(Property property) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        return sqlSession.update("property.updatePropertyById", property);
    }

    @Override
    public int deletePropertyById(Long id) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        return sqlSession.delete("property.deletePropertyById", id);
    }
}
