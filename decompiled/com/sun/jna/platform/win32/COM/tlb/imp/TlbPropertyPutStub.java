/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.platform.win32.COM.tlb.imp;

import com.sun.jna.platform.win32.COM.TypeInfoUtil;
import com.sun.jna.platform.win32.COM.TypeLibUtil;
import com.sun.jna.platform.win32.COM.tlb.imp.TlbAbstractMethod;
import com.sun.jna.platform.win32.OaIdl;

public class TlbPropertyPutStub
extends TlbAbstractMethod {
    public TlbPropertyPutStub(int n2, TypeLibUtil typeLibUtil, OaIdl.FUNCDESC fUNCDESC, TypeInfoUtil typeInfoUtil) {
        super(n2, typeLibUtil, fUNCDESC, typeInfoUtil);
        TypeInfoUtil.TypeInfoDoc typeInfoDoc = typeInfoUtil.getDocumentation(fUNCDESC.memid);
        String string = typeInfoDoc.getDocString();
        String string2 = "set" + typeInfoDoc.getName();
        String[] stringArray = typeInfoUtil.getNames(fUNCDESC.memid, this.paramCount + 1);
        for (int i2 = 0; i2 < this.paramCount; ++i2) {
            OaIdl.ELEMDESC eLEMDESC = fUNCDESC.lprgelemdescParam.elemDescArg[i2];
            String string3 = this.getType(eLEMDESC);
            this.methodparams = this.methodparams + string3 + " " + this.replaceJavaKeyword(stringArray[i2].toLowerCase());
            if (i2 >= this.paramCount - 1) continue;
            this.methodparams = this.methodparams + ", ";
        }
        this.replaceVariable("helpstring", string);
        this.replaceVariable("methodname", string2);
        this.replaceVariable("methodparams", this.methodparams);
        this.replaceVariable("vtableid", String.valueOf(this.vtableId));
        this.replaceVariable("memberid", String.valueOf(this.memberid));
    }

    @Override
    protected String getClassTemplate() {
        return "com/sun/jna/platform/win32/COM/tlb/imp/TlbPropertyPutStub.template";
    }
}

