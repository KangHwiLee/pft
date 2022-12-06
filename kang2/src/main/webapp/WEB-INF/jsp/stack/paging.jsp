<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<script src="resources/core_ui/js/main.js"></script>
<style>
.pagination{display:block;padding-top:35px;text-align:center;clear: both;}
.pagination ul li{display:inline-block; vertical-align:top; margin:2px; padding:0;cursor:pointer}
.pagination ul li a{display:block;height:28px; border:1px solid #67738c; line-height:26px; font-size:14px; font-weight:400;color:#67738c;padding:0 5px}
.pagination ul li a.active{background:#67738c;color:#292d36;}
</style>
<div id="paging_study">
	<table class="table table-striped table-sm">
				<thead>
					<tr>
						<th>No.</th>
						<th>제목</th>
						<th>카테고리</th>
					</tr>
				</thead>
				<tbody id="paging_table">
				
				
				
				</tbody>
			</table>
			<div class="pagination" id="pagination_1">
			
			</div>
		
	
		</div>

          <!-- /.row-->
          <div class="card mb-4">
            <div class="card-body">
              <div class="d-flex justify-content-between">
                <div>
                  <h4 class="card-title mb-0">설명</h4>
                  <div class="small text-medium-emphasis">Back-End Developer</div>
                </div>
                </div>
              </div>
              <div class="c-chart-wrapper" style="height:300px;margin-top:40px;">
               <p style="padding-left:14px">웹 개발의 가장 기초이면서 자주써야하는 기술인 페이징입니다.</p><br>
               <p style="padding-left:14px">자세한 설명은 제 블로그 tistory에 올려놓았습니다.</p><br>
               <p style="padding-left:14px"><a href="https://eight-letter.tistory.com/11">https://eight-letter.tistory.com/11</a></p><br>
               <p style="padding-left:14px">감사합니다</p><br>
              </div>
            </div>
          <!-- /.card.mb-4-->
          <!-- /.row-->
<script>
$(document).ready(function(){
	paging_1(1);
})
</script>