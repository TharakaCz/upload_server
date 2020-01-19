package com.thinktwice.lk.service;

import com.thinktwice.lk.helper.VideoDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface VideoService {

  public String upload(MultipartFile file,String language)throws Exception;
  public String delete(Long pid)throws Exception;
  public VideoDTO find(Long pid)throws Exception;
  public List<VideoDTO> getAll()throws Exception;
}
