/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.lang.reflect.Array;

public final class bxb {
    private float[] var_float_arr_a;
    private float[] var_float_arr_b;
    private float[] var_float_arr_c;
    private int var_int_a;
    private float[] var_float_arr_d;
    private int var_int_b;
    private float var_float_a;
    private float[] var_float_arr_e = new float[32];
    private static final float var_float_b;
    private static final float var_float_c;
    private static final float var_float_d;
    private static final float var_float_e;
    private static final float var_float_f;
    private static final float g;
    private static final float h;
    private static final float i;
    private static final float j;
    private static final float k;
    private static final float l;
    private static final float m;
    private static final float n;
    private static final float o;
    private static final float p;
    private static final float q;
    private static final float r;
    private static final float s;
    private static final float t;
    private static final float u;
    private static final float v;
    private static final float w;
    private static final float x;
    private static final float y;
    private static final float z;
    private static final float A;
    private static final float B;
    private static final float C;
    private static final float D;
    private static final float E;
    private static final float F;
    private static float[] var_float_arr_f;
    private static float[][] var_float_arr_arr_a;

    public bxb(int n2, float f2, float[] fArray) {
        if (var_float_arr_f == null) {
            var_float_arr_f = bxb.float_arr_a();
            var_float_arr_arr_a = bxb.a(var_float_arr_f, 16);
        }
        this.var_float_arr_a = new float[512];
        this.var_float_arr_b = new float[512];
        this.var_float_arr_d = new float[32];
        this.var_int_b = n2;
        this.var_float_a = f2;
        this.void_a();
    }

    public void void_a() {
        int n2;
        for (n2 = 0; n2 < 512; ++n2) {
            this.var_float_arr_b[n2] = 0.0f;
            this.var_float_arr_a[n2] = 0.0f;
        }
        for (n2 = 0; n2 < 32; ++n2) {
            this.var_float_arr_d[n2] = 0.0f;
        }
        this.var_float_arr_c = this.var_float_arr_a;
        this.var_int_a = 15;
    }

    public void a(float f2, int n2) {
        this.var_float_arr_d[n2] = f2;
    }

    public void a(float[] fArray) {
        for (int i2 = 31; i2 >= 0; --i2) {
            this.var_float_arr_d[i2] = fArray[i2];
        }
    }

