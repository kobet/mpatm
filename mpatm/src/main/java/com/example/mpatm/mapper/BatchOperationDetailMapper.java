package com.example.mpatm.mapper;

import com.example.mpatm.model.BatchOperationDetail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BatchOperationDetailMapper {

    @Insert("INSERT INTO batch_operation_detail(batch_index, type, business_id) VALUES(#{batchIndex}, #{type}, #{businessId})")
    public void insert(@Param("batchIndex") int batchIndex, @Param("type") int type, @Param("businessId") String businessId);

    @Select("select * from batch_operation_detail where type = #{type} and business_id = #{businessId} for update")
    public BatchOperationDetail lockByTypeAndBusinessId(@Param("type") int type, @Param("businessId") String businessId);
}
