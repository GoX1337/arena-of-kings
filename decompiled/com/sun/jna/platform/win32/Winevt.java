/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.platform.win32;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.StringArray;
import com.sun.jna.Structure;
import com.sun.jna.Union;
import com.sun.jna.platform.win32.BaseTSD;
import com.sun.jna.platform.win32.Guid;
import com.sun.jna.platform.win32.WinBase;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.win32.W32APITypeMapper;

public interface Winevt {
    public static final int EVT_VARIANT_TYPE_ARRAY = 128;
    public static final int EVT_VARIANT_TYPE_MASK = 127;
    public static final int EVT_READ_ACCESS = 1;
    public static final int EVT_WRITE_ACCESS = 2;
    public static final int EVT_ALL_ACCESS = 7;
    public static final int EVT_CLEAR_ACCESS = 4;

    public static class EVT_HANDLE
    extends WinNT.HANDLE {
        public EVT_HANDLE() {
        }

        public EVT_HANDLE(Pointer pointer) {
            super(pointer);
        }
    }

    public static interface EVT_EVENT_PROPERTY_ID {
        public static final int EvtEventQueryIDs = 0;
        public static final int EvtEventPath = 1;
        public static final int EvtEventPropertyIdEND = 2;
    }

    public static interface EVT_QUERY_PROPERTY_ID {
        public static final int EvtQueryNames = 0;
        public static final int EvtQueryStatuses = 1;
        public static final int EvtQueryPropertyIdEND = 2;
    }

    public static interface EVT_EVENT_METADATA_PROPERTY_ID {
        public static final int EventMetadataEventID = 0;
        public static final int EventMetadataEventVersion = 1;
        public static final int EventMetadataEventChannel = 2;
        public static final int EventMetadataEventLevel = 3;
        public static final int EventMetadataEventOpcode = 4;
        public static final int EventMetadataEventTask = 5;
        public static final int EventMetadataEventKeyword = 6;
        public static final int EventMetadataEventMessageID = 7;
        public static final int EventMetadataEventTemplate = 8;
        public static final int EvtEventMetadataPropertyIdEND = 9;
    }

    public static interface EVT_PUBLISHER_METADATA_PROPERTY_ID {
        public static final int EvtPublisherMetadataPublisherGuid = 0;
        public static final int EvtPublisherMetadataResourceFilePath = 1;
        public static final int EvtPublisherMetadataParameterFilePath = 2;
        public static final int EvtPublisherMetadataMessageFilePath = 3;
        public static final int EvtPublisherMetadataHelpLink = 4;
        public static final int EvtPublisherMetadataPublisherMessageID = 5;
        public static final int EvtPublisherMetadataChannelReferences = 6;
        public static final int EvtPublisherMetadataChannelReferencePath = 7;
        public static final int EvtPublisherMetadataChannelReferenceIndex = 8;
        public static final int EvtPublisherMetadataChannelReferenceID = 9;
        public static final int EvtPublisherMetadataChannelReferenceFlags = 10;
        public static final int EvtPublisherMetadataChannelReferenceMessageID = 11;
        public static final int EvtPublisherMetadataLevels = 12;
        public static final int EvtPublisherMetadataLevelName = 13;
        public static final int EvtPublisherMetadataLevelValue = 14;
        public static final int EvtPublisherMetadataLevelMessageID = 15;
        public static final int EvtPublisherMetadataTasks = 16;
        public static final int EvtPublisherMetadataTaskName = 17;
        public static final int EvtPublisherMetadataTaskEventGuid = 18;
        public static final int EvtPublisherMetadataTaskValue = 19;
        public static final int EvtPublisherMetadataTaskMessageID = 20;
        public static final int EvtPublisherMetadataOpcodes = 21;
        public static final int EvtPublisherMetadataOpcodeName = 22;
        public static final int EvtPublisherMetadataOpcodeValue = 23;
        public static final int EvtPublisherMetadataOpcodeMessageID = 24;
        public static final int EvtPublisherMetadataKeywords = 25;
        public static final int EvtPublisherMetadataKeywordName = 26;
        public static final int EvtPublisherMetadataKeywordValue = 27;
        public static final int EvtPublisherMetadataKeywordMessageID = 28;
        public static final int EvtPublisherMetadataPropertyIdEND = 29;
    }

