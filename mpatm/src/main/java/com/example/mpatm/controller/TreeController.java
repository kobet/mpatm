package com.example.mpatm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.mpatm.mapper.TreeMapper;
import com.example.mpatm.model.TreeNode;

@Controller
@RequestMapping("/tree")
public class TreeController {
	
	@Autowired
	private TreeMapper treeMapper;
	
	@RequestMapping("/list")
    public String index(ModelMap map) {
        
        return "business/tree";  
    }
	
	@RequestMapping("/list.json")
	@ResponseBody
	public List<TreeNode> list(){
//		List<TreeNode> list =treeMapper.getTreeList();
		List<TreeNode> list = new ArrayList<TreeNode>();
		TreeNode node1 = new TreeNode(1,0,"清结算系统",false);
		TreeNode node2 = new TreeNode(11,1,"贷前试算",false);
		TreeNode node3 = new TreeNode(12,1,"贷后操作",false);
		TreeNode node4 = new TreeNode(2,0,"账务系统",false);
		TreeNode node5 = new TreeNode(21,2,"账务系统",false);
		TreeNode node6 = new TreeNode(22,2,"跑批业务",false);
		list.add(node1);
		list.add(node2);
		list.add(node3);
		list.add(node4);
		list.add(node5);
		list.add(node6);
		System.out.println("==========================");
		return list;
	}

}
