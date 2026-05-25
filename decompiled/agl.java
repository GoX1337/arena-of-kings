/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.GameType;

public class agl
extends axm {
    public agl(Engine engine, ayl ayl2) {
        super(engine, ayl2);
        Engine.a("new PlayAssetDependencies()");
    }

    @Override
    public void a(ayl ayl2) {
        this.void_a(ajw.e);
        this.void_a(ajw.c);
        this.void_a(ajw.jd);
        this.void_a(ajw.jl);
        this.void_a(ajw.jm);
        this.void_a(ajw.kM);
        this.void_a(ajw.kN);
        this.void_a(ajw.jl);
        this.void_a(ajw.jm);
        this.void_a(ajw.lc);
        this.void_a(ajw.jZ);
        this.void_a(ajw.ka);
        this.void_a(ajw.kb);
        this.void_a(ajw.kc);
        this.void_a(ajw.kd);
        this.void_a(ajw.ke);
        this.void_a(ajw.kf);
        this.void_a(ajw.kg);
        this.void_a(ajw.kh);
        this.void_a(ajw.ki);
        this.void_a(ajw.kj);
        this.void_a(ajw.kl);
        this.void_a(ajw.km);
        this.void_a(ajw.kn);
        this.void_a(ajw.kk);
        this.void_a(ajw.ko);
        this.void_a(ajw.kp);
        this.void_a(ajw.jS);
        this.void_a(ajw.jT);
        this.void_a(ajw.jY);
        this.void_a(ajw.iX);
        this.void_a(ajw.iY);
        this.void_a(ajw.iZ);
        this.void_a(ajw.ja);
        this.void_a(ajw.jb);
        this.void_a(ajw.kq);
        this.void_a(ajw.kr);
        this.void_a(ajw.ks);
        this.void_a(ajw.hM);
        this.void_a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().abi_a().getScreenDependency());
        this.void_a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().abi_b().getScreenDependency());
        this.void_a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().abi_c().getScreenDependency());
        this.void_a(ajw.jy);
        this.void_a(ajw.iW);
        this.void_a(ajw.jc);
        this.void_a(ajw.jf);
        this.void_a(ajw.jg);
        this.void_a(ajw.jh);
        this.void_a(ajw.ji);
        this.void_a(ajw.jj);
        this.void_a(ajw.jk);
        this.void_a(ajw.je);
        this.void_a(ajw.i);
        this.void_a(ajw.kB);
        this.void_a(ajw.iU);
        this.void_a(ajw.iV);
        this.void_a(ajw.kD);
        this.void_a(ajw.kE);
        this.void_a(ajw.la);
        this.void_a(ajw.lb);
        this.void_a(ajw.kY);
        this.void_a(ajw.kX);
        this.void_a(ajw.kW);
        this.void_a(ajw.ky);
        this.void_a(ajw.jU);
        this.void_a(ajw.jV);
        this.void_a(ajw.jW);
        this.void_a(ajw.ld);
        this.void_a(ajw.le);
    }

    @Override
    public void b(ayl ayl2) {
        Engine.a("enemy size: " + ay.ay_a().ge_a().a().size());
        switch (((agp)ayl2).com_arenaofkings_packets_misc_ArenaName_a()) {
            case DARK: {
                this.void_a(ajw.p);
                this.void_a(ajw.o);
                if (((agp)ayl2).boolean_b()) {
                    this.void_a(ajw.n);
                } else {
                    this.void_a(ajw.m);
                }
                this.void_a(ajw.kP);
                this.void_a(ajw.jn);
                break;
            }
            case DESERT: {
                this.void_a(ajw.t);
                this.void_a(ajw.s);
                if (((agp)ayl2).boolean_b()) {
                    this.void_a(ajw.r);
                } else {
                    this.void_a(ajw.q);
                }
                this.void_a(ajw.kU);
                break;
            }
            case FOREST: {
                this.void_a(ajw.x);
                this.void_a(ajw.w);
                if (((agp)ayl2).boolean_b()) {
                    this.void_a(ajw.v);
                } else {
                    this.void_a(ajw.u);
                }
                this.void_a(ajw.kT);
                break;
            }
            case INDOOR: {
                this.void_a(ajw.B);
                this.void_a(ajw.A);
                if (((agp)ayl2).boolean_b()) {
                    this.void_a(ajw.z);
                } else {
                    this.void_a(ajw.y);
                }
                this.void_a(ajw.kV);
                this.void_a(ajw.jy);
                this.void_a(ajw.jA);
                break;
            }
            case SNOWY: {
                this.void_a(ajw.l);
                this.void_a(ajw.k);
                this.void_a(ajw.j);
                this.void_a(ajw.kR);
                this.void_a(ajw.ar);
                this.void_a(ajw.h);
                this.void_a(ajw.jp);
                this.void_a(ajw.jx);
                break;
            }
            default: {
                this.void_a(ajw.p);
                this.void_a(ajw.o);
                this.void_a(ajw.m);
                this.void_a(ajw.kP);
            }
        }
        if (ay.ay_a().gd_a().com_arenaofkings_packets_misc_GameType_a() == GameType.TUTORIAL_DPS || ay.ay_a().gd_a().com_arenaofkings_packets_misc_GameType_a() == GameType.TUTORIAL_HEALER) {
            this.void_a(ajw.kt);
        }
        if (ay.ay_a().gd_a().com_arenaofkings_packets_misc_GameType_a() == GameType.DARK_BOSS_BATTLE) {
            this.void_a(ajw.eo);
            this.void_a(ajw.ep);
            this.void_a(ajw.dT);
            this.void_a(ajw.dU);
            this.void_a(ajw.hM);
        }
        for (br object : ay.ay_a().gf_a().a().values()) {
            for (ajw ajw2 : object.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().a()) {
                this.void_a(ajw2);
            }
        }
        for (br br2 : ay.ay_a().ge_a().a().values()) {
            for (ajw ajw2 : br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().a()) {
                this.void_a(ajw2);
            }
        }
        for (ajw ajw3 : this.a.var_hg_a.a()) {
            this.void_a(ajw3);
        }
        if (this.a().contains(ajw.ip, true) || this.a().contains(ajw.cfr_renamed_6, true) || this.a().contains(ajw.it, true) || this.a().contains(ajw.iy, true)) {
            if (!this.a().contains(ajw.ih, true)) {
                this.void_a(ajw.ih);
            }
            if (!this.a().contains(ajw.iv, true)) {
                this.void_a(ajw.iv);
            }
        }
        if (this.a().contains(ajw.fT, true) && !this.a().contains(ajw.dT, true)) {
            this.void_a(ajw.dT);
        }
        if (this.a().contains(ajw.gW, true)) {
            if (!this.a().contains(ajw.ih, true)) {
                this.void_a(ajw.ih);
            }
            if (!this.a().contains(ajw.iv, true)) {
                this.void_a(ajw.iv);
            }
        }
        if (this.a().contains(ajw.hk, true)) {
            if (!this.a().contains(ajw.db, true)) {
                this.void_a(ajw.db);
            }
            if (!this.a().contains(ajw.dc, true)) {
                this.void_a(ajw.dc);
            }
        }
        if (this.a().contains(ajw.cy, true) && !this.a().contains(ajw.cA, true)) {
            this.void_a(ajw.cA);
        }
        if (this.a().contains(ajw.cL, true) && !this.a().contains(ajw.cN, true)) {
            this.void_a(ajw.cN);
        }
        if (this.a().contains(ajw.cn, true) && !this.a().contains(ajw.ey, true)) {
            this.void_a(ajw.ey);
            this.void_a(ajw.ez);
        }
        if (this.a().contains(ajw.bZ, true)) {
            this.void_a(ajw.bP);
        }
        if (this.a().contains(ajw.V, true)) {
            if (!this.a().contains(ajw.cY, true)) {
                this.void_a(ajw.cY);
            }
            if (!this.a().contains(ajw.da, true)) {
                this.void_a(ajw.da);
            }
            if (!this.a().contains(ajw.cZ, true)) {
                this.void_a(ajw.cZ);
            }
            if (!this.a().contains(ajw.hw, true)) {
                this.void_a(ajw.hw);
            }
        }
        if (this.a().contains(ajw.co, true)) {
            this.void_a(ajw.cC);
        }
        this.void_a(ajw.bt);
        this.void_a(ajw.bu);
        this.void_a(ajw.bv);
        this.void_a(ajw.ic);
        this.void_a(ajw.bG);
        this.void_a(ajw.bH);
        this.void_a(ajw.bw);
        this.void_a(ajw.bx);
        this.void_a(ajw.by);
        this.void_a(ajw.bz);
        this.void_a(ajw.bA);
        this.void_a(ajw.bB);
        this.void_a(ajw.bC);
        this.void_a(ajw.bD);
        this.void_a(ajw.bE);
        this.void_a(ajw.bF);
    }
}

