package com.entity.view;

import com.entity.HuibianzhishiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 汇编知识
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("huibianzhishi")
public class HuibianzhishiView extends HuibianzhishiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 汇编知识类型的值
		*/
		private String huibianzhishiValue;
		/**
		* 是否上架的值
		*/
		private String shangxiaValue;



	public HuibianzhishiView() {

	}

	public HuibianzhishiView(HuibianzhishiEntity huibianzhishiEntity) {
		try {
			BeanUtils.copyProperties(this, huibianzhishiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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















}
