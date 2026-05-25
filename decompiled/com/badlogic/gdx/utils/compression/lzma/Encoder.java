/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils.compression.lzma;

import com.badlogic.gdx.utils.compression.ICodeProgress;
import com.badlogic.gdx.utils.compression.lz.BinTree;
import com.badlogic.gdx.utils.compression.lzma.Base;
import com.badlogic.gdx.utils.compression.rangecoder.BitTreeEncoder;
import java.io.InputStream;
import java.io.OutputStream;

public class Encoder {
    public static final int EMatchFinderTypeBT2 = 0;
    public static final int EMatchFinderTypeBT4 = 1;
    static final int kIfinityPrice = 0xFFFFFFF;
    static byte[] g_FastPos = new byte[2048];
    int _state = Base.StateInit();
    byte _previousByte;
    int[] _repDistances = new int[4];
    static final int kDefaultDictionaryLogSize = 22;
    static final int kNumFastBytesDefault = 32;
    public static final int kNumLenSpecSymbols = 16;
    static final int kNumOpts = 4096;
    Optimal[] _optimum = new Optimal[4096];
    BinTree _matchFinder = null;
    com.badlogic.gdx.utils.compression.rangecoder.Encoder _rangeEncoder = new com.badlogic.gdx.utils.compression.rangecoder.Encoder();
    short[] _isMatch = new short[192];
    short[] _isRep = new short[12];
    short[] _isRepG0 = new short[12];
    short[] _isRepG1 = new short[12];
    short[] _isRepG2 = new short[12];
    short[] _isRep0Long = new short[192];
    BitTreeEncoder[] _posSlotEncoder = new BitTreeEncoder[4];
    short[] _posEncoders = new short[114];
    BitTreeEncoder _posAlignEncoder = new BitTreeEncoder(4);
    LenPriceTableEncoder _lenEncoder = new LenPriceTableEncoder();
    LenPriceTableEncoder _repMatchLenEncoder = new LenPriceTableEncoder();
    LiteralEncoder _literalEncoder = new LiteralEncoder();
    int[] _matchDistances = new int[548];
    int _numFastBytes = 32;
    int _longestMatchLength;
    int _numDistancePairs;
    int _additionalOffset;
    int _optimumEndIndex;
    int _optimumCurrentIndex;
    boolean _longestMatchWasFound;
    int[] _posSlotPrices = new int[256];
    int[] _distancesPrices = new int[512];
    int[] _alignPrices = new int[16];
    int _alignPriceCount;
    int _distTableSize = 44;
    int _posStateBits = 2;
    int _posStateMask = 3;
    int _numLiteralPosStateBits = 0;
    int _numLiteralContextBits = 3;
    int _dictionarySize = 0x400000;
    int _dictionarySizePrev = -1;
    int _numFastBytesPrev = -1;
    long nowPos64;
    boolean _finished;
    InputStream _inStream;
    int _matchFinderType = 1;
    boolean _writeEndMark = false;
    boolean _needReleaseMFStream = false;
    int[] reps = new int[4];
    int[] repLens = new int[4];
    int backRes;
    long[] processedInSize = new long[1];
    long[] processedOutSize = new long[1];
    boolean[] finished = new boolean[1];
    public static final int kPropSize = 5;
    byte[] properties = new byte[5];
    int[] tempPrices = new int[128];
    int _matchPriceCount;

    static int GetPosSlot(int n2) {
        if (n2 < 2048) {
            return g_FastPos[n2];
        }
        if (n2 < 0x200000) {
            return g_FastPos[n2 >> 10] + 20;
        }
        return g_FastPos[n2 >> 20] + 40;
    }

    static int GetPosSlot2(int n2) {
        if (n2 < 131072) {
            return g_FastPos[n2 >> 6] + 12;
        }
        if (n2 < 0x8000000) {
            return g_FastPos[n2 >> 16] + 32;
        }
        return g_FastPos[n2 >> 26] + 52;
    }

    void BaseInit() {
        this._state = Base.StateInit();
        this._previousByte = 0;
        for (int i2 = 0; i2 < 4; ++i2) {
            this._repDistances[i2] = 0;
        }
    }

    void Create() {
        if (this._matchFinder == null) {
            BinTree binTree = new BinTree();
            int n2 = 4;
            if (this._matchFinderType == 0) {
                n2 = 2;
            }
            binTree.SetType(n2);
            this._matchFinder = binTree;
        }
        this._literalEncoder.Create(this._numLiteralPosStateBits, this._numLiteralContextBits);
        if (this._dictionarySize == this._dictionarySizePrev && this._numFastBytesPrev == this._numFastBytes) {
            return;
        }
        this._matchFinder.Create(this._dictionarySize, 4096, this._numFastBytes, 274);
        this._dictionarySizePrev = this._dictionarySize;
        this._numFastBytesPrev = this._numFastBytes;
    }

    public Encoder() {
        int n2;
        for (n2 = 0; n2 < 4096; ++n2) {
            this._optimum[n2] = new Optimal();
        }
        for (n2 = 0; n2 < 4; ++n2) {
            this._posSlotEncoder[n2] = new BitTreeEncoder(6);
        }
    }

    void SetWriteEndMarkerMode(boolean bl2) {
        this._writeEndMark = bl2;
    }

    void Init() {
        this.BaseInit();
        this._rangeEncoder.Init();
        com.badlogic.gdx.utils.compression.rangecoder.Encoder.InitBitModels(this._isMatch);
        com.badlogic.gdx.utils.compression.rangecoder.Encoder.InitBitModels(this._isRep0Long);
        com.badlogic.gdx.utils.compression.rangecoder.Encoder.InitBitModels(this._isRep);
        com.badlogic.gdx.utils.compression.rangecoder.Encoder.InitBitModels(this._isRepG0);
        com.badlogic.gdx.utils.compression.rangecoder.Encoder.InitBitModels(this._isRepG1);
        com.badlogic.gdx.utils.compression.rangecoder.Encoder.InitBitModels(this._isRepG2);
        com.badlogic.gdx.utils.compression.rangecoder.Encoder.InitBitModels(this._posEncoders);
        this._literalEncoder.Init();
        for (int i2 = 0; i2 < 4; ++i2) {
            this._posSlotEncoder[i2].Init();
        }
        this._lenEncoder.Init(1 << this._posStateBits);
        this._repMatchLenEncoder.Init(1 << this._posStateBits);
        this._posAlignEncoder.Init();
        this._longestMatchWasFound = false;
        this._optimumEndIndex = 0;
        this._optimumCurrentIndex = 0;
        this._additionalOffset = 0;
    }

