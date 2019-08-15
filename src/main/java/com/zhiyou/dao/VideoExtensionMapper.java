package com.zhiyou.dao;

import com.zhiyou.model.VideoExtension;

public interface VideoExtensionMapper {
	VideoExtension videoPlay(int videoId);

	void updatePlayNum(int playNum,int videoId);
}
