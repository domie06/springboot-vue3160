package com.dao;

import com.entity.HuibianzhishiLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.HuibianzhishiLiuyanView;

/**
 * 汇编知识留言 Dao 接口
 *
 * @author 
 */
public interface HuibianzhishiLiuyanDao extends BaseMapper<HuibianzhishiLiuyanEntity> {

   List<HuibianzhishiLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