    private void b() {
        float[] fArray = this.var_float_arr_d;
        float f2 = fArray[0];
        float f3 = fArray[1];
        float f4 = fArray[2];
        float f5 = fArray[3];
        float f6 = fArray[4];
        float f7 = fArray[5];
        float f8 = fArray[6];
        float f9 = fArray[7];
        float f10 = fArray[8];
        float f11 = fArray[9];
        float f12 = fArray[10];
        float f13 = fArray[11];
        float f14 = fArray[12];
        float f15 = fArray[13];
        float f16 = fArray[14];
        float f17 = fArray[15];
        float f18 = fArray[16];
        float f19 = fArray[17];
        float f20 = fArray[18];
        float f21 = fArray[19];
        float f22 = fArray[20];
        float f23 = fArray[21];
        float f24 = fArray[22];
        float f25 = fArray[23];
        float f26 = fArray[24];
        float f27 = fArray[25];
        float f28 = fArray[26];
        float f29 = fArray[27];
        float f30 = fArray[28];
        float f31 = fArray[29];
        float f32 = fArray[30];
        float f33 = fArray[31];
        float f34 = f2 + f33;
        float f35 = f3 + f32;
        float f36 = f4 + f31;
        float f37 = f5 + f30;
        float f38 = f6 + f29;
        float f39 = f7 + f28;
        float f40 = f8 + f27;
        float f41 = f9 + f26;
        float f42 = f10 + f25;
        float f43 = f11 + f24;
        float f44 = f12 + f23;
        float f45 = f13 + f22;
        float f46 = f14 + f21;
        float f47 = f15 + f20;
        float f48 = f16 + f19;
        float f49 = f17 + f18;
        float f50 = f34 + f49;
        float f51 = f35 + f48;
        float f52 = f36 + f47;
        float f53 = f37 + f46;
        float f54 = f38 + f45;
        float f55 = f39 + f44;
        float f56 = f40 + f43;
        float f57 = f41 + f42;
        float f58 = (f34 - f49) * r;
        float f59 = (f35 - f48) * s;
        float f60 = (f36 - f47) * t;
        float f61 = (f37 - f46) * u;
        float f62 = (f38 - f45) * v;
        float f63 = (f39 - f44) * w;
        float f64 = (f40 - f43) * x;
        float f65 = (f41 - f42) * y;
        f34 = f50 + f57;
        f35 = f51 + f56;
        f36 = f52 + f55;
        f37 = f53 + f54;
        f38 = (f50 - f57) * z;
        f39 = (f51 - f56) * A;
        f40 = (f52 - f55) * B;
        f41 = (f53 - f54) * C;
        f42 = f58 + f65;
        f43 = f59 + f64;
        f44 = f60 + f63;
        f45 = f61 + f62;
        f46 = (f58 - f65) * z;
        f47 = (f59 - f64) * A;
        f48 = (f60 - f63) * B;
        f49 = (f61 - f62) * C;
        f50 = f34 + f37;
        f51 = f35 + f36;
        f52 = (f34 - f37) * D;
        f53 = (f35 - f36) * E;
        f54 = f38 + f41;
        f55 = f39 + f40;
        f56 = (f38 - f41) * D;
        f57 = (f39 - f40) * E;
        f58 = f42 + f45;
        f59 = f43 + f44;
        f60 = (f42 - f45) * D;
        f61 = (f43 - f44) * E;
        f62 = f46 + f49;
        f63 = f47 + f48;
        f64 = (f46 - f49) * D;
        f65 = (f47 - f48) * E;
        f34 = f50 + f51;
        f35 = (f50 - f51) * F;
        f36 = f52 + f53;
        f37 = (f52 - f53) * F;
        f38 = f54 + f55;
        f39 = (f54 - f55) * F;
        f40 = f56 + f57;
        f41 = (f56 - f57) * F;
        f42 = f58 + f59;
        f43 = (f58 - f59) * F;
        f44 = f60 + f61;
        f45 = (f60 - f61) * F;
        f46 = f62 + f63;
        f47 = (f62 - f63) * F;
        f48 = f64 + f65;
        f49 = (f64 - f65) * F;
        float f66 = f41;
        float f67 = f66 + f39;
        float f68 = -f67 - f40;
        float f69 = -f40 - f41 - f38;
        float f70 = f49;
        float f71 = f70 + f45;
        float f72 = f71 + f47;
        float f73 = f49 + f47 + f43;
        float f74 = -f73 - f48;
        float f75 = -f48 - f49 - f44 - f45;
        float f76 = f75 - f47;
        float f77 = -f48 - f49 - f46 - f42;
        float f78 = f75 - f46;
        float f79 = -f34;
        float f80 = f35;
        float f81 = f37;
        float f82 = -f81 - f36;
        f34 = (f2 - f33) * var_float_b;
        f35 = (f3 - f32) * var_float_c;
        f36 = (f4 - f31) * var_float_d;
        f37 = (f5 - f30) * var_float_e;
        f38 = (f6 - f29) * var_float_f;
        f39 = (f7 - f28) * g;
        f40 = (f8 - f27) * h;
        f41 = (f9 - f26) * i;
        f42 = (f10 - f25) * j;
        f43 = (f11 - f24) * k;
        f44 = (f12 - f23) * l;
        f45 = (f13 - f22) * m;
        f46 = (f14 - f21) * n;
        f47 = (f15 - f20) * o;
        f48 = (f16 - f19) * p;
        f49 = (f17 - f18) * q;
        f50 = f34 + f49;
        f51 = f35 + f48;
        f52 = f36 + f47;
        f53 = f37 + f46;
        f54 = f38 + f45;
        f55 = f39 + f44;
        f56 = f40 + f43;
        f57 = f41 + f42;
        f58 = (f34 - f49) * r;
        f59 = (f35 - f48) * s;
        f60 = (f36 - f47) * t;
        f61 = (f37 - f46) * u;
        f62 = (f38 - f45) * v;
        f63 = (f39 - f44) * w;
        f64 = (f40 - f43) * x;
        f65 = (f41 - f42) * y;
        f34 = f50 + f57;
        f35 = f51 + f56;
        f36 = f52 + f55;
        f37 = f53 + f54;
        f38 = (f50 - f57) * z;
        f39 = (f51 - f56) * A;
        f40 = (f52 - f55) * B;
        f41 = (f53 - f54) * C;
        f42 = f58 + f65;
        f43 = f59 + f64;
        f44 = f60 + f63;
        f45 = f61 + f62;
        f46 = (f58 - f65) * z;
        f47 = (f59 - f64) * A;
        f48 = (f60 - f63) * B;
        f49 = (f61 - f62) * C;
        f50 = f34 + f37;
        f51 = f35 + f36;
        f52 = (f34 - f37) * D;
        f53 = (f35 - f36) * E;
        f54 = f38 + f41;
        f55 = f39 + f40;
        f56 = (f38 - f41) * D;
        f57 = (f39 - f40) * E;
        f58 = f42 + f45;
        f59 = f43 + f44;
        f60 = (f42 - f45) * D;
        f61 = (f43 - f44) * E;
        f62 = f46 + f49;
        f63 = f47 + f48;
        f64 = (f46 - f49) * D;
        f65 = (f47 - f48) * E;
        f34 = f50 + f51;
        f35 = (f50 - f51) * F;
        f36 = f52 + f53;
        f37 = (f52 - f53) * F;
        f38 = f54 + f55;
        f39 = (f54 - f55) * F;
        f40 = f56 + f57;
        f41 = (f56 - f57) * F;
        f42 = f58 + f59;
        f43 = (f58 - f59) * F;
        f44 = f60 + f61;
        f45 = (f60 - f61) * F;
        f46 = f62 + f63;
        f47 = (f62 - f63) * F;
        f48 = f64 + f65;
        float f83 = f49 = (f64 - f65) * F;
        float f84 = f83 + f41;
        float f85 = f84 + f45;
        float f86 = f85 + f39 + f47;
        float f87 = f49 + f45 + f37;
        float f88 = f87 + f47;
        f75 = f47 + f49 + f43;
        float f89 = f75 + f35;
        float f90 = -f89 - f48;
        float f91 = f75 + f39 + f41;
        float f92 = -f91 - f40 - f48;
        f75 = -f44 - f45 - f48 - f49;
        float f93 = f75 - f47 - f36 - f37;
        float f94 = f75 - f47 - f39 - f40 - f41;
        float f95 = f75 - f46 - f36 - f37;
        float f96 = f38 + f40 + f41;
        float f97 = f75 - f46 - f96;
        f75 = -f42 - f46 - f48 - f49;
        float f98 = f75 - f34;
        float f99 = f75 - f96;
        float[] fArray2 = this.var_float_arr_c;
        int n2 = this.var_int_a;
        fArray2[0 + n2] = f80;
        fArray2[16 + n2] = f89;
        fArray2[32 + n2] = f73;
        fArray2[48 + n2] = f91;
        fArray2[64 + n2] = f67;
        fArray2[80 + n2] = f86;
        fArray2[96 + n2] = f72;
        fArray2[112 + n2] = f88;
        fArray2[128 + n2] = f81;
        fArray2[144 + n2] = f87;
        fArray2[160 + n2] = f71;
        fArray2[176 + n2] = f85;
        fArray2[192 + n2] = f66;
        fArray2[208 + n2] = f84;
        fArray2[224 + n2] = f70;
        fArray2[240 + n2] = f83;
        fArray2[256 + n2] = 0.0f;
        fArray2[272 + n2] = -f83;
        fArray2[288 + n2] = -f70;
        fArray2[304 + n2] = -f84;
        fArray2[320 + n2] = -f66;
        fArray2[336 + n2] = -f85;
        fArray2[352 + n2] = -f71;
        fArray2[368 + n2] = -f87;
        fArray2[384 + n2] = -f81;
        fArray2[400 + n2] = -f88;
        fArray2[416 + n2] = -f72;
        fArray2[432 + n2] = -f86;
        fArray2[448 + n2] = -f67;
        fArray2[464 + n2] = -f91;
        fArray2[480 + n2] = -f73;
        fArray2[496 + n2] = -f89;
        fArray2 = this.var_float_arr_c == this.var_float_arr_a ? this.var_float_arr_b : this.var_float_arr_a;
        fArray2[0 + n2] = -f80;
        fArray2[16 + n2] = f90;
        fArray2[32 + n2] = f74;
        fArray2[48 + n2] = f92;
        fArray2[64 + n2] = f68;
        fArray2[80 + n2] = f94;
        fArray2[96 + n2] = f76;
        fArray2[112 + n2] = f93;
        fArray2[128 + n2] = f82;
        fArray2[144 + n2] = f95;
        fArray2[160 + n2] = f78;
        fArray2[176 + n2] = f97;
        fArray2[192 + n2] = f69;
        fArray2[208 + n2] = f99;
        fArray2[224 + n2] = f77;
        fArray2[240 + n2] = f98;
        fArray2[256 + n2] = f79;
        fArray2[272 + n2] = f98;
        fArray2[288 + n2] = f77;
        fArray2[304 + n2] = f99;
        fArray2[320 + n2] = f69;
        fArray2[336 + n2] = f97;
        fArray2[352 + n2] = f78;
        fArray2[368 + n2] = f95;
        fArray2[384 + n2] = f82;
        fArray2[400 + n2] = f93;
        fArray2[416 + n2] = f76;
        fArray2[432 + n2] = f94;
        fArray2[448 + n2] = f68;
        fArray2[464 + n2] = f92;
        fArray2[480 + n2] = f74;
        fArray2[496 + n2] = f90;
    }

