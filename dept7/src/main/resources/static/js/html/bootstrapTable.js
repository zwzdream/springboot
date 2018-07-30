$(function(){
    $table=$('#reportTable');
    //分页查询
    searchName();

});
function doSearch(){
    //分页查询
    $table.bootstrapTable('refresh', {url: ctx+'/User/username/listPage'});
}

//分页查询
function searchName(){
    $table.bootstrapTable({
        method: 'post',
        //method: 'get',
        url: "/user/username/listPage",
        //url: ctx+'/resources/demo.json',
        contentType: "application/x-www-form-urlencoded",
        dataType: "json",
        striped: true, //使表格带有条纹
        pagination: true, //在表格底部显示分页工具栏
        pageSize:5,
        pageNumber:1,
        pageList: [5,10,15, 20],
        idField: "id", //标识哪个字段为id主键
        showToggle: false, //名片格式
        cardView: false,//设置为True时显示名片（card）布局
        showColumns: true, //显示隐藏列
        showRefresh: true, //显示刷新按钮
        singleSelect: false,//复选框是否只能选择一条记录
        search: true,//是否显示右上角的搜索框
        clickToSelect: true,//点击行即可选中单选/复选框
        //选择client分页，后台查询所有的结果返回（json数据），前台自己根据数据分页，选择server，由后台传回的rows（每页的数据）和total（查询到的所有数据量）决定
        sidePagination: "server",//分页方式：client客户端分页，server服务端分页（*）
        queryParams: queryParams, //参数
        searchOnEnterKey: "true",
        queryParamsType: "limit", //参数格式,发送标准的RESTFul类型的参数请求
        toolbar: "#toolbar", //设置工具栏的Id或者class
// responseHandler: responseHandler,//对后台传的数据处理成前台可以接受的形式
        //列
        columns: [
            {field:'companyId' ,checkbox:true},
            {field:'id',title:'ID',width:100,sortable:true,valign:'middle',align:'center'},
            {field:'age',title:'年龄',width:100,sortable:true,valign:'middle',align:'center'},
            {field:'createDate',title:'创建日期',width:100,sortable:true,valign:'middle',align:'center'},
            {field:'name',title:"姓名",width:100,sortable:true,valign:'middle',align:'center'},
            {field:'remarks',title:'备注',width:100,sortable:true,valign:'middle',align:'center'},
            {title:'操作',width:100,sortable:true,valign:'middle',align:'center',formatter: operateFormatter}
        ],
// silent: true, //刷新事件必须设置
        formatLoadingMessage: function () {
            return "请稍等，正在加载中...";
        },
        formatNoMatches: function () { //没有匹配的结果
            return '无符合条件的记录';
        },
        onLoadError: function (data) {
            $table.bootstrapTable('removeAll');
        },
        onClickRow:function(row,$element){  //$element是当前tr的jquery对象
            // $element.css("background-color", "green");
            $('.success').removeClass('success');//去除之前选中的行的，选中样式
            $element.addClass('success');//添加当前选中的 success样式用于区别
        },
        onDblClickRow: function (row) {
            //window.location.href = ctx+"/User/toEdit/" + row.id;
            ajaxContent('/User/toEdit/' + row.id);
        },
    });

}

function operateFormatter(value, row, index) {
    return [
        '<a class="edit" href="javascript:void(0)" title="Edit" onclick="edit(\''+ row.id + '\')">',
        '<i class="glyphicon glyphicon-edit"></i>',
        '</a> ',
        '<a class="remove" href="javascript:void(0)" title="Remove" onclick="del(\''+ row.id + '\')">',
        '<i class="glyphicon glyphicon-remove"></i>',
        '</a>'
    ].join('');
}
function edit(id){
    ajaxContent('/User/toEdit/' + id);
}
function del(id){
    ajaxContent('/User/delete/' + id);
}



function queryParams(params) { //配置参数
    var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
        username:$('#username').val(),//用户名
        pageNumber: params.pageNumber, //页码
        pageSize: params.limit, //页面大小

    };
    return temp;

}
//获得data-checkbox="true",即选中行的值
function getIdSelections() {
    return $.map($table.bootstrapTable('getSelections'), function(row) {
        return row.id;
    });
}



