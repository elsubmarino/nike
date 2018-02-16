<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
${pageMaker.cri.page }
<table id="product">
	<c:forEach items="${products}" var="item" varStatus="stat">
		<c:if test="${stat.index % 5 ==0 }">
			<tr>
		</c:if>
				<td><a href="/product/read?num=${item.num }"><img src='${item.picture }'>${item.size_quantity}
					Color | ${item.name } ${item.type } ${item.price }</a></td>
		<c:if test="${stat.index % 5 == 4 }">
			</tr>
		</c:if>
	</c:forEach>
</table>
<script>
$(function(){
	var page=${pageMaker.cri.page};
	$(document).scroll(function(){
		if($(document).scrollTop()+$(window).height()==$(document).height()){
			var data={page:page+1};
			$.ajax({
				url:"/product/product",
				type:"post",
				data:data,
				success:function(evt){
					var data=evt;
					var content="";
					data.products.forEach(function(v,i){
						if(i%5==0)
							content+="<tr>";
						content+="<td><a href='"+v.num+"'><img src='"+v.picture+"'> "+v.size_quantity+" Color | "+v.name+" "+v.type+" "+v.price+"</a></td>";
						if(i%5==4)
							content+="</tr>";
					});
						$("#product").append(content);
					page+=1;	

					
				},
				error:function(a,b,c){
					alert("잘못된 요청입니다.");
				}
			});
		}
		
	});
});
</script>
