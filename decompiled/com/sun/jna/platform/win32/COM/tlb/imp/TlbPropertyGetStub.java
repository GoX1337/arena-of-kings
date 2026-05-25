/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.platform.win32.COM.tlb.imp;

import com.sun.jna.platform.win32.COM.TypeInfoUtil;
import com.sun.jna.platform.win32.COM.TypeLibUtil;
import com.sun.jna.platform.win32.COM.tlb.imp.TlbAbstractMethod;
import com.sun.jna.platform.win32.OaIdl;

public class TlbPropertyGetStub
extends TlbAbstractMethod {
    public TlbPropertyGetStub(int n2, TypeLibUtil typeLibUtil, OaIdl.FUNCDESC fUNCDESC, TypeInfoUtil typeInfoUtil) {
        super(n2, typeLibUtil, fUNCDESC, typeInfoUtil);
        TypeInfoUtil.TypeInfoDoc typeInfoDoc = typeInfoUtil.getDocumentation(fUNCDESC.memid);
        String string = typeInfoDoc.getDocString();
        String string2 = "get" + typeInfoDoc.getName();
        this.replaceVariable("helpstring", string);
        this.replaceVariable("returntype", this.returnType);
        this.replaceVariable("methodname", string2);
        this.replaceVariable("vtableid", String.valueOf(this.vtableId));
        this.replaceVariable("memberid", String.valueOf(this.memberid));
    }

    @Override
    protected String getClassTemplate() {
        return "com/sun/jna/platform/win32/COM/tlb/imp/TlbPropertyGetStub.template";
    }
}

