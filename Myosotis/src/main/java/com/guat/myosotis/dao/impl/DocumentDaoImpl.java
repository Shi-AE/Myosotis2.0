package com.guat.myosotis.dao.impl;

import com.guat.myosotis.bean.Document;
import com.guat.myosotis.dao.DocumentDao;
import com.guat.myosotis.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class DocumentDaoImpl implements DocumentDao {
    @Override
    public int insert(Document document) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        return sqlSession.insert("document.insert", document);
    }

    @Override
    public List<Document> selectAll(String employ) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        return sqlSession.selectList("document.selectAll", employ);
    }

    @Override
    public byte[] selectFileById(Long id) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        return sqlSession.selectOne("document.selectFileById", id);
    }

    @Override
    public int deleteFileById(Long id) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        return sqlSession.delete("document.deleteFileById", id);
    }
}
