var gridObj;
$(function () {
    gridObj = $.fn.bsgrid.init('searchTable', {
        url: 'data/json.jsp',
        // autoLoad: false,
        pageSizeSelect: true,
        pageSize: 10
    });
});

function operate(record, rowIndex, colIndex, options) {
    return '<a href="#" onclick="alert(\'ID=' + gridObj.getRecordIndexValue(record, 'ID') + '\');">Operate</a>';
}