    private void b(bxa bxa2) {
        float[] fArray = this.var_float_arr_c;
        float[] fArray2 = this.var_float_arr_e;
        int n2 = 0;
        for (int i2 = 0; i2 < 32; ++i2) {
            float f2;
            float[] fArray3 = var_float_arr_arr_a[i2];
            fArray2[i2] = f2 = (fArray[0 + n2] * fArray3[0] + fArray[15 + n2] * fArray3[1] + fArray[14 + n2] * fArray3[2] + fArray[13 + n2] * fArray3[3] + fArray[12 + n2] * fArray3[4] + fArray[11 + n2] * fArray3[5] + fArray[10 + n2] * fArray3[6] + fArray[9 + n2] * fArray3[7] + fArray[8 + n2] * fArray3[8] + fArray[7 + n2] * fArray3[9] + fArray[6 + n2] * fArray3[10] + fArray[5 + n2] * fArray3[11] + fArray[4 + n2] * fArray3[12] + fArray[3 + n2] * fArray3[13] + fArray[2 + n2] * fArray3[14] + fArray[1 + n2] * fArray3[15]) * this.var_float_a;
            n2 += 16;
        }
    }

    private void c(bxa bxa2) {
        float[] fArray = this.var_float_arr_c;
        float[] fArray2 = this.var_float_arr_e;
        int n2 = 0;
        for (int i2 = 0; i2 < 32; ++i2) {
            float f2;
            float[] fArray3 = var_float_arr_arr_a[i2];
            fArray2[i2] = f2 = (fArray[1 + n2] * fArray3[0] + fArray[0 + n2] * fArray3[1] + fArray[15 + n2] * fArray3[2] + fArray[14 + n2] * fArray3[3] + fArray[13 + n2] * fArray3[4] + fArray[12 + n2] * fArray3[5] + fArray[11 + n2] * fArray3[6] + fArray[10 + n2] * fArray3[7] + fArray[9 + n2] * fArray3[8] + fArray[8 + n2] * fArray3[9] + fArray[7 + n2] * fArray3[10] + fArray[6 + n2] * fArray3[11] + fArray[5 + n2] * fArray3[12] + fArray[4 + n2] * fArray3[13] + fArray[3 + n2] * fArray3[14] + fArray[2 + n2] * fArray3[15]) * this.var_float_a;
            n2 += 16;
        }
    }