    int ReadMatchDistances() {
        int n2 = 0;
        this._numDistancePairs = this._matchFinder.GetMatches(this._matchDistances);
        if (this._numDistancePairs > 0 && (n2 = this._matchDistances[this._numDistancePairs - 2]) == this._numFastBytes) {
            n2 += this._matchFinder.GetMatchLen(n2 - 1, this._matchDistances[this._numDistancePairs - 1], 273 - n2);
        }
        ++this._additionalOffset;
        return n2;
    }

    void MovePos(int n2) {
        if (n2 > 0) {
            this._matchFinder.Skip(n2);
            this._additionalOffset += n2;
        }
    }

    int GetRepLen1Price(int n2, int n3) {
        return com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice0(this._isRepG0[n2]) + com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice0(this._isRep0Long[(n2 << 4) + n3]);
    }

    int GetPureRepPrice(int n2, int n3, int n4) {
        int n5;
        if (n2 == 0) {
            n5 = com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice0(this._isRepG0[n3]);
            n5 += com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice1(this._isRep0Long[(n3 << 4) + n4]);
        } else {
            n5 = com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice1(this._isRepG0[n3]);
            if (n2 == 1) {
                n5 += com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice0(this._isRepG1[n3]);
            } else {
                n5 += com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice1(this._isRepG1[n3]);
                n5 += com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice(this._isRepG2[n3], n2 - 2);
            }
        }
        return n5;
    }

    int GetRepPrice(int n2, int n3, int n4, int n5) {
        int n6 = this._repMatchLenEncoder.GetPrice(n3 - 2, n5);
        return n6 + this.GetPureRepPrice(n2, n4, n5);
    }

    int GetPosLenPrice(int n2, int n3, int n4) {
        int n5 = Base.GetLenToPosState(n3);
        int n6 = n2 < 128 ? this._distancesPrices[n5 * 128 + n2] : this._posSlotPrices[(n5 << 6) + Encoder.GetPosSlot2(n2)] + this._alignPrices[n2 & 0xF];
        return n6 + this._lenEncoder.GetPrice(n3 - 2, n4);
    }

    int Backward(int n2) {
        int n3;
        this._optimumEndIndex = n2;
        int n4 = this._optimum[n2].PosPrev;
        int n5 = this._optimum[n2].BackPrev;
        do {
            if (this._optimum[n2].Prev1IsChar) {
                this._optimum[n4].MakeAsChar();
                this._optimum[n4].PosPrev = n4 - 1;
                if (this._optimum[n2].Prev2) {
                    this._optimum[n4 - 1].Prev1IsChar = false;
                    this._optimum[n4 - 1].PosPrev = this._optimum[n2].PosPrev2;
                    this._optimum[n4 - 1].BackPrev = this._optimum[n2].BackPrev2;
                }
            }
            n3 = n4;
            int n6 = n5;
            n5 = this._optimum[n3].BackPrev;
            n4 = this._optimum[n3].PosPrev;
            this._optimum[n3].BackPrev = n6;
            this._optimum[n3].PosPrev = n2;
        } while ((n2 = n3) > 0);
        this.backRes = this._optimum[0].BackPrev;
        this._optimumCurrentIndex = this._optimum[0].PosPrev;
        return this._optimumCurrentIndex;
    }

