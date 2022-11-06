<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<ul>
	<li onclick="kakaoLogin();">
      <a href="javascript:void(0)">
          <span>카카오 로그인</span>
      </a>
	</li>
	<li onclick="kakaoLogout();">
      <a href="javascript:void(0)">
          <span>카카오 로그아웃</span>
      </a>
	</li>
	<li onclick="friend();">
      <a href="javascript:void(0)">
          <span>테스트</span>
      </a>
	</li>
</ul>
<!-- 카카오 스크립트 -->
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script>
Kakao.init('4149bafdb9a5a5f288ffa60a0dbfbd37'); //발급받은 키 중 javascript키를 사용해준다.
console.log(Kakao.isInitialized()); // sdk초기화여부판단
//카카오로그인
var token_test = "";
function kakaoLogin() {
    Kakao.Auth.login({
      success: function (response) {
        Kakao.API.request({
          url: '/v2/user/me',
          success: function (response) {
        	  console.log(response)
          },
          fail: function (error) {
            console.log(error)
          },
        })
      },
      fail: function (error) {
        console.log(error)
      },
    })
  }
//카카오로그아웃  
function kakaoLogout() {
    if (Kakao.Auth.getAccessToken()) {
      Kakao.API.request({
        url: '/v1/user/unlink',
        success: function (response) {
        	console.log(response)
        },
        fail: function (error) {
          console.log(error)
        },
      })
      Kakao.Auth.setAccessToken(undefined)
    }
  }

function send_test(){
	Kakao.API.request({
		  url: '/v2/api/talk/memo/default/send',
		  data: {
		    template_object: {
		      object_type: 'feed',
		      content: {
		        title: '딸기 치즈 케익',
		        description: '#케익 #딸기 #삼평동 #카페 #분위기 #소개팅',
		        image_url:
		          'https://mud-kage.kakao.com/dn/Q2iNx/btqgeRgV54P/VLdBs9cvyn8BJXB3o7N8UK/kakaolink40_original.png',
		        link: {
		          web_url: 'https://developers.kakao.com',
		          mobile_web_url: 'https://developers.kakao.com',
		        },
		      },
		      item_content: {
		        profile_text: 'Kakao',
		        profile_image_url: 'https://mud-kage.kakao.com/dn/Q2iNx/btqgeRgV54P/VLdBs9cvyn8BJXB3o7N8UK/kakaolink40_original.png',
		        title_image_url: 'https://mud-kage.kakao.com/dn/Q2iNx/btqgeRgV54P/VLdBs9cvyn8BJXB3o7N8UK/kakaolink40_original.png',
		        title_image_text: 'Cheese cake',
		        title_image_category: 'Cake',
		        items: [
		          {
		            item: 'Cake1',
		            item_op: '1000원',
		          },
		          {
		            item: 'Cake2',
		            item_op: '2000원',
		          },
		          {
		            item: 'Cake3',
		            item_op: '3000원',
		          },
		          {
		            item: 'Cake4',
		            item_op: '4000원',
		          },
		          {
		            item: 'Cake5',
		            item_op: '5000원',
		          },
		        ],
		        sum: 'Total',
		        sum_op: '15000원',
		      },
		      social: {
		        like_count: 100,
		        comment_count: 200,
		      },
		      buttons: [
		        {
		          title: '웹으로 보기',
		          link: {
		            mobile_web_url: 'https://developers.kakao.com',
		            web_url: 'https://developers.kakao.com',
		          },
		        },
		        {
		          title: '앱으로 보기',
		          link: {
		            mobile_web_url: 'https://developers.kakao.com',
		            web_url: 'https://developers.kakao.com',
		          },
		        },
		      ],
		    },
		  },
		})
		  .then(function(response) {
		    console.log(response);
		  })
		  .catch(function(error) {
		    console.log(error);
		  });
}

function friend(){
	Kakao.Picker.selectFriends({
		  title: '친구 선택',
		  maxPickableCount: 10,
		  minPickableCount: 1,
		})
		  .then(function(response) {
		    console.log(response);
		  })
		  .catch(function(error) {
		    console.log(error);
		  });

		// 리다이렉트 방식
		// 성공: ${returnUrl}?selected=${SelectedUsers}
		// 실패: ${returnUrl}?error=${Error}
		Kakao.Picker.selectFriends({
		  returnUrl: 'https://localhost:8080', // 필수
		  title: '친구 선택',
		  maxPickableCount: 10,
		  minPickableCount: 1,
		});
}
</script>
  
</body>

</html>