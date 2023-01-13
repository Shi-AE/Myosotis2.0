package com.guat.myosotis.util;

import com.guat.myosotis.bean.Employ;

/**
 * 编写。解析员工编号
 *
 * @author A.E.
 * @version 1.0
 * @since 1.0
 */
public class EmployIdUtil {
    private EmployIdUtil() {}

    /*
     * 规则：
     * 入职时间 2002-09-07
     * 部门编号 1001
     * 员工编号 200209071001
     */

    /**
     * 字符串化员工编号
     * @param employ 员工对象
     * @return 员工编号
     */
    public static String stringify(Employ employ) {
        String date = employ.getHireDate();
        String deptId = employ.getDeptId();
        StringBuilder res = new StringBuilder();
        String[] strings = date.split("-");
        for (String string : strings) {
            res.append(string);
        }
        res.append(deptId);
        return res.toString();
    }

    /**
     * 解析员工编号
     * @param employId 员工编号
     * @return 员工对象
     */
    public static Employ parse(String employId) {
        String date = employId.substring(0, 4) + '-'
                + employId.substring(4,6) + '-'
                + employId.substring(6,8);
        String deptId = employId.substring(8);
        Employ employ = new Employ();
        employ.setHireDate(date);
        employ.setDeptId(deptId);
        return employ;
    }
}
