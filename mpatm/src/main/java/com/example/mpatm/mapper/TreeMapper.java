package com.example.mpatm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.mpatm.model.TreeNode;

@Mapper
public interface TreeMapper {
	
	@Select("")
	List<TreeNode> getTreeList();

}
