package com.zhiyou.service;

import com.zhiyou.model.Video;
import com.zhiyou.model.VideoExample;
import com.zhiyou.model.VideoExtension;

public interface VideoService {
	VideoExtension videoPlay(int videoId);
	void updatePlayNum(Video video,VideoExample example);
}
