/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils.compression.lzma;

import com.badlogic.gdx.utils.compression.lz.OutWindow;
import com.badlogic.gdx.utils.compression.lzma.Base;
import com.badlogic.gdx.utils.compression.rangecoder.BitTreeDecoder;
import java.io.InputStream;
import java.io.OutputStream;

public class Decoder {
    OutWindow m_OutWindow = new OutWindow();
    com.badlogic.gdx.utils.compression.rangecoder.Decoder m_RangeDecoder = new com.badlogic.gdx.utils.compression.rangecoder.Decoder();
    short[] m_IsMatchDecoders = new short[192];
    short[] m_IsRepDecoders = new short[12];
    short[] m_IsRepG0Decoders = new short[12];
    short[] m_IsRepG1Decoders = new short[12];
    short[] m_IsRepG2Decoders = new short[12];
    short[] m_IsRep0LongDecoders = new short[192];
    BitTreeDecoder[] m_PosSlotDecoder = new BitTreeDecoder[4];
    short[] m_PosDecoders = new short[114];
    BitTreeDecoder m_PosAlignDecoder = new BitTreeDecoder(4);
    LenDecoder m_LenDecoder = new LenDecoder();
    LenDecoder m_RepLenDecoder = new LenDecoder();
    LiteralDecoder m_LiteralDecoder = new LiteralDecoder();
    int m_DictionarySize = -1;
    int m_DictionarySizeCheck = -1;
    int m_PosStateMask;

    public Decoder() {
        for (int i2 = 0; i2 < 4; ++i2) {
            this.m_PosSlotDecoder[i2] = new BitTreeDecoder(6);
        }
    }

    boolean SetDictionarySize(int n2) {
        if (n2 < 0) {
            return false;
        }
        if (this.m_DictionarySize != n2) {
            this.m_DictionarySize = n2;
            this.m_DictionarySizeCheck = Math.max(this.m_DictionarySize, 1);
            this.m_OutWindow.Create(Math.max(this.m_DictionarySizeCheck, 4096));
        }
        return true;
    }

    boolean SetLcLpPb(int n2, int n3, int n4) {
        if (n2 > 8 || n3 > 4 || n4 > 4) {
            return false;
        }
        this.m_LiteralDecoder.Create(n3, n2);
        int n5 = 1 << n4;
        this.m_LenDecoder.Create(n5);
        this.m_RepLenDecoder.Create(n5);
        this.m_PosStateMask = n5 - 1;
        return true;
    }

    void Init() {
        this.m_OutWindow.Init(false);
        com.badlogic.gdx.utils.compression.rangecoder.Decoder.InitBitModels(this.m_IsMatchDecoders);
        com.badlogic.gdx.utils.compression.rangecoder.Decoder.InitBitModels(this.m_IsRep0LongDecoders);
        com.badlogic.gdx.utils.compression.rangecoder.Decoder.InitBitModels(this.m_IsRepDecoders);
        com.badlogic.gdx.utils.compression.rangecoder.Decoder.InitBitModels(this.m_IsRepG0Decoders);
        com.badlogic.gdx.utils.compression.rangecoder.Decoder.InitBitModels(this.m_IsRepG1Decoders);
        com.badlogic.gdx.utils.compression.rangecoder.Decoder.InitBitModels(this.m_IsRepG2Decoders);
        com.badlogic.gdx.utils.compression.rangecoder.Decoder.InitBitModels(this.m_PosDecoders);
        this.m_LiteralDecoder.Init();
        for (int i2 = 0; i2 < 4; ++i2) {
            this.m_PosSlotDecoder[i2].Init();
        }
        this.m_LenDecoder.Init();
        this.m_RepLenDecoder.Init();
        this.m_PosAlignDecoder.Init();
        this.m_RangeDecoder.Init();
    }