    public static interface EVT_CHANNEL_REFERENCE_FLAGS {
        public static final int EvtChannelReferenceImported = 1;
    }

    public static interface EVT_CHANNEL_SID_TYPE {
        public static final int EvtChannelSidTypeNone = 0;
        public static final int EvtChannelSidTypePublishing = 1;
    }

    public static interface EVT_CHANNEL_CLOCK_TYPE {
        public static final int EvtChannelClockTypeSystemTime = 0;
        public static final int EvtChannelClockTypeQPC = 1;
    }

    public static interface EVT_CHANNEL_ISOLATION_TYPE {
        public static final int EvtChannelIsolationTypeApplication = 0;
        public static final int EvtChannelIsolationTypeSystem = 1;
        public static final int EvtChannelIsolationTypeCustom = 2;
    }

    public static interface EVT_CHANNEL_TYPE {
        public static final int EvtChannelTypeAdmin = 0;
        public static final int EvtChannelTypeOperational = 1;
        public static final int EvtChannelTypeAnalytic = 2;
        public static final int EvtChannelTypeDebug = 3;
    }

    public static interface EVT_CHANNEL_CONFIG_PROPERTY_ID {
        public static final int EvtChannelConfigEnabled = 0;
        public static final int EvtChannelConfigIsolation = 1;
        public static final int EvtChannelConfigType = 2;
        public static final int EvtChannelConfigOwningPublisher = 3;
        public static final int EvtChannelConfigClassicEventlog = 4;
        public static final int EvtChannelConfigAccess = 5;
        public static final int EvtChannelLoggingConfigRetention = 6;
        public static final int EvtChannelLoggingConfigAutoBackup = 7;
        public static final int EvtChannelLoggingConfigMaxSize = 8;
        public static final int EvtChannelLoggingConfigLogFilePath = 9;
        public static final int EvtChannelPublishingConfigLevel = 10;
        public static final int EvtChannelPublishingConfigKeywords = 11;
        public static final int EvtChannelPublishingConfigControlGuid = 12;
        public static final int EvtChannelPublishingConfigBufferSize = 13;
        public static final int EvtChannelPublishingConfigMinBuffers = 14;
        public static final int EvtChannelPublishingConfigMaxBuffers = 15;
        public static final int EvtChannelPublishingConfigLatency = 16;
        public static final int EvtChannelPublishingConfigClockType = 17;
        public static final int EvtChannelPublishingConfigSidType = 18;
        public static final int EvtChannelPublisherList = 19;
        public static final int EvtChannelPublishingConfigFileMax = 20;
        public static final int EvtChannelConfigPropertyIdEND = 21;
    }

    public static interface EVT_EXPORTLOG_FLAGS {
        public static final int EvtExportLogChannelPath = 1;
        public static final int EvtExportLogFilePath = 2;
        public static final int EvtExportLogTolerateQueryErrors = 4096;
        public static final int EvtExportLogOverwrite = 8192;
    }

    public static interface EVT_LOG_PROPERTY_ID {
        public static final int EvtLogCreationTime = 0;
        public static final int EvtLogLastAccessTime = 1;
        public static final int EvtLogLastWriteTime = 2;
        public static final int EvtLogFileSize = 3;
        public static final int EvtLogAttributes = 4;
        public static final int EvtLogNumberOfLogRecords = 5;
        public static final int EvtLogOldestRecordNumber = 6;
        public static final int EvtLogFull = 7;
    }

    public static interface EVT_OPEN_LOG_FLAGS {
        public static final int EvtOpenChannelPath = 1;
        public static final int EvtOpenFilePath = 2;
    }

