package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 汇编知识
 *
 * @author 
 * @email
 */
@TableName("huibianzhishi")
public class HuibianzhishiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public HuibianzhishiEntity() {

	}

	public HuibianzhishiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 汇编知识名称
     */
    @TableField(value = "huibianzhishi_name")

    private String huibianzhishiName;


    /**
     * 汇编知识编号
     */
    @TableField(value = "huibianzhishi_uuid_number")

    private String huibianzhishiUuidNumber;


    /**
     * 汇编知识照片
     */
    @TableField(value = "huibianzhishi_photo")

    private String huibianzhishiPhoto;


    /**
     * 汇编知识视频
     */
    @TableField(value = "huibianzhishi_video")

    private String huibianzhishiVideo;


    /**
     * 知识课件
     */
    @TableField(value = "huibianzhishi_file")

    private String huibianzhishiFile;


    /**
     * 汇编知识类型
     */
    @TableField(value = "huibianzhishi_types")

    private Integer huibianzhishiTypes;


    /**
     * 赞
     */
    @TableField(value = "zan_number")

    private Integer zanNumber;


    /**
     * 踩
     */
    @TableField(value = "cai_number")

    private Integer caiNumber;


    /**
     * 知识热度
     */
    @TableField(value = "huibianzhishi_clicknum")

    private Integer huibianzhishiClicknum;


    /**
     * 汇编知识详细介绍
     */
    @TableField(value = "huibianzhishi_content")

    private String huibianzhishiContent;


    /**
     * 是否上架
     */
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @TableField(value = "huibianzhishi_delete")

    private Integer huibianzhishiDelete;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：汇编知识名称
	 */
    public String getHuibianzhishiName() {
        return huibianzhishiName;
    }
    /**
	 * 获取：汇编知识名称
	 */

    public void setHuibianzhishiName(String huibianzhishiName) {
        this.huibianzhishiName = huibianzhishiName;
    }
    /**
	 * 设置：汇编知识编号
	 */
    public String getHuibianzhishiUuidNumber() {
        return huibianzhishiUuidNumber;
    }
    /**
	 * 获取：汇编知识编号
	 */

    public void setHuibianzhishiUuidNumber(String huibianzhishiUuidNumber) {
        this.huibianzhishiUuidNumber = huibianzhishiUuidNumber;
    }
    /**
	 * 设置：汇编知识照片
	 */
    public String getHuibianzhishiPhoto() {
        return huibianzhishiPhoto;
    }
    /**
	 * 获取：汇编知识照片
	 */

    public void setHuibianzhishiPhoto(String huibianzhishiPhoto) {
        this.huibianzhishiPhoto = huibianzhishiPhoto;
    }
    /**
	 * 设置：汇编知识视频
	 */
    public String getHuibianzhishiVideo() {
        return huibianzhishiVideo;
    }
    /**
	 * 获取：汇编知识视频
	 */

    public void setHuibianzhishiVideo(String huibianzhishiVideo) {
        this.huibianzhishiVideo = huibianzhishiVideo;
    }
    /**
	 * 设置：知识课件
	 */
    public String getHuibianzhishiFile() {
        return huibianzhishiFile;
    }
    /**
	 * 获取：知识课件
	 */

    public void setHuibianzhishiFile(String huibianzhishiFile) {
        this.huibianzhishiFile = huibianzhishiFile;
    }
    /**
	 * 设置：汇编知识类型
	 */
    public Integer getHuibianzhishiTypes() {
        return huibianzhishiTypes;
    }
    /**
	 * 获取：汇编知识类型
	 */

    public void setHuibianzhishiTypes(Integer huibianzhishiTypes) {
        this.huibianzhishiTypes = huibianzhishiTypes;
    }
    /**
	 * 设置：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }
    /**
	 * 获取：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 设置：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }
    /**
	 * 获取：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 设置：知识热度
	 */
    public Integer getHuibianzhishiClicknum() {
        return huibianzhishiClicknum;
    }
    /**
	 * 获取：知识热度
	 */

    public void setHuibianzhishiClicknum(Integer huibianzhishiClicknum) {
        this.huibianzhishiClicknum = huibianzhishiClicknum;
    }
    /**
	 * 设置：汇编知识详细介绍
	 */
    public String getHuibianzhishiContent() {
        return huibianzhishiContent;
    }
    /**
	 * 获取：汇编知识详细介绍
	 */

    public void setHuibianzhishiContent(String huibianzhishiContent) {
        this.huibianzhishiContent = huibianzhishiContent;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }
    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getHuibianzhishiDelete() {
        return huibianzhishiDelete;
    }
    /**
	 * 获取：逻辑删除
	 */

    public void setHuibianzhishiDelete(Integer huibianzhishiDelete) {
        this.huibianzhishiDelete = huibianzhishiDelete;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Huibianzhishi{" +
            "id=" + id +
            ", huibianzhishiName=" + huibianzhishiName +
            ", huibianzhishiUuidNumber=" + huibianzhishiUuidNumber +
            ", huibianzhishiPhoto=" + huibianzhishiPhoto +
            ", huibianzhishiVideo=" + huibianzhishiVideo +
            ", huibianzhishiFile=" + huibianzhishiFile +
            ", huibianzhishiTypes=" + huibianzhishiTypes +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", huibianzhishiClicknum=" + huibianzhishiClicknum +
            ", huibianzhishiContent=" + huibianzhishiContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", huibianzhishiDelete=" + huibianzhishiDelete +
            ", createTime=" + createTime +
        "}";
    }
}
