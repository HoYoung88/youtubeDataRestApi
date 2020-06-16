package com.loudg.api.yt;

import com.loudg.api.yt.controller.ChannelRestContoller;
import com.loudg.api.yt.mapper.playlist.PlaylistMapper;
import com.loudg.api.yt.vo.playlist.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.http.server.RequestPath;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.restdocs.request.RequestDocumentation;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@Slf4j
class LogudYtApiApplicationTests extends ApiDocumentation {

	@Test
	void channelApi() throws Exception {
		this.mockMvc
				.perform( get("/channel/{channelId}", "UCYP2aGg8h_9JHqNQBHNKp7w")
						.accept(MediaType.APPLICATION_JSON)
						.characterEncoding("UTF-8"))
				.andExpect(status().is2xxSuccessful())
		.andDo(this.documentationHandler.document(
				operation -> {
					RequestDocumentation.pathParameters(
							parameterWithName("channelId").description("channelId")
					);
				}
		));
	}

	@Resource
	private PlaylistMapper playlistMapper;

	@Test
	void sampleTest() throws Exception {
		String channelId = "UCYP2aGg8h_9JHqNQBHNKp7w";
		List<PlaylistVo> playlistVoList = playlistMapper.selectPlaylist(channelId);
		List<PlaylistStatVo> playlistStatVoList = playlistMapper.selectPlaylistStatMonth(channelId);

		playlistVoList.stream()
				.map(playlistVo -> {
					StatVo statVo = new StatVo();
					playlistStatVoList.stream()
							.filter(playlistStatVo -> playlistStatVo.getPlaylistId().equals(playlistVo.getPlaylistId()))
							.forEach(playlistStatVo -> {
								String month = playlistStatVo.getMonth();
								statVo.setViews(new StatViewsVo(month, playlistStatVo.getViews(), playlistStatVo.getViewsIncreasPercent()));
								statVo.setEstimatedMinutesWatched(new StatEstimatedMinutesWatchedVo(month, playlistStatVo.getEstimatedMinutesWatched(), playlistStatVo.getEstimatedMinutesWatchedIncreasPercent()));
								statVo.setSubscribers(new StatSubscribersVo(month, playlistStatVo.getSubscribers(), playlistStatVo.getSubscribersIncreaseIncreasPercent()));
							});
					playlistVo.setStat(statVo);

					return playlistVo;
				})
		;
		;

//		playlistVoList.stream().filter(playlistVo -> {
			//playlistStatVoList.stream()
//		});

//
//		log.debug(">>>>>>>");
//		log.debug(">>>>> {}", playlistVoList.stream().map(playlistVo -> {
//			log.debug(">>> {}", playlistVo.toString());
//			log.debug(">>>> {}",playlistStatVos.stream().allMatch(playlistStatVo -> playlistVo.getPlaylistId() == playlistStatVo.getPlaylistId()));
//
//			return playlistVo;
//		}));

//		playlistVoListt.stream().map(playlistVo -> {
//			StatVo statVo = new StatVo();
//			Stream stream = playlistStatVoList.stream();
//
//
//			List<PlaylistStatVo> list = playlistStatVoList.stream().filter(playlistStatVo -> playlistStatVo.getPlaylistId().equals(playlistVo.getPlaylistId())).collect(Collectors.toList());
//
//		});


//		StatVo statVo = new StatVo();
//		playlistStatVos.forEach(playlistStatVo -> {
//			if(playlistStatVo.getPlaylistId().equals(playlistVo.getPlaylistId())) {
//				String month = playlistStatVo.getMonth();
//
//				statVo.setViews(new StatViewsVo(month, playlistStatVo.getViews(), playlistStatVo.getViewsIncreasPercent()));
//
//				statVo.setEstimatedMinutesWatched(new StatEstimatedMinutesWatchedVo(month, playlistStatVo.getEstimatedMinutesWatched(), playlistStatVo.getEstimatedMinutesWatchedIncreasPercent()));
//
//				statVo.setSubscribers(new StatSubscribersVo(month, playlistStatVo.getSubscribers(), playlistStatVo.getSubscribersIncreaseIncreasPercent()));
//
//			}
//		});
//
//		playlistVo.setStat(statVo);
//
//		log.debug(">> {}", list);list




	}
}