    /*
     * Unable to fully structure code
     */
    int GetOptimum(int var1_1) {
        if (this._optimumEndIndex != this._optimumCurrentIndex) {
            var2_2 = this._optimum[this._optimumCurrentIndex].PosPrev - this._optimumCurrentIndex;
            this.backRes = this._optimum[this._optimumCurrentIndex].BackPrev;
            this._optimumCurrentIndex = this._optimum[this._optimumCurrentIndex].PosPrev;
            return var2_2;
        }
        this._optimumEndIndex = 0;
        this._optimumCurrentIndex = 0;
        if (!this._longestMatchWasFound) {
            var2_3 = this.ReadMatchDistances();
        } else {
            var2_3 = this._longestMatchLength;
            this._longestMatchWasFound = false;
        }
        var3_4 = this._numDistancePairs;
        var4_5 = this._matchFinder.GetNumAvailableBytes() + 1;
        if (var4_5 < 2) {
            this.backRes = -1;
            return 1;
        }
        if (var4_5 > 273) {
            var4_5 = 273;
        }
        var5_6 = 0;
        for (var6_7 = 0; var6_7 < 4; ++var6_7) {
            this.reps[var6_7] = this._repDistances[var6_7];
            this.repLens[var6_7] = this._matchFinder.GetMatchLen(-1, this.reps[var6_7], 273);
            if (this.repLens[var6_7] <= this.repLens[var5_6]) continue;
            var5_6 = var6_7;
        }
        if (this.repLens[var5_6] >= this._numFastBytes) {
            this.backRes = var5_6;
            var7_8 = this.repLens[var5_6];
            this.MovePos(var7_8 - 1);
            return var7_8;
        }
        if (var2_3 >= this._numFastBytes) {
            this.backRes = this._matchDistances[var3_4 - 1] + 4;
            this.MovePos(var2_3 - 1);
            return var2_3;
        }
        var7_9 = this._matchFinder.GetIndexByte(-1);
        var8_10 = this._matchFinder.GetIndexByte(0 - this._repDistances[0] - 1 - 1);
        if (var2_3 < 2 && var7_9 != var8_10 && this.repLens[var5_6] < 2) {
            this.backRes = -1;
            return 1;
        }
        this._optimum[0].State = this._state;
        var9_11 = var1_1 & this._posStateMask;
        this._optimum[1].Price = com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice0(this._isMatch[(this._state << 4) + var9_11]) + this._literalEncoder.GetSubCoder(var1_1, this._previousByte).GetPrice(Base.StateIsCharState(this._state) == false, var8_10, var7_9);
        this._optimum[1].MakeAsChar();
        var10_12 = com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice1(this._isMatch[(this._state << 4) + var9_11]);
        var11_13 = var10_12 + com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice1(this._isRep[this._state]);
        if (var8_10 == var7_9 && (var12_14 = var11_13 + this.GetRepLen1Price(this._state, var9_11)) < this._optimum[1].Price) {
            this._optimum[1].Price = var12_14;
            this._optimum[1].MakeAsShortRep();
        }
        v0 = var12_14 = var2_3 >= this.repLens[var5_6] ? var2_3 : this.repLens[var5_6];
        if (var12_14 < 2) {
            this.backRes = this._optimum[1].BackPrev;
            return 1;
        }
        this._optimum[1].PosPrev = 0;
        this._optimum[0].Backs0 = this.reps[0];
        this._optimum[0].Backs1 = this.reps[1];
        this._optimum[0].Backs2 = this.reps[2];
        this._optimum[0].Backs3 = this.reps[3];
        var13_15 = var12_14;
        do {
            this._optimum[var13_15--].Price = 0xFFFFFFF;
        } while (var13_15 >= 2);
        for (var6_7 = 0; var6_7 < 4; ++var6_7) {
            var14_16 = this.repLens[var6_7];
            if (var14_16 < 2) continue;
            var15_17 = var11_13 + this.GetPureRepPrice(var6_7, this._state, var9_11);
            do {
                var16_18 = var15_17 + this._repMatchLenEncoder.GetPrice(var14_16 - 2, var9_11);
                var17_19 = this._optimum[var14_16];
                if (var16_18 >= var17_19.Price) continue;
                var17_19.Price = var16_18;
                var17_19.PosPrev = 0;
                var17_19.BackPrev = var6_7;
                var17_19.Prev1IsChar = false;
            } while (--var14_16 >= 2);
        }
        var14_16 = var10_12 + com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice0(this._isRep[this._state]);
        v1 = var13_15 = this.repLens[0] >= 2 ? this.repLens[0] + 1 : 2;
        if (var13_15 <= var2_3) {
            var15_17 = 0;
            while (var13_15 > this._matchDistances[var15_17]) {
                var15_17 += 2;
            }
            while (true) {
                var16_18 = this._matchDistances[var15_17 + 1];
                var17_20 = var14_16 + this.GetPosLenPrice(var16_18, var13_15, var9_11);
                var18_22 = this._optimum[var13_15];
                if (var17_20 < var18_22.Price) {
                    var18_22.Price = var17_20;
                    var18_22.PosPrev = 0;
                    var18_22.BackPrev = var16_18 + 4;
                    var18_22.Prev1IsChar = false;
                }
                if (var13_15 == this._matchDistances[var15_17] && (var15_17 += 2) == var3_4) break;
                ++var13_15;
            }
        }
        var15_17 = 0;
        block6: while (true) {
            if (++var15_17 == var12_14) {
                return this.Backward(var15_17);
            }
            var16_18 = this.ReadMatchDistances();
            var3_4 = this._numDistancePairs;
            if (var16_18 >= this._numFastBytes) {
                this._longestMatchLength = var16_18;
                this._longestMatchWasFound = true;
                return this.Backward(var15_17);
            }
            ++var1_1;
            var17_21 = this._optimum[var15_17].PosPrev;
            if (this._optimum[var15_17].Prev1IsChar) {
                --var17_21;
                if (this._optimum[var15_17].Prev2) {
                    var18_23 = this._optimum[this._optimum[var15_17].PosPrev2].State;
                    var18_23 = this._optimum[var15_17].BackPrev2 < 4 ? Base.StateUpdateRep(var18_23) : Base.StateUpdateMatch(var18_23);
                } else {
                    var18_23 = this._optimum[var17_21].State;
                }
                var18_23 = Base.StateUpdateChar(var18_23);
            } else {
                var18_23 = this._optimum[var17_21].State;
            }
            if (var17_21 == var15_17 - 1) {
                var18_23 = this._optimum[var15_17].IsShortRep() ? Base.StateUpdateShortRep(var18_23) : Base.StateUpdateChar(var18_23);
            } else {
                if (this._optimum[var15_17].Prev1IsChar && this._optimum[var15_17].Prev2) {
                    var17_21 = this._optimum[var15_17].PosPrev2;
                    var19_24 = this._optimum[var15_17].BackPrev2;
                    var18_23 = Base.StateUpdateRep(var18_23);
                } else {
                    var19_24 = this._optimum[var15_17].BackPrev;
                    var18_23 = var19_24 < 4 ? Base.StateUpdateRep(var18_23) : Base.StateUpdateMatch(var18_23);
                }
                var20_26 = this._optimum[var17_21];
                if (var19_24 < 4) {
                    if (var19_24 == 0) {
                        this.reps[0] = var20_26.Backs0;
                        this.reps[1] = var20_26.Backs1;
                        this.reps[2] = var20_26.Backs2;
                        this.reps[3] = var20_26.Backs3;
                    } else if (var19_24 == 1) {
                        this.reps[0] = var20_26.Backs1;
                        this.reps[1] = var20_26.Backs0;
                        this.reps[2] = var20_26.Backs2;
                        this.reps[3] = var20_26.Backs3;
                    } else if (var19_24 == 2) {
                        this.reps[0] = var20_26.Backs2;
                        this.reps[1] = var20_26.Backs0;
                        this.reps[2] = var20_26.Backs1;
                        this.reps[3] = var20_26.Backs3;
                    } else {
                        this.reps[0] = var20_26.Backs3;
                        this.reps[1] = var20_26.Backs0;
                        this.reps[2] = var20_26.Backs1;
                        this.reps[3] = var20_26.Backs2;
                    }
                } else {
                    this.reps[0] = var19_24 - 4;
                    this.reps[1] = var20_26.Backs0;
                    this.reps[2] = var20_26.Backs1;
                    this.reps[3] = var20_26.Backs2;
                }
            }
            this._optimum[var15_17].State = var18_23;
            this._optimum[var15_17].Backs0 = this.reps[0];
            this._optimum[var15_17].Backs1 = this.reps[1];
            this._optimum[var15_17].Backs2 = this.reps[2];
            this._optimum[var15_17].Backs3 = this.reps[3];
            var19_24 = this._optimum[var15_17].Price;
            var7_9 = this._matchFinder.GetIndexByte(-1);
            var8_10 = this._matchFinder.GetIndexByte(0 - this.reps[0] - 1 - 1);
            var9_11 = var1_1 & this._posStateMask;
            var20_25 = var19_24 + com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice0(this._isMatch[(var18_23 << 4) + var9_11]) + this._literalEncoder.GetSubCoder(var1_1, this._matchFinder.GetIndexByte(-2)).GetPrice(Base.StateIsCharState(var18_23) == false, var8_10, var7_9);
            var21_27 = this._optimum[var15_17 + 1];
            var22_28 = false;
            if (var20_25 < var21_27.Price) {
                var21_27.Price = var20_25;
                var21_27.PosPrev = var15_17;
                var21_27.MakeAsChar();
                var22_28 = true;
            }
            var10_12 = var19_24 + com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice1(this._isMatch[(var18_23 << 4) + var9_11]);
            var11_13 = var10_12 + com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice1(this._isRep[var18_23]);
            if (var8_10 == var7_9 && (var21_27.PosPrev >= var15_17 || var21_27.BackPrev != 0) && (var23_29 = var11_13 + this.GetRepLen1Price(var18_23, var9_11)) <= var21_27.Price) {
                var21_27.Price = var23_29;
                var21_27.PosPrev = var15_17;
                var21_27.MakeAsShortRep();
                var22_28 = true;
            }
            var23_29 = this._matchFinder.GetNumAvailableBytes() + 1;
            var4_5 = var23_29 = Math.min(4095 - var15_17, var23_29);
            if (var4_5 < 2) continue;
            if (var4_5 > this._numFastBytes) {
                var4_5 = this._numFastBytes;
            }
            if (!var22_28 && var8_10 != var7_9 && (var25_31 = this._matchFinder.GetMatchLen(0, this.reps[0], var24_30 = Math.min(var23_29 - 1, this._numFastBytes))) >= 2) {
                var26_32 = Base.StateUpdateChar(var18_23);
                var27_33 = var1_1 + 1 & this._posStateMask;
                var28_34 = var20_25 + com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice1(this._isMatch[(var26_32 << 4) + var27_33]) + com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice1(this._isRep[var26_32]);
                var29_35 = var15_17 + 1 + var25_31;
                while (var12_14 < var29_35) {
                    this._optimum[++var12_14].Price = 0xFFFFFFF;
                }
                var30_39 = var28_34 + this.GetRepPrice(0, var25_31, var26_32, var27_33);
                var31_40 = this._optimum[var29_35];
                if (var30_39 < var31_40.Price) {
                    var31_40.Price = var30_39;
                    var31_40.PosPrev = var15_17 + 1;
                    var31_40.BackPrev = 0;
                    var31_40.Prev1IsChar = true;
                    var31_40.Prev2 = false;
                }
            }
            var24_30 = 2;
            for (var25_31 = 0; var25_31 < 4; ++var25_31) {
                var26_32 = this._matchFinder.GetMatchLen(-1, this.reps[var25_31], var4_5);
                if (var26_32 < 2) continue;
                var27_33 = var26_32;
                while (true) {
                    if (var12_14 < var15_17 + var26_32) {
                        this._optimum[++var12_14].Price = 0xFFFFFFF;
                        continue;
                    }
                    var28_34 = var11_13 + this.GetRepPrice(var25_31, var26_32, var18_23, var9_11);
                    var29_36 = this._optimum[var15_17 + var26_32];
                    if (var28_34 < var29_36.Price) {
                        var29_36.Price = var28_34;
                        var29_36.PosPrev = var15_17;
                        var29_36.BackPrev = var25_31;
                        var29_36.Prev1IsChar = false;
                    }
                    if (--var26_32 < 2) break;
                }
                var26_32 = var27_33;
                if (var25_31 == 0) {
                    var24_30 = var26_32 + 1;
                }
                if (var26_32 >= var23_29 || (var29_37 = this._matchFinder.GetMatchLen(var26_32, this.reps[var25_31], var28_34 = Math.min(var23_29 - 1 - var26_32, this._numFastBytes))) < 2) continue;
                var30_39 = Base.StateUpdateRep(var18_23);
                var31_41 = var1_1 + var26_32 & this._posStateMask;
                var32_43 = var11_13 + this.GetRepPrice(var25_31, var26_32, var18_23, var9_11) + com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice0(this._isMatch[(var30_39 << 4) + var31_41]) + this._literalEncoder.GetSubCoder(var1_1 + var26_32, this._matchFinder.GetIndexByte(var26_32 - 1 - 1)).GetPrice(true, this._matchFinder.GetIndexByte(var26_32 - 1 - (this.reps[var25_31] + 1)), this._matchFinder.GetIndexByte(var26_32 - 1));
                var30_39 = Base.StateUpdateChar(var30_39);
                var31_41 = var1_1 + var26_32 + 1 & this._posStateMask;
                var33_44 = var32_43 + com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice1(this._isMatch[(var30_39 << 4) + var31_41]);
                var34_45 = var33_44 + com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice1(this._isRep[var30_39]);
                var35_46 = var26_32 + 1 + var29_37;
                while (var12_14 < var15_17 + var35_46) {
                    this._optimum[++var12_14].Price = 0xFFFFFFF;
                }
                var36_47 = var34_45 + this.GetRepPrice(0, var29_37, var30_39, var31_41);
                var37_48 = this._optimum[var15_17 + var35_46];
                if (var36_47 >= var37_48.Price) continue;
                var37_48.Price = var36_47;
                var37_48.PosPrev = var15_17 + var26_32 + 1;
                var37_48.BackPrev = 0;
                var37_48.Prev1IsChar = true;
                var37_48.Prev2 = true;
                var37_48.PosPrev2 = var15_17;
                var37_48.BackPrev2 = var25_31;
            }
            if (var16_18 > var4_5) {
                var16_18 = var4_5;
                var3_4 = 0;
                while (var16_18 > this._matchDistances[var3_4]) {
                    var3_4 += 2;
                }
                this._matchDistances[var3_4] = var16_18;
                var3_4 += 2;
            }
            if (var16_18 < var24_30) continue;
            var14_16 = var10_12 + com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice0(this._isRep[var18_23]);
            while (var12_14 < var15_17 + var16_18) {
                this._optimum[++var12_14].Price = 0xFFFFFFF;
            }
            var25_31 = 0;
            while (var24_30 > this._matchDistances[var25_31]) {
                var25_31 += 2;
            }
            var26_32 = var24_30;
            while (true) {
                var27_33 = this._matchDistances[var25_31 + 1];
                var28_34 = var14_16 + this.GetPosLenPrice(var27_33, var26_32, var9_11);
                var29_38 = this._optimum[var15_17 + var26_32];
                if (var28_34 < var29_38.Price) {
                    var29_38.Price = var28_34;
                    var29_38.PosPrev = var15_17;
                    var29_38.BackPrev = var27_33 + 4;
                    var29_38.Prev1IsChar = false;
                }
                if (var26_32 == this._matchDistances[var25_31]) {
                    if (var26_32 < var23_29 && (var31_42 = this._matchFinder.GetMatchLen(var26_32, var27_33, var30_39 = Math.min(var23_29 - 1 - var26_32, this._numFastBytes))) >= 2) {
                        var32_43 = Base.StateUpdateMatch(var18_23);
                        var33_44 = var1_1 + var26_32 & this._posStateMask;
                        var34_45 = var28_34 + com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice0(this._isMatch[(var32_43 << 4) + var33_44]) + this._literalEncoder.GetSubCoder(var1_1 + var26_32, this._matchFinder.GetIndexByte(var26_32 - 1 - 1)).GetPrice(true, this._matchFinder.GetIndexByte(var26_32 - (var27_33 + 1) - 1), this._matchFinder.GetIndexByte(var26_32 - 1));
                        var32_43 = Base.StateUpdateChar(var32_43);
                        var33_44 = var1_1 + var26_32 + 1 & this._posStateMask;
                        var35_46 = var34_45 + com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice1(this._isMatch[(var32_43 << 4) + var33_44]);
                        var36_47 = var35_46 + com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice1(this._isRep[var32_43]);
                        var37_49 = var26_32 + 1 + var31_42;
                        while (var12_14 < var15_17 + var37_49) {
                            this._optimum[++var12_14].Price = 0xFFFFFFF;
                        }
                        var28_34 = var36_47 + this.GetRepPrice(0, var31_42, var32_43, var33_44);
                        var29_38 = this._optimum[var15_17 + var37_49];
                        if (var28_34 < var29_38.Price) {
                            var29_38.Price = var28_34;
                            var29_38.PosPrev = var15_17 + var26_32 + 1;
                            var29_38.BackPrev = 0;
                            var29_38.Prev1IsChar = true;
                            var29_38.Prev2 = true;
                            var29_38.PosPrev2 = var15_17;
                            var29_38.BackPrev2 = var27_33 + 4;
                        }
                    }
                    if ((var25_31 += 2) != var3_4) ** break;
                    continue block6;
                }
                ++var26_32;
            }
            break;
        }
    }

