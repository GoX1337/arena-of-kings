/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.platform.win32.COM.tlb.imp;

import com.sun.jna.platform.win32.COM.TypeInfoUtil;
import com.sun.jna.platform.win32.COM.TypeLibUtil;
import com.sun.jna.platform.win32.COM.tlb.imp.TlbAbstractMethod;
import com.sun.jna.platform.win32.OaIdl;

public class TlbFunctionStub
extends TlbAbstractMethod {
    public TlbFunctionStub(int n2, TypeLibUtil typeLibUtil, OaIdl.FUNCDESC fUNCDESC, TypeInfoUtil typeInfoUtil) {
        super(n2, typeLibUtil, fUNCDESC, typeInfoUtil);
        TypeInfoUtil.TypeInfoDoc typeInfoDoc = typeInfoUtil.getDocumentation(fUNCDESC.memid);
        String string = typeInfoDoc.getName();
        String string2 = typeInfoDoc.getDocString();
        String[] stringArray = typeInfoUtil.getNames(fUNCDESC.memid, this.paramCount + 1);
        if (this.paramCount > 0) {
            this.methodvariables = ", ";
        }
        for (int i2 = 0; i2 < this.paramCount; ++i2) {
            OaIdl.ELEMDESC eLEMDESC = fUNCDESC.lprgelemdescParam.elemDescArg[i2];
            String string3 = stringArray[i2 + 1].toLowerCase();
            this.methodparams = this.methodparams + this.getType(eLEMDESC.tdesc) + " " + this.replaceJavaKeyword(string3);
            this.methodvariables = this.methodvariables + string3;
            if (i2 >= this.paramCount - 1) continue;
            this.methodparams = this.methodparams + ", ";
            this.methodvariables = this.methodvariables + ", ";
        }
        this.replaceVariable("helpstring", string2);
        this.replaceVariable("returntype", this.returnType);
        this.replaceVariable("methodname", string);
        this.replaceVariable("methodparams", this.methodparams);
        this.replaceVariable("vtableid", String.valueOf(this.vtableId));
        this.replaceVariable("memberid", String.valueOf(this.memberid));
    }

    @Override
    protected String getClassTemplate() {
        return "com/sun/jna/platform/win32/COM/tlb/imp/TlbFunctionStub.template";
    }
}

