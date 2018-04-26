<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="widget/jquery-easyui-1.5/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="widget/jquery-easyui-1.5/themes/icon.css">
<link rel="stylesheet" type="text/css" href="widget/jquery-easyui-1.5/demo/demo.css">
<script type="text/javascript" src="widget/jquery/jquery-3.3.1.js"></script>
<script type="text/javascript" src="widget/jquery-easyui-1.5/jquery.min.js"></script>
<script type="text/javascript" src="widget/jquery-easyui-1.5/jquery.easyui.min.js"></script>


<script type="text/javascript">
	$(function (){
		//$.ajax({contentType:"application/json; charset=utf-8"});
		/* $.post('user/showUserList.do',{},function(result){
			debugger;
        }); */
        var datagrid; //定义全局变量datagrid
        var editRow = undefined; //定义全局变量：当前编辑的行
        datagrid=$('#sjb_div').datagrid({   
	        title:"用户信息",
	        //iconCls: 'icon-save', //图标
	        url:'user/showUserList.do',
	        queryParams: {          
	        	page: function(){
	        		var grid = $('#sjb_div');  
	        		var options = grid.datagrid('getPager').data("pagination").options;  
	        		var page = options.pageNumber;//当前页数  
	        		return page;
	        	} ,pageSize : function(){
	        		var grid = $('#sjb_div');  
	        		var options = grid.datagrid('getPager').data("pagination").options;  
	        		return options.pageSize;
	        	}       
            }, 
	        pagination:true,//如果为true控件底部显示分页工具栏。
	        width:660,
			height:550,
			loadMsg : '数据加载中......', 
			idField:'uid',
			//singleSelect:true,单选
	        columns:[[    
	                  {field:"",checkbox:true},  //复选框
	                  {field:'uid',title:'编号',align:'center',hidden:true,readonly:true,editor:'text'}, 
	                  {field:'id',title:'编号',align:'center',readonly:true,editor:'text'},    
	                  {field:'userName',title:'用户',align:'center',editor:'text'},    
	                  {field:'passWord',title:'密码',align:'center',editor:'text'},    
	                  {field:'age',title:'年龄',align:'center',editor:'text'}    
	                  
	                  ]],
	        //toolbar:"#gongjulan",//工具栏
	        toolbar:[
		        {  text: '添加', iconCls: 'icon-add', handler: function () {//添加列表的操作按钮添加，修改，删除等
	                    //添加时如果没有正在编辑的行，则在datagrid的第一行插入一行
	                    if (editRow == undefined) {                                         
	                            datagrid.datagrid("insertRow", {
	                                    index: 0, // index start with 0
	                                    row: {}
	                            });                   
	                            //将新插入的那一行开户编辑状态
	                            datagrid.datagrid("beginEdit", 0);
	                            //给当前编辑的行赋值
	                            editRow = 0;
	                    }
		        	}
	        	}, '-',
                
                { text: '修改', iconCls: 'icon-edit', 
                    handler: function () {
                        //修改时要获取选择到的行
                        var rows = datagrid.datagrid("getSelections");
                        //如果只选择了一行则可以进行修改，否则不操作
                        if (rows.length == 1) {
                            //当无编辑行时
                            if (editRow == undefined) {
                                //获取到当前选择行的下标
                                var index = datagrid.datagrid("getRowIndex", rows[0]);
                                //开启编辑
                                datagrid.datagrid("beginEdit", index);
                                //把当前开启编辑的行赋值给全局变量editRow
                                editRow = index;
                                //当开启了当前选择行的编辑状态之后，
                                //应该取消当前列表的所有选择行，要不然双击之后无法再选择其他行进行编辑
                                datagrid.datagrid("unselectAll");
                            }
                        }
                    }
                }, '-',
                { text: '删除', iconCls: 'icon-remove', 
                    handler: function () {
                         //删除时先获取选择行
                         var rows = datagrid.datagrid("getSelections");
                         //选择要删除的行
                         if (rows.length > 0) {
                                $.messager.confirm("提示", "你确定要删除吗?", function (r) {
                                    if (r) {
                                        var ids = [];
                                        for (var i = 0; i < rows.length; i++) {
                                            ids.push(rows[i].uid);
                                        }
                                        //将选择到的行存入数组并用,分隔转换成字符串，
                                        //本例只是前台操作没有与数据库进行交互所以此处只是弹出要传入后台的id
                                        //alert(ids.join(','));
                                        $.ajax({
                                            url : "user/deleteUsert.do",
                                            type : 'POST',
                                            dataType:"JSON",
                                            data : {
                                            	uid : ids.join(',')
                                            },
                                            beforeSend : function (){
                                                $.messager.progress({
                                                    text : '正在处理中...'
                                                });    
                                            },
                                            success : function (result){
                                                $.messager.progress('close');
                                                if (result.state=='200'){
                                                    datagrid.datagrid('reload');
                                                    $.messager.show({
                                                        title : '操作提醒',
                                                        msg   : result.count + '条数据被成功删除！'
                                                    })
                                                } else if( result.state =='500' ) {
                                                    $.messager.alert('删除失败', '删除失败，参数出错，请联系管理员！', 'warning');
                                                } else {
                                                    $.messager.alert('删除失败', '没有删除任何数据！', 'warning');
                                                }
                                            }
                                        });                                    
                                    }
                                });
                         } else {
                                $.messager.alert("提示", "请选择要删除的行", "error");
                         } 
                    }
                }, '-',
                { text: '保存', iconCls: 'icon-save', 
                    handler: function () {
                         //保存时结束当前编辑的行，自动触发onAfterEdit事件如果要与后台交互可将数据通过Ajax提交后台
                         datagrid.datagrid("endEdit", editRow);  
                         editRow = undefined;
                    }
                }/* , '-',
                { text: '取消编辑', iconCls: 'icon-redo', 
                    handler: function () {
                         //取消当前编辑行把当前编辑行罢undefined回滚改变的数据,取消选择的行
                         editRow = undefined;
                         datagrid.datagrid("rejectChanges");
                         datagrid.datagrid("unselectAll");
                    }
                }, '-' */
	        ],
	        onAfterEdit: function (rowIndex, rowData, changes) {
                //endEdit该方法触发此事件                     
                //var row = datagrid.datagrid("getData").rows[rowIndex];  //获取某一行的值  
                var inserted = datagrid.datagrid('getChanges','inserted');
                var updated  = datagrid.datagrid('getChanges','updated');
                if(inserted.length < 1 && updated.length <1){
                    editRow = undefined;
                    datagrid.datagrid('unselectAll');
                    return;
                }
                var url = '';
                if(inserted.length>0){
                    url="user/insertUsert.do";  
                }
                if(updated.length>0){
                    url="user/updateUsert.do";  
                }
                      
                $.ajax({
                   url : url,
                   type : 'POST',
                   dataType:"JSON",
                   data : rowData,
                   beforeSend : function (){
                       $.messager.progress({
                           text : '正在处理中...'
                       })
                   },
                   success : function (data){
                       $.messager.progress('close');
                       if (data.state=='200'){  
                            datagrid.datagrid("acceptChanges");
                            if(inserted.length>0){
                            	$.messager.show({
                                    title : '操作提示',
                                    msg : '添加成功'
                                });
                            }
                            if(updated.length>0){
                            	 $.messager.show({
                                     title : '操作提示',
                                     msg : '修改成功'
                                 });  
                            }
                                     
                            editRow = undefined;
                            datagrid.datagrid("reload");  
                           $('#addcheck').val(1);
                       } else if (data.state=='500') {
                           $.messager.alert('添加失败', '操作失败，参数有误请联系管理员！', 'warning');
                       } else {
                           datagrid.datagrid("beginEdit",editRow); 
                           $.messager.alert('警告操作', '未知错误！请重新刷新后提交！', 'warning');
                       }
                       datagrid.datagrid("unselectAll"); 
                       datagrid.trigger("onDblClickRow");
                   }
                });
                //////////////////                                                  
            },
	        onDblClickRow: function (rowIndex, rowData) {
                	//双击开启编辑行
                	if(editRow){
                		datagrid.datagrid("endEdit", editRow);  
                        editRow = undefined;
                	}
                    if (editRow == undefined) {
                            datagrid.datagrid("beginEdit", rowIndex);
                            editRow = rowIndex;
                    }
                },
          //加载成功之后，选定并获取首行数据       
            onLoadSuccess:function(data){   
                //alert("${page.total}");
                debugger
                
            },  
	    }); 
        $('#sjb_div').datagrid('getPager').pagination({//分页栏下方文字显示
        	/* alert('${p.total}')  
        	debugger; */
            displayMsg:'第{from}条到{to}条 共{total}条',
            onBeforeRefresh:function(pageNumber, pageSize){
            $(this).pagination('loading');
             alert('pageNumber:'+pageNumber+',pageSize:'+pageSize);
             $(this).pagination('loaded');
          }
      });
	});
	function add_xz(){
	    $('#add_xzchuangkou').dialog('open');    
	}
	//新增in保存
	function add_xzchuangkou_bc(){
	    $.ajax({
	        url:"user/insertUsert.do",    
	        type:"post",
	        data:{
	        	id:$("#id").val(),
	            userName:$("#userName").val(),
	            passWord:$("#passWord").val(),
	            age:$("#age").val(),
	        },
	        dataType:"json",
	        success:function(result){
	        	debugger;
	            if (result.state=='200') {
	                $('#sjb_div').datagrid('reload'); 
	            }
	            $.messager.show({
	                title:'新增',
	                msg:result.add_zx_jg,
	                timeout:3000,
	                showType:'slide'
	            });
	        },
	        error:function (){
	            $.messager.show({
	                title:'新增',
	                msg:result.add_zx_jg ,
	                timeout:3000,
	                showType:'slide'
	            });
	        }
	    })
	}
	//新增in取消
	function add_xzchuangkou_qx(){
	    $('#add_xzchuangkou').dialog('close');    
	}

