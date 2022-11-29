package mybatis;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConfig {
    private static SqlSessionFactory sqlSessionFactory;
    public MyBatisConfig(){
        getInstance();
    }

    public static synchronized SqlSessionFactory getInstance(){
        InputStream config = MyBatisConfig.class.getClassLoader().getResourceAsStream("data/socket_config.xml");
        if(sqlSessionFactory == null){
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        }
        sqlSessionFactory.getConfiguration();
        return sqlSessionFactory;
    }

    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }
}