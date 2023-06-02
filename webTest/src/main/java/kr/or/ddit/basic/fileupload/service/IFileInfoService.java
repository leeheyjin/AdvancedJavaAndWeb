package kr.or.ddit.basic.fileupload.service;

import java.util.List;

import kr.or.ddit.basic.vo.FileInfoVO;

public interface IFileInfoService {
	public int insert(FileInfoVO vo);

	public List<FileInfoVO> getAll();

	public FileInfoVO getOne(int file_no);
}
