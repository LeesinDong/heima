import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {
    @Test
    public void testSelectAll() throws IOException {
        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. 执行方法
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);

        //5. 释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectById() throws IOException {
        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. 执行方法
        Brand brand = brandMapper.selectById(6);
        System.out.println(brand);

        //5. 释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectConditionSingle() throws IOException {
        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);


        Map map = new HashMap<>();
//        map.put("id", 1);
        map.put("brandName", "三只松鼠");
        //4. 执行方法
        List<Brand> brands = brandMapper.selectByConditionSingle(map);
        System.out.println(brands);

        //5. 释放资源
        sqlSession.close();
    }

    @Test
    public void testAdd() throws IOException {
        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);


        Brand brand = new Brand();
        brand.setBrandName("a");
        brand.setCompanyName("b");
        brand.setDescription("aaa");
        brand.setStatus(1);
        brand.setOrdered(3);
        brandMapper.add(brand);
        System.out.println(brand);
        sqlSession.commit();
        //5. 释放资源
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {
        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = new Brand();
        brand.setId(6);
        brand.setBrandName("a");
        brand.setCompanyName("b");
        brand.setDescription("大大大大大");
        brand.setStatus(1);
        brand.setOrdered(3);
        brandMapper.update(brand);
        System.out.println(brand);
        sqlSession.commit();
        //5. 释放资源
        sqlSession.close();
    }

    @Test
    public void testUpdateCondition() throws IOException {
        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = new Brand();
        brand.setId(6);
//        brand.setBrandName("a");
//        brand.setCompanyName("b");
//        brand.setDescription("大大大大大");
        brand.setStatus(222);
//        brand.setOrdered(3);
        brandMapper.updateCondition(brand);
        System.out.println(brand);
        sqlSession.commit();
        //5. 释放资源
        sqlSession.close();
    }

    @Test
    public void testDeleteById() throws IOException {
        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = new Brand();
        brand.setId(6);
//        brand.setBrandName("a");
//        brand.setCompanyName("b");
//        brand.setDescription("大大大大大");
        brand.setStatus(111);
//        brand.setOrdered(3);
        brandMapper.deleteById(7);
        System.out.println(brand);
        sqlSession.commit();
        //5. 释放资源
        sqlSession.close();
    }

    @Test
    public void testDeleteByIds() throws IOException {
        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = new Brand();
        brand.setId(6);
//        brand.setBrandName("a");
//        brand.setCompanyName("b");
//        brand.setDescription("大大大大大");
        brand.setStatus(111);
//        brand.setOrdered(3);]
        int[] ids = {1, 2, 3};
        brandMapper.deleteByIds(ids);
        System.out.println(brand);
        sqlSession.commit();
        //5. 释放资源
        sqlSession.close();
    }
}
