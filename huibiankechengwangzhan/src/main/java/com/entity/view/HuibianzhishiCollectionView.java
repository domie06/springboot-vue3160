package com.entity.view;

import com.entity.HuibianzhishiCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 汇编知识收藏
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("huibianzhishi_collection")
public class HuibianzhishiCollectionView extends HuibianzhishiCollectionEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 类型的值
		*/
		private String huibianzhishiCollectionValue;



		//级联表 huibianzhishi
			/**
			* 汇编知识名称
			*/
			private String huibianzhishiName;
			/**
			* 汇编知识编号
			*/
			private String huibianzhishiUuidNumber;
			/**
			* 汇编知识照片
			*/
			private String huibianzhishiPhoto;
			/**
			* 汇编知识视频
			*/
			private String huibianzhishiVideo;
			/**
			* 知识课件
			*/
			private String huibianzhishiFile;
			/**
			* 汇编知识类型
			*/
			private Integer huibianzhishiTypes;
				/**
				* 汇编知识类型的值
				*/
				private String huibianzhishiValue;
			/**
			* 赞
			*/
			private Integer zanNumber;
			/**
			* 踩
			*/
			private Integer caiNumber;
			/**
			* 知识热度
			*/
			private Integer huibianzhishiClicknum;
			/**
			* 汇编知识详细介绍
			*/
			private String huibianzhishiContent;
			/**
			* 是否上架
			*/
			private Integer shangxiaTypes;
				/**
				* 是否上架的值
				*/
				private String shangxiaValue;
			/**
			* 逻辑删除
			*/
			private Integer huibianzhishiDelete;

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 用户头像
			*/
			private String yonghuPhoto;
			/**
			* 电子邮箱
			*/
			private String yonghuEmail;

	public HuibianzhishiCollectionView() {

	}

	public HuibianzhishiCollectionView(HuibianzhishiCollectionEntity huibianzhishiCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, huibianzhishiCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 类型的值
			*/
			public String getHuibianzhishiCollectionValue() {
				return huibianzhishiCollectionValue;
			}
			/**
			* 设置： 类型的值
			*/
			public void setHuibianzhishiCollectionValue(String huibianzhishiCollectionValue) {
				this.huibianzhishiCollectionValue = huibianzhishiCollectionValue;
			}




























				//级联表的get和set huibianzhishi

					/**
					* 获取： 汇编知识名称
					*/
					public String getHuibianzhishiName() {
						return huibianzhishiName;
					}
					/**
					* 设置： 汇编知识名称
					*/
					public void setHuibianzhishiName(String huibianzhishiName) {
						this.huibianzhishiName = huibianzhishiName;
					}

					/**
					* 获取： 汇编知识编号
					*/
					public String getHuibianzhishiUuidNumber() {
						return huibianzhishiUuidNumber;
					}
					/**
					* 设置： 汇编知识编号
					*/
					public void setHuibianzhishiUuidNumber(String huibianzhishiUuidNumber) {
						this.huibianzhishiUuidNumber = huibianzhishiUuidNumber;
					}

					/**
					* 获取： 汇编知识照片
					*/
					public String getHuibianzhishiPhoto() {
						return huibianzhishiPhoto;
					}
					/**
					* 设置： 汇编知识照片
					*/
					public void setHuibianzhishiPhoto(String huibianzhishiPhoto) {
						this.huibianzhishiPhoto = huibianzhishiPhoto;
					}

					/**
					* 获取： 汇编知识视频
					*/
					public String getHuibianzhishiVideo() {
						return huibianzhishiVideo;
					}
					/**
					* 设置： 汇编知识视频
					*/
					public void setHuibianzhishiVideo(String huibianzhishiVideo) {
						this.huibianzhishiVideo = huibianzhishiVideo;
					}

					/**
					* 获取： 知识课件
					*/
					public String getHuibianzhishiFile() {
						return huibianzhishiFile;
					}
					/**
					* 设置： 知识课件
					*/
					public void setHuibianzhishiFile(String huibianzhishiFile) {
						this.huibianzhishiFile = huibianzhishiFile;
					}

					/**
					* 获取： 汇编知识类型
					*/
					public Integer getHuibianzhishiTypes() {
						return huibianzhishiTypes;
					}
					/**
					* 设置： 汇编知识类型
					*/
					public void setHuibianzhishiTypes(Integer huibianzhishiTypes) {
						this.huibianzhishiTypes = huibianzhishiTypes;
					}


						/**
						* 获取： 汇编知识类型的值
						*/
						public String getHuibianzhishiValue() {
							return huibianzhishiValue;
						}
						/**
						* 设置： 汇编知识类型的值
						*/
						public void setHuibianzhishiValue(String huibianzhishiValue) {
							this.huibianzhishiValue = huibianzhishiValue;
						}

					/**
					* 获取： 赞
					*/
					public Integer getZanNumber() {
						return zanNumber;
					}
					/**
					* 设置： 赞
					*/
					public void setZanNumber(Integer zanNumber) {
						this.zanNumber = zanNumber;
					}

					/**
					* 获取： 踩
					*/
					public Integer getCaiNumber() {
						return caiNumber;
					}
					/**
					* 设置： 踩
					*/
					public void setCaiNumber(Integer caiNumber) {
						this.caiNumber = caiNumber;
					}

					/**
					* 获取： 知识热度
					*/
					public Integer getHuibianzhishiClicknum() {
						return huibianzhishiClicknum;
					}
					/**
					* 设置： 知识热度
					*/
					public void setHuibianzhishiClicknum(Integer huibianzhishiClicknum) {
						this.huibianzhishiClicknum = huibianzhishiClicknum;
					}

					/**
					* 获取： 汇编知识详细介绍
					*/
					public String getHuibianzhishiContent() {
						return huibianzhishiContent;
					}
					/**
					* 设置： 汇编知识详细介绍
					*/
					public void setHuibianzhishiContent(String huibianzhishiContent) {
						this.huibianzhishiContent = huibianzhishiContent;
					}

					/**
					* 获取： 是否上架
					*/
					public Integer getShangxiaTypes() {
						return shangxiaTypes;
					}
					/**
					* 设置： 是否上架
					*/
					public void setShangxiaTypes(Integer shangxiaTypes) {
						this.shangxiaTypes = shangxiaTypes;
					}


						/**
						* 获取： 是否上架的值
						*/
						public String getShangxiaValue() {
							return shangxiaValue;
						}
						/**
						* 设置： 是否上架的值
						*/
						public void setShangxiaValue(String shangxiaValue) {
							this.shangxiaValue = shangxiaValue;
						}

					/**
					* 获取： 逻辑删除
					*/
					public Integer getHuibianzhishiDelete() {
						return huibianzhishiDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setHuibianzhishiDelete(Integer huibianzhishiDelete) {
						this.huibianzhishiDelete = huibianzhishiDelete;
					}










				//级联表的get和set yonghu

					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}

					/**
					* 获取： 用户手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 用户手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}

					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}

					/**
					* 获取： 用户头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 用户头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}



}
