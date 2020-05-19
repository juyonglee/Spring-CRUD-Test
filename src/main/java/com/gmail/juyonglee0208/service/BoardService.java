package com.gmail.juyonglee0208.service;

import java.util.List;

import com.gmail.juyonglee0208.domain.BoardVO;

public interface BoardService {
	public void register(BoardVO board);
	public BoardVO get(Long bno);
	public Boolean modify(BoardVO board);
	public boolean remove(Long bno);
	public List<BoardVO> getList();
}