    boolean ChangePair(int n2, int n3) {
        int n4 = 7;
        return n2 < 1 << 32 - n4 && n3 >= n2 << n4;
    }

    void WriteEndMarker(int n2) {
        if (!this._writeEndMark) {
            return;
        }
        this._rangeEncoder.Encode(this._isMatch, (this._state << 4) + n2, 1);
        this._rangeEncoder.Encode(this._isRep, this._state, 0);
        this._state = Base.StateUpdateMatch(this._state);
        int n3 = 2;
        this._lenEncoder.Encode(this._rangeEncoder, n3 - 2, n2);
        int n4 = 63;
        int n5 = Base.GetLenToPosState(n3);
        this._posSlotEncoder[n5].Encode(this._rangeEncoder, n4);
        int n6 = 30;
        int n7 = (1 << n6) - 1;
        this._rangeEncoder.EncodeDirectBits(n7 >> 4, n6 - 4);
        this._posAlignEncoder.ReverseEncode(this._rangeEncoder, n7 & 0xF);
    }

    void Flush(int n2) {
        this.ReleaseMFStream();
        this.WriteEndMarker(n2 & this._posStateMask);
        this._rangeEncoder.FlushData();
        this._rangeEncoder.FlushStream();
    }

    public void CodeOneBlock(long[] lArray, long[] lArray2, boolean[] blArray) {
        int n2;
        int n3;
        lArray[0] = 0L;
        lArray2[0] = 0L;
        blArray[0] = true;
        if (this._inStream != null) {
            this._matchFinder.SetStream(this._inStream);
            this._matchFinder.Init();
            this._needReleaseMFStream = true;
            this._inStream = null;
        }
        if (this._finished) {
            return;
        }
        this._finished = true;
        long l2 = this.nowPos64;
        if (this.nowPos64 == 0L) {
            if (this._matchFinder.GetNumAvailableBytes() == 0) {
                this.Flush((int)this.nowPos64);
                return;
            }
            this.ReadMatchDistances();
            n3 = (int)this.nowPos64 & this._posStateMask;
            this._rangeEncoder.Encode(this._isMatch, (this._state << 4) + n3, 0);
            this._state = Base.StateUpdateChar(this._state);
            n2 = this._matchFinder.GetIndexByte(0 - this._additionalOffset);
            this._literalEncoder.GetSubCoder((int)this.nowPos64, this._previousByte).Encode(this._rangeEncoder, (byte)n2);
            this._previousByte = n2;
            --this._additionalOffset;
            ++this.nowPos64;
        }
        if (this._matchFinder.GetNumAvailableBytes() == 0) {
            this.Flush((int)this.nowPos64);
            return;
        }
        while (true) {
            int n4;
            int n5;
            n3 = this.GetOptimum((int)this.nowPos64);
            n2 = this.backRes;
            int n6 = (int)this.nowPos64 & this._posStateMask;
            int n7 = (this._state << 4) + n6;
            if (n3 == 1 && n2 == -1) {
                this._rangeEncoder.Encode(this._isMatch, n7, 0);
                n5 = this._matchFinder.GetIndexByte(0 - this._additionalOffset);
                LiteralEncoder.Encoder2 encoder2 = this._literalEncoder.GetSubCoder((int)this.nowPos64, this._previousByte);
                if (!Base.StateIsCharState(this._state)) {
                    n4 = this._matchFinder.GetIndexByte(0 - this._repDistances[0] - 1 - this._additionalOffset);
                    encoder2.EncodeMatched(this._rangeEncoder, (byte)n4, (byte)n5);
                } else {
                    encoder2.Encode(this._rangeEncoder, (byte)n5);
                }
                this._previousByte = (byte)n5;
                this._state = Base.StateUpdateChar(this._state);
            } else {
                this._rangeEncoder.Encode(this._isMatch, n7, 1);
                if (n2 < 4) {
                    this._rangeEncoder.Encode(this._isRep, this._state, 1);
                    if (n2 == 0) {
                        this._rangeEncoder.Encode(this._isRepG0, this._state, 0);
                        if (n3 == 1) {
                            this._rangeEncoder.Encode(this._isRep0Long, n7, 0);
                        } else {
                            this._rangeEncoder.Encode(this._isRep0Long, n7, 1);
                        }
                    } else {
                        this._rangeEncoder.Encode(this._isRepG0, this._state, 1);
                        if (n2 == 1) {
                            this._rangeEncoder.Encode(this._isRepG1, this._state, 0);
                        } else {
                            this._rangeEncoder.Encode(this._isRepG1, this._state, 1);
                            this._rangeEncoder.Encode(this._isRepG2, this._state, n2 - 2);
                        }
                    }
                    if (n3 == 1) {
                        this._state = Base.StateUpdateShortRep(this._state);
                    } else {
                        this._repMatchLenEncoder.Encode(this._rangeEncoder, n3 - 2, n6);
                        this._state = Base.StateUpdateRep(this._state);
                    }
                    n5 = this._repDistances[n2];
                    if (n2 != 0) {
                        for (int i2 = n2; i2 >= 1; --i2) {
                            this._repDistances[i2] = this._repDistances[i2 - 1];
                        }
                        this._repDistances[0] = n5;
                    }
                } else {
                    int n8;
                    this._rangeEncoder.Encode(this._isRep, this._state, 0);
                    this._state = Base.StateUpdateMatch(this._state);
                    this._lenEncoder.Encode(this._rangeEncoder, n3 - 2, n6);
                    n5 = Encoder.GetPosSlot(n2 -= 4);
                    int n9 = Base.GetLenToPosState(n3);
                    this._posSlotEncoder[n9].Encode(this._rangeEncoder, n5);
                    if (n5 >= 4) {
                        n4 = (n5 >> 1) - 1;
                        n8 = (2 | n5 & 1) << n4;
                        int n10 = n2 - n8;
                        if (n5 < 14) {
                            BitTreeEncoder.ReverseEncode(this._posEncoders, n8 - n5 - 1, this._rangeEncoder, n4, n10);
                        } else {
                            this._rangeEncoder.EncodeDirectBits(n10 >> 4, n4 - 4);
                            this._posAlignEncoder.ReverseEncode(this._rangeEncoder, n10 & 0xF);
                            ++this._alignPriceCount;
                        }
                    }
                    n4 = n2;
                    for (n8 = 3; n8 >= 1; --n8) {
                        this._repDistances[n8] = this._repDistances[n8 - 1];
                    }
                    this._repDistances[0] = n4;
                    ++this._matchPriceCount;
                }
                this._previousByte = this._matchFinder.GetIndexByte(n3 - 1 - this._additionalOffset);
            }
            this._additionalOffset -= n3;
            this.nowPos64 += (long)n3;
            if (this._additionalOffset != 0) continue;
            if (this._matchPriceCount >= 128) {
                this.FillDistancesPrices();
            }
            if (this._alignPriceCount >= 16) {
                this.FillAlignPrices();
            }
            lArray[0] = this.nowPos64;
            lArray2[0] = this._rangeEncoder.GetProcessedSizeAdd();
            if (this._matchFinder.GetNumAvailableBytes() == 0) {
                this.Flush((int)this.nowPos64);
                return;
            }
            if (this.nowPos64 - l2 >= 4096L) break;
        }
        this._finished = false;
        blArray[0] = false;
    }