    private void d(bxa bxa2) {
        float[] fArray = this.var_float_arr_c;
        float[] fArray2 = this.var_float_arr_e;
        int n2 = 0;
        for (int i2 = 0; i2 < 32; ++i2) {
            float f2;
            float[] fArray3 = var_float_arr_arr_a[i2];
            fArray2[i2] = f2 = (fArray[2 + n2] * fArray3[0] + fArray[1 + n2] * fArray3[1] + fArray[0 + n2] * fArray3[2] + fArray[15 + n2] * fArray3[3] + fArray[14 + n2] * fArray3[4] + fArray[13 + n2] * fArray3[5] + fArray[12 + n2] * fArray3[6] + fArray[11 + n2] * fArray3[7] + fArray[10 + n2] * fArray3[8] + fArray[9 + n2] * fArray3[9] + fArray[8 + n2] * fArray3[10] + fArray[7 + n2] * fArray3[11] + fArray[6 + n2] * fArray3[12] + fArray[5 + n2] * fArray3[13] + fArray[4 + n2] * fArray3[14] + fArray[3 + n2] * fArray3[15]) * this.var_float_a;
            n2 += 16;
        }
    }

    private void e(bxa bxa2) {
        float[] fArray = this.var_float_arr_c;
        float[] fArray2 = this.var_float_arr_e;
        int n2 = 0;
        for (int i2 = 0; i2 < 32; ++i2) {
            float f2;
            float[] fArray3 = var_float_arr_arr_a[i2];
            fArray2[i2] = f2 = (fArray[3 + n2] * fArray3[0] + fArray[2 + n2] * fArray3[1] + fArray[1 + n2] * fArray3[2] + fArray[0 + n2] * fArray3[3] + fArray[15 + n2] * fArray3[4] + fArray[14 + n2] * fArray3[5] + fArray[13 + n2] * fArray3[6] + fArray[12 + n2] * fArray3[7] + fArray[11 + n2] * fArray3[8] + fArray[10 + n2] * fArray3[9] + fArray[9 + n2] * fArray3[10] + fArray[8 + n2] * fArray3[11] + fArray[7 + n2] * fArray3[12] + fArray[6 + n2] * fArray3[13] + fArray[5 + n2] * fArray3[14] + fArray[4 + n2] * fArray3[15]) * this.var_float_a;
            n2 += 16;
        }
    }

    private void f(bxa bxa2) {
        float[] fArray = this.var_float_arr_c;
        float[] fArray2 = this.var_float_arr_e;
        int n2 = 0;
        for (int i2 = 0; i2 < 32; ++i2) {
            float f2;
            float[] fArray3 = var_float_arr_arr_a[i2];
            fArray2[i2] = f2 = (fArray[4 + n2] * fArray3[0] + fArray[3 + n2] * fArray3[1] + fArray[2 + n2] * fArray3[2] + fArray[1 + n2] * fArray3[3] + fArray[0 + n2] * fArray3[4] + fArray[15 + n2] * fArray3[5] + fArray[14 + n2] * fArray3[6] + fArray[13 + n2] * fArray3[7] + fArray[12 + n2] * fArray3[8] + fArray[11 + n2] * fArray3[9] + fArray[10 + n2] * fArray3[10] + fArray[9 + n2] * fArray3[11] + fArray[8 + n2] * fArray3[12] + fArray[7 + n2] * fArray3[13] + fArray[6 + n2] * fArray3[14] + fArray[5 + n2] * fArray3[15]) * this.var_float_a;
            n2 += 16;
        }
    }

