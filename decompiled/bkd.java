/*
 * Decompiled with CFR 0.152.
 */
import java.math.BigDecimal;
import java.math.BigInteger;

abstract class bkd<T extends bfz>
extends blc<T> {
    protected final Boolean a;

    public bkd(Class<T> clazz, Boolean bl2) {
        super(clazz);
        this.a = bl2;
    }

    @Override
    public Object a(bdc bdc2, bfs bfs2, boc boc2) {
        return boc2.d(bdc2, bfs2);
    }

    @Override
    public btq btq_a() {
        return btq.e;
    }

    @Override
    public boolean boolean_a() {
        return true;
    }

    @Override
    public Boolean a(bfr bfr2) {
        return this.a;
    }

    protected void a(bdc bdc2, bfs bfs2, bpo bpo2, String string, bpt bpt2, bfz bfz2, bfz bfz3) {
        if (bfs2.a(bfu.i)) {
            bfs2.a(bfz.class, "Duplicate field '%s' for `ObjectNode`: not allowed when `DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY` enabled", new Object[]{string});
        }
        if (bfs2.a(bdj.var_bdj_a)) {
            if (bfz2.boolean_a()) {
                ((bpd)bfz2).a(bfz3);
                bpt2.b(string, bfz2);
            } else {
                bpd bpd2 = bpo2.bpd_a();
                bpd2.a(bfz2);
                bpd2.a(bfz3);
                bpt2.b(string, bpd2);
            }
        }
    }

    @Override
    protected final bpt bpt_a(bdc bdc2, bfs bfs2, bpo bpo2) {
        bpt bpt2 = bpo2.bpt_a();
        String string = bdc2.java_lang_String_a();
        while (string != null) {
            bfz bfz2;
            bdf bdf2 = bdc2.bdf_a();
            if (bdf2 == null) {
                bdf2 = bdf.var_bdf_a;
            }
            switch (bdf2.int_a()) {
                case 1: {
                    bfz2 = this.bpt_a(bdc2, bfs2, bpo2);
                    break;
                }
                case 3: {
                    bfz2 = this.bpd_a(bdc2, bfs2, bpo2);
                    break;
                }
                case 12: {
                    bfz2 = this.d(bdc2, bfs2, bpo2);
                    break;
                }
                case 6: {
                    bfz2 = bpo2.a(bdc2.java_lang_String_e());
                    break;
                }
                case 7: {
                    bfz2 = this.bfz_b(bdc2, bfs2, bpo2);
                    break;
                }
                case 9: {
                    bfz2 = bpo2.a(true);
                    break;
                }
                case 10: {
                    bfz2 = bpo2.a(false);
                    break;
                }
                case 11: {
                    bfz2 = bpo2.bpr_a();
                    break;
                }
                default: {
                    bfz2 = this.bfz_a(bdc2, bfs2, bpo2);
                }
            }
            bfz bfz3 = bpt2.b(string, bfz2);
            if (bfz3 != null) {
                this.a(bdc2, bfs2, bpo2, string, bpt2, bfz3, bfz2);
            }
            string = bdc2.java_lang_String_a();
        }
        return bpt2;
    }

    protected final bpt bpt_b(bdc bdc2, bfs bfs2, bpo bpo2) {
        bpt bpt2 = bpo2.bpt_a();
        String string = bdc2.java_lang_String_d();
        while (string != null) {
            bfz bfz2;
            bdf bdf2 = bdc2.bdf_a();
            if (bdf2 == null) {
                bdf2 = bdf.var_bdf_a;
            }
            switch (bdf2.int_a()) {
                case 1: {
                    bfz2 = this.bpt_a(bdc2, bfs2, bpo2);
                    break;
                }
                case 3: {
                    bfz2 = this.bpd_a(bdc2, bfs2, bpo2);
                    break;
                }
                case 12: {
                    bfz2 = this.d(bdc2, bfs2, bpo2);
                    break;
                }
                case 6: {
                    bfz2 = bpo2.a(bdc2.java_lang_String_e());
                    break;
                }
                case 7: {
                    bfz2 = this.bfz_b(bdc2, bfs2, bpo2);
                    break;
                }
                case 9: {
                    bfz2 = bpo2.a(true);
                    break;
                }
                case 10: {
                    bfz2 = bpo2.a(false);
                    break;
                }
                case 11: {
                    bfz2 = bpo2.bpr_a();
                    break;
                }
                default: {
                    bfz2 = this.bfz_a(bdc2, bfs2, bpo2);
                }
            }
            bfz bfz3 = bpt2.b(string, bfz2);
            if (bfz3 != null) {
                this.a(bdc2, bfs2, bpo2, string, bpt2, bfz3, bfz2);
            }
            string = bdc2.java_lang_String_a();
        }
        return bpt2;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Override
    protected final bfz a(bdc var1_1, bfs var2_2, bpt var3_3) {
        if (var1_1.boolean_d()) {
            var4_4 = var1_1.java_lang_String_a();
        } else {
            if (!var1_1.boolean_a(bdf.f)) {
                return (bfz)this.a(var1_1, var2_2);
            }
            var4_4 = var1_1.java_lang_String_d();
        }
        while (var4_4 != null) {
            block20: {
                block19: {
                    var5_5 = var1_1.bdf_a();
                    var6_6 = var3_3.a(var4_4);
                    if (var6_6 == null) ** GOTO lbl-1000
                    if (!(var6_6 instanceof bpt)) break block19;
                    if (var5_5 != bdf.var_bdf_b) ** GOTO lbl-1000
                    var7_7 /* !! */  = this.a(var1_1, var2_2, (bpt)var6_6);
                    if (var7_7 /* !! */  != var6_6) {
                        var3_3.a(var4_4, var7_7 /* !! */ );
                    }
                    break block20;
                }
                if (var6_6 instanceof bpd && var5_5 == bdf.var_bdf_d) {
                    var7_7 /* !! */  = this.a(var1_1, var2_2, (bpd)var6_6);
                    if (var7_7 /* !! */  != var6_6) {
                        var3_3.a(var4_4, var7_7 /* !! */ );
                    }
                } else lbl-1000:
                // 3 sources

                {
                    if (var5_5 == null) {
                        var5_5 = bdf.var_bdf_a;
                    }
                    var8_8 = var2_2.bpo_a();
                    switch (var5_5.int_a()) {
                        case 1: {
                            var7_7 /* !! */  = this.bpt_a(var1_1, var2_2, var8_8);
                            break;
                        }
                        case 3: {
                            var7_7 /* !! */  = this.bpd_a(var1_1, var2_2, var8_8);
                            break;
                        }
                        case 12: {
                            var7_7 /* !! */  = this.d(var1_1, var2_2, var8_8);
                            break;
                        }
                        case 6: {
                            var7_7 /* !! */  = var8_8.a(var1_1.java_lang_String_e());
                            break;
                        }
                        case 7: {
                            var7_7 /* !! */  = this.bfz_b(var1_1, var2_2, var8_8);
                            break;
                        }
                        case 9: {
                            var7_7 /* !! */  = var8_8.a(true);
                            break;
                        }
                        case 10: {
                            var7_7 /* !! */  = var8_8.a(false);
                            break;
                        }
                        case 11: {
                            var7_7 /* !! */  = var8_8.bpr_a();
                            break;
                        }
                        default: {
                            var7_7 /* !! */  = this.bfz_a(var1_1, var2_2, var8_8);
                        }
                    }
                    var3_3.a(var4_4, var7_7 /* !! */ );
                }
            }
            var4_4 = var1_1.java_lang_String_a();
        }
        return var3_3;
    }

    @Override
    protected final bpd bpd_a(bdc bdc2, bfs bfs2, bpo bpo2) {
        bdf bdf2;
        bpd bpd2 = bpo2.bpd_a();
        block11: while ((bdf2 = bdc2.bdf_a()) != null) {
            switch (bdf2.int_a()) {
                case 1: {
                    bpd2.a(this.bpt_a(bdc2, bfs2, bpo2));
                    continue block11;
                }
                case 3: {
                    bpd2.a(this.bpd_a(bdc2, bfs2, bpo2));
                    continue block11;
                }
                case 4: {
                    return bpd2;
                }
                case 12: {
                    bpd2.a(this.d(bdc2, bfs2, bpo2));
                    continue block11;
                }
                case 6: {
                    bpd2.a(bpo2.a(bdc2.java_lang_String_e()));
                    continue block11;
                }
                case 7: {
                    bpd2.a(this.bfz_b(bdc2, bfs2, bpo2));
                    continue block11;
                }
                case 9: {
                    bpd2.a(bpo2.a(true));
                    continue block11;
                }
                case 10: {
                    bpd2.a(bpo2.a(false));
                    continue block11;
                }
                case 11: {
                    bpd2.a(bpo2.bpr_a());
                    continue block11;
                }
            }
            bpd2.a(this.bfz_a(bdc2, bfs2, bpo2));
        }
        return bpd2;
    }

    @Override
    protected final bfz a(bdc bdc2, bfs bfs2, bpd bpd2) {
        bpo bpo2 = bfs2.bpo_a();
        block11: while (true) {
            bdf bdf2 = bdc2.bdf_a();
            switch (bdf2.int_a()) {
                case 1: {
                    bpd2.a(this.bpt_a(bdc2, bfs2, bpo2));
                    continue block11;
                }
                case 3: {
                    bpd2.a(this.bpd_a(bdc2, bfs2, bpo2));
                    continue block11;
                }
                case 4: {
                    return bpd2;
                }
                case 12: {
                    bpd2.a(this.d(bdc2, bfs2, bpo2));
                    continue block11;
                }
                case 6: {
                    bpd2.a(bpo2.a(bdc2.java_lang_String_e()));
                    continue block11;
                }
                case 7: {
                    bpd2.a(this.bfz_b(bdc2, bfs2, bpo2));
                    continue block11;
                }
                case 9: {
                    bpd2.a(bpo2.a(true));
                    continue block11;
                }
                case 10: {
                    bpd2.a(bpo2.a(false));
                    continue block11;
                }
                case 11: {
                    bpd2.a(bpo2.bpr_a());
                    continue block11;
                }
            }
            bpd2.a(this.bfz_a(bdc2, bfs2, bpo2));
        }
    }

    @Override
    protected final bfz bfz_a(bdc bdc2, bfs bfs2, bpo bpo2) {
        switch (bdc2.int_a()) {
            case 2: {
                return bpo2.bpt_a();
            }
            case 5: {
                return this.bpt_b(bdc2, bfs2, bpo2);
            }
            case 12: {
                return this.d(bdc2, bfs2, bpo2);
            }
            case 6: {
                return bpo2.a(bdc2.java_lang_String_e());
            }
            case 7: {
                return this.bfz_b(bdc2, bfs2, bpo2);
            }
            case 8: {
                return this.c(bdc2, bfs2, bpo2);
            }
            case 9: {
                return bpo2.a(true);
            }
            case 10: {
                return bpo2.a(false);
            }
            case 11: {
                return bpo2.bpr_a();
            }
        }
        return (bfz)bfs2.a(this.a(), bdc2);
    }

    protected final bfz bfz_b(bdc bdc2, bfs bfs2, bpo bpo2) {
        int n2 = bfs2.int_a();
        bdc.b b2 = (n2 & b) != 0 ? (bfu.b.a(n2) ? bdc.b.c : (bfu.c.a(n2) ? bdc.b.b : bdc2.bdc$b_a())) : bdc2.bdc$b_a();
        if (b2 == bdc.b.var_bdc$b_a) {
            return bpo2.a(bdc2.int_e());
        }
        if (b2 == bdc.b.b) {
            return bpo2.a(bdc2.long_a());
        }
        return bpo2.a((BigInteger)bdc2.java_lang_Number_a());
    }

    protected final bfz c(bdc bdc2, bfs bfs2, bpo bpo2) {
        bdc.b b2 = bdc2.bdc$b_a();
        if (b2 == bdc.b.f) {
            return bpo2.a((BigDecimal)bdc2.java_lang_Number_a());
        }
        if (bfs2.a(bfu.var_bfu_a)) {
            if (bdc2.boolean_f()) {
                return bpo2.a(bdc2.double_a());
            }
            return bpo2.a((BigDecimal)bdc2.java_lang_Number_a());
        }
        if (b2 == bdc.b.d) {
            return bpo2.a(bdc2.float_a());
        }
        return bpo2.a(bdc2.double_a());
    }

    protected final bfz d(bdc bdc2, bfs bfs2, bpo bpo2) {
        Object object = bdc2.java_lang_Object_a();
        if (object == null) {
            return bpo2.bpr_a();
        }
        Class<?> clazz = object.getClass();
        if (clazz == byte[].class) {
            return bpo2.a((byte[])object);
        }
        if (object instanceof bva) {
            return bpo2.a((bva)object);
        }
        if (object instanceof bfz) {
            return (bfz)object;
        }
        return bpo2.a(object);
    }
}

