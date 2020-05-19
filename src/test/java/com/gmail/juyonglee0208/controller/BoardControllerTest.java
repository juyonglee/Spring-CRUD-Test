package com.gmail.juyonglee0208.controller;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;

import com.gmail.juyonglee0208.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class BoardControllerTest {
	
	@Setter(onMethod_ = @Autowired)
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@org.junit.Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testList() {
		try {
			ModelMap modelMap = mockMvc.perform(MockMvcRequestBuilders.get("/board/list")).andReturn().getModelAndView().getModelMap();
			log.info("================================================");
			List<BoardVO> boards = (List<BoardVO>) modelMap.get("list");
			for (BoardVO boardVO : boards) {
				log.info(boardVO.getWriter());
				log.info("================================================");
			}
		} catch (Exception e) {
			fail("testList 실패!!");
		}
	}
	
	@Test
	public void postRegisterTest() {
		try {
			String resultPage;
			resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
					.param("title", "HelloW World!")
					.param("content", "CRUD = Create Test")
					.param("writer", "이주용")).andReturn().getModelAndView().getViewName();
			log.info("================================================");
			log.info(resultPage);
			log.info("================================================");
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testGet() {
		try {
			ModelMap map = mockMvc.perform(MockMvcRequestBuilders.get("/board/get").param("bno", "8")).andReturn().getModelAndView().getModelMap();
			log.info(map);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testModify() {
		try {
			String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
					.param("bno", "9")
					.param("title", "수정된 테스트 새글 제목")
					.param("writer", "소주용")
					.param("content", "CRUD Update Test")).andReturn().getModelAndView().getViewName();
			log.info(resultPage);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testRemove() {
		try {
			String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
					.param("bno", "13")).andReturn().getModelAndView().getViewName();
			log.info(resultPage);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
