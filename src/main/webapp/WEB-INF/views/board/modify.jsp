<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>


<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">Board Modify</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">

      <div class="panel-heading">Board Modify Page</div>
      <!-- /.panel-heading -->
      <div class="panel-body">

      	<form id="updateForm" role="form" action="/mbc-board/api/board/v1/boards" method="post"> -
          <div class="form-group">
            <label>no</label> <input class="form-control" name="boardIndex"
            value='<c:out value="${board.boardIndex}"/>' readonly="readonly">
          </div>
          
          <div class="form-group">
            <label>Title</label> <input class="form-control" name='title'
            value='<c:out value="${board.title}"/>'>
          </div>

          <div class="form-group">
            <label>Text area</label>
            <textarea class="form-control" rows="3" name='content'>
            <c:out value="${board.content}"/>
			</textarea>
          </div>

          <div class="form-group">
            <label>Writer</label> <input class="form-control" name='writer'
            value='<c:out value="${board.writer}"/>' readonly="readonly">
          </div>
          <!-- <button type="submit" data-oper="modify" class="btn btn-default">수정하기</button> -->
          <button type="button" onclick="sendJsonPutRequest()">수정하기</button>
          <!-- <button type="submit" data-oper="remove" class="btn btn-default">삭제하기</button> -->
          <button data-oper="modify" class="btn btn-default" 
          onclick="location.href='/mbc-board/api/board/v1/deleteBoard/<c:out value="${board.boardIndex}"/>'">삭제하기</button>
          <!-- <button type="submit" data-oper="list" class="btn btn-default">목록으로</button> -->
          <button data-oper="list" class="btn btn-default"
          onclick="location.href='/mbc-board/views/boardListView'">목록으로</button>
      	</form> 

      </div>
      <!--  end panel-body -->

    </div>
    <!--  end panel-body -->
  </div>
  <!-- end panel -->
</div>
<!-- /.row -->
<%@include file="../includes/footer.jsp"%>


    <script type="text/javascript">
    
    $(document).ready(
    	function() {
    		
    		var formObj = $("form");

	    	$("button").on("click", function(e) {
				e.preventDefault(); // 기존 기능 (submit) 안쓰겠다.
				
				var oper = $(this).data("oper");
				
				switch (oper) {
					case "remove" -> {
						formObj.attr("action", "/board/remove");
					}
					case "list" -> {
						self.location = "/board/list";
					}
					case "modify" -> {
						formObj.submit();
					}
				}
				
			});
		}		
		
    	function sendJsonPutRequest() {
    		  // 폼 데이터를 객체로 수집
    		  const form = document.getElementById("updateForm");

    		  const data = {
    		    boardIndex: form.boardIndex.value,
    		    title: form.title.value,
    		    content: form.content.value,
    		    writer: form.writer.value
    		  };

    		  fetch("/mbc-board/api/board/v1/boards", {
    		    method: "PUT",
    		    headers: {
    		      "Content-Type": "application/json"
    		    },
    		    body: JSON.stringify(data)
    		  })
    		  .then(response => {
    		    if (response.redirected) {
    		      // 서버에서 redirect:/board/list 리턴했을 경우
    		      window.location.href = response.url;
    		    } else {
    		      return response.text().then(console.log);
    		    }
    		  })
    		  .catch(error => console.error("에러 발생:", error));
    		}
    );
    
    </script>
    
    