    public boolean Code(InputStream inputStream, OutputStream outputStream, long l2) {
        this.m_RangeDecoder.SetStream(inputStream);
        this.m_OutWindow.SetStream(outputStream);
        this.Init();
        int n2 = Base.StateInit();
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        long l3 = 0L;
        byte by2 = 0;
        while (l2 < 0L || l3 < l2) {
            int n7;
            int n8;
            int n9 = (int)l3 & this.m_PosStateMask;
            if (this.m_RangeDecoder.DecodeBit(this.m_IsMatchDecoders, (n2 << 4) + n9) == 0) {
                LiteralDecoder.Decoder2 decoder2 = this.m_LiteralDecoder.GetDecoder((int)l3, by2);
                by2 = !Base.StateIsCharState(n2) ? decoder2.DecodeWithMatchByte(this.m_RangeDecoder, this.m_OutWindow.GetByte(n3)) : decoder2.DecodeNormal(this.m_RangeDecoder);
                this.m_OutWindow.PutByte(by2);
                n2 = Base.StateUpdateChar(n2);
                ++l3;
                continue;
            }
            if (this.m_RangeDecoder.DecodeBit(this.m_IsRepDecoders, n2) == 1) {
                n8 = 0;
                if (this.m_RangeDecoder.DecodeBit(this.m_IsRepG0Decoders, n2) == 0) {
                    if (this.m_RangeDecoder.DecodeBit(this.m_IsRep0LongDecoders, (n2 << 4) + n9) == 0) {
                        n2 = Base.StateUpdateShortRep(n2);
                        n8 = 1;
                    }
                } else {
                    if (this.m_RangeDecoder.DecodeBit(this.m_IsRepG1Decoders, n2) == 0) {
                        n7 = n4;
                    } else {
                        if (this.m_RangeDecoder.DecodeBit(this.m_IsRepG2Decoders, n2) == 0) {
                            n7 = n5;
                        } else {
                            n7 = n6;
                            n6 = n5;
                        }
                        n5 = n4;
                    }
                    n4 = n3;
                    n3 = n7;
                }
                if (n8 == 0) {
                    n8 = this.m_RepLenDecoder.Decode(this.m_RangeDecoder, n9) + 2;
                    n2 = Base.StateUpdateRep(n2);
                }
            } else {
                n6 = n5;
                n5 = n4;
                n4 = n3;
                n8 = 2 + this.m_LenDecoder.Decode(this.m_RangeDecoder, n9);
                n2 = Base.StateUpdateMatch(n2);
                n7 = this.m_PosSlotDecoder[Base.GetLenToPosState(n8)].Decode(this.m_RangeDecoder);
                if (n7 >= 4) {
                    int n10 = (n7 >> 1) - 1;
                    n3 = (2 | n7 & 1) << n10;
                    if (n7 < 14) {
                        n3 += BitTreeDecoder.ReverseDecode(this.m_PosDecoders, n3 - n7 - 1, this.m_RangeDecoder, n10);
                    } else {
                        n3 += this.m_RangeDecoder.DecodeDirectBits(n10 - 4) << 4;
                        if ((n3 += this.m_PosAlignDecoder.ReverseDecode(this.m_RangeDecoder)) < 0) {
                            if (n3 == -1) break;
                            return false;
                        }
                    }
                } else {
                    n3 = n7;
                }
            }
            if ((long)n3 >= l3 || n3 >= this.m_DictionarySizeCheck) {
                return false;
            }
            this.m_OutWindow.CopyBlock(n3, n8);
            l3 += (long)n8;
            by2 = this.m_OutWindow.GetByte(0);
        }
        this.m_OutWindow.Flush();
        this.m_OutWindow.ReleaseStream();
        this.m_RangeDecoder.ReleaseStream();
        return true;
    }

    public boolean SetDecoderProperties(byte[] byArray) {
        if (byArray.length < 5) {
            return false;
        }
        int n2 = byArray[0] & 0xFF;
        int n3 = n2 % 9;
        int n4 = n2 / 9;
        int n5 = n4 % 5;
        int n6 = n4 / 5;
        int n7 = 0;
        for (int i2 = 0; i2 < 4; ++i2) {
            n7 += (byArray[1 + i2] & 0xFF) << i2 * 8;
        }
        if (!this.SetLcLpPb(n3, n5, n6)) {
            return false;
        }
        return this.SetDictionarySize(n7);
    }

