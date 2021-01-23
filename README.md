# Spring_Project

기존에 완성했던 Web_Proejct인 'Mibbda'를 Spring MyBatis버전으로 변형시키는 Project.

<변형 방식>

*커맨드에서 로직이 있는 경우*

  1.Dao.java를 생성 (Interface)
  
  2.Dao.xml을 생성(Dao.java와 이름이 동일하게 만들어야 함)
  
  3.Dao.xml에 mapper를 그려주고 그 안에 리턴할 name과 resultType을 정해주고 Query문을 작성
  
  4.Dao.java에 Dao.xml에서 리턴하는 name을 그대로 사용하는 메소드 생성
  
  5.Command 생성
  
  6.servlet-context.xml에 beans:bean으로 해당 Command 등록
  
  7.Command에서 Dao.java에 있는 메소드를 로직에 따라 사용 (sqlSesson.getMapper)
  
  8.Controller에 Autowired로 커맨드를 등록
  
  9.mapping 후 request, session, model 등 필요한 메소드 선언 후 사용
  
  10.Command.execute(model)

*단순 CRUD인 경우*

  1.Dao.java를 생성 (Interface)
  
  2.Dao.xml을 생성(Dao.java와 이름이 동일하게 만들어야 함)
  
  3.Dao.xml에 mapper를 그려주고 그 안에 리턴할 name과 resultType을 정해주고 Query문을 작성
  
  4.Dao.java에 Dao.xml에서 리턴하는 name을 그대로 사용하는 메소드 생성
  
  5.Controller에서 Dao dao = sqlSession.getMapper(dao.class); 로 dao연결
  
  6.model.addAttribute("리턴할 이름", dao.메소드명); 리턴 (SELECT인 경우)

*공통 작업*

  1.Dto, jsp 옮겨 오기
  
  2.Controller에 mapping 
  
 
  
