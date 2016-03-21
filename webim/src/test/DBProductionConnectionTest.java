package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.sql.DataSource;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @ClassName DBProductionConnectionTest
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author John
 * @Date 2016-3-1 下午11:15:14
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml" })
@ActiveProfiles("production")
public class DBProductionConnectionTest {
    @Resource
    private DataSource dataSource;
    @Test
    public void getDBConnectionTest() throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select 1 from dual");
        rs.next();
        Assert.assertEquals(1, rs.getInt(1));
        connection.close();
    }
}
