package kr.or.ddit.basic.fileupload.service;

import java.util.List;

import kr.or.ddit.basic.fileupload.dao.FileInfoDAO;
import kr.or.ddit.basic.fileupload.dao.IFileInfoDAO;
import kr.or.ddit.basic.vo.FileInfoVO;

public class FileInfoService implements IFileInfoService {
	private static IFileInfoService service;
	private IFileInfoDAO dao;

	private FileInfoService() {
		dao = FileInfoDAO.getInstance();
	}

	public static IFileInfoService getInstance() {
		if (service == null) {
			service = new FileInfoService();
		}
		return service;
	}

	@Override
	public int insert(FileInfoVO vo) {
		return dao.insert(vo);
	}

	@Override
	public List<FileInfoVO> getAll() {
		return dao.getAll();
	}

	@Override
	public FileInfoVO getOne(int file_no) {
		return dao.getOne(file_no);
	}

}
