package com.guat.myosotis.service.impl;

import com.guat.myosotis.bean.Document;
import com.guat.myosotis.dao.DocumentDao;
import com.guat.myosotis.dao.EmployDao;
import com.guat.myosotis.dao.impl.DocumentDaoImpl;
import com.guat.myosotis.dao.impl.EmployDaoImpl;
import com.guat.myosotis.service.DocumentService;
import com.guat.myosotis.util.SqlSessionUtil;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DocumentServiceImpl implements DocumentService {
    @Override
    public byte[] getBytes(Part file) throws IOException {
        InputStream inputStream = file.getInputStream();
        int available = inputStream.available();
        byte[] bytes = new byte[available];
        //noinspection ResultOfMethodCallIgnored
        inputStream.read(bytes);
        return bytes;
    }

    @Override
    public String getTargetEmployId(String name) {
        EmployDao employDao = new EmployDaoImpl();
        try {
            String employIdByName = employDao.selectEmployIdByName(name);
            SqlSessionUtil.commitSqlSession();
            return employIdByName;
        } finally {
            SqlSessionUtil.closeSqlSession();
        }

    }

    @Override
    public boolean sendDocument(Document document) {
        DocumentDao documentDao = new DocumentDaoImpl();
        try {
            int insert = documentDao.insert(document);
            SqlSessionUtil.commitSqlSession();
            return insert == 1;
        } finally {
            SqlSessionUtil.closeSqlSession();
        }
    }

    @Override
    public List<Document> getDocumentInfo(String employId) {
        DocumentDao documentDao = new DocumentDaoImpl();
        EmployDao employDao = new EmployDaoImpl();
        try {
            List<Document> documents = documentDao.selectAll(employId);
            documents.forEach((e) -> {
                String sender = e.getSender();
                sender = employDao.selectNameByEmployId(sender);
                e.setSender(sender);
            });
            SqlSessionUtil.commitSqlSession();
            return documents;
        } finally {
            SqlSessionUtil.closeSqlSession();
        }
    }

    @Override
    public byte[] getFile(String sId) {
        Long id = Long.valueOf(sId);
        DocumentDao documentDao = new DocumentDaoImpl();
        try {
            byte[] file = documentDao.selectFileById(id);
            SqlSessionUtil.commitSqlSession();
            return file;
        } finally {
            SqlSessionUtil.closeSqlSession();
        }

    }

    @Override
    public boolean deleteFile(String sId) {
        Long id = Long.valueOf(sId);
        DocumentDao documentDao = new DocumentDaoImpl();
        try {
            int count = documentDao.deleteFileById(id);
            SqlSessionUtil.commitSqlSession();
            return count == 1;
        } finally {
            SqlSessionUtil.closeSqlSession();
        }

    }
}
