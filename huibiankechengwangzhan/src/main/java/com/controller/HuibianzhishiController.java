
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 汇编知识
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/huibianzhishi")
public class HuibianzhishiController {
    private static final Logger logger = LoggerFactory.getLogger(HuibianzhishiController.class);

    @Autowired
    private HuibianzhishiService huibianzhishiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("huibianzhishiDeleteStart",1);params.put("huibianzhishiDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = huibianzhishiService.queryPage(params);

        //字典表数据转换
        List<HuibianzhishiView> list =(List<HuibianzhishiView>)page.getList();
        for(HuibianzhishiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        HuibianzhishiEntity huibianzhishi = huibianzhishiService.selectById(id);
        if(huibianzhishi !=null){
            //entity转view
            HuibianzhishiView view = new HuibianzhishiView();
            BeanUtils.copyProperties( huibianzhishi , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody HuibianzhishiEntity huibianzhishi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,huibianzhishi:{}",this.getClass().getName(),huibianzhishi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<HuibianzhishiEntity> queryWrapper = new EntityWrapper<HuibianzhishiEntity>()
            .eq("huibianzhishi_name", huibianzhishi.getHuibianzhishiName())
            .eq("huibianzhishi_uuid_number", huibianzhishi.getHuibianzhishiUuidNumber())
            .eq("huibianzhishi_video", huibianzhishi.getHuibianzhishiVideo())
            .eq("huibianzhishi_types", huibianzhishi.getHuibianzhishiTypes())
            .eq("zan_number", huibianzhishi.getZanNumber())
            .eq("cai_number", huibianzhishi.getCaiNumber())
            .eq("huibianzhishi_clicknum", huibianzhishi.getHuibianzhishiClicknum())
            .eq("shangxia_types", huibianzhishi.getShangxiaTypes())
            .eq("huibianzhishi_delete", huibianzhishi.getHuibianzhishiDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuibianzhishiEntity huibianzhishiEntity = huibianzhishiService.selectOne(queryWrapper);
        if(huibianzhishiEntity==null){
            huibianzhishi.setHuibianzhishiClicknum(1);
            huibianzhishi.setShangxiaTypes(1);
            huibianzhishi.setHuibianzhishiDelete(1);
            huibianzhishi.setCreateTime(new Date());
            huibianzhishiService.insert(huibianzhishi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody HuibianzhishiEntity huibianzhishi, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,huibianzhishi:{}",this.getClass().getName(),huibianzhishi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<HuibianzhishiEntity> queryWrapper = new EntityWrapper<HuibianzhishiEntity>()
            .notIn("id",huibianzhishi.getId())
            .andNew()
            .eq("huibianzhishi_name", huibianzhishi.getHuibianzhishiName())
            .eq("huibianzhishi_uuid_number", huibianzhishi.getHuibianzhishiUuidNumber())
            .eq("huibianzhishi_video", huibianzhishi.getHuibianzhishiVideo())
            .eq("huibianzhishi_types", huibianzhishi.getHuibianzhishiTypes())
            .eq("zan_number", huibianzhishi.getZanNumber())
            .eq("cai_number", huibianzhishi.getCaiNumber())
            .eq("huibianzhishi_clicknum", huibianzhishi.getHuibianzhishiClicknum())
            .eq("shangxia_types", huibianzhishi.getShangxiaTypes())
            .eq("huibianzhishi_delete", huibianzhishi.getHuibianzhishiDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuibianzhishiEntity huibianzhishiEntity = huibianzhishiService.selectOne(queryWrapper);
        if("".equals(huibianzhishi.getHuibianzhishiPhoto()) || "null".equals(huibianzhishi.getHuibianzhishiPhoto())){
                huibianzhishi.setHuibianzhishiPhoto(null);
        }
        if("".equals(huibianzhishi.getHuibianzhishiVideo()) || "null".equals(huibianzhishi.getHuibianzhishiVideo())){
                huibianzhishi.setHuibianzhishiVideo(null);
        }
        if("".equals(huibianzhishi.getHuibianzhishiFile()) || "null".equals(huibianzhishi.getHuibianzhishiFile())){
                huibianzhishi.setHuibianzhishiFile(null);
        }
        if(huibianzhishiEntity==null){
            huibianzhishiService.updateById(huibianzhishi);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<HuibianzhishiEntity> list = new ArrayList<>();
        for(Integer id:ids){
            HuibianzhishiEntity huibianzhishiEntity = new HuibianzhishiEntity();
            huibianzhishiEntity.setId(id);
            huibianzhishiEntity.setHuibianzhishiDelete(2);
            list.add(huibianzhishiEntity);
        }
        if(list != null && list.size() >0){
            huibianzhishiService.updateBatchById(list);
        }
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<HuibianzhishiEntity> huibianzhishiList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            HuibianzhishiEntity huibianzhishiEntity = new HuibianzhishiEntity();
//                            huibianzhishiEntity.setHuibianzhishiName(data.get(0));                    //汇编知识名称 要改的
//                            huibianzhishiEntity.setHuibianzhishiUuidNumber(data.get(0));                    //汇编知识编号 要改的
//                            huibianzhishiEntity.setHuibianzhishiPhoto("");//详情和图片
//                            huibianzhishiEntity.setHuibianzhishiVideo(data.get(0));                    //汇编知识视频 要改的
//                            huibianzhishiEntity.setHuibianzhishiFile(data.get(0));                    //知识课件 要改的
//                            huibianzhishiEntity.setHuibianzhishiTypes(Integer.valueOf(data.get(0)));   //汇编知识类型 要改的
//                            huibianzhishiEntity.setZanNumber(Integer.valueOf(data.get(0)));   //赞 要改的
//                            huibianzhishiEntity.setCaiNumber(Integer.valueOf(data.get(0)));   //踩 要改的
//                            huibianzhishiEntity.setHuibianzhishiClicknum(Integer.valueOf(data.get(0)));   //知识热度 要改的
//                            huibianzhishiEntity.setHuibianzhishiContent("");//详情和图片
//                            huibianzhishiEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            huibianzhishiEntity.setHuibianzhishiDelete(1);//逻辑删除字段
//                            huibianzhishiEntity.setCreateTime(date);//时间
                            huibianzhishiList.add(huibianzhishiEntity);


                            //把要查询是否重复的字段放入map中
                                //汇编知识编号
                                if(seachFields.containsKey("huibianzhishiUuidNumber")){
                                    List<String> huibianzhishiUuidNumber = seachFields.get("huibianzhishiUuidNumber");
                                    huibianzhishiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> huibianzhishiUuidNumber = new ArrayList<>();
                                    huibianzhishiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("huibianzhishiUuidNumber",huibianzhishiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //汇编知识编号
                        List<HuibianzhishiEntity> huibianzhishiEntities_huibianzhishiUuidNumber = huibianzhishiService.selectList(new EntityWrapper<HuibianzhishiEntity>().in("huibianzhishi_uuid_number", seachFields.get("huibianzhishiUuidNumber")).eq("huibianzhishi_delete", 1));
                        if(huibianzhishiEntities_huibianzhishiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(HuibianzhishiEntity s:huibianzhishiEntities_huibianzhishiUuidNumber){
                                repeatFields.add(s.getHuibianzhishiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [汇编知识编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        huibianzhishiService.insertBatch(huibianzhishiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = huibianzhishiService.queryPage(params);

        //字典表数据转换
        List<HuibianzhishiView> list =(List<HuibianzhishiView>)page.getList();
        for(HuibianzhishiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        HuibianzhishiEntity huibianzhishi = huibianzhishiService.selectById(id);
            if(huibianzhishi !=null){

                //点击数量加1
                huibianzhishi.setHuibianzhishiClicknum(huibianzhishi.getHuibianzhishiClicknum()+1);
                huibianzhishiService.updateById(huibianzhishi);

                //entity转view
                HuibianzhishiView view = new HuibianzhishiView();
                BeanUtils.copyProperties( huibianzhishi , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody HuibianzhishiEntity huibianzhishi, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,huibianzhishi:{}",this.getClass().getName(),huibianzhishi.toString());
        Wrapper<HuibianzhishiEntity> queryWrapper = new EntityWrapper<HuibianzhishiEntity>()
            .eq("huibianzhishi_name", huibianzhishi.getHuibianzhishiName())
            .eq("huibianzhishi_uuid_number", huibianzhishi.getHuibianzhishiUuidNumber())
            .eq("huibianzhishi_video", huibianzhishi.getHuibianzhishiVideo())
            .eq("huibianzhishi_types", huibianzhishi.getHuibianzhishiTypes())
            .eq("zan_number", huibianzhishi.getZanNumber())
            .eq("cai_number", huibianzhishi.getCaiNumber())
            .eq("huibianzhishi_clicknum", huibianzhishi.getHuibianzhishiClicknum())
            .eq("shangxia_types", huibianzhishi.getShangxiaTypes())
            .eq("huibianzhishi_delete", huibianzhishi.getHuibianzhishiDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuibianzhishiEntity huibianzhishiEntity = huibianzhishiService.selectOne(queryWrapper);
        if(huibianzhishiEntity==null){
            huibianzhishi.setHuibianzhishiDelete(1);
            huibianzhishi.setCreateTime(new Date());
        huibianzhishiService.insert(huibianzhishi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