</script>
</head>
<body>
	 <div id="gongjulan">
        <a href="javascript:void(0);" onclick="add_xz()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">新增</a>
        <a href="javascript:void(0);" onclick="add_bj()" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">编辑</a> 
        <a href="javascript:void(0);" onclick="add_del()" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a>

    </div>
    <div id="sjb_div"></div>
    <!-- 新增窗口tart--------------------------------------------------- -->
    <div id="add_xzchuangkou" class="easyui-dialog" title="新增"  style="width:300px;height:300px;top:150px;"
       data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:'#add_xzchuangkou_bcandqx'">
        <form id="add_xz_form" method="post">
            </br> 编号:<input id="id" class="easyui-validatebox"  data-options="required:false,validType:'length[1,50]'" /></br> 
            </br> 用户:<input id="userName" class="easyui-validatebox" data-options="required:false,validType:'length[1,50]'" /></br> 
            </br> 密码:<input id="passWord" class="easyui-validatebox" data-options="required:false,validType:'length[1,50]'" /></br> 
            </br> 年龄:<input id="age" class="easyui-validatebox" data-options="required:false,validType:'length[1,50]'" /></br> 
           
        </form>
    </div>
    <!-- 新增窗口in保存取消tart--------------------------------------------------- -->
    <div id="add_xzchuangkou_bcandqx">
        <a href="javascript:void(0);" onclick="add_xzchuangkou_bc()"
            class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a> <a
            href="javascript:void(0);" onclick="add_xzchuangkou_qx()"
            class="easyui-linkbutton" data-options="iconCls:'icon-clear'">取消</a>
    </div>
    
</body>
</html>