    void ReleaseMFStream() {
        if (this._matchFinder != null && this._needReleaseMFStream) {
            this._matchFinder.ReleaseStream();
            this._needReleaseMFStream = false;
        }
    }

    void SetOutStream(OutputStream outputStream) {
        this._rangeEncoder.SetStream(outputStream);
    }

    void ReleaseOutStream() {
        this._rangeEncoder.ReleaseStream();
    }

    void ReleaseStreams() {
        this.ReleaseMFStream();
        this.ReleaseOutStream();
    }

    void SetStreams(InputStream inputStream, OutputStream outputStream, long l2, long l3) {
        this._inStream = inputStream;
        this._finished = false;
        this.Create();
        this.SetOutStream(outputStream);
        this.Init();
        this.FillDistancesPrices();
        this.FillAlignPrices();
        this._lenEncoder.SetTableSize(this._numFastBytes + 1 - 2);
        this._lenEncoder.UpdateTables(1 << this._posStateBits);
        this._repMatchLenEncoder.SetTableSize(this._numFastBytes + 1 - 2);
        this._repMatchLenEncoder.UpdateTables(1 << this._posStateBits);
        this.nowPos64 = 0L;
    }

    public void Code(InputStream inputStream, OutputStream outputStream, long l2, long l3, ICodeProgress iCodeProgress) {
        this._needReleaseMFStream = false;
        try {
            this.SetStreams(inputStream, outputStream, l2, l3);
            while (true) {
                this.CodeOneBlock(this.processedInSize, this.processedOutSize, this.finished);
                if (this.finished[0]) {
                    return;
                }
                if (iCodeProgress == null) continue;
                iCodeProgress.SetProgress(this.processedInSize[0], this.processedOutSize[0]);
            }
        }
        finally {
            this.ReleaseStreams();
        }
    }

