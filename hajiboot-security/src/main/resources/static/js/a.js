
	$(function(){
	    	
	    	$("#result3").on("click",function(){
	    		$.ajax({
	    			type:"GET",
	    			headers: {
	    				Accept:"application/json; charset=utf-8",
	    				"Content-Type":"application/json; charset=utf-8"
	    			},
	    			
	    			url:"customers/json",
	    			success:function(data){
	    					    			
	    				var result="";
	    				for(var i=0; i<data.length; i++)
	    					result +="<br>"+data[i].id+'-'+data[i].firstName;
	    				$("#output").html(result);
	    				
	    			  
	    			}	  
	    		});	
	    });
	    
	});


	 
	  
	  
			 
			
			$(function(){
				
					$.ajax({
						
						type:"GET",
						url:"customers/getRandom",
					   
						success:function(data){
						 
						$("#target").html(data);
					}
				});
			  });
			
	    	 
	    
	
	
	
	
	 	  
		
		    $(function(){
		   	 
		    
		    	$("#buttonDemo2").on("click",function(){
		    		var id=$("#id").val();
		    		$.ajax({
		    			
		    			url:"customers/ajax/"+id+"",
		    			
		    			success:function(data){
		    				alert("sdfd");
		    				//var result="";
		    				//result +="<br>"+data.id+'-'+data.firstName;
		    				$("#result2").html(data.id);
		    				
		    			   
		    			}
		    		});
		    	});
		    	
		    });
		    
		    
	
	 
	
	 
	  
	 
			
			
		
	    			 
		
			 
				
		    	 
		  
		
	
	
	 	 