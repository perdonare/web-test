/**
 * Created by perdonare on 2015/5/3.
 */

$(function () {

    $("#box").datagrid({
        width:400,
        title:'json-test',
        method:'post',
        iconCls:'icon-search',
        url:'test/easyui/json/data',
        columns:[[
            {
                field:'name',
                title:'用户名'
            },
            {
                field:'password',
                title:'密码'
            }

        ]]
    });

});
