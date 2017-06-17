


$(function(){
   $("#user_picture").mouseover(function(){
   	
  		$("#chgpic" ).show();
	});

    $("#user_picture").mouseout(function(){
   	
  		$("#chgpic" ).hide();
	});


    $("#achgpic").click(function(){
		$("#uploadpic").show(500);
	});

	$("#cancel").click(function(){
		$("#uploadpic").hide(500);
	});
});



$(function(){

	$("#chgpassword").click(function(){
		// $("#userinformation").hide();
		// $("#score").hide();
		// $("#logout").hide();
		$("#chgpage").fadeIn(500);
		$("#publishmessage").hide();
		// $("#logpage").toggle( "blind" );
	})
});

var xmlhttp;
function chg(){
	var logbtn=document.getElementById("chgbtn");
	logbtn.disabled="disabled";
	document.getElementById("tryagain").innerHTML="请2秒后重试";

  var password1 = document.getElementById("cpassword1").value;
  var password2=document.getElementById("cpassword2").value;

  if (password1&&password2) 
  {

  	if (password1==password2) 
	  {
	  	  var par="&password1="+password1;
		  var url = "change.action";
		 
		  xmlhttp =new XMLHttpRequest(); 
		  xmlhttp.onreadystatechange=chgResult; //响应函数
		  xmlhttp.open("POST",url,true);   //设置访问的页面
		  xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		  xmlhttp.send(par);  //执行访问

		  setTimeout(btnactive,2000);
	  }

	  else
	  {
	  		document.getElementById('chgResult').innerHTML="两次输入的密码不一致！";
	  		setTimeout(btnactive,2000);
	  }



  }


  else
  {
  		document.getElementById('chgResult').innerHTML="密码不能为空";
	  	setTimeout(btnactive,2000);
  }


  
  
}
 
function chgResult(){
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	  console.log(xmlhttp.responseText);
	if (xmlhttp.responseText=="true") 
	{
		window.location.href="newwelcome.jsp";
	}
	else
	{
		document.getElementById('chgResult').innerHTML="修改失败！未知原因";

	}
    
  
}

//2秒内禁用按钮，防止表单重复提交
	function btnactive()
	{
		document.getElementById("chgbtn").removeAttribute('disabled');
		document.getElementById("tryagain").innerHTML="";
		document.getElementById('chgResult').innerHTML="";
	}










$(function(){

	$("#reload1").click(function(){
		$("#chgpage").hide(500);
		$("#publishmessage").show();
	})
});


//用ajax实现发布动态的功能
$(function(){

	$("#publishmessage").click(function(){		
		// $("#newmessage").show(500);

		var newmessage=$("#saysomething").val();
		if (newmessage=="")
		{
			alert("写点什么吧，不要为空哦");
		}

		else
		{


			// newmessage=newmessage.replace(/<script>/i,"script");
			// newmessage=newmessage.replace(/<\/script>/i,"/script");
			
			for (var i = 0; i < newmessage.length; i++) {
				newmessage=newmessage.replace(/</i,"&lt");
				newmessage=newmessage.replace(/>/i,"&gt");
			}



			
			$.ajax({
			url: 'publishMessage',
	    	type: 'POST',
	    	async:false,
	    	// dataType: 'default: Intelligent Guess (Other values: xml, json, script, or html)',
	    	data: {"content": newmessage},
	    	success:function(result)
	    	{
	    		console.log(result);
	    		
	    			$("#shownewmessage").text(newmessage);

	    			$("#newmessage").show(500);


	    			//修改次元素的ID
	    			$("#newmessage").attr('id','oldmessages');

	    			$("#msgdingwei").after('<div class="panel panel-default" id="newmessage" style="display: none; margin-top:18px;">'+
						  '<div class="panel-heading">'+$('#js-name').text() +'<font style="float: right; margin-right: 5px;">刚刚</font></div>'+
						  '<div class="panel-body" id="shownewmessage">'+
						    '面板内容'+
						  '</div>'+
						'</div>');


	    		
	    	}
	    });
	}

	});
});



//ajax实现无刷新删除动态的功能
var xmlhttp;
	function delmsg(del_id){
	

	  var par="del_id="+del_id;
	  var url = "deleteMessage.action";
	 
	  xmlhttp =new XMLHttpRequest(); 
	  xmlhttp.onreadystatechange=delResult; //响应函数
	  xmlhttp.open("POST",url,false);   //设置访问的页面
	  xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	  xmlhttp.send(par);  //执行访问

	  setTimeout(btnactive,2000);
	}
	 
	function delResult(){
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
		  console.log(xmlhttp.responseText);
		var msg_id="#msg_"+xmlhttp.responseText;
		console.log(msg_id);
		$(msg_id).hide(500);
	    
	  
	}


	$(document).ready(function(){
		  
	    
	    var nowmonth=moment().month()+1;

	    var monthimgurl="http://zxd-1253592841.file.myqcloud.com/img/bonus_"+nowmonth+".jpg";

	    $("#monthimg").attr("src",monthimgurl) ;



	    //解决手机浏览器排版问题
	    var ua = navigator.userAgent;
		var ipad = ua.match(/(iPad).*OS\s([\d_]+)/);
	    isIphone = !ipad && ua.match(/(iPhone\sOS)\s([\d_]+)/);
	    isAndroid = ua.match(/(Android)\s+([\d.]+)/);
	    isMobile = isIphone || isAndroid;
	    if(isMobile) {
	        $("#right-info").css('display', 'none');
	    }


	   
	   
	  });



	$(function(){

		 $('div.holder').jPages({
		        containerID : "allmessages",
		        first: '首页',
		        last: '尾页',
		        previous: '上页',
		        next: '下页', 
		        perPage : 10,  
		       // animation: "bounceInLeft"

		        animation: "fadeInUp"

		      });

	});


//下面是发表评论的功能
   function publishreply(pub_rep_id)
   {

   		var reply_msg_id=pub_rep_id;
   		var username=$('#js-username').text();
   		var name=$('#js-name').text();
   		var textid="#reply_text_"+pub_rep_id;
   		var content=$(textid).val();

   		var dingwei="#replydingwei_"+pub_rep_id;

   		$.ajax({
   			url: 'publishReply',
   			type: 'POST',
   			async:false,
   			// dataType: 'default: Intelligent Guess (Other values: xml, json, script, or html)',
   			data: {'username':username , 'messageid':pub_rep_id , 'content':content},
   			success:function(result)
   			{
   				$('#newreply_name').text(name);
   				$('#newreply_content').text(content);

   				$("#newreply").show(500);
   			}
   		});
   		
   		
   		



   }





 






