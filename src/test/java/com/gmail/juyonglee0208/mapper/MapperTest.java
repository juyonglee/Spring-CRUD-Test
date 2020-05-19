package com.gmail.juyonglee0208.mapper;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.ibatis.jdbc.Null;
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
public class MapperTest {
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		assertNotNull(mapper);
		log.info("====================================================");
		log.info("\t[Board Mapper Test]");
		mapper.getList().forEach(board-> {
			log.info(board);
		});
		log.info("====================================================");
	}
	
	@Test
	public void testGetListFromXML() {
		assertNotNull(mapper);
		log.info("====================================================");
		log.info("\t[Board Mapper Test]");
		mapper.getListFromXML().forEach(board-> {
			log.info(board);
		});
		log.info("====================================================");
	}
	
	@Test
	public void insetTest() {
		BoardVO board = new BoardVO();
		board.setTitle("CRUD 테스트입니다.");
		board.setContent("CRUD XX 같구먼!!!");
		board.setWriter("Tony");
		log.info(board);
		mapper.insert(board);
	}
	
	@Test
	public void insetTestSelectKey() {
		BoardVO board = new BoardVO();
		board.setTitle("CRUD 테스트입니다.");
		board.setContent("CRUD ...");
		board.setWriter("Jone");
		mapper.insertSelectKey(board);
		log.info("====================================================");
		log.info("Inserted ID: " + board.getBno());
		log.info("====================================================");
	}
	
	@Test
	public void readTest() {
		 BoardVO board_item = mapper.read(5L);
		 log.info("====================================================");
		 if(board_item == null) {
			 log.info("Data가 존재하지 않습니다!");
		 } else {
			 log.info(board_item);
		 }
		 
		 log.info("====================================================");
	}
	
	@Test
	public void deleteTest() {
		log.info("====================================================");
		if(mapper.delete(29L)>0) {
			log.info("삭제 성공!");
		} else {
			log.info("삭제할 데이터가 존재하지 않습니다!");
		}
		log.info("====================================================");
	}
	
	@Test
	public void updateTest() {
		BoardVO board = new BoardVO();
		board.setWriter("Juyong Lee");
		board.setBno(34L);
		int count = mapper.update(board);
		log.info("====================================================");
		log.info("Update Count: "+ count);
		log.info("====================================================");
	}
}
