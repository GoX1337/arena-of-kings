/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.platform.win32.COM.tlb.imp;

import com.sun.jna.platform.win32.COM.TypeInfoUtil;
import com.sun.jna.platform.win32.COM.TypeLibUtil;
import com.sun.jna.platform.win32.COM.tlb.imp.TlbBase;
import com.sun.jna.platform.win32.OaIdl;
import com.sun.jna.platform.win32.Variant;

public class TlbInterface
extends TlbBase {
    public TlbInterface(int n2, String string, TypeLibUtil typeLibUtil) {
        super(n2, typeLibUtil, null);
        TypeLibUtil.TypeLibDoc typeLibDoc = this.typeLibUtil.getDocumentation(n2);
        String string2 = typeLibDoc.getDocString();
        if (typeLibDoc.getName().length() > 0) {
            this.name = typeLibDoc.getName();
        }
        this.logInfo("Type of kind 'Interface' found: " + this.name);
        this.createPackageName(string);
        this.createClassName(this.name);
        this.setFilename(this.name);
        TypeInfoUtil typeInfoUtil = typeLibUtil.getTypeInfoUtil(n2);
        OaIdl.TYPEATTR tYPEATTR = typeInfoUtil.getTypeAttr();
        this.createJavaDocHeader(tYPEATTR.guid.toGuidString(), string2);
        int n3 = tYPEATTR.cVars.intValue();
        for (int i2 = 0; i2 < n3; ++i2) {
            OaIdl.VARDESC vARDESC = typeInfoUtil.getVarDesc(i2);
            Variant.VARIANT.ByReference byReference = vARDESC._vardesc.lpvarValue;
            Object object = byReference.getValue();
            OaIdl.MEMBERID mEMBERID = vARDESC.memid;
            TypeInfoUtil.TypeInfoDoc typeInfoDoc = typeInfoUtil.getDocumentation(mEMBERID);
            this.content = this.content + "\t\t//" + typeInfoDoc.getName() + "\n";
            this.content = this.content + "\t\tpublic static final int " + typeInfoDoc.getName() + " = " + object.toString() + ";";
            if (i2 >= n3 - 1) continue;
            this.content = this.content + "\n";
        }
        this.createContent(this.content);
    }

    protected void createJavaDocHeader(String string, String string2) {
        this.replaceVariable("uuid", string);
        this.replaceVariable("helpstring", string2);
    }

    @Override
    protected String getClassTemplate() {
        return "com/sun/jna/platform/win32/COM/tlb/imp/TlbInterface.template";
    }
}

