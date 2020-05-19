package com.gmail.juyonglee0208.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.gmail.juyonglee0208.domain.BoardVO;

public interface BoardMapper {
	@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();

	public List<BoardVO> getListFromXML();
	
	public void insert(BoardVO board);
	
	public void insertSelectKey(BoardVO board);

	public BoardVO read(Long bno);
		
	public int delete(Long bno);
	
	public int update(BoardVO board);
}
