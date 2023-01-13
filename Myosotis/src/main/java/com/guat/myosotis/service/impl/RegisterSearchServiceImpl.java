package com.guat.myosotis.service.impl;

import com.guat.myosotis.dao.DeptDao;
import com.guat.myosotis.dao.EmployDao;
import com.guat.myosotis.dao.impl.DeptDaoImpl;
import com.guat.myosotis.dao.impl.EmployDaoImpl;
import com.guat.myosotis.service.RegisterSearchService;
import com.guat.myosotis.util.SqlSessionUtil;

import java.util.List;

public class RegisterSearchServiceImpl implements RegisterSearchService {
    @Override
    public List<String> managerSearch() {
        EmployDao employDao = new EmployDaoImpl();
        try {
            List<String> name = employDao.selectAllName();
            SqlSessionUtil.commitSqlSession();
            return name;
        } finally {
            SqlSessionUtil.closeSqlSession();
        }
    }

    @Override
    public List<String> deptSearch() {
        DeptDao deptDao = new DeptDaoImpl();
        try {
            List<String> name = deptDao.selectAllName();
            SqlSessionUtil.commitSqlSession();
            return name;
        } finally {
            SqlSessionUtil.closeSqlSession();
        }
    }
}
