/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.platform.win32.COM.tlb.imp;

import com.sun.jna.platform.win32.COM.ITypeInfo;
import com.sun.jna.platform.win32.COM.TypeInfoUtil;
import com.sun.jna.platform.win32.COM.TypeLibUtil;
import com.sun.jna.platform.win32.COM.tlb.imp.TlbAbstractMethod;
import com.sun.jna.platform.win32.COM.tlb.imp.TlbBase;
import com.sun.jna.platform.win32.COM.tlb.imp.TlbFunctionDispId;
import com.sun.jna.platform.win32.COM.tlb.imp.TlbFunctionVTable;
import com.sun.jna.platform.win32.COM.tlb.imp.TlbPropertyGet;
import com.sun.jna.platform.win32.COM.tlb.imp.TlbPropertyPut;
import com.sun.jna.platform.win32.OaIdl;

public class TlbCoClass
extends TlbBase {
    public TlbCoClass(int n2, String string, TypeLibUtil typeLibUtil, String string2) {
        super(n2, typeLibUtil, null);
        TypeInfoUtil typeInfoUtil = typeLibUtil.getTypeInfoUtil(n2);
        TypeLibUtil.TypeLibDoc typeLibDoc = this.typeLibUtil.getDocumentation(n2);
        String string3 = typeLibDoc.getDocString();
        if (typeLibDoc.getName().length() > 0) {
            this.name = typeLibDoc.getName();
        }
        this.logInfo("Type of kind 'CoClass' found: " + this.name);
        this.createPackageName(string);
        this.createClassName(this.name);
        this.setFilename(this.name);
        String string4 = this.typeLibUtil.getLibAttr().guid.toGuidString();
        int n3 = this.typeLibUtil.getLibAttr().wMajorVerNum.intValue();
        int n4 = this.typeLibUtil.getLibAttr().wMinorVerNum.intValue();
        String string5 = n3 + "." + n4;
        String string6 = typeInfoUtil.getTypeAttr().guid.toGuidString();
        this.createJavaDocHeader(string4, string5, string3);
        this.createCLSID(string6);
        this.createCLSIDName(this.name);
        OaIdl.TYPEATTR tYPEATTR = typeInfoUtil.getTypeAttr();
        int n5 = tYPEATTR.cImplTypes.intValue();
        String string7 = "";
        for (int i2 = 0; i2 < n5; ++i2) {
            OaIdl.HREFTYPE hREFTYPE = typeInfoUtil.getRefTypeOfImplType(i2);
            ITypeInfo iTypeInfo = typeInfoUtil.getRefTypeInfo(hREFTYPE);
            TypeInfoUtil typeInfoUtil2 = new TypeInfoUtil(iTypeInfo);
            this.createFunctions(typeInfoUtil2, string2);
            TypeInfoUtil.TypeInfoDoc typeInfoDoc = typeInfoUtil2.getDocumentation(new OaIdl.MEMBERID(-1));
            string7 = string7 + typeInfoDoc.getName();
            if (i2 >= n5 - 1) continue;
            string7 = string7 + ", ";
        }
        this.createInterfaces(string7);
        this.createContent(this.content);
    }

    protected void createFunctions(TypeInfoUtil typeInfoUtil, String string) {
        OaIdl.TYPEATTR tYPEATTR = typeInfoUtil.getTypeAttr();
        int n2 = tYPEATTR.cFuncs.intValue();
        for (int i2 = 0; i2 < n2; ++i2) {
            OaIdl.FUNCDESC fUNCDESC = typeInfoUtil.getFuncDesc(i2);
            TlbAbstractMethod tlbAbstractMethod = null;
            if (fUNCDESC.invkind.value == OaIdl.INVOKEKIND.INVOKE_FUNC.value) {
                tlbAbstractMethod = this.isVTableMode() ? new TlbFunctionVTable(i2, this.index, this.typeLibUtil, fUNCDESC, typeInfoUtil) : new TlbFunctionDispId(i2, this.index, this.typeLibUtil, fUNCDESC, typeInfoUtil);
            } else if (fUNCDESC.invkind.value == OaIdl.INVOKEKIND.INVOKE_PROPERTYGET.value) {
                tlbAbstractMethod = new TlbPropertyGet(i2, this.index, this.typeLibUtil, fUNCDESC, typeInfoUtil);
            } else if (fUNCDESC.invkind.value == OaIdl.INVOKEKIND.INVOKE_PROPERTYPUT.value) {
                tlbAbstractMethod = new TlbPropertyPut(i2, this.index, this.typeLibUtil, fUNCDESC, typeInfoUtil);
            } else if (fUNCDESC.invkind.value == OaIdl.INVOKEKIND.INVOKE_PROPERTYPUTREF.value) {
                tlbAbstractMethod = new TlbPropertyPut(i2, this.index, this.typeLibUtil, fUNCDESC, typeInfoUtil);
            }
            if (!this.isReservedMethod(tlbAbstractMethod.getMethodName())) {
                this.content = this.content + tlbAbstractMethod.getClassBuffer();
                if (i2 < n2 - 1) {
                    this.content = this.content + "\n";
                }
            }
            typeInfoUtil.ReleaseFuncDesc(fUNCDESC);
        }
    }

    protected void createJavaDocHeader(String string, String string2, String string3) {
        this.replaceVariable("uuid", string);
        this.replaceVariable("version", string2);
        this.replaceVariable("helpstring", string3);
    }

    protected void createCLSIDName(String string) {
        this.replaceVariable("clsidname", string.toUpperCase());
    }

    protected void createCLSID(String string) {
        this.replaceVariable("clsid", string);
    }

    protected void createInterfaces(String string) {
        this.replaceVariable("interfaces", string);
    }

    @Override
    protected String getClassTemplate() {
        return "com/sun/jna/platform/win32/COM/tlb/imp/TlbCoClass.template";
    }
}

