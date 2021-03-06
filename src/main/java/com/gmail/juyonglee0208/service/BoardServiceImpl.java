package com.gmail.juyonglee0208.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmail.juyonglee0208.domain.BoardVO;
import com.gmail.juyonglee0208.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardServiceImpl implements BoardService {
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Override
	public void register(BoardVO board) {
		log.info("Register....." + board);
		mapper.insertSelectKey(board);
	}

	@Override
	public BoardVO get(Long bno) {
		return mapper.read(bno);
	}

	@Override
	public Boolean modify(BoardVO board) {	
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {
		return mapper.delete(bno)==1;
	}

	@Override
	public List<BoardVO> getList() {
		log.info("Get List.......");
		return mapper.getList();
	}

}
