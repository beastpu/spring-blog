
				$(function(){
					
						$.ajax({
							url:"sign/wen",
						   
							success:function(data){
							$("#b").html(data);
						}
					});
				  });

				
				$(function(){
			    	
			    	$("#button").on("click",function(){
			    		$.ajax({
			    			type:"GET",
			    			headers: {
			    				Accept:"application/json; charset=utf-8",
			    				"Content-Type":"application/json; charset=utf-8"
			    			},
			    			
			    			url:"sign/user",
			    			success:function(data){
			    					    			
			    				var result="";
			    				for(var i=0; i<data.length; i++)
			    				result +="<br>"+data[i].id+'-'+data[i].username;
			    			    $("#user").html(result);
			    			}
			    			  
			    		});	 
			    	});	
		
				});
				
				//get example
				
			var xhr=new XMLHttpRequest();
			xhr.onload=function(){
				
			if(xhr.status===200){
				
			document.getElementById("b").innerHTML="<h1>"+xhr.responseText+"</h1>";
				}
				};
				xhr.open("GET","sign/wen",true);
				xhr.send();
				
				// post example
				
$(function(){
			    	
			    	$("#abc").on("click",function(){
			    		
			    		var user='{"username":"wo","encodedPassword":"yao"}';
			    		$.ajax({
			    			type:"POST",
			    			contentType : 'application/json;charset=utf-8',
			    			url:"sign/add",
			    		
			    			data: '{"username":"wo","encodedPassword":"yao"}',
			    			
			    			success:function(data){
			    					    			
			    				alert("success");
			    			}
			    			  
			    		});	 
			    	});	
		
				});

//从键盘输入

$(function(){
	
	$("#adduser").on("click",function(){
		var a=$("#a").val();
		var b=$("#password1").val();
		var user1={username:a,encodedPassword:b};
		
		$.ajax({
			type:"POST",
			contentType :'application/json;charset=utf-8',
			url:"sign/addForm",
			data:JSON.stringify(user1),
			
			success:function(data){				    			
				alert("success");
			}
			  
		});	 
	});	

});



$(function(){
  	 
   
   	$("#find").on("click",function(){
   		var id=$("#id").val();
   		$.ajax({
   			
   			type:"GET",
			
   			url:"sign/ajax/"+id+"",
   			success:function(data){
   				alert("success");
   				var result="";
   			
   				result+="<br>"+data.id+'-'+data.username;
   				//$("#item").html("<br>"+data.id+"-"+data.username);
   				$("#item").html(result);
   			    
   			}
   		
   		});
   	});
   	
   });

		
			
			