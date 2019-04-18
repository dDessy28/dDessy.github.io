// Dibuat oleh : dDessy
// Referensi dari berbagai sumber
// https://www.leggetter.co.uk/2010/03/12/making-cross-domain-javascript-requests-using-xmlhttprequest-or-xdomainrequest.html

$(document).keypress(
  function(event){
    if (event.which == '13') {
      event.preventDefault();
      document.getElementById("errapi").innerHTML = "Silakan gunakan 'Get List'";
    }
});

$(function () {
    $('.tree li').hide();
    $('.tree li:first').show();
    $('.tree li').on('click', function (e) {
        var children = $(this).find('> ul > li');
        if (children.is(":visible")) children.hide('fast');
        else children.show('fast');
        e.stopPropagation();
    });
});

function searchBL() {
	//var panelExist = document.getElementsByClassName("panel-group");
	//if (panelExist) {
		//panelExist.remove();
	//}
	var param = document.getElementById("param").value;
	if (param === "") {
		document.getElementById("errapi"). innerHTML = "Please input keyword";
	} else {
		if (param.includes(",")) {
			var params = param.split(",").reverse();
			params.forEach(split => {
				callOtherDomain(split);
			});
		} else {
			callOtherDomain(param);
		}
	}
}

function callOtherDomain(param) {
	var request;
	var isIE8 = window.XDomainRequest ? true : false;
	if (isIE8) {
		request = new window.XDomainRequest();
	} else {
		request = new XMLHttpRequest();
	}
	if (request) {
		var url = 'https://www.bukalapak.com/omniscience/v2?word=' + param + '&user=undefined&key=undefined';
		if(isIE8) {
			request.onload = outputResult(request, param);
			request.open("GET", url, true);
			request.send();
		} else {
			request.open('GET', url, true);
			request.onreadystatechange = function() {
				if (request.readyState == 4) {
					if (request.status == 200) {
					outputResult(request, param);
					} else {
					alert("request Errors Occured");
					}
				}
			}
			request.send();
		}
	} else {
	  var text = "No request TookPlace At All";
	  var textNode = document.createTextNode(text);
	  var textDiv = document.getElementById("resapi");
	  textDiv.appendChild(textNode);
	}
}

function outputResult(request, param) {
	document.getElementById("hide").style.display = "inline-block";
	var tree =  '<li><a>' + param + '</a><ul>';
	var treeend = "</div></div></div></span></li>";
	var panelHead = '<li><span class="panel-group" style="display:inline-block;"><div class="panel panel-primary"><div class="panel-heading">';
	var panelBody = '<div class="panel-body" ><div class="col-lg-2" >';
	var response = request.responseText;
	var jsonres = JSON.parse(response);
	jsonSuggest = jsonres.word;
	if (jsonSuggest.length > 0) {
		var panelSuggest = panelHead + "Total Suggest : " + jsonSuggest.length + "</div>" + panelBody;
		jsonSuggest.forEach(element => {
			panelSuggest += element + "<hr>";
		});
		panelSuggest += treeend;
		tree += panelSuggest;
	}
	
	jsonToko = jsonres.user;
	if (jsonToko.length > 0) {
		var panelToko = panelHead + "Total Toko : " + jsonToko.length + "</div>" + panelBody;
		jsonToko.forEach(element => {
			panelToko += "<img src='" + element.img + "' align='left' style='margin-right:0.5em;'>Toko id : " + element.id + "<br>Nama Toko : " + element.name + "<br>Url Toko : https://bukalapak.com" + element.url + "<hr>";
		});
		panelToko += treeend;
		tree += panelToko;
	}
	
	jsonCategory = jsonres.category;
	if (jsonCategory.length > 0) {
		var panelCategory = panelHead + "Total Kategori : " + jsonCategory.length + "</div>" + panelBody;
		jsonCategory.forEach(element => {
			panelCategory += "Kategori id : " + element.id + "<br>Kategori : " + element.category + "<br>Nama : " + element.name + "<br>Url : https://bukalapak.com" + element.url + "<hr>";
		});
		panelCategory += treeend;
		tree += panelCategory;
	}
	
	jsonHarga = jsonres.product;
	if (jsonHarga.length > 0) {
		var panelHarga = panelHead + "Total Produk : " + jsonHarga.length + "</div>" + panelBody;
		jsonHarga.forEach(element => {
			panelHarga += "<img src='" + element.img + "'align='left' style='margin-right:0.5em;'>Produk id : " + element.id + "<br>Nama Produk : " + element.name + "<br>Harga Produk : Rp " + element.price + "<br>Url Toko : https://bukalapak.com" + element.url + "<hr>";
		});
		panelHarga += "</div></div></div></span></ul></li>";
		var textDiv = document.getElementById("resapi");
		textDiv.insertAdjacentHTML('afterbegin', tree + panelHarga);
	}
	
	function escapeHtml(text) {
	  var map = {
	    '&': '&amp;',
	    '<': '&lt;',
	    '>': '&gt;',
	    '"': '&quot;',
	    "'": '&#039;'
	  };
	  return text.replace(/[&<>"']/g, function(m) { return map[m]; });
	}
}