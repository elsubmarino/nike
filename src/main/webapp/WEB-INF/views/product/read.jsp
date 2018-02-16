<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="row">
	<div class="col-md-5">
		<c:forEach items="${product }" var="item" varStatus="i">
			<c:if test="${i.index%2==0 }">
				<div class="row">
			</c:if>
			<img src='${item.url }'>
			<c:if test="${i.index%2==1 or i.index+1==item.size }">
	</div>
	</c:if>
	</c:forEach>
</div>

<div class="col-md-7">
	<h3>${product.get(0).name }</h3>
	<div class="row">${product.get(0).type }$${product.get(0).price }</div>
	<div class="row">
		<div class="row">
			<b>CHOOSE SIZE</b> Size Guide
		</div>
		<div class="row">
			<table class="table table-bordered">
				<c:forEach items="${sizes }" var="item" varStatus="i">
					<c:if test="${i.index % 5==0 }">
						<tr>
					</c:if>
					<td>${item.size }</td>
					<c:if test="${i.index % 5==4 or i.index+1 == fn:length(sizes) }">
						</tr>
					</c:if>
				</c:forEach>
			</table>
		</div>
		<div class="row">
			<button class="btn btn-default">ADD TO CART</button>
			<button class="btn btn-default">&hearts;</button>
		</div>
	</div>
	<div class="row">${product.get(0).description }</div>
	<div class="row">${product.get(0).description }</div>
	<div class="row">
		<ul>
			<li><c:forEach items="${colors }" var="item" varStatus="i">
	${item.name }
	<c:if test="${fn:length(colors) ne i.index+1 }">
	/
	</c:if>
				</c:forEach></li>
		</ul>
	</div>
	<div class="row">
	FREE SHIPPING & RETURNS<div class="pull-right">+</div>
	</div>
	<div class="row" id="reviewMore">
	REVIEWS(${countOfReviews }) ${ratings }  <span id="more" style="cursor:pointer">+</span>
	</div>
	<div class="row">
	MORE INFO
	</div>
	<div class="row">
	Need Help? Chat Now
	</div>
</div>
</div>
<div class="row">
<div>THESE POPULAR PRODUCTS MIGHT INTEREST YOU</div>
</div>
<div class="row">
<table>
<tr>
<td></td>
</tr>
</table>
</div>
<script>
var detail=0;
$("#more").on("click",function(evt){
	if(detail==0){
	var num={num:"${product.get(0).num}"};
	$.ajax({
		url:'/product/reviews',
		method:'post',
		data:num,
		success:function(evt){
			var append="";
			evt.forEach(function(v,i){
				append+="<div class='row'></div>";
				append+="<div class='row'>"+v.description+"</div>";
				append+="<div class='row'><span>"+v.star +"</span> <span>"+v.username+"</span></div>";
			});
			$("#reviewMore").append(append);
			detail=1;
		},
		error:function(a,b,c){
			alert("잘못된 접근입니다.");
		}
	});
	}
});
</script>