    private void g(bxa bxa2) {
        float[] fArray = this.var_float_arr_c;
        float[] fArray2 = this.var_float_arr_e;
        int n2 = 0;
        for (int i2 = 0; i2 < 32; ++i2) {
            float f2;
            float[] fArray3 = var_float_arr_arr_a[i2];
            fArray2[i2] = f2 = (fArray[5 + n2] * fArray3[0] + fArray[4 + n2] * fArray3[1] + fArray[3 + n2] * fArray3[2] + fArray[2 + n2] * fArray3[3] + fArray[1 + n2] * fArray3[4] + fArray[0 + n2] * fArray3[5] + fArray[15 + n2] * fArray3[6] + fArray[14 + n2] * fArray3[7] + fArray[13 + n2] * fArray3[8] + fArray[12 + n2] * fArray3[9] + fArray[11 + n2] * fArray3[10] + fArray[10 + n2] * fArray3[11] + fArray[9 + n2] * fArray3[12] + fArray[8 + n2] * fArray3[13] + fArray[7 + n2] * fArray3[14] + fArray[6 + n2] * fArray3[15]) * this.var_float_a;
            n2 += 16;
        }
    }

    private void h(bxa bxa2) {
        float[] fArray = this.var_float_arr_c;
        float[] fArray2 = this.var_float_arr_e;
        int n2 = 0;
        for (int i2 = 0; i2 < 32; ++i2) {
            float f2;
            float[] fArray3 = var_float_arr_arr_a[i2];
            fArray2[i2] = f2 = (fArray[6 + n2] * fArray3[0] + fArray[5 + n2] * fArray3[1] + fArray[4 + n2] * fArray3[2] + fArray[3 + n2] * fArray3[3] + fArray[2 + n2] * fArray3[4] + fArray[1 + n2] * fArray3[5] + fArray[0 + n2] * fArray3[6] + fArray[15 + n2] * fArray3[7] + fArray[14 + n2] * fArray3[8] + fArray[13 + n2] * fArray3[9] + fArray[12 + n2] * fArray3[10] + fArray[11 + n2] * fArray3[11] + fArray[10 + n2] * fArray3[12] + fArray[9 + n2] * fArray3[13] + fArray[8 + n2] * fArray3[14] + fArray[7 + n2] * fArray3[15]) * this.var_float_a;
            n2 += 16;
        }
    }

    private void i(bxa bxa2) {
        float[] fArray = this.var_float_arr_c;
        float[] fArray2 = this.var_float_arr_e;
        int n2 = 0;
        for (int i2 = 0; i2 < 32; ++i2) {
            float f2;
            float[] fArray3 = var_float_arr_arr_a[i2];
            fArray2[i2] = f2 = (fArray[7 + n2] * fArray3[0] + fArray[6 + n2] * fArray3[1] + fArray[5 + n2] * fArray3[2] + fArray[4 + n2] * fArray3[3] + fArray[3 + n2] * fArray3[4] + fArray[2 + n2] * fArray3[5] + fArray[1 + n2] * fArray3[6] + fArray[0 + n2] * fArray3[7] + fArray[15 + n2] * fArray3[8] + fArray[14 + n2] * fArray3[9] + fArray[13 + n2] * fArray3[10] + fArray[12 + n2] * fArray3[11] + fArray[11 + n2] * fArray3[12] + fArray[10 + n2] * fArray3[13] + fArray[9 + n2] * fArray3[14] + fArray[8 + n2] * fArray3[15]) * this.var_float_a;
            n2 += 16;
        }
    }

    private void j(bxa bxa2) {
        float[] fArray = this.var_float_arr_c;
        float[] fArray2 = this.var_float_arr_e;
        int n2 = 0;
        for (int i2 = 0; i2 < 32; ++i2) {
            float f2;
            float[] fArray3 = var_float_arr_arr_a[i2];
            fArray2[i2] = f2 = (fArray[8 + n2] * fArray3[0] + fArray[7 + n2] * fArray3[1] + fArray[6 + n2] * fArray3[2] + fArray[5 + n2] * fArray3[3] + fArray[4 + n2] * fArray3[4] + fArray[3 + n2] * fArray3[5] + fArray[2 + n2] * fArray3[6] + fArray[1 + n2] * fArray3[7] + fArray[0 + n2] * fArray3[8] + fArray[15 + n2] * fArray3[9] + fArray[14 + n2] * fArray3[10] + fArray[13 + n2] * fArray3[11] + fArray[12 + n2] * fArray3[12] + fArray[11 + n2] * fArray3[13] + fArray[10 + n2] * fArray3[14] + fArray[9 + n2] * fArray3[15]) * this.var_float_a;
            n2 += 16;
        }
    }

