package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface BrandMapper {

    List<Brand> selectAll();

    @Select("select * from tb_brand where id = #{id};")
    Brand selectById(int id);

    List<Brand> selectByCondition(@Param("id") int id, @Param("age") int age, @Param("name") String name);

    List<Brand> selectByConditionSingle(Map map);

    void add(Brand brand);

    void update(Brand brand);

    void updateCondition(Brand brand);

    void deleteById(int id);

    void deleteByIds(@Param("ids") int[] ids);
}