    public void WriteCoderProperties(OutputStream outputStream) {
        this.properties[0] = (byte)((this._posStateBits * 5 + this._numLiteralPosStateBits) * 9 + this._numLiteralContextBits);
        for (int i2 = 0; i2 < 4; ++i2) {
            this.properties[1 + i2] = (byte)(this._dictionarySize >> 8 * i2);
        }
        outputStream.write(this.properties, 0, 5);
    }

    void FillDistancesPrices() {
        int n2;
        int n3;
        int n4;
        for (n4 = 4; n4 < 128; ++n4) {
            n3 = Encoder.GetPosSlot(n4);
            int n5 = (n3 >> 1) - 1;
            n2 = (2 | n3 & 1) << n5;
            this.tempPrices[n4] = BitTreeEncoder.ReverseGetPrice(this._posEncoders, n2 - n3 - 1, n5, n4 - n2);
        }
        for (n4 = 0; n4 < 4; ++n4) {
            int n6;
            BitTreeEncoder bitTreeEncoder = this._posSlotEncoder[n4];
            n2 = n4 << 6;
            for (n3 = 0; n3 < this._distTableSize; ++n3) {
                this._posSlotPrices[n2 + n3] = bitTreeEncoder.GetPrice(n3);
            }
            for (n3 = 14; n3 < this._distTableSize; ++n3) {
                int n7 = n2 + n3;
                this._posSlotPrices[n7] = this._posSlotPrices[n7] + ((n3 >> 1) - 1 - 4 << 6);
            }
            int n8 = n4 * 128;
            for (n6 = 0; n6 < 4; ++n6) {
                this._distancesPrices[n8 + n6] = this._posSlotPrices[n2 + n6];
            }
            while (n6 < 128) {
                this._distancesPrices[n8 + n6] = this._posSlotPrices[n2 + Encoder.GetPosSlot(n6)] + this.tempPrices[n6];
                ++n6;
            }
        }
        this._matchPriceCount = 0;
    }