    private void k(bxa bxa2) {
        float[] fArray = this.var_float_arr_c;
        float[] fArray2 = this.var_float_arr_e;
        int n2 = 0;
        for (int i2 = 0; i2 < 32; ++i2) {
            float f2;
            float[] fArray3 = var_float_arr_arr_a[i2];
            fArray2[i2] = f2 = (fArray[9 + n2] * fArray3[0] + fArray[8 + n2] * fArray3[1] + fArray[7 + n2] * fArray3[2] + fArray[6 + n2] * fArray3[3] + fArray[5 + n2] * fArray3[4] + fArray[4 + n2] * fArray3[5] + fArray[3 + n2] * fArray3[6] + fArray[2 + n2] * fArray3[7] + fArray[1 + n2] * fArray3[8] + fArray[0 + n2] * fArray3[9] + fArray[15 + n2] * fArray3[10] + fArray[14 + n2] * fArray3[11] + fArray[13 + n2] * fArray3[12] + fArray[12 + n2] * fArray3[13] + fArray[11 + n2] * fArray3[14] + fArray[10 + n2] * fArray3[15]) * this.var_float_a;
            n2 += 16;
        }
    }

    private void l(bxa bxa2) {
        float[] fArray = this.var_float_arr_c;
        float[] fArray2 = this.var_float_arr_e;
        int n2 = 0;
        for (int i2 = 0; i2 < 32; ++i2) {
            float f2;
            float[] fArray3 = var_float_arr_arr_a[i2];
            fArray2[i2] = f2 = (fArray[10 + n2] * fArray3[0] + fArray[9 + n2] * fArray3[1] + fArray[8 + n2] * fArray3[2] + fArray[7 + n2] * fArray3[3] + fArray[6 + n2] * fArray3[4] + fArray[5 + n2] * fArray3[5] + fArray[4 + n2] * fArray3[6] + fArray[3 + n2] * fArray3[7] + fArray[2 + n2] * fArray3[8] + fArray[1 + n2] * fArray3[9] + fArray[0 + n2] * fArray3[10] + fArray[15 + n2] * fArray3[11] + fArray[14 + n2] * fArray3[12] + fArray[13 + n2] * fArray3[13] + fArray[12 + n2] * fArray3[14] + fArray[11 + n2] * fArray3[15]) * this.var_float_a;
            n2 += 16;
        }
    }

    private void m(bxa bxa2) {
        float[] fArray = this.var_float_arr_c;
        float[] fArray2 = this.var_float_arr_e;
        int n2 = 0;
        for (int i2 = 0; i2 < 32; ++i2) {
            float f2;
            float[] fArray3 = var_float_arr_arr_a[i2];
            fArray2[i2] = f2 = (fArray[11 + n2] * fArray3[0] + fArray[10 + n2] * fArray3[1] + fArray[9 + n2] * fArray3[2] + fArray[8 + n2] * fArray3[3] + fArray[7 + n2] * fArray3[4] + fArray[6 + n2] * fArray3[5] + fArray[5 + n2] * fArray3[6] + fArray[4 + n2] * fArray3[7] + fArray[3 + n2] * fArray3[8] + fArray[2 + n2] * fArray3[9] + fArray[1 + n2] * fArray3[10] + fArray[0 + n2] * fArray3[11] + fArray[15 + n2] * fArray3[12] + fArray[14 + n2] * fArray3[13] + fArray[13 + n2] * fArray3[14] + fArray[12 + n2] * fArray3[15]) * this.var_float_a;
            n2 += 16;
        }
    }

    private void n(bxa bxa2) {
        float[] fArray = this.var_float_arr_c;
        float[] fArray2 = this.var_float_arr_e;
        int n2 = 0;
        for (int i2 = 0; i2 < 32; ++i2) {
            float f2;
            float[] fArray3 = var_float_arr_arr_a[i2];
            fArray2[i2] = f2 = (fArray[12 + n2] * fArray3[0] + fArray[11 + n2] * fArray3[1] + fArray[10 + n2] * fArray3[2] + fArray[9 + n2] * fArray3[3] + fArray[8 + n2] * fArray3[4] + fArray[7 + n2] * fArray3[5] + fArray[6 + n2] * fArray3[6] + fArray[5 + n2] * fArray3[7] + fArray[4 + n2] * fArray3[8] + fArray[3 + n2] * fArray3[9] + fArray[2 + n2] * fArray3[10] + fArray[1 + n2] * fArray3[11] + fArray[0 + n2] * fArray3[12] + fArray[15 + n2] * fArray3[13] + fArray[14 + n2] * fArray3[14] + fArray[13 + n2] * fArray3[15]) * this.var_float_a;
            n2 += 16;
        }
    }

