## 헬스일정예약관리시스템

**개요**

  헬스 일정 관리가 사람에 의해 이루어짐으로써 발생하는 오차의 가능성과 불필요한 연락을 개선하기 위해 <u>헬스 일정 관리(신청/변경/조회)를 웹페이지로 시스템화</u> 하고, 별도의 <u>커뮤니티 게시판</u>을 개설함으로써 헬스장 사용자가 정보를 공유할 수 있도록 한다.

**프로젝트 구성원**

  소프트웨어 공학 수업시간에 팀프로젝트로 했던 설계를 기반으로 단독개발

**시스템 구조**



![system-architecture](https://github.com/SeoJaeyeon/fitnessCenterManagementSystem/blob/master/img/system-architecture.PNG?raw=true)



**주요 요구사항 및 구현내용**

- <u>사용자 인증 및 권한 부여</u>: 별도의 카테고리 설정 없이 사용자 군(헬스장 관리자/트레이너/회원)별 로그인과 맞춤형 기능 제공

: Spring-Security를 통해 각각 ROLE_MANAGER, ROLE_TRAINER, ROLE_MEMER 권한을 부여하여 구현 

- <u>스케줄 조회</u> : 트레이너와 회원은 금주 PT 일정 확인 

- <u>스케줄 신청</u>: 회원은 2주 후의 PT일정 신청/변경/예약대기

- <u>개인정보 수정</u>: 트레이너와 회원은 자신의 개인정보(패스워드, 연락처, 프로필 사진) 변경 가능

: AWS S3 , form 태그, jstl c태그를 통해 구현 

- <u>사용자 관리</u>: 헬스장 관리자는 트레이너와 회원 등록/정보 수정 가능

: AWS S3, form 태그를 통해 구현

- <u>커뮤니티</u>: 모든 사용자는 내부 게시판을 통해 소통 가능

: DB와 비교하여 각 게시글에 대한 차등 권한 부여, 게시글 작성/수정/삭제/댓글 작성 기능 구현



**시연영상**

  [![Video Label](http://img.youtube.com/vi/uLR1RNqJ1Mw/0.jpg)](https://youtu.be/3Q0snPGf3og)