package com.gmail.juyonglee0208.service;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gmail.juyonglee0208.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j

public class ServiceTest {

	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
	@Test
	public void testExist() {
		log.info("======================================");
		assertNotNull(service);
		log.info(service);
		log.info("======================================");
	}
	
	@Test
	public void testRegister() {
		BoardVO board = new BoardVO();
		board.setTitle("Test");
		board.setContent("Service Test");
		board.setWriter("JYL");
		service.register(board);
		log.info("======================================");
		log.info("생성된 게시물 번호: " + board.getBno());
		log.info("======================================");
	}
	
	@Test
	public void testGetList() {
		log.info("======================================");
		service.getList().forEach(each_board -> {
			log.info(each_board);
			log.info("======================================");
		});
	}
	
	@Test
	public void getBoardItem() {
		BoardVO board = service.get(6L);
		log.info("======================================");
		log.info(board);
		log.info("======================================");
	}
	
	@Test
	public void updateTest() {
		BoardVO board = new BoardVO();
		board.setBno(8L);
		board.setTitle("Hello");
		board.setContent("CRUD Test....");
		board.setUpdateDate(new Date());
		board.setWriter("JYL");
		if(!service.modify(board)) {
			log.info("======================================");
			log.info("Index를 확인해주세요!");
			log.info("======================================");
		}
	}
	
	@Test
	public void deleteTest() {
		log.info("======================================");
		log.info(service.remove(9L));
		log.info("======================================");
	}
	
	
}
