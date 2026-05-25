/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.linux;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.Immutable;
import oshi.hardware.SoundCard;
import oshi.hardware.common.AbstractSoundCard;
import oshi.util.FileUtil;
import oshi.util.platform.linux.ProcPath;

@Immutable
final class LinuxSoundCard
extends AbstractSoundCard {
    private static final Logger LOG = LoggerFactory.getLogger(LinuxSoundCard.class);
    private static final String CARD_FOLDER = "card";
    private static final String CARDS_FILE = "cards";
    private static final String ID_FILE = "id";

    LinuxSoundCard(String string, String string2, String string3) {
        super(string, string2, string3);
    }

    private static List<File> getCardFolders() {
        File file = new File(ProcPath.ASOUND);
        ArrayList<File> arrayList = new ArrayList<File>();
        File[] fileArray = file.listFiles();
        if (fileArray != null) {
            for (File file2 : fileArray) {
                if (!file2.getName().startsWith(CARD_FOLDER) || !file2.isDirectory()) continue;
                arrayList.add(file2);
            }
        } else {
            LOG.warn("No Audio Cards Found");
        }
        return arrayList;
    }

    private static String getSoundCardVersion() {
        String string = FileUtil.getStringFromFile(ProcPath.ASOUND + "version");
        return string.isEmpty() ? "not available" : string;
    }

    private static String getCardCodec(File file) {
        String string = "";
        File[] fileArray = file.listFiles();
        if (fileArray != null) {
            block0: for (File file2 : fileArray) {
                if (!file2.getName().startsWith("codec")) continue;
                if (!file2.isDirectory()) {
                    string = FileUtil.getKeyValueMapFromFile(file2.getPath(), ":").get("Codec");
                    continue;
                }
                File[] fileArray2 = file2.listFiles();
                if (fileArray2 == null) continue;
                for (File file3 : fileArray2) {
                    if (file3.isDirectory() || !file3.getName().contains("#")) continue;
                    string = file3.getName().substring(0, file3.getName().indexOf(35));
                    continue block0;
                }
            }
        }
        return string;
    }

    private static String getCardName(File file) {
        String string = "Not Found..";
        Map<String, String> map = FileUtil.getKeyValueMapFromFile(ProcPath.ASOUND + "/" + CARDS_FILE, ":");
        String string2 = FileUtil.getStringFromFile(file.getPath() + "/" + ID_FILE);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!entry.getKey().contains(string2)) continue;
            string = entry.getValue();
            return string;
        }
        return string;
    }

    public static List<SoundCard> getSoundCards() {
        ArrayList<SoundCard> arrayList = new ArrayList<SoundCard>();
        for (File file : LinuxSoundCard.getCardFolders()) {
            arrayList.add(new LinuxSoundCard(LinuxSoundCard.getSoundCardVersion(), LinuxSoundCard.getCardName(file), LinuxSoundCard.getCardCodec(file)));
        }
        return arrayList;
    }
}

