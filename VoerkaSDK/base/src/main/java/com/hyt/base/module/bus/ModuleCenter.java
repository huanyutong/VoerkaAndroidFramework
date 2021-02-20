package com.hyt.base.module.bus;

import android.content.Context;

import com.hyt.base.module.util.ClassUtils;
import com.hyt.base.module.util.ModuleUtil;
import com.hyt.model.ModuleMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ModuleCenter {
    private static final String TAG = ModuleCenter.class.getSimpleName();

    private static Set<ModuleMeta> group = new HashSet<>();
    private static Map<String,Set<ModuleMeta>> sortgroup = new HashMap<>();

    public synchronized static void init(Context context){
        try {
            //获取指定ModuleUnit$$的类名文件
            List<String> classFileNames = ClassUtils.getFileNameByPackageName(context, ModuleUtil.NAME_OF_MODULEUNIT);
            for(String className:classFileNames){
                if(className.startsWith(ModuleUtil.ADDRESS_OF_MODULEUNIT)){
                    IModuleUnit iModuleUnit = (IModuleUnit)(Class.forName(className).getConstructor().newInstance());
                    iModuleUnit.loadInto(group);//加载列表
                }
            }
//            Logger.i(TAG,"group = "+ group.toString());
            sort(group);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 排列Module列表
     * @param group
     */
    private static void sort(Set<ModuleMeta> group){
        for(ModuleMeta meta:group){
            Set<ModuleMeta> metaSet = new HashSet<>();
            if(sortgroup.get(meta.templet)!=null){
                metaSet=sortgroup.get(meta.templet);
            }
            metaSet.add(meta);
            sortgroup.put(meta.templet,metaSet);
        }
    }

    /**
     * 分隔载入多模板
     * @param groupName
     * @return
     */
    private static String[] split(String groupName){
        return groupName.split(",");
    }

    public static List<String> getModuleList(String templet){
        List<String> list = new ArrayList<>();
        if(sortgroup.containsKey(templet)){
            for(ModuleMeta meta:sortgroup.get(templet)){
                list.add(meta.moduleName);
            }
        }else{
//            Log.i(TAG,"do not have key "+ templet);
        }
        //            Log.i(TAG,"list = "+ list.toString());
        return list;
    }
}
