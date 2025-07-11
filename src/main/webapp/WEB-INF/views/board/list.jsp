<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 

<%@ include file="../includes/header.jsp" %> <!-- 위쪽에 반복되는 메뉴들... -->


            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">게시판</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                           MBCBoard List Page
                           <button id="regBtn" type="button" class="btn btn-xs pull-right">게시글 등록</button>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>#번호</th>
                                        <th>제목</th>
                                        <th>작성자</th>
                                        <th>작성일</th>
                                        <th>수정일</th>
                                    </tr>
                                </thead>
                                
                                
                             	<!-- 데이터 영역 -->
                             	<c:forEach items="${list}" var="board">
                             		
                             		<tr>
	                             		<td><c:out value="${board.boardIndex}"/></td>
	                             		<td>
	                             			<a href="/mbc-board/api/board/v1/boards/<c:out value="${board.boardIndex}"/>">
		                             			<c:out value="${board.title}"/>
	                             			</a>
	                             		</td>
	                             		<td><c:out value="${board.writer}"/></td>
	                             		<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.createDate}"/></td>
	                             		<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate}"/></td>
                             		</tr>
                             	</c:forEach>
                             
                             </table>   
                             
                             <!-- Modal -->
                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">MBC Board</h4>
                                        </div>
                                        <div class="modal-body">
                                            처리 완료
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
                                            <button type="button" class="btn btn-primary">저장</button>
                                        </div>
                                    </div>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
                            </div>
                            <!-- /.modal -->
                            
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-6 -->
            </div>
            <!-- /.row -->
    
    <%@ include file="../includes/footer.jsp" %>
    
    <script type="text/javascript">
    
    $(document).ready(
    	function() {
			var result = '<c:out value="${result}"/>';
			
			checkModal(result);
	    	
	    	function checkModal(result) {
				if (result === '')
					return;
				
				if (parseInt(result) > 0) 
					$(".modal-body").html("게시글 " + parseInt(result) + "번이 등록 되었습니다.");
				
				$("#myModal").modal("show");
			}

	    	$("regBtn").on("click", function() {
				self.location = "/mbc-board/views/board/registBoardView";
			});
		}		
		
    	
    );
    
    </script>
    
    
    
    
    
    