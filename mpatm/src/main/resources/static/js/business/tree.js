/***
		 * 树对象
		 */
var bTree = {
		onClick : function(event, treeId, treeNode, clickFlag){
			alert('测试节点点击事件');
		}	
};



//设置
		var setting = {
			check: {
				enable: true
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			//事件
			callback: {
				//beforeClick: beforeClick,
				onClick: bTree.onClick
			}
		};

		/**test data
		var zNodes =[
			{ id:1, pId:0, name:"清结算系统", open:false},
			{ id:11, pId:1, name:"贷前试算",open:false},
			{ id:12, pId:1, name:"贷后操作",open:false},
			{ id:13, pId:1, name:"叠加包相关",open:false},
			{ id:111, pId:11, name:"getAllinfo"},
			{ id:121, pId:12, name:"生成产品快照"},
			{ id:1211, pId:121, name:"参数"},
			{ id:122, pId:12, name:"生成还款计划表"},
			{ id:123, pId:12, name:"正常核销"},
			{ id:124, pId:12, name:"提前核销"},
			{ id:125, pId:12, name:"预核销"},
			{ id:131, pId:13, name:"创建叠加包"},
			{ id:132, pId:13, name:"激活叠加包"},
			{ id:133, pId:13, name:"退订叠加包"},
			{ id:134, pId:13, name:"叠加包跑批"},
			{ id:135, pId:13, name:"叠加包查询"},
			{ id:2, pId:0, name:"账务系统", open:true},
			{ id:21, pId:2, name:"核销业务"},
			{ id:22, pId:2, name:"跑批业务", open:true},
			{ id:221, pId:22, name:"随意勾选 2-2-1", checked:true},
			{ id:222, pId:22, name:"随意勾选 2-2-2"},
			{ id:3, pId:0, name:"交易系统"},
			{ id:31, pId:3, name:"接口",open:false},
			{ id:32, pId:3, name:"队列",open:false},
			{ id:4, pId:0, name:"医美系统"},
			{ id:41, pId:4, name:"部分回购",open:false},
			{ id:42, pId:4, name:"全部回购",open:false},
		];
		*/
		var code;		
		function setCheck() {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),

			py = "p",
			sy = "s",
			pn = "p",
			sn = "s",
			type = { "Y":py + sy, "N":pn + sn};
			zTree.setting.check.chkboxType = type;
			showCode('setting.check.chkboxType = { "Y" : "' + type.Y + '", "N" : "' + type.N + '" };');
		}
		function showCode(str) {
			if (!code) code = $("#code");
			code.empty();
			code.append("<li>"+str+"</li>");
		}
		
		$(function(){
			var host = window.location.host;
			var params = {};
			$.ajax({
				  type: 'POST',
				  url: "http://" + host + "/tree/list.json",
				  data: params,
				  success: function(result){
					  //alert(result);
					  $.fn.zTree.init($("#treeDemo"), setting, result);
						//setCheck();
						//$("#py").bind("change", setCheck);
						//$("#sy").bind("change", setCheck);
						//$("#pn").bind("change", setCheck);
						//$("#sn").bind("change", setCheck);
				  },
				  dataType: "json"
				});		
		});
		

		