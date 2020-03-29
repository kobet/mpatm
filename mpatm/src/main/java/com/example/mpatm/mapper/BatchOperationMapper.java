package com.example.mpatm.mapper;

import com.example.mpatm.model.BatchOperation;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BatchOperationMapper {

    @Insert("INSERT INTO batch_operation(name) VALUES(#{name})")
    public Integer insert(@Param("name") String name);

    @Select("select * from batch_operation where id = #{id}# for update")
    public BatchOperation lockById(@Param("id") long id);
}
