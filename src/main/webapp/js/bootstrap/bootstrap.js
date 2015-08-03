var gridObj;
$(function () {
    gridObj = $.fn.bsgrid.init('searchTable', {
        url: '/test/bootstrap/data/json',
        // autoLoad: false,
        pageSizeSelect: true,
        pageSize: 10
    });
});

function operate(record, rowIndex, colIndex, options) {
    return '<a href="#" onclick="alert(\'ID=' + gridObj.getRecordIndexValue(record, 'ID') + '\');">Operate</a>';
}