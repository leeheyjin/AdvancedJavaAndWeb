package com.suin.zzang.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.suin.zzang.vo.Chahyun;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class FileController {
	@PostMapping(value =  "/mFile", produces = "application/json;charset=utf-8")
	@ResponseBody	// AJAX 요청에 응답
	public String getFile(Chahyun chahyun) throws Exception {
		log.debug(chahyun.getSuinFile().getOriginalFilename());
		log.debug(""+chahyun.getSuinFile().getSize());
		log.debug(chahyun.getGoodWords());
		log.debug(chahyun.getBadWords());
		
		String soyeon = "e:/uploads/" + chahyun.getSuinFile().getOriginalFilename();
		
		chahyun.getSuinFile().transferTo(new File(soyeon));
		
		//물리적 경로에 대응하는 웹경로를 리턴
		return "/zzang/myfiles/" + chahyun.getSuinFile().getOriginalFilename();
	}

	/*
	@PostMapping(value =  "/mFile", produces = "application/json;charset=utf-8")
	@ResponseBody	// AJAX 요청에 응답
	public String getFile(MultipartFile suinFile, MultipartHttpServletRequest msr) throws Exception {
		log.debug(suinFile.getOriginalFilename());
		log.debug(""+suinFile.getSize());
		log.debug(msr.getParameter("goodWords"));
		log.debug(msr.getParameter("badWords"));
		
		String soyeon = "e:/uploads/" + suinFile.getOriginalFilename();
		
		suinFile.transferTo(new File(soyeon));
		
		//물리적 경로에 대응하는 웹경로를 리턴
		return "/zzang/myfiles/" + suinFile.getOriginalFilename();
	}
	*/
}
