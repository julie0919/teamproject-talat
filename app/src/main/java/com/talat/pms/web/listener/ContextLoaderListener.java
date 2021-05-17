package com.talat.pms.web.listener;

import java.io.InputStream;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.talat.mybatis.MybatisDaoFactory;
import com.talat.mybatis.SqlSessionFactoryProxy;
import com.talat.mybatis.TransactionManager;
import com.talat.pms.dao.JourneyDao;
import com.talat.pms.dao.JourneyRiderDao;
import com.talat.pms.dao.RiderQnADao;
//github.com/julie0919/teamproject-talat.git
import com.talat.pms.dao.RouteDao;
import com.talat.pms.service.JourneyRiderService;
import com.talat.pms.service.JourneyService;
import com.talat.pms.service.RiderQnAService;
import com.talat.pms.service.RouteService;
import com.talat.pms.service.impl.DefaultJourneyRiderService;
import com.talat.pms.service.impl.DefaultJourneyService;
import com.talat.pms.service.impl.DefaultRiderQnAService;
import com.talat.pms.service.impl.DefaultRouteService;

// 웹 애플리케이션을 시작하거나 종료할 때 서버로부터 보고를 받는다.
// 즉 톰캣 서버가 웹 애플리케이션을 시작하거나 종료하면 리스너 규칙에 따라 메서드를 호출한다는 뜻이다.
// 
public class ContextLoaderListener implements ServletContextListener {
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    try {
      ServletContext servletContext = sce.getServletContext();

      // 1) Mybatis 관련 객체 준비
      InputStream mybatisConfigStream = Resources.getResourceAsStream(
          servletContext.getInitParameter("mybatis-config"));
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(mybatisConfigStream);
      SqlSessionFactoryProxy sqlSessionFactoryProxy = new SqlSessionFactoryProxy(sqlSessionFactory);

      // 2) DAO 관련 객체 준비
      MybatisDaoFactory daoFactory = new MybatisDaoFactory(sqlSessionFactoryProxy);
      //      BoardDao boardDao = daoFactory.createDao(BoardDao.class);
      //      MemberDao memberDao = daoFactory.createDao(MemberDao.class);
      JourneyDao journeyDao = daoFactory.createDao(JourneyDao.class);
      JourneyRiderDao journeyRiderDao = daoFactory.createDao(JourneyRiderDao.class);
      RiderQnADao riderQnADao = daoFactory.createDao(RiderQnADao.class);
      RouteDao routeDao = daoFactory.createDao(RouteDao.class);

      // 3) 서비스 관련 객체 준비
      TransactionManager txManager = new TransactionManager(sqlSessionFactoryProxy);

      //      BoardService boardService = new DefaultBoardService(boardDao);
      //      MemberService memberService = new DefaultMemberService(memberDao);
      JourneyService journeyService = new DefaultJourneyService(txManager,journeyDao,routeDao);
      JourneyRiderService journeyRiderService = new DefaultJourneyRiderService(txManager,journeyRiderDao);
      RouteService routeService = new DefaultRouteService(routeDao);
      RiderQnAService riderQnAService = new DefaultRiderQnAService(riderQnADao);

      // 4) 서비스 객체를 ServletContext 보관소에 저장한다.
      //      servletContext.setAttribute("boardService", boardService);
      //      servletContext.setAttribute("memberService", memberService);
      servletContext.setAttribute("journeyService", journeyService);
      servletContext.setAttribute("journeyRiderService", journeyRiderService);
      servletContext.setAttribute("routeService", routeService);
      servletContext.setAttribute("riderQnAService", riderQnAService);


      System.out.println("ContextLoaderListener: 의존 객체를 모두 준비하였습니다.");

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
