package com.guat.myosotis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * 操作会话工具类
 *
 * @author A.E.
 * @version 1.0
 * @since 1.0
 */
public class SqlSessionUtil {

    private SqlSessionUtil() {
    }

    private static final ThreadLocal<SqlSession> local = new ThreadLocal<>();

    private static final SqlSessionFactory sqlSessionFactory;

    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取并将会话添加到线程
     *
     * @return 会话对象
     */
    public static SqlSession getSqlSession() {
        SqlSession sqlSession = local.get();
        if (sqlSession == null) {
            sqlSession = sqlSessionFactory.openSession();
            local.set(sqlSession);
        }
        return sqlSession;
    }

    /**
     * 提交事务
     */
    public static void commitSqlSession() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        if (sqlSession != null) {
            sqlSession.commit();
        }
    }

    /**
     * 关闭，从线程中移除会话
     */
    public static void closeSqlSession() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        if (sqlSession != null) {
            sqlSession.close();
            local.remove();
        }
    }

}
