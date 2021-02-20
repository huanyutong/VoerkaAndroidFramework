package com.hyt.base.module.model;

import android.os.Bundle;

import com.hyt.base.module.base.AbsModule;

import java.lang.reflect.Method;

/**
 * Created by air on 2016/12/18.
 */

public class ModuleInfo {
    public String name;         //模块名称
    public AbsModule module;    //模块实体

    public ModuleInfo(String name, AbsModule module) {
        this.name = name;
        this.module = module;
    }
}