    void FillAlignPrices() {
        for (int i2 = 0; i2 < 16; ++i2) {
            this._alignPrices[i2] = this._posAlignEncoder.ReverseGetPrice(i2);
        }
        this._alignPriceCount = 0;
    }

    public boolean SetAlgorithm(int n2) {
        return true;
    }

    public boolean SetDictionarySize(int n2) {
        int n3 = 29;
        if (n2 < 1 || n2 > 1 << n3) {
            return false;
        }
        this._dictionarySize = n2;
        int n4 = 0;
        while (n2 > 1 << n4) {
            ++n4;
        }
        this._distTableSize = n4 * 2;
        return true;
    }

    public boolean SetNumFastBytes(int n2) {
        if (n2 < 5 || n2 > 273) {
            return false;
        }
        this._numFastBytes = n2;
        return true;
    }

    public boolean SetMatchFinder(int n2) {
        if (n2 < 0 || n2 > 2) {
            return false;
        }
        int n3 = this._matchFinderType;
        this._matchFinderType = n2;
        if (this._matchFinder != null && n3 != this._matchFinderType) {
            this._dictionarySizePrev = -1;
            this._matchFinder = null;
        }
        return true;
    }

    public boolean SetLcLpPb(int n2, int n3, int n4) {
        if (n3 < 0 || n3 > 4 || n2 < 0 || n2 > 8 || n4 < 0 || n4 > 4) {
            return false;
        }
        this._numLiteralPosStateBits = n3;
        this._numLiteralContextBits = n2;
        this._posStateBits = n4;
        this._posStateMask = (1 << this._posStateBits) - 1;
        return true;
    }

    public void SetEndMarkerMode(boolean bl2) {
        this._writeEndMark = bl2;
    }

    static {
        int n2 = 22;
        int n3 = 2;
        Encoder.g_FastPos[0] = 0;
        Encoder.g_FastPos[1] = 1;
        for (int i2 = 2; i2 < n2; ++i2) {
            int n4 = 1 << (i2 >> 1) - 1;
            int n5 = 0;
            while (n5 < n4) {
                Encoder.g_FastPos[n3] = (byte)i2;
                ++n5;
                ++n3;
            }
        }
    }

    class Optimal {
        public int State;
        public boolean Prev1IsChar;
        public boolean Prev2;
        public int PosPrev2;
        public int BackPrev2;
        public int Price;
        public int PosPrev;
        public int BackPrev;
        public int Backs0;
        public int Backs1;
        public int Backs2;
        public int Backs3;

        Optimal() {
        }

        public void MakeAsChar() {
            this.BackPrev = -1;
            this.Prev1IsChar = false;
        }

        public void MakeAsShortRep() {
            this.BackPrev = 0;
            this.Prev1IsChar = false;
        }

        public boolean IsShortRep() {
            return this.BackPrev == 0;
        }
    }

    class LenPriceTableEncoder
    extends LenEncoder {
        int[] _prices;
        int _tableSize;
        int[] _counters;

        LenPriceTableEncoder() {
            this._prices = new int[4352];
            this._counters = new int[16];
        }

        public void SetTableSize(int n2) {
            this._tableSize = n2;
        }

        public int GetPrice(int n2, int n3) {
            return this._prices[n3 * 272 + n2];
        }

        void UpdateTable(int n2) {
            this.SetPrices(n2, this._tableSize, this._prices, n2 * 272);
            this._counters[n2] = this._tableSize;
        }

        public void UpdateTables(int n2) {
            for (int i2 = 0; i2 < n2; ++i2) {
                this.UpdateTable(i2);
            }
        }

        @Override
        public void Encode(com.badlogic.gdx.utils.compression.rangecoder.Encoder encoder, int n2, int n3) {
            super.Encode(encoder, n2, n3);
            int n4 = n3;
            this._counters[n4] = this._counters[n4] - 1;
            if (this._counters[n4] == 0) {
                this.UpdateTable(n3);
            }
        }
    }

