$(function(){

	$.ajax({
		url: 'getBingImg',
		type: 'GET',
//		dataType: 'JSONP',
		// data: {'format':'js' , 'idx':'0' , 'n':'1' , 'mkt':'zh-CN'},
		success: function(result){
              console.log(result);
              $("#bingimg").attr('src',result); 
            }
		
		
	})
	
	
});