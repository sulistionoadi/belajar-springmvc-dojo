dojo.provide("app.mainframe");

var treeMenuStore = new dojo.data.ItemFileReadStore({
    url: "../js/dojotoolkit/app/menustore.json"
});

var treeMenuModel = new dijit.tree.ForestStoreModel({
    store: treeMenuStore,
    query: {type: 'menu'},
    rootId: "root",
    rootLabel: "Menu",
    childrenAttrs: ["children"]
});

function menuTreeClick(event){
	if('displayFormBarang' == event.action[0]){
		displayFormBarang();
	}
}

function showErrorOpenPage(error, pane){
	if('403' == error.status){
		confirm("Permission denied !");
	} else {
		confirm('[' + error.status + '] ' + error.statusText);
	}
	pane.set("href", "error/gagal.html");
}

function formatDate(value, format){
	if(!value) return null;
	return retval = dojo.date.locale.format(new Date(value), {datePattern: format, selector: "date"});
}

function formatWaktu(value) {
	if(!value) return "...";
    return dojo.date.locale.format(new Date(value), {datePattern: "d MMM yyyy", timePattern: "HH:mm:ss"});
}

function getDateTime(date, time){
	var itemDate = formatDate(date, 'd');
	var itemMonth = formatDate(date, 'MM');
	var itemYear = formatDate(date, 'yyyy');
	var itemHour = formatDate(time, 'HH');
	var itemMinute = formatDate(time, 'mm');
	var itemSecond = formatDate(time, 'ss');
	
	if(itemDate!=null && itemMonth!=null && itemYear!=null && itemHour!=null && itemMinute!= null && itemSecond!=null){
		return new Date(itemYear, itemMonth-1, itemDate, itemHour, itemMinute, itemSecond);
	}
	return null;
}

var dialogLoading = null;
function showLoadingDialog(content){
    var htmlContent = "<center style=\"font-size: 12px; background: rgb(0, 0, 0, 0.6); font-weight: bold; color: red;\">" + content + "<br><br><img src=\"/img/loading.gif\" width=\"100px\" height=\"100px\" ></center>";
    console.log(htmlContent);
    
    if(dijit.byId("idDialogLoading") == null){
        dialogLoading = new dijit.Dialog({
            id: "idDialogLoading",
            title: "Loading. . .",
            style: "width: 300px; height: 180px; border: 0px;"
        });
    }
    dijit.byId("idDialogLoading").set("content", htmlContent);
    dialogLoading.show();
}

function formatNumber(value) {
    return dojo.number.format(value);
}
