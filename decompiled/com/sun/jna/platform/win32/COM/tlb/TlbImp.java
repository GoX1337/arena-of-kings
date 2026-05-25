/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.platform.win32.COM.tlb;

import com.sun.jna.platform.win32.COM.TypeLibUtil;
import com.sun.jna.platform.win32.COM.tlb.imp.TlbBase;
import com.sun.jna.platform.win32.COM.tlb.imp.TlbCmdlineArgs;
import com.sun.jna.platform.win32.COM.tlb.imp.TlbCoClass;
import com.sun.jna.platform.win32.COM.tlb.imp.TlbConst;
import com.sun.jna.platform.win32.COM.tlb.imp.TlbDispInterface;
import com.sun.jna.platform.win32.COM.tlb.imp.TlbEnum;
import com.sun.jna.platform.win32.COM.tlb.imp.TlbInterface;
import com.sun.jna.platform.win32.OaIdl;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class TlbImp
implements TlbConst {
    private TypeLibUtil typeLibUtil;
    private File comRootDir;
    private File outputDir;
    private TlbCmdlineArgs cmdlineArgs;

    public static void main(String[] stringArray) {
        new TlbImp(stringArray);
    }

    public TlbImp(String[] stringArray) {
        this.cmdlineArgs = new TlbCmdlineArgs(stringArray);
        if (this.cmdlineArgs.isTlbId()) {
            String string = this.cmdlineArgs.getRequiredParam("tlb.id");
            int n2 = this.cmdlineArgs.getIntParam("tlb.major.version");
            int n3 = this.cmdlineArgs.getIntParam("tlb.minor.version");
            this.typeLibUtil = new TypeLibUtil(string, n2, n3);
            this.startCOM2Java();
        } else if (this.cmdlineArgs.isTlbFile()) {
            String string = this.cmdlineArgs.getRequiredParam("tlb.file");
            this.typeLibUtil = new TypeLibUtil(string);
            this.startCOM2Java();
        } else {
            this.cmdlineArgs.showCmdHelp();
        }
    }

    public void startCOM2Java() {
        try {
            this.createDir();
            String string = this.cmdlineArgs.getBindingMode();
            int n2 = this.typeLibUtil.getTypeInfoCount();
            for (int i2 = 0; i2 < n2; ++i2) {
                OaIdl.TYPEKIND tYPEKIND = this.typeLibUtil.getTypeInfoType(i2);
                if (tYPEKIND.value == 0) {
                    this.createCOMEnum(i2, this.getPackageName(), this.typeLibUtil);
                    continue;
                }
                if (tYPEKIND.value == 1) {
                    TlbImp.logInfo("'TKIND_RECORD' objects are currently not supported!");
                    continue;
                }
                if (tYPEKIND.value == 2) {
                    TlbImp.logInfo("'TKIND_MODULE' objects are currently not supported!");
                    continue;
                }
                if (tYPEKIND.value == 3) {
                    this.createCOMInterface(i2, this.getPackageName(), this.typeLibUtil);
                    continue;
                }
                if (tYPEKIND.value == 4) {
                    this.createCOMDispInterface(i2, this.getPackageName(), this.typeLibUtil);
                    continue;
                }
                if (tYPEKIND.value == 5) {
                    this.createCOMCoClass(i2, this.getPackageName(), this.typeLibUtil, string);
                    continue;
                }
                if (tYPEKIND.value == 6) {
                    TlbImp.logInfo("'TKIND_ALIAS' objects are currently not supported!");
                    continue;
                }
                if (tYPEKIND.value != 7) continue;
                TlbImp.logInfo("'TKIND_UNION' objects are currently not supported!");
            }
            TlbImp.logInfo(n2 + " files sucessfully written to: " + this.comRootDir.toString());
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void createDir() {
        String string = this.cmdlineArgs.getParam("output.dir");
        String string2 = "_jnaCOM_" + System.currentTimeMillis() + "\\myPackage\\" + this.typeLibUtil.getName().toLowerCase() + "\\";
        if (string != null) {
            this.comRootDir = new File(string + "\\" + string2);
        } else {
            String string3 = System.getProperty("java.io.tmpdir");
            this.comRootDir = new File(string3 + "\\" + string2);
        }
        if (this.comRootDir.exists()) {
            this.comRootDir.delete();
        }
        if (!this.comRootDir.mkdirs()) {
            throw new FileNotFoundException("Output directory NOT sucessfully created to: " + this.comRootDir.toString());
        }
        TlbImp.logInfo("Output directory sucessfully created.");
    }

    private String getPackageName() {
        return "myPackage." + this.typeLibUtil.getName().toLowerCase();
    }

    private void writeTextFile(String string, String string2) {
        String string3 = this.comRootDir + File.separator + string;
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(string3));
        bufferedOutputStream.write(string2.getBytes());
        bufferedOutputStream.close();
    }

    private void writeTlbClass(TlbBase tlbBase) {
        StringBuffer stringBuffer = tlbBase.getClassBuffer();
        this.writeTextFile(tlbBase.getFilename(), stringBuffer.toString());
    }

    private void createCOMEnum(int n2, String string, TypeLibUtil typeLibUtil) {
        TlbEnum tlbEnum = new TlbEnum(n2, string, typeLibUtil);
        this.writeTlbClass(tlbEnum);
    }

    private void createCOMInterface(int n2, String string, TypeLibUtil typeLibUtil) {
        TlbInterface tlbInterface = new TlbInterface(n2, string, typeLibUtil);
        this.writeTlbClass(tlbInterface);
    }

    private void createCOMDispInterface(int n2, String string, TypeLibUtil typeLibUtil) {
        TlbDispInterface tlbDispInterface = new TlbDispInterface(n2, string, typeLibUtil);
        this.writeTlbClass(tlbDispInterface);
    }

    private void createCOMCoClass(int n2, String string, TypeLibUtil typeLibUtil, String string2) {
        TlbCoClass tlbCoClass = new TlbCoClass(n2, this.getPackageName(), typeLibUtil, string2);
        this.writeTlbClass(tlbCoClass);
    }

    public static void logInfo(String string) {
        System.out.println(string);
    }
}

