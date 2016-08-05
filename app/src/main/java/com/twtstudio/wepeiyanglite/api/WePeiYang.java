package com.twtstudio.wepeiyanglite.api;

import com.twtstudio.wepeiyanglite.model.AvailableRoom;
import com.twtstudio.wepeiyanglite.model.GalleryIndexItem;
import com.twtstudio.wepeiyanglite.model.GalleryPhotos;
import com.twtstudio.wepeiyanglite.model.NewsItem;
import com.twtstudio.wepeiyanglite.model.SchoolBuildings;
import com.twtstudio.wepeiyanglite.model.Token;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by huangyong on 16/5/18.
 */
public interface WePeiYang {

    @GET("auth/token/get")
    Observable<ApiResponse<Token>> login(@Query("twtuname") String twtuname, @Query("twtpasswd") String twtpasswd);

    @GET("auth/bind/tju")
    Observable<ApiResponse> bindTju(@Query("tjuuname") String tjuuname, @Query("tjupasswd") String tjupasswd);

    @GET("news/type/{type}")
    Observable<ApiResponse<List<NewsItem>>> getNewsList(@Path("type") int type, @Query("page") int page);

    //不要脸和云鹏要的主站图片主页接口
    @GET("http://www.twt.edu.cn/mapi/galleries/index")
    Observable<List<GalleryIndexItem>> getGalleryIndex();

    //不要脸要的照片接口
    @GET("http://www.twt.edu.cn/mapi/galleries/{id}/photos")
    Observable<List<GalleryPhotos>> getGalleryPhotos(@Path("id") int id);

    @GET("classrooms/buildings")
    Observable<ApiResponse<SchoolBuildings>> getBuildingsId();

    @GET("classrooms")
    Observable<ApiResponse<List<String>>> getAvailableRooms(@Query("bid") int bid, @Query("time") String timeStamp);
}
