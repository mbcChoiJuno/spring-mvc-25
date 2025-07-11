<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>


<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">Board Detail</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">

      <div class="panel-heading">Board Detail Page</div>
      <!-- /.panel-heading -->
      <div class="panel-body">

        <!-- <form role="form" action="/mbc-board/api/board/v1/boards" method="post"> -->
          <div class="form-group">
            <label>no</label> <input class="form-control" name='title'
            value='<c:out value="${board.boardIndex}"/>' readonly="readonly">
          </div>
          
          <div class="form-group">
            <label>Title</label> <input class="form-control" name='title'
            value='<c:out value="${board.title}"/>' readonly="readonly">
          </div>

          <div class="form-group">
            <label>Text area</label>
            <textarea class="form-control" rows="3" name='content' readonly="readonly">
            <c:out value="${board.content}"/>
			</textarea>
          </div>

          <div class="form-group">
            <label>Writer</label> <input class="form-control" name='writer'
            value='<c:out value="${board.writer}"/>' readonly="readonly">
          </div>
          <button data-oper="modify" class="btn btn-default" 
          onclick="location.href='/mbc-board/views/modifyBoardView<c:out value="${board.boardIndex}"/>'">수정하기</button>
          <button data-oper="list" class="btn btn-default"
          onclick="location.href='/mbc-board/views/boardListView'">목록으로</button>
        <!-- </form> -->

      </div>
      <!--  end panel-body -->

    </div>
    <!--  end panel-body -->
  </div>
  <!-- end panel -->
</div>
<!-- /.row -->
<%@include file="../includes/footer.jsp"%>
