package kr.or.ddit.basic.fileupload.dao;

import java.util.List;

import kr.or.ddit.basic.vo.FileInfoVO;

public interface IFileInfoDAO {
	public int insert(FileInfoVO vo);
	public List<FileInfoVO> getAll();
	public FileInfoVO getOne(int file_no);

}
