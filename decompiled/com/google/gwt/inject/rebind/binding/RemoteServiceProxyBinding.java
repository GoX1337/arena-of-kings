/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.ext.GeneratorContext
 *  com.google.gwt.core.ext.typeinfo.JClassType
 *  com.google.gwt.core.ext.typeinfo.TypeOracle
 *  com.google.gwt.user.client.rpc.RemoteService
 *  com.google.inject.Inject
 */
package com.google.gwt.inject.rebind.binding;

import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.TypeOracle;
import com.google.gwt.inject.rebind.binding.CallGwtDotCreateBinding;
import com.google.gwt.inject.rebind.util.KeyUtil;
import com.google.gwt.inject.rebind.util.SourceWriteUtil;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.inject.Inject;

public class RemoteServiceProxyBinding
extends CallGwtDotCreateBinding {
    private static final String ASYNC_SERVICE_PROXY_SUFFIX = "Async";
    private final GeneratorContext ctx;

    @Inject
    public RemoteServiceProxyBinding(SourceWriteUtil sourceWriteUtil, KeyUtil keyUtil, GeneratorContext generatorContext) {
        super(sourceWriteUtil, keyUtil);
        this.ctx = generatorContext;
    }

    protected String getTypeNameToCreate() {
        String string = super.getTypeNameToCreate();
        String string2 = string.substring(0, string.length() - ASYNC_SERVICE_PROXY_SUFFIX.length());
        TypeOracle typeOracle = this.ctx.getTypeOracle();
        JClassType jClassType = typeOracle.findType(string2);
        JClassType jClassType2 = typeOracle.findType(RemoteService.class.getName());
        if (jClassType != null && jClassType2 != null && jClassType.isAssignableTo(jClassType2)) {
            string = jClassType.getQualifiedSourceName();
        }
        return string;
    }

    public static boolean isRemoteServiceProxy(JClassType jClassType) {
        return jClassType.isInterface() != null && jClassType.getQualifiedSourceName().endsWith(ASYNC_SERVICE_PROXY_SUFFIX);
    }
}