    public static interface EVT_FORMAT_MESSAGE_FLAGS {
        public static final int EvtFormatMessageEvent = 1;
        public static final int EvtFormatMessageLevel = 2;
        public static final int EvtFormatMessageTask = 3;
        public static final int EvtFormatMessageOpcode = 4;
        public static final int EvtFormatMessageKeyword = 5;
        public static final int EvtFormatMessageChannel = 6;
        public static final int EvtFormatMessageProvider = 7;
        public static final int EvtFormatMessageId = 8;
        public static final int EvtFormatMessageXml = 9;
    }

    public static interface EVT_RENDER_FLAGS {
        public static final int EvtRenderEventValues = 0;
        public static final int EvtRenderEventXml = 1;
        public static final int EvtRenderBookmark = 2;
    }

    public static interface EVT_RENDER_CONTEXT_FLAGS {
        public static final int EvtRenderContextValues = 0;
        public static final int EvtRenderContextSystem = 1;
        public static final int EvtRenderContextUser = 2;
    }

    public static interface EVT_SYSTEM_PROPERTY_ID {
        public static final int EvtSystemProviderName = 0;
        public static final int EvtSystemProviderGuid = 1;
        public static final int EvtSystemEventID = 2;
        public static final int EvtSystemQualifiers = 3;
        public static final int EvtSystemLevel = 4;
        public static final int EvtSystemTask = 5;
        public static final int EvtSystemOpcode = 6;
        public static final int EvtSystemKeywords = 7;
        public static final int EvtSystemTimeCreated = 8;
        public static final int EvtSystemEventRecordId = 9;
        public static final int EvtSystemActivityID = 10;
        public static final int EvtSystemRelatedActivityID = 11;
        public static final int EvtSystemProcessID = 12;
        public static final int EvtSystemThreadID = 13;
        public static final int EvtSystemChannel = 14;
        public static final int EvtSystemComputer = 15;
        public static final int EvtSystemUserID = 16;
        public static final int EvtSystemVersion = 17;
        public static final int EvtSystemPropertyIdEND = 18;
    }

    public static interface EVT_SUBSCRIBE_NOTIFY_ACTION {
        public static final int EvtSubscribeActionError = 0;
        public static final int EvtSubscribeActionDeliver = 1;
    }

    public static interface EVT_SUBSCRIBE_FLAGS {
        public static final int EvtSubscribeToFutureEvents = 1;
        public static final int EvtSubscribeStartAtOldestRecord = 2;
        public static final int EvtSubscribeStartAfterBookmark = 3;
        public static final int EvtSubscribeOriginMask = 3;
        public static final int EvtSubscribeTolerateQueryErrors = 4096;
        public static final int EvtSubscribeStrict = 65536;
    }

    public static interface EVT_SEEK_FLAGS {
        public static final int EvtSeekRelativeToFirst = 1;
        public static final int EvtSeekRelativeToLast = 2;
        public static final int EvtSeekRelativeToCurrent = 3;
        public static final int EvtSeekRelativeToBookmark = 4;
        public static final int EvtSeekOriginMask = 7;
        public static final int EvtSeekStrict = 65536;
    }

    public static interface EVT_QUERY_FLAGS {
        public static final int EvtQueryChannelPath = 1;
        public static final int EvtQueryFilePath = 2;
        public static final int EvtQueryForwardDirection = 256;
        public static final int EvtQueryReverseDirection = 512;
        public static final int EvtQueryTolerateQueryErrors = 4096;
    }

    @Structure.FieldOrder(value={"Server", "User", "Domain", "Password", "Flags"})
    public static class EVT_RPC_LOGIN
    extends Structure {
        public String Server;
        public String User;
        public String Domain;
        public String Password;
        public int Flags;

        public EVT_RPC_LOGIN() {
            super(W32APITypeMapper.UNICODE);
        }

        public EVT_RPC_LOGIN(String string, String string2, String string3, String string4, int n2) {
            super(W32APITypeMapper.UNICODE);
            this.Server = string;
            this.User = string2;
            this.Domain = string3;
            this.Password = string4;
            this.Flags = n2;
        }

        public EVT_RPC_LOGIN(Pointer pointer) {
            super(pointer, 0, W32APITypeMapper.UNICODE);
        }

        public static class ByValue
        extends EVT_RPC_LOGIN
        implements Structure.ByValue {
        }

        public static class ByReference
        extends EVT_RPC_LOGIN
        implements Structure.ByReference {
        }
    }