    class LenEncoder {
        short[] _choice = new short[2];
        BitTreeEncoder[] _lowCoder = new BitTreeEncoder[16];
        BitTreeEncoder[] _midCoder = new BitTreeEncoder[16];
        BitTreeEncoder _highCoder = new BitTreeEncoder(8);

        public LenEncoder() {
            for (int i2 = 0; i2 < 16; ++i2) {
                this._lowCoder[i2] = new BitTreeEncoder(3);
                this._midCoder[i2] = new BitTreeEncoder(3);
            }
        }

        public void Init(int n2) {
            com.badlogic.gdx.utils.compression.rangecoder.Encoder.InitBitModels(this._choice);
            for (int i2 = 0; i2 < n2; ++i2) {
                this._lowCoder[i2].Init();
                this._midCoder[i2].Init();
            }
            this._highCoder.Init();
        }

        public void Encode(com.badlogic.gdx.utils.compression.rangecoder.Encoder encoder, int n2, int n3) {
            if (n2 < 8) {
                encoder.Encode(this._choice, 0, 0);
                this._lowCoder[n3].Encode(encoder, n2);
            } else {
                encoder.Encode(this._choice, 0, 1);
                if ((n2 -= 8) < 8) {
                    encoder.Encode(this._choice, 1, 0);
                    this._midCoder[n3].Encode(encoder, n2);
                } else {
                    encoder.Encode(this._choice, 1, 1);
                    this._highCoder.Encode(encoder, n2 - 8);
                }
            }
        }

        public void SetPrices(int n2, int n3, int[] nArray, int n4) {
            int n5 = com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice0(this._choice[0]);
            int n6 = com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice1(this._choice[0]);
            int n7 = n6 + com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice0(this._choice[1]);
            int n8 = n6 + com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice1(this._choice[1]);
            int n9 = 0;
            for (n9 = 0; n9 < 8; ++n9) {
                if (n9 >= n3) {
                    return;
                }
                nArray[n4 + n9] = n5 + this._lowCoder[n2].GetPrice(n9);
            }
            while (n9 < 16) {
                if (n9 >= n3) {
                    return;
                }
                nArray[n4 + n9] = n7 + this._midCoder[n2].GetPrice(n9 - 8);
                ++n9;
            }
            while (n9 < n3) {
                nArray[n4 + n9] = n8 + this._highCoder.GetPrice(n9 - 8 - 8);
                ++n9;
            }
        }
    }

    class LiteralEncoder {
        Encoder2[] m_Coders;
        int m_NumPrevBits;
        int m_NumPosBits;
        int m_PosMask;

        LiteralEncoder() {
        }

        public void Create(int n2, int n3) {
            if (this.m_Coders != null && this.m_NumPrevBits == n3 && this.m_NumPosBits == n2) {
                return;
            }
            this.m_NumPosBits = n2;
            this.m_PosMask = (1 << n2) - 1;
            this.m_NumPrevBits = n3;
            int n4 = 1 << this.m_NumPrevBits + this.m_NumPosBits;
            this.m_Coders = new Encoder2[n4];
            for (int i2 = 0; i2 < n4; ++i2) {
                this.m_Coders[i2] = new Encoder2();
            }
        }

        public void Init() {
            int n2 = 1 << this.m_NumPrevBits + this.m_NumPosBits;
            for (int i2 = 0; i2 < n2; ++i2) {
                this.m_Coders[i2].Init();
            }
        }

        public Encoder2 GetSubCoder(int n2, byte by2) {
            return this.m_Coders[((n2 & this.m_PosMask) << this.m_NumPrevBits) + ((by2 & 0xFF) >>> 8 - this.m_NumPrevBits)];
        }

        class Encoder2 {
            short[] m_Encoders = new short[768];

            Encoder2() {
            }

            public void Init() {
                com.badlogic.gdx.utils.compression.rangecoder.Encoder.InitBitModels(this.m_Encoders);
            }

            public void Encode(com.badlogic.gdx.utils.compression.rangecoder.Encoder encoder, byte by2) {
                int n2 = 1;
                for (int i2 = 7; i2 >= 0; --i2) {
                    int n3 = by2 >> i2 & 1;
                    encoder.Encode(this.m_Encoders, n2, n3);
                    n2 = n2 << 1 | n3;
                }
            }

            public void EncodeMatched(com.badlogic.gdx.utils.compression.rangecoder.Encoder encoder, byte by2, byte by3) {
                int n2 = 1;
                boolean bl2 = true;
                for (int i2 = 7; i2 >= 0; --i2) {
                    int n3 = by3 >> i2 & 1;
                    int n4 = n2;
                    if (bl2) {
                        int n5 = by2 >> i2 & 1;
                        n4 += 1 + n5 << 8;
                        bl2 = n5 == n3;
                    }
                    encoder.Encode(this.m_Encoders, n4, n3);
                    n2 = n2 << 1 | n3;
                }
            }

            public int GetPrice(boolean bl2, byte by2, byte by3) {
                int n2;
                int n3;
                int n4 = 0;
                int n5 = 1;
                if (bl2) {
                    for (n3 = 7; n3 >= 0; --n3) {
                        n2 = by2 >> n3 & 1;
                        int n6 = by3 >> n3 & 1;
                        n4 += com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice(this.m_Encoders[(1 + n2 << 8) + n5], n6);
                        n5 = n5 << 1 | n6;
                        if (n2 == n6) continue;
                        --n3;
                        break;
                    }
                }
                while (n3 >= 0) {
                    n2 = by3 >> n3 & 1;
                    n4 += com.badlogic.gdx.utils.compression.rangecoder.Encoder.GetPrice(this.m_Encoders[n5], n2);
                    n5 = n5 << 1 | n2;
                    --n3;
                }
                return n4;
            }
        }
    }
}

