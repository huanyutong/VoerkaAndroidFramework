package com.hyt.base.module.bus;

import com.hyt.model.ModuleMeta;

import java.util.Set;

public interface IModuleUnit {
    void loadInto(Set<ModuleMeta> group);
}
