var xml;
function sendRequest(e)
{	
	if (window.XMLHttpRequest)
	  {
	  xml=new XMLHttpRequest();
	  }
	else
	  {
	  xml=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	url="search.action?fname="+e;
	xml.onreadystatechange=getResponse;
	xml.open("GET",url,true);
	xml.send(null);
}

function getResponse()
{
	if (xml.readyState==4){
			if(xml.status==200){
				document.getElementById("disp").innerHTML=xml.responseText;
		}
	}
}
