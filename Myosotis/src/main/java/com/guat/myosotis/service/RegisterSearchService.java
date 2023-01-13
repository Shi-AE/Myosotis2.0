package com.guat.myosotis.service;

import java.util.List;

/**
 * 下拉框内容查询服务
 *
 * @author A.E.
 * @version 1.0
 * @since 1.0
 */
public interface RegisterSearchService {

    /**
     * 查询上级领导
     * @return
     */
    List<String> managerSearch();

    /**
     * 查询部门
     * @return
     */
    List<String> deptSearch();
}
