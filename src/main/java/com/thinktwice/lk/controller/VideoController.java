package com.thinktwice.lk.controller;

import com.thinktwice.lk.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/app/video")
public class VideoController {

  @Autowired
  private VideoService videoService;

  @PostMapping(value = "/upload/{language}")
  protected ResponseEntity<Object>upload(@RequestParam("file")MultipartFile file,@PathVariable("language") String language){
    try {
      return new ResponseEntity<Object>(videoService.upload(file,language), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping(value = "/delete/{pid}")
  protected ResponseEntity<Object>delete(@PathVariable("pid")Long pid){
    try {
      return new ResponseEntity<Object>(videoService.delete(pid),HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping(value = "/find/{pid}")
  protected ResponseEntity<Object>find(@PathVariable("pid")Long pid){
    try {
      return new ResponseEntity<Object>(videoService.find(pid),HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping(value = "/getAllVideos")
  protected ResponseEntity<Object>getAll(){
    try {
      return new ResponseEntity<Object>(videoService.getAll(),HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
