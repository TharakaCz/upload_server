package com.thinktwice.lk.service.impl;

import com.thinktwice.lk.helper.VideoDTO;
import com.thinktwice.lk.model.VideoUploard;
import com.thinktwice.lk.repository.VideoRepository;
import com.thinktwice.lk.service.VideoService;
import com.thinktwice.lk.utill.AppConstent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

  @Autowired
  private VideoRepository videoRepository;
  private String filepath;

  @Override
  public String upload(MultipartFile file,String language) throws Exception {

    if (file.getContentType().equals("video/mp4")){

      VideoUploard videoUploard = new VideoUploard();
      videoUploard.setuDate(new Date());
      videoUploard.setvName(file.getOriginalFilename());
      videoUploard.setvSize(file.getSize());
      videoUploard.setvFormat(file.getContentType());
      if (language.equals("english")){
        videoUploard.setvPath(AppConstent.ENGLISH_VIDEO_PATH+file.getOriginalFilename());
      }else if (language.equals("hindi")){
        videoUploard.setvPath(AppConstent.HINDI_VIDEO_PATH+file.getOriginalFilename());
      }else if (language.equals("sinhalese")){
        videoUploard.setvPath(AppConstent.SINHALA_VIDEO_PATH+file.getOriginalFilename());
      }else if (language.equals("tamil")){
        videoUploard.setvPath(AppConstent.TAMIL_VIDEO_PATH+file.getOriginalFilename());
      }
      filepath ="."+videoUploard.getvPath();
      if (videoRepository.save(videoUploard) != null){
        byte[] data = file.getBytes();
        Path path = Paths.get(filepath);
        Files.write(path,data);
        return "Video Upload Success";
      }else {
        return "Upload Fail System Error 500";
      }
    }else {
        return "Please Select Valid Video File";
    }
  }

  @Override
  public String delete(Long pid) throws Exception {

    VideoUploard videoUploard = videoRepository.findById(pid).get();
    String Path = videoUploard.getvPath();
    File file = new File(Path);

     if (file.delete()){
       videoRepository.deleteById(pid);
       return "Deleted success";
     }else {
       return "Delete Fail System Error 500";
     }
  }

  @Override
  public VideoDTO find(Long pid) throws Exception {
    VideoDTO videoDTO = findVideo(pid);
    return videoDTO;
  }

  @Override
  public List<VideoDTO> getAll() throws Exception {

    List<VideoUploard>videoUploards = videoRepository.findAll();
    ArrayList<VideoDTO>videoDTOS = new ArrayList<>();
    videoUploards.forEach(each->{
      try {
        videoDTOS.add(getAllVideos(each));
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
    return videoDTOS;
  }

  private VideoDTO findVideo(Long pid)throws Exception{

    VideoUploard videoUploard = videoRepository.findById(pid).get();
    VideoDTO videoDTO = new VideoDTO();
    videoDTO.setPid(videoUploard.getPid());
    videoDTO.setuDate(videoUploard.getuDate());
    videoDTO.setvFormat(videoUploard.getvFormat());
    videoDTO.setvName(videoUploard.getvName());
    videoDTO.setvSize(videoUploard.getvSize());
    videoDTO.setvPath(videoUploard.getvPath());
    return videoDTO;

  }

  private VideoDTO getAllVideos(VideoUploard videoUploard) throws Exception{

    VideoDTO videoDTO = new VideoDTO();
    videoDTO.setvPath(videoUploard.getvPath());
    videoDTO.setvSize(videoUploard.getvSize());
    videoDTO.setvName(videoUploard.getvName());
    videoDTO.setvFormat(videoUploard.getvFormat());
    videoDTO.setuDate(videoUploard.getuDate());
    videoDTO.setPid(videoUploard.getPid());

    return videoDTO;
  }

}