    public static interface EVT_RPC_LOGIN_FLAGS {
        public static final int EvtRpcLoginAuthDefault = 0;
        public static final int EvtRpcLoginAuthNegotiate = 1;
        public static final int EvtRpcLoginAuthKerberos = 2;
        public static final int EvtRpcLoginAuthNTLM = 3;
    }

    @Structure.FieldOrder(value={"field1", "Count", "Type"})
    public static class EVT_VARIANT
    extends Structure {
        public field1_union field1;
        public int Count;
        public int Type;
        private Object holder;

        public EVT_VARIANT() {
            super(W32APITypeMapper.DEFAULT);
        }

        public EVT_VARIANT(Pointer pointer) {
            super(pointer, 0, W32APITypeMapper.DEFAULT);
        }

        public void use(Pointer pointer) {
            this.useMemory(pointer, 0);
        }

        private int getBaseType() {
            return this.Type & 0x7F;
        }

        public boolean isArray() {
            return (this.Type & 0x80) == 128;
        }

        public EVT_VARIANT_TYPE getVariantType() {
            return EVT_VARIANT_TYPE.values()[this.getBaseType()];
        }

        public void setValue(EVT_VARIANT_TYPE eVT_VARIANT_TYPE, Object object) {
            this.allocateMemory();
            if (eVT_VARIANT_TYPE == null) {
                throw new IllegalArgumentException("setValue must not be called with type set to NULL");
            }
            this.holder = null;
            if (object == null || eVT_VARIANT_TYPE == EVT_VARIANT_TYPE.EvtVarTypeNull) {
                this.Type = EVT_VARIANT_TYPE.EvtVarTypeNull.ordinal();
                this.Count = 0;
                this.field1.writeField("pointerValue", Pointer.NULL);
            } else {
                switch (eVT_VARIANT_TYPE) {
                    case EvtVarTypeAnsiString: {
                        if (object.getClass().isArray() && object.getClass().getComponentType() == String.class) {
                            this.Type = eVT_VARIANT_TYPE.ordinal() | 0x80;
                            StringArray stringArray = new StringArray((String[])object, false);
                            this.holder = stringArray;
                            this.Count = ((String[])object).length;
                            this.field1.writeField("pointerValue", stringArray);
                            break;
                        }
                        if (object.getClass() == String.class) {
                            this.Type = eVT_VARIANT_TYPE.ordinal();
                            Memory memory = new Memory(((String)object).length() + 1);
                            memory.setString(0L, (String)object);
                            this.holder = memory;
                            this.Count = 0;
                            this.field1.writeField("pointerValue", memory);
                            break;
                        }
                        throw new IllegalArgumentException(eVT_VARIANT_TYPE.name() + " must be set from String/String[]");
                    }
                    case EvtVarTypeBoolean: {
                        if (object.getClass().isArray() && object.getClass().getComponentType() == WinDef.BOOL.class) {
                            this.Type = eVT_VARIANT_TYPE.ordinal() | 0x80;
                            Memory memory = new Memory(((WinDef.BOOL[])object).length * 4);
                            for (int i2 = 0; i2 < ((WinDef.BOOL[])object).length; ++i2) {
                                memory.setInt(i2 * 4, ((WinDef.BOOL[])object)[i2].intValue());
                            }
                            this.holder = memory;
                            this.Count = 0;
                            this.field1.writeField("pointerValue", memory);
                            break;
                        }
                        if (object.getClass() == WinDef.BOOL.class) {
                            this.Type = eVT_VARIANT_TYPE.ordinal();
                            this.Count = 0;
                            this.field1.writeField("intValue", ((WinDef.BOOL)object).intValue());
                            break;
                        }
                        throw new IllegalArgumentException(eVT_VARIANT_TYPE.name() + " must be set from BOOL/BOOL[]");
                    }
                    case EvtVarTypeString: 
                    case EvtVarTypeEvtXml: {
                        if (object.getClass().isArray() && object.getClass().getComponentType() == String.class) {
                            this.Type = eVT_VARIANT_TYPE.ordinal() | 0x80;
                            StringArray stringArray = new StringArray((String[])object, true);
                            this.holder = stringArray;
                            this.Count = ((String[])object).length;
                            this.field1.writeField("pointerValue", stringArray);
                            break;
                        }
                        if (object.getClass() == String.class) {
                            this.Type = eVT_VARIANT_TYPE.ordinal();
                            Memory memory = new Memory((((String)object).length() + 1) * 2);
                            memory.setWideString(0L, (String)object);
                            this.holder = memory;
                            this.Count = 0;
                            this.field1.writeField("pointerValue", memory);
                            break;
                        }
                        throw new IllegalArgumentException(eVT_VARIANT_TYPE.name() + " must be set from String/String[]");
                    }
                    case EvtVarTypeSByte: 
                    case EvtVarTypeByte: {
                        if (object.getClass().isArray() && object.getClass().getComponentType() == Byte.TYPE) {
                            this.Type = eVT_VARIANT_TYPE.ordinal() | 0x80;
                            Memory memory = new Memory(((byte[])object).length * 1);
                            memory.write(0L, (byte[])object, 0, ((byte[])object).length);
                            this.holder = memory;
                            this.Count = 0;
                            this.field1.writeField("pointerValue", memory);
                            break;
                        }
                        if (object.getClass() == Byte.TYPE) {
                            this.Type = eVT_VARIANT_TYPE.ordinal();
                            this.Count = 0;
                            this.field1.writeField("byteValue", object);
                            break;
                        }
                        throw new IllegalArgumentException(eVT_VARIANT_TYPE.name() + " must be set from byte/byte[]");
                    }
                    case EvtVarTypeInt16: 
                    case EvtVarTypeUInt16: {
                        if (object.getClass().isArray() && object.getClass().getComponentType() == Short.TYPE) {
                            this.Type = eVT_VARIANT_TYPE.ordinal() | 0x80;
                            Memory memory = new Memory(((short[])object).length * 2);
                            memory.write(0L, (short[])object, 0, ((short[])object).length);
                            this.holder = memory;
                            this.Count = 0;
                            this.field1.writeField("pointerValue", memory);
                            break;
                        }
                        if (object.getClass() == Short.TYPE) {
                            this.Type = eVT_VARIANT_TYPE.ordinal();
                            this.Count = 0;
                            this.field1.writeField("shortValue", object);
                            break;
                        }
                        throw new IllegalArgumentException(eVT_VARIANT_TYPE.name() + " must be set from short/short[]");
                    }
                    case EvtVarTypeHexInt32: 
                    case EvtVarTypeInt32: 
                    case EvtVarTypeUInt32: {
                        if (object.getClass().isArray() && object.getClass().getComponentType() == Integer.TYPE) {
                            this.Type = eVT_VARIANT_TYPE.ordinal() | 0x80;
                            Memory memory = new Memory(((int[])object).length * 4);
                            memory.write(0L, (int[])object, 0, ((int[])object).length);
                            this.holder = memory;
                            this.Count = 0;
                            this.field1.writeField("pointerValue", memory);
                            break;
                        }
                        if (object.getClass() == Integer.TYPE) {
                            this.Type = eVT_VARIANT_TYPE.ordinal();
                            this.Count = 0;
                            this.field1.writeField("intValue", object);
                            break;
                        }
                        throw new IllegalArgumentException(eVT_VARIANT_TYPE.name() + " must be set from int/int[]");
                    }
                    case EvtVarTypeHexInt64: 
                    case EvtVarTypeInt64: 
                    case EvtVarTypeUInt64: {
                        if (object.getClass().isArray() && object.getClass().getComponentType() == Long.TYPE) {
                            this.Type = eVT_VARIANT_TYPE.ordinal() | 0x80;
                            Memory memory = new Memory(((long[])object).length * 4);
                            memory.write(0L, (long[])object, 0, ((long[])object).length);
                            this.holder = memory;
                            this.Count = 0;
                            this.field1.writeField("pointerValue", memory);
                            break;
                        }
                        if (object.getClass() == Long.TYPE) {
                            this.Type = eVT_VARIANT_TYPE.ordinal();
                            this.Count = 0;
                            this.field1.writeField("longValue", object);
                            break;
                        }
                        throw new IllegalArgumentException(eVT_VARIANT_TYPE.name() + " must be set from long/long[]");
                    }
                    case EvtVarTypeSingle: {
                        if (object.getClass().isArray() && object.getClass().getComponentType() == Float.TYPE) {
                            this.Type = eVT_VARIANT_TYPE.ordinal() | 0x80;
                            Memory memory = new Memory(((float[])object).length * 4);
                            memory.write(0L, (float[])object, 0, ((float[])object).length);
                            this.holder = memory;
                            this.Count = 0;
                            this.field1.writeField("pointerValue", memory);
                            break;
                        }
                        if (object.getClass() == Float.TYPE) {
                            this.Type = eVT_VARIANT_TYPE.ordinal();
                            this.Count = 0;
                            this.field1.writeField("floatValue", object);
                            break;
                        }
                        throw new IllegalArgumentException(eVT_VARIANT_TYPE.name() + " must be set from float/float[]");
                    }
                    case EvtVarTypeDouble: {
                        if (object.getClass().isArray() && object.getClass().getComponentType() == Double.TYPE) {
                            this.Type = eVT_VARIANT_TYPE.ordinal() | 0x80;
                            Memory memory = new Memory(((double[])object).length * 4);
                            memory.write(0L, (double[])object, 0, ((double[])object).length);
                            this.holder = memory;
                            this.Count = 0;
                            this.field1.writeField("pointerValue", memory);
                            break;
                        }
                        if (object.getClass() == Double.TYPE) {
                            this.Type = eVT_VARIANT_TYPE.ordinal();
                            this.Count = 0;
                            this.field1.writeField("doubleVal", object);
                            break;
                        }
                        throw new IllegalArgumentException(eVT_VARIANT_TYPE.name() + " must be set from double/double[]");
                    }
                    case EvtVarTypeBinary: {
                        if (object.getClass().isArray() && object.getClass().getComponentType() == Byte.TYPE) {
                            this.Type = eVT_VARIANT_TYPE.ordinal();
                            Memory memory = new Memory(((byte[])object).length * 1);
                            memory.write(0L, (byte[])object, 0, ((byte[])object).length);
                            this.holder = memory;
                            this.Count = 0;
                            this.field1.writeField("pointerValue", memory);
                            break;
                        }
                        throw new IllegalArgumentException(eVT_VARIANT_TYPE.name() + " must be set from byte[]");
                    }
                    default: {
                        throw new IllegalStateException(String.format("NOT IMPLEMENTED: getValue(%s) (Array: %b, Count: %d)", new Object[]{eVT_VARIANT_TYPE, this.isArray(), this.Count}));
                    }
                }
            }
            this.write();
        }

        public Object getValue() {
            EVT_VARIANT_TYPE eVT_VARIANT_TYPE = this.getVariantType();
            switch (eVT_VARIANT_TYPE) {
                case EvtVarTypeAnsiString: {
                    return this.isArray() ? this.field1.getPointer().getPointer(0L).getStringArray(0L, this.Count) : this.field1.getPointer().getPointer(0L).getString(0L);
                }
                case EvtVarTypeBoolean: {
                    if (this.isArray()) {
                        int[] nArray = this.field1.getPointer().getPointer(0L).getIntArray(0L, this.Count);
                        WinDef.BOOL[] bOOLArray = new WinDef.BOOL[nArray.length];
                        for (int i2 = 0; i2 < bOOLArray.length; ++i2) {
                            bOOLArray[i2] = new WinDef.BOOL((long)nArray[i2]);
                        }
                        return bOOLArray;
                    }
                    return new WinDef.BOOL((long)this.field1.getPointer().getInt(0L));
                }
                case EvtVarTypeString: 
                case EvtVarTypeEvtXml: {
                    return this.isArray() ? this.field1.getPointer().getPointer(0L).getWideStringArray(0L, this.Count) : this.field1.getPointer().getPointer(0L).getWideString(0L);
                }
                case EvtVarTypeFileTime: {
                    if (this.isArray()) {
                        WinBase.FILETIME fILETIME = Structure.newInstance(WinBase.FILETIME.class, this.field1.getPointer().getPointer(0L));
                        fILETIME.read();
                        return fILETIME.com_sun_jna_Structure_arr_toArray(this.Count);
                    }
                    WinBase.FILETIME fILETIME = new WinBase.FILETIME(this.field1.getPointer());
                    fILETIME.read();
                    return fILETIME;
                }
                case EvtVarTypeSysTime: {
                    if (this.isArray()) {
                        WinBase.SYSTEMTIME sYSTEMTIME = Structure.newInstance(WinBase.SYSTEMTIME.class, this.field1.getPointer().getPointer(0L));
                        sYSTEMTIME.read();
                        return sYSTEMTIME.com_sun_jna_Structure_arr_toArray(this.Count);
                    }
                    WinBase.SYSTEMTIME sYSTEMTIME = Structure.newInstance(WinBase.SYSTEMTIME.class, this.field1.getPointer().getPointer(0L));
                    sYSTEMTIME.read();
                    return sYSTEMTIME;
                }
                case EvtVarTypeSByte: 
                case EvtVarTypeByte: {
                    return this.isArray() ? (Object)this.field1.getPointer().getPointer(0L).getByteArray(0L, this.Count) : Byte.valueOf(this.field1.getPointer().getByte(0L));
                }
                case EvtVarTypeInt16: 
                case EvtVarTypeUInt16: {
                    return this.isArray() ? (Object)this.field1.getPointer().getPointer(0L).getShortArray(0L, this.Count) : Short.valueOf(this.field1.getPointer().getShort(0L));
                }
                case EvtVarTypeHexInt32: 
                case EvtVarTypeInt32: 
                case EvtVarTypeUInt32: {
                    return this.isArray() ? (Object)this.field1.getPointer().getPointer(0L).getIntArray(0L, this.Count) : Integer.valueOf(this.field1.getPointer().getInt(0L));
                }
                case EvtVarTypeHexInt64: 
                case EvtVarTypeInt64: 
                case EvtVarTypeUInt64: {
                    return this.isArray() ? (Object)this.field1.getPointer().getPointer(0L).getLongArray(0L, this.Count) : Long.valueOf(this.field1.getPointer().getLong(0L));
                }
                case EvtVarTypeSingle: {
                    return this.isArray() ? (Object)this.field1.getPointer().getPointer(0L).getFloatArray(0L, this.Count) : Float.valueOf(this.field1.getPointer().getFloat(0L));
                }
                case EvtVarTypeDouble: {
                    return this.isArray() ? (Object)this.field1.getPointer().getPointer(0L).getDoubleArray(0L, this.Count) : Double.valueOf(this.field1.getPointer().getDouble(0L));
                }
                case EvtVarTypeBinary: {
                    assert (!this.isArray());
                    return this.field1.getPointer().getPointer(0L).getByteArray(0L, this.Count);
                }
                case EvtVarTypeNull: {
                    return null;
                }
                case EvtVarTypeGuid: {
                    if (this.isArray()) {
                        Guid.GUID gUID = Structure.newInstance(Guid.GUID.class, this.field1.getPointer().getPointer(0L));
                        gUID.read();
                        return gUID.com_sun_jna_Structure_arr_toArray(this.Count);
                    }
                    Guid.GUID gUID = Structure.newInstance(Guid.GUID.class, this.field1.getPointer().getPointer(0L));
                    gUID.read();
                    return gUID;
                }
                case EvtVarTypeSid: {
                    if (this.isArray()) {
                        WinNT.PSID pSID = Structure.newInstance(WinNT.PSID.class, this.field1.getPointer().getPointer(0L));
                        pSID.read();
                        return pSID.com_sun_jna_Structure_arr_toArray(this.Count);
                    }
                    WinNT.PSID pSID = Structure.newInstance(WinNT.PSID.class, this.field1.getPointer().getPointer(0L));
                    pSID.read();
                    return pSID;
                }
                case EvtVarTypeSizeT: {
                    if (this.isArray()) {
                        long[] lArray = this.field1.getPointer().getPointer(0L).getLongArray(0L, this.Count);
                        BaseTSD.SIZE_T[] sIZE_TArray = new BaseTSD.SIZE_T[lArray.length];
                        for (int i3 = 0; i3 < sIZE_TArray.length; ++i3) {
                            sIZE_TArray[i3] = new BaseTSD.SIZE_T(lArray[i3]);
                        }
                        return sIZE_TArray;
                    }
                    return new BaseTSD.SIZE_T(this.field1.getPointer().getLong(0L));
                }
                case EvtVarTypeEvtHandle: {
                    if (this.isArray()) {
                        Pointer[] pointerArray = this.field1.getPointer().getPointer(0L).getPointerArray(0L, this.Count);
                        WinNT.HANDLE[] hANDLEArray = new WinNT.HANDLE[pointerArray.length];
                        for (int i4 = 0; i4 < hANDLEArray.length; ++i4) {
                            hANDLEArray[i4] = new WinNT.HANDLE(pointerArray[i4]);
                        }
                        return hANDLEArray;
                    }
                    return new WinNT.HANDLE(this.field1.getPointer().getPointer(0L));
                }
            }
            throw new IllegalStateException(String.format("NOT IMPLEMENTED: getValue(%s) (Array: %b, Count: %d)", new Object[]{eVT_VARIANT_TYPE, this.isArray(), this.Count}));
        }

        public static class ByValue
        extends EVT_VARIANT
        implements Structure.ByValue {
            public ByValue(Pointer pointer) {
                super(pointer);
            }

            public ByValue() {
            }
        }

        public static class ByReference
        extends EVT_VARIANT
        implements Structure.ByReference {
            public ByReference(Pointer pointer) {
                super(pointer);
            }

            public ByReference() {
            }
        }

        public static class field1_union
        extends Union {
            public byte byteValue;
            public short shortValue;
            public int intValue;
            public long longValue;
            public float floatValue;
            public double doubleVal;
            public Pointer pointerValue;
        }
    }

