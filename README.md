## 헬스일정예약관리시스템

**개요**

  헬스 일정 관리가 사람에 의해 이루어짐으로써 발생하는 오차의 가능성과 불필요한 연락을 개선하기 위해 <u>헬스 일정 관리(신청/변경/조회)를 웹페이지로 시스템화</u> 하고, 별도의 <u>커뮤니티 게시판</u>을 개설함으로써 헬스장 사용자가 정보를 공유할 수 있도록 한다.



**시스템 구조**

![system-architecture](https://github.com/SeoJaeyeon/fitnessCenterManagementSystem/blob/master/img/system-architecture.PNG?raw=true)



**주요 요구사항 및 구현내용**

- <u>사용자 인증 및 권한 부여</u>: 별도의 카테고리 설정 없이 사용자 군(헬스장 관리자/트레이너/회원)별 로그인과 맞춤형 기능 제공

: Spring-Security를 통해 각각 ROLE_MANAGER, ROLE_TRAINER, ROLE_MEMER 권한을 부여하여 구현 

- <u>스케줄 조회</u>: 트레이너와 회원은 금주 PT 일정 확인 

: jsp 반복문을 통해 구현 

[schedule.jsp](https://github.com/SeoJaeyeon/fitnessCenterManagementSystem/blob/master/fitnessCenterManagementSystem/src/main/webapp/WEB-INF/views/schedule.jsp)

```html
<% int count=0;
	ArrayList<ScheduleDTO> list=new ArrayList<ScheduleDTO>();
	int size=-1;
	if(request.getAttribute("schedules")!=null){
		list = (ArrayList<ScheduleDTO>)request.getAttribute("schedules");
		size=list.size();
	}
	%>
  	<% for(int time=9; time<22; time++){ %>
    <tr>
      <th scope="row"><%= time %>시~<%= time+1 %>시</th>
	  <%for(int i=0; i<7; i++){ %>
	  	<td
	  		<% if(size>0 && list.get(count).getHour()==time && list.get(count).getDay()==i){%> style="background-color:rgb(204,255,255)">
	  			<%= list.get(count).getMember_name()%> 회원 - 	<%= list.get(count).getTrainer_name()%> 트레이너 
	  			 <%; if(count < size-1) count++; }else{%>><% }%>
	  	</td>
	  	<%}; %>
    </tr>
    <%}%>
```

- <u>스케줄 신청</u>: 회원은 2주 후의 PT일정 신청/변경/예약대기
- <u>개인정보 수정</u>: 트레이너와 회원은 자신의 개인정보(패스워드, 연락처, 프로필 사진) 변경 가능

: AWS S3 , form 태그, jstl c태그를 통해 구현 

[tr_mypage.jsp](https://github.com/SeoJaeyeon/fitnessCenterManagementSystem/blob/master/fitnessCenterManagementSystem/src/main/webapp/WEB-INF/views/trainer/tr_mypage.jsp)
[TrainerController.java](https://github.com/SeoJaeyeon/fitnessCenterManagementSystem/blob/master/fitnessCenterManagementSystem/src/main/java/kr/ac/fcm/controller/TrainerController.java)

- <u>사용자 관리</u>: 헬스장 관리자는 트레이너와 회원 등록/정보 수정 가능

: AWS S3, form 태그를 통해 구현

- <u>커뮤니티</u>: 모든 사용자는 내부 게시판을 통해 소통 가능

: DB와 비교하여 각 게시글에 대한 차등 권한 부여, 게시글 작성/수정/삭제/댓글 작성 기능 구현
