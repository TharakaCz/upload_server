package com.thinktwice.lk.repository;

import com.thinktwice.lk.model.VideoUploard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<VideoUploard,Long> {
}
