<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.model.*, com.sist.dao.*"%>
    
<%

		BoardModel model = new BoardModel();
		model.boardUpdateData(request);

%>    
    
    
    
<!DOCTYPE html> <!-- 5버전을 사용 예정!! insert.jsp 복사함-->
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<style type="text/css">

.row {
	margin: 0px auto; 
	width: 600px;	
}

h2 {

	text-align: center;
}

</style>
</head>
<body>
	<div class="container">
		<h2>수정하기</h2>
		<div class="row">
			<form method=post action="update_ok.jsp"> 
		
			<table class="table table-hover">
				<tr>
					<th width=20% class="text-right default success" >이름</th>
					<td width=80%>
					<input type=text name=name size=15 required value="${vo.name }">
					<input type="hidden" value="${vo.no }" name=no>
					</td>
				</tr>
				<tr>
					<th width=20% class="text-right default success" >제목</th>
					<td width=80%>
					<input type=text name=subject size=50 required value="${vo.subject }">
					</td>
				</tr>
				<tr> 
					<!-- input은 value에 넣고  textarea는 박에 놓기 -->
					<th width=20% class="text-right default success" >내용</th>
					<td width=80%>
					<textarea rows="8" cols="60" name=content required>${vo.content }</textarea>
					</td>
				</tr>
				<tr>
					<th width=20% class="text-right default success" >비밀번호</th>
					<td width=80%>
					<input type="password" name=pwd size=10 required value="${vo.pwd }">
					</td>
				</tr>
				
				<tr>
					<td class="text-center" colspan="2">
					<input type="submit" value="수정" class="btn btn-sm btn-primary">
					<input type="button" value="취소" class="btn btn-sm btn-danger"
					onclick="javascript:history.back()"> <!--취소버튼 눌렀을때  다시 돌아가기!-->
					</td>
				</tr>
			</table>
			</form>
		</div>
	</div>
</body>
</html>