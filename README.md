# BoardWebProject_
## 마지막 수정
* User, Board, Reply 데이터베이스 설계에서 FK, PK가 설정되어 있지 않았다.
  * User, Board, Reply, Message, View 데이터베이스 모두 다시 설게했다.
  * User.id를 PK로 두고, Board, Reply, Message, View에서 FK로 참조하도록 했다.
  * Board.id를 PK로 두고 Reply, View가 FK로 참조하도록 했다.
* Session을 컨트롤러에서 다루도록 되어 있고, 같은 동작을 하는 코드가 여기저기 있었다. (유저 정보를 세션에 넘기는 것)
  * 컨트롤러에 있는 HttpSession은 다 걷어내고, 모두 UserService에서 다루도록 했다.
  * 접속한 유저의 정보는 로그인시 한꺼번에 세션에 저장시키고 필요할 경우에 UserService에서 호출해서 꺼내 쓴다.
  
## 회원가입
![20200731235145](https://user-images.githubusercontent.com/52740533/89047064-d1608c80-d388-11ea-9e2e-60ab53fcbc99.png)
* 계정 : e-mail 형식
* 비밀번호 : 최소 10자, 최대 20자
  * BCrpyt를 통해 암호화
* 닉네임 : 최소 3자, 최대 15자

## 로그인
![20200731234700](https://user-images.githubusercontent.com/52740533/89046727-58f9cb80-d388-11ea-97cf-76770b545ba6.png)

## 게시판
![20200801000049](https://user-images.githubusercontent.com/52740533/89048035-37014880-d38a-11ea-8119-604b1aa743d7.png)
* 로그인 되어 있는 유저의 닉네임 출력
* 로그아웃
* 글쓰기
* 쪽지
* 게시글
  * 게시글 id
  * 작성자 (닉네임)
    * 작성자 클릭시 작성자에게 쪽지 보내기
  * 제목
    * 제목 클릭시 게시글 보기
    * ![20200801001132](https://user-images.githubusercontent.com/52740533/89049039-97dd5080-d38b-11ea-8df0-dff3ac48d224.png)
      * 목록으로
      * 게시글 수정, 게시글 삭제
        * 게시글 수정과 삭제는 해당 게시글 작성자만 가능
      * 댓글 조회
        * 댓글 수정 삭제
          * 댓글 수정과 삭제는 해당 댓글 작성자만 가능
      * 댓글 작성
  * 작성일
  * 조회수
    * A유저가 게시글을 읽어 조회수가 올라가면, A유저는 마지막으로 게시글을 읽은 후 30분이 지나야 조회수 카운트
    