    class LiteralDecoder {
        Decoder2[] m_Coders;
        int m_NumPrevBits;
        int m_NumPosBits;
        int m_PosMask;

        LiteralDecoder() {
        }

        public void Create(int n2, int n3) {
            if (this.m_Coders != null && this.m_NumPrevBits == n3 && this.m_NumPosBits == n2) {
                return;
            }
            this.m_NumPosBits = n2;
            this.m_PosMask = (1 << n2) - 1;
            this.m_NumPrevBits = n3;
            int n4 = 1 << this.m_NumPrevBits + this.m_NumPosBits;
            this.m_Coders = new Decoder2[n4];
            for (int i2 = 0; i2 < n4; ++i2) {
                this.m_Coders[i2] = new Decoder2();
            }
        }

        public void Init() {
            int n2 = 1 << this.m_NumPrevBits + this.m_NumPosBits;
            for (int i2 = 0; i2 < n2; ++i2) {
                this.m_Coders[i2].Init();
            }
        }

        Decoder2 GetDecoder(int n2, byte by2) {
            return this.m_Coders[((n2 & this.m_PosMask) << this.m_NumPrevBits) + ((by2 & 0xFF) >>> 8 - this.m_NumPrevBits)];
        }

        class Decoder2 {
            short[] m_Decoders = new short[768];

            Decoder2() {
            }

            public void Init() {
                com.badlogic.gdx.utils.compression.rangecoder.Decoder.InitBitModels(this.m_Decoders);
            }

            public byte DecodeNormal(com.badlogic.gdx.utils.compression.rangecoder.Decoder decoder) {
                int n2 = 1;
                while ((n2 = n2 << 1 | decoder.DecodeBit(this.m_Decoders, n2)) < 256) {
                }
                return (byte)n2;
            }

            public byte DecodeWithMatchByte(com.badlogic.gdx.utils.compression.rangecoder.Decoder decoder, byte by2) {
                int n2 = 1;
                do {
                    int n3 = by2 >> 7 & 1;
                    by2 = (byte)(by2 << 1);
                    int n4 = decoder.DecodeBit(this.m_Decoders, (1 + n3 << 8) + n2);
                    n2 = n2 << 1 | n4;
                    if (n3 == n4) continue;
                    while (n2 < 256) {
                        n2 = n2 << 1 | decoder.DecodeBit(this.m_Decoders, n2);
                    }
                    break;
                } while (n2 < 256);
                return (byte)n2;
            }
        }
    }

    class LenDecoder {
        short[] m_Choice = new short[2];
        BitTreeDecoder[] m_LowCoder = new BitTreeDecoder[16];
        BitTreeDecoder[] m_MidCoder = new BitTreeDecoder[16];
        BitTreeDecoder m_HighCoder = new BitTreeDecoder(8);
        int m_NumPosStates = 0;

        LenDecoder() {
        }

        public void Create(int n2) {
            while (this.m_NumPosStates < n2) {
                this.m_LowCoder[this.m_NumPosStates] = new BitTreeDecoder(3);
                this.m_MidCoder[this.m_NumPosStates] = new BitTreeDecoder(3);
                ++this.m_NumPosStates;
            }
        }

        public void Init() {
            com.badlogic.gdx.utils.compression.rangecoder.Decoder.InitBitModels(this.m_Choice);
            for (int i2 = 0; i2 < this.m_NumPosStates; ++i2) {
                this.m_LowCoder[i2].Init();
                this.m_MidCoder[i2].Init();
            }
            this.m_HighCoder.Init();
        }

        public int Decode(com.badlogic.gdx.utils.compression.rangecoder.Decoder decoder, int n2) {
            if (decoder.DecodeBit(this.m_Choice, 0) == 0) {
                return this.m_LowCoder[n2].Decode(decoder);
            }
            int n3 = 8;
            n3 = decoder.DecodeBit(this.m_Choice, 1) == 0 ? (n3 += this.m_MidCoder[n2].Decode(decoder)) : (n3 += 8 + this.m_HighCoder.Decode(decoder));
            return n3;
        }
    }
}

