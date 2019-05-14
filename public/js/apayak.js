// Dibuat oleh : dDessy
// 24 april 2019
// Referensi dari berbagai sumber

var global = true;

function apaYa(id) {
	return document.getElementById(id);
}

function waktu(stamp) {
	var jam = new Date(stamp);
	return jam.toLocaleString("id-ID");
}

function persen(num, per) {
	var diskon = (num/100)*per;
	return (per - diskon).toFixed(2).split(".")[0];
}

//html-online.com/articles/get-url-parameters-javascript/
function getUrlVars() {
    var vars = {};
    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
        vars[key] = value;
    });
    return vars;
}

function cariToko(sku, idProduk) {
	if(sku !== "" && idProduk !== "") {
		var sSku = sku.split("-");
		var tambah = "";
		sSku.forEach( cari => {
			if (!tambah) {
				tambah += cari;
			}
			else {
				tambah += " " + cari;
			}
			callOtherDomain(tambah, idProduk, false);
		});
	}
	else {
		return;
	}
}

function callOtherDomain(param, idProduk, id) {
	apaYa("muter").style.display = "block";
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
			request.onload = outputResult(request, param, idProduk);
			request.open("GET", url, true);
			request.send();
		} else {
			request.open('GET', url, true);
			request.onreadystatechange = function() {
				if (request.readyState == 4) {
					if (request.status == 200) {
						outputResult(request, param, idProduk);
					} else {
						mancing("resapi").innerHTML = '<p style="color:red;">[?]beberapa request tidak merespon</p>';
					}
				}
			}
			request.send();
		}
	} else {
	  var text = "No request TookPlace At All";
	  var textNode = document.createTextNode(text);
	  var textDiv = apaYa("resapi");
	  textDiv.appendChild(textNode);
	}
}

function outputResult(request, kw, idProduk) {
	var ketemu = false;
	apaYa("resapi").style.display = "block";
	var tree =  "";
	var treeend = "</div></div></div></div>";
	var panelHead = '<div class="panel-group" ><div class="panel panel-primary"><div class="panel-heading">';
	var panelBody = '<div class="panel-body" ><div class="col-lg-2">';
	var response = request.responseText;
	var jsonres = JSON.parse(response);
	if (!kw || !idProduk) {
		var panelToko = panelHead + "Keyword : " + kw + "   ||   Total Toko : " + jsonToko.length + "</div>" + panelBody;
		panelToko += "<p style='color:red;'>error!</p><hr>";
		panelToko += treeend;
		var textDiv = apaYa("resapi");
		textDiv.insertAdjacentHTML("afterbegin",panelToko);
		apaYa("muter").style.display = "none";
	}
	else {
		var panelDanger = '<div class="panel-group"><div class="panel panel-danger"><div class="panel-heading">';
		var jsonHarga = jsonres.product;
		if (jsonHarga.length > 0) {
			var panelHarga = panelDanger + "Keyword : " + kw + "   ||   Total Produk : " + jsonHarga.length + "</div>" + panelBody;
			jsonHarga.forEach(element => {
				if (element.url.split("/").reverse()[0].split("-")[0] === idProduk) {
					panelHarga += "<div class='jumbotron' style='background-color:cyan;'><h4>Apa produk ini yang kakak cari?</h4><img src='" + element.img + "'align='left' style='margin-right:0.5em;'>Produk id : " + element.id + "<br><b style='color:red;'>Url id : " + element.url.split("/").reverse()[0].split("-")[0] + "</b><br>Nama Produk : " + element.name + "<br>Harga Produk : Rp " + element.price + "<br>Url Toko : https://bukalapak.com" + element.url + "<br><a href='https://bukalapak.com" + element.url + "' target='_blank' class='btn btn-primary' >Cek TKP</a><br>";
					if (getUrlVars()["cek"]) {
						panelHarga += "<h4>Diskon : " + getUrlVars()['cek'] + "%<br>Kisaran Harga : Rp " + persen(getUrlVars()['cek'], element.price) + "<br><span style='color:red;'>Perkiraan Harga Hanya Perhitungan Sistem, Bisa Jauh Berbeda!!!</h4></div><hr>";
					}
					else {
						panelHarga += "</div><hr>";
					}
					ketemu = true;
				}
				else {
					panelHarga += "<img src='" + element.img + "'align='left' style='margin-right:0.5em;'>Produk id : " + element.id + "<br>Nama Produk : " + element.name + "<br>Harga Produk : Rp " + element.price + "<br>Url Toko : https://bukalapak.com" + element.url + "<hr>";
				}
			});
			panelHarga += treeend;
			if (global) {
				var textDiv = apaYa("resapi");
				textDiv.insertAdjacentHTML("afterbegin", panelHarga);
				if (ketemu) {
					global = false;
				}
			}
			apaYa("muter").style.display = "none";
		}
	}
}
