<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
            <div class="col-12">
              <div class="card mb-4">
                <div class="card-header"><strong>Code</strong></div>
                <div class="card-body">
                    <script>
    $(document).ready(function(){
  var code = $(".codemirror-textarea")[0];
  var editor = CodeMirror.fromTextArea(code, {
    lineNumbers : true,
    lineWrapping: true, //줄바꿈. 음.. break-word;
    theme: "darcula",
    mode : 'text/javascript',
    val : $(".codemirror-textarea")[0].value
  });
});
</script>
                   <textarea class="codemirror-textarea" style="width:auto;">
                   ${data }
                   </textarea>
                </div>
              </div>
            </div>
            
            