    private void o(bxa bxa2) {
        float[] fArray = this.var_float_arr_c;
        float[] fArray2 = this.var_float_arr_e;
        int n2 = 0;
        for (int i2 = 0; i2 < 32; ++i2) {
            float f2;
            float[] fArray3 = var_float_arr_arr_a[i2];
            fArray2[i2] = f2 = (fArray[13 + n2] * fArray3[0] + fArray[12 + n2] * fArray3[1] + fArray[11 + n2] * fArray3[2] + fArray[10 + n2] * fArray3[3] + fArray[9 + n2] * fArray3[4] + fArray[8 + n2] * fArray3[5] + fArray[7 + n2] * fArray3[6] + fArray[6 + n2] * fArray3[7] + fArray[5 + n2] * fArray3[8] + fArray[4 + n2] * fArray3[9] + fArray[3 + n2] * fArray3[10] + fArray[2 + n2] * fArray3[11] + fArray[1 + n2] * fArray3[12] + fArray[0 + n2] * fArray3[13] + fArray[15 + n2] * fArray3[14] + fArray[14 + n2] * fArray3[15]) * this.var_float_a;
            n2 += 16;
        }
    }

    private void p(bxa bxa2) {
        float[] fArray = this.var_float_arr_c;
        float[] fArray2 = this.var_float_arr_e;
        int n2 = 0;
        for (int i2 = 0; i2 < 32; ++i2) {
            float f2;
            float[] fArray3 = var_float_arr_arr_a[i2];
            fArray2[i2] = f2 = (fArray[14 + n2] * fArray3[0] + fArray[13 + n2] * fArray3[1] + fArray[12 + n2] * fArray3[2] + fArray[11 + n2] * fArray3[3] + fArray[10 + n2] * fArray3[4] + fArray[9 + n2] * fArray3[5] + fArray[8 + n2] * fArray3[6] + fArray[7 + n2] * fArray3[7] + fArray[6 + n2] * fArray3[8] + fArray[5 + n2] * fArray3[9] + fArray[4 + n2] * fArray3[10] + fArray[3 + n2] * fArray3[11] + fArray[2 + n2] * fArray3[12] + fArray[1 + n2] * fArray3[13] + fArray[0 + n2] * fArray3[14] + fArray[15 + n2] * fArray3[15]) * this.var_float_a;
            n2 += 16;
        }
    }

    private void q(bxa bxa2) {
        float[] fArray = this.var_float_arr_c;
        float[] fArray2 = this.var_float_arr_e;
        int n2 = 0;
        for (int i2 = 0; i2 < 32; ++i2) {
            float f2;
            float[] fArray3 = var_float_arr_arr_a[i2];
            fArray2[i2] = f2 = (fArray[15 + n2] * fArray3[0] + fArray[14 + n2] * fArray3[1] + fArray[13 + n2] * fArray3[2] + fArray[12 + n2] * fArray3[3] + fArray[11 + n2] * fArray3[4] + fArray[10 + n2] * fArray3[5] + fArray[9 + n2] * fArray3[6] + fArray[8 + n2] * fArray3[7] + fArray[7 + n2] * fArray3[8] + fArray[6 + n2] * fArray3[9] + fArray[5 + n2] * fArray3[10] + fArray[4 + n2] * fArray3[11] + fArray[3 + n2] * fArray3[12] + fArray[2 + n2] * fArray3[13] + fArray[1 + n2] * fArray3[14] + fArray[0 + n2] * fArray3[15]) * this.var_float_a;
            n2 += 16;
        }
    }

    private void r(bxa bxa2) {
        switch (this.var_int_a) {
            case 0: {
                this.b(bxa2);
                break;
            }
            case 1: {
                this.c(bxa2);
                break;
            }
            case 2: {
                this.d(bxa2);
                break;
            }
            case 3: {
                this.e(bxa2);
                break;
            }
            case 4: {
                this.f(bxa2);
                break;
            }
            case 5: {
                this.g(bxa2);
                break;
            }
            case 6: {
                this.h(bxa2);
                break;
            }
            case 7: {
                this.i(bxa2);
                break;
            }
            case 8: {
                this.j(bxa2);
                break;
            }
            case 9: {
                this.k(bxa2);
                break;
            }
            case 10: {
                this.l(bxa2);
                break;
            }
            case 11: {
                this.m(bxa2);
                break;
            }
            case 12: {
                this.n(bxa2);
                break;
            }
            case 13: {
                this.o(bxa2);
                break;
            }
            case 14: {
                this.p(bxa2);
                break;
            }
            case 15: {
                this.q(bxa2);
            }
        }
        if (bxa2 != null) {
            bxa2.a(this.var_int_b, this.var_float_arr_e);
        }
    }

    public void a(bxa bxa2) {
        this.b();
        this.r(bxa2);
        this.var_int_a = this.var_int_a + 1 & 0xF;
        this.var_float_arr_c = this.var_float_arr_c == this.var_float_arr_a ? this.var_float_arr_b : this.var_float_arr_a;
        for (int i2 = 0; i2 < 32; ++i2) {
            this.var_float_arr_d[i2] = 0.0f;
        }
    }

