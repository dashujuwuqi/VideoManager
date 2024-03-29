package com.zhiyou.backgroundservice;

import com.zhiyou.model.Video;
import com.zhiyou.model.VideoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BackVideoService {
    long countByExample(VideoExample example);

    int deleteByExample(VideoExample example);

    int deleteByPrimaryKey(Integer videoId);

    int insert(Video record);

    int insertSelective(Video record);

    List<Video> selectByExample(VideoExample example);

    Video selectByPrimaryKey(Integer videoId);

    int updateByExampleSelective(@Param("record") Video record, @Param("example") VideoExample example);

    int updateByExample(@Param("record") Video record, @Param("example") VideoExample example);

    int updateByPrimaryKeySelective(Video record);

    int updateByPrimaryKey(Video record);
    
    List<Video> select();
    
    List<Video> selectLike(@Param("speakerId")String speakerId, @Param("courseId")String courseId,@Param("subject")String subject, @Param("factor")String factor); 
}