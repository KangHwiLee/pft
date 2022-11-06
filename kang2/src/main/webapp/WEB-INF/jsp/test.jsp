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
          <span>īī�� �α���</span>
      </a>
	</li>
	<li onclick="kakaoLogout();">
      <a href="javascript:void(0)">
          <span>īī�� �α׾ƿ�</span>
      </a>
	</li>
	<li onclick="friend();">
      <a href="javascript:void(0)">
          <span>�׽�Ʈ</span>
      </a>
	</li>
</ul>
<!-- īī�� ��ũ��Ʈ -->
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script>
Kakao.init('4149bafdb9a5a5f288ffa60a0dbfbd37'); //�߱޹��� Ű �� javascriptŰ�� ������ش�.
console.log(Kakao.isInitialized()); // sdk�ʱ�ȭ�����Ǵ�
//īī���α���
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
//īī���α׾ƿ�  
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
		        title: '���� ġ�� ����',
		        description: '#���� #���� #���� #ī�� #������ #�Ұ���',
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
		            item_op: '1000��',
		          },
		          {
		            item: 'Cake2',
		            item_op: '2000��',
		          },
		          {
		            item: 'Cake3',
		            item_op: '3000��',
		          },
		          {
		            item: 'Cake4',
		            item_op: '4000��',
		          },
		          {
		            item: 'Cake5',
		            item_op: '5000��',
		          },
		        ],
		        sum: 'Total',
		        sum_op: '15000��',
		      },
		      social: {
		        like_count: 100,
		        comment_count: 200,
		      },
		      buttons: [
		        {
		          title: '������ ����',
		          link: {
		            mobile_web_url: 'https://developers.kakao.com',
		            web_url: 'https://developers.kakao.com',
		          },
		        },
		        {
		          title: '������ ����',
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
		  title: 'ģ�� ����',
		  maxPickableCount: 10,
		  minPickableCount: 1,
		})
		  .then(function(response) {
		    console.log(response);
		  })
		  .catch(function(error) {
		    console.log(error);
		  });

		// �����̷�Ʈ ���
		// ����: ${returnUrl}?selected=${SelectedUsers}
		// ����: ${returnUrl}?error=${Error}
		Kakao.Picker.selectFriends({
		  returnUrl: 'https://localhost:8080', // �ʼ�
		  title: 'ģ�� ����',
		  maxPickableCount: 10,
		  minPickableCount: 1,
		});
}
</script>
  
</body>

</html>