    private static float[] float_arr_a() {
        try {
            Class<Float> clazz = Float.TYPE;
            Object object = bxb.a(bxb.class.getResourceAsStream("/sfd.ser"), clazz, 512);
            return (float[])object;
        }
        catch (IOException iOException) {
            throw new ExceptionInInitializerError(iOException);
        }
    }

    private static Object a(InputStream inputStream, Class clazz, int n2) {
        int n3;
        if (clazz == null) {
            throw new NullPointerException("elemType");
        }
        if (n2 < -1) {
            throw new IllegalArgumentException("length");
        }
        Object object = bxb.a(inputStream);
        Class<?> clazz2 = object.getClass();
        if (!clazz2.isArray()) {
            throw new InvalidObjectException("object is not an array");
        }
        Class<?> clazz3 = clazz2.getComponentType();
        if (clazz3 != clazz) {
            throw new InvalidObjectException("unexpected array component type");
        }
        if (n2 != -1 && (n3 = Array.getLength(object)) != n2) {
            throw new InvalidObjectException("array length mismatch");
        }
        return object;
    }

    public static Object a(InputStream inputStream) {
        Object object;
        if (inputStream == null) {
            throw new NullPointerException("in");
        }
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        try {
            object = objectInputStream.readObject();
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new InvalidClassException(classNotFoundException.toString());
        }
        return object;
    }

    private static float[][] a(float[] fArray, int n2) {
        int n3 = fArray.length / n2;
        float[][] fArrayArray = new float[n3][];
        for (int i2 = 0; i2 < n3; ++i2) {
            fArrayArray[i2] = bxb.a(fArray, i2 * n2, n2);
        }
        return fArrayArray;
    }

    private static float[] a(float[] fArray, int n2, int n3) {
        if (n2 + n3 > fArray.length) {
            n3 = fArray.length - n2;
        }
        if (n3 < 0) {
            n3 = 0;
        }
        float[] fArray2 = new float[n3];
        for (int i2 = 0; i2 < n3; ++i2) {
            fArray2[i2] = fArray[n2 + i2];
        }
        return fArray2;
    }

    static {
        var_float_b = (float)(1.0 / (2.0 * Math.cos(0.04908738521234052)));
        var_float_c = (float)(1.0 / (2.0 * Math.cos(0.14726215563702155)));
        var_float_d = (float)(1.0 / (2.0 * Math.cos(0.2454369260617026)));
        var_float_e = (float)(1.0 / (2.0 * Math.cos(0.3436116964863836)));
        var_float_f = (float)(1.0 / (2.0 * Math.cos(0.44178646691106466)));
        g = (float)(1.0 / (2.0 * Math.cos(0.5399612373357456)));
        h = (float)(1.0 / (2.0 * Math.cos(0.6381360077604268)));
        i = (float)(1.0 / (2.0 * Math.cos(0.7363107781851077)));
        j = (float)(1.0 / (2.0 * Math.cos(0.8344855486097889)));
        k = (float)(1.0 / (2.0 * Math.cos(0.9326603190344698)));
        l = (float)(1.0 / (2.0 * Math.cos(1.030835089459151)));
        m = (float)(1.0 / (2.0 * Math.cos(1.1290098598838318)));
        n = (float)(1.0 / (2.0 * Math.cos(1.227184630308513)));
        o = (float)(1.0 / (2.0 * Math.cos(1.325359400733194)));
        p = (float)(1.0 / (2.0 * Math.cos(1.423534171157875)));
        q = (float)(1.0 / (2.0 * Math.cos(1.521708941582556)));
        r = (float)(1.0 / (2.0 * Math.cos(0.09817477042468103)));
        s = (float)(1.0 / (2.0 * Math.cos(0.2945243112740431)));
        t = (float)(1.0 / (2.0 * Math.cos(0.4908738521234052)));
        u = (float)(1.0 / (2.0 * Math.cos(0.6872233929727672)));
        v = (float)(1.0 / (2.0 * Math.cos(0.8835729338221293)));
        w = (float)(1.0 / (2.0 * Math.cos(1.0799224746714913)));
        x = (float)(1.0 / (2.0 * Math.cos(1.2762720155208536)));
        y = (float)(1.0 / (2.0 * Math.cos(1.4726215563702154)));
        z = (float)(1.0 / (2.0 * Math.cos(0.19634954084936207)));
        A = (float)(1.0 / (2.0 * Math.cos(0.5890486225480862)));
        B = (float)(1.0 / (2.0 * Math.cos(0.9817477042468103)));
        C = (float)(1.0 / (2.0 * Math.cos(1.3744467859455345)));
        D = (float)(1.0 / (2.0 * Math.cos(0.39269908169872414)));
        E = (float)(1.0 / (2.0 * Math.cos(1.1780972450961724)));
        F = (float)(1.0 / (2.0 * Math.cos(0.7853981633974483)));
        var_float_arr_f = null;
        var_float_arr_arr_a = null;
    }
}