    public static interface EVT_LOGIN_CLASS {
        public static final int EvtRpcLogin = 1;
    }

    public static enum EVT_VARIANT_TYPE {
        EvtVarTypeNull(""),
        EvtVarTypeString("String"),
        EvtVarTypeAnsiString("AnsiString"),
        EvtVarTypeSByte("SByte"),
        EvtVarTypeByte("Byte"),
        EvtVarTypeInt16("Int16"),
        EvtVarTypeUInt16("UInt16"),
        EvtVarTypeInt32("Int32"),
        EvtVarTypeUInt32("UInt32"),
        EvtVarTypeInt64("Int64"),
        EvtVarTypeUInt64("UInt64"),
        EvtVarTypeSingle("Single"),
        EvtVarTypeDouble("Double"),
        EvtVarTypeBoolean("Boolean"),
        EvtVarTypeBinary("Binary"),
        EvtVarTypeGuid("Guid"),
        EvtVarTypeSizeT("SizeT"),
        EvtVarTypeFileTime("FileTime"),
        EvtVarTypeSysTime("SysTime"),
        EvtVarTypeSid("Sid"),
        EvtVarTypeHexInt32("Int32"),
        EvtVarTypeHexInt64("Int64"),
        EvtVarTypeEvtHandle("EvtHandle"),
        EvtVarTypeEvtXml("Xml");

        private final String field;

        private EVT_VARIANT_TYPE(String string2) {
            this.field = string2;
        }

        public String getField() {
            return this.field.isEmpty() ? "" : this.field + "Val";
        }

        public String getArrField() {
            return this.field.isEmpty() ? "" : this.field + "Arr";
        }
    }
}

