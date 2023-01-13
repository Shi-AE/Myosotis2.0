package com.guat.myosotis.service;

import com.guat.myosotis.bean.Document;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.util.List;

/**
 * 文件管理服务
 *
 * @author A.E.
 * @version 1.0
 * @since 1.0
 */
public interface DocumentService {

    /**
     * 文件获取字节流
     * @param file 文件
     * @return 字节流
     */
    byte[] getBytes(Part file) throws IOException;

    /**
     * 获取发送目标员工编号
     * @param name 姓名
     * @return 员工编号
     */
    String getTargetEmployId(String name);

    /**
     * 发送文件到服务器
     * @param document 文件信息
     * @return 是否成功
     */
    boolean sendDocument(Document document);

    /**
     * 获取文件信息
     * @param employId  员工编号
     * @return 文件信息列表
     */
    List<Document> getDocumentInfo(String employId);

    /**
     * 通过id获取文件
     * @param id 文件编号
     * @return 文件流
     */
    byte[] getFile(String id);

    /**
     * 删除文件
     * @param id 文件编号
     * @return 是否成功
     */
    boolean deleteFile(String id);
}
