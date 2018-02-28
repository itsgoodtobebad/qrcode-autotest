package com.itsgoodtobebad.qrcode.dbhelper;

import com.itsgoodtobebad.qrcode.dto.MerBase;
import com.itsgoodtobebad.qrcode.mapper.MerBaseMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author liliangxi.
 *         Created on 2018/2/23.
 */
public class DBHelper {

    private static String QRCODE_AGENT = "qrcode_agent";
    public static SqlSessionFactory sqlSessionFactory;

    static {
        String resource = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, QRCODE_AGENT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public MerBase queryMerchantByMchtPhone(String mchtPhone){
        SqlSession session = sqlSessionFactory.openSession(true);
        try{
            MerBaseMapper merBaseMapper = session.getMapper(MerBaseMapper.class);
            MerBase merBase = merBaseMapper.queryMerchantByMchtPhone(mchtPhone);

            return merBase;
        }finally {
            session.close();
        }
    }

    public void deleteMerchantFromMerBaseByMchtPhone(String mchtPhone){
        SqlSession session = sqlSessionFactory.openSession(true);
        try{
            MerBaseMapper merBaseMapper = session.getMapper(MerBaseMapper.class);
            merBaseMapper.deleteMerchantFromMerBaseByMchtPhone(mchtPhone);
        }finally {
            session.close();
        }
    }

    public void deleteMerchantFromMerBaseApprovalByMchtPhone(String mchtPhone){
        SqlSession session = sqlSessionFactory.openSession(true);
        try{
            MerBaseMapper merBaseMapper = session.getMapper(MerBaseMapper.class);
            merBaseMapper.deleteMerchantFromMerBaseApprovalByMchtPhone(mchtPhone);
        }finally {
            session.close();
        }
    }
}
