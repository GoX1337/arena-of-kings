/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.platform.win32.COM.tlb.imp;

import com.sun.jna.platform.win32.COM.TypeInfoUtil;
import com.sun.jna.platform.win32.COM.TypeLibUtil;
import com.sun.jna.platform.win32.COM.tlb.imp.TlbAbstractMethod;
import com.sun.jna.platform.win32.COM.tlb.imp.TlbBase;
import com.sun.jna.platform.win32.COM.tlb.imp.TlbFunctionStub;
import com.sun.jna.platform.win32.COM.tlb.imp.TlbPropertyGetStub;
import com.sun.jna.platform.win32.COM.tlb.imp.TlbPropertyPutStub;
import com.sun.jna.platform.win32.OaIdl;

public class TlbDispInterface
extends TlbBase {
    public TlbDispInterface(int n2, String string, TypeLibUtil typeLibUtil) {
        super(n2, typeLibUtil, null);
        TypeLibUtil.TypeLibDoc typeLibDoc = this.typeLibUtil.getDocumentation(n2);
        String string2 = typeLibDoc.getDocString();
        if (typeLibDoc.getName().length() > 0) {
            this.name = typeLibDoc.getName();
        }
        this.logInfo("Type of kind 'DispInterface' found: " + this.name);
        this.createPackageName(string);
        this.createClassName(this.name);
        this.setFilename(this.name);
        TypeInfoUtil typeInfoUtil = typeLibUtil.getTypeInfoUtil(n2);
        OaIdl.TYPEATTR tYPEATTR = typeInfoUtil.getTypeAttr();
        this.createJavaDocHeader(tYPEATTR.guid.toGuidString(), string2);
        int n3 = tYPEATTR.cFuncs.intValue();
        for (int i2 = 0; i2 < n3; ++i2) {
            OaIdl.FUNCDESC fUNCDESC = typeInfoUtil.getFuncDesc(i2);
            OaIdl.MEMBERID mEMBERID = fUNCDESC.memid;
            TypeInfoUtil.TypeInfoDoc typeInfoDoc = typeInfoUtil.getDocumentation(mEMBERID);
            String string3 = typeInfoDoc.getName();
            TlbAbstractMethod tlbAbstractMethod = null;
            if (!this.isReservedMethod(string3)) {
                if (fUNCDESC.invkind.value == OaIdl.INVOKEKIND.INVOKE_FUNC.value) {
                    tlbAbstractMethod = new TlbFunctionStub(n2, typeLibUtil, fUNCDESC, typeInfoUtil);
                } else if (fUNCDESC.invkind.value == OaIdl.INVOKEKIND.INVOKE_PROPERTYGET.value) {
                    tlbAbstractMethod = new TlbPropertyGetStub(n2, typeLibUtil, fUNCDESC, typeInfoUtil);
                } else if (fUNCDESC.invkind.value == OaIdl.INVOKEKIND.INVOKE_PROPERTYPUT.value) {
                    tlbAbstractMethod = new TlbPropertyPutStub(n2, typeLibUtil, fUNCDESC, typeInfoUtil);
                } else if (fUNCDESC.invkind.value == OaIdl.INVOKEKIND.INVOKE_PROPERTYPUTREF.value) {
                    tlbAbstractMethod = new TlbPropertyPutStub(n2, typeLibUtil, fUNCDESC, typeInfoUtil);
                }
                this.content = this.content + tlbAbstractMethod.getClassBuffer();
                if (i2 < n3 - 1) {
                    this.content = this.content + "\n";
                }
            }
            typeInfoUtil.ReleaseFuncDesc(fUNCDESC);
        }
        this.createContent(this.content);
    }

    protected void createJavaDocHeader(String string, String string2) {
        this.replaceVariable("uuid", string);
        this.replaceVariable("helpstring", string2);
    }

    @Override
    protected String getClassTemplate() {
        return "com/sun/jna/platform/win32/COM/tlb/imp/TlbDispInterface.template";
